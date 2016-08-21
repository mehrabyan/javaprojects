package seebattle;

public class GameManager {
	Coordinate c;
	Player player1,player2;
	Allocetships allocated1,allocated2;
	Target target1,target2;
	Shipsfield shipsfield1,shipsfield2;
	GameManager () {
		player1 = new Player();
		player2 = new Player();
		allocated1 = new Allocetships();
//		allocated2 = new Allocetships();
	    shipsfield1 = new Shipsfield();
	    shipsfield2 = new Shipsfield();
	    target1 = new Target();
	    target2 = new Target();
	} //konec konstruktora
	void managermethods () {
	allocated1.allocet();
//	allocated2.allocet();
	}
}