package src.com.senac.algoritmos;

import java.util.Scanner;

import src.com.senac.algoritmos.AvaliadorRPN;
import src.com.senac.estruturas.PilhaCheia;
import src.com.senac.estruturas.PilhaOperador;
import src.com.senac.estruturas.PilhaVazia;

public class AvaliaInfixa {

	private static String imprime;
	private static double saida;
	
	public static String avaliaInfixa (String expressao) throws PilhaCheia, PilhaVazia, InvalidOperator
    {
    	PilhaOperador pilha = new PilhaOperador(50);
    	
    	Scanner sc = new Scanner(expressao);
    	
    	while (sc.hasNext()) {
    		if (sc.hasNextInt()) {
    			if(imprime == null){
    				imprime = ("" + sc.nextInt());
    			}else{
    				imprime += (" " + sc.nextInt());
    			}
    		} 
    		
    		else {
    			String teste = sc.next();
    			
    			if(teste.charAt(0) == ')'){
    				while((char)pilha.peek() != '('){
    					imprime += " " + (char)pilha.pop();
    				}
    				pilha.pop();
    			}
    			
    			else if(teste.charAt(0) == '('){
    				pilha.push(teste.charAt(0));
    			}
    			
    			else if((teste.charAt(0) == '*') || (teste.charAt(0) == '/') || (teste.charAt(0) == '+') || (teste.charAt(0) == '-')){
    				if(pilha.getTopo() -1 == -1 ){
    					pilha.push(teste.charAt(0));
    					
    				}else{
    					if(prioridade(teste.charAt(0)) >= prioridade((char)pilha.peek()) || (char)pilha.peek() == '('){
    						pilha.push(teste.charAt(0));
    					}
    					else{
    						while(pilha.getTopo()-1 != -1){
    							if ( ((char)pilha.peek() == '(') && (teste.charAt(0) == '(') ){
    								pilha.pop();
    								break;
    							}
    							else if( prioridade(teste.charAt(0)) == prioridade((char)pilha.peek()) ){
    								break;
    							}
    							
    							else if(prioridade(teste.charAt(0)) <= prioridade((char)pilha.peek()) ){
    								if((char)pilha.peek() == '('){
    									;
    									break;
    								}
    								imprime += " " + (char)pilha.pop();
    							}
    						}
    						pilha.push(teste.charAt(0));
    					}
    				}
    			//prioridade(teste.charAt(0));
    			}
    		}
        }
         
    	while(pilha.getTopo() != 0){
    		imprime += " " + (char)pilha.pop();
    	}
    	
    	saida = AvaliadorRPN.avalia(imprime);
    	imp();
        return imprime = "resultado final: " + saida;
}
	


private static char prioridade (char op) throws InvalidOperator
{
	if(op == ')' || op == '(') {
		return 3;
	}
	
	if(op == '*' || op == '/') {
		return 2;
	}
	
	if(op == '+' || op == '-') {
		return 1;
	}
		
	throw new InvalidOperator(op);
}

	private static void imp(){
		System.out.println("resultado posfixa: " + imprime);
	}

}