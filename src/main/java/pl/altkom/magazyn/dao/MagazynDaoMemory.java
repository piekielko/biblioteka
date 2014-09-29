package pl.altkom.magazyn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.altkom.magazyn.model.Towar;

@Repository
public class MagazynDaoMemory implements MagazynDao {

	private List<Towar> dane;
	
	
	
	public MagazynDaoMemory() {
		dane = new ArrayList();
	}

	@Override
	public synchronized void addTowar(Towar t) {
		// TODO Auto-generated method stub
		Towar tmp = null;
		if (dane.size() != 0) {
			tmp = dane.get(dane.size()-1);
			t.setId(tmp.getId()+1);
			dane.add(t);
		} else {
			dane.add(t);
		}
	}

	@Override
	public synchronized void updateTowar(Towar t) {
		// TODO Auto-generated method stub
		dane.set((int)t.getId(), t);
	}

	@Override
	public synchronized Towar getTowar(long id) {
		// TODO Auto-generated method stub
		return dane.get((int)id);
	}

	@Override
	public synchronized void removeTowar(long id) {
		// TODO Auto-generated method stub
		dane.remove((int)id);
	}

	@Override
	public synchronized List<Towar> getAllSortedTowar(int atrybut, String s) {
		// TODO Auto-generated method stub
		return dane;
	}

	@Override
	public void setSort(int sort) {
		// TODO Auto-generated method stub
		
	}

}
