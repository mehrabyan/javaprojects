package seebattle.fieldsandships;

import java.util.*;

public class SetShips {
	ShipsField shipsField;
	private int[] motor = {4, 3, 3, 2, 2, 2,};
	Random rddir = new Random();
	
	public void locateBigShips(ShipsField shipsField) {
		for (int mot : motor) {
			int dir = rddir.nextInt(2);
			switch (dir) {
			case (0):
				shipsField.SetShipH(mot);
				break;
			case (1):
				shipsField.SetShipV(mot);
				break;
			}
		}
	}

	public void locate1MotShips(ShipsField shipsField) { // try direct,without locate1MotShips
		for (int i = 0; i < 4; i++) {
			shipsField.setShip1Mot();
		}
	}
	
	public void correctDislocation(ShipsField shipsField) {
		locateBigShips(shipsField);
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
			locateBigShips(shipsField);
		}
		locate1MotShips(shipsField);
		shipsField.showFields();
	}
}