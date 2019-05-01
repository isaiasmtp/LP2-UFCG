package testesControllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import controllers.ControllerFornecedores;

/**
 * Classe para teste do COntrollerFornecedores
 * 
 * @author Isaias Martins
 *
 */
class ControllerFornecedoresTest {

	ControllerFornecedores fornecedores = new ControllerFornecedores();

	/**
	 * Teste para metodo para adicionar fornecedor
	 */
	@Test
	void testAdicionarFornecedor() {
		assertEquals(fornecedores.adicionarFornecedor("nome", "email", "telefone"), "nome");

		assertThrows(IllegalArgumentException.class, () -> fornecedores.adicionarFornecedor("nome", "", ""));
		assertThrows(IllegalArgumentException.class, () -> fornecedores.adicionarFornecedor("   ", "descrixao", ""));
		assertThrows(IllegalArgumentException.class, () -> fornecedores.adicionarFornecedor("", " ", ""));
		assertThrows(NullPointerException.class, () -> fornecedores.adicionarFornecedor("sanduba", "gostoso", null));
		assertThrows(NullPointerException.class, () -> fornecedores.adicionarFornecedor(null, "", ""));
		assertThrows(NullPointerException.class, () -> fornecedores.adicionarFornecedor("120", null, ""));
	}

	/**
	 * Teste de metodo para recuperar fornecedor
	 */
	@Test
	void testRecuperaFornecedor() {
		fornecedores.adicionarFornecedor("Isaias", "isaias@gmail.com", "4008-8922");

		assertEquals(fornecedores.recuperaFornecedor("Isaias"), "Isaias - isaias@gmail.com - 4008-8922");
	}

	/**
	 * Teste para editar fornecedor
	 */
	@Test
	void testEditarFornecedor() {
		fornecedores.adicionarFornecedor("Isaias", "isaias@gmail.com", "4008-8922");

		assertEquals(fornecedores.editarFornecedor("Isaias", "email", "a@a"), true);
		assertEquals(fornecedores.editarFornecedor("Isaias", "telefone", "0000"), true);

		assertThrows(IllegalArgumentException.class, () -> fornecedores.editarFornecedor("Isaias", "nome", "a@a"));
		assertThrows(IllegalArgumentException.class, () -> fornecedores.editarFornecedor("Isaias", "nome", "  "));
		assertThrows(IllegalArgumentException.class, () -> fornecedores.editarFornecedor("  ", "nome", "AA"));
		assertThrows(NullPointerException.class, () -> fornecedores.editarFornecedor("Isaias", null, "a@a"));
	}

	/**
	 * Teste para remover fornecedor
	 */
	@Test
	void testRemoverFornecedor() {

		fornecedores.adicionarFornecedor("Isaias", "isaias@gmail.com", "4008-8922");
		assertEquals(fornecedores.removerFornecedor("Isaias"), true);
		assertThrows(IllegalArgumentException.class, () -> fornecedores.removerFornecedor(" "));
		assertThrows(NullPointerException.class, () -> fornecedores.removerFornecedor(null));
	}

	/**
	 * Teste para imprimir todos os fornecedores
	 */
	@Test
	void testImprimirTodosFornecedores() {
		fornecedores.adicionarFornecedor("System", "a@a", "0");
		fornecedores.adicionarFornecedor("Verilog", "b@b", "1");
		assertEquals(fornecedores.imprimirTodosFornecedores(), "System - a@a - 0 | Verilog - b@b - 1");
	}

	/**
	 * Teste de adicao de produto
	 */
	@Test
	void testAdicionaProduto() {
		ControllerFornecedores fornecedores1 = new ControllerFornecedores();
		fornecedores1.adicionarFornecedor("a", "a@a", "0");

		assertEquals(fornecedores1.adicionaProdutoSimples("a", "Misto", "Gostoso", 2), true);
	}

	/**
	 * Teste de exibicao de produto
	 */
	@Test
	void testExibeProduto() {

		ControllerFornecedores fornecedores1 = new ControllerFornecedores();
		fornecedores1.adicionarFornecedor("a", "a@a", "0");
		fornecedores1.adicionaProdutoSimples("a", "Misto", "Gostoso", 2);
		assertEquals(fornecedores1.exibeProduto("Misto", "Gostoso", "a"), "Misto - Gostoso - R$2,00");
	}

	/**
	 * Teste na exibicao dos produtos de um fornecedor
	 */
	@Test
	void testExibeProdutosFornecedor() {

		ControllerFornecedores fornecedores2 = new ControllerFornecedores();
		fornecedores2.adicionarFornecedor("a", "a@a", "0");
		fornecedores2.adicionaProdutoSimples("a", "Misto", "Gostoso", 2);

		assertEquals(fornecedores2.exibeProdutosFornecedor("a"), "a - Misto - Gostoso - R$2,00");
	}

	/**
	 * Teste de exibicao de todos os produtos
	 */
	@Test
	void testExibeProdutos() {
		ControllerFornecedores fornecedores1 = new ControllerFornecedores();
		fornecedores1.adicionarFornecedor("a", "a@a", "0");
		fornecedores1.adicionaProdutoSimples("a", "Misto", "Gostoso", 2);
		assertEquals(fornecedores1.exibeProdutos(), "a - Misto - Gostoso - R$2,00");
	}

	/**
	 * Teste de edicao de produtos
	 */
	@Test
	void testEditaProduto() {
		ControllerFornecedores fornecedores1 = new ControllerFornecedores();
		fornecedores1.adicionarFornecedor("a", "a@a", "0");
		fornecedores1.adicionaProdutoSimples("a", "Misto", "Gostoso", 2);

		assertEquals(fornecedores1.editaProduto("Misto", "Gostoso", "a", 5), true);
		assertThrows(IllegalArgumentException.class, () -> fornecedores1.editaProduto("Misto", "Gostoso", "a", -5));
	}

	/**
	 * Teste de remocao de produtos
	 */
	@Test
	void testRemoveProduto() {
		ControllerFornecedores fornecedores1 = new ControllerFornecedores();
		fornecedores1.adicionarFornecedor("a", "a@a", "0");
		fornecedores1.adicionaProdutoSimples("a", "Misto", "Gostoso", 2);

		assertEquals(fornecedores1.removeProduto("Misto", "Gostoso", "a"), true);
		assertThrows(IllegalArgumentException.class, () -> fornecedores1.removeProduto("  ", "Gostoso", "a"));
		assertThrows(IllegalArgumentException.class, () -> fornecedores1.removeProduto("Misto", "  ", "a"));
		assertThrows(IllegalArgumentException.class, () -> fornecedores1.removeProduto("Misto", "Gostoso", " "));
	}

}
