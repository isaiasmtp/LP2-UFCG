package entidades;

import abstrato.ProdutoAbstract;

/**
 * Classe que representa um Produto.
 * 
 * @author Isaias Martins - 118110593
 *
 */
public class ProdutoSimples extends ProdutoAbstract implements Comparable {
	
	/**
	 * Constroi um Produto Simples
	 * 
	 * @param nome      Nome
	 * @param descricao Descricao
	 * @param preco     Preco
	 */
	public ProdutoSimples(String nome, String descricao, double preco) {
		excessoes.verificaEntradasProduto(nome, descricao, preco);
		super.nome = nome;
		super.descricao = descricao;
		this.preco = preco;

	}

}
