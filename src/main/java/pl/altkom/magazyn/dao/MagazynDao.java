package pl.altkom.magazyn.dao;

import java.util.List;
import pl.altkom.magazyn.model.Ksiazki;

public interface MagazynDao {

	public void addTowar(Ksiazki t);

	public void updateTowar(Ksiazki t);

	public Ksiazki getTowar(long id);

	public void removeTowar(long id);

	public List<Ksiazki> getAllSortedTowar(int atrybut, String s);
	
	public void setSort(int sort);

}
