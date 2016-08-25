package seebattle;

import java.util.Arrays;

public class GameManager {
	Coordinate c;
	Player player1,player2;
	Shipsfield shipsfield1,shipsfield2;
	GameManager () {
		player1 = new Player();
		player2 = new Player();
	    shipsfield1 = new Shipsfield();
	    shipsfield2 = new Shipsfield();
		} //konec konstruktora
	void managermethods () {
		shipsfield1.fillEmptyFields();
//		System.out.println(Arrays.toString(shipsfield1.mptyFields));
		shipsfield2.fillEmptyFields();
//		System.out.println(Arrays.toString(shipsfield2.mptyFields));
		
// player1 shoot,gm check rezult and define who is  next shooter
		ShotResult shres = null; 
		c = player1.pli(shipsfield2);
		if (!(player1.previouseShot.contains(c))){
			
		    player1.previouseShot.add(c);
		    
		    shres = shipsfield2.checkShot(c);
		    switch (shres) {
		    case HIT:
		    	System.out.println("The ship is Hit");
		    	// player1 continues
		    case DEAD:
		    	if (shipsfield2.ships.size() == 0) {
		    		System.out.println("Game over");
// 					Finish game
		    	}
		    	break;
		    case MISS:
		    	c = player2.pli(shipsfield1);
		    	break;
		       }
		   	}
					
      }
}