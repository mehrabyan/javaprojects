// Sozdaem class igrokov
package seebattle;
import java.util.*;

public class Player {
	Coordinat c;
	int[] koordinat = new int[2];
	Player () {
		System.out.println("Sozdaem obyekt igrok \n");
	}
	int[]   pli (Target tar) {	// igrok sluchayno vibiraet cel 
		Random rrr = new Random();
		do {				// krutit, poka budet pustaja yacheyka 
			c.x = rrr.nextInt(7)+1;	
			c.y = rrr.nextInt(7)+1;	
			} while(!(tar.cell[c.x][c.y] == ' '));
     System.out.println("Moya cel :" + "(" + c.x +" ; " + c.y + ")");  
      koordinat[0] = c.x;
      koordinat[1] = c.y;
      return koordinat;
  }
}