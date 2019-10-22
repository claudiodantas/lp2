package lab4FranciclaudioDantas;

/**
 * Representação de um grupo. Todo grupo precisa ter um nome, que é seu identificador único.
 * 
 * @author Francicláudio Dantas da Silva - 118210343
 */

import java.util.HashSet;

public class Grupo {
	
	/**
	 * O nome do grupo.
	 */
	private String nome;
	
	/**
	 * Alunos que estão cadastrados no grupo, em um HashSet do tipo Aluno.
	 */
	private HashSet<Aluno> alunos;
	
	/**
	 * Constrói um grupo a partir do nome do grupo e a incialização do HashSet com os alunos alocados
	 * no grupo. Também é realizada a validação do parâmetro, ou seja, verifica se ele é nulo ou vazio.
	 * 
	 * @param nome o nome do grupo
	 */
	public Grupo(String nome) {
		validaArgumento(nome);
		
		this.nome = nome;
		this.alunos = new HashSet<>();
	}
	
	/**
	 * Verifica se o parâmetro do construtor é válido, ou seja, não é vazio e não é nulo, lançando
	 * uma exceção do tipo IllegalArgumentException, caso o argumento seja vazio, e NullPointerException,
	 * caso o argumento seja nulo.
	 * 
	 * @param nome o nome do grupo.
	 */
	private void validaArgumento(String nome) {
		if (nome == null) {
			throw new NullPointerException("O nome do grupo nao pode ser nulo");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("O nome do grupo nao pode ser vazio");
		}
	}
	
	/**
	 * Retorna o nome do grupo.
	 * 
	 * @return o nome do grupo.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna um HashSet com todos os alunos alocados no grupo.
	 * 
	 * @return HashSet com objetos do tipo Aluno.
	 */
	public HashSet<Aluno> getAlunos(){
		return this.alunos;
	}
	
	/**
	 * Realiza o alocamento de um aluno ao grupo.
	 * 
	 * @param aluno objeto do tipo Aluno que será alocado.
	 */
	public void alocaAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	/**
	 * Método HashCode() sobreescrito. Entre as alterações feitas está a remoção da verificação 
	 * númerica de atributos nulos, pois, levando em consideração que argumentos nulos não podem 
	 * passar no construtor da classe, essa ação não se faz mais necessária. O hash do atributo 'nome'
	 * é cálculado a partir de sua versão com letras minúsculas.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nome.toLowerCase().hashCode();
		return result;
	}
	
	/**
	 * Método equals() sobreescrito. Entre as alterações realizadas está a remoção da comparação de objetos
	 * com argumentos nulos, visto que esse tratamento já é feito previamente no construtor com o Null-
	 * -PointerException, portanto essa ação não se faz mais necessária. O atributo 'nome' é verificado
	 * a partir de sua versão com letras minúsculas.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (!nome.toLowerCase().equals(other.nome.toLowerCase()))
			return false;
		return true;
	}
	
	/**
	 * Método toString() sobreescrito. Realiza a representação textual de um grupo. Essa representação
	 * é feita no formato: Alunos do grupo nomeDoGrupo:
	 * 					   * Matricula - NomeAluno - Curso
	 * 						...[continua].
	 */
	@Override
	public String toString() {
		String listaAlunos = "";
		for (Aluno aluno: alunos) {
			listaAlunos = listaAlunos + "* " + aluno.toString() + "\n";
		}
		return "Alunos do grupo " + this.nome + ":\n" + listaAlunos;
	}
}
