// Sozdaem class igrokov
package seebattle;
import java.util.*;

public class Player {
	Coordinate c;
	protected List<Coordinate> previouseShot = new ArrayList<Coordinate>();
	Random rrr = new Random();

	  public Coordinate pli(Shipsfield shipsfield) {	// player choose target random
			c.setX(rrr.nextInt(7)+1);	
			c.setY(rrr.nextInt(7)+1);	
			
// Need to decide about returned coordinate, check it here or in GameManager
//			if (!(previouseShot.contains(c))){
//				previouseShot.add(c);
//	            System.out.println("My target is :" + c.toString());
	            return c;
//		       	}
//			else {	
//				System.out.println(c.toString() + " coodinate was already shooted,try again");
//				c.setC(0,0);
//                return c; // isn't correct.How redo method?
//			}
 }			
}