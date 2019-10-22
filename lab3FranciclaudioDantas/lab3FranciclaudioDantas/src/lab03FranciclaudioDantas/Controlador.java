package lab03FranciclaudioDantas;

/**
 * Criada com o objetivo de tornar mais legível e melhorar o design da classe principal Menu.
 * 
 * @author Francicláudio Dantas da Silva - 118210343
 */

import java.util.Scanner;

public class Controlador {
	
	/**
	 * Objeto do tipo Scanner.
	 */
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Objeto do tipo Agenda.
	 */
	Agenda agenda = new Agenda();
	
	/**
	 * Posição do contato na agenda.
	 */
	private int posicao;
	
	/**
	 * O primeiro nome do contato.
	 */
	private String nome;
	
	/**
	 * O sobrenome do contato.
	 */
	private String sobrenome;
	
	/**
	 * O telefone do contato.
	 */
	private String telefone;
	
	/**
	 * Realiza a solicitação do usuário a partir da opção passada como parâmetro na classe Menu.
	 * 
	 * @param opcao opção passada a partir da classe Menu.
	 * @return uma String referente ao resultado da operação realizada.
	 */
	public String leOpcao(String opcao) {
		if (opcao.equals("C")) {
			System.out.print("Posição: ");
			this.posicao = sc.nextInt();
			sc.nextLine();
			if (posicao <= 100 && posicao > 0) {
				System.out.print("Nome: ");
				this.nome = sc.nextLine();
				System.out.print("Sobrenome: ");
				this.sobrenome = sc.nextLine();
				System.out.print("Telefone: ");
				this.telefone = sc.nextLine();
				
				agenda.cadastraContato(this.nome, this.sobrenome, this.telefone, this.posicao);
					return "CADASTRO REALIZADO!\n";
				} else {
					return "POSICAOO INVALIDA!\n";
			}
			
		} else if (opcao.equals("L")) {
			return agenda.listaContatos();
			
		} else if (opcao.equals("E")) {
			System.out.print("Contato> ");
			this.posicao = sc.nextInt();
			
			return agenda.exibeContato(this.posicao);
			
		} else {
			if (!opcao.equals("S")) {
				return "OPCAO INVALIDA!\n";
			}
			return "";
		}
	}
	
}
