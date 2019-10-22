package lab02Franciclaudio;

import java.util.Arrays;

/**
* Representação de uma disciplina acadêmica. Toda disciplina precisa ter um nome, uma quantidade de horas
* de estudo dedicadas e quatro notas.
*
* @author Francicláudio Dantas da Silva - 118210343
*/

public class Disciplina {
	/**
	 * O nome da disciplina.
	 */
	private String nomeDisciplina;
	
	/**
	 * Quantidade de horas de estudo dedicadas.
	 */
	private int horasEstudo;
	
	/**
	 * Array que armazena quatro notas.
	 */
	private double[] notas = new double[4];
	
	/**
	 * Cria uma disciplina a partir do nome.
	 * 
	 * @param nomeDisciplina O nome da disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Calcula a média aritmética das quatro notas da disciplina.
	 * 
	 * @return a soma das 4 notas divida por 4.
	 */
	private double media() {
		double soma = 0;
		for (int i = 0; i < 4; i++) {
			soma += this.notas[i];
		}
		
		return soma/4;
	}
	
	/**
	 * Realiza uma incrementação de horas estudadas a partir do valor passado por parâmetro.
	 * 
	 * @param horasEstudo Horas de estudo
	 */
	public void cadastraHoras(int horasEstudo) {
		this.horasEstudo += horasEstudo;
	}
	
	/**
	 * Cadastra uma nota a partir da identificação da nota a ser alterada e seu valor.
	 * 
	 * @param nota Identificação da nota que será alterada
	 * @param valorNota Nota que será atribuída
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * Verifica se o aluno teve uma média maior ou igual a 7.
	 * 
	 * @return valor boolean igual a true se a média for maior ou igual a 7, ou valor boolean igual
	 * a false se a média for menor que 7.
	 */
	public boolean aprovado() {
		if (this.media() >= 7.0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Retorna a String que representa a Disciplina. A representação segue o formato:
	 * Nome da disciplina Quantidade de horas de estudo Média [Nota1, Nota2, Nota3, Nota4].
	 * 
	 * @return a representação em String de uma disciplina.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horasEstudo + " " 
				+ this.media() + " " + Arrays.toString(this.notas);
	}
}
