package controle;

import java.util.HashSet;

/**
 * Classe que representa um conjunto de estudantes e é definido por um nome que
 * é uma String.
 * 
 * @author Isaias Martins
 *
 */
public class Grupo {

	private HashSet<Aluno> conjuntoGrupo;
	private String nome;

	/**
	 * Construtor do Grupo com a String nome e cria o conjunto do Grupo para
	 * armazenar alunos.
	 * 
	 * @param nome Nome do grupo.
	 */
	public Grupo(String nome) {
		if (nome == null) {
			throw new NullPointerException();

		} else if ("".equals(nome.trim())) {
			throw new IllegalArgumentException();

		} else {
			this.nome = nome;
			conjuntoGrupo = new HashSet<>();
		}
	}

	/**
	 * Metodo para cadastrar aluno no grupo
	 * 
	 * @param aluno Objeto Aluno
	 * @return True caso seja adicionado ao conjunto, False caso não seja
	 *         adicionado.
	 */
	public boolean cadastraAluno(Aluno aluno) {
		if (aluno == null) {
			throw new NullPointerException();
		}
		return this.conjuntoGrupo.add(aluno);
	}

	/**
	 * Metodo que retorna uma String com todos os alunos cadastrados no grupo.
	 */
	public String toString() {
		String saida = "";
		for (Aluno aluno : conjuntoGrupo) {
			saida += "* " + aluno.toString() + "\n";
		}
		return saida;
	}

	/**
	 * hashCode sobrescrito para igualar pelo nome do grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * equals sobrescrito para igualar pelo nome do grupo.
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
