package seebattle;

import java.util.Random;

public class CompPlayer extends Player {
	CompPlayer(String name) {
		super(name);
	}

	@Override
  public Coordinate pli() {
		Coordinate c;
		int plicoordind;
		Random coordind = new Random();
		plicoordind = coordind.nextInt(getTargetForShot().size());
		c = getTargetForShot().get(plicoordind);
		getShotHistory().add(c);
		getTargetForShot().remove(c);
		return c;
  }
}