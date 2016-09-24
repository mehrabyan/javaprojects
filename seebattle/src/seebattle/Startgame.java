package seebattle;

public class Startgame {
	
	public static void main(String[] args) 
	  throws java.io.IOException {
		GameType gt = new GameType();
		gt.choosType();
		char type = (char) System.in.read();
		GameManager gm = new GameManager();
		
		switch (type) {
		      
		case '1' :
			gm.gameCvsC();
			break;
		case '2' :
			gm.gameCvsH();
			break;
		default :
			System.out.println("Uncorrect choose");
			break;
		}
    	gm.initGameData();
    	gm.naabordaj();
    	gm.statistics();
	}
}