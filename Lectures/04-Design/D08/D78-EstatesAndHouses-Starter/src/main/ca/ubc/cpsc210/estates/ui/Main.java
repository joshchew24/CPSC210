package ca.ubc.cpsc210.estates.ui;

import ca.ubc.cpsc210.estates.model.Estate;
import ca.ubc.cpsc210.estates.model.House;
import ca.ubc.cpsc210.estates.model.Neighbourhood;

public class Main {

	public static void main(String[] args) {
		Estate estate = new Estate();
		estate.setGateHouse(new House("red", 600));
		estate.setGuestHouse(new House("blue", 1200));
		estate.setMainHouse(new House("grey", 3000));

		Neighbourhood neighbourhood = new Neighbourhood();
		neighbourhood.addHouse(new House("yellow",1000));
		neighbourhood.addHouse(new House("green",1100));
		neighbourhood.addHouse(new House("blue",900));

		for (House house : estate) {
			house.visit();
		}

		for (House house : neighbourhood) {
			house.visit();
		}

	}

}
