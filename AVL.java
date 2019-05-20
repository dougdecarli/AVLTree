package tradutor;

import java.util.ArrayList;
import java.util.List;

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
	
	public Node search(String key) {
	    Node current = root;

	    while (current != null) {
	        int comparison = key.compareTo(current.getKey());
	        if (comparison == 0) {
	            return current;
	        } else if (comparison < 0) {
	            current = current.getLeftChild();
	        } else { 
	            current = current.getRightChild();
	        }
	    }

	    return null;
	}
	
	public List<Dicionario> getDicionario() {
    	List<Dicionario> dicionario = new ArrayList<Dicionario>();
    	
    	Node current = root;
    	
    	if(current != null)
    		dicionario.add(current.getDicionario());
 	    
 	    while(current != null) {
 	    	
 	    	if(current.getLeftChild() != null) {
 	    		dicionario.add(current.getLeftChild().getDicionario());
 	    		current = current.getLeftChild();
 	    	}
 	    	
 	    	else if(current.getRightChild() != null) {
 	    		dicionario.add(current.getRightChild().getDicionario());
 	    		current = current.getRightChild();
 	    	}
 	    	
 	    	else
 	    		return dicionario;
 	    		
 	    }
 	    
 	    return null;
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
	
    public void inOrder() {
        inOrder(this.root);
    }
    
    private void inOrder(Node node) {
        if (node != null)
        {
            inOrder(node.getLeftChild());
            System.out.println(node.getDicionario() + " " + node.getBalanceFactor());
            inOrder(node.getRightChild());
        }
    }
    
    public void rsd() {
    	
    }
    
}
