package pl.altkom.magazyn.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pl.altkom.magazyn.model.Towar;

@Repository
public class MagazynDaoDerby implements MagazynDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private int sort = 0;

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	@Override
	public void addTowar(Towar t) {
		// TODO Auto-generated method stub

		try {
			String sql = "INSERT INTO towary(nazwa,opis,cena,ilosc,kategoria) values(?,?,?,?,?)";
			// String sql1 =
			// "select id FROM towary order by id desc FETCH FIRST ROW ONLY;";

			// jdbcTemplate.execute(sql1);
			jdbcTemplate.update(sql, new Object[] { t.getNazwa(), t.getOpis(),
					t.getCena(), t.getIlosc(), t.getKategoria() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void updateTowar(Towar t) {
		String SQL = "update towary set nazwa = ?, opis = ?, cena = ?, ilosc = ?, kategoria = ? where id = ?";
		jdbcTemplate.update(SQL, t.getNazwa(), t.getOpis(), t.getCena(),
				t.getIlosc(), t.getKategoria(), t.getId());
		return;
	}

	@Override
	public Towar getTowar(long id) {
		String SQL = "select * from towary where id = ?";
		Towar towar = jdbcTemplate.queryForObject(SQL, new Object[] { id },
				new TowarMapper());
		return towar;
	}

	@Override
	public void removeTowar(long id) {
		String SQL = "delete from towary where id = ?";
		jdbcTemplate.update(SQL, id);
	}

	@Override
	public List<Towar> getAllSortedTowar(int atrybut, String s) {
		String sql = "select * FROM towary";
		List<Towar> towary = jdbcTemplate.query(sql, new TowarMapper());
		return towary;
	}

}
