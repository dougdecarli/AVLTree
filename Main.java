package tradutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Tradutor tradutor = new Tradutor();
		Teclado teclado = new Teclado();
		
		try {
			tradutor.carregaDicionario("C:\\Users\\i871294\\Desktop\\dicionario.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		System.out.println(tradutor.traduzPalavra("close"));		
		List<String> defs = new ArrayList<String>();		
		defs.add("tipos");defs.add("de");defs.add("carinha");defs.add("sao");	
		tradutor.insereTraducao("d", defs);
		tradutor.mostrarDicionario();		
	}
}
