//object sozdaet Shipsfield i rasstavlyaet korabli
package seebattle;
import java.util.*;

public class Allocetships {
	Coordinat c;
	Shipsfield field;
	int[] motor = {4,3,3,2,2,2,1,1,1,1};
	Allocetships () {
	field = new Shipsfield();
	}
	void allocet () {
		int kx = 0;
		int ky = 0;
		int dir;
		Random rand = new Random();
	    Random rr = new Random();
	    for(int mot: motor) {
	      dir = rr.nextInt(2);          // 0-Horizontal,1- Vertical              
	      		switch ( dir) {
	      			case 0 :
	      					do {
	                        kx = rand.nextInt(8)+1;
	                        ky = rand.nextInt(8)+1;
	                        field.checkfields.checkH(kx, ky, mot);
	                        } while (field.checkfields.mojno != 0 );
	          				field.setship.setShipH(kx, ky, mot);
//	          				for (int i = 0; i < 10; i++) {
//	          		          for (int j = 0; j < 10; j++)
//	          			   System.out.print(field.cell[i][j] + "  ");
//	          		           System.out.println();
//	          		          }
//	          				 System.out.println();
		               break;
	          case 1 : do {
	                         kx = rand.nextInt(8)+1;
	                         ky = rand.nextInt(8)+1;
	                         field.checkfields.checkV(kx, ky, mot);
	                         } while(field.checkfields.mojno != 0 );
	                         field.setship.setShipV(kx, ky, mot);
	                   break;
	           default : System.out.println("Voznikla oshibka");
	     }
     }   
 }
}