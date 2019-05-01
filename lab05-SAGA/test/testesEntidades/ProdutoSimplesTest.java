package testesEntidades;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.ProdutoSimples;

/**
 * Classe para testar classe de produto
 * @author Isaias Martins
 *
 */
class ProdutoSimplesTest {

	/**
	 * Metodo para testar produto simples
	 */
	@Test
	void testProduto() {
		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("nome", "", 1));
		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("   ", "descrixao", 2));
		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("", " ",3));
		assertThrows(NullPointerException.class, () -> new ProdutoSimples("sanduba", "gostoso", -1));
		assertThrows(NullPointerException.class, () -> new ProdutoSimples(null, "", 1));
		assertThrows(NullPointerException.class, () -> new ProdutoSimples("120", null, 2));		
	}

	/**
	 * Metodo para testar toString
	 */
	@Test
	void testToString() {
		ProdutoSimples produto = new ProdutoSimples("Nome","Descricao",10.00);
		assertEquals(produto.toString(),"Nome - Descricao - R$10,00");
	}

	/**
	 * Metodo para testar equals
	 */
	@Test
	void testEqualsObject() {
		ProdutoSimples produto1 = new ProdutoSimples("Nome","Descricao",10.00);
		ProdutoSimples produto2 = new ProdutoSimples("Nome","Descricao",10.00);
		assertTrue(produto1.equals(produto2));
		
		ProdutoSimples produto3 = new ProdutoSimples("Nome","Desc",50.00);
		ProdutoSimples produto4 = new ProdutoSimples("N","Descricao",50.00);
		assertFalse(produto1.equals(produto3));
		assertFalse(produto2.equals(produto4));
	}

	/**
	 * Metodo para testar CompareTo
	 */
	@Test
	void testCompareTo() {
		ProdutoSimples produto1 = new ProdutoSimples("A","A",10.00);
		ProdutoSimples produto2 = new ProdutoSimples("A","B",10.00);

		ProdutoSimples produto4 = new ProdutoSimples("A","A",10.00);
		ProdutoSimples produto3 = new ProdutoSimples("B","A",10.00);
		
		assertEquals(produto1.compareTo(produto4), 0);
		assertEquals(produto2.compareTo(produto1), 1);

		assertEquals(produto3.compareTo(produto1), 1);
		assertEquals(produto1.compareTo(produto3), -1);
	}

}
