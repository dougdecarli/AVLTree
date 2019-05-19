package tradutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dicionario {
	
	protected String palavra; //Key
	protected LinkedList<String> definicoes;
	
	public Dicionario(String[] palavras) {
		definicoes = new LinkedList<String>();
		
		this.palavra = palavras[0];
		
		for(int i=1; i<palavras.length;i++)
			this.definicoes.add(palavras[i]);
	}
	
	public String getPalavra() {
		return this.palavra;
	}
	
	public List<String> getDefinicoes() {
		List<String> definicoes = new ArrayList<String>(this.definicoes.size());
		
		for(int i = 0; i<this.definicoes.size(); i++) {
			definicoes.add(this.definicoes.get(i));
		}
		
		return definicoes;
	}
	
	public String toString() {
		String str = "Palavra: " + this.palavra + " Definicoes:";
		
		for(int i=0; i<this.definicoes.size();i++)
			str += " " + definicoes.get(i);		
		
		return str;
	}
	
}
