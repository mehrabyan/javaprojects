package seebattle;

import seebattle.fieldandships.Coordinate;
import seebattle.fieldandships.Setships;
import seebattle.fieldandships.Shipsfield;
import seebattle.fieldandships.ShotResult;
import seebattle.player.*;

//import java.util.*;

public class GameManager {
	Setships set = new Setships();
	Player player1, player2, currentPlayer;
	Shipsfield shipsfield1, shipsfield2, currentShipsfield;

	public GameManager() {
		shipsfield1 = new Shipsfield();
		shipsfield1.fillEmptyFields();
		System.out.println("The size of emptyFields after creating shipsfield1 is :" + shipsfield1.sizeOfEmptyFields());
		shipsfield2 = new Shipsfield();
		shipsfield2.fillEmptyFields();
		System.out.println("The size of emptyFields after creating shipsfield2 is :" + shipsfield1.sizeOfEmptyFields());
	}

	public void gameCompVsComp() {
		player1 = new CompPlayer("Player1");
		player2 = new CompPlayer("Player2");
	}

	public void gameCompVsHuman() {
		player1 = new CompPlayer("Player1");
		player2 = new HumanPlayer("Nemo");
	}

	public void gameHumanVsHuman() {
		player1 = new HumanPlayer("Aranaks");
		player2 = new HumanPlayer("Nemo");
	}

	private void initCurrentPlayer() {
		currentPlayer = player1;
		currentShipsfield = shipsfield2;
	}

	private void switchPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
			currentShipsfield = shipsfield1;
		} else {
			currentPlayer = player1;
			currentShipsfield = shipsfield2;
		}
	}

	private void setShips() {
		set.setShip4ForTest(shipsfield1);
		set.setShip3ForTest(shipsfield1);
		set.setShip2ForTest(shipsfield1);
		set.setShip1ForTest(shipsfield1);
		System.out.println(
				"The size of emptyFields after ships seting on the shipsfield1 is :" + shipsfield1.sizeOfEmptyFields());
		System.out.println("The blocks :" + shipsfield1.toString());

		set.setShip4ForTest(shipsfield2);
		set.setShip3ForTest(shipsfield2);
		set.setShip2ForTest(shipsfield2);
		set.setShip1ForTest(shipsfield2);
		System.out.println(
				"The size of emptyFields after ships seting on the shipsfield2 is :" + shipsfield2.sizeOfEmptyFields());
		System.out.println("The blocks :" + shipsfield2.toString());
	}

	public void initGameData() {
		initCurrentPlayer();
		setShips();
	}

	// make Game Manager really GM // all functions to flow game
	private ShotResult pliPlayer() {
		Coordinate c;
		c = currentPlayer.pli();
		System.out.println("The target is :" + c.toString());
		return currentShipsfield.checkShot(c);
	}

	public void naabordaj() {
		boolean gameOver = false;
		while (!gameOver) {
			System.out.print(currentPlayer.getName() + " is shooting.");
			switch (pliPlayer()) {

			case HIT:
				System.out.println("The ship is hit, " + currentPlayer.getName() + " continues shooting");
				break;
			case DEAD:
				System.out.println("The ship is dead");
				if (!(currentShipsfield.checkListOfShips() == 0)) {
					System.out.println("Continues shooting");
				} else {
					gameOver = true;
					System.out.println(currentPlayer.getName() + " wins.Game over");
					System.out.println();
				}
				break;

			case MISS:
				System.out.println("The shot miss,switch Player");
				switchPlayer();
				break;
			default:
				break;
			}
		}
	}

	public void statistics() {
		Bookkeeping book = new Bookkeeping();
		book.allDeadShips(shipsfield1, shipsfield2, player1, player2);
		book.showShots(player1, player2);
		book.showHitShips(shipsfield1, shipsfield2, player1, player2);
	}
}