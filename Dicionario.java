package tradutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dicionario {
	
	protected String palavra;
	protected LinkedList<String> definicoes;
	
	public Dicionario(String[] palavras) {
		this.definicoes = new LinkedList<String>();
		
		this.palavra = palavras[0];
		
		for(int i=1; i<palavras.length;i++)
			this.definicoes.add(palavras[i]);
	}
	
	public Dicionario(String palavra, List<String> definicoes) {
		this.definicoes = new LinkedList<String>();
		
		this.palavra = palavra;
		
		for(int i=0; i<definicoes.size(); i++)
			this.definicoes.add(definicoes.get(i));
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
		String str = this.palavra;
		
		for(int i=0; i<this.definicoes.size();i++)
			str += "#" + this.definicoes.get(i);		
		
		return str;
	}
	
}
