package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Aluno;
import controle.Grupo;
import controle.Sistema;

/**
 * Classe que testa o Sistema
 * 
 * @author Isaias Martins
 *
 */
class SistemaTest {

	Sistema sistema1;
	Sistema sistema2;

	/**
	 * Inicia sistema1 e sistema2 Cadastra alunos ao sistema1
	 */
	@BeforeEach
	public void setUp() {
		sistema1 = new Sistema();
		sistema2 = new Sistema();

		sistema1.cadastraAluno("200", "Isaias", "CC");
		sistema1.cadastraAluno("201", "Isaias", "CC");
		sistema1.cadastraAluno("202", "Isaias", "CC");
		sistema1.cadastraAluno("203", "Isaias", "CC");

	}

	/**
	 * Teste do cadastro de grupos.
	 */
	@Test
	void testCadastraGrupo() {
		assertTrue(sistema1.cadastraGrupo("CC"));
		assertTrue(sistema1.cadastraGrupo("aa"));

		assertFalse(sistema1.cadastraGrupo("aA"));
		assertFalse(sistema1.cadastraGrupo("Aa"));
		assertFalse(sistema1.cadastraGrupo("AA"));
		assertFalse(sistema1.cadastraGrupo("aa"));

		assertThrows(NullPointerException.class, () -> sistema1.cadastraGrupo(null));
		assertThrows(IllegalArgumentException.class, () -> sistema1.cadastraGrupo(""));
		assertThrows(IllegalArgumentException.class, () -> sistema1.cadastraGrupo(" "));

	}

	/**
	 * Testa o cadastro de alunos.
	 */
	@Test
	void testCadastraAluno() {
		assertTrue(sistema1.cadastraAluno("120", "Isaias", "CC"));
		assertTrue(sistema1.cadastraAluno("001", "He", "CC"));
		assertFalse(sistema1.cadastraAluno("120", "ZePqueno", "AA"));

		assertThrows(NullPointerException.class, () -> sistema1.cadastraAluno(null, "Isaias", "CC"));
		assertThrows(NullPointerException.class, () -> sistema1.cadastraAluno("003", "Isaias", null));
		assertThrows(NullPointerException.class, () -> sistema1.cadastraAluno("004", null, "CC"));

		assertThrows(NullPointerException.class, () -> sistema1.cadastraAluno(null, "Isaias", null));
		assertThrows(NullPointerException.class, () -> sistema1.cadastraAluno(null, null, null));
		assertThrows(NullPointerException.class, () -> sistema1.cadastraAluno("002", null, null));

		assertThrows(IllegalArgumentException.class, () -> sistema1.cadastraAluno("010", " ", ""));
		assertThrows(IllegalArgumentException.class, () -> sistema1.cadastraAluno("011", "Isaias", " "));
		assertThrows(IllegalArgumentException.class, () -> sistema1.cadastraAluno("", "Isaias", "AA"));
		assertThrows(IllegalArgumentException.class, () -> sistema1.cadastraAluno(" ", "Isaias", "AA"));
	}

	/**
	 * Teste o metodo que verifica a existencia de alunos.
	 */
	@Test
	void testExisteAlunoString() {
		assertTrue(sistema1.existeAluno("200"));
		assertFalse(sistema1.existeAluno("01"));

		String teste = null;

		assertThrows(IllegalArgumentException.class, () -> sistema1.existeAluno(""));
		assertThrows(IllegalArgumentException.class, () -> sistema1.existeAluno(" "));
		assertThrows(NullPointerException.class, () -> sistema1.existeAluno(teste));
	}

	/**
	 * Testa existencia de alunos.
	 */
	@Test
	void testExisteAlunoAluno() {

		Aluno aluno1 = new Aluno("200", "Isaias", "CC");
		Aluno aluno3 = new Aluno("100", "He", "cc");
		Aluno aluno4 = null;

		assertTrue(sistema1.existeAluno(aluno1));
		assertFalse(sistema1.existeAluno(aluno3));
		assertThrows(NullPointerException.class, () -> sistema1.existeAluno(aluno4));

	}

	/**
	 * Teste que verifica a existencia de grupos.
	 */
	@Test
	void testExisteGrupo() {

		sistema1.cadastraGrupo("CC");

		assertTrue(sistema1.existeGrupo("CC"));
		assertTrue(sistema1.existeGrupo("cc"));
		assertTrue(sistema1.existeGrupo("Cc"));
		assertFalse(sistema1.existeGrupo("AA"));
		assertFalse(sistema1.existeGrupo("Ca"));

		assertThrows(NullPointerException.class, () -> sistema1.existeGrupo(null));
	}

	/**
	 * Teste de exibição de Aluno.
	 */
	@Test
	void testExibirAluno() {
		Aluno aluno1 = new Aluno("200", "Isaias", "CC");
		assertEquals(sistema1.exibirAluno("200"), "\nAluno: " + aluno1.toString() + "\n");

		assertThrows(NullPointerException.class, () -> sistema1.exibirAluno(null));
		assertThrows(IllegalArgumentException.class, () -> sistema1.exibirAluno(""));
		assertThrows(IllegalArgumentException.class, () -> sistema1.exibirAluno(" "));
	}

	/**
	 * Teste do metodo que aloca alunos para o grupo.
	 */
	@Test
	void testAlocaAluno() {
		sistema2.cadastraGrupo("AA");
		sistema2.cadastraAluno("120", "Isaias", "cc");
		sistema2.cadastraAluno("121", "Isaias", "cc");

		assertTrue(sistema2.alocaAluno("120", "aa"));
		assertTrue(sistema2.alocaAluno("121", "Aa"));

		assertFalse(sistema2.alocaAluno("120", "AA"));
		assertFalse(sistema2.alocaAluno("120", "AA"));

		assertThrows(IllegalArgumentException.class, () -> sistema2.alocaAluno(" ", "AA"));
		assertThrows(IllegalArgumentException.class, () -> sistema2.alocaAluno("120", "  "));
		assertThrows(IllegalArgumentException.class, () -> sistema2.alocaAluno(" ", "  "));

		assertThrows(NullPointerException.class, () -> sistema2.alocaAluno("120", null));
		assertThrows(NullPointerException.class, () -> sistema2.alocaAluno(null, "aa"));
		assertThrows(NullPointerException.class, () -> sistema2.alocaAluno(null, null));
	}

	/**
	 * Teste de impressão de grupos.
	 */
	@Test
	void testImprimirGrupo() {
		sistema2.cadastraGrupo("lista");
		assertEquals(sistema2.imprimirGrupo("lista"), "");

		sistema2.cadastraAluno("120", "Isaias", "cc");
		sistema2.cadastraAluno("121", "Isaias", "cc");

		sistema2.alocaAluno("120", "lista");

		assertEquals(sistema2.imprimirGrupo("lista"), "* 120 - Isaias - cc\n");

		sistema2.alocaAluno("121", "lista");

		assertEquals(sistema2.imprimirGrupo("lista"), "* 120 - Isaias - cc\n* 121 - Isaias - cc\n");
	}

	/**
	 * Teste de adicionar aluno que respondeu ao quadro.
	 */
	@Test
	void testAdicionarResposta() {
		assertTrue(sistema1.adicionarResposta("200"));
		assertFalse(sistema1.adicionarResposta("000"));

		assertThrows(NullPointerException.class, () -> sistema1.adicionarResposta(null));
		assertThrows(IllegalArgumentException.class, () -> sistema1.adicionarResposta(" "));
	}

	/**
	 * Teste de imprimir alunos que responderam ao quadro.
	 */
	@Test
	void testImprimirRespostas() {
		assertEquals(sistema1.imprimirRespostas(), "");
		sistema1.adicionarResposta("200");
		assertEquals(sistema1.imprimirRespostas(), "1. 200 - Isaias - CC\n");
		sistema1.adicionarResposta("201");
		assertEquals(sistema1.imprimirRespostas(), "1. 200 - Isaias - CC\n2. 201 - Isaias - CC\n");

	}

}
