package trabalho.jogo;

import java.util.Scanner;
import java.util.Arrays;

public class Jogo {

	private int tanque = 6;
	private int posicao = 0;
	private int combustivel = 0;
	private int tamanho_mapa = 10;
	private int[] mapa = new int[tamanho_mapa];
	private int[] carga = new int[tamanho_mapa];
	private int opcao;
	private int troca = 0;

	public int getTanque() {
		return tanque;
	}

	public void setTanque(int tanque) {
		this.tanque = tanque;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public int getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public int getTamanho_mapa() {
		return tamanho_mapa;
	}

	public void setTamanho_mapa(int tamanho_mapa) {
		this.tamanho_mapa = tamanho_mapa;
	}

	public int[] getMapa() {
		return mapa;
	}

	public void setMapa(int[] mapa) {
		this.mapa = mapa;
	}

	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	public int[] getCarga() {
		return carga;
	}

	public void setCarga(int[] carga) {
		this.carga = carga;
	}

	public int getTroca() {
		return troca;
	}

	public void setTroca(int troca) {
		this.troca = troca;
	}

	
	
	
	public void avancar(int pos) {
		
		if ((pos + posicao) >= (tamanho_mapa - 1)) {
			System.out.println("\nPARABÉNS VOCÊ GANHOU!!!");
			System.exit(0);
		}
		else if (pos > tanque) {
			System.out.println("\n       VOCÊ PODE ANDAR NO MAXIMO   " + tanque + "   POSIÇÕES!");
		}else {
			posicao += pos;
			tanque -= pos;
			mapa[posicao] = tanque;  
			mapa[posicao - pos] = 0;
			System.out.println("---------------------------------------------------------");
			System.out.println("\n\nmapa  = " + Arrays.toString(mapa));
			System.out.println("carga = " + Arrays.toString(carga));
		}
	}

	public void voltar(int pos) {
		if (pos > tanque) {
			System.out.println("\nVOCÊ PODE ANDAR NO MAXIMO   " + tanque + "   POSIÇÕES!\n");
		} else {
			posicao -= pos;
			tanque -= pos;
			mapa[posicao] = tanque;
			mapa[posicao + pos] = 0;
			if (posicao == 0) {
				mapa[0] = 6;
				System.out.println("---------------------------------------------------------");
				System.out.println("\n\nmapa  = " + Arrays.toString(mapa));
				System.out.println("carga = " + Arrays.toString(carga));
			} else {
				System.out.println("---------------------------------------------------------");
				System.out.println("\nmapa  = " + Arrays.toString(mapa));
				System.out.println("carga = " + Arrays.toString(carga));
			}
		}

	}

	public void descarregar(int gas) {
		if (gas > tanque) {
			System.out.println("\nVocê pode descarregar = " + tanque);
		} else {
			combustivel = gas;
			carga[posicao] += combustivel;
			mapa[posicao] -= combustivel;
			tanque -= combustivel;
			System.out.println("---------------------------------------------------------");
			System.out.println("\n\nmapa  = " + Arrays.toString(mapa));
			System.out.println("carga = " + Arrays.toString(carga));
		}
	}

	public void carregar(int gas) {
		if (gas > carga[posicao]) {
			System.out.println("\nSINTO MUITO!, VOCÊ TEM   " + carga[posicao] + "   PARA RECARREGAR\n");
		} else if ((gas + tanque) > 6) {
			System.out.println("\nVOCÊ SÓ PODE CARREGAR   " + (6 - tanque) + "   POSIÇÕES\n");
		} else if ((gas + tanque) <= 6) {
			tanque += gas;
			combustivel -= gas;
			carga[posicao] -= gas;
			mapa[posicao] += gas;
			System.out.println("---------------------------------------------------------");
			System.out.println("\n\nmapa  = " + Arrays.toString(mapa));
			System.out.println("carga = " + Arrays.toString(carga));
		}

	}

	
	
	
	
	
	public static void main(String[] args) {

		Jogo j = new Jogo();

		j.getMapa()[0] = 6;

		System.out.println("Bem vindo ao jogo");
		System.out.println("O objetivo do jogo é chegar até a ultima posição do vetor, sendo que sempre quando você esta na posição 1 do vetor o seu tanque enche");
		System.out.println("automáticamente (tanque = 6), e em qualquer parte do vetor você pode carregar ou descarregar posições  \n Boa sorte!! ");
		System.out.println("\n\nmapa  = " + Arrays.toString(j.getMapa()));
		System.out.println("carga = " + Arrays.toString(j.getCarga()));

		
		
		
		do {

			// verifica se estou na posição zero do mapa se sim tanque = 6
			if (j.getPosicao() == 0) {
				j.setTanque(6);
			}
			
			// se tanque = 0 e tiver recarga na minha posição indica
			// obrigatoriedae de recarga ou acaba jogo
			if (j.getTanque() == 0) {
				if (j.getCarga()[j.getPosicao()] > 0) {
					System.out.println("Você é obrigado a carregar ou vai perder");
				}
			}
			
			// se tanque = 0 e não tiver como recarregar sai do while e acaba o jogo
			if (j.getTanque() == 0) {
				if (j.getCarga()[j.getPosicao()] == 0) {
					System.out
							.println("\nVOCÊ PERDEU! NÃO TEM COMO RECARREGAR E NÃO TEM MAIS COMBUSTIVEL");
					break;
				}
			}
			
			//verifica se ganhou
			if (j.getPosicao() == 666){
				System.out.println("FIM");
			}

			// foi colocado +1 para facilitar a visão do usuário e contar de 1 a 10 e não de 0 a 9
			System.out.println("\nvocê está na posição   " + (j.getPosicao() + 1) + "   e tem   " + j.getTanque() + "   posições para andar");
			System.out.println("Nesta posição você tem   " + j.getCarga()[j.getPosicao()] + "   posições para carregar");
			
			
			System.out.println("\ndigite  1  AVANÇA");
			System.out.println("digite  2  VOLTA");
			System.out.println("digite  3  DESCARREGA");
			System.out.println("digite  4  CARREGA");
			System.out.println("digite  5  MOSTRA MAPAS");
			System.out.println("digite  9  SAI");

			System.out.print("\nDIGITE SUA OPÇÃO: ");

			// joga em opção o valor indicado pelo usuário
			Scanner sc = new Scanner(System.in);
			j.setOpcao(sc.nextInt());

			
			
			switch (j.getOpcao()) {

			case 9:
				System.out.println("\n       VOCÊ DESISTIU");
				break;

			case 1: // avançar
				System.out.print("Digite quantas posições deseja avançar: ");
				j.setTroca(sc.nextInt());
				if (j.getTroca() == 0){
					break;
				}else{
				j.avancar(j.getTroca());
				break;
				}

			case 2: // Voltar
				System.out.print("Digite quantas posições deseja voltar: ");
				j.setTroca(sc.nextInt());
				if (j.getTroca() == 0){
					break;
				}else{
				j.voltar(j.getTroca());
				break;
				}

			case 3: // descarregar
				System.out.print("Digite quantas posições deseja descarregar: ");
				j.setTroca(sc.nextInt());
				j.descarregar(j.getTroca());
				break;

			case 4: // carregar
				if (j.getCarga()[j.getPosicao()] != 0) {
					System.out.print("Digite quantas posições deseja carregar: ");
					j.setTroca(sc.nextInt());
					j.carregar(j.getTroca());
				} else {
					System.out.println("NESTA POSIÇÃO NÃO HÁ NADA PARA RECARREGAR");
				}
				break;

			case 5: // mostra os mapas
				System.out.println("mapa  = " + Arrays.toString(j.getMapa()));
				System.out.println("carga = " + Arrays.toString(j.getCarga()));
				break;

			default:
				System.out.println("\nOPÇÃO INVALIDA ESCOLHA UM DOS NUMERO INDICADOS ABAIXO");
				break;

			}

		} while (j.getOpcao() != 9);

		if (j.getOpcao() == 9) {
			System.out.println("tente mais tarde");
		}

	}
}