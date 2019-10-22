package lab02Franciclaudio;

/**
 * Representa��o do estado de sa�de de um aluno. Toda representa��o de sa�de deve constar o estado
 * da sa�de f�sica e da sa�de mental do aluno.
 * 
 * @author Francicl�udio Dantas da Silva - 118210343
 *
 */

public class Saude {
	
	/**
	 * Representa��o em String da sa�de f�sica do aluno, podendo ser da forma "boa" ou "fraca".
	 */
	private String saudeFisica;
	
	/**
	 * Representa��o da sa�de mental do aluno, podendo ser da forma "boa" ou "fraca".
	 */
	private String saudeMental;
	
	/**
	 * Constr�i o estado de sa�de do aluno atribuindo, por padr�o, o valor "boa" para a sa�de mental
	 * e para a sa�de f�sica.
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
	}
	
	/**
	 * Atribui o valor da sa�de mental do aluno.
	 * 
	 * @param valor o valor da sa�de mental do aluno.
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}
	
	/**
	 * Atribui o valor da sa�de f�sica do aluno.
	 * 
	 * @param valor o valor da sa�de f�sica do aluno.
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}
	
	/**
	 * Retorna o estado de sa�de do aluno.
	 * 
	 * @return  A String "fraca" caso os valores da sa�de mental e da sa�de f�sica 
	 * sejam igualmente "fraca", a String "ok" caso um dos estados de sa�de seja "fraca" e
	 * o outro "boa", ou a String "boa" caso os dois estados de sa�de sejam "boa".
	 */
	public String getStatusGeral() {
		if (saudeFisica.equals("fraca")) {
			if (saudeMental.equals("fraca")) {
				return "fraca";
			} else {
				return "ok";
			}
		} else {
			if (saudeMental.equals("boa")) {
				return "boa";
			} else {
				return "ok";
			}
		}
	}
	
}
