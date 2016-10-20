package seebattle.allmanus;

public class Terminal {

	protected void mainChoose() throws java.io.IOException {
		menuForGame();
		char choose;
		do {
			choose = (char) System.in.read();
			switch (choose) {
			case '1':
				StartSeans ss = new StartSeans();
				ss.startSeans();
				break;
			case '2':
				// help menu
				GameHelp gh = new GameHelp();
				gh.gameHelp();
				break;
			case '3':
				// Exit game
				System.exit(0);
			}
		} while (!((choose == '1') || (choose == '2') || (choose == '3')));

	}

	private void menuForGame() {
		System.out.println("Please,choose from main menu.");
		System.out.println("1 - new game.");
		System.out.println();
		System.out.println("2 - hepl.");
		System.out.println();
		System.out.println("3 - exit game.");
		System.out.println();
	}

	
}