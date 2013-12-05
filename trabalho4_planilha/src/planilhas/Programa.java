package planilhas;

import static java.lang.System.exit;

import java.util.Scanner;

public class Programa {
	static NodoColuna novo = new NodoColuna();
	static Lista lista = new Lista();
	static String entrada;
	
	
	public static void verificaEntrada(){
		do{
			Scanner sc = new Scanner(System.in);
			entrada = sc.next();
			novo.setColuna(entrada);
		
			lista.insereColuna(novo);
			lista.procuraLinha(novo);
				
			if(entrada.equals("fim")){
				System.out.println("você desistiu!");
				exit(0);
			}
			
		}while(entrada.equals("fim"));
	}
	
	
	public static void main(String[] args) {
		System.out.println("Digite 'fim' para sair.");
		System.out.println("Digite a celula desejada: ");
		
		verificaEntrada();
		System.out.println(entrada);
		
		
	}

}
