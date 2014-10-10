package pl.altkom.magazyn.model;

import java.util.Comparator;

public class ComparatorByNazwa implements Comparator<Ksiazki> {

    @Override
    public int compare(Ksiazki o1, Ksiazki o2) {
        String naz1 = o1.getTytul();
        String naz2 = o2.getTytul();
        return naz1.compareToIgnoreCase(naz2);
    }

}
