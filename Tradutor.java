package tradutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Tradutor {
	
	AVL avl;
	
	public Tradutor() {

	}
	
	protected void carregaDicionario(String filepath) throws IOException {
		
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
			
			String line;
			String[] palavras;
			
			this.avl = new AVL();
			
			while((line = br.readLine()) != null) {
				
				palavras = line.split("#");
				
				Dicionario dicionario = new Dicionario(palavras);
				
				//System.out.println(dicionario);
				
				//avl.insert(palavras[0]);
				
				this.avl.insert(dicionario);
				
				this.avl.inOrder();
				System.out.println();
				System.out.println();
				
			}	
		} 
		
	}
	
	public List<String> traduzPalavra(String palavra) {
		return null;
	}
	
	public void insereTraducao(String palavra, List<String> definicoes) {
		
	}
	
	public void salvaDicionario(String filepath) {
		
	}
	
	public void mostrarDicionario() {
		this.avl.inOrder();
	}
	
}
