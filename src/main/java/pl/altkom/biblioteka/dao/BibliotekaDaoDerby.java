package pl.altkom.biblioteka.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.altkom.biblioteka.model.ComparatorByNazwiskoAutora;
import pl.altkom.biblioteka.model.ComparatorByKat;
import pl.altkom.biblioteka.model.ComparatorByTytul;
import pl.altkom.biblioteka.model.ComparatorByOpis;
import pl.altkom.biblioteka.model.ComparatorByIlosc;
import pl.altkom.biblioteka.model.Ksiazka;

@Repository
public class BibliotekaDaoDerby implements BibliotekaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private int sort = 0;

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public void addKsiazka(Ksiazka k) {
		// TODO Auto-generated method stub

		try {
			String sql = "INSERT INTO ksiazki(tytul,opis,imieAutora,nazwiskoAutora,pochodzenieAutora,ilosc,kategoria) values(?,?,?,?,?,?,?)";
			// String sql1 =
			// "select id FROM ksiazki order by id desc FETCH FIRST ROW ONLY;";

			// jdbcTemplate.execute(sql1);
			jdbcTemplate.update(sql, new Object[] { k.getTytul(), k.getOpis(),
					k.getImieAutora(), k.getNazwiskoAutora(), k.getPochodzenieAutora(), k.getIlosc(), k.getKategoria() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void updateKsiazka(Ksiazka k) {
		String SQL = "update ksiazki set tytul = ?, opis = ?, imieAutora = ?, nazwiskoautora = ?, pochodzenieAutora = ?, ilosc = ?, kategoria = ? where id = ?";
		jdbcTemplate.update(SQL, k.getTytul(), k.getOpis(), k.getImieAutora(), k.getNazwiskoAutora(), k.getPochodzenieAutora(),
				k.getIlosc(), k.getKategoria(), k.getId());
		return;
	}

	@Override
	public Ksiazka getKsiazka(long id) {
		String SQL = "select * from ksiazki where id = ?";
		Ksiazka ksiazka = jdbcTemplate.queryForObject(SQL, new Object[] { id },
				new KsiazkaMapper());
		return ksiazka;
	}

	@Override
	public void removeKsiazka(long id) {
		String SQL = "delete from ksiazki where id = ?";
		jdbcTemplate.update(SQL, id);
	}

	@Override
	public List<Ksiazka> getAllSortedKsiazka(int atrybut, String s) {
		String sql = "select * FROM ksiazki";
		List<Ksiazka> ksiazki = jdbcTemplate.query(sql, new KsiazkaMapper());
		List<Ksiazka> tmp = new ArrayList();
		if (atrybut != 0) {
			if (atrybut == 1)
				for (int i = 0; i < ksiazki.size(); i++)
					if (ksiazki.get(i).getTytul().matches(s))
						tmp.add(ksiazki.get(i));
			if (atrybut == 2)
				for (int i = 0; i < ksiazki.size(); i++)
					if (ksiazki.get(i).getOpis().matches(s))
						tmp.add(ksiazki.get(i));
			if (atrybut == 5)
				for (int i = 0; i < ksiazki.size(); i++)
					if (ksiazki.get(i).getKategoria().matches(s))
						tmp.add(ksiazki.get(i));
			ksiazki = tmp;
		}

		if (sort == 1)
			Collections.sort(ksiazki, new ComparatorByTytul());
                if (sort == 2)
			Collections.sort(ksiazki, new ComparatorByOpis());
		if (sort == 3)
			Collections.sort(ksiazki, new ComparatorByNazwiskoAutora());
                if (sort == 4)
			Collections.sort(ksiazki, new ComparatorByIlosc());
		if (sort == 5)
			Collections.sort(ksiazki, new ComparatorByKat());
                

		return ksiazki;
	}

}
