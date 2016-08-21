package seebattle;

import java.util.ArrayList;
import java.util.List;

public class Shipsfield {
	private List<Ship> ships = new ArrayList<Ship>();
	private List<Ship> deadShips = new ArrayList<Ship>();
	private List<Coordinate> emptyFields = new ArrayList<Coordinate>();

	public ShotResult checkShot(Coordinate c) {
		ShotResult res = null;
		
		if(emptyFields.contains(c)) 
			res = ShotResult.MISS;
		else {
			for (Ship ship : ships) {
				res = ship.processShot(c);
				
				switch (res) {
				case HIT:
					break;
				case DEAD:
					deadShips.add(ship);
					ships.remove(ship); // Can't be done this way. Need an iterator
				default:
					break;
				}
				
				if(res.equals(ShotResult.HIT) || res.equals(ShotResult.DEAD))
					break;
			}
		}
		
		return res;
	}
}
