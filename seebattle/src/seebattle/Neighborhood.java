package seebattle;

import java.util.ArrayList;
import java.util.List;

public class Neighborhood {
	Coordinate c;
	Shipsfield field;
	private List<Coordinate> environment = new ArrayList<Coordinate>();
	
	public void makeEnvironment(Coordinate c) {
		
		environment.add(c.upperCornerLeft());
		environment.add(c.previousInColm());
		environment.add(c.upperCornerRight());
		environment.add(c.nextInRow());
		environment.add(c.bottomCornerRight());
		environment.add(c.nextInColm());
		environment.add(c.bottomCornerLeft());
		environment.add(c.previousInRow());
	}

	public List<Coordinate> getEnvironmet() {
		return environment;
	}

	public void setEnvironment(List<Coordinate> environment) {
		this.environment = environment;
	}

	public boolean checkEnvironment(Coordinate c) {
		int count = 0;
		for(Coordinate coord: environment) {
			if (field.getEmptyFields().contains(coord))
		count++;
		}
		if (count == 8)
			return true;
		else
			return false;
	}
}