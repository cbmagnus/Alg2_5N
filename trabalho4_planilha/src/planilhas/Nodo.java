package planilhas;

public class Nodo {
	private Nodo prox;
	private int valor;
	
	public void setNext(Nodo prox){
		this.prox = prox;
	}
	public Nodo getNext(){
		return this.prox;
	}

	public void setValor(int valor){
		this.valor = valor;
	}
	public int getValor(){
		return this.valor;
	}
	
	
}
