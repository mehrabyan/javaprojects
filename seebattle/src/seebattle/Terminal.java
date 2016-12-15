package seebattle;

public class Terminal {
	

	public void mainchoose() throws java.io.IOException {
		MainMenu mm = new MainMenu();
		StartSeans ss = new StartSeans(); 
		mm.menuForGame();
		char choose;
		do { 
			choose = (char) System.in.read();
		switch (choose) {
		case '1' :
			ss.startSeans();
			break;
		case '2' :
//			help menu
			GameHelp gh = new GameHelp();
			gh.gameHelp();
			break;
		case '3' :
//			Exit game
			System.exit(0);
			break;
		 }
		}  while (!((choose == 1) | (choose == 2) | (choose == 3)));
	}
}