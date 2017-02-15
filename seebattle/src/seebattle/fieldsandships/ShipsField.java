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

	public List<Coordinate> getTempForShipsSet() {
		return tempForShipsSet;
	}

	public Coordinate getCoordFromEmptyFields(int x, int y) {
		return emptyFields.get(10 * x + y);
	}

	public Coordinate getCoordByIndexFromTemp(int i) {
		return tempForShipsSet.get(i);
	}

	public Coordinate getCoordFromTemp(int x, int y) {
		return tempForShipsSet.get(10 * x + y);
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

	public void setShip1Mot() {
		Ship ship = new Ship();
		c = PlaceFor1MotShip();
		int x = c.getX();
		int y = c.getY();
		c = new Coordinate(x, y);
		ship.addToBlocks(c);
		ship.setMotors(1);
		// mark ship environment
		setShipsEnvironmentMarkers(ship);
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
		// mark ship environment
		setShipsEnvironmentMarkers(ship);
		addToListShips(new Ship(ship.getBlocks()));

	}

	public void SetShipV(int mot) {
		Ship ship = new Ship();
		c = PlaseForShipV(mot);
		int x = c.getX();
		int y = c.getY();
		c = new Coordinate(x, y);
		for (int k = 0; k < mot; k++) {
			ship.addToBlocks(c);
			c = c.nextInColm();
		}
		ship.setMotors(mot);
		// mark ship environment
		setShipsEnvironmentMarkers(ship);
		addToListShips(new Ship(ship.getBlocks()));

	}

	public void showFields() {
		char[][] mass = new char[10][10];
		for (int t = 0; t < 10; t++) {
			for (int r = 0; r < 10; r++)
				mass[t][r] = ' ';
		}

		for (Coordinate c : tempForShipsSet) {
			if (c.isMarked()) {
				int s = c.getX();
				int d = c.getY();
				mass[s][d] = ' ';
			}
		}

		for (Ship sh : ships) {
			for (Coordinate c : sh.getBlocks()) {
				int i = c.getX();
				int j = c.getY();
				mass[i][j] = 'O';
			}
		}
		for (int t = 0; t < 10; t++) {
			for (int r = 0; r < 10; r++) {
				System.out.print(Arrays.asList(mass[t][r]));
			}
			System.out.println();
		}
		System.out.println(toString());
	}

	public Coordinate PlaceFor1MotShip() {
		Coordinate c = null;
		boolean validPlace = false;
		while (!validPlace) {
			int x = rd1.nextInt(8) + 1;
			int y = rd1.nextInt(8) + 1;
			c = getCoordFromTemp(x, y);
			if (!(c.isMarked()))
				validPlace = true;
		}
		return c;
	}

	public Coordinate PlaceForShipH(int mot) {
		boolean validPlace = false;
		Coordinate c1 = null;
		while (!validPlace) {
			int x = rd1.nextInt(8) + 1;
			int y = rd1.nextInt(8) + 1;
			c = getCoordFromTemp(x, y);
			c1 = c;
			for (int a = 1; a < mot; a++) {
				if (c1.isMarked()) {
					break;
				} else {
					if (c.getY() + mot <= 9)
						c1 = getNextCoordInRowFromTemp(c1);
					else
						c1 = getPreviousCoordInRowFromTemp(c1);
				}
				if ((a == mot - 1) && !(c1.isMarked()))
					validPlace = true;
			}
		}
		if (c.getY() >= c1.getY())
			c = c1;
		return c;
	}

	public Coordinate PlaseForShipV(int mot) {
		boolean validPlace = false;
		Coordinate c1 = null;
		while (!validPlace) {
			int x = rd1.nextInt(8) + 1;
			int y = rd1.nextInt(8) + 1;
			c = getCoordFromTemp(x, y);
			c1 = c;
			for (int a = 1; a < mot; a++) {
				if (c1.isMarked()) {
					break;
				} else {
					if (c.getX() + mot <= 9)
						c1 = getNextCoordInColmFromTemp(c1);
					else
						c1 = getPreviousCoordInColmFromTemp(c1);
				}
				if ((a == mot - 1) && !(c1.isMarked()))
					validPlace = true;
			}
		}
		if (c.getX() >= c1.getX())
			c = c1;
		return c;
	}

	public int sizeOfEmptyFields() {
		return emptyFields.size();
	}

	public int sizeOfDeadShips() {
		return deadShips.size();
	}

	public void setShipsEnvironmentMarkers(Ship ship) {
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
			}
		}
	}
}