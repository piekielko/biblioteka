package pl.altkom.biblioteka.dao;

import java.util.List;
import pl.altkom.biblioteka.model.Ksiazka;

public interface BibliotekaDao {

	public void addKsiazka(Ksiazka k);

	public void updateKsiazka(Ksiazka k);

	public Ksiazka getKsiazka(long id);

	public void removeKsiazka(long id);

	public List<Ksiazka> getAllSortedKsiazka(int atrybut, String s);
	
	public void setSort(int sort);

}
