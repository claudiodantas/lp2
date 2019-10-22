package lab02Franciclaudio;

/**
* Representação de uma conta nos laboratórios de computação da UFCG.
* Toda conta precisa ter o nome do laboratório, a quantidade de espaço disponível para
* o usuário ocupar e a quantidade de espaço que ele já ocupou.
*
* @author Francicláudio Dantas da Silva - 118210343
*/

public class ContaLaboratorio {
	/**
	 * O nome do laboratório
	 */
	private String nomeLaboratorio;
	
	/**
	 * A quantidade de espaço ocupado pelo proprietário da conta, em MegaBytes
	 */
	private int espacoOcupado;
	
	/**
	 * A quantidade de espaço disponível para o usuário utilizar, em MegaBytes
	 */
	private int cota;
	
	
	/**
	 * Constrói uma conta a partir do nome do laboratório.
	 * Por padrão, quando não indicado nos parâmetros, a cota dos usuários começa em 2000.
	 * 
	 * @param nomeLaboratorio o nome do laboratório.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
	}
	
	/**
	 * Constrói uma conta a partir do nome do laboratório e da cota de espaço reservado na memória
	 * para o usuário.
	 * 
	 * @param nomeLaboratorio o nome do laboratório.
	 * @param cota a cota de espaço reservado.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * Atualiza a quantidade de espaço utilizada pelo usuário.
	 * 
	 * @param mbytes quantidade de espaço consumido, em MegaBytes.
	 */
    public void consomeEspaco(int mbytes) {
    	espacoOcupado += mbytes;
    }
    
    /**
     * Libera o espaço desocupado pelo usuário.
     * 
     * @param mbytes quantidade de espaço liberado, em MegaBytes.
     */
    
    public void liberaEspaco(int mbytes) {
    	espacoOcupado -= mbytes;
    }
    
    /**
     * Informa se a cota de memória foi atingida.
     * 
     * @return valor boolean true, se a cota foi atingida, 
     * ou valor boolean false, caso ainda não tenha sido atingida.
     */
    public boolean atingiuCota() {
    	if (this.espacoOcupado >= this.cota) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * Retorna a String que representa uma conta no laboratório. A representação segue o formato: 
     * Nome do Laboratório Espaço ocupado/Cota
     * 
     * @return a representação em String de uma conta no laboratório.
     */
    
    public String toString() {
    	return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
    }
}
