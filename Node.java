package tradutor;

public class Node {

	public String key;
	Node parentNode;
	Node leftChild;
	Node rightChild;
	int heigth;
	
	Node(String key){
		this.key = key;
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
	
}
