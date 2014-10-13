package pl.altkom.biblioteka.model;

import java.util.Comparator;

public class ComparatorByKat implements Comparator<Ksiazka> {

    @Override
    public int compare(Ksiazka o1, Ksiazka o2) {
        String kat1 = o1.getKategoria();
        String kat2 = o2.getKategoria();
        return kat1.compareToIgnoreCase(kat2);
    }

}
