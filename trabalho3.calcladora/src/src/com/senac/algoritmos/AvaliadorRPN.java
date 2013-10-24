package src.com.senac.algoritmos;

import java.util.Scanner;

import src.com.senac.estruturas.PilhaReserva;
import src.com.senac.estruturas.PilhaCheia;
import src.com.senac.estruturas.PilhaOperador;
import src.com.senac.estruturas.PilhaVazia;
/*
public class AvaliadorRPN 
{
	
	private static double[] dados2;
	private static int topo2;
	
	public static double avalia (String expressao) throws PilhaCheia, PilhaVazia, InvalidOperator
	{	
		PilhaOperador pilha = new PilhaOperador(50);
		
		Scanner sc = new Scanner(expressao);
		
		String a = sc.next();
		String b = a.sc.next();
		if(a == b)
		{
		
		while (sc.hasNext()) 
		{
			if (sc.hasNextInt())
			{
				PilhaOperador.push(sc.nextInt());
			}
			
			else
			{					    
				String op = sc.next();
				double rhs = pilha.pop();
				double lhs = pilha.pop();
				PilhaOperador.push( executaOperador(op.charAt(0), lhs, rhs) );
			}
		}
		
		return pilha.pop();
		}
		
		
		else
		{
			while (sc.hasNext()) 
			{
				if (sc.hasNextInt()) {
					PilhaOperador.push(sc.nextInt());
				} else{
					if(sc.next() == ")"){
						while(dados2[topo2] != '('){
							PilhaOperador.push(topo2);
							topo2 --;
						}
					}
					dados2[topo2] = sc.next();
					topo2 ++;
				}
			}
			
			
		}
		return avalia(dados2[topo2]);
	}

	
	private static double executaOperador(char op, double lhs, double rhs) throws InvalidOperator, PilhaCheia
	{
		switch (op) {
			case '+': return lhs + rhs;
			case '-': return lhs - rhs;
			case '*': return lhs * rhs;
			case '/': return lhs / rhs;
			default: throw new InvalidOperator(op);
		}
	}
	
	
	public static void fechaParenteses(char op) throws InvalidOperator, PilhaCheia{
		while (topo2 != '('){
			PilhaOperador.push(topo2);
			topo2 --;
		}
		topo2 --;
	}
	
	
}
*/





















public class AvaliadorRPN 
{
        public static double avalia (String expressao) throws PilhaCheia, PilhaVazia, InvalidOperator
        {        
                PilhaOperador pilha = new PilhaOperador(50);
                PilhaReserva pilha2 = new PilhaReserva(50);
                
                Scanner sc = new Scanner(expressao);
                
                while (sc.hasNext()) {
                        if (sc.hasNextInt()) {
                                pilha.push(sc.nextInt());
                        } else {
                        	if(sc.next() == ")"){
                        		while(pilha2.topo2 != '('){
                        			pilha2.retira();
                        			pilha.push(pilha2.topo2);
                        		}
                        	}else if(){
                        		
                        	}
                            
                        	String op = sc.next();
                            double rhs = pilha.pop();
                            double lhs = pilha.pop();
                            pilha.push( executaOperador(op.charAt(0), lhs, rhs) );
                        }
                }
                
                return pilha.pop();
        }

        private static double executaOperador(char op, double lhs, double rhs) throws InvalidOperator
        {
                switch (op) {
                        case '+': return lhs + rhs;
                        case '-': return lhs - rhs;
                        case '*': return lhs * rhs;
                        case '/': return lhs / rhs;
                        default: throw new InvalidOperator(op);
                }
        }
}

