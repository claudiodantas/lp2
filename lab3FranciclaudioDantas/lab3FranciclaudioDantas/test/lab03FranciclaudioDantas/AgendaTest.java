package lab03FranciclaudioDantas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgendaTest {
	
	private Agenda ag1;
	private Agenda ag2;
	private Agenda ag3;
	
	@BeforeEach
	public void setUp() {
		this.ag1 = new Agenda();
		this.ag2 = new Agenda();
		this.ag3 = new Agenda();
		assertTrue(ag1.cadastraContato("Matheus", "Gaudencio", "(83) 99999-0000", 1));
	}
	
	
	@Test
	public void testConstrutor() {
		Agenda ag2 = new Agenda();
		Contato[] cont = new Contato[100];
		assertArrayEquals(ag2.getContatos(), cont); 
	}
	
	@Test
	public void testCadastraContato() {
		assertTrue(ag1.cadastraContato("Livia", "Sampaio", "(83) 88888-0000", 1));
		assertTrue(ag1.cadastraContato("Livia", "Sampaio", "(83) 88888-0000", 100));
		assertFalse(ag1.cadastraContato("Matheus", "Gaudencio", "(83) 99999-0000", 0));
		assertFalse(ag1.cadastraContato("Livia", "Sampaio", "(83) 88888-0000", 101));
	}
	
	@Test
	public void testExibeContato() {
		assertEquals(ag1.exibeContato(1), "Matheus Gaudencio - (83) 99999-0000");
		assertEquals(ag1.exibeContato(2), "POSICAO INVALIDA!");
	}
	
	@Test
	public void testListaContatos() {
		assertEquals(ag1.listaContatos(), "1 - Matheus Gaudencio\n");
		ag1.cadastraContato("Livia", "Sampaio", "(83) 88888-0000", 25);
		assertEquals(ag1.listaContatos(), "1 - Matheus Gaudencio\n" + "25 - Livia Sampaio\n");
		
	}
	
	@Test
	public void testHashCode() {
		ag3.cadastraContato("Matheus", "Gaudencio", "(83) 99999-0000", 1);
		
		assertNotEquals(ag1.hashCode(), ag2.hashCode());
		assertEquals(ag1.hashCode(), ag3.hashCode());
		
	}
	
	@Test
	public void testEquals() {
		ag2.cadastraContato("Matheus", "Gaudencio", "(83) 99999-0000", 1);
		ag3 = null;
		Agenda ag4 = new Agenda();
		ag4.cadastraContato("Matheus", "Gaudencio", "(83) 99999-0000", 4);
		Contato cont = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
		
		assertTrue(ag1.equals(ag1));
		assertTrue(ag1.equals(ag2));
		assertFalse(ag1.equals(ag3));
		assertFalse(ag1.equals(cont));
		assertFalse(ag1.equals(ag4));
	}

}
