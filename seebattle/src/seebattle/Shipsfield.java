package seebattle;

import java.util.ArrayList;
import java.util.*;

public class Shipsfield {
	Ship ship;
	Coordinate c;
	private List<Ship> ships = new ArrayList<Ship>();						
	private Iterator<Ship> iterships = ships.iterator();					
	private List<Ship> deadShips = new ArrayList<Ship>();					
	private List<Coordinate> emptyFields = new ArrayList<Coordinate>();		

	public ShotResult checkShot(Coordinate c) {
		ShotResult res = null;
//		System.out.println("In checkShot res is :" + res);
		System.out.println("In checkShot :" + showemptyFields());
		if(emptyFields.contains(c)) {								// res don't reseive value  in true case
			System.out.println("We are in true");
			res = ShotResult.MISS;
			System.out.println("True case res is :" + res);
		}
		else {
			System.out.println("Else case res is :" + res);
			for (Ship ship : ships) {
				res = ship.processShot(c);
				System.out.println("In for each  res is :" + res);
				switch (res) {
				case HIT:
					break;
				case DEAD:
					deadShips.add(ship);
//					iterships.next();
					iterships.remove(); // Can't be done this way. Need an iterator
					break;
				default:
					break;
				}
				
				if(res.equals(ShotResult.HIT) || res.equals(ShotResult.DEAD))
					break;
			}
		}
		System.out.println("In exiting from for each res is :" + res);
		return res;
	}

	public void addToListShips(Ship ship){
		ships.add(ship);
	}
	
	public void removeFromEmptyFields (Coordinate c) {
		emptyFields.remove(c);
	}
	
	public int checkListOfShips() {
		return ships.size();
	}
	
	public String showHitShips() {
		for (Ship ship: ships) {
			if (ship.getMotors() > ship.getSizeOfBlocks())
		return "The hit ships :" + ship.toString();
				
			}
	}
	
	public String showDeadShips() {
		return "Deadships= [" + deadShips +"]"; 
	}
	
	@Override
	public String toString() {
		return "Shipsfield [ships=" + ships + "]";
	}
	
	public String showemptyFields() {
		return "emptyFields :" + emptyFields;
	}
	
// I way.  All coordinates from c[0,0] to c[9,9] replace into emptyFields 
	public void fillEmptyFields () {
		c = new Coordinate();
		  for (int i = 0; i < 10; i++){ 
			for (int j = 0; j < 10; j++)	
				emptyFields.add(new Coordinate(i,j));
		}
	}
	public int sizeOfEmptyFields() {
		return emptyFields.size();
		}
}