package seebattle;

public class Setships {
	Ship ship;
	Shipsfield shipsfield;

	public void setShip4ForTest(Shipsfield shipsfield) {
		// set 4
		Coordinate c = new Coordinate();

		ship = new Ship();
		c.setC(1, 0);
		for (int i = 1; i < 5; i++) {
			c = c.nextInColm();
			ship.addToBlocks(c);
			shipsfield.removeFromEmptyFields(c);
		}
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
	}

	// set 3
	// I - 3
	public void setShip3ForTest(Shipsfield shipsfield) {
		Coordinate c = new Coordinate();

		ship = new Ship();
		c = new Coordinate(7, 6);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		c = new Coordinate(7, 7);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		c = new Coordinate(7, 8);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
		// II - 3
		ship = new Ship();
		c = new Coordinate(3, 6);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		c = new Coordinate(4, 6);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		c = new Coordinate(5, 6);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
	}
	//
	// set 2
	// I - 2

	public void setShip2ForTest(Shipsfield shipsfield) {
		Coordinate c = new Coordinate();

		ship = new Ship();
		c = new Coordinate(3, 2);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		c = new Coordinate(3, 3);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		// II - 2
		ship = new Ship();
		c = new Coordinate(6, 1);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		c = new Coordinate(6, 2);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		// III - 2
		ship = new Ship();
		c = new Coordinate(2, 8);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		c = new Coordinate(3, 8);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
	}
	// set 1

	public void setShip1ForTest(Shipsfield shipsfield) {
		Coordinate c = new Coordinate();

		ship = new Ship();
		c = new Coordinate(8, 1);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		ship = new Ship();
		c = new Coordinate(5, 4);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		ship = new Ship();
		c = new Coordinate(7, 4);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		shipsfield.addToListShips(new Ship(ship.getBlocks()));

		ship = new Ship();
		c = new Coordinate(5, 8);
		ship.addToBlocks(c);
		shipsfield.removeFromEmptyFields(c);
		shipsfield.addToListShips(new Ship(ship.getBlocks()));
	}
}