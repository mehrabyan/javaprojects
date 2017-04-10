package allocation;

import seebattle.fieldsandships.ShipsField;

public class SetShips {
	public void correctLocation(ShipsField shipsField) {
		Locate locate = new Locate(shipsField); 
		System.out.println("Start big ships location");
		locate.locShip(new Mot4ShipPlace(shipsField), 4);
		locate.locShip(new Mot3ShipPlace(shipsField), 3);
		locate.locShip(new Mot3ShipPlace(shipsField), 3);
		locate.locShip(new Mot2ShipPlace(shipsField), 2);
		locate.locShip(new Mot2ShipPlace(shipsField), 2);
		locate.locShip(new Mot2ShipPlace(shipsField), 2);
		shipsField.setUnmarkedCells();
		System.out.println("The size of emptyField after 4, 3, and 2 mot ships location " + shipsField.getUnmarkedCells().size());
		System.out.println(shipsField.getUnmarkedCells().toString());
		locate.locShip(new Mot1ShipPlace(shipsField), 1);
		locate.locShip(new Mot1ShipPlace(shipsField), 1);
		locate.locShip(new Mot1ShipPlace(shipsField), 1);
		locate.locShip(new Mot1ShipPlace(shipsField), 1);
		System.out.println();
		System.out.println();
		shipsField.showFields();
	}
}