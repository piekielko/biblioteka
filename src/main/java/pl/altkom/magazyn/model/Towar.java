package pl.altkom.magazyn.model;

import java.io.Serializable;

public class Towar implements Serializable {

	private long id;
	private String nazwa;
	private String opis;
	private double cena;
	private int ilosc;
	private String kategoria;

	public Towar(long id, String nazwa, String opis, double cena, int ilosc,
			String kategoria) {
		this.id = id;
		this.nazwa = nazwa;
		this.opis = opis;
		this.cena = cena;
		this.ilosc = ilosc;
		this.kategoria = kategoria;
	}

	public Towar() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

}
