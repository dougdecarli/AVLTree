package tradutor;

import java.util.LinkedList;

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
	
	public String[] getDefinicoes() {
		String[] definicoes = null;
		
		for(int i = 0; i<this.definicoes.size(); i++) {
			definicoes[i] = this.definicoes.get(i);
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
