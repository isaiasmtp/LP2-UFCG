package controle;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe que representa um quadro com os alunos que respoderam.
 * 
 * @author Isaias Martins
 *
 */
public class Quadro {

	private ArrayList<Aluno> listaAlunos;

	/**
	 * Construtor que cria o ArrayList para armazenar os alunos em sequencia.
	 */
	public Quadro() {
		listaAlunos = new ArrayList<>();
	}

	/**
	 * Metodo para adicionar aluno que respondeu ao array.
	 * 
	 * @param aluno Aluno.
	 * @return True caso adicione, False caso não.
	 */
	public boolean addResposta(Aluno aluno) {
		if (aluno != null) {
			listaAlunos.add(aluno);
			return true;
		}
		return false;
	}

	/**
	 * Metodo que retorna uma String com os alunos que respoderam.
	 */
	public String toString() {
		String saida = "";
		for (int i = 0; i < listaAlunos.size(); i++) {
			saida += (i + 1) + ". " + listaAlunos.get(i).toString() + "\n";

		}
		return saida;
	}
}
