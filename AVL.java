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
	
	public boolean insert(Dicionario dicionario) {
		if(dicionario == null)
			throw new NullPointerException();
		
		if(root == null) {
			root = new Node(dicionario);
			System.out.println("Root " + dicionario.getPalavra() + " ("  + dicionario + ") inserted");
			return true;
		}
		
		return insert(dicionario, root);
	}
	
	public boolean insert(Dicionario dicionario, Node node) {
		
		Node current;
		String parentKey = node.getKey();
		
		String key = dicionario.getPalavra();
		
		if(key.equals(parentKey))
			throw new IllegalArgumentException("A duplicated key was inserted.");
		
		int compare = key.compareTo(parentKey);
		
		if(compare < 0) {			
			current = node.getLeftChild();
			
			if(current == null) {
				node.setLeftChild(new Node(dicionario));
				System.out.println("Node " + dicionario.getPalavra() + " (" + dicionario + ") inserted as a left child of Node " + node.getKey());
				return true;
			}		
			else
				return insert(dicionario, current);			
		}
		
		else if(compare > 0) {			
			current = node.getRightChild();
			
			if(current == null) {
				node.setRightChild(new Node(dicionario)); 
				System.out.println("Node " + dicionario.getPalavra() + " (" + dicionario + ") inserted as a right child of Node " + node.getKey());
				return true;			
			}			
			else
				return insert(dicionario, current);
		}		
		
		return false;
	}	
	
	public boolean insert(String key) {
		
		if(key == null)
			throw new NullPointerException();
		
		if(root == null) {
			System.out.println("Root " + key + " inserted");
			root = new Node(key);
			return true;
		}
		
		return insert(key, root);
	}
	
	public boolean insert(String key, Node node) {
		
		Node current;
		String parentKey = node.getKey();
		
		if(key.equals(parentKey))
			throw new IllegalArgumentException("A duplicated key was inserted.");
		
		int compare = key.compareTo(parentKey);
		
		if(compare < 0) {			
			current = node.getLeftChild();
			
			if(current == null) {
				node.setLeftChild(new Node(key));
				System.out.println("Node " + key + " inserted as a left child of Node " + node.getKey());
				return true;
			}		
			else {
				return insert(key, current);	
			}
		}
		
		else if(compare > 0) {			
			current = node.getRightChild();
			
			if(current == null) {
				node.setRightChild(new Node(key)); 
				System.out.println("Node " + key + " inserted as a right child of Node " + node.getKey());
				return true;			
			}			
			else {
				return insert(key , current);
			}
		}		
		
		return false;
	}
	
    public void inOrder() {
        inOrder(this.root);
    }
    
    private void inOrder(Node node) {
        if (node != null)
        {
            inOrder(node.getLeftChild());
            System.out.println(node.getKey() + " " + node.calculateBalanceFactor());
            inOrder(node.getRightChild());
        }
    }
    
}
