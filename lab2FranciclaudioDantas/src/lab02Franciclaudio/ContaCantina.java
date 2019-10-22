package lab02Franciclaudio;

/**
* Representa��o de uma conta em uma cantina da UFCG. Toda conta precisa ter o nome da cantina, quantidade
* de itens comprados, d�bito, e a soma de todos os gastos.
*
* @author Francicl�udio Dantas da Silva - 118210343
*/

public class ContaCantina {
	/**
	 * O nome da cantina.
	 */
	private String nomeDaCantina;
	
	/**
	 * Quantidade de unidades compradas.
	 */
	private int qntItens;
	
	/**
	 * Quantidade de dinheiro, em centavos, que est� sendo devida.
	 */
	private int debito;
	
	/**
	 * Quantidade de gastos, em centavos, sejam eles pagos ou n�o.
	 */
	private int soma;
	
	/**
	 * Constr�i uma conta a partir do nome da cantina.
	 * 
	 * @param nomeDaCantina o nome da cantina.
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
	}
	
	/**
	 * Realiza o cadastro de lanches comprados a partir da quantidade e do valor a ser pago em centavos.
	 * 
	 * @param qntItens quantidade de itens comprados.
	 * @param valorCentavos valor pago pelos itens, em centavos.
	 */
	public void cadastraLanche(int qntItens, int valorCentavos) {
		this.qntItens += qntItens;
		this.soma += valorCentavos;
		this.debito += valorCentavos;
		
	}
	
	/**
	 * Realiza o pagamento da quantidade especificada do d�bito em centavos.
	 * 
	 * @param valorCentavos o valor em centavos.
	 */
	public void pagaConta(int valorCentavos) {
		this.debito -= valorCentavos;
	}
	
	/**
	 * Retorna a d�vida que ainda n�o foi paga.
	 * 
	 * @return o valor em centavos do d�bito.
	 */
	public int getFaltaPagar() {
		return this.debito;
	}
	
	/**
	 * Realiza a representa��o em String de uma Conta. Essa representa��o � feita no formato:
	 * Nome da cantina Quantidade de itens comprados Soma dos gastos.
	 * 
	 * @return a representa��o em String de uma conta na cantina.
	 */
	public String toString() {
		return this.nomeDaCantina + " " + this.qntItens + " " + this.soma;
	}
}
