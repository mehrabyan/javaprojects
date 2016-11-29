package seebattle.allmanus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameHelp {

	public void gameHelp() throws IOException {
		String str;
		try (BufferedReader br = new BufferedReader(new FileReader("res/help.txt"))) {
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException exc) {
			System.out.println("The help file not found");
		}
//		System.out.println("Press any key to continue.");
//		System.in.read();
		Terminal terminal = new Terminal();
		terminal.mainChoose();
//		return;/
	}
}