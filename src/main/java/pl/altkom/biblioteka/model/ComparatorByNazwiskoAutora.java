package pl.altkom.biblioteka.model;

import java.util.Comparator;

public class ComparatorByNazwiskoAutora implements Comparator<Ksiazka> {

    @Override
    public int compare(Ksiazka o1, Ksiazka o2) {
        String nazwisko1 = new String(o1.getNazwiskoAutora());
        String nazwisko2 = new String(o2.getNazwiskoAutora());

        return nazwisko1.compareTo(nazwisko2);
    }

}
