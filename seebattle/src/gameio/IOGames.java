package gameio;

import java.io.*;
import java.util.*;

public class IOGames {
	
	public void saveGame() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please,enter your name ");
		String name = scan.nextLine();
	File dirpath = new File("src/savedgames/"+name);
	boolean created = dirpath.mkdir();
	if (created)
		System.out.println("The directory /" + name +" successfully created");
	scan.close();
	
	}
}
