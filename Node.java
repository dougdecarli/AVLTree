package tradutor;

public class Node {

	public String key;
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
	
	public void setLeftChild(Node node) {
		this.leftChild = node;
	}
	
	public void setRightChild(Node node) {
		this.rightChild = node;
	}
	
}
