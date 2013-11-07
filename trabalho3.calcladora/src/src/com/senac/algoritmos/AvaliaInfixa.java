package src.com.senac.algoritmos;

import java.util.Scanner;

import src.com.senac.algoritmos.AvaliadorRPN;
import src.com.senac.estruturas.PilhaCheia;
import src.com.senac.estruturas.PilhaInfixa;
import src.com.senac.estruturas.PilhaOperador;
import src.com.senac.estruturas.PilhaVazia;

public class AvaliaInfixa {

	private static String imprime;
	private static double saida;
	
	public static String avaliaInfixa (String expressao) throws PilhaCheia, PilhaVazia, InvalidOperator
    {
    	PilhaInfixa pilha = new PilhaInfixa(50);
    	
    	Scanner sc = new Scanner(expressao);
    	imprime = null;
    	while (sc.hasNext()) {
    		if (sc.hasNextInt()) {
    			if(imprime == null){
        			imprime = sc.nextInt() + " ";
        		}
    			else{
    			imprime += sc.nextInt() + " ";
        		}
    		} 
    		
    		else {
    			char teste = sc.next().charAt(0);
    			if(teste == ')'){
    				while(pilha.peek() != '('){
    					imprime += pilha.pop() + " ";
    				}
    				pilha.pop();
    			}
    			
    			else if(teste == '('){
    				pilha.push(teste);
    			}
    			
    			else if((teste == '*') || (teste == '/') || (teste == '+') || (teste == '-')){
    				if(pilha.getTopo() -1 == -1 ){
    					pilha.push(teste);
    					
    				}else{
    					if(prioridade(teste) >= prioridade(pilha.peek()) || pilha.peek() == '('){
    						pilha.push(teste);
    					}
    					else{
    						while(pilha.getTopo()-1 != -1){
    							if ( (pilha.peek() == '(') && (teste == '(') ){
    								pilha.pop();
    								break;
    							}
    							else if( prioridade(teste) == prioridade(pilha.peek()) ){
    								break;
    							}
    							
    							else if(prioridade(teste) <= prioridade(pilha.peek()) ){
    								if(pilha.peek() == '('){
    									;
    									break;
    								}
    								imprime += pilha.pop() + " ";
    							}
    						}
    						pilha.push(teste);
    					}
    				}
    			}
    		}
        }
         
    	while(pilha.getTopo() != 0){
    		imprime += pilha.pop() + " ";
    	}
    	
    	saida = AvaliadorRPN.avalia(imprime);
    	System.out.println("resultado posfixa: " + imprime);
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
		
	throw new InvalidOperator((char)op);
}

}