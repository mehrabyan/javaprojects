package seebattle.allmanus;

import seebattle.GameManager;

public class StartSeans {

	public void startSeans() throws java.io.IOException {
		chooseType();
		GameManager gm = new GameManager();
		char type;

		do {
			type = (char) System.in.read();
			switch (type) {

			case '1':
				gm.gameCompVsComp();
				break;
			case '2':
				gm.gameCompVsHuman();
				break;
			case '3':
				gm.gameHumanVsHuman();
				break;
			}
		} while (!((type == '1') || (type == '2') || (type == '3')));

		gm.initGameData();
		gm.naabordaj();
		gm.statistics();
		
		playAgain();
		do {
			int tp = System.in.read();
			switch (tp) {
			
			case '1':
				Terminal tm = new Terminal();
				tm.mainChoose();
//				chooseType();
				break;
			case '2':
				System.exit(0);
			}
		} while (!((type == 1) ||(type == 2)));
	}
	
	public void chooseType() {
		System.out.println("Please,enter what type of game you want to play.");
		System.out.println("1 - comp vs comp");
		System.out.println("2 - comp vs human");
		System.out.println("3 - human vs human");
	}

	public void playAgain() {
		System.out.println();
		System.out.println("Do You want to play again?");
		System.out.println("1 - new game.");
		System.out.println();
		System.out.println("2 - exit game.");
	}

}