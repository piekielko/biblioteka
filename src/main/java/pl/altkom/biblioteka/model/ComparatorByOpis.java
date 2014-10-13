package pl.altkom.biblioteka.model;

import java.util.Comparator;

public class ComparatorByOpis implements Comparator<Ksiazka> {
    
    @Override
    public int compare(Ksiazka o1, Ksiazka o2) {
        String opi1 = o1.getOpis();
        String opi2 = o2.getOpis();
        return opi1.compareToIgnoreCase(opi2);
    }

}

