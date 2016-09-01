package seebattle;

public class Bookkeeping {
	Player player1,player2;
	Shipsfield field1,field2;
	Ship ship;
	
// class shows the list of deadships,
	public void showAllDeadShips() {
		System.out.println("The list of dead ships for player1 is :" + field1.showDeadShips());
		System.out.println("The list of dead ships for player2 is :" + field2.showDeadShips());
	}
//	list of hit ships 
	public void showHitShips() {
		System.out.println("The list of hit ships for player1 is :" + field1.showHitShips());
		System.out.println("The list of hit ships for player2 is :" + field2.showHitShips());
	}
	
//	list of shot history for each player,calculate shots for each player
	
}
