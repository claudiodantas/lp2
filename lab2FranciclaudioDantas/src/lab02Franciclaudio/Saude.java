package lab02Franciclaudio;

/**
 * Representação do estado de saúde de um aluno. Toda representação de saúde deve constar o estado
 * da saúde física e da saúde mental do aluno.
 * 
 * @author Francicláudio Dantas da Silva - 118210343
 *
 */

public class Saude {
	
	/**
	 * Representação em String da saúde física do aluno, podendo ser da forma "boa" ou "fraca".
	 */
	private String saudeFisica;
	
	/**
	 * Representação da saúde mental do aluno, podendo ser da forma "boa" ou "fraca".
	 */
	private String saudeMental;
	
	/**
	 * Constrói o estado de saúde do aluno atribuindo, por padrão, o valor "boa" para a saúde mental
	 * e para a saúde física.
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
	}
	
	/**
	 * Atribui o valor da saúde mental do aluno.
	 * 
	 * @param valor o valor da saúde mental do aluno.
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}
	
	/**
	 * Atribui o valor da saúde física do aluno.
	 * 
	 * @param valor o valor da saúde física do aluno.
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}
	
	/**
	 * Retorna o estado de saúde do aluno.
	 * 
	 * @return  A String "fraca" caso os valores da saúde mental e da saúde física 
	 * sejam igualmente "fraca", a String "ok" caso um dos estados de saúde seja "fraca" e
	 * o outro "boa", ou a String "boa" caso os dois estados de saúde sejam "boa".
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
