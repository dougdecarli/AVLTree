package tradutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Tradutor {
	
	AVL avl;
	
	protected void carregaDicionario(String filepath) throws IOException {			
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
			String line;
			String[] palavras;
			
			this.avl = new AVL();
			
			while((line = br.readLine()) != null) {
				palavras = line.split("#");				
				Dicionario dicionario = new Dicionario(palavras);				
				this.avl.insert(dicionario);
			}	
		} 		
	}
	
	public List<String> traduzPalavra(String palavra) {
		if(palavra == null)
			throw new IllegalArgumentException("Empty search argument.");
		
		return this.avl.search(palavra).getDefinicoes();		
	}
	
	public void insereTraducao(String palavra, List<String> definicoes) {
		Dicionario novaTraducao = new Dicionario(palavra, definicoes);
		this.avl.insert(novaTraducao);
	}
	
	public void salvaDicionario(String filepath) {
		
	}
	
	public void mostrarDicionario() {
		this.avl.inOrder();
	}
}
