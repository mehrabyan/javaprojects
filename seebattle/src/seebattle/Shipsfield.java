package seebattle;

import java.util.ArrayList;
import java.util.*;

public class Shipsfield {
	Ship ship;
	Coordinate c;
	private List<Ship> ships = new ArrayList<Ship>();						// can I chenge the access specifiers,
	private Iterator<Ship> iterships = ships.iterator();					// or I need to create some methods to access private fields ?
	private List<Ship> deadShips = new ArrayList<Ship>();					//
	private List<Coordinate> emptyFields = new ArrayList<Coordinate>();		//

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
					iterships.remove(); // Can't be done this way. Need an iterator
					
				default:
					break;
				}
				
				if(res.equals(ShotResult.HIT) || res.equals(ShotResult.DEAD))
					break;
			}
		}
		
		return res;
	}

	public void addtToListShips(Ship ship){
		ships.add(ship);
	}
// I way.  All coordinates from c[0,0] to c[9,9] replace into emptyFields 
	public void fillEmptyFields () {
		c.setC(0, 0);
		for (int i = 0; i < 10; i++){		//	as alternative emptyFields.add(c.set(i,j) 
			for (int j = 0; j < 10; j++){	//	
				emptyFields.add(c);			//
				c.nextInRow(c);
			}
				c.nextInColm(c);
		}
	}
}