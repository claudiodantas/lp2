package lab4FranciclaudioDantas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	
	@BeforeEach
	public void setUp() {
		this.aluno1 = new Aluno("250", "Gabriel Reyes", "Computacao");
		this.aluno2 = new Aluno("250", "Rafael Ferreira", "Computacao"); 
		this.aluno3 = new Aluno("555", "Veronica Souza", "Matematica");
	}
	
	@Test
	public void testContrutor() {
		assertEquals("250", this.aluno1.getMatricula());
		assertEquals("Gabriel Reyes", this.aluno1.getNome());
		assertEquals("Computacao", this.aluno1.getCurso());
	}
	
	@Test
	public void testArgumentoNulo() {
		try {
			new Aluno(null, "Gabriel Reyes", "Computacao");
			fail("Era esperada uma exceção!");
		} catch (NullPointerException npe) {}
		
		try {
			new Aluno("250", null, "Computacao");
			fail("Era esperada uma exceção!");
		} catch (NullPointerException npe) {}
		
		try {
			new Aluno("250", "Gabriel Reyes", null);
		} catch (NullPointerException npe) {}
	}
	
	@Test
	public void testArgumentoVazio() {
		try {
			new Aluno("", "Gabriel Reyes", "Computacao");
			fail("Era esperada uma exceção!");
		} catch (IllegalArgumentException iae) {}
		
		try {
			new Aluno("250", "", "Computacao");
			fail("Era esperada uma exceção!");
		} catch (IllegalArgumentException iae) {}
		
		try {
			new Aluno("250", "Gabriel Reyes", "");
		} catch (IllegalArgumentException iae) {}
	}
	
	@Test
	public void testHashCode() {
		assertEquals(this.aluno1.hashCode(), this.aluno2.hashCode());
		assertNotEquals(this.aluno1.hashCode(), aluno3.hashCode());
		
	}
	
	@Test
	public void testEquals() {
		Aluno alunoNulo = null;
		Grupo grupo = new Grupo("Listas");
		
		assertTrue(this.aluno1.equals(this.aluno1));
		assertTrue(this.aluno1.equals(this.aluno2));
		assertFalse(this.aluno1.equals(this.aluno3));
		assertFalse(this.aluno1.equals(alunoNulo));
		assertFalse(this.aluno1.equals(grupo));
	}
	
	@Test
	public void testToString() {
		assertEquals("250 - Gabriel Reyes - Computacao", this.aluno1.toString());
	}

}
