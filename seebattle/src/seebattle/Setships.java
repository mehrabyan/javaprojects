package seebattle;

public class Setships {
	Coordinat c = new Coordinat();
// sozdaem H korabl ,v kajdoy kletke - chislo motorov
    void setShipH(int kx,int ky,int motor) {
    	c.x = kx; c.y = ky;
    	System.out.println("Horizontal " + motor + "  ship coord = " + c.x + " " + c.y);
	     for ( int i = 0; i < motor; i++) 
               field.cell[c.x + i][c.y] = motor;
// vozle  H korablya zapisivaem 9 vo vsex yacheykax
	     for ( int i = 0; i < motor; i++) {
	         field.cell[c.x + i][c.y - 1] = 9;
	         field.cell[c.x + i][c.y + 1] = 9;
	         }
	     for ( int i = 0; i < 3; i++) {
	         field.cell[c.x - 1][c.y - 1 + i] = 9;
	         field.cell[c.x + motor][c.y - 1 + i] = 9;
	         }
     } // konec metoda	     
//sozdaem V korabl ,v kajdoy kletke - chislo motorov
    void setShipV(int kx, int ky, int motor) {
    	c.x = kx; c.y = ky;
    	System.out.println("Vertikal " + motor + "  ship coord = " + c.x + " " + c.y);
	     for ( int i = 0; i < motor; i++)
               field.cell[c.x][c.y + i] = motor;
// vozle  V korablya zapisivaem 9 vo vsex yacheykax
	     for ( int i = 0; i < motor; i++) {
	         field.cell[c.x - 1][c.y + i] = 9;
	         field.cell[c.x + 1][c.y + i] = 9;
	         }
	     for ( int i = 0; i < 3; i++) {
	         field.cell[c.x - 1 + i][c.y - 1] = 9;
	         field.cell[c.x -1 + i][c.y + motor] = 9;
	         }	     
      }
}