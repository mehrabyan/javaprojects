package seebattle.allmanus;

import seebattle.GameManager;

public class StartSeans {

	public void startSeans(String st) throws java.io.IOException {
		GameManager gm = new GameManager();
			
			switch (st) {

			case "Comp vs Comp":
				gm.gameCompVsComp();
				break;
			case "Comp vs Human":
				gm.gameCompVsHuman();
				break;
			case "Human vs Human":
				gm.gameHumanVsHuman();
				break;
			}

		gm.initGameData();
		gm.naabordaj();
		gm.statistics();
		
//		toMainMenu();
//			int tp = System.in.read();
//			switch (tp) {
//			
//			case '1':
//				Terminal tm = new Terminal();
//				tm.mainChoose();
//				chooseType();
//				break;
//			case '2':
//				System.exit(0);
			}
	
	public void exitGame(String ex) {
		System.exit(0);
	}
	
	public void toMainMenu() {
		System.out.println();
		System.out.println("Press enter for back to Main Menu");
	}
}