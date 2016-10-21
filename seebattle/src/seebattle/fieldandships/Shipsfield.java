package seebattle.fieldandships;

import java.util.ArrayList;
import java.util.List;

public class Shipsfield {
	private List<Ship> ships = new ArrayList<Ship>();
	// private Iterator<Ship> it = ships.iterator();
	private List<Ship> deadShips = new ArrayList<Ship>();
	private List<Coordinate> emptyFields = new ArrayList<Coordinate>();

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

	public void addToListShips(Ship ship) { // add remove from emptyFields
		ships.add(ship);
		for (Coordinate c : ship.getBlocks())
			emptyFields.remove(c);
	}

	public void removeFromEmptyFields(Coordinate c) {
		emptyFields.remove(c);
	}

	public int checkListOfShips() {
		return ships.size();
	}

	public Coordinate getCoordByIndexFromEmptyFields(int i) {
		return emptyFields.get(i);
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
		return "Shipsfield [ships=" + ships + "]";
	}

	public List<Coordinate> showEmptyFields() {
		return emptyFields;
	}

	// I way. All coordinates from c[0,0] to c[9,9] replace into emptyFields
	public void fillEmptyFields() {
		// Coordinate c = new Coordinate();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				emptyFields.add(new Coordinate(i, j));
		}
	}

	public int sizeOfEmptyFields() {
		return emptyFields.size();
	}

	public int sizeOfDeadShips() {
		return deadShips.size();
	}
}