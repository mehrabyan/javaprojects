package menutree;

import java.util.Scanner;

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

	public void generateMenuForGame() throws Exception {
		TreeForMenu tfm = new TreeForMenu();
		NodesForMenu nfm = new NodesForMenu();
		Scanner scan = new Scanner(System.in);
		Scanner ss = new Scanner(System.in);

		tfm = nfm.generateMenuNodes();
		currentNode = tfm.getRootNode();

		for (Integer i : currentNode.getChildren().keySet()) {
			System.out.println(i + ". " + currentNode.getChildNode(i).getContent());
		}

//		String text;
		do {

			int j = scan.nextInt();
			if (j == 0) {
				if (currentNode.hasParent()) {
					for (Integer k : currentNode.getParent().getChildren().keySet())
						System.out.println(k + ". " + currentNode.getParent().getChildNode(k).getContent());
					currentNode = currentNode.getParent();
				} else
					System.out.println("You are in root");
			} else {
				if (currentNode.isLeaf()) {
					System.out.println("You are in lowest level"); // run methods
					}
				else {
					if (j > currentNode.getChildren().keySet().size())
						System.out.println("Enter correct number");
					else {
							currentNode = currentNode.getChildNode(j);
							for (Integer m : currentNode.getChildren().keySet())
								System.out.println(m + ". " + currentNode.getChildNode(m).getContent());
							}
				}
			  }
			} while (true); //((text = ss.nextLine()) != "quit");
//		 scan.close();
//		 ss.close();
//		 System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		TreeForMenu tfm = new TreeForMenu();

		tfm.generateMenuForGame();
	}
}