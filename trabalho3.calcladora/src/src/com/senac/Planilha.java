package src.com.senac;

import src.com.senac.algoritmos.AvaliadorRPN;
import src.com.senac.algoritmos.AvaliaInfixa;

import static java.lang.System.*;

public class Planilha {
	public static void main(String[] args) throws Exception {
		out.println( AvaliaInfixa.avaliaInfixa ("3 + ( 5 * 3 ) - 5 / 2 + 2") );
		out.println( AvaliadorRPN.avalia ("3 5 2 + *") );
	}
}
