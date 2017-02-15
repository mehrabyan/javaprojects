package seebattle.fieldsandships;

import java.util.*;

public class NewSetShips {
	ShipsField shipsField;
	private int[] motor = {4, 3, 3, 2, 2, 2,};
	Random rddir = new Random();
	
	public void allocetShip(ShipsField shipsField) {
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
		for (int i = 0; i < 4; i++) {
		shipsField.setShip1Mot();
		}
		shipsField.showFields();
	}
}