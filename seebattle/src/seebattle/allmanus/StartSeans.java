package seebattle.allmanus;

import seebattle.GameManager;

public class StartSeans {

	public void startSeans(int type) throws java.io.IOException {
		GameManager gm = new GameManager();

		do {
			switch (type) {

			case 1:
				gm.gameCompVsComp();
				break;
			case 2:
				gm.gameCompVsHuman();
				break;
			case 3:
				gm.gameHumanVsHuman();
				break;
			}
		} while (!((type == 1) || (type == 2) || (type == 3)));

		gm.initGameData();
		gm.naabordaj();
		gm.statistics();
		
		toMainMenu();
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
	
	public void toMainMenu() {
		System.out.println();
		System.out.println("Press enter for back to Main Menu");
	}

}