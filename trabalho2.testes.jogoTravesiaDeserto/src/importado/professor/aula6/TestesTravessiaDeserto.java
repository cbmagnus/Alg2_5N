package importado.professor.aula6;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestesTravessiaDeserto{
	private TravessiaDeserto jogo = null;

	public void jogoGanho(){
		jogo.avancar();
		jogo.avancar();
		jogo.descarregar();
		jogo.descarregar();
		jogo.voltar();
		jogo.voltar();
		jogo.avancar();
		jogo.avancar();
		jogo.descarregar();
		jogo.descarregar();
		jogo.voltar();
		jogo.voltar();
		jogo.avancar();
		jogo.avancar();
		jogo.descarregar();
		jogo.descarregar();
		jogo.voltar();
		jogo.voltar();
		jogo.avancar();
		jogo.avancar();
		jogo.descarregar();
		jogo.descarregar();
		jogo.voltar();
		jogo.voltar();
		jogo.avancar();
		jogo.avancar();
		jogo.carregar();
		jogo.carregar();
		jogo.avancar();
		jogo.avancar();
		jogo.descarregar();
		jogo.descarregar();
		jogo.voltar();
		jogo.voltar();
		jogo.carregar();
		jogo.carregar();
		jogo.carregar();
		jogo.carregar();
		jogo.carregar();
		jogo.carregar();
		jogo.avancar();
		jogo.avancar();
		jogo.carregar();
		jogo.carregar();
		jogo.avancar();
		jogo.avancar();
		jogo.avancar();
		jogo.avancar();
		jogo.avancar();
		jogo.avancar();
	}
	
	
	@Before
	public void setUp() {
		System.out.println("inicio");
		
		jogo = new TravessiaDeserto();
		jogo.initGame();
	}

	
	@Test
	public void testAvancar(){
		int anterior_pos = jogo.getPos();
		int anterior_fuel = jogo.getFuel();
		jogo.avancar();
		assertEquals(anterior_pos + 1, jogo.getPos());
		assertEquals(anterior_fuel - 1,jogo.getFuel());
		jogo.voltar();
		assertEquals(0, jogo.getPos());
		do{
			jogo.avancar();
		}while(jogo.getFuel() != 0);
		jogo.avancar();
		assertEquals(TravessiaDeserto.MAX_FUEL, jogo.getPos());
	}
	
	
	//testa se @fuel permanece zero
	@Test
	public void testDescarregar(){
		assertEquals(0, jogo.getPos());
		int teste = 0;
		jogo.avancar();
		assertEquals((TravessiaDeserto.MAX_FUEL - 1), jogo.getFuel());		
		do {
			jogo.descarregar();
			teste = teste + 1;	//teste no fim esta com 6
		}while(teste < TravessiaDeserto.MAX_FUEL);
		assertEquals(0, jogo.getFuel());
		assertEquals((TravessiaDeserto.MAX_FUEL - 1), jogo.getMap()[jogo.getPos()]);
	}
	
	
	@Test
	public void testVoltar(){
		assertEquals(0, jogo.getPos());
		jogo.voltar();
		assertEquals(0, jogo.getPos());
		assertEquals(TravessiaDeserto.MAX_FUEL, jogo.getFuel());
		
		assertEquals((TravessiaDeserto.MAX_FUEL),jogo.getFuel());
		jogo.avancar();
		jogo.avancar();
		int anterior_pos = jogo.getPos();// 2
		int anterior_fuel = jogo.getFuel();// 4
		jogo.voltar();
		assertEquals((anterior_pos - 1), jogo.getPos()); //1
		assertEquals((anterior_fuel - 1),jogo.getFuel()); //3	
	}
	
	
	@Test
	public void testCarregar(){
		assertEquals(0, jogo.getPos());
		jogo.avancar();
		jogo.carregar();
		assertEquals((TravessiaDeserto.MAX_FUEL -1), jogo.getFuel());
		jogo.voltar();
		
		//testa se realmente descarregou e carregou
		assertEquals(0, jogo.getPos());
		jogo.avancar();
		jogo.descarregar();
		assertEquals(TravessiaDeserto.MAX_FUEL -2, jogo.getFuel());
		assertEquals(1, jogo.getMap()[jogo.getPos()]);
		jogo.carregar();
		jogo.carregar();
		assertEquals((TravessiaDeserto.MAX_FUEL -1), jogo.getFuel());
		assertEquals(0, jogo.getMap()[jogo.getPos()]);
		jogo.voltar();
		
		//encontrado um erro (permite carregar mais que o permitido)
		int gas = 2;
		assertEquals(0, jogo.getPos());
		jogo.avancar();
		do{
			jogo.descarregar();
			gas = gas + 1;
		}while(gas < TravessiaDeserto.MAX_FUEL);
		assertEquals(1, jogo.getFuel());
		assertEquals((TravessiaDeserto.MAX_FUEL - 2), jogo.getMap()[jogo.getPos()]); //4 na posicao porque gas inicia em 2
		jogo.voltar();
		jogo.avancar();
		do{
			jogo.carregar();
		}while(jogo.getMap()[jogo.getPos()] != 0);
		assertEquals(TravessiaDeserto.MAX_FUEL, jogo.getFuel()); //não deveria passar da carga maxima de combustivel
	}
	
	
	@Test
	public void testProcessCommand(){
		assertEquals(0, jogo.getPos());
		jogo.processCommand(0);	//avancar
		assertEquals(1, jogo.getPos());
		assertEquals(TravessiaDeserto.MAX_FUEL - 1, jogo.getFuel());
		
		jogo.processCommand(3);	//descarregar
		assertEquals(TravessiaDeserto.MAX_FUEL - 2, jogo.getFuel());
		
		jogo.processCommand(2);	//carregar
		assertEquals(TravessiaDeserto.MAX_FUEL - 1, jogo.getFuel());
		
		jogo.processCommand(1);	//voltar
		assertEquals(0, jogo.getPos());
		assertEquals(TravessiaDeserto.MAX_FUEL, jogo.getFuel());
	}
	
	
	@Test
	public void testTranslateCommand(){
		assertEquals(TravessiaDeserto.AVANCAR, jogo.translateCommand("avancar"));
		assertEquals(TravessiaDeserto.VOLTAR, jogo.translateCommand("voltar"));
		assertEquals(TravessiaDeserto.DESCARREGAR, jogo.translateCommand("descarregar"));
		assertEquals(TravessiaDeserto.CARREGAR, jogo.translateCommand("carregar"));
		assertEquals(TravessiaDeserto.AJUDA, jogo.translateCommand("ajuda"));
		
		assertEquals(TravessiaDeserto.AVANCAR, jogo.translateCommand("AvaNcar"));
		assertEquals(TravessiaDeserto.VOLTAR, jogo.translateCommand("voLtar"));
		assertEquals(TravessiaDeserto.DESCARREGAR, jogo.translateCommand("desCarregaR"));
		assertEquals(TravessiaDeserto.CARREGAR, jogo.translateCommand("cArreGar"));
		assertEquals(TravessiaDeserto.AJUDA, jogo.translateCommand("AJUDA"));
		
		assertEquals(TravessiaDeserto.ERROR, jogo.translateCommand("avança"));
		assertEquals(TravessiaDeserto.ERROR, jogo.translateCommand("CAREGA"));
		assertEquals(TravessiaDeserto.ERROR, jogo.translateCommand("Aud3"));
		assertEquals(TravessiaDeserto.ERROR, jogo.translateCommand("2"));
	}
	
	
	@Test
	public void testInitGame(){
		jogo.initGame();
		assertEquals(0, jogo.getPos());
		assertEquals(TravessiaDeserto.MAX_FUEL, jogo.getFuel());
	}
	
	
	@Test
	public void testIsWinner(){
		jogoGanho();
		assertEquals(TravessiaDeserto.MAP_SIZE, jogo.getPos());
		assertTrue(jogo.isWinner());
	}

	
	@Test
	public void testIsGameOver(){

		assertFalse(jogo.isGameOver());
				
		while (jogo.getFuel() > 0){
			jogo.avancar();
		}
		assertTrue(jogo.getFuel() == 0);
		assertFalse(jogo.getPos() == TravessiaDeserto.MAP_SIZE);
		assertTrue(jogo.getMap()[jogo.getPos()] == 0);
		
		assertTrue(jogo.isGameOver());
	}
	
	
	@Test
	public void testGetEndMessage(){
		jogoGanho();
		assertTrue(jogo.getEndMessage() == "Voce GANHOU!");
		
		jogo.initGame();
		assertEquals(0, jogo.getPos());
		do{
			jogo.avancar();
		}while(jogo.getFuel() != 0);
		
		assertEquals(0, jogo.getFuel());
		assertFalse(jogo.getPos() == TravessiaDeserto.MAP_SIZE);
		assertTrue(jogo.getEndMessage() == "Voce PERDEU.");
	}
	
	
	@After
	public void tearDown() {
		System.out.println("final");
		jogo = null;

	}


}
