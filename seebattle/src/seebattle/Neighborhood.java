package seebattle;

import java.util.ArrayList;
import java.util.List;

public class Neighborhood {
	Coordinate c;
	Shipsfield field;
	private List<Coordinate> environment = new ArrayList<Coordinate>();
	
	public void makeEnvironment(Coordinate c) {
		
		for(int i = -1;i < 2;i++) {
			c = new Coordinate(c.getX() + i,c.getY() - 1);
			environment.add(c);
		}
		for(int i = -1;i < 2;i++) {
			c = new Coordinate(c.getX() + i,c.getY() + 1);
			environment.add(c);
		}
		environment.add(c.previousInRow());
		environment.add(c.nextInRow());
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