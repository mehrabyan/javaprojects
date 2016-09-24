// Sozdaem class igrokov
package seebattle;

import java.util.*;

public class Player {
	private String name;
	private List<Coordinate> targetForShot = new ArrayList<Coordinate>();
	private List<Coordinate> shotHistory = new ArrayList<Coordinate>();

	public Player(String name) {
		this.name = name;
		for (int i = 1; i < 9; i++) { // we don't need the coordinate with 0
										// and 9
			for (int j = 1; j < 9; j++) {
				targetForShot.add(new Coordinate(i, j));
			}
		}
	}

	public Coordinate pli() {
		Coordinate c;
		int plicoordind;
		Random coordind = new Random();
		plicoordind = coordind.nextInt(targetForShot.size());
		c = targetForShot.get(plicoordind);
		shotHistory.add(c);
		targetForShot.remove(c);
		// int enter = System.in.read();
		return c;
	}

	public List<Coordinate> showShotHistory() {
		return shotHistory;
	}

	public int sizeOfTargetForShot() {
		return targetForShot.size();
	}

	public int madeShot() {
		return (64 - targetForShot.size());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}