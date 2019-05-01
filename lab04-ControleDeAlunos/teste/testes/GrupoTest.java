package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import controle.Aluno;
import controle.Grupo;

/**
 * Classe de teste do Grupo.
 * 
 * @author Isaías Martins.
 *
 */
class GrupoTest {

	/**
	 * Teste do contrutor de Grupo.
	 */
	@Test
	void testGrupo() {
		assertThrows(IllegalArgumentException.class, () -> new Grupo(""));
		assertThrows(IllegalArgumentException.class, () -> new Grupo("   "));
		assertThrows(NullPointerException.class, () -> new Grupo(null));
	}

	/**
	 * Teste do cadastro de alunos no grupo.
	 */
	@Test
	void testCadastraAluno() {
		Aluno aluno1 = new Aluno("120", "Isaias", "cc");
		Grupo grupo = new Grupo("comp");

		assertTrue(grupo.cadastraAluno(aluno1));
		assertFalse(grupo.cadastraAluno(aluno1));
	}

	/**
	 * Teste do toString de Grupo. Imprimi todos os alunos cadastrados no grupo.
	 */
	@Test
	void testToString() {
		Aluno aluno1 = new Aluno("120", "Isaias", "cc");
		Aluno aluno2 = new Aluno("121", "He", "cc");

		Grupo grupo1 = new Grupo("CC");
		grupo1.cadastraAluno(aluno1);
		grupo1.cadastraAluno(aluno2);

		Grupo grupo2 = new Grupo("AA");

		assertEquals(grupo1.toString(),
				"* 120" + " - " + "Isaias" + " - " + "cc\n" + "* 121" + " - " + "He" + " - " + "cc\n");
		assertEquals(grupo2.toString(), "");

	}

	/**
	 * Teste do equals de grupo Compara por nome, e não importa se é maior ou
	 * minusculo.
	 */
	@Test
	void testEqualsObject() {

		Grupo grupo1 = new Grupo("CC");
		Grupo grupo2 = new Grupo("cc");
		Grupo grupo3 = new Grupo("AA");
		Grupo grupo4 = new Grupo("CC");

		assertFalse(grupo1.equals(grupo2));
		assertFalse(grupo1.equals(grupo3));
		assertTrue(grupo1.equals(grupo4));

	}

}
