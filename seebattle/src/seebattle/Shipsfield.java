package seebattle;

import java.util.ArrayList;
import java.util.*;

public class Shipsfield {
	Ship ship;
	Coordinate c;
	Random rand = new Random();
	int mot;	// In future it must be modifyed
	private List<Ship> ships = new ArrayList<Ship>();
	private Iterator<Ship> iterships = ships.iterator();
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

// I way.  All coordinates c[0,0] to c[9,9] replace into emptyFields 
	public void fillEmptyFields () {
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				emptyFields.add(c);
				c.nextInRow(c);
			}
				c.nextInColm(c);
		}
	}
	
	
// generet coordinate by random for Horizontal
	public void checkCoordforShipsH() {
		c.setX(rand.nextInt(7) + 1);
		c.setY(rand.nextInt(7) + 1);
		int count = 0;
		
// check all coordinat (motor) in emptyfields,if all necessery coordinates are in the emptyfields
	     for (int i = 0; i< mot; i++)
	    	 if (emptyFields.contains(c)) {
	    		 count++;
	    		 c.nextInRow(c);
	    	 }
	     
// set its to ship blocks and delet from emptyFields 
	     if (count == mot) {
	    	 for (int i = 0; i< mot; i++) {
	    		 ship.blocks.add(c);
	    		 emptyFields.remove(c);
	    		 c.previousInRow(c);
	    	     }
	    	 ships.add(new Ship(blocks));	// create ship with that coordinates
	     }

  }
// generet coordinate by random for Vertical
	public void checkCoordforShipsV() {
		c.setX(rand.nextInt(7) + 1);
		c.setY(rand.nextInt(7) + 1);
		int count = 0;
		
// check all coordinat (motor) in emptyfields,if all necessery coordinates are in the emptyfields
	     for (int i = 0; i< mot; i++)
	    	 if (emptyFields.contains(c)) {
	    		 count++;
	    		 c.nextInColm(c);
	    	 }
	     
// set its to ship blocks and delet from emptyFields
	     if (count == mot) {
	    	 for (int i = 0; i< mot; i++) {
	    		 ship.blocks.add();
	    		 emptyFields.remove(c);
	    		 c.previousInColm(c);
	    	     }
	    	 ships.add(new Ship(blocks));	// create ship with that coordinates
	     }
    }
}