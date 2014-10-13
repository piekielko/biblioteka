package pl.altkom.biblioteka.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.altkom.biblioteka.model.Ksiazka;


public class BibliotekaDaoMemory implements BibliotekaDao {

	private List<Ksiazka> dane;
	
	
	
	public BibliotekaDaoMemory() {
		dane = new ArrayList();
	}

	@Override
	public synchronized void addKsiazka(Ksiazka k) {
		// TODO Auto-generated method stub
		Ksiazka tmp = null;
		if (dane.size() != 0) {
			tmp = dane.get(dane.size()-1);
			k.setId(tmp.getId()+1);
			dane.add(k);
		} else {
			dane.add(k);
		}
	}

	@Override
	public synchronized void updateKsiazka(Ksiazka k) {
		// TODO Auto-generated method stub
		dane.set((int)k.getId(), k);
	}

	@Override
	public synchronized Ksiazka getKsiazka(long id) {
		// TODO Auto-generated method stub
		return dane.get((int)id);
	}

	@Override
	public synchronized void removeKsiazka(long id) {
		// TODO Auto-generated method stub
		dane.remove((int)id);
	}

	@Override
	public synchronized List<Ksiazka> getAllSortedKsiazka(int atrybut, String s) {
		// TODO Auto-generated method stub
		return dane;
	}

	@Override
	public void setSort(int sort) {
		// TODO Auto-generated method stub
		
	}

}
