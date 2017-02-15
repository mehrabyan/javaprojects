package seebattle;

import java.io.FileWriter;
import java.io.IOException;

import seebattle.fieldsandships.Coordinate;
import seebattle.fieldsandships.NewSetShips;
import seebattle.fieldsandships.ShipsField;
import seebattle.fieldsandships.ShotResult;
import seebattle.player.CompPlayer;
import seebattle.player.HumanPlayer;
import seebattle.player.Player;

//import java.util.*;

public class GameManager {
//	SetShips set = new SetShips();
	NewSetShips newSetShips = new NewSetShips();
	Player player1, player2, currentPlayer;
	ShipsField shipsField1, shipsField2, currentShipsField;

	public GameManager() {
		shipsField1 = new ShipsField();
//		newSet.initTempForShipsSet(shipsField1);
		System.out.println("The size of emptyFields after creating shipsfield1 is :" + shipsField1.sizeOfEmptyFields());
		shipsField2 = new ShipsField();
//		newSet.initTempForShipsSet(shipsField2);
		System.out.println("The size of emptyFields after creating shipsfield2 is :" + shipsField1.sizeOfEmptyFields());
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

	private void setShips() {
//		set.setShip4ForTest(shipsfield1);
//		set.setShip3ForTest(shipsfield1);
//		set.setShip2ForTest(shipsfield1);
//		set.setShip1ForTest(shipsfield1);
		newSetShips.setShp(shipsField1);
		System.out.println(
				"The size of emptyFields after ships seting on the shipsfield1 is :" + shipsField1.sizeOfEmptyFields());
//		System.out.println("The blocks of ships in field1 :" + shipsField1.getShipsEnvironment().toString());
		try (FileWriter writer = new FileWriter("res/Shipsfield.txt", true)) {
			String text = "The blocks of ships in field1 :" + shipsField1.toString();
			
			writer.write(text);
			
			writer.append('\n');

			writer.flush();
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}


//		set.setShip4ForTest(shipsfield2);
//		set.setShip3ForTest(shipsfield2);
//		set.setShip2ForTest(shipsfield2);
//		set.setShip1ForTest(shipsfield2);
//		newSetShips.setShp(shipsField2);
//		System.out.println(
//				"The size of emptyFields after ships seting on the shipsfield2 is :" + shipsField2.sizeOfEmptyFields());
//		System.out.println("The blocks of ships in field2 :" + shipsField2.toString());
//		try (FileWriter writer = new FileWriter("res/Shipsfield.txt", true)) {
//			String text = "The blocks of ships in field2 :" + shipsField2.toString();
			
//			writer.write(text);
			
//			writer.append('\n');

//			writer.flush();
//		} catch (IOException ex) {

//			System.out.println(ex.getMessage());
//		}
	}

	public void initGameData() {
		initCurrentPlayer();
		setShips();
//		newSet.printShipEnvironment(shipsField1);
//		newSet.printShipEnvironment(shipsField2);
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