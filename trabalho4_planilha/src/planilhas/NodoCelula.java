package planilhas;

public class NodoCelula extends Nodo {
	private Nodo lista;
	private int valor;
	
	public boolean compare(int key){
		if(key == valor){
			return true;
		}
		return false;
	}
	
	
	public int getValor(){
		return this.valor;
	}
	public void setValor(int valor){
		this.valor = valor;
	}


	public boolean compare(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
