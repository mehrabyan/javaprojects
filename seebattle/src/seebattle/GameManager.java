package seebattle;

//import java.util.*;

public class GameManager {
	Setships set = new Setships();
	Player player1,player2;
	Shipsfield shipsfield1,shipsfield2;
	int ind = 0;
	GameManager () {
		player1 = new Player();
		player2 = new Player();
	    shipsfield1 = new Shipsfield();
	    shipsfield2 = new Shipsfield();
		} //konec konstruktora
	private void createEmptyFields () {
		shipsfield1.fillEmptyFields();
		System.out.println("The size of emptyFields after creating shipsfield1 is :" + shipsfield1.sizeOfEmptyFields());
		shipsfield2.fillEmptyFields();
		System.out.println("The size of emptyFields after creating shipsfield2 is :" + shipsfield1.sizeOfEmptyFields());
	}	
	
	private void setShips() {
		set.setShip4ForTest(shipsfield1);
		set.setShip3ForTest(shipsfield1);
		set.setShip2ForTest(shipsfield1);
		set.setShip1ForTest(shipsfield1);
		System.out.println("The size of emptyFields after ships seting on the shipsfield1 is :" + shipsfield1.sizeOfEmptyFields());
		System.out.println("The blocks :" + shipsfield1.toString());
		
		set.setShip4ForTest(shipsfield2);
		set.setShip3ForTest(shipsfield2);
		set.setShip2ForTest(shipsfield2);
		set.setShip1ForTest(shipsfield2);
		System.out.println("The size of emptyFields after ships seting on the shipsfield2 is :" + shipsfield2.sizeOfEmptyFields());
		System.out.println("The blocks :" + shipsfield2.toString());
	}

	public void startGame() {
		createEmptyFields();
		setShips();
	}
	
//	make Game Manager really GM // all functions to flow game
	private ShotResult pliPlayer(Player player,Shipsfield shipsfield) {
		Coordinate c;
		ShotResult res;
		c = player.pli();
		System.out.println("The target is :" + c.toString());
		return res = shipsfield.checkShot(c);
	}
	
	public void switchPlayer1() {
		System.out.print("Plauer1 is shooting.");
		switch (pliPlayer(player1,shipsfield2)) {
			
		case HIT:
			System.out.println("The ship is hit, Player1 continues shooting");
			switchPlayer1();
			break;
		case DEAD:
			System.out.println("The ship is dead");
			if (!(shipsfield2.checkListOfShips() == 0)) {
				System.out.println("Continues shooting");
			  	switchPlayer1();
			  	break;
			  	}
			else 
			  System.out.println("Player1 wins.Game over");
			  System.out.println();
				ind = 1;
//			  Gameover.functions;
//			  Show all statistic dates about shots,dead and hit ships
				break;
		  	
		case MISS:
			System.out.println("The shot miss,switch Player");
			switchPlayer2();
			break;
		default:
			break;
	   }
	}	
	
	public void switchPlayer2() {
		System.out.print("Plauer2 is shooting.");
		switch (pliPlayer(player2,shipsfield1)) {
			
		case HIT:
			System.out.println("The ship is hit, Player2 continues shooting");
			switchPlayer2();
			break;
		case DEAD:
			System.out.println("The ship is dead");
			if (!(shipsfield1.checkListOfShips() == 0)) {
				System.out.println("Continues shooting");
			  	switchPlayer2();
			  	break;
			  	}
			else
			  System.out.println("Player2 wins.Game over");
			  System.out.println();
				ind = 1;
//			  Gameover.functions;
//			  Show all statistic dates about shots,dead and hit ships
			
			  break;
		  	
		case MISS:
			System.out.println("The shot miss,switch Player");
			switchPlayer1();
			break;
		default:
			break;
	   }
	}	
	public void naabordaj() {
		do {
		switchPlayer1();
		} while (!(ind == 1));
	}		
	
	public void statistics() {
		Bookkeeping book = new Bookkeeping();
		book.allDeadShips(shipsfield1, shipsfield2);
		book.showShots(player1, player2);
		book.showHitShips(shipsfield1, shipsfield2);
		
	}
}