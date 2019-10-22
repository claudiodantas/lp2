package lab4FranciclaudioDantas;

/**
 * Representação de um aluno. Todo aluno precisa ter um nome e o curso que ele frequenta, além de
 * uma matrícula como identificador único.
 * 
 * @author Francicláudio Dantas da Silva - 118210343
 */

public class Aluno {
	
	/**
	 * A matrícula do aluno.
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
	 * Constrói um Aluno a partir da matrícula, do nome e do curso, e verifica se os parâmetros
	 * são válidos, ou seja, não são nulos e nem vazios.
	 * 
	 * @param matricula a matrícula do aluno.
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
	 * Verifica se os parâmetros do construtor são válidos, ou seja, não são vazios e não são nulos, lançando
	 * uma exceção do tipo IllegalArgumentException, caso o argumento seja vazio, e NullPointerException,
	 * caso o argumento seja nulo.
	 * 
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	private void validaArgumentos(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Matricula não pode ser nula!");
		}
		if (matricula.trim().equals("")) {
			throw new IllegalArgumentException("Matrícula não pode ser vazia!");
		}
		if (nome == null) {
			throw new NullPointerException("Nome não pode ser nulo!");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome não pode ser vazio!");
		}
		if (curso == null) {
			throw new NullPointerException("Curso não pode ser nulo!");
		}
		if (curso.trim().equals("")) {
			throw new IllegalArgumentException("Curso não pode ser vazio!");
		}
	}
	
	/**
	 * Retorna a matrícula do aluno.
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
	 * Método HashCode() sobreescrito. Entre as alterações feitas está a remoção da verificação 
	 * númerica de atributos nulos, pois, levando em consideração que argumentos nulos não podem 
	 * passar no construtor da classe, essa ação não se faz mais necessária.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula.hashCode();
		return result;
	}
	
	/**
	 * Método equals() sobreescrito. Entre as alterações realizadas está a remoção da comparação de objetos
	 * com argumentos nulos, visto que esse tratamento já é feito previamente no construtor com o Null-
	 * -PointerException, portanto essa ação não se faz mais necessária.
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
	 * Método toString() sobreescrito. Realiza a representação textual de um aluno. Essa representação
	 * é feita no formato: Matricula - Nome - Curso
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	
}
