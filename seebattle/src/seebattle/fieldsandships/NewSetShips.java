package seebattle.fieldsandships;

import java.util.*;

public class NewSetShips {
	ShipsField shipsField;
	private int[] motor = {4, 3, 3, 2, 2, 2,};
	Random rddir = new Random();
	
//	public void initTempForShipsSet(ShipsField shipsField) {
//		Coordinate c;
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				c = new Coordinate(i, j);
//				c.setMarker('u');
//				shipsField.getTempForShipsSet().add(c);
//			}
//		}
//	}

	public void setShp(ShipsField shipsField) {
//		shipsField.SetShip4H();
		for (int mot : motor) {
			System.out.println("now set ship with " + mot + " motors");
//			int dir = rddir.nextInt(2);
//			switch (dir) {
//			case (0):
				shipsField.SetShipH(mot);
//				break;
//			case (1):
//				shipsField.SetShipV(mot);
//				break;
//			}
		}
		for (int i = 0; i < 4; i++) {
		shipsField.setShip1Mot();
		}
		shipsField.showFields();
	}
	
//	public void printShipEnvironment(ShipsField shipsField) {
//		System.out.println("okrujenie kor");
//		System.out.println(shipsField.getShipsEnvironment().toString());
//	}
}
//public boolean isValidPath(String[] path) throws Exception {
//	boolean isValid = true;
//	Node<String> currentNode = getRootNode();
//
//	if (currentNode == null)
//		throw new Exception("Root node can't be null");
//
//	for (String joint : path) {
//		currentNode = currentNode.getChildNode(Integer.parseInt(joint));
//
//		if (currentNode == null) {
//			isValid = false;
//			System.out.println("The path is not valid");
//			break;
//		}
//	}
//	return isValid;
//}
