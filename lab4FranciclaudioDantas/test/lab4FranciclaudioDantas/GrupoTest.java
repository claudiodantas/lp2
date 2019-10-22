package lab4FranciclaudioDantas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoTest {
	
	private Grupo grupo1;
	private Grupo grupo2;
	private Grupo grupo3;
	private Aluno aluno1;
	private Aluno aluno2;
	private HashSet<Aluno> alunos;
	
	@BeforeEach
	public void setUp() {
		this.grupo1 = new Grupo("Listas");
		this.grupo2 = new Grupo("listas");
		this.grupo3 = new Grupo("Cálculo");
		this.aluno1 = new Aluno("250", "Gabriel Reyes", "Computacao");
		this.aluno2 = new Aluno("250", "Angela Ziegler", "Medicina");
		this.alunos = new HashSet<>();
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Listas", this.grupo1.getNome());
		
	}
	
	@Test
	public void testArgumentoNulo() {
		try {
			new Grupo(null);
			fail("Era esperada uma exceção!");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	public void testArgumentoVazio() {
		try {
			new Grupo("");
			fail("Era esperada uma exceção!");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	public void testAlocaAluno() {
		this.alunos.add(this.aluno1);
		this.grupo1.alocaAluno(this.aluno1);
		assertEquals(this.alunos, this.grupo1.getAlunos());
		
		this.grupo1.alocaAluno(aluno2);
		assertEquals(this.alunos, this.grupo1.getAlunos());
	}
	
	@Test
	public void testHashCode() {
		assertNotEquals(this.grupo1.hashCode(), this.grupo3.hashCode());
		assertEquals(this.grupo1.hashCode(), this.grupo2.hashCode());
	}
	
	@Test
	public void testEquals() {
		assertTrue(this.grupo1.equals(this.grupo1));
		assertTrue(this.grupo1.equals(this.grupo2));
		assertFalse(this.grupo1.equals(this.grupo3));
		
		Aluno aluno = null;
		assertFalse(this.grupo1.equals(aluno));
		assertFalse(this.grupo1.equals(this.aluno1));
		
	}
	
	@Test
	public void testToString() {
		assertEquals("Alunos do grupo Listas:\n", this.grupo1.toString());
		this.grupo1.alocaAluno(this.aluno1);
		assertEquals("Alunos do grupo Listas:\n* 250 - Gabriel Reyes - Computacao\n", this.grupo1.toString());
	}

}
