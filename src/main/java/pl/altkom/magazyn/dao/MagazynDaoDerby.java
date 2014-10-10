package pl.altkom.magazyn.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.altkom.magazyn.model.ComparatorByAutorzy;
import pl.altkom.magazyn.model.ComparatorByKat;
import pl.altkom.magazyn.model.ComparatorByNazwa;
import pl.altkom.magazyn.model.Ksiazki;

@Repository
public class MagazynDaoDerby implements MagazynDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private int sort = 0;

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public void addTowar(Ksiazki t) {
		// TODO Auto-generated method stub

		try {
			String sql = "INSERT INTO towary(tytul,opis,cena,ilosc,kategoria) values(?,?,?,?,?)";
			// String sql1 =
			// "select id FROM towary order by id desc FETCH FIRST ROW ONLY;";

			// jdbcTemplate.execute(sql1);
			jdbcTemplate.update(sql, new Object[] { t.getTytul(), t.getOpis(),
					t.getAutorzy(), t.getIlosc(), t.getKategoria() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void updateTowar(Ksiazki t) {
		String SQL = "update towary set nazwa = ?, opis = ?, cena = ?, ilosc = ?, kategoria = ? where id = ?";
		jdbcTemplate.update(SQL, t.getTytul(), t.getOpis(), t.getAutorzy(),
				t.getIlosc(), t.getKategoria(), t.getId());
		return;
	}

	@Override
	public Ksiazki getTowar(long id) {
		String SQL = "select * from towary where id = ?";
		Ksiazki towar = jdbcTemplate.queryForObject(SQL, new Object[] { id },
				new KsiazkiMapper());
		return towar;
	}

	@Override
	public void removeTowar(long id) {
		String SQL = "delete from towary where id = ?";
		jdbcTemplate.update(SQL, id);
	}

	@Override
	public List<Ksiazki> getAllSortedTowar(int atrybut, String s) {
		String sql = "select * FROM towary";
		List<Ksiazki> towary = jdbcTemplate.query(sql, new KsiazkiMapper());
		List<Ksiazki> tmp = new ArrayList();
		if (atrybut != 0) {
			if (atrybut == 1)
				for (int i = 0; i < towary.size(); i++)
					if (towary.get(i).getTytul().matches(s))
						tmp.add(towary.get(i));
			if (atrybut == 2)
				for (int i = 0; i < towary.size(); i++)
					if (towary.get(i).getOpis().matches(s))
						tmp.add(towary.get(i));
			if (atrybut == 5)
				for (int i = 0; i < towary.size(); i++)
					if (towary.get(i).getKategoria().matches(s))
						tmp.add(towary.get(i));
			towary = tmp;
		}

		if (sort == 1)
			Collections.sort(towary, new ComparatorByNazwa());
		if (sort == 3)
			Collections.sort(towary, new ComparatorByAutorzy());
		if (sort == 5)
			Collections.sort(towary, new ComparatorByKat());

		return towary;
	}

}
