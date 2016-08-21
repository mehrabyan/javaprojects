package seebattle;

public class Checkfields {
	int mojno;
	Coordinate c = new Coordinate();
	// Proveryaetsya mesto dlya Horizontal dir ship
		void checkH ( int kx , int ky ,int motor ) {
			c.x = kx; c.y = ky;
			  if (c.x + motor > 8)
			     	mojno = 1;
			   else {
			      for (int i = 0; i < motor; i++) {
			    	  if(cell[c.x + i][c.y] != 0)
				    	   mojno = 1;
			    	  else mojno = 0;
				      }
			       } // end else
		}   // konec metoda checkH
	// Proveryaetsya mesto dlya Vertical dir ship
			 void checkV (int kx, int ky, int motor) {
				 c.x = kx; c.y = ky;
			     if (c.y + motor > 8)
			    	mojno = 1;
			     else {
			       for (int i = 0; i < motor; i++) {
			    	  if(cell[c.x][c.y + i] != 0)
			    		   mojno = 1;
			    	  else mojno = 0;
					      }
			     } // end else
		 }   // konec metoda checkV
}
