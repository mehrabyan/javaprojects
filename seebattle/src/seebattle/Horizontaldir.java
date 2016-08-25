package seebattle;

import java.util.Random;

public class Horizontaldir implements SetCoordinate {
	Coordinate c;
	Shipsfield field;
	Ship ship;
	Random rand = new Random();
	int mot;	// In future it must be modifyed
// generet coordinate by random for Horizontal
		public void setCoordinatesForShip() {
			c.setX(rand.nextInt(8) + 1);
			c.setY(rand.nextInt(8) + 1);
			int count = 0;
// check all coordinat (motor) in emptyFields,if all necessery coordinates are in the emptyfields
		     for (int i = 0; i< mot; i++)
		    	 if (field.emptyFields.contains(c)) {
		    		 count++;
		    		 c.nextInRow(c);
		    	 }
		     
// set its to ship blocks and delete from emptyFields 
		     if (count == mot) {
		    	 for (int i = 0; i< mot; i++) {
		    		 ship.addToBlocks(c);
		    		 field.emptyFields.remove(c);
		    		 c.previousInRow(c);
		    	     }
		    	field.addtToListShips(new Ship(blocks));	// create ship with that coordinates
		     }
	  }
}
