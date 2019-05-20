package tradutor;

import java.util.ArrayList;
import java.util.List;

public class AVL {
	
	private Node root;
	
	public AVL() {
		this.root = null;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public boolean insert(Dicionario dicionario) {
		if(dicionario == null)
			throw new NullPointerException("Empty dictionary being added!");
		
		if(this.root == null) {
			this.root = new Node(dicionario);
			return true;
		}
		
		return insert(dicionario, this.root);
	}
	
	private boolean insert(Dicionario dicionario, Node node) {	
		Node child;
		String currentKey = node.getKey();
		String key = dicionario.getPalavra();
		
		if(key.equals(currentKey))
			throw new IllegalArgumentException("A dictionary with the " + currentKey + " already exists!");
		
		int compare = key.compareTo(currentKey);
		
		if(compare < 0) {			
			child = node.getLeftChild();
			
			if(child == null) {
				node.setLeftChild(new Node(dicionario));
				return true;
			}		
			else
				return insert(dicionario, child);			
		}
		
		else if(compare > 0) {			
			child = node.getRightChild();
			
			if(child == null) {
				node.setRightChild(new Node(dicionario)); 
				return true;			
			}			
			else
				return insert(dicionario, child);
		}				
		return false;
	}	
    
    public Dicionario search(String palavra) {
    	if(palavra == null || this.root == null)
    		throw new NullPointerException();
    	
    	return search(palavra, root);
    }
    
    private Dicionario search(String palavra, Node node) {    	
    	String nodeKey = node.getKey();
    	Node child;
    	
    	if(palavra.equals(node.getKey()))
    		return node.getDicionario();
    	
    	int compare = palavra.compareTo(node.getKey());
    	
    	if(compare < 0)
    		return search(palavra, node.getLeftChild());
    	
    	if(compare > 0)
    		return search(palavra, node.getRightChild());
      	
		return null;	
    }

    public void inOrder() {
        inOrder(this.root);
    }
    
    private void inOrder(Node node) {
        if (node != null){
            inOrder(node.getLeftChild());
            //System.out.println(node.getDicionario() + " " + node.getBalanceFactor());
            inOrder(node.getRightChild());
        }
    }
    
    public List<String> getDicionario() {  	
    	List<String> dicionario = new ArrayList<String>();  	
        inOrderGetContent(this.root, dicionario);
        return dicionario;
    }
    
    private void inOrderGetContent(Node node, List<String> dicionario) {
        if (node != null){
            inOrderGetContent(node.getLeftChild(), dicionario);         
            dicionario.add(node.getDicionario().toString());
            inOrderGetContent(node.getRightChild(), dicionario);
        }
    }    
    
}
