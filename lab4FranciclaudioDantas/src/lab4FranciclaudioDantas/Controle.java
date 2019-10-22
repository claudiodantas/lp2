package lab4FranciclaudioDantas;

/**
* Representação do Controle de Alunos, possuindo um HashMap de alunos, um HashMap de grupos de estudo,
* e um ArrayList com os alunos que responderam questões no quadro.
*
* @author Francicláudio Dantas da Silva - 118210343
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Controle {
	
	/**
	 * HashMap que armazena objetos do tipo Aluno, utilizando uma chave do tipo String, referente à
	 * matrícula de cada aluno.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * HashMap que armazena objetos do tipo Grupo, utilizando uma String como chave, referente ao
	 * nome do grupo em letras minúsculas.
	 */
	private HashMap<String, Grupo> grupos;
	
	/**
	 * ArrayList que armazena objetos do tipo Aluno. Cada objeto diz respeito à um aluno
	 * que respondeu questões no quadro.
	 */
	private ArrayList<Aluno> alunosResponderam;
	
	/**
	 * Constrói um objeto Controle inicializando os atributos 'alunos', 'grupos' e 'alunosResponderam'.
	 */
	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosResponderam = new ArrayList<>();
	}
	
	/**
	 * Retorna um HashMap com todos os alunos cadastrados.
	 * 
	 * @return HashMap com objetos do tipo alunos, referenciados pela matrícula.
	 */
	public HashMap<String, Aluno> getAlunos(){
		return this.alunos;
	}
	
	/**
	 * Retorna um HashMap com todos os grupos cadastrados.
	 * 
	 * @return HashMap com objetos do tipo Grupo, referenciados pelo nome do grupo
	 * em letras minúsculas.
	 */
	public HashMap<String, Grupo> getGrupos(){
		return this.grupos;
	}
	
	/**
	 * Retorna um ArrayList com o registro de todos os alunos que responderam questões
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
	 * @param matricula a matrícula do aluno.
	 * @param nomeAluno o nome do aluno.
	 * @param curso o curso que o aluno faz.
	 * 
	 * @return "MATRICULA JA CADASTRADA!\n", se já existir algum aluno com a mesma matrícula
	 * 		    cadastrado, e "CADASTRO REALIZADO\n", se o cadastro ocorrer com sucesso.
	 */
	public String cadastraAluno(String matricula, String nomeAluno, String curso) {
		if (this.alunos.containsKey(matricula)) {
			return "MATRICULA JÁ CADASTRADA!\n";
		} else {
			this.alunos.put(matricula, new Aluno(matricula, nomeAluno, curso));
		}
		return "CADASTRO REALIZADO!\n";
	}
	
	/**
	 * Realiza a consulta de um aluno através da matrícula.
	 * 
	 * @param matricula a matrícula do aluno.
	 * 
	 * @return A representação em String do aluno se ele for cadastrado, e a mensagem 
	 * 		   "Aluno nao cadastrado.\n" caso ele não seja.
	 */
	public String consultaAluno(String matricula) {
		if (ehCadastrado(matricula)) {
			return "Aluno: " + this.alunos.get(matricula).toString() + "\n";
		}
		return "Aluno não cadastrado.\n";
	}
	
	/**
	 * Verifica se um aluno está cadastrado no controle através de sua matrícula.
	 * 
	 * @param matricula a matricula do aluno.
	 * 
	 * @return true se o aluno estiver contido no atributo 'alunos' e false se ele não estiver.
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
	 * @return "GRUPO JA CADASTRADO!\n", se o nome do grupo fizer referência a outro grupo
	 * 		    que já está registrado no atributo 'grupos', e "CADASTRO REALIZADO!\n" se 
	 * 			o cadastro ocorrer com sucesso.
	 */
	public String cadastraGrupo(String nomeGrupo) {
		if(this.grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "GRUPO JÁ CADASTRADO!\n";	
		} else {
			this.grupos.put(nomeGrupo.toLowerCase(), new Grupo(nomeGrupo));
		}
		return "CADASTRO REALIZADO!\n";
	}
	
	/**
	 * Realiza o alocamento de um aluno, especificado pela matrícula, a um grupo, especificado
	 * pelo seu nome.
	 * 
	 * @param matricula a matrícula do aluno.
	 * @param nomeGrupo o nome do grupo.
	 * 
	 * @return "Aluno não cadastrado.\n", se o aluno não estiver registrado no controle;
	 * 		   "Grupo não cadastrado.\n", se o grupo não estiver registrado no controle;
	 * 		   Uma exceção do tipo IllegalArgumentException, se aluno e o grupo não existirem 
	 * 		   no controle; e "ALUNO ALOCADO!\n", se a alocação ocorrer com sucesso.
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		if (this.grupos.containsKey(nomeGrupo.toLowerCase())) {
			if (this.alunos.containsKey(matricula)) {
				grupos.get(nomeGrupo.toLowerCase()).alocaAluno(alunos.get(matricula));
			}else {
				return "Aluno não cadastrado.\n";
			}
		} else if (this.alunos.containsKey(matricula)){
			return "Grupo não cadastrado.\n";
		} else {
			throw new IllegalArgumentException("Grupo e Aluno não cadastrados no controle.");
		}
		return "ALUNO ALOCADO!\n";
	}
	
	/**
	 * Imprime a representação textual de um grupo, a partir do nome passado como parâmetro.
	 * 
	 * @param nomeGrupo o nome do grupo.
	 * 
	 * @return A representação textual de um grupo, caso ele esteja cadastrado, e 
	 * 		   "Grupo não cadastrado.\n", caso o grupo não esteja cadastrado.
	 */
	public String imprimeGrupo(String nomeGrupo) {
		if (!grupos.containsKey(nomeGrupo.toLowerCase())) {
			return "Grupo não cadastrado.\n";
		}
		return grupos.get(nomeGrupo.toLowerCase()).toString();
	}
	
	/**
	 * Realiza o registro de um aluno que respondeu à uma questão no quadro em 'alunosResponderam'.
	 * 
	 * @param matricula a matrícula do aluno.
	 * 
	 * @return "ALUNO REGISTRADO!\n", caso o registro ocorra com sucesso, e "Aluno não cadastrado.\n"
	 * 		   caso o aluno não esteja cadastrado no controle.
	 */
	public String registraResposta(String matricula) {
		if (!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.\n";
		}
		alunosResponderam.add(alunos.get(matricula));
		return "ALUNO REGISTRADO!\n";
	}
	
	/**
	 * Imprime os alunos que responderam questões no quadro.
	 * 
	 * @return representação textual dos alunos que responderam questões no quadro.
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
