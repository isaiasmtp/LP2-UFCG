package testesEntidades;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.Fornecedor;
import entidades.Fornecedor;

/**
 * Classe para testar Fornecedor
 * @author Isaias Martins
 *
 */
class FornecedorTest {

	/**
	 * Metodo para testar fornecedor
	 */
	@Test
	void testFornecedor() {
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("nome", "", ""));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("   ", "descrixao", ""));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", " ",""));
		assertThrows(NullPointerException.class, () -> new Fornecedor("sanduba", "gostoso", null));
		assertThrows(NullPointerException.class, () -> new Fornecedor(null, "", ""));
		assertThrows(NullPointerException.class, () -> new Fornecedor("120", null,""));	
	}

	/**
	 *Metodo para testar toString 
	 */
	@Test
	void testToString() {
		Fornecedor fornecedor = new Fornecedor("Nome","email","telefone");
		assertEquals(fornecedor.toString(),"Nome - email - telefone");
	}

	/**
	 * Metodo para testar equals
	 */
	@Test
	void testEqualsObject() {
		Fornecedor fornecedor1 = new Fornecedor("Nome","email","telefone");
		Fornecedor fornecedor2 = new Fornecedor("Nome","email","telefone");
		
		Fornecedor fornecedor3 = new Fornecedor("Nome1","email","telefone");
		Fornecedor fornecedor4 = new Fornecedor("Nome2","email","telefone");
		
		assertTrue(fornecedor1.equals(fornecedor2));
		assertFalse(fornecedor3.equals(fornecedor4));
	}

	/**
	 * Metodo para testar CompareTo
	 */
	@Test
	void testCompareTo() {

		Fornecedor fornecedor1 = new Fornecedor("Nome","email","telefone");
		Fornecedor fornecedor2 = new Fornecedor("Nome","email","telefone");
		
		Fornecedor fornecedor3 = new Fornecedor("A","email","telefone");
		Fornecedor fornecedor4 = new Fornecedor("B","email","telefone");

		assertEquals(fornecedor1.compareTo(fornecedor2), 0);
		assertEquals(fornecedor3.compareTo(fornecedor4), -1);
		assertEquals(fornecedor4.compareTo(fornecedor3), 1);
	}

}
