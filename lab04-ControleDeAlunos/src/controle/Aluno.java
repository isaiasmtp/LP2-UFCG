package controle;

/**
 * Classe que representa um aluno
 * 
 * @author Isaias Martins
 *
 */
public class Aluno {

	private String matricula;
	private String nome;
	private String curso;

	/**
	 * Construtor que cria um aluno, definindo matricula, nome e curso
	 * 
	 * @param matricula Matricula do Aluno
	 * @param nome      Nome do Aluno
	 * @param curso     Curso do Aluno
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (nome == null || matricula == null || curso == null) {
			throw new NullPointerException();

		} else if ("".equals(nome.trim()) || "".equals(curso.trim()) || "".equals(matricula.trim())) {
			throw new IllegalArgumentException();

		} else {
			this.matricula = matricula;
			this.nome = nome;
			this.curso = curso;
		}
	}

	/**
	 * Metodo String que retorna uma String com as informações do aluno.
	 */
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}

	/**
	 * hashCode gerado para comparar a matricula.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * equals gerado para comparar apenas a matricula e assim, retorna true caso a
	 * matricula seja igual e false caso seja diferente
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
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}
