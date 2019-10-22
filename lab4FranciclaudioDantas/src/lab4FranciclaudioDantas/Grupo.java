package lab4FranciclaudioDantas;

/**
 * Representa��o de um grupo. Todo grupo precisa ter um nome, que � seu identificador �nico.
 * 
 * @author Francicl�udio Dantas da Silva - 118210343
 */

import java.util.HashSet;

public class Grupo {
	
	/**
	 * O nome do grupo.
	 */
	private String nome;
	
	/**
	 * Alunos que est�o cadastrados no grupo, em um HashSet do tipo Aluno.
	 */
	private HashSet<Aluno> alunos;
	
	/**
	 * Constr�i um grupo a partir do nome do grupo e a incializa��o do HashSet com os alunos alocados
	 * no grupo. Tamb�m � realizada a valida��o do par�metro, ou seja, verifica se ele � nulo ou vazio.
	 * 
	 * @param nome o nome do grupo
	 */
	public Grupo(String nome) {
		validaArgumento(nome);
		
		this.nome = nome;
		this.alunos = new HashSet<>();
	}
	
	/**
	 * Verifica se o par�metro do construtor � v�lido, ou seja, n�o � vazio e n�o � nulo, lan�ando
	 * uma exce��o do tipo IllegalArgumentException, caso o argumento seja vazio, e NullPointerException,
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
	 * @param aluno objeto do tipo Aluno que ser� alocado.
	 */
	public void alocaAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	/**
	 * M�todo HashCode() sobreescrito. Entre as altera��es feitas est� a remo��o da verifica��o 
	 * n�merica de atributos nulos, pois, levando em considera��o que argumentos nulos n�o podem 
	 * passar no construtor da classe, essa a��o n�o se faz mais necess�ria. O hash do atributo 'nome'
	 * � c�lculado a partir de sua vers�o com letras min�sculas.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nome.toLowerCase().hashCode();
		return result;
	}
	
	/**
	 * M�todo equals() sobreescrito. Entre as altera��es realizadas est� a remo��o da compara��o de objetos
	 * com argumentos nulos, visto que esse tratamento j� � feito previamente no construtor com o Null-
	 * -PointerException, portanto essa a��o n�o se faz mais necess�ria. O atributo 'nome' � verificado
	 * a partir de sua vers�o com letras min�sculas.
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
	 * M�todo toString() sobreescrito. Realiza a representa��o textual de um grupo. Essa representa��o
	 * � feita no formato: Alunos do grupo nomeDoGrupo:
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
