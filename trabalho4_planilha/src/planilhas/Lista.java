package planilhas;

public class Lista {
	private NodoColuna head = new NodoColuna();
	int comparacao = 0;
	
	
	public boolean procuraColuna(NodoColuna novo){
		if(head == null){
			System.out.println("não existe nenhuma coluna");
			return false;
		}
		else if(head != null){
			while(head.getcoluna() != novo.getcoluna()){
				head.getNext();
				if(head.getcoluna() == null){
					System.out.println("Coluna não encontrada");
					return false;
				}
			}
			System.out.println("coluna encontrada");
			return true;
		}
		return false;
	}
	
	
	public void insereColuna(NodoColuna novo){
		NodoColuna procurado = head;
		NodoColuna anterior = head;
		
		if(procuraColuna(novo) == true){
			System.out.println("Já existe esta coluna");
			procuraLinha(novo);
			return;
		}
		else if(procurado == null){
			procurado = novo;
			return;
		}
		
		if(comparacao > 0){
			novo.setNext(procurado);
			procurado = novo;
		}
		else if(comparacao < 0){
			while(comparacao < 0){
				anterior.setNext(procurado);
				procurado.getNext();
			}
		novo.setNext(procurado);
		anterior.setNext(novo);
		procurado = novo;
		}
			
		return;
	}
	
	
	public void procuraLinha(NodoColuna key){
		
		NodoColuna procurado = head;    //salvar em qualquer elemento o inicio pra não perder a lista
		NodoColuna anterior = head;
		int comparacao = procurado.getcoluna().compareTo(key.getcoluna());
			
		if(comparacao == 0){
			if(procurado.getLista().getValor() == key.getLista().getValor()){
				System.out.println(procurado.getcoluna());
				System.out.println(procurado.getcoluna() + procurado.getLista().getValor());
				return;
			}
			else if(procurado.getLista().getValor() > key.getLista().getValor()){
				key.getLista().setNext(procurado.getLista());
				procurado.setLista(key.getLista());
			}
			else if(procurado.getLista().getValor() < key.getLista().getValor()){
				while(procurado.getLista().getValor() < key.getLista().getValor()){
					anterior.getLista().setNext(procurado.getLista()); 
					procurado.getLista().getNext();
				}
				key.getLista().setNext(procurado.getLista());
				anterior.getLista().setNext(key.getLista());
				procurado = anterior;
				}
			else if(procurado.getLista() == null){
				procurado.setLista(key.getLista());
			}
		return;
		}
	}
}
