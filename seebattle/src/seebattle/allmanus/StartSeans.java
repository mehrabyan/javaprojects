package seebattle.allmanus;

import seebattle.GameManager;

public class StartSeans {

	public void startSeans(String st) throws java.io.IOException {
		GameManager gm = new GameManager();
			
			switch (st) {

			case "Comp vs Comp":
								gm.gameCompVsComp();
								System.out.println("You choose game type : Comp vs Comp");
								break;
								
			case "Comp vs Human":
								gm.gameCompVsHuman();
								System.out.println("You choose game type : Comp vs Human");
								break;
								
			case "Human vs Human":
								gm.gameHumanVsHuman();
								System.out.println("You choose game type : Human vs Human");
								break;
								
			default :
				break;
			}

		gm.initGameData();
		gm.naabordaj();
		gm.statistics();
		
			}

}