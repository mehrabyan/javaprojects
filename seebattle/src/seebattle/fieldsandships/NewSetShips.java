package seebattle.fieldsandships;

import java.util.*;

public class NewSetShips {
	ShipsField shipsField;
	private int[] motor = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };
	Random rddir = new Random();

	public void SetShips(ShipsField shipsField) {
		for (int mot : motor) {
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
