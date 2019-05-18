package tradutor;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		Tradutor tradutor = new Tradutor();
		
		try {
			tradutor.carregaDicionario("C:\\Users\\i871294\\Desktop\\dicionario.dat");
		} catch (IOException e) {
			System.out.println("");
			e.printStackTrace();
		}
		
		tradutor.mostrarDicionario();
			
	}

}
