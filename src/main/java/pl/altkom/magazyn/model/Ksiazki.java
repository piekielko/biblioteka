package pl.altkom.magazyn.model;

import java.io.Serializable;
import java.util.Comparator;

public class Ksiazki implements Serializable, Comparable {

    private long id;
    private String tytul;
    private String opis;
    private String autorzy;
    private int ilosc;
    private String kategoria;

    public Ksiazki(long id, String tytul, String opis, String autorzy, int ilosc,
            String kategoria) {
        this.id = id;
        this.tytul = tytul;
        this.opis = opis;
        this.autorzy = autorzy;
        this.ilosc = ilosc;
        this.kategoria = kategoria;
    }

    public Ksiazki() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getAutorzy() {
        return autorzy;
    }

    public void setAutorzy(String autorzy) {
        this.autorzy = autorzy;
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

    @Override
    public int compareTo(Object o) {
        return -1;
    }
}
