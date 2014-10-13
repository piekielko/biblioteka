package pl.altkom.biblioteka.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.altkom.biblioteka.model.Ksiazka;

public class KsiazkaMapper implements RowMapper<Ksiazka> {
	public Ksiazka mapRow(ResultSet row, int rowNum) throws SQLException {
		Ksiazka ksiazka = new Ksiazka();
		ksiazka.setId(row.getLong("ID"));
		ksiazka.setTytul(row.getString("tytul"));
		ksiazka.setOpis(row.getString("opis"));
		ksiazka.setImieAutora(row.getString("imieAutora"));
                ksiazka.setNazwiskoAutora(row.getString("nazwiskoAutora"));
                ksiazka.setPochodzenieAutora(row.getString("pochodzenieAutora"));
		ksiazka.setIlosc(row.getInt("ilosc"));
		ksiazka.setKategoria(row.getString("kategoria"));
		return ksiazka;
	}
}
