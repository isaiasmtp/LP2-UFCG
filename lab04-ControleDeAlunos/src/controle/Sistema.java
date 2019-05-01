package controle;

import java.util.HashMap;

/**
 * Classe controladora.
 * 
 * @author Isaias Martins.
 *
 */
public class Sistema {

	private HashMap<String, Aluno> mapaAlunos;
	private HashMap<String, Grupo> mapaGrupo;
	private Quadro quadro;

	/**
	 * Construtor do Sistema. Inicializa o mapa de alunos, mapa de grupos e o
	 * quadro.
	 */
	public Sistema() {
		mapaAlunos = new HashMap<>();
		mapaGrupo = new HashMap<>();
		quadro = new Quadro();
	}

	/**
	 * Metodo para cadastro de grupos no sistema.
	 * 
	 * @param nome Nome do Grupo.
	 * @return True caso adicione, False caso não consiga adicionar.
	 */
	public boolean cadastraGrupo(String nome) {
		if (!existeGrupo(nome.toLowerCase())) {
			this.mapaGrupo.put(nome.toLowerCase(), new Grupo(nome));
			return true;
		}
		return false;
	}

	/**
	 * Metodo para cadastrar Alunos no sistema.
	 * 
	 * @param matricula Matricula do Aluno.
	 * @param nome      Nome do Alunos.
	 * @param curso     Curso do Aluno.
	 * @return True caso adicione, False caso não consiga adicionar.
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		if (!existeAluno(matricula)) {
			this.mapaAlunos.put(matricula, new Aluno(matricula, nome, curso));
			return true;
		}
		return false;
	}

	/**
	 * Metodo que verifica se existe aluno no mapa.
	 * 
	 * @param matricula Matricula do Aluno
	 * @return True caso tenha, False caso não tenha.
	 */
	public boolean existeAluno(String matricula) {
		if (matricula == null) {
			throw new NullPointerException();
		} else if ("".equals(matricula.trim())) {
			throw new IllegalArgumentException();
		}

		return this.mapaAlunos.containsKey(matricula);

	}

	/**
	 * Metodo que verifica se existe aluno no mapa.
	 * 
	 * @param aluno Objeto Aluno
	 * @return True caso tenha, False caso não tenha.
	 */
	public boolean existeAluno(Aluno aluno) {
		if (aluno == null) {
			throw new NullPointerException();
		}
		return this.mapaAlunos.containsValue(aluno);
	}

	/**
	 * Meotodo para verificar existencia de grupo no mapa de Grupos
	 * 
	 * @param nome Nome do Grupo.
	 * @return True caso tenha, False caso não tenha.
	 */
	public boolean existeGrupo(String nome) {
		if (nome == null) {
			throw new NullPointerException();
		}
		return this.mapaGrupo.containsKey(nome.toLowerCase());
	}

	/**
	 * Metodo que returna toString do aluno com a matricula passada por parametro
	 * caso esteja cadastrado.
	 * 
	 * @param matricula Matricula do Aluno.
	 * @return String Aluno não cadastrado, caso não esteja cadastrado no mapa ou
	 *         toString do aluno
	 */
	public String exibirAluno(String matricula) {
		if (matricula == null) {
			throw new NullPointerException();

		} else if ("".equals(matricula.trim())) {
			throw new IllegalArgumentException();

		}

		if (!existeAluno(matricula)) {
			return "\n" + "Aluno não cadastrado." + "\n";
		} else {
			return "\nAluno: " + mapaAlunos.get(matricula).toString() + "\n";
		}

	}

	/**
	 * Metodo que Aloca aluno cadastrado para o grupo cadastrado.
	 * 
	 * @param matricula Matricula do Aluno.
	 * @param nome      Nome do grupo.
	 * @return True caso adicione, False caso não consiga adicionar.
	 */
	public boolean alocaAluno(String matricula, String nome) {
		if (matricula == null) {
			throw new NullPointerException();

		} else if ("".equals(matricula.trim())) {
			throw new IllegalArgumentException();
		}

		if (nome == null) {
			throw new NullPointerException();

		} else if ("".equals(nome.trim())) {
			throw new IllegalArgumentException();
		}

		Grupo grupo = mapaGrupo.get(nome.toLowerCase());
		Aluno aluno = mapaAlunos.get(matricula.toLowerCase());

		return grupo.cadastraAluno(aluno);

	}

	/**
	 * Metodo para imprimir alunos do grupo.
	 * 
	 * @param nome Nome do grupo.
	 * @return String com os alunos do grupo.
	 */
	public String imprimirGrupo(String nome) {
		if (nome == null) {
			throw new NullPointerException();

		} else if ("".equals(nome.trim())) {
			throw new IllegalArgumentException();
		}

		Grupo grupo = mapaGrupo.get(nome.toLowerCase());
		return grupo.toString();
	}

	/**
	 * Metodo para adicionar alunos que respoderam ao Quadro.
	 * 
	 * @param matricula Matricula do Aluno.
	 * @return True caso adicione, False caso não consiga adicionar.
	 */
	public boolean adicionarResposta(String matricula) {
		if (matricula == null) {
			throw new NullPointerException();

		} else if ("".equals(matricula.trim())) {
			throw new IllegalArgumentException();
		}

		Aluno aluno = mapaAlunos.get(matricula.toLowerCase());

		return quadro.addResposta(aluno);

	}

	/**
	 * Metodo para imprimir alunos que respoderam as perguntas.
	 * 
	 * @return String dos alunos que foram adicionados em sequencia.
	 */
	public String imprimirRespostas() {
		return quadro.toString();
	}
}
