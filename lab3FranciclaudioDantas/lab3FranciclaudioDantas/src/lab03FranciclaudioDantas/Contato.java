package lab03FranciclaudioDantas;

/**
* Representação de um contato. Todo contato precisa ter um nome, sobrenome e número de telefone.
*
* @author Francicláudio Dantas da Silva - 118210343
*/

public class Contato {
	
	/**
	 * O primeiro nome do contato
	 */
	private String nome;
	
	/**
	 * O sobrenome do contato
	 */
	private String sobrenome;
	
	/**
	 * O número de telefone do contato no formato (XX) XXXX-XXXX
	 */
	private String telefone;
	
	/**
	 * Constrói um contato a partir do nome, do sobrenome e do número de telefone, e verifica se
	 * o argumento de cada um deles é válido, ou seja, não são nulos ou vazios.
	 * 
	 * @param nome o primeiro nome do contato.
	 * @param sobrenome o sobrenome do contato.
	 * @param telefone o número de telefone do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		validaParametros(nome, sobrenome, telefone);
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Verifica se os argumentos passados como parâmetro no método construtor são válidos.
	 * 
	 * @param nome o nome do contato.
	 * @param sobrenome o sobrenome do contato.
	 * @param telefone o telefone do contato.
	 */
	private void validaParametros(String nome, String sobrenome, String telefone) {
		if (nome == null) {
			throw new NullPointerException("Nome não pode ser nulo!");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome não pode ser vazio!");
		}
		if (sobrenome == null) {
			throw new NullPointerException("Sobrenome não pode ser nulo!");
		}
		if (sobrenome.trim().equals("")) {
			throw new IllegalArgumentException("Sobrenome não pode ser vazio!");
		}
		if (telefone == null) {
			throw new NullPointerException("Telefone não pode ser nulo!");
		}
		if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone não pode ser vazio!");
		}
	}
	
	/**
	 * Retorna o nome do contato.
	 * 
	 * @return o nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o sobrenome do contato.
	 * 
	 * @return o sobrenome do contato.
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * Retorna o número de telefone do contato.
	 * 
	 * @return o número de telefone do contato
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/**
	 * Realiza a representação em String de um contato. Essa representação é feita no formato:
	 * Nome Sobrenome - (XX) XXXX-XXXX
	 * 
	 * @return a representação em String de um contato.
	 */
	@Override
	public String toString() {
		return this.nome + " " + sobrenome + " - " + this.telefone;
	}
	
	/**
	 * Método hashCode() sobreescrito. Entre as alterações feitas está a remoção da verificação númerica de atributos nulos, pois,
	 * levando em consideração que argumentos nulos não podem passar no construtor da classe, essa ação não se faz mais necessária.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nome.hashCode();
		result = prime * result + sobrenome.hashCode();
		return result;
	}
	
	/**
	 * Método equals() sobreescrito. Entre as alterações realizadas está a remoção da comparação de objetos com argumentos nulos, visto
	 * que esse tratamento já é feito previamente no construtor com o Null Pointer Exception, portanto essa ação não se faz mais necessária.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (!nome.equals(other.nome))
			return false;
		if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}
	
}
