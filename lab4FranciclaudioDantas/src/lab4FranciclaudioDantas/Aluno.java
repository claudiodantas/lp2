package lab4FranciclaudioDantas;

/**
 * Representa��o de um aluno. Todo aluno precisa ter um nome e o curso que ele frequenta, al�m de
 * uma matr�cula como identificador �nico.
 * 
 * @author Francicl�udio Dantas da Silva - 118210343
 */

public class Aluno {
	
	/**
	 * A matr�cula do aluno.
	 */
	private String matricula;
	
	/**
	 * O nome do aluno.
	 */
	private String nome;
	
	/**
	 * O curso que o aluno frequenta.
	 */
	private String curso;
	
	/**
	 * Constr�i um Aluno a partir da matr�cula, do nome e do curso, e verifica se os par�metros
	 * s�o v�lidos, ou seja, n�o s�o nulos e nem vazios.
	 * 
	 * @param matricula a matr�cula do aluno.
	 * @param nome o nome do aluno.
	 * @param curso o curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		validaArgumentos(matricula, nome, curso);
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Verifica se os par�metros do construtor s�o v�lidos, ou seja, n�o s�o vazios e n�o s�o nulos, lan�ando
	 * uma exce��o do tipo IllegalArgumentException, caso o argumento seja vazio, e NullPointerException,
	 * caso o argumento seja nulo.
	 * 
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	private void validaArgumentos(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Matricula n�o pode ser nula!");
		}
		if (matricula.trim().equals("")) {
			throw new IllegalArgumentException("Matr�cula n�o pode ser vazia!");
		}
		if (nome == null) {
			throw new NullPointerException("Nome n�o pode ser nulo!");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome n�o pode ser vazio!");
		}
		if (curso == null) {
			throw new NullPointerException("Curso n�o pode ser nulo!");
		}
		if (curso.trim().equals("")) {
			throw new IllegalArgumentException("Curso n�o pode ser vazio!");
		}
	}
	
	/**
	 * Retorna a matr�cula do aluno.
	 * 
	 * @return a matricula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Retorna o nome do aluno.
	 * 
	 * @return o nome do aluno.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o curso do aluno.
	 * 
	 * @return o curso do aluno.
	 */
	public String getCurso() {
		return this.curso;
	}
	
	/**
	 * M�todo HashCode() sobreescrito. Entre as altera��es feitas est� a remo��o da verifica��o 
	 * n�merica de atributos nulos, pois, levando em considera��o que argumentos nulos n�o podem 
	 * passar no construtor da classe, essa a��o n�o se faz mais necess�ria.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula.hashCode();
		return result;
	}
	
	/**
	 * M�todo equals() sobreescrito. Entre as altera��es realizadas est� a remo��o da compara��o de objetos
	 * com argumentos nulos, visto que esse tratamento j� � feito previamente no construtor com o Null-
	 * -PointerException, portanto essa a��o n�o se faz mais necess�ria.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	/**
	 * M�todo toString() sobreescrito. Realiza a representa��o textual de um aluno. Essa representa��o
	 * � feita no formato: Matricula - Nome - Curso
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	
}
