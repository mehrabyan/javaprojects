package seebattle.fieldsandships;

import java.util.*;

public class ShipsField {
	Random rd1 = new Random();
	Coordinate c;
	private List<Ship> ships = new ArrayList<Ship>();
	private List<Ship> deadShips = new ArrayList<Ship>();
	private List<Coordinate> emptyFields = new ArrayList<Coordinate>();
	// private Iterator<Coordinate> it = emptyFields.iterator();

	public ShipsField() {
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				c = new Coordinate(i, j);
				c.setMarker('u');
				emptyFields.add(c);
			}
		}
	}
	
	public List<Coordinate> getEmptyFields() {
		return this.emptyFields;
	}

	public List<Ship> getShips() {
		return ships;
	}
	
	public int unmarkedCellsNumber() {
		int number = 0;
		for(int i = 1; i < 9; i++) {
			for(int j = 1; j < 9; j++) {
			if (!(getCoordFromEmptyFields(i,j).isMarked()))
			number++;
			}
		}
		return number;
	}
	
	public Coordinate getCoordFromEmptyFields(int x, int y) {
		return emptyFields.get(10 * x + y);
	}

	public Coordinate getNextCoordInRowFromEmptyFields(Coordinate c) {
		int index = 0;
		if (emptyFields.contains(c))
			index = emptyFields.indexOf(c);
		return emptyFields.get(index + 1);
	}

	public Coordinate getPreviousCoordInRowFromEmptyFields(Coordinate c) {
		int index = 0;
		if (emptyFields.contains(c))
			index = emptyFields.indexOf(c);
		return emptyFields.get(index - 1);
	}

	public Coordinate getNextCoordInColmFromEmptyFields(Coordinate c) {
		int index = 0;
		if (emptyFields.contains(c))
			index = emptyFields.indexOf(c);
		return emptyFields.get(index + 10);
	}

	public Coordinate getPreviousCoordInColmFromEmptyFields(Coordinate c) {
		int index = 0;
		if (emptyFields.contains(c))
			index = emptyFields.indexOf(c);
		return emptyFields.get(index - 10);
	}

	public Coordinate getUpperLeftCoordFromEmptyFields(Coordinate c) {
		int x = c.getX();
		int y = c.getY();
		return getCoordFromEmptyFields(x - 1, y - 1);
	}

	public Coordinate getLowerRightCoordFromTemp(Coordinate c) {
		int x = c.getX();
		int y = c.getY();
		return getCoordFromEmptyFields(x + 1, y + 1);
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

	public void addToListShips(Ship ship) { 
		ships.add(ship);
	}
	
	public void removeShipsCoordFromEmptyFields() { // remove from emptyFields
		for (Ship ship : ships) {
			for (Coordinate c : ship.getBlocks()) {
				emptyFields.remove(c);	
			}
		}
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
	
//	@Override
//	public String toString() {
//		return " [ships=" + ships + "\n" + "]";
//	}

	public List<Coordinate> showEmptyFields() {
		return emptyFields;
	}

	public void set1MotShip() {
		Ship ship = new Ship();
		c = PlaceFor1MotShip();
		ship.addToBlocks(c);
		ship.setMotors(1);
		// mark ship environment
		setShipsEnvironmentMarkers(ship);
		addToListShips(new Ship(ship.getBlocks()));
	}

	public void set4MotShipH(int mot) {
		Ship ship = new Ship();
		c =PlaceFor4MotShipH(mot);
		for (int k = 0; k < mot; k++) { // reseive coord array from PlaceFor4MotShipH 
			ship.addToBlocks(c);		//
			c = getNextCoordInRowFromEmptyFields(c); // 
		}
		ship.setMotors(mot);
		// mark ship environment
		setShipsEnvironmentMarkers(ship);
		addToListShips(new Ship(ship.getBlocks()));

	}

	public void set4MotShipV(int mot) {
		Ship ship = new Ship();
		c = PlaceFor4MotShipV(mot);
		for (int k = 0; k < mot; k++) { // reseive coord array from PlaceFor4MotShipH
			ship.addToBlocks(c);
			c = getNextCoordInColmFromEmptyFields(c);
		}
		ship.setMotors(mot);
		// mark ship environment
		setShipsEnvironmentMarkers(ship);
		addToListShips(new Ship(ship.getBlocks()));

	}

	
	public void setShipH(int mot) {
		Ship ship = new Ship();
		c =PlaceForShipH(mot);
		for (int k = 0; k < mot; k++) {
			ship.addToBlocks(c);
			c = getNextCoordInRowFromEmptyFields(c);
		}
		ship.setMotors(mot);
		// mark ship environment
		setShipsEnvironmentMarkers(ship);
		addToListShips(new Ship(ship.getBlocks()));

	}

	public void setShipV(int mot) {
		Ship ship = new Ship();
		c = PlaceForShipV(mot);
		for (int k = 0; k < mot; k++) {
			ship.addToBlocks(c);
			c = getNextCoordInColmFromEmptyFields(c);
		}
		ship.setMotors(mot);
		// mark ship environment
		setShipsEnvironmentMarkers(ship);
		addToListShips(new Ship(ship.getBlocks()));

	}

	public void showFields() {
		char[][] mass = new char[10][10];
		for (Coordinate c : emptyFields) {
			if (c.isMarked()) {
			int i = c.getX();
			int j = c.getY();
				mass[i][j] = ' ';
			}
	}
		for(Ship sh : ships) {
			for (Coordinate c : sh.getBlocks()) {
				int i = c.getX();
				int j = c.getY();
					mass[i][j] = 'X';
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
		Coordinate c = null ;
		boolean validPlace = false;
		while (!validPlace) {
			int x = rd1.nextInt(8) + 1;
			int y = rd1.nextInt(8) + 1;
			c = getCoordFromEmptyFields(x, y);
			if (!(c.isMarked()))
				validPlace = true;
		}
		return c;
	}

	public Coordinate PlaceFor4MotShipH(int mot) {
		boolean validPlace = false;
		Coordinate c1 = null;
		while (!validPlace) {
			int z = rd1.nextInt(3);
			if(z % 2 == 0) {
				z ++ ;
			}
			int x = z;
			int d = rd1.nextInt(5);
			if(d % 2 == 0) {
				d ++ ;
			}
			int y = d;
			c = getCoordFromEmptyFields(x, y);
			c1 = c;
			for (int a = 1; a < mot; a++) {
				if (c1.isMarked()) {
					break;
				} else {
						c1 = getNextCoordInRowFromEmptyFields(c1);
				}
				if ((a == mot - 1) && !(c1.isMarked()))
					validPlace = true;
			}
		}
		System.out.println("Returned coordinate c is :" + c);
		return c;
	}
	
	public Coordinate PlaceFor4MotShipV(int mot) {
		boolean validPlace = false;
		Coordinate c1 = null;
		while (!validPlace) {
			int d = rd1.nextInt(5);
			if(d % 2 == 0) {
				d ++ ;
			}
			int x = d;
			int z = rd1.nextInt(3);
			if(z % 2 == 0) {
				z ++ ;
			}
			int y = z;
			c = getCoordFromEmptyFields(x, y);
			c1 = c;
			for (int a = 1; a < mot; a++) {
				if (c1.isMarked()) {
					break;
				} else {
						c1 = getNextCoordInColmFromEmptyFields(c1);
				}
				if ((a == mot - 1) && !(c1.isMarked()))
					validPlace = true;
			}
		}
		return c;
	}
	
	public Coordinate PlaceForShipH(int mot) {
		boolean validPlace = false;
		Coordinate c1 = null;
		while (!validPlace) {
			int x = rd1.nextInt(8) + 1;
			int y = rd1.nextInt(8) + 1;
			c = getCoordFromEmptyFields(x, y);
			c1 = c;
			for (int a = 1; a < mot; a++) {
				if (c1.isMarked()) {
					break;
				} else {
					if (c.getY() + mot <= 9)
						c1 = getNextCoordInRowFromEmptyFields(c1);
					else
						c1 = getPreviousCoordInRowFromEmptyFields(c1);
				}
				if ((a == mot - 1) && !(c1.isMarked()))
					validPlace = true;
			}
		}
		if (c.getY() >= c1.getY())
			c = c1;
		return c;
	}

	public Coordinate PlaceForShipV(int mot) { // join 2 method
		boolean validPlace = false;
		Coordinate c1 = null;
		while (!validPlace) {
			int x = rd1.nextInt(8) + 1;
			int y = rd1.nextInt(8) + 1;
			c = getCoordFromEmptyFields(x, y);
			c1 = c;
			for (int a = 1; a < mot; a++) {
				if (c1.isMarked()) {
					break;
				} else {
					if (c.getX() + mot <= 9)
						c1 = getNextCoordInColmFromEmptyFields(c1);
					else
						c1 = getPreviousCoordInColmFromEmptyFields(c1);
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
		c = getCoordFromEmptyFields(i, j);
		c1 = getUpperLeftCoordFromEmptyFields(c);
		c = ship.getBlocks().get(ship.getMotors() - 1);
		i = c.getX();
		j = c.getY();
		c = getCoordFromEmptyFields(i, j);
		c2 = getLowerRightCoordFromTemp(c);
		for (int x = c1.getX(); x <= c2.getX(); x++) {
			for (int y = c1.getY(); y <= c2.getY(); y++) {
				getCoordFromEmptyFields(x, y).setMarker('m');
			}
		}
	}
}