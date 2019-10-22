package lab02Franciclaudio;

/**
* Representa��o de uma conta nos laborat�rios de computa��o da UFCG.
* Toda conta precisa ter o nome do laborat�rio, a quantidade de espa�o dispon�vel para
* o usu�rio ocupar e a quantidade de espa�o que ele j� ocupou.
*
* @author Francicl�udio Dantas da Silva - 118210343
*/

public class ContaLaboratorio {
	/**
	 * O nome do laborat�rio
	 */
	private String nomeLaboratorio;
	
	/**
	 * A quantidade de espa�o ocupado pelo propriet�rio da conta, em MegaBytes
	 */
	private int espacoOcupado;
	
	/**
	 * A quantidade de espa�o dispon�vel para o usu�rio utilizar, em MegaBytes
	 */
	private int cota;
	
	
	/**
	 * Constr�i uma conta a partir do nome do laborat�rio.
	 * Por padr�o, quando n�o indicado nos par�metros, a cota dos usu�rios come�a em 2000.
	 * 
	 * @param nomeLaboratorio o nome do laborat�rio.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
	}
	
	/**
	 * Constr�i uma conta a partir do nome do laborat�rio e da cota de espa�o reservado na mem�ria
	 * para o usu�rio.
	 * 
	 * @param nomeLaboratorio o nome do laborat�rio.
	 * @param cota a cota de espa�o reservado.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * Atualiza a quantidade de espa�o utilizada pelo usu�rio.
	 * 
	 * @param mbytes quantidade de espa�o consumido, em MegaBytes.
	 */
    public void consomeEspaco(int mbytes) {
    	espacoOcupado += mbytes;
    }
    
    /**
     * Libera o espa�o desocupado pelo usu�rio.
     * 
     * @param mbytes quantidade de espa�o liberado, em MegaBytes.
     */
    
    public void liberaEspaco(int mbytes) {
    	espacoOcupado -= mbytes;
    }
    
    /**
     * Informa se a cota de mem�ria foi atingida.
     * 
     * @return valor boolean true, se a cota foi atingida, 
     * ou valor boolean false, caso ainda n�o tenha sido atingida.
     */
    public boolean atingiuCota() {
    	if (this.espacoOcupado >= this.cota) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * Retorna a String que representa uma conta no laborat�rio. A representa��o segue o formato: 
     * Nome do Laborat�rio Espa�o ocupado/Cota
     * 
     * @return a representa��o em String de uma conta no laborat�rio.
     */
    
    public String toString() {
    	return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
    }
}
