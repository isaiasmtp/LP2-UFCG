package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.Aluno;

/**
 * Classe que testa Aluno.
 * 
 * @author Isaias Martins.
 *
 */
class AlunoTest {

	@Test
	/**
	 * Teste do construtor do Aluno
	 */
	void testAluno() {
		assertThrows(IllegalArgumentException.class, () -> new Aluno("", "", ""));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("   ", "", ""));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("", "   ", ""));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("", "", "   "));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("120", "Isaias", ""));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("120", "  ", "Computacao"));

		assertThrows(NullPointerException.class, () -> new Aluno(null, "", ""));
		assertThrows(NullPointerException.class, () -> new Aluno("120", null, "Computacao"));
		assertThrows(NullPointerException.class, () -> new Aluno("0", "Isaias", null));
	}

	/**
	 * Teste do toString de Aluno.
	 */
	@Test
	void testToString() {
		Aluno aluno1 = new Aluno("0", "Isaias", "Computacao");
		Aluno aluno2 = new Aluno("100", "He", "cc");

		assertEquals(aluno1.toString(), 0 + " - " + "Isaias" + " - " + "Computacao");
		assertEquals(aluno2.toString(), "100" + " - " + "He" + " - " + "cc");
	}

	/**
	 * Teste do equals que verifica igualdade pela matricula.
	 */
	@Test
	void testEqualsObject() {
		Aluno aluno1 = new Aluno("0", "Isaias", "Computacao");
		Aluno aluno2 = new Aluno("0", "Isaias", "Computacao");
		Aluno aluno3 = new Aluno("100", "He", "cc");
		Aluno aluno4 = new Aluno("100", "J", "AA");
		Aluno aluno5 = new Aluno("100", "J", "cc");

		assertEquals(aluno1.equals(aluno2), true);
		assertEquals(aluno1.equals(aluno3), false);
		assertEquals(aluno3.equals(aluno4), true);
		assertEquals(aluno4.equals(aluno5), true);
	}

}
