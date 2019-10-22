package lab03FranciclaudioDantas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContatoTest {
	
	private Contato cont1;
	private Contato cont2;
	private Contato cont3;
	private Contato cont4;
	private Contato cont5;
	private Agenda ag;
	
	@BeforeEach
	public void setUp() {
		this.cont1 = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
		this.cont2 = new Contato("Matheus", "Gaudencio", "(83) 88888-0000");
		this.cont3 = new Contato("Matheus", "Sampaio", "(83) 99999-0000");
		this.cont4 = new Contato("Pedro", "Gaudencio", "(83) 99999-0000");
		this.cont5 = new Contato("Livia", "Campos", "9973-2999");
		this.ag = new Agenda();
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Matheus", cont1.getNome());
		assertEquals("Gaudencio", cont1.getSobrenome());
		assertEquals("(83) 99999-0000", cont1.getTelefone());
	}
	
	@Test
	public void testArgumentoNull() {
		try {
			new Contato(null, "Gaudencio", "(83) 99999-0000");
			fail("Era esperado exceção ao passar argumento nulo");
			
			} catch(NullPointerException npe) {	
			}
		
		try {
			new Contato("Matheus", null, "(83) 99999-0000");
			fail("Era esperado exceção ao passar argumento nulo");
			
		} catch(NullPointerException npe) {
		}
		
		try {
			new Contato("Matheus", "Gaudencio", null);
			fail("Era esperado exceção ao passar argumento nulo");
			
		} catch(NullPointerException npe) {
		}
	}
	
	@Test
	public void testArgumentoVazio() {
		try {
			
			new Contato("", "Gaudencio", "(83) 99999-0000");
			fail("Era esperado exceção ao passar argumento vazio");
			
			} catch(IllegalArgumentException iae) {
				
			}
		
		try {
			
			new Contato("Matheus", "", "(83) 99999-0000");
			fail("Era esperado exceção ao passar argumento vazio");
			
		} catch(IllegalArgumentException iae) {
			
		}
		
		try {
			
			new Contato("Matheus", "Gaudencio", "");
			fail("Era esperado exceção ao passar argumento vazio");
			
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	
	@Test
	public void testToString() {
		assertEquals("Matheus Gaudencio - (83) 99999-0000", cont1.toString());
	}
	
	@Test
	public void testHashCode() {
		assertNotEquals(this.cont1.hashCode(), this.cont5.hashCode());
		assertEquals(this.cont1.hashCode(), this.cont2.hashCode());
	}
	
	@Test
	public void testEquals() {
		Contato contatoNulo = null;
		
		assertTrue(this.cont1.equals(this.cont1));
		assertTrue(this.cont1.equals(this.cont2));
		assertFalse(this.cont1.equals(this.cont5));
		assertFalse(this.cont1.equals(this.cont3));
		assertFalse(this.cont1.equals(this.cont4));
		assertFalse(this.cont1.equals(this.ag));
		
		assertFalse(this.cont1.equals(contatoNulo));
		
		
	}

}
