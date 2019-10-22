package lab02Franciclaudio;

import java.util.Arrays;

/**
* Representa��o de uma disciplina acad�mica. Toda disciplina precisa ter um nome, uma quantidade de horas
* de estudo dedicadas e quatro notas.
*
* @author Francicl�udio Dantas da Silva - 118210343
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
	 * Calcula a m�dia aritm�tica das quatro notas da disciplina.
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
	 * Realiza uma incrementa��o de horas estudadas a partir do valor passado por par�metro.
	 * 
	 * @param horasEstudo Horas de estudo
	 */
	public void cadastraHoras(int horasEstudo) {
		this.horasEstudo += horasEstudo;
	}
	
	/**
	 * Cadastra uma nota a partir da identifica��o da nota a ser alterada e seu valor.
	 * 
	 * @param nota Identifica��o da nota que ser� alterada
	 * @param valorNota Nota que ser� atribu�da
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * Verifica se o aluno teve uma m�dia maior ou igual a 7.
	 * 
	 * @return valor boolean igual a true se a m�dia for maior ou igual a 7, ou valor boolean igual
	 * a false se a m�dia for menor que 7.
	 */
	public boolean aprovado() {
		if (this.media() >= 7.0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Retorna a String que representa a Disciplina. A representa��o segue o formato:
	 * Nome da disciplina Quantidade de horas de estudo M�dia [Nota1, Nota2, Nota3, Nota4].
	 * 
	 * @return a representa��o em String de uma disciplina.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horasEstudo + " " 
				+ this.media() + " " + Arrays.toString(this.notas);
	}
}
