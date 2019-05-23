package tradutor;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Tradutor tradutor = new Tradutor();
		Teclado t = new Teclado();
		String palavra = "";
		
		try {
			tradutor.carregaDicionario("C:\\Users\\Douglas\\Downloads\\dicionario.txt");
		} catch (IOException e) {
			System.out.println("");
			e.printStackTrace();
		}
		
		//tradutor.mostrarDicionario();
		
		int op;
        System.out.print('\u000C');//Limpar dados
		
		do {
			System.out.println("");
			System.out.println("");
            System.out.println("Digite 1 para buscar tradução para palavra em inglês");
            System.out.println("Digite 2 para inserir uma nova palavra no dicionário");
            System.out.println("Digite 3 salvar o arquivo dicionário");
            System.out.println("Digite 0 para finalizar operação");
            op = t.leInt("Escolha uma opção: ");
		
            
            if(op == 1) {
            	 palavra = t.leString("Digite a palavra: ");
            	
            	if(tradutor.traduzPalavra(palavra) != null) {
            		ArrayList<String> definicoes = new ArrayList<String>(tradutor.traduzPalavra(palavra));
            		System.out.println("Definições para: " + palavra + " " + definicoes.toString());
            	} else
            		System.out.println("Esta palavra não está presente no dicionário. Deseja adicioná-la? Se sim, aperte a tecla 2");
            }
            
            else if(op == 2) {
            	if(palavra.equals("") || tradutor.avl.search(palavra) != null) {
            		palavra = t.leString("Digite a palavra: ");
            	} 
            	
            	String traducao = t.leString("Digite as traduções para a palavra " + palavra + ": (formato: traducao-traducao-traducao...)");
            		
            	String[] definicoesArray = traducao.split("-");
            	ArrayList<String> definicoesList = new ArrayList<String>(definicoesArray.length);
            	for(int i = 0; i < definicoesArray.length; i++)
            		definicoesList.add(definicoesArray[i]);
            		
            	tradutor.insereTraducao(palavra, definicoesList);
            	
            	//Limpar variavel palavra
            	palavra = "";
            	
            }
            
            else if(op == 3) {
            	
            	try {
			tradutor.salvaDicionario("C:\\Users\\Douglas\\Downloads\\tradutor.txt");
			System.out.println("Dicionário salvo com sucesso!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }
           
            
		}
		
		while (op != 0);
        
    }

}
