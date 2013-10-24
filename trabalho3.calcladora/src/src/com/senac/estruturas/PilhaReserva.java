package src.com.senac.estruturas;

public class PilhaReserva {
	
	public double[] dados2;
	public int topo2;
	
	/*public int getTopo2(){
		return topo2;
	}*/
	
	public PilhaReserva (int tam)
	{
		dados2 = new double[tam];
		topo2 = 0;
	}
	
	public static void insere (double valor)
	{	
		dados2[topo2] = valor;
		topo2++;
	}
	
	public double retira ()
	{		
		topo2--;
		return dados2[topo2];
	}
	

}
