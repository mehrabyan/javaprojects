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
         	 for (int i = 1; i < 9; i++){	// we don't need the coordinate with 0 and 9 		 
			   for (int j = 1; j < 9; j++){		
					targetForShot.add(new Coordinate(i,j));
//			   System.out.print(c.toString());
			   }
//			   System.out.println();
     		 }
   	}
         	
	public Coordinate pli() {	
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
	
	public int sizeOftargetForShot() {
		return targetForShot.size();
	}
}