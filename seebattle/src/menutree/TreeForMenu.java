package menutree;

import java.io.IOException;
import java.util.Scanner;

import gameio.IOGames;
import seebattle.allmanus.StartSeans;

public class TreeForMenu extends Tree<String> {

	public Node<String> currentNode, node;

	public boolean isValidPath(String[] path) throws Exception {
		boolean isValid = true;
		Node<String> currentNode = getRootNode();

		if (currentNode == null)
			throw new Exception("Root node can't be null");

		for (String joint : path) {
			currentNode = currentNode.getChildNode(Integer.parseInt(joint));

			if (currentNode == null) {
				isValid = false;
				System.out.println("The path is not valid");
				break;
			}
		}
		return isValid;
	}
	
	@SuppressWarnings("null")
	public void generateMenuForGame() throws Exception {
		TreeForMenu tfm = new TreeForMenu();
		NodesForTree nft = new NodesForTree();
		Scanner scan = new Scanner(System.in);
//		Scanner ss = new Scanner(System.in);

		tfm = nft.generateMenuNodes();
		currentNode = tfm.getRootNode();
		System.out.println("Always enter 0 for back");
		for (Integer i : currentNode.getChildren().keySet()) {
			System.out.println(i + ". " + currentNode.getChildNode(i).getContent());
		}
		do {
			int j = scan.nextInt();
			 if (j > currentNode.getChildren().keySet().size())
			 System.out.println("Enter correct number");
			 else {
				 if (j == 0) {
					 if (currentNode.hasParent()) {
						 currentNode = currentNode.getParent();
						 for (Integer k : currentNode.getChildren().keySet())
							 System.out.println(k + ". " + currentNode.getChildNode(k).getContent());
					 	} else
					 		System.out.println("You are in root");
				 	} else {
				 		currentNode = currentNode.getChildNode(j);
				 			if (!(currentNode.isTerminalNode())) {
				 				for (Integer m : currentNode.getChildren().keySet())
				 					System.out.println(m + ". " + currentNode.getChildNode(m).getContent());
				 				} else {
				 					int i = 0;
				 					String[] nodeContent = new String[3];
				 					do {
				 						
				 						nodeContent[i] = currentNode.getContent();
				 						currentNode = currentNode.getParent();
				 						i++;
				 					} while (currentNode.hasParent());
				 					defUserChoice(nodeContent);	// Write for all purpose
				}
			  }
			}
			 
		} while (true); 
	}
	
	public String[] defUserChoice(String[] content) throws Exception {
//		for(int k = 0; k < content.length; k++)
//				System.out.println(content[k]);
//		define all nesessery methods
		do {
			switch (content[1]) {
			
			case "New game":
				StartSeans ss = new StartSeans(); // not only startSeans
				ss.startSeans(content[0]);
				break;
				
			case "Save game":
				IOGames iog = new IOGames();
				iog.saveGame(content[0]);
				break;
				
			case "Exit":
				System.exit(0);
			}
		
		return content;
		} while(true);
	}
}