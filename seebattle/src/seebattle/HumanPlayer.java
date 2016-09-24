package seebattle;

import java.util.*;
//import java.util.regex.MatchResult;

public class HumanPlayer extends Player {
	Coordinate c = new Coordinate();
	int a = 0, b = 0;
//	private List<Coordinate> shotHistory = new ArrayList<Coordinate>();
	HumanPlayer() {
		super("Player2");
	}
 public Coordinate pli() {
	System.out.println("Enter Your target coordinate as (x,y)");
//	System.out.println("Enter coordinate x from 1 to 8");
	 Scanner sc = new Scanner(System.in);
	 a = sc.nextInt();
	 c.setX(a);
//	 System.out.println("Enter coordinate y from 1 to 8");
	 b = sc.nextInt();
	 c.setY(b);
	return c;
 }
 
// public static void main(String[] args) {
//	 HumanPlayer human = new HumanPlayer();
//	 System.out.println("Your targer is " + (human.pli()).toString());
// }
}