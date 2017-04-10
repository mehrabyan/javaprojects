package seebattle.fieldsandships;

import java.util.*;

public class ShipsField {
	Random rd1 = new Random(); // remove into methods.
	Coordinate c, currentCell;
	private List<Ship> ships = new ArrayList<Ship>();
	private List<Ship> deadShips = new ArrayList<Ship>();
	private List<Coordinate> emptyFields = new ArrayList<Coordinate>();
	private List<Coordinate> unmarkedCells = new ArrayList<Coordinate>();

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
	
	public Coordinate getCoordFromEmptyFields(int x, int y) {
		return emptyFields.get((10 * x) + y);
	}

	public Coordinate getNextCoordInRowFromEmptyFields(Coordinate c) {
		int x = c.getX();
		int y = c.getY();
		return emptyFields.get((10 * x) +  y + 1);
	}

	public Coordinate getPreviousCoordInRowFromEmptyFields(Coordinate c) {
		int x = c.getX();
		int y = c.getY();
		return emptyFields.get((10 * x) + y - 1);
	}

	public Coordinate getNextCoordInColmFromEmptyFields(Coordinate c) {
		int x = c.getX();
		int y = c.getY();
		return emptyFields.get(10 * (x + 1) + y);
	}

	public Coordinate getPreviousCoordInColmFromEmptyFields(Coordinate c) {
		int x = c.getX();
		int y = c.getY();
		return emptyFields.get(10 * (x - 1) + y);
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

	public Coordinate PlaceFor1MotShip() {
		setUnmarkedCells();
			int x = rd1.nextInt(unmarkedCells.size());
			return unmarkedCells.get(x);
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
	public void showFields() {
		char[][] mass = new char[10][10];
		for (Coordinate c : emptyFields) {
			if (c.isMarked()) {
			int i = c.getX();
			int j = c.getY();
				mass[i][j] = 'X';
			}
	}
		for(Ship sh : ships) {
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
	
	public List<Coordinate> getUnmarkedCells() {
		return unmarkedCells;
	}

	public void setUnmarkedCells() {
		unmarkedCells.removeAll(unmarkedCells);
		for(int i = 1; i < 9; i++) {
			for(int j = 1; j < 9; j++) {
			if (!(getCoordFromEmptyFields(i,j).isMarked()))
				unmarkedCells.add(getCoordFromEmptyFields(i,j));
			}
		}
	}
}