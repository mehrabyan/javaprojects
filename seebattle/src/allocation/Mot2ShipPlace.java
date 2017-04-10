package allocation;
import java.util.*;
import seebattle.fieldsandships.*;

public class Mot2ShipPlace implements ShipsPlaces {
		Random rd1 = new Random();
		StartCoordinates sc = new StartCoordinates();
		ShipsField shipsField;
		List<Coordinate> lc;
		Coordinate c, currentCell;
		public Mot2ShipPlace(ShipsField shF) {
			shipsField = shF;
		}
		public List<Coordinate> placeForShip() {
			lc = new ArrayList<Coordinate>();
			int[] xy ;
			int dir = rd1.nextInt(2);
			int i = 0;
			boolean validPlace = false;
			while (!validPlace) {
				xy = sc.statrCoordinateFor2(dir);
				int x = xy[0];
				int y = xy[1];
			currentCell = shipsField.getCoordFromEmptyFields(x, y);
				switch (dir) {
						case 0 :
								for (i = 0; i < 2; i++) {
									if (currentCell.isMarked()) {
										lc.removeAll(lc);
											break;
									} else {
								lc.add(currentCell);
									currentCell = shipsField.getNextCoordInRowFromEmptyFields(currentCell);
								}
							}
								break;
								
						case 1 :
								for (i = 0; i < 2; i++) {
									if (currentCell.isMarked()) {
										lc.removeAll(lc);
											break;
									} else {
								lc.add(currentCell);
								currentCell = shipsField.getNextCoordInColmFromEmptyFields(currentCell);
						}
					}
								break;
				}
				if (lc.size() == 2) {
					validPlace = true;
				}
			}
			return lc;
		}
}