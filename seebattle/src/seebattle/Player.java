// Sozdaem class igrokov
package seebattle;

import java.util.*;

abstract public class Player {
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

	abstract public Coordinate pli();
	
	public List<Coordinate> getTargetForShot() {
		return targetForShot;
	}

	public void setTargetForShot(List<Coordinate> targetForShot) {
		this.targetForShot = targetForShot;
	}

	public List<Coordinate> getShotHistory() {
		return shotHistory;
	}

	public void setShotHistory(List<Coordinate> shotHistory) {
		this.shotHistory = shotHistory;
	}


	public List<Coordinate> showShotHistory() {
		return shotHistory;
	}

	public int sizeOfTargetForShot() {
		return targetForShot.size();
	}

	public int madeShot() {
		return shotHistory.size();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}