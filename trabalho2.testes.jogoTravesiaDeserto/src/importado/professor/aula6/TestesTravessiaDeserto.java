package importado.professor.aula6;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestesTravessiaDeserto extends TravessiaDeserto{
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("antes classe");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("depois classe");
	}

	@Before
	public void setUp() {
		System.out.println("inicio");
	}

	@After
	public void tearDown() {
		System.out.println("final");
	}

	@Test
	public void testAvanca() {
		int v1 = 0;
		assertEquals(0, getProcessCommand(v1));
		
		
		
		/* //valor esperado 5 e valor passado 5 e valor de chance de erro 0
		assertEquals("teste n = 5.\n", 5, Recursao.fibonacci(5), 0);
		assertEquals(1, Recursao.fibonacci(-1), 0);
		assertEquals(1, Recursao.fibonacci(0), 0);
		assertEquals(1, Recursao.fibonacci(1), 0);
		assertEquals(1, Recursao.fibonacci(2), 0);
		assertEquals(2, Recursao.fibonacci(3), 0);
		assertEquals(21, Recursao.fibonacci(8), 0);
	*/
	}


}
