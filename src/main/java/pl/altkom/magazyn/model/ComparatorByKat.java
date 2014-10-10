package pl.altkom.magazyn.model;

import java.util.Comparator;

public class ComparatorByKat implements Comparator<Ksiazki> {

    @Override
    public int compare(Ksiazki o1, Ksiazki o2) {
        String kat1 = o1.getKategoria();
        String kat2 = o2.getKategoria();
        return kat1.compareToIgnoreCase(kat2);
    }

}
