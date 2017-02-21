package menutree;

import java.util.Map;
import java.util.TreeMap;

public class Node<T> {
	private T content;
	private Node<T> parent;
	private Map<Integer, Node<T>> children = new TreeMap<Integer, Node<T>>();

	public Node() {
	}

	public Node(T content) {
		this.content = content;
	}

	public T getContent() {
		return content;
	}
	
	public Integer getKey() {
		Node<String> node =new Node<String>();//что хотим найти
		for (Integer key : children.keySet()) {
		    Node<T> nd = children.get(key);
		    if (key != null) {
		        if (node.equals(nd)) {
		            return key; // нашли наше значение и возвращаем  ключ
	           }
		    }
		}
		return null;
	}

	public void setContent(T content) {
		this.content = content;
	}
	
	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	public boolean hasParent() {
		return getParent() != null;
	}


	public Map<Integer, Node<T>> getChildren() {
		return children;
	}

	public Node<T> getChildNode(int i) {
		return children.get(i);
	}

	public void setChildren(Map<Integer, Node<T>> children) {
		this.children = children;
		// addChildNode(node);
		for (Node<T> node : children.values())
			node.setParent(this);
	}

	public void addChildNode(Integer i,Node<T> node) {
		if (node != null && !children.values().contains(node)) {
				children.put(i, node);
			node.setParent(this);
		}
	}
	
	public boolean isTerminalNode() {
		return getChildren().isEmpty();

	}
	
//	public Integer getNodeKye() {
//		return 1;
//	}
	
}