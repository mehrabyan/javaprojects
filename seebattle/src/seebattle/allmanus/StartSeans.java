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
		
			}

}