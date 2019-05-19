package tradutor;

public class Node {
	
	private Dicionario dicionario;
	private int balanceFactor;
	private String key;
	private Node parentNode;
	private Node leftChild;
	private Node rightChild;
	
	Node(String key){
		this.key = key;
		this.balanceFactor = 0;
	}
	
	Node(Dicionario dicionario){
		this.dicionario = dicionario;
		this.key = dicionario.getPalavra();
		this.balanceFactor = 0;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public Node getLeftChild() {
		return this.leftChild;
	}
	
	public Node getRightChild() {
		return this.rightChild;
	}
	
	public Node getParent() {
		return this.parentNode;
	}
	
	public void setLeftChild(Node node) {
		this.leftChild = node;
	}
	
	public void setRightChild(Node node) {
		this.rightChild = node;
	}
	
	public void setParentNode(Node node) {
		this.parentNode = node;
	}
	
	public Dicionario getDicionario( ) {
		return this.dicionario;
	}
	
	public boolean isBalanced() {
		this.getBalanceFactor();

		if(this.balanceFactor <= -2 || this.balanceFactor >= 2)
			return false;
		return true;
	}
	
	public String toString() {
		String basic = "Key: " + this.key + "; Parent: " + this.parentNode.getKey() + "; ";
		
		if(this.leftChild == null && this.rightChild == null)
			return basic + "Left Child: null; Right Child = null;";
					
		else if(this.leftChild == null && this.rightChild != null)
			return basic + "Left Child: null; Right Child: " + this.rightChild.getKey() + ";";
			
		else if(this.leftChild != null && this.rightChild == null)
			return basic + "Left Child: " + this.leftChild.getKey() + "; Right Child: null";
		
		return basic + "Left Child: " + this.leftChild.getKey() + "; Right Child: " + this.rightChild.getKey() + ";";		
	}
	
	public int getBalanceFactor() {
		int leftSubtreeHeigth = 0;
		int rightSubtreeHeigth = 0;
		
		Node current = this.getLeftChild();
		
		if(current != null) {
			while(current.getLeftChild() != null || current.getRightChild() != null) {
				if(current.getLeftChild() != null) {
					leftSubtreeHeigth += 1;
					current = current.getLeftChild();
				}
				else if(current.getRightChild() != null) {
					leftSubtreeHeigth += 1;
					current = current.getRightChild();
				}	
			}
		}
		
		current = this.getRightChild();
		
		if(current != null) {
			while(current.getLeftChild() != null || current.getRightChild() != null) {
				if(current.getLeftChild() != null) {
					leftSubtreeHeigth += 1;
					current = current.getLeftChild();
				}
				else if(current.getRightChild() != null) {
					leftSubtreeHeigth += 1;
					current = current.getRightChild();
				}	
			}		
		}
		
		this.balanceFactor = leftSubtreeHeigth - rightSubtreeHeigth;
		
		return this.balanceFactor;		
	}
	
	public int getLeftSubtreeHeigth() {
		return 0;
	}
	
	public int getRightSubtreeHeigth() {
		return 0;
	}
	
}
