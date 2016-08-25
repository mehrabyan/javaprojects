package seebattle;

import java.util.Random;

public class Verticaldir implements SetCoordinate {
	Coordinate c;
	Shipsfield field;
	Ship ship;
	Random rand = new Random();
	int mot;	// In future it must be modifyed
	// generet coordinates random for Vertical
			public void setCoordinatesForShip() {
				c.setX(rand.nextInt(8) + 1);
				c.setY(rand.nextInt(8) + 1);
				int count = 0;
				
	// check  coordinate (motor) in emptyFields,if all necessery coordinates are in the emptyfields
			     for (int i = 0; i< mot; i++)
			    	 if (field.emptyFields.contains(c)) {
			    		 count++;
			    		 c.nextInColm(c);
			    	 }
			     
	// set its to ship blocks and delete from emptyFields
			     if (count == mot) {
			    	 for (int i = 0; i< mot; i++) {
			    		 ship.addToBlocks(c);
			    		 field.emptyFields.remove(c);
			    		 c.previousInColm(c);
			    	     }
			    	  field.addtToListShips(new Ship(blocks));	// create ship with that coordinates
		     }
	    }

}
