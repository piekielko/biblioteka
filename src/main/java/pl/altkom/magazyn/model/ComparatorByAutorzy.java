package pl.altkom.magazyn.model;

import java.util.Comparator;

public class ComparatorByAutorzy implements Comparator<Ksiazki> {

    @Override
    public int compare(Ksiazki o1, Ksiazki o2) {
        String cen1 = new String(o1.getAutorzy());
        String cen2 = new String(o2.getAutorzy());

        return cen1.compareTo(cen2);
    }

}
