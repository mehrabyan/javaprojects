package seebattle;

import java.io.*;
public class GameHelp {

	public void gameHelp() throws IOException {
		String str;
		try (BufferedReader br = 
				new BufferedReader(new FileReader("help.txt")))
		{
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch(IOException exc) {
			System.out.println("The help file not found");
		}
		System.out.println("Press any key to continue.");
		System.in.read();
		return;
    	}
}