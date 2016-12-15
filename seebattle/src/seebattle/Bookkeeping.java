import seebattle.fieldsandships.ShipsField;
import seebattle.player.Player;

public class Bookkeeping {

	// calculate the deadships,
	public void allDeadShips(ShipsField field1, ShipsField field2, Player player1, Player player2) {
		System.out.println(player1.getName() + " destroys " + field2.sizeOfDeadShips() + " ships");
		System.out.println(player2.getName() + " destroys " + field1.sizeOfDeadShips() + " ships");
	}

	// list of hit ships
	public void showHitShips(ShipsField field1, ShipsField field2, Player player1, Player player2) {
		System.out.println(player1.getName() + " has hit ships " + field1.showHitShips());
		System.out.println(player2.getName() + " has hit ships " + field2.showHitShips());
	}

	// calculate shots for each player
	public void showShots(Player player1, Player player2) {
		System.out.println(player1.getName() + " made " + player1.madeShot() + " shots");
		System.out.println(player2.getName() + " made " + player2.madeShot() + " shots");
	}

}