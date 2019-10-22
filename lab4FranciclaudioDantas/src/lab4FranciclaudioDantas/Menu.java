package lab4FranciclaudioDantas;

/**
* Representação do Menu de um controle de alunos, grupos de estudo e associações entre eles.
* O Menu possui um objeto do tipo Scanner que lê o comando do usuário, e um objeto do tipo
* Controle que faz uma referenciação à classe que realiza as operações referentes ao comando passado.
*
* @author Francicláudio Dantas da Silva - 118210343
*/

import java.util.Scanner;

public class Menu {
	
	/**
	 * Responsável por inicializar o projeto, imprimir opções do Menu e recolher uma comando passado
	 * como entrada pelo usuário que, a depender, solicitará, ou não, outros atributos que serão
	 * passados como parâmetro para um objeto do tipo Controle que realizará as operações.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Objeto responsável por realizar operações de leitura de dados, a partir da classe Scanner.
		 */
		Scanner sc = new Scanner(System.in);
		
		/**
		 * Objeto responsácel por realizar operações presentes na classe Controle, a partir do
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
		 * Armazena o comando lido na entrada do usuário.
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
			System.out.print("Opção> ");
			opcao = sc.nextLine();
			
			if (opcao.equals("C")) {
				System.out.print("Matrícula: ");
				matricula = sc.nextLine();
				System.out.print("Nome: ");
				nomeAluno = sc.nextLine();
				System.out.print("Curso: ");
				curso = sc.nextLine();
				
				System.out.println(ctrl.cadastraAluno(matricula, nomeAluno, curso));
				
			} else if (opcao.equals("E")) {
				System.out.print("Matrícula: ");
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
					System.out.print("Matrícula: ");
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
					System.out.println("Opção inválida!");
				}
			} else if (opcao.equals("R")) {
				System.out.print("Matricula: ");
				matricula = sc.nextLine();
				
				System.out.println(ctrl.registraResposta(matricula));
				
			} else if (opcao.equals("I")) {
				System.out.println(ctrl.imprimeAlunosResponderam());
				
			} else if (!opcao.equals("O")) {
				System.out.println("Opção inválida!");
			}
			
		} while (!opcao.equals("O"));
		
		sc.close();
	}
	
}
