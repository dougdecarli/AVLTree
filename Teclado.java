package tradutor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
				
				this.avl.insert(dicionario);
				
				this.avl.inOrder();
				System.out.println();
				System.out.println();
				
			}	
		} 
		
	}
	
	public List<String> traduzPalavra(String palavra) {
		
		Node n = avl.search(palavra);
		
		if(n != null) {
			int length = n.getDicionario().getDefinicoes().size();
			List<String> definicoes = new ArrayList<String>(length);
			
			for(int i = 0; i < length; i++) {
				definicoes.add(n.getDicionario().getDefinicoes().get(i));
			}
			
			return definicoes;
		}
	
		
		return null;
	}
	
	public void insereTraducao(String palavra, List<String> definicoes) {
		//Array de palavra + traducoes para realizar o insert
		String[] palavras = new String[definicoes.size() + 1];
		
		palavras[0] = palavra;
		for(int i = 0; i < definicoes.size(); i++)
			//palavras já foi inicializado com palavra
			palavras[i+1] = definicoes.get(i);
		
		Dicionario dicionario = new Dicionario(palavras);
		this.avl.insert(dicionario);
		this.avl.inOrder();
		
	}
	
	public void salvaDicionario(String filepath) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
			List<Dicionario> dicionario = new ArrayList<Dicionario>(avl.getDicionario());
			
			for (int i = 0; i < dicionario.size(); i++) {
				bw.write(dicionario.get(i).toString());
				bw.newLine(); 
			}
		}
	
	}
	
	public void mostrarDicionario() {
		this.avl.inOrder();
	}
	
}
