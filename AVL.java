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
	
	public boolean insert(String key) {
		
		if(key == null)
			throw new NullPointerException();
		
		if(root == null) {
			root = new Node(key);
			return true;
		}
		
		return insert(key, root);
	}
	
	public boolean insert(String key, Node parent) {
		
		String parentKey = parent.getKey();
		Node current;
		
		if(key.equals(parentKey))
			throw new IllegalArgumentException("A duplicated key was inserted.");
		
		int compare = key.compareTo(parentKey);
		
		if(compare < 0) {
			
			current = parent.getLeftChild();
			
			if(current == null) {
				parent.setLeftChild(new Node(key));
				return true;
			}
			
			else {
				return insert(key, current);
			}
			
		}
		
		else if(compare > 0) {
			
			current = parent.getRightChild();
			
			if(current == null) {
				parent.setRightChild(new Node(key));
				return true;
			}
			
			else{
				return insert(key , current);
			}
			
		}		
		
		return false;
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	public void inOrder(Node node) {
		if (node == null)
			return;
		
	    inOrder(node.getLeftChild());
	    System.out.println(node);
	    inOrder(node.getRightChild());
	}
	
}
