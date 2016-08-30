package seebattle;

public class Startgame {
	GameManager gm;
	public static void main(String[] args) 
	  throws java.io.IOException {
    	GameManager gm = new GameManager();
    	
    	gm.createEmptyField();
		gm.setShips();
		gm.Naabordaj();
	  }
}