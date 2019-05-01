package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.Aluno;
import controle.Quadro;

/**
 * Classe de teste do Quadro.
 * 
 * @author Isaias Martins.
 *
 */
class QuadroTest {

	/**
	 * Teste da adição de respostas ao quadro.
	 */
	@Test
	void testAddResposta() {
		Aluno aluno1 = new Aluno("001", "isaias", "cc");
		Quadro quadro = new Quadro();

		assertTrue(quadro.addResposta(aluno1));
		assertTrue(quadro.addResposta(aluno1));

		Aluno aluno0 = null;

		assertFalse(quadro.addResposta(aluno0));
	}

	/**
	 * Teste de impressão de Alunos que responderam ao quadro.
	 */
	@Test
	void testImprimirAlunos() {
		Aluno aluno1 = new Aluno("001", "isaias", "cc");
		Aluno aluno2 = new Aluno("002", "He", "aa");

		Quadro quadro = new Quadro();
		Quadro quadro2 = new Quadro();

		quadro.addResposta(aluno1);
		quadro.addResposta(aluno1);

		assertEquals(quadro.toString(), "1. 001 - isaias - cc\n2. 001 - isaias - cc\n");

		quadro.addResposta(aluno2);

		assertEquals(quadro.toString(), "1. 001 - isaias - cc\n2. 001 - isaias - cc\n3. 002 - He - aa\n");
		assertEquals(quadro2.toString(), "");
	}

}
