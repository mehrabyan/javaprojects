package seebattle.fieldsandships;

import java.util.*;

public class SetShips {
	ShipsField shipsField;
	private int[] motor = {3, 3, 2, 2, 2};
	Random rddir = new Random();
	
	public void locateBigShips(ShipsField shipsField) {
		int dir = rddir.nextInt(2);
		switch (dir) {
		case (0):
			shipsField.set4MotShipH(4);
			break;
		case (1):
			shipsField.set4MotShipV(4);
			break;
		}
		for (int mot : motor) {
		
			int dir1 = rddir.nextInt(2);
			switch (dir1) {
			case (0):
				shipsField.setShipH(mot);
				break;
			case (1):
				shipsField.setShipV(mot);
				break;
			}
		}
	}

	public void locate1MotShips(ShipsField shipsField) { // try direct,without locate1MotShips
		for (int i = 0; i < 4; i++) {
			shipsField.set1MotShip();
		}
	}
	
	public void PlaceFor1MotShips(ShipsField shipsField) {
		System.out.println("Find place for 1 mot ships");
		while (shipsField.unmarkedCellsNumber() < 13) {
			shipsField.getEmptyFields().removeAll(shipsField.getEmptyFields());
			shipsField.getShips().removeAll(shipsField.getShips());
			Coordinate c;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					c = new Coordinate(i, j);
					c.setMarker('u');
					shipsField.getEmptyFields().add(c);
				}
			}
			System.out.println("Relocate big ships");
			locateBigShips(shipsField);
			System.out.println("Relocate big ships 2");
		}
	}
	
	public void correctDislocation(ShipsField shipsField) {
		System.out.println("Start big ships location");
		locateBigShips(shipsField);
		System.out.println("befor placefor1mot");
		PlaceFor1MotShips(shipsField);
		System.out.println("The big ships location is O'K");
		shipsField.showFields();
		System.out.println("There is enough place for 1 mot ships :");
		System.out.println(shipsField.unmarkedCellsNumber());
//		locate1MotShips(shipsField);
		for (int i = 0; i < 4; i++) {
			shipsField.set1MotShip();
			System.out.println("Locate " + (i +1)  + " ship");
		}
		shipsField.showFields();
	}
}