package seebattle.fieldsandships;

import java.util.*;

public class ShipsField {
	Random rd1 = new Random();
	Coordinate c;
	private List<Ship> ships = new ArrayList<Ship>();
	// private Set<Coordinate> shipsEnvironment = new HashSet<Coordinate>();
	private List<Ship> deadShips = new ArrayList<Ship>();
	private List<Coordinate> emptyFields = new ArrayList<Coordinate>();
	private List<Coordinate> tempForShipsSet = new ArrayList<Coordinate>();
	// private List<Coordinate> cellEnvironment = new ArrayList<Coordinate>();
	// private Iterator<Coordinate> it = emptyFields.iterator();

	public ShipsField() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				emptyFields.add(new Coordinate(i, j));
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				c = new Coordinate(i, j);
				c.setMarker('u');
				tempForShipsSet.add(c);
			}
		}
	}

	// can coordinate tells as about his environment ?

	// public List<Coordinate> getCellEnvironment() {
	// return cellEnvironment;
	// }
	//
	// public void setCellEnvironment(Coordinate cell) {
	// if (cell.hasNextInColm() && cell.hasPreviuosInColm() &&
	// cell.hasNextInRow() && cell.hasPreviuosInRow()) {
	// cellEnvironment.add(cell.upperCornerLeft());
	// cellEnvironment.add(cell.previousInColm());
	// cellEnvironment.add(cell.upperCornerRight());
	// cellEnvironment.add(cell.lowerCornerLeft());
	// cellEnvironment.add(cell.nextInColm());
	// cellEnvironment.add(cell.lowerCornerRight());
	// cellEnvironment.add(cell.previousInRow());
	// cellEnvironment.add(cell.nextInRow());
	// cellEnvironment.add(cell);
	// }
	// }
	//
	// public void markCellEnvironment(Coordinate c) {
	// for (Coordinate coord : getCellEnvironment())
	// coord.setMarker('m');
	// }

	public List<Coordinate> getTempForShipsSet() {
		return tempForShipsSet;
	}

	public void setTempForShipsSet(List<Coordinate> tempForShipsSet) {
		this.tempForShipsSet = tempForShipsSet;
	}

	public Coordinate getCoordFromEmptyFields(int x, int y) {
		int index;
		c.setC(x, y);
		index = emptyFields.indexOf(c);
		return emptyFields.get(index);
	}

	public Coordinate getCoordByIndexFromTemp(int i) {
		return tempForShipsSet.get(i);
	}

	public Coordinate getCoordFromTemp(int x, int y) {
		int index = 0;
		c.setC(x, y);
		if (tempForShipsSet.contains(c))
			index = tempForShipsSet.indexOf(c);
		return tempForShipsSet.get(index);
	}

	public Coordinate getNextCoordInRowFromTemp(Coordinate c) {
		int index = 0;
		if (tempForShipsSet.contains(c))
			index = tempForShipsSet.indexOf(c);
		return tempForShipsSet.get(index + 1);
	}

	public Coordinate getPreviousCoordInRowFromTemp(Coordinate c) {
		int index = 0;
		if (tempForShipsSet.contains(c))
			index = tempForShipsSet.indexOf(c);
		return tempForShipsSet.get(index - 1);
	}

	public Coordinate getNextCoordInColmFromTemp(Coordinate c) {
		int index = 0;
		if (tempForShipsSet.contains(c))
			index = tempForShipsSet.indexOf(c);
		return tempForShipsSet.get(index + 10);
	}

	public Coordinate getPreviousCoordInColmFromTemp(Coordinate c) {
		int index = 0;
		if (tempForShipsSet.contains(c))
			index = tempForShipsSet.indexOf(c);
		return tempForShipsSet.get(index - 10);
	}

	public Coordinate getUpperLeftCoordFromTemp(Coordinate c) {
		int x = c.getX();
		int y = c.getY();
		return getCoordFromTemp(x - 1, y - 1);
	}

	public Coordinate getLowerRightCoordFromTemp(Coordinate c) {
		int x = c.getX();
		int y = c.getY();
		return getCoordFromTemp(x + 1, y + 1);
	}

	public List<Coordinate> getEmptyFields() {
		return emptyFields;
	}

	public ShotResult checkShot(Coordinate c) {
		// showEmptyFields();
		ShotResult res = null;
		if (emptyFields.contains(c))
			res = ShotResult.MISS;
		else {
			for (Ship ship : ships) {
				res = ship.processShot(c);
				switch (res) {
				case HIT:
					break;
				case DEAD:
					deadShips.add(ship);
					ships.remove(ship); // Can't be done this way. Need an
										// iterator
					break;
				default:
					break;
				}

				if (res.equals(ShotResult.HIT) || res.equals(ShotResult.DEAD))
					break;
			}
		}
		return res;
	}

	public void addToListShips(Ship ship) { // and remove from emptyFields
		ships.add(ship);
		for (Coordinate c : ship.getBlocks()) {
			emptyFields.remove(c);
		}
	}

	public void removeFromEmptyFields(Coordinate c) {
		emptyFields.remove(c);
	}

	public int checkListOfShips() {
		return ships.size();
	}

//	public Coordinate getCoordByIndexFromEmptyFields(int i) {
//		return emptyFields.get(i);
//	}

	public List<Ship> showHitShips() {
		List<Ship> hitShips = new ArrayList<Ship>();
		for (Ship ship : ships) {
			if (ship.getMotors() > ship.getSizeOfBlocks())
				hitShips.add(ship);
		}
		return hitShips;
	}

	public List<Ship> showDeadShips() {
		return deadShips;
	}

	@Override
	public String toString() {
		return " [ships=" + ships + "\n" + "]";
	}

	public List<Coordinate> showEmptyFields() {
		return emptyFields;
	}

	public void SetShip4H() {
		Ship ship = new Ship();
		ship.addToBlocks(new Coordinate(1, 1));
		ship.addToBlocks(new Coordinate(1, 2));
		ship.addToBlocks(new Coordinate(1, 3));
		ship.addToBlocks(new Coordinate(1, 4));
		ship.setMotors(4);
		setH_ShipsEnvironmentMarkers(ship);
		addToListShips(new Ship(ship.getBlocks()));
	}

	public void SetShipH(int mot) {
		Ship ship = new Ship();
		c = PlaceForShipH(mot);
		int x = c.getX();
		int y = c.getY();
		c = new Coordinate(x, y);		
		for (int k = 0; k < mot; k++) {
			ship.addToBlocks(c);
			c = c.nextInRow();
		}
		ship.setMotors(mot);
		// mark H_ship environment
		setH_ShipsEnvironmentMarkers(ship);
		addToListShips(new Ship(ship.getBlocks()));
		System.out.println(toString());
	}

	// public void SetShipV(int mot) {
	// Ship ship = new Ship();
	// c = ValidPlaseForShipV(mot);
	// c.setMarker('m');
	// Coordinate c1 = c;
	// ship.addToBlocks(c);
	// for (int k = 0; k < mot - 1; k++) {
	// if (c.getY() + mot - 1 <= 8) {
	// c1 = c1.nextInColm();
	// } else {
	// c1 = c1.previousInColm();
	// }
	// c1.setMarker('m');
	// ship.addToBlocks(c1);
	// }
	//
	// // mark ship environment V
	// ship.setMotors(mot);
	// setShipsEnvironmentV(ship);
	// addToListShips(new Ship(ship.getBlocks()));
	// for (Coordinate c : ship.getBlocks())
	// System.out.print("\n" + "(" + c + " - " + c.getMarker() + ")");
	// }

	public Coordinate PlaceForShipH(int mot) {
		boolean validPlace = false;
		Coordinate c1 = null;
		while (!validPlace) {
			int x = rd1.nextInt(8) + 1;
			int y = rd1.nextInt(8) + 1;
//			System.out.println("coord :( x , " + y + ")");
			c = getCoordFromTemp(x, y);
//			System.out.println(c + " " + c.getMarker());
			c1 = c;
			for (int a = 1; a < mot; a++) {
				if (c1.isMarked()) {
					break;
				} else {
					if (c.getY() + mot < 9)
						c1 = getNextCoordInRowFromTemp(c1);
					else
						c1 = getPreviousCoordInRowFromTemp(c1);
				}
				if ((a == mot - 1) && !(c1.isMarked()))
					validPlace = true;
			}
		}
		System.out.println("aaaaaaaa" + c + " : " + c.getMarker());
		if (c.getY() >= c1.getY())
			c = c1;
		System.out.println("returned" + c + " : " + c.getMarker());
		return c;
	}

	// public Coordinate ValidPlaseForShipH(int mot) {
	// Coordinate c1;
	// boolean validPlace;
	// do {
	// validPlace = true;
	// int x = rd1.nextInt(7) + 1;
	// int y = rd2.nextInt(7) + 1;
	// c = getCoordFromTemp(new Coordinate(x, y));
	// c = new Coordinate(x, y);
	// c1 = c;
	// for (int i = 0; i < mot - 1; i++) {
	// if (shipsEnvironment.contains(c1)) {
	// System.out.println("can not take " + c1 + "\n");
	// validPlace = false;
	// break;
	// } else {
	// if (c.getX() + mot <= 9)
	// c1 = c1.nextInRow();
	// else
	// c1 = c1.previousInRow();
	// }
	// }
	// } while (!validPlace);
	// if (c.getX() <= c1.getX()) {
	// System.out.println("returned c :" + c + "\n");
	// return c;
	// } else {
	// System.out.println("returned c1 :" + c1 + "\n");
	// return c1;
	// }
	// }
	// public Coordinate ValidPlaseForShipV(int mot) {
	// boolean isValidPlace = false;
	// do {
	// int index = rd1.nextInt(tempForShipsSet.size()) + 1;
	// c = getCoordByIndexFromTemp(index);
	// Coordinate c1 = c;
	// if (c1.getMarker() == 'm') {
	// break;
	// } else {
	// for (int k = 0; k < mot; k++) {
	// if (c.getX() + mot - 1 <= 8)
	// c1 = c1.nextInColm();
	// else
	// c1 = c1.previousInColm();
	// if (c1.getMarker() == 'm')
	// break;
	// }
	// }
	// isValidPlace = true;
	// } while (!isValidPlace);
	// return c;
	// }

	public int sizeOfEmptyFields() {
		return emptyFields.size();
	}

	public int sizeOfDeadShips() {
		return deadShips.size();
	}

	// public List<Coordinate> getShipsEnvironment() {
	// return shipsEnvironment;
	// }

	public void setH_ShipsEnvironmentMarkers(Ship ship) {
		Coordinate c, c1, c2;
		c = ship.getBlocks().get(0);
		int i = c.getX();
		int j = c.getY();
		c = getCoordFromTemp(i, j);
		c1 = getUpperLeftCoordFromTemp(c);
		c = ship.getBlocks().get(ship.getMotors() - 1);
		i = c.getX();
		j = c.getY();
		c = getCoordFromTemp(i, j);
		c2 = getLowerRightCoordFromTemp(c);
		for (int x = c1.getX(); x <= c2.getX(); x++) {
			for (int y = c1.getY(); y <= c2.getY(); y++) {
				getCoordFromTemp(x, y).setMarker('m');
				// shipsEnvironment.add(new Coordinate(x, y));
			}
		}
	}

	// public void setShipsEnvironmentV(Ship ship) {
	// Coordinate c1, c2, c3 c4;
	// c1 = ship.shipUpperCornerLeft();
	// c2 = ship.shipLowerCornerLeft();
	// c3 = ship.shipUpperCornerRight();
	// c4 = ship.shipLowerCornerRight();
	// for (int i = c1; i <= c3; i++) {
	// for (int j = c1; j <= c4; j++) {
	// c = new Coordinate(i, j);
	// c.setMarker('m');
	// // shipsEnvironment.add(c);
	// }
	// }
	// }
}