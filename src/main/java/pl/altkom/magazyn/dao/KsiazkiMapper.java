package pl.altkom.magazyn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.altkom.magazyn.model.Ksiazki;

public class KsiazkiMapper implements RowMapper<Ksiazki> {
	public Ksiazki mapRow(ResultSet row, int rowNum) throws SQLException {
		Ksiazki towar = new Ksiazki();
		towar.setId(row.getLong("ID"));
		towar.setTytul(row.getString("tytul"));
		towar.setOpis(row.getString("opis"));
		towar.setAutorzy(row.getString("autorzy"));
		towar.setIlosc(row.getInt("ilosc"));
		towar.setKategoria(row.getString("kategoria"));
		return towar;
	}
}
