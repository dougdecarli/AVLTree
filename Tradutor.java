package tradutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Tradutor {

	
	protected void carregaDicionario(String filepath) throws IOException {
		
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
			
			String line;
			String[] palavras;
			
			AVL avl = new AVL();
			
			while((line = br.readLine()) != null) {
				
				palavras = line.split("#");
				
				Dicionario dicionario = new Dicionario(palavras);
				
				//System.out.println(dicionario);
				
				avl.insert(palavras[0]);
				
			}
			
			avl.inOrder(avl.getRoot());
			
		} 
		
	}
	
	public List<String> traduzPalavra(String palavra) {
		return null;
	}
	
	public void insereTraducao(String palavra, List<String> definicoes) {
		
	}
	
	public void salvaDicionario(String filepath) {
		
	}
	
}
