package pl.altkom.biblioteka.model;

import java.util.Comparator;

public class ComparatorByIlosc implements Comparator<Ksiazka>  {
    
    @Override
    public int compare(Ksiazka o1, Ksiazka o2) {
        Double il1 = new Double(o1.getIlosc());
        Double il2 = new Double(o2.getIlosc());

        return il1.compareTo(il2);
    }

}
