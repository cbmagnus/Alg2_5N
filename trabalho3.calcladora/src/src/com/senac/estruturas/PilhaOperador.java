package src.com.senac.estruturas;

public class PilhaOperador {

	private static double[] dados;
	private static int topo;
	
	
	public PilhaOperador (int tam)
	{
		dados = new double[tam];
		topo = 0;
	}

	public double peek () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		return dados[topo - 1]; 
	}

	public static void push (double valor) throws PilhaCheia
	{
		if (isFull())
			throw new PilhaCheia();
		
		dados[topo] = valor;
		topo++;
	}
	
	public double pop () throws PilhaVazia
	{
		if (isEmpty())
			throw new PilhaVazia();
		
		topo--;
		return dados[topo];
	}
	
	private static boolean isFull() {
		return topo == dados.length;
	}

	private boolean isEmpty() {
		return topo == 0;
	}
}
