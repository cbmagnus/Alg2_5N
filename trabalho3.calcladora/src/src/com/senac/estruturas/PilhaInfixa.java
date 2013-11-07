package src.com.senac.estruturas;

public class PilhaInfixa {
	
	private static char[] dados2;
	private static int topo2 = 0;
	
	public int getTopo(){
		return topo2;
	}
	
	public PilhaInfixa (int tam)
	{
		dados2 = new char[tam];
		topo2 = 0;
	}

	public static char peek () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		return dados2[topo2 - 1]; 
	}

	public static void push (char valor) throws PilhaCheia
	{
		if (isFull())
			throw new PilhaCheia();
		
		dados2[topo2] = valor;
		topo2++;
	}
		
	public static char pop () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
			
		topo2--;
		return dados2[topo2];
	}
	
	private static boolean isFull() {
		return topo2 == dados2.length;
	}

	private static boolean isEmpty() {
			return topo2 == 0;
	}
}
