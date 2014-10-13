package pl.altkom.biblioteka.model;

import java.io.Serializable;
import java.util.Comparator;

public class Ksiazka implements Serializable, Comparable {

    private long id;
    private String tytul;
    private String opis;
    private String imieAutora;
    private String nazwiskoAutora;
    private String pochodzenieAutora;
    private int ilosc;
    private String kategoria;

    public Ksiazka(long id, String tytul, String opis, String imieAutora, String nazwiskoAutora, String pochodzenieAutora, int ilosc, String kategoria) {
        this.id = id;
        this.tytul = tytul;
        this.opis = opis;
        this.imieAutora = imieAutora;
        this.nazwiskoAutora = nazwiskoAutora;
        this.pochodzenieAutora = pochodzenieAutora;
        this.ilosc = ilosc;
        this.kategoria = kategoria;
    }

    public Ksiazka() {
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

    public String getImieAutora() {
        return imieAutora;
    }

    public void setImieAutora(String imieAutora) {
        this.imieAutora = imieAutora;
    }

    public String getNazwiskoAutora() {
        return nazwiskoAutora;
    }

    public void setNazwiskoAutora(String nazwiskoAutora) {
        this.nazwiskoAutora = nazwiskoAutora;
    }

    public String getPochodzenieAutora() {
        return pochodzenieAutora;
    }

    public void setPochodzenieAutora(String pochodzenieAutora) {
        this.pochodzenieAutora = pochodzenieAutora;
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
