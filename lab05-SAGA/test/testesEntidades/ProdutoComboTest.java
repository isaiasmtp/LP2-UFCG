package testesEntidades;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import abstrato.ProdutoAbstract;
import entidades.ProdutoCombo;
import entidades.ProdutoSimples;

/**
 * Classe de teste de produto Combo
 * @author Isaias Martins
 *
 */
class ProdutoComboTest {

	/**
	 * Teste do construtor
	 */
	@Test
	void testProdutoCombo() {
		ArrayList<ProdutoAbstract> produtos = new ArrayList<>();

		ProdutoSimples produto1 = new ProdutoSimples("X","TUDO",10.00);
		ProdutoSimples produto2 = new ProdutoSimples("X","BACON", 15.00);

		ProdutoSimples produto4 = new ProdutoSimples("X","EGG",12.00);
		ProdutoSimples produto3 = new ProdutoSimples("X","FIT",10.00);
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		
		ProdutoCombo combo1 =  new ProdutoCombo("Combo", "Top", 0.25,produtos);
		
		assertThrows(IllegalArgumentException.class, () -> new ProdutoCombo("  ", "Top", 0.25,produtos));
		assertThrows(IllegalArgumentException.class, () -> new ProdutoCombo("Combo", "  ", 0.25,produtos));
		assertThrows(IllegalArgumentException.class, () -> new ProdutoCombo("Combo", "Top", -1 ,produtos));
		assertThrows(IllegalArgumentException.class, () -> new ProdutoCombo("Combo", "Top", 1,produtos));
		
		assertThrows(NullPointerException.class, () -> new ProdutoCombo(null, "Top", 0.25,produtos));
		assertThrows(NullPointerException.class, () -> new ProdutoCombo("top", null, 0.25,produtos));
		assertThrows(IllegalArgumentException.class, () -> new ProdutoCombo("Combo", "Top", 1, null));
	}

	/**
	 * Teste de atualizar fator
	 */
	@Test
	void testSetFator() {
		ArrayList<ProdutoAbstract> produtos = new ArrayList<>();

		ProdutoSimples produto1 = new ProdutoSimples("X","TUDO",10.00);
		ProdutoSimples produto2 = new ProdutoSimples("X","BACON", 15.00);

		ProdutoSimples produto4 = new ProdutoSimples("X","EGG",12.00);
		ProdutoSimples produto3 = new ProdutoSimples("X","FIT",10.00);
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		
		ProdutoCombo combo1 =  new ProdutoCombo("Combo", "Top", 0.25,produtos);
		assertEquals(combo1.toString(),"Combo - Top - R$35,25");
		combo1.setFator(0.90);
		assertEquals(combo1.toString(),"Combo - Top - R$4,70");	
	}

}
