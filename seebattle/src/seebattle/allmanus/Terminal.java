package seebattle.allmanus;

public class Terminal {
	String[] mm = { "Please,choose from main menu.", "1 - new game.", "2 - hepl.", "3 - exit game.", };

	public void mainChoose() throws java.io.IOException {
		menuForGame();
		char choose;
		do {
			choose = (char) System.in.read();
			switch (choose) {
			case '1':
				StartSeans ss = new StartSeans();
				ss.startSeans(1);
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
		for (int i = 0; i < mm.length; i++)
			System.out.println(mm[i]);
	}
}