package entidades;

import java.util.ArrayList;
import java.util.List;

import abstrato.ProdutoAbstract;
import backend.Exceptions;

/**
 * Classe que representa um produto que e um combo
 * 
 * @author Isaias Martins
 *
 */
public class ProdutoCombo extends ProdutoAbstract {

	private List<ProdutoAbstract> produto;
	double fator;
	double valor;
	private Exceptions excessoes = new Exceptions();

	/**
	 * Construtor do combo
	 * 
	 * @param nome      Nome do Combo
	 * @param descricao Descricao do Combo
	 * @param fator     Fator de desconto do Combo
	 * @param produto   Produtos Simples que formam o combo
	 */
	public ProdutoCombo(String nome, String descricao, double fator, ArrayList<ProdutoAbstract> produto) {
		excessoes.verificaProdutoFator(fator, "");
		excessoes.verificaAtributoVazioNull(nome, "");
		excessoes.verificaAtributoVazioNull(descricao, "");

		super.nome = nome;
		super.descricao = descricao;
		this.produto = produto;
		this.fator = fator;

		super.preco = calculaPreco(produto) * (1 - fator);
	}

	/**
	 * Metodo para Calcular Preco do Combo
	 * 
	 * @param produto Produtos Simples
	 * @return somatorio dos valores dos produtos simples
	 */
	private double calculaPreco(ArrayList<ProdutoAbstract> produto) {
		double valor = 0;

		for (int i = 0; i < produto.size(); i++) {

			valor += produto.get(i).getPreco();

		}
		this.valor = valor;
		return valor;
	}

	/**
	 * Metodo para inserir novo fator
	 * 
	 * @param novoFator Novo Fator
	 */
	public void setFator(double novoFator) {
		super.preco = (valor * (1 - novoFator));
	}

}
