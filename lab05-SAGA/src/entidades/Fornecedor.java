package entidades;

import java.util.ArrayList;
import java.util.List;

import abstrato.ProdutoAbstract;
import backend.Exceptions;

/**
 * Metodo que representa um Fornecedor
 * 
 * @author Isaias Martins - 118110593
 *
 */
public class Fornecedor implements Comparable {

	private String nome;
	private String email;
	private String telefone;
	public List<ProdutoAbstract> produtos;
	Exceptions excessoes = new Exceptions();

	public ProdutoAbstract getProduto(String nome, String descricao) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equals(nome) && produtos.get(i).getDescricao().equals(descricao)) {
				return produtos.get(i);
			}
		}
		return null;
	}

	/**
	 * Constroi um Fornecedor
	 * 
	 * @param nome     Nome do fornecedor
	 * @param email    Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		excessoes.verificaEntradasControllerFornecedores(nome, email, telefone);

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		produtos = new ArrayList<>();

	}

	/**
	 * Metodo que retorna uma string do fornecedor.
	 */
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Metodo que retorna o nome do fornecedor
	 * 
	 * @return Nome do fornecedor
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo que retorna o email do fornecedor.
	 * 
	 * @return Email.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Metodo que retorna o telefone do fornecedor
	 * 
	 * @return Telefone do fornecedor.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Metodo para comparar fornecedor pelo nome;
	 */
	@Override
	public int compareTo(Object o) {
		return this.nome.compareTo(((Fornecedor) o).nome);

	}

}
