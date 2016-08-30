package seebattle;

//import java.util.*;

public class GameManager {
	Coordinate c;
	Ship ship1,ship2;
	Setships set = new Setships();
	Player player1,player2;
	Shipsfield shipsfield1,shipsfield2;
	Switchshot switchshot;
	GameManager () {
		ship1 = new Ship();
//		player1 = new Player();
//		player2 = new Player();
	    shipsfield1 = new Shipsfield();
	    shipsfield2 = new Shipsfield();
	    switchshot = new Switchshot();
		} //konec konstruktora
	public void createEmptyField () {
		shipsfield1.fillEmptyFields();
		System.out.println("The size of emptyFields after creating shipsfield1 is :" + shipsfield1.sizeOfEmptyFields());
		shipsfield2.fillEmptyFields();
		System.out.println("The size of emptyFields after creating shipsfield2 is :" + shipsfield1.sizeOfEmptyFields());
	}	
	
	public void setShips() {
		set.setShip4ForTest(shipsfield1);
		set.setShip3ForTest(shipsfield1);
		set.setShip2ForTest(shipsfield1);
		set.setShip1ForTest(shipsfield1);
		System.out.println("The size of emptyFields after ships seting on the shipsfield1 is :" + shipsfield1.sizeOfEmptyFields());
		System.out.println("The blocks :" + shipsfield1.toString());
		
		set.setShip4ForTest(shipsfield2);
		set.setShip3ForTest(shipsfield2);
		set.setShip2ForTest(shipsfield2);
		set.setShip1ForTest(shipsfield2);
		System.out.println("The size of emptyFields after ships seting on the shipsfield2 is :" + shipsfield2.sizeOfEmptyFields());
		System.out.println("The blocks :" + shipsfield2.toString());
	}

// player1 start the game
	public void Naabordaj() {
		switchshot.switchToPlayer1();
	}
}