// sozdaetsya klass pole dlya vistrelov
package seebattle;

class Target {
   char[][] cell;		//massiv dlya vistrelov
   Coordinat c;
   Target () {			//konstruktor inicializ pole
	   System.out.println();   
       System.out.println("Sozdaetsya pole - mishen \n");
       cell = new char[10][10];
	   c = new Coordinat();
	  for (c.x = 0; c.x < 10; c.x++) {
	    for (c.y = 0; c.y < 10; c.y++){
		  cell[c.x][c.y] = '_';
		  System.out.print(cell[c.x][c.y] + "  ");
	  } 
	  System.out.println();
	}
   }// konec konstr.
}