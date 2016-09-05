package seebattle;

public class Startgame {
	
	public static void main(String[] args) 
	  throws java.io.IOException {
		GameManager gm = new GameManager();
    	
    	gm.startGame();
    	gm.naabordaj();
    	gm.statistics();
	}
}