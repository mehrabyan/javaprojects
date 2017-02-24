package seebattle;

import java.io.FileWriter;
import java.io.IOException;

import seebattle.fieldsandships.Coordinate;
import seebattle.fieldsandships.SetShips;
import seebattle.fieldsandships.ShipsField;
import seebattle.fieldsandships.ShotResult;
import seebattle.player.CompPlayer;
import seebattle.player.HumanPlayer;
import seebattle.player.Player;

public class GameManager {
	SetShips sets = new SetShips();
	Player player1, player2, currentPlayer;
	ShipsField shipsField1, shipsField2, currentShipsField;

	public GameManager() {
		shipsField1 = new ShipsField();
		System.out.println("The size of emptyFields after creating shipsfield1 is :" + shipsField1.sizeOfEmptyFields());
		shipsField2 = new ShipsField();
		System.out.println("The size of emptyFields after creating shipsfield2 is :" + shipsField1.sizeOfEmptyFields());
	}
	
	private void setShips() {
		sets.correctDislocation(shipsField1);
		shipsField1.removeShipsCoordFromEmptyFields();
		System.out.println(
				"The size of emptyFields after ships location on the shipsfield1 is :" + shipsField1.sizeOfEmptyFields());
		sets.correctDislocation(shipsField2);
		shipsField2.removeShipsCoordFromEmptyFields();
		System.out.println(
				"The size of emptyFields after ships location on the shipsfield2 is :" + shipsField2.sizeOfEmptyFields());
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
		currentShipsField = shipsField2;
	}

	private void switchPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
			currentShipsField = shipsField1;
		} else {
			currentPlayer = player1;
			currentShipsField = shipsField2;
		}
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
		return currentShipsField.checkShot(c);
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
				if (!(currentShipsField.checkListOfShips() == 0)) {
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
		book.allDeadShips(shipsField1, shipsField2, player1, player2);
		book.showShots(player1, player2);
		book.showHitShips(shipsField1, shipsField2, player1, player2);
	}
}