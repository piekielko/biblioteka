package pl.altkom.magazyn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.altkom.magazyn.model.Towar;

public class TowarMapper implements RowMapper<Towar> {
	public Towar mapRow(ResultSet row, int rowNum) throws SQLException {
		Towar towar = new Towar();
		towar.setId(row.getLong("ID"));
		towar.setNazwa(row.getString("nazwa"));
		towar.setOpis(row.getString("opis"));
		towar.setCena(row.getDouble("cena"));
		towar.setIlosc(row.getInt("ilosc"));
		towar.setKategoria(row.getString("kategoria"));
		return towar;
	}
}
