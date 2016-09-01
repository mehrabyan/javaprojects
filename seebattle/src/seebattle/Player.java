// Sozdaem class igrokov
package seebattle;
import java.util.*;

public class Player {
	Coordinate c;
	int plicoordind;
	private List<Coordinate> targetForShot = new ArrayList<Coordinate>();
	private List<Coordinate> shotHistory = new ArrayList<Coordinate>();
	Random coordind = new Random();
	
	Player() {
         	 for (int i = 1; i < 10; i++){	// we don't need the coordinate with 0 and 10 		 
			   for (int j = 1; j < 10; j++){		
					targetForShot.add(new Coordinate(i,j));
//			   System.out.print(c.toString());
			   }
//			   System.out.println();
     		 }
   	}
         	
	public Coordinate pli() {	
		System.out.println("Target size is :" + sizeOfTargetForShot());
		  plicoordind = coordind.nextInt(targetForShot.size());
		  c = targetForShot.get(plicoordind);
		  System.out.println("My target is :" +  c.toString());
		  shotHistory.add(c);
		  targetForShot.remove(c);
//		  int enter = System.in.read();
		  return c;
    }
	
	public void showShotHistory() {
		System.out.println("The shoot history :" + shotHistory.toString());
	}
	
	public int sizeOfTargetForShot() {
		return targetForShot.size();
	}
}