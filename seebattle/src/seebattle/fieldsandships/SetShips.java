package seebattle.fieldsandships;

import java.util.*;

public class SetShips {
	ShipsField shipsField;
//	private int[] motor = {3, 3};
	Random rddir = new Random();
	
	public void locateBigShips(ShipsField shipsField) {
			shipsField.set4MotShip(4);
			shipsField.set3MotShip(3);
			
			shipsField.showFields();
			
			shipsField.set3MotShip(3);
			
			shipsField.showFields();
			
			shipsField.set2MotShip(2);
			
			shipsField.showFields();
			
			shipsField.set2MotShip(2);
			
			shipsField.showFields();
			
			shipsField.set2MotShip(2);
			
			shipsField.showFields();
			
		System.out.println("Unmarked cells number befor 1 mot ships set :" + shipsField.unmarkedCellsNumber());
		shipsField.showFields();	
	}


	public void PlaceFor1MotShips(ShipsField shipsField) {
		System.out.println();
		System.out.println("Find place for 1 mot ships");
		System.out.println();
		for (int k = 0; k < 4; k++) {
		if (shipsField.unmarkedCellsNumber() < 3 - k) {
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
		shipsField.set1MotShip(1);
		}
	}
	
	public void correctDislocation(ShipsField shipsField) {
		System.out.println("Start big ships location");
		locateBigShips(shipsField);
		PlaceFor1MotShips(shipsField);
		System.out.println("The big ships location is O'K");
		System.out.println("There is enough place for 1 mot ships :");
		System.out.println(shipsField.unmarkedCellsNumber());
//		for (int i = 0; i < 4; i++) {
//			shipsField.set1MotShip(1);
//			System.out.println("Locate " + (i +1)  + " ship");
//		}
		shipsField.showFields();
	}
}