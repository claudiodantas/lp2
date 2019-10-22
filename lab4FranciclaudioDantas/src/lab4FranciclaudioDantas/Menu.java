package lab4FranciclaudioDantas;

/**
* Representa��o do Menu de um controle de alunos, grupos de estudo e associa��es entre eles.
* O Menu possui um objeto do tipo Scanner que l� o comando do usu�rio, e um objeto do tipo
* Controle que faz uma referencia��o � classe que realiza as opera��es referentes ao comando passado.
*
* @author Francicl�udio Dantas da Silva - 118210343
*/

import java.util.Scanner;

public class Menu {
	
	/**
	 * Respons�vel por inicializar o projeto, imprimir op��es do Menu e recolher uma comando passado
	 * como entrada pelo usu�rio que, a depender, solicitar�, ou n�o, outros atributos que ser�o
	 * passados como par�metro para um objeto do tipo Controle que realizar� as opera��es.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Objeto respons�vel por realizar opera��es de leitura de dados, a partir da classe Scanner.
		 */
		Scanner sc = new Scanner(System.in);
		
		/**
		 * Objeto respons�cel por realizar opera��es presentes na classe Controle, a partir do
		 * comando lido.
		 */
		Controle ctrl = new Controle();
		
		/**
		 * Matricula do aluno.
		 */
		String matricula;
		
		/**
		 * Nome do aluno.
		 */
		String nomeAluno;
		
		/**
		 * Curso do aluno.
		 */
		String curso;
		
		/**
		 * Nome do grupo.
		 */
		String nomeGrupo;
		
		/**
		 * Armazena o comando lido na entrada do usu�rio.
		 */
		String opcao;
		
		do {
			System.out.println("(C)adastrar Aluno");
			System.out.println("(E)xibir Aluno");
			System.out.println("(N)ovo Grupo");
			System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
			System.out.println("(R)egistrar Aluno que Respondeu");
			System.out.println("(I)mprimir Alunos que Responderam");
			System.out.println("(O)ra, vamos fechar o programa!\n");
			System.out.print("Op��o> ");
			opcao = sc.nextLine();
			
			if (opcao.equals("C")) {
				System.out.print("Matr�cula: ");
				matricula = sc.nextLine();
				System.out.print("Nome: ");
				nomeAluno = sc.nextLine();
				System.out.print("Curso: ");
				curso = sc.nextLine();
				
				System.out.println(ctrl.cadastraAluno(matricula, nomeAluno, curso));
				
			} else if (opcao.equals("E")) {
				System.out.print("Matr�cula: ");
				matricula = sc.nextLine();
				System.out.print("\n");
				
				System.out.println(ctrl.consultaAluno(matricula));
				
			} else if (opcao.equals("N")) {
				System.out.print("Grupo: ");
				nomeGrupo = sc.nextLine();
				
				System.out.println(ctrl.cadastraGrupo(nomeGrupo));
				
			} else if (opcao.equals("A")) {
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				String opcao2 = sc.nextLine();
				if (opcao2.equals("A")) {
					System.out.print("Matr�cula: ");
					matricula = sc.nextLine();
					System.out.print("Grupo: ");
					nomeGrupo = sc.nextLine();
					
					System.out.println(ctrl.alocaAluno(matricula, nomeGrupo));
					
				} else if (opcao2.equals("I")) {
					System.out.print("Grupo: ");
					nomeGrupo = sc.nextLine();
					System.out.print("");
					
					System.out.println(ctrl.imprimeGrupo(nomeGrupo));
					
				} else {
					System.out.println("Op��o inv�lida!");
				}
			} else if (opcao.equals("R")) {
				System.out.print("Matricula: ");
				matricula = sc.nextLine();
				
				System.out.println(ctrl.registraResposta(matricula));
				
			} else if (opcao.equals("I")) {
				System.out.println(ctrl.imprimeAlunosResponderam());
				
			} else if (!opcao.equals("O")) {
				System.out.println("Op��o inv�lida!");
			}
			
		} while (!opcao.equals("O"));
		
		sc.close();
	}
	
}
