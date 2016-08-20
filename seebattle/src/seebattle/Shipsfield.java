package seebattle;

public class Shipsfield {
	int[][] cell = new int[10][10];
//	Coordinat c = new Coordinat();
	Setships setship;
	Checkfields checkfields;
	Shipsfield() {
		checkfields = new Checkfields();
		setship = new Setships();
//		System.out.println("Novie pole dlya korabley \n");
//		 for (c.x = 0; c.x < 10; c.x++) {
//		  for (c.y = 0; c.y < 10; c.y++){
//			  cell[c.x][c.y] = 0;
//		}
//	 }
  }
}
