// Sozdaem class igrokov
package seebattle;
import java.util.*;

public class Player {
	Coordinate c;
	Random rrr = new Random();

	  public Coordinate pli(Shipsfield shipsfield) {	// player choose target random 
			c.setX(rrr.nextInt(7)+1);	
			c.setY(rrr.nextInt(7)+1);	
            System.out.println("My target is :" + c.toString());  
      return c;
	} 
		
}