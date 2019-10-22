package lab03FranciclaudioDantas;

/**
 * Representação de uma agenda telefônica. Toda agenda possui um array de contatos.
 * 
 * @author Francicláudio Dantas da Silva - 118210343
 */

import java.util.Arrays;

public class Agenda {
	
	/**
	 * Array de objetos da classe Contato
	 */
	private Contato[] contato;
	
	/**
	 * Constrói uma agenda telefônica a partir da inicialização de um array de objetos da classe Contato
	 * com 100 posições.
	 */
	public Agenda() {
		this.contato = new Contato[100];
	}
	
	/**
	 * Retorna o array com os contatos.
	 * 
	 * @return array do tipo Contato.
	 */
	public Contato[] getContatos() {
		return this.contato;
	}
	
	/**
	 * Realiza o cadastro de um novo contato na Agenda em uma das 100 posições do array contato.
	 * 
	 * @param nome o nome do contato.
	 * @param sobrenome o sobrenome do contado.
	 * @param telefone o número de telefone do contato, no formato (XX) XXXXX-XXXX.
	 * @param posicao a posição onde o contato será armazenado no array.
	 * @return true se o cadastro for realizado e false caso contrário.
	 */
	public boolean cadastraContato(String nome, String sobrenome, String telefone, int posicao) {
		if (posicao <= 100 && posicao > 0) {
			this.contato[(posicao-1)] = new Contato(nome, sobrenome, telefone);
			return true;
		}
		return false;
	}
	
	/**
	 * Exibe um contato da agenda especificado por sua posição no array contato.
	 * 
	 * @param posicao a posição no array que o contato a ser exibido está localizado.
	 * @return a representação em String do contato se for passada uma posição valida, e
	 * 		   a mensagem "POSICAO INVALIDA!" caso a posição não seja válida.
	 */
	public String exibeContato(int posicao) {
		if (!(this.contato[(posicao-1)] == null)) {
			return this.contato[(posicao-1)].toString();
		} else {
			return "POSICAO INVALIDA!";
		}
	}
	
	/**
	 * Faz a listagem de todos os contatos em posições válidas do array contato.
	 * 
	 * @return uma String com a representação de todos os contatos válidos.
	 */
	public String listaContatos() {
		String contatos = "";
		int indice = 1;
		for (int i = 0; i < 100; i++) {
			if (this.contato[i] != (null)) {
				contatos = contatos + indice + " - " + this.contato[i].getNome() + " " 
							+ this.contato[i].getSobrenome() + "\n";
			}
			
			indice += 1;
		}
		return contatos;
	}

	/**
	 * Método hashCode() sobreescrito. Não foram realizadas alterações.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contato);
		return result;
	}
	
	/**
	 * Método equals() sobreescrito. Não foram realizadas alterações.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contato, other.contato))
			return false;
		return true;
	}
	
}
