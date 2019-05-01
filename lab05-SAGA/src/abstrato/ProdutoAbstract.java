package abstrato;

import backend.Exceptions;
import entidades.ProdutoSimples;

/**
 * Classe que representa um produto
 * 
 * @author Isaias Martins
 *
 */
public abstract class ProdutoAbstract implements Comparable {

	protected String nome;
	protected String descricao;
	protected double preco;
	protected Exceptions excessoes = new Exceptions();

	/**
	 * Metodo que retorna preco do produto
	 * 
	 * @return Preco do produto
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * Metodo para inserir preco
	 * 
	 * @param preco Preco do produto
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Metodo para retornar nome
	 * 
	 * @return Nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo para retornar descricao
	 * 
	 * @return Descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Metodo de representacao de um produto
	 */
	public String toString() {
		String precoString = String.format("%.2f", this.preco);
		return this.nome + " - " + this.descricao + " - R$" + precoString;
	}

	/**
	 * Compara pelo nome
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Equals pelo nome
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoAbstract other = (ProdutoAbstract) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Metodo para comparar produtos
	 */
	@Override
	public int compareTo(Object o) {
		if (this.nome.compareTo(((ProdutoAbstract) o).nome) == 0) {
			return (this.descricao.compareTo(((ProdutoAbstract) o).descricao));
		}
		return (this.nome.compareTo(((ProdutoAbstract) o).nome));

	}

}
