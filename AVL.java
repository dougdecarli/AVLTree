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
	
	public List<String> getAllDicionarios() {  	
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
	
	public boolean insert(Dicionario dicionario, String palavra) {
		if(dicionario == null)
			throw new NullPointerException();
		
		if(root == null) {
			root = new Node(dicionario);
			System.out.println("Root " + dicionario.getPalavra() + " ("  + dicionario + ") inserted");
		}
		
		root = insert(dicionario, palavra, root);
		
		return true;
	}
	
	public Node insert(Dicionario dicionario, String palavra, Node node) {
		
		//Adiciona novo nodo
		if( node == null )
			 node = new Node(dicionario);
		
		int compare = palavra.compareTo(node.getKey());
		
		//Percorre arvore ate achar um nodo null, e então adiciona nodo		
		if(compare < 0) {			
			node.leftChild = insert(dicionario, palavra, node.leftChild);		
		}
		else if(compare > 0) {			
			node.rightChild = insert(dicionario, palavra, node.rightChild);	
		}		
		
		//Balanceia nodo atual
		node = balance(node);
		
		return node;
	}	
	
	//Balanceamento da arvore AVL
	public Node balance (Node node) {
		//Verifica valor do fator de cada nodo
        if (getFactor(node) == 2) {
                if (getFactor(node) > 0) 
                	node = rightRotation(node);
                else 
                	node = doubleRightRotation(node);
        }
        else if (getFactor(node) == -2 ) {
        	if (getFactor(node) < 0) 
                	node = leftRotation(node);
                else 
                	node = doubleLeftRotation(node);
        }
        node.height = maiorAltura( getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
        return node;
    }
	
	//Retorna altura da arvore
	private static int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }
	
	//Retorna fator de balanceamento
	private int getFactor (Node t) {
        return getHeight( t.leftChild ) - getHeight( t.rightChild );
    }
	
	//Retorna o maior valor ente as sub arvores leftHeight e rightHeight.
    private static int maiorAltura( int leftHeight, int rightHeight ) {
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
    
    //Faz Rotação simples a direita */
    private static Node rightRotation(Node k2) {
        Node k1 = k2.leftChild;
        k2.leftChild = k1.rightChild;
        k1.rightChild = k2;
        k2.height = maiorAltura( getHeight(k2.leftChild), getHeight(k2.rightChild) ) + 1;
        k1.height = maiorAltura( getHeight(k1.leftChild), k2.height) + 1;
        return k1;
    }
    
    //Rotação simples à esquerda */
    private static Node leftRotation(Node k1) {
        Node k2 = k1.rightChild;
        k1.rightChild = k2.leftChild;
        k2.leftChild = k1;
        k1.height = maiorAltura( getHeight( k1.leftChild ), getHeight( k1.rightChild ) ) + 1;
        k2.height = maiorAltura( getHeight( k2.rightChild ), k1.height ) + 1;
        return k2;
    }
    
    //Rotação dupla à direita */
    private static Node doubleRightRotation( Node k3 ) {
        k3.leftChild = leftRotation( k3.leftChild );
        return rightRotation( k3 );
    }
    
    //Rotação dupla à esquerda */
    private static Node doubleLeftRotation(Node k1) {
        k1.rightChild = rightRotation(k1.rightChild);
        return leftRotation(k1);
    }
	
    public void inOrder() {
        inOrder(this.root);
    }
    
    private void inOrder(Node node) {
        if (node != null)
        {
            inOrder(node.getLeftChild());
            System.out.println(node.getDicionario() + " " + getFactor(node));
            inOrder(node.getRightChild());
        }
    }
    
    
    
}
