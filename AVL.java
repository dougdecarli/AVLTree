package tradutor;

public class AVL {
	
	private Node root;
	
	public AVL() {
		this.root = null;
	}
	
	public AVL(String key) {
		this.root = new Node(key);
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public void insert(String key) {
		Node current = root;
		Node parent = current;
		
		if(root == null) {
			root = new Node(key);
		}
		else {
			while(current != null && key != current.getKey()) {
				if(key.compareToIgnoreCase(current.getKey()) < 0) {
					parent = current;
					current = current.getLeftChild();
				}
				else {
					parent = current;
					current = current.getRightChild();
				}
			}
			
			if(key.compareToIgnoreCase(parent.getKey()) < 0 && parent.getLeftChild() == current){
				parent.setLeftChild(new Node(key));
			}
			
			if(key.compareToIgnoreCase(parent.getKey()) > 0 && parent.getLeftChild() == current){
				parent.setRightChild(new Node(key));
			}		
		}
	}
	
	public void inOrder(Node current) {
		if (current == null) {
			System.out.print("null ");
		} else {
			inOrder(current.getLeftChild());
			System.out.print(current.getKey() + " ");
			inOrder(current.getRightChild());
		}
	}
	
}
