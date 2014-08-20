package pl.altkom.magazyn.dao;

import java.util.ArrayList;
import java.util.List;

import pl.altkom.magazyn.model.Towar;

public class magazynDaoMemory implements magazynDao {

	private List<Towar> dane;
		
	public magazynDaoMemory() {
		dane = new ArrayList();
	}

	@Override
	public void addTowar(Towar t) {
		// TODO Auto-generated method stub
		if (dane.size() != 0) {
			t.setId(dane.size());
			dane.add(t);
		} else {
			dane.add(t);
		}
	}

	@Override
	public void updateTowar(Towar t) {
		// TODO Auto-generated method stub
		dane.set((int)t.getId(), t);
	}

	@Override
	public Towar getTowar(long id) {
		// TODO Auto-generated method stub
		return dane.get((int)id);
	}

	@Override
	public void removeTowar(long id) {
		// TODO Auto-generated method stub
		dane.remove((int)id);
	}

	@Override
	public List<Towar> getAllSortedTowar(int atrybut, String s) {
		// TODO Auto-generated method stub
		return dane;
	}

}
