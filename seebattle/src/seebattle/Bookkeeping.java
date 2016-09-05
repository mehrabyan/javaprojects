package seebattle;

public class Bookkeeping {
	
// calculate the deadships,
	public void allDeadShips(Shipsfield field1,Shipsfield field2) {
		System.out.println("Player1 destroys " + field2.sizeOfDeadShips() + " ships");
		System.out.println("Player2 destroys " + field1.sizeOfDeadShips() + " ships");
	}
//	list of hit ships 
	public void showHitShips(Shipsfield field1,Shipsfield field2) {
		System.out.println("Player1 has the list of hit ships :" + field1.showHitShips());
		System.out.println("Player2 has the list of hit ships :" + field2.showHitShips());
	}
	
//	calculate shots for each player
	public void showShots(Player player1,Player player2) {
		System.out.println("Player1 makes " + player1.madeShot() + " shots");
		System.out.println("Player2 makes " + player2.madeShot() + " shots");
	}
	
}
