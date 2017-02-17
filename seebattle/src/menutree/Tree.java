package menutree;

public class Tree<T> {
	private Node<T> rootNode = new Node<T>();

	public Node<T> getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node<T> node) {
		this.rootNode = node;
	}
}