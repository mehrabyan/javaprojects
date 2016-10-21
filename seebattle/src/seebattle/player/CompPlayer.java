package seebattle.player;

import java.util.Random;

import seebattle.fieldandships.Coordinate;

public class CompPlayer extends Player {
	public CompPlayer(String name) {
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