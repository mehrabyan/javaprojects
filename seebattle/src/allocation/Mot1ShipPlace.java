package allocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seebattle.fieldsandships.*;

public class Mot1ShipPlace implements ShipsPlaces {
	Random rd1 = new Random();
	StartCoordinates sc = new StartCoordinates();
	ShipsField shipsField;
	List<Coordinate> lc;
	Coordinate c, currentCell;
	public Mot1ShipPlace(ShipsField shF) {
		shipsField = shF;
	}
	
	public int enoughPlace() {
		shipsField.setUnmarkedCells();
		return shipsField.getUnmarkedCells().size();
	}
	
	public List<Coordinate> placeForShip() {
		lc = new ArrayList<Coordinate>();
		shipsField.setUnmarkedCells();
//		int x = rd1.nextInt(shipsField.getUnmarkedCells().size());
		lc.add(shipsField.getUnmarkedCells().get(0));
		return lc;
	}
}