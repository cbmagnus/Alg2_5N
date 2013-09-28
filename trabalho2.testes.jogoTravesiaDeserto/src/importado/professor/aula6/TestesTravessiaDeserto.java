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
	}
	
	
	//testa se @fuel permanece zero
	@Test
	public void testDescarregar(){
		assertEquals(0, jogo.getPos());
		int teste = 0;
		jogo.avancar();
		assertEquals((jogo.MAX_FUEL - 1), jogo.getFuel());		
		
		do {
			jogo.descarregar();
			teste = teste + 1;
		}while(teste < jogo.MAX_FUEL);
		
		assertEquals(0, jogo.getFuel());
		assertEquals((jogo.MAX_FUEL - 1), jogo.getMap()[jogo.getPos()]);
	}
	
	
	@Test
	public void testVoltar(){
		assertEquals(0, jogo.getPos());
		jogo.voltar();
		assertEquals(0, jogo.getPos());
		assertEquals(jogo.MAX_FUEL, jogo.getFuel());
		
		assertEquals((jogo.MAX_FUEL),jogo.getFuel());
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
		assertEquals((jogo.MAX_FUEL -1), jogo.getFuel());
		jogo.voltar();
		
		//testa se realmente descarregou e carregou
		assertEquals(0, jogo.getPos());
		jogo.avancar();
		jogo.descarregar();
		assertEquals(jogo.MAX_FUEL -2, jogo.getFuel());
		assertEquals(1, jogo.getMap()[jogo.getPos()]);
		jogo.carregar();
		jogo.carregar();
		assertEquals((jogo.MAX_FUEL -1), jogo.getFuel());
		assertEquals(0, jogo.getMap()[jogo.getPos()]);

	}
	

	
	@After
	public void tearDown() {
		System.out.println("final");
		jogo = null;

	}


}
