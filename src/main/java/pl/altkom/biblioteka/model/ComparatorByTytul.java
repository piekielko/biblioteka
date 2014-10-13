package pl.altkom.biblioteka.model;

import java.util.Comparator;

public class ComparatorByTytul implements Comparator<Ksiazka> {

    @Override
    public int compare(Ksiazka o1, Ksiazka o2) {
        String naz1 = o1.getTytul();
        String naz2 = o2.getTytul();
        return naz1.compareToIgnoreCase(naz2);
    }

}
