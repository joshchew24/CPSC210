package ca.ubc.cpsc210.estates.model;

import java.util.Iterator;

public class Estate implements Iterable<House> {

	private House mainHouse;
	private House gateHouse;
	private House guestHouse;

	public void setMainHouse(House mainHouse) {
		this.mainHouse = mainHouse;
	}

	public void setGateHouse(House gateHouse) {
		this.gateHouse = gateHouse;
	}

	public void setGuestHouse(House guestHouse) {
		this.guestHouse = guestHouse;
	}

    @Override
    public Iterator<House> iterator() {
        return new EstateIterator();
    }

    private class EstateIterator implements Iterator<House> {

	    private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < 3;
        }

        @Override
        public House next() {
            switch(cursor) {
                case 0:
                    cursor++;
                    return mainHouse;
                case 1:
                    cursor++;
                    return gateHouse;
                default:
                    cursor++;
                    return guestHouse;
            }
        }
    }
}
