package allocation;

import java.util.*;
import seebattle.fieldsandships.*;

public class Mot4ShipPlace implements ShipsPlaces {
	Random rd1 = new Random();
	StartCoordinates sc = new StartCoordinates();
	ShipsField shipsField;
	List<Coordinate> lc;
	Coordinate c, currentCell;
	public Mot4ShipPlace(ShipsField shF) {
		shipsField = shF;
	}
	
	public List<Coordinate> placeForShip() {
		lc = new ArrayList<Coordinate>();
		int[] xy ;
		int dir = rd1.nextInt(2);
		xy = sc.statrCoordinateFor4(dir);
		int x = xy[0];
		int y = xy[1];
		
		switch (dir) {
		case 0:
			currentCell = shipsField.getCoordFromEmptyFields(x, y);
//			System.out.println("dir :" + dir + " " + "cell is :" + currentCell);
			lc.add(currentCell);
			for (int i = 0; i < 3; i++) {
				currentCell = shipsField.getNextCoordInRowFromEmptyFields(currentCell);
				lc.add(currentCell);
			}
			break;
		case 1:
			currentCell = shipsField.getCoordFromEmptyFields(x, y);
//			System.out.println("dir :" + dir + " " + "cell is :" + currentCell);
			lc.add(currentCell);
			for (int i = 0; i < 3; i++) {
				currentCell = shipsField.getNextCoordInColmFromEmptyFields(currentCell);
				lc.add(currentCell);
			}
			break;
		}
		return lc;
	}
	
//	public int[] statrCoordinateFor4(int dir) {
//		int[] start = {0,0};
//		int[] x = {1, 3, 4, 5, 6, 8};
//		int[] y = {1, 3, 5};
//		switch (dir) {
//		case 0:
//			start[0] = x[rd1.nextInt(x.length - 1)];
//			start[1] = y[rd1.nextInt(y.length - 1)];
//			break;
//		case 1:
//			start[0] = y[rd1.nextInt(x.length - 1)];
//			start[1] = x[rd1.nextInt(y.length - 1)];
//			break;
//		}
//		return start;
//     }
}