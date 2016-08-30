package seebattle;

public class Switchshot {
	int enter;
	Coordinate c;
	Player player1,player2;
	Shipsfield shipsfield1,shipsfield2;
	
	public Switchshot () {
		c = new Coordinate();
		player1 = new Player();
		player2 = new Player();
		shipsfield1 = new Shipsfield();
		shipsfield2 = new Shipsfield();
	}

	public void switchToPlayer1() {	
		ShotResult res = null;
		c = player1.pli();
		System.out.println("Player1 shoots.Press enter to continue");
		res = shipsfield2.checkShot(c);
		System.out.println(res);
		switch (res) {
			case MISS:
				System.out.println("The shot is miss,Player2 shooting");
				switchToPlayer2();
				break;
				
			case HIT:
				System.out.println("The ship is hit,player1 continues shooting");
				switchToPlayer1();
				break;
				
			case DEAD:
				System.out.println("The ship is dead");
				  if (shipsfield2.checkListOfShips() == 0) {
					  System.out.println("Player1 wins.Game over");
//					  Gameover.functions;
//					  Show all statistic dates about shots,dead and hit ships
					  break; }
				  	System.out.println("Player1 continues shooting");
				  	switchToPlayer1();
				break;
			default:
				break;
		}		
    }
	
	public void switchToPlayer2() {
		ShotResult res = null;
		c = player2.pli();
		System.out.println("Player2 shoots.Press enter to continue");
		res = shipsfield1.checkShot(c);
		switch (res) {
		case MISS:
			System.out.println("The shot is miss,Player2 shooting");
			switchToPlayer1();
			break;
			
		case HIT:
			System.out.println("The ship is hit,player2 continues shooting");
			switchToPlayer2();
			break;
			
		case DEAD:
			System.out.println("The ship is dead");
			  if (shipsfield2.checkListOfShips() == 0) {
				  System.out.println("Player2 wins.Game over");
//				  Gameover.functions;
				  break; }
			  	System.out.println("Player2 continues shooting");
			  	switchToPlayer2();
			 break;
			 
		default:
			break;
		}
	}

}