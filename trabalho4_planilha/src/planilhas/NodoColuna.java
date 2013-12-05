package planilhas;

public class NodoColuna extends Nodo {
	private String coluna;
	private Nodo lista;
	
	public String getcoluna(){
		return this.coluna;
	}
	public void setColuna(String coluna){
		this.coluna = coluna;
	}
	
	public Nodo getLista(){
		return this.lista;
	}
	public void setLista(Nodo lista){
		this.lista = lista;
	}
	
}
