package ca.ubc.cpsc210.estates.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Neighbourhood implements Iterable<House>{

	private List<House> houses = new ArrayList<>();

	public void addHouse(House house) {
		this.houses.add(house);
	}


    @Override
    public Iterator<House> iterator() {
        return houses.iterator();
    }
}
