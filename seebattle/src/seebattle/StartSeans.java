package seebattle;

public class StartSeans {

	public void startSeans()  
			throws java.io.IOException {
	GameType gt = new GameType();
	gt.chooseType();
	GameManager gm = new GameManager();
	char type;
	
	do {
		type = (char) System.in.read();
			switch (type) {
	      
			case '1' :
				gm.gameCompVsComp();
				break;
			case '2' :
				gm.gameCompVsHuman();
				break;
			case '3' :
				gm.gameHumanVsHuman();
				break;
			}
	} while(! ((type == '1') | (type == '2') | (type == '3')));
	
	gm.initGameData();
	gm.naabordaj();
	gm.statistics();
  }

//public static void main(String[] args) 
//		throws java.io.IOException {
//	StartSeans ss1 = new StartSeans();
//	ss1.startSeans();
// }
}