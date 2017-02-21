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
	
	public void correctAllocation(ShipsField shipsField) {
		while (!(shipsField.getShips().size() == 10)) {
			long start = System.currentTimeMillis();
			System.out.println("AA : " + (start));
		do {
			
			allocetShip(shipsField);
//			return;	
		}	while (start < start + 5);
//		Thread.currentThread().interrupt();
		System.out.println("AA : " + (start));
	}
		shipsField.showFields();
 }
}