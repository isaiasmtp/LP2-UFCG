package entidades;

import java.util.ArrayList;

import abstrato.ProdutoAbstract;

public class Compra implements Comparable{
	private String data;
	private ProdutoAbstract produto;
	private String nomeProduto;

	public Compra(String data, ProdutoAbstract produto) {
		this.data = data;
		this.produto = produto;
		nomeProduto = produto.getNome();
	}

	public ProdutoAbstract getProduto() {
		return produto;
	}

	@Override
	public int compareTo(Object o) {
		return this.nomeProduto.compareTo(((Compra) o).nomeProduto);
	}

	public String getData() {
		return data;
	}

	public String getNomeDesProduto() {
		return nomeProduto;
	}

	
	
	
	
	

}
