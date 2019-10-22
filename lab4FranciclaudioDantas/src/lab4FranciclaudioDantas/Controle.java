package lab4FranciclaudioDantas;

/**
* Representa��o do Controle de Alunos, possuindo um HashMap de alunos, um HashMap de grupos de estudo,
* e um ArrayList com os alunos que responderam quest�es no quadro.
*
* @author Francicl�udio Dantas da Silva - 118210343
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Controle {
	
	/**
	 * HashMap que armazena objetos do tipo Aluno, utilizando uma chave do tipo String, referente �
	 * matr�cula de cada aluno.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * HashMap que armazena objetos do tipo Grupo, utilizando uma String como chave, referente ao
	 * nome do grupo em letras min�sculas.
	 */
	private HashMap<String, Grupo> grupos;
	
	/**
	 * ArrayList que armazena objetos do tipo Aluno. Cada objeto diz respeito � um aluno
	 * que respondeu quest�es no quadro.
	 */
	private ArrayList<Aluno> alunosResponderam;
	
	/**
	 * Constr�i um objeto Controle inicializando os atributos 'alunos', 'grupos' e 'alunosResponderam'.
	 */
	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosResponderam = new ArrayList<>();
	}
	
	/**
	 * Retorna um HashMap com todos os alunos cadastrados.
	 * 
	 * @return HashMap com objetos do tipo alunos, referenciados pela matr�cula.
	 */
	public HashMap<String, Aluno> getAlunos(){
		return this.alunos;
	}
	
	/**
	 * Retorna um HashMap com todos os grupos cadastrados.
	 * 
	 * @return HashMap com objetos do tipo Grupo, referenciados pelo nome do grupo
	 * em letras min�sculas.
	 */
	public HashMap<String, Grupo> getGrupos(){
		return this.grupos;
	}
	
	/**
	 * Retorna um ArrayList com o registro de todos os alunos que responderam quest�es
	 * no quadro.
	 * 
	 * @return ArrayList de objetos do tipo Aluno.
	 */
	public ArrayList<Aluno> getAlunosResponderam(){
		return this.alunosResponderam;
	}
	
	/**
	 * Realiza o cadastro de um novo aluno.
	 * 
	 * @param matricula a matr�cula do aluno.
	 * @param nomeAluno o nome do aluno.
	 * @param curso o curso que o aluno faz.
	 * 
	 * @return "MATRICULA JA CADASTRADA!\n", se j� existir algum aluno com a mesma matr�cula
	 * 		    cadastrado, e "CADASTRO REALIZADO\n", se o cadastro ocorrer com sucesso.
	 */
	public String cadastraAluno(String matricula, String nomeAluno, String curso) {
		if (this.alunos.containsKey(matricula)) {
			return "MATRICULA J� CADASTRADA!\n";
		} else {
			this.alunos.put(matricula, new Aluno(matricula, nomeAluno, curso));
		}
		return "CADASTRO REALIZADO!\n";
	}
	
	/**
	 * Realiza a consulta de um aluno atrav�s da matr�cula.
	 * 
	 * @param matricula a matr�cula do aluno.
	 * 
	 * @return A representa��o em String do aluno se ele for cadastrado, e a mensagem 
	 * 		   "Aluno nao cadastrado.\n" caso ele n�o seja.
	 */
	public String consultaAluno(String matricula) {
		if (ehCadastrado(matricula)) {
			return "Aluno: " + this.alunos.get(matricula).toString() + "\n";
		}
		return "Aluno n�o cadastrado.\n";
	}
	
	/**
	 * Verifica se um aluno est� cadastrado no controle atrav�s de sua matr�cula.
	 * 
	 * @param matricula a matricula do aluno.
	 * 
	 * @return true se o aluno estiver contido no atributo 'alunos' e false se ele n�o estiver.
	 */
	private boolean ehCadastrado(String matricula) {
		if (this.alunos.containsKey(matricula)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Realiza o cadastro de um novo grupo.
	 * 
	 * @param nomeGrupo o nome do grupo.
	 * 
	 * @return "GRUPO JA CADASTRADO!\n", se o nome do grupo fizer refer�ncia a outro grupo
	 * 		    que j� est� registrado no atributo 'grupos', e "CADASTRO REALIZADO!\n" se 
	 * 			o cadastro ocorrer com sucesso.
	 */
	public String cadastraGrupo(String nomeGrupo) {
		if(this.grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "GRUPO J� CADASTRADO!\n";	
		} else {
			this.grupos.put(nomeGrupo.toLowerCase(), new Grupo(nomeGrupo));
		}
		return "CADASTRO REALIZADO!\n";
	}
	
	/**
	 * Realiza o alocamento de um aluno, especificado pela matr�cula, a um grupo, especificado
	 * pelo seu nome.
	 * 
	 * @param matricula a matr�cula do aluno.
	 * @param nomeGrupo o nome do grupo.
	 * 
	 * @return "Aluno n�o cadastrado.\n", se o aluno n�o estiver registrado no controle;
	 * 		   "Grupo n�o cadastrado.\n", se o grupo n�o estiver registrado no controle;
	 * 		   Uma exce��o do tipo IllegalArgumentException, se aluno e o grupo n�o existirem 
	 * 		   no controle; e "ALUNO ALOCADO!\n", se a aloca��o ocorrer com sucesso.
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		if (this.grupos.containsKey(nomeGrupo.toLowerCase())) {
			if (this.alunos.containsKey(matricula)) {
				grupos.get(nomeGrupo.toLowerCase()).alocaAluno(alunos.get(matricula));
			}else {
				return "Aluno n�o cadastrado.\n";
			}
		} else if (this.alunos.containsKey(matricula)){
			return "Grupo n�o cadastrado.\n";
		} else {
			throw new IllegalArgumentException("Grupo e Aluno n�o cadastrados no controle.");
		}
		return "ALUNO ALOCADO!\n";
	}
	
	/**
	 * Imprime a representa��o textual de um grupo, a partir do nome passado como par�metro.
	 * 
	 * @param nomeGrupo o nome do grupo.
	 * 
	 * @return A representa��o textual de um grupo, caso ele esteja cadastrado, e 
	 * 		   "Grupo n�o cadastrado.\n", caso o grupo n�o esteja cadastrado.
	 */
	public String imprimeGrupo(String nomeGrupo) {
		if (!grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "Grupo n�o cadastrado.\n";
		}
		return grupos.get(nomeGrupo.toLowerCase()).toString();
	}
	
	/**
	 * Realiza o registro de um aluno que respondeu � uma quest�o no quadro em 'alunosResponderam'.
	 * 
	 * @param matricula a matr�cula do aluno.
	 * 
	 * @return "ALUNO REGISTRADO!\n", caso o registro ocorra com sucesso, e "Aluno n�o cadastrado.\n"
	 * 		   caso o aluno n�o esteja cadastrado no controle.
	 */
	public String registraResposta(String matricula) {
		if (!alunos.containsKey(matricula)) {
			return "Aluno n�o cadastrado.\n";
		}
		alunosResponderam.add(alunos.get(matricula));
		return "ALUNO REGISTRADO!\n";
	}
	
	/**
	 * Imprime os alunos que responderam quest�es no quadro.
	 * 
	 * @return representa��o textual dos alunos que responderam quest�es no quadro.
	 */
	public String imprimeAlunosResponderam() {
		String listaAlunosResponderam = "";
		for (int i = 0; i < alunosResponderam.size(); i++) {
			listaAlunosResponderam = listaAlunosResponderam + (i+1) + ". "
									+ alunosResponderam.get(i).toString() + "\n";
		}
		return "Alunos:\n" + listaAlunosResponderam;
	}

}
