package seebattle.fieldsandships;

public class SetShips {
	Ship ship;
	ShipsField shipsfield;

	public void setShip4ForTest(ShipsField shipsfield) {
		// set 4
		ship = new Ship();
		ship.addToBlocks(new Coordinate(1, 1));
		ship.addToBlocks(new Coordinate(1, 2));
		ship.addToBlocks(new Coordinate(1, 3));
		ship.addToBlocks(new Coordinate(1, 4));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
	}

	// set 3
	// I - 3
	public void setShip3ForTest(ShipsField shipsfield) {
		ship = new Ship();
		ship.addToBlocks(new Coordinate(7, 6));
		ship.addToBlocks(new Coordinate(7, 7));
		ship.addToBlocks(new Coordinate(7, 8));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
		// II - 3
		ship = new Ship();
		ship.addToBlocks(new Coordinate(3, 6));
		ship.addToBlocks(new Coordinate(4, 6));
		ship.addToBlocks(new Coordinate(5, 6));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
	}
	//
	// set 2
	// I - 2

	public void setShip2ForTest(ShipsField shipsfield) {
		ship = new Ship();
		ship.addToBlocks(new Coordinate(3, 2));
		ship.addToBlocks(new Coordinate(3, 3));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		// II - 2
		ship = new Ship();
		ship.addToBlocks(new Coordinate(6, 1));
		ship.addToBlocks(new Coordinate(6, 2));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		// III - 2
		ship = new Ship();
		ship.addToBlocks(new Coordinate(2, 8));
		ship.addToBlocks(new Coordinate(3, 8));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
	}
	// set 1

	public void setShip1ForTest(ShipsField shipsfield) {
		ship = new Ship();
		ship.addToBlocks(new Coordinate(8, 1));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		ship = new Ship();
		ship.addToBlocks(new Coordinate(5, 4));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		ship = new Ship();
		ship.addToBlocks(new Coordinate(7, 4));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		ship = new Ship();
		ship.addToBlocks(new Coordinate(5, 8));
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
	}
}