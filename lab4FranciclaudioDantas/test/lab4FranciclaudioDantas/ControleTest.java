package lab4FranciclaudioDantas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleTest {
	
	private Controle ctrl;
	
	@BeforeEach
	public void setUp() {
		this.ctrl = new Controle();
	}
	
	@Test
	public void testConstrutor() {
		assertEquals((new HashMap<String, Aluno>()), this.ctrl.getAlunos());
		assertEquals((new HashMap<String, Grupo>()), this.ctrl.getGrupos());
		assertEquals((new ArrayList<Aluno>()), this.ctrl.getAlunosResponderam());
	}
	
	@Test
	public void testCadastraAluno() {
		assertEquals("CADASTRO REALIZADO!\n", this.ctrl.cadastraAluno("250", "Gabriel Reyes", "Computacao"));
		assertEquals("MATRICULA JÁ CADASTRADA!\n", this.ctrl.cadastraAluno("250", "Rafael Ferreira", "Psicologia"));
	}
	
	@Test
	public void testConsultaAluno() {
		this.ctrl.cadastraAluno("250", "Gabriel Reyes", "Computacao");
		assertEquals("Aluno: 250 - Gabriel Reyes - Computacao\n", this.ctrl.consultaAluno("250"));
		
		assertEquals("Aluno não cadastrado.\n", this.ctrl.consultaAluno("123"));
	}
	
	@Test
	public void testCadastraGrupo() {
		assertEquals("CADASTRO REALIZADO!\n", this.ctrl.cadastraGrupo("Listas"));
		assertEquals("GRUPO JÁ CADASTRADO!\n", this.ctrl.cadastraGrupo("listas"));
	}
	
	@Test
	public void testAlocaAluno() {
		this.ctrl.cadastraGrupo("Cálculo");
		this.ctrl.cadastraAluno("250", "Gabriel Reyes", "Computacao");
		assertEquals("ALUNO ALOCADO!\n", this.ctrl.alocaAluno("250", "Cálculo"));
		assertEquals("ALUNO ALOCADO!\n", this.ctrl.alocaAluno("250", "cálculo"));
		assertEquals("Aluno não cadastrado.\n", this.ctrl.alocaAluno("123", "Cálculo"));
		assertEquals("Grupo não cadastrado.\n", this.ctrl.alocaAluno("250", "Vetorial"));
		
		try {
			this.ctrl.alocaAluno("123", "Vetorial");
			fail("Era esperada uma exceção!");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	public void testImprimeGrupo() {
		this.ctrl.cadastraGrupo("Listas");
		assertEquals("Alunos do grupo Listas:\n", this.ctrl.imprimeGrupo("Listas"));
		
		this.ctrl.cadastraAluno("250", "Gabriel Reyes", "Computacao");
		this.ctrl.alocaAluno("250", "Listas");
		assertEquals("Alunos do grupo Listas:\n* 250 - Gabriel Reyes - Computacao\n", this.ctrl.imprimeGrupo("Listas"));
		
		assertEquals("Grupo não cadastrado.\n", this.ctrl.imprimeGrupo("Filosofia"));
	}
	
	@Test
	public void testRegistraResposta() {
		this.ctrl.cadastraGrupo("Listas");
		assertEquals("Aluno não cadastrado.\n", this.ctrl.registraResposta("123"));
		
		this.ctrl.cadastraAluno("250", "Gabriel Reyes", "Computacao");
		assertEquals("ALUNO REGISTRADO!\n", this.ctrl.registraResposta("250"));
	}
	
	@Test
	public void testImprimeAlunosResponderam() {
		assertEquals("Alunos:\n", this.ctrl.imprimeAlunosResponderam());
		this.ctrl.cadastraGrupo("Listas");
		this.ctrl.cadastraAluno("250", "Gabriel Reyes", "Computacao");
		this.ctrl.registraResposta("250");
		assertEquals("Alunos:\n1. 250 - Gabriel Reyes - Computacao\n", this.ctrl.imprimeAlunosResponderam());
		
	}
}
