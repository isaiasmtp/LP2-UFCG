package testesControllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.ControllerClientes;

/**
 * Classe de teste do controller de clientes
 * 
 * @author Isaias Martins
 *
 */
class ControllerClientesTest {

	ControllerClientes clientes = new ControllerClientes();

	/**
	 * Teste de adicao de clientes
	 */
	@Test
	void testAdicionarCliente() {
		assertEquals(clientes.adicionarCliente("00000000000", "nome", "email", "SPLAB AMEM"), "00000000000");

		assertThrows(IllegalArgumentException.class,
				() -> clientes.adicionarCliente("00000000", "nome", "email", "SPLAB AMEM"));
		assertThrows(IllegalArgumentException.class,
				() -> clientes.adicionarCliente("00000000000", " ", "email", "SPLAB AMEM"));
		assertThrows(IllegalArgumentException.class,
				() -> clientes.adicionarCliente("00000000000", "nome", "  ", "SPLAB AMEM"));
		assertThrows(IllegalArgumentException.class,
				() -> clientes.adicionarCliente("00000000000", "nome", "EMAIL", "  "));

		assertThrows(NullPointerException.class, () -> clientes.adicionarCliente(null, "nome", "email", "SPLAB AMEM"));
		assertThrows(NullPointerException.class,
				() -> clientes.adicionarCliente("00000000000", null, "email", "SPLAB AMEM"));
		assertThrows(NullPointerException.class,
				() -> clientes.adicionarCliente("00000000000", "nome", null, "SPLAB AMEM"));
		assertThrows(NullPointerException.class, () -> clientes.adicionarCliente("00000000000", "nome", "email", null));
	}

	/**
	 * Teste de recuperar um cliente
	 */
	@Test
	void testRecuperaCliente() {
		clientes.adicionarCliente("00000000000", "nome", "email", "SPLAB AMEM");
		assertEquals(clientes.recuperaCliente("00000000000"), "nome - SPLAB AMEM - email");

		assertThrows(IllegalArgumentException.class, () -> clientes.recuperaCliente("0000000"));
		assertThrows(IllegalArgumentException.class, () -> clientes.recuperaCliente(" "));
		assertThrows(NullPointerException.class, () -> clientes.recuperaCliente(null));
	}

	/**
	 * Teste de edicao de cliente
	 */
	@Test
	void testEditarCliente() {
		clientes.adicionarCliente("00000000000", "nome", "email", "SPLAB AMEM");
		clientes.editarCliente("00000000000", "nome", "novoNome");
		assertEquals(clientes.recuperaCliente("00000000000"), "novoNome - SPLAB AMEM - email");
		clientes.editarCliente("00000000000", "email", "novoEmail");
		assertEquals(clientes.recuperaCliente("00000000000"), "novoNome - SPLAB AMEM - novoEmail");
		clientes.editarCliente("00000000000", "localizacao", "VETEX");
		assertEquals(clientes.recuperaCliente("00000000000"), "novoNome - VETEX - novoEmail");
	}

	/**
	 * Teste de remocao de cliente
	 */
	@Test
	void testRemoverCliente() {
		clientes.adicionarCliente("00000000000", "nome", "email", "SPLAB AMEM");
		assertEquals(clientes.recuperaCliente("00000000000"), "nome - SPLAB AMEM - email");
		assertEquals(clientes.removerCliente("00000000000"), true);
		assertThrows(IllegalArgumentException.class, () -> clientes.recuperaCliente("000000000000"));
		assertEquals(clientes.removerCliente("000000111"), false);
	}

	/**
	 * Teste de impressao de todos os clientes
	 */
	@Test
	void testImprimirTodosClientes() {
		clientes.adicionarCliente("00000000000", "nome", "email", "SPLAB AMEM");
		clientes.adicionarCliente("00000000001", "nome", "email", "SPLAB AMEM");
		clientes.adicionarCliente("00000000002", "nome", "email", "SPLAB AMEM");

		assertEquals(clientes.imprimirTodosClientes(),
				"nome - SPLAB AMEM - email | nome - SPLAB AMEM - email | nome - SPLAB AMEM - email");
	}

}
