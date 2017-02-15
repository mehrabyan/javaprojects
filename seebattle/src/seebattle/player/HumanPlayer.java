package seebattle.player;

import java.util.Scanner;

import seebattle.fieldsandships.Coordinate;

public class HumanPlayer extends Player {
	Coordinate c = new Coordinate();
	int a = 0, b = 0;
	Scanner sc = new Scanner(System.in);

	public HumanPlayer(String name) {
		super(name);
	}

	@Override
	public Coordinate pli() {
		System.out.println("Enter Your target coordinate as (x,y)");
		System.out.println("Enter coordinate x from 1 to 8");

		a = sc.nextInt();
		c.setX(a);
		System.out.println("Enter coordinate y from 1 to 8");
		b = sc.nextInt();
		c.setY(b);
		// sc.close();
		getShotHistory().add(c);
		return c;
	}
}