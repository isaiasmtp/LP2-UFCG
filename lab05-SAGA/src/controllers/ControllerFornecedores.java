package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import abstrato.ProdutoAbstract;
import backend.Exceptions;
import entidades.Fornecedor;
import entidades.ProdutoCombo;
import entidades.ProdutoSimples;

/**
 * Classe que representa um controlador de Fornecedores Os Produtos existem
 * apenas em Fornecedores
 * 
 * @author Isaias Martins
 *
 */
public class ControllerFornecedores {

	private Map<String, Fornecedor> fornecedores;
	Exceptions excessoes = new Exceptions();

	/**
	 * Constroi um Controlador de Fornecedor Inicializa Map
	 */
	public ControllerFornecedores() {
		fornecedores = new HashMap<>();
	}

	// <CRUID FORNECEDORES>

	/**
	 * Metodo que adiciona um fornecedor ao Mapa
	 * 
	 * @param nome     Nome do fornecedor
	 * @param email    Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 * @return Nome do fornecedor
	 */
	public String adicionarFornecedor(String nome, String email, String telefone) {
		excessoes.verificaEntradasControllerFornecedores(nome, email, telefone);

		if (fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}

		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, fornecedor);
		return nome;

	}

	/**
	 * Metodo que retorna to String do fornecedor
	 * 
	 * @param Nome do fornecedor
	 * @return toString do Forncedor
	 */
	public String recuperaFornecedor(String nome) {
		if (fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");

		}
	}

	public Fornecedor recuperaFornecedorFornecedor(String nome) {
		return fornecedores.get(nome);

	}

	/**
	 * Metodo para editar Fornecedor
	 * 
	 * @param nome         Nome do fornecedor
	 * @param atributo     Atributo que vai ser editado
	 * @param novoAtributo Novo atribudo que vai substituir.
	 * @return true caso conclua com sucesso.
	 */
	public boolean editarFornecedor(String nome, String atributo, String novoAtributo) {
		String email;
		String telefone;

		excessoes.verificaAtributoVazio(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		excessoes.verificaAtributoVazio(novoAtributo,
				"Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

		if (fornecedores.containsKey(nome)) {
			if (atributo.equals("nome")) {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");

			} else if (atributo.equals("email")) {
				Fornecedor fornecedor = fornecedores.get(nome);
				nome = fornecedor.getNome();
				telefone = fornecedor.getTelefone();
				email = novoAtributo;

				excessoes.verificaEntradasControllerFornecedores(nome, email, telefone);

				Fornecedor fornecedorAtualizado = new Fornecedor(nome, email, telefone);
				fornecedores.put(nome, fornecedorAtualizado);
				return true;

			} else if (atributo.equals("telefone")) {
				Fornecedor fornecedor = fornecedores.get(nome);
				nome = fornecedor.getNome();
				telefone = novoAtributo;
				email = fornecedor.getEmail();

				excessoes.verificaEntradasControllerFornecedores(nome, email, telefone);

				Fornecedor fornecedorAtualizado = new Fornecedor(nome, email, telefone);
				fornecedores.put(nome, fornecedorAtualizado);
				return true;

			} else {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
			}
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}

	}

	/**
	 * Metodo para remover fornecedor do mapa
	 * 
	 * @param nome Nome do fornecedor
	 * @return true caso conclua com sucesso
	 */
	public boolean removerFornecedor(String nome) {
		excessoes.verificaNomeRemocaoFornecedor(nome);

		if (fornecedores.containsKey(nome)) {
			fornecedores.remove(nome);
			return true;
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}

	/**
	 * Metodo para imprimir todos os fornecedores
	 * 
	 * @return String com todos os fornecedores
	 */
	public String imprimirTodosFornecedores() {
		ArrayList<Fornecedor> fornecedorOrdenado = new ArrayList<>(this.fornecedores.values());
		String saida = "";

		Collections.sort(fornecedorOrdenado);

		for (int i = 0; i < fornecedorOrdenado.size(); i++) {
			saida += fornecedorOrdenado.get(i);
			if (!((i + 1) == fornecedorOrdenado.size())) {
				saida += " | ";
			}
		}
		return saida;

	}

	// <CRUID 3 - PRODUTOS-SIMPLES>

	/**
	 * Metodo para adicioinar produto a um fornecedor
	 * 
	 * @param nomeFornecedor Nome do Fornecedor
	 * @param nome           Nome do produto
	 * @param descricao      Descricao do produto
	 * @param preco          Preco do produto
	 */
	public boolean adicionaProdutoSimples(String nomeFornecedor, String nome, String descricao, double preco) {

		excessoes.verificaAtributoVazioNull(nomeFornecedor,
				"Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");

		if (fornecedores.containsKey(nomeFornecedor)) {
			Fornecedor fornecedor = fornecedores.get(nomeFornecedor);
			excessoes.verificaEntradasProduto(nome, descricao, preco);
			ProdutoSimples produto = new ProdutoSimples(nome, descricao, preco);

			if (fornecedor.produtos.contains(produto)) {
				throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
			} else {
				fornecedor.produtos.add(produto);
				return true;
			}

		} else {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}

	}

	/**
	 * Metodo que exibe um Produto
	 * 
	 * @param nome           Nome do produto
	 * @param descricao      Descricao do produto
	 * @param nomeFornecedor Nome do fornecedor
	 * @return Strign do produto
	 */
	public String exibeProduto(String nome, String descricao, String nomeFornecedor) {

		excessoes.VerificaexibeProduto(nome, descricao, nomeFornecedor);

		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}

		Fornecedor fornecedor = fornecedores.get(nomeFornecedor);

		for (int i = 0; i < fornecedor.produtos.size(); i++) {
			if (fornecedor.produtos.get(i).getNome().equals(nome)
					&& fornecedor.produtos.get(i).getDescricao().equals(descricao)) {
				return fornecedor.produtos.get(i).toString();

			}
		}

		throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");

	}

	/**
	 * Metodo que exibe todos os produtos de um fornecedor
	 * 
	 * @param nomeFornecedor Nome do fornecedor
	 * @return String com todos os produtos do fornecedor em ordem alfabetica
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		Fornecedor fornecedor = fornecedores.get(nomeFornecedor);

		ArrayList<ProdutoAbstract> produtoOrdenado = new ArrayList<>();
		String saida = "";

		for (int i = 0; i < fornecedor.produtos.size(); i++) {
			produtoOrdenado.add(fornecedor.produtos.get(i));
		}

		Collections.sort(produtoOrdenado);

		for (int i = 0; i < produtoOrdenado.size(); i++) {
			saida += nomeFornecedor + " - " + produtoOrdenado.get(i);
			if (!((i + 1) == produtoOrdenado.size())) {
				saida += " | ";
			}
		}
		return saida;

	}

	/**
	 * Metodo que exibe todos os produtos de todos os fornecedores
	 * 
	 * @return String com todos os produtos
	 */
	public String exibeProdutos() {

		ArrayList<Fornecedor> fornecedorOrdenado = new ArrayList<>(this.fornecedores.values());
		String saida = "";

		Collections.sort(fornecedorOrdenado);

		for (int i = 0; i < fornecedorOrdenado.size(); i++) {
			saida += exibeProdutosFornecedor(fornecedorOrdenado.get(i).getNome());

			if (!((i + 1) == fornecedorOrdenado.size())) {
				saida += " | ";
			}
		}

		return saida;
	}

	/**
	 * Metodo para editar o preco de um produto
	 * 
	 * @param nome           Nome do produto
	 * @param descricao      Descricao do produto
	 * @param nomeFornecedor Nome do fornecedor
	 * @param novoPreco      Novo preco
	 * @return true caso conclua com sucesso
	 */
	public boolean editaProduto(String nome, String descricao, String nomeFornecedor, double novoPreco) {

		excessoes.VerificaEditaProduto(nome, descricao, nomeFornecedor, novoPreco);

		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}

		Fornecedor fornecedor = fornecedores.get(nomeFornecedor);

		for (int i = 0; i < fornecedor.produtos.size(); i++) {
			if (fornecedor.produtos.get(i).getNome().equals(nome)
					&& fornecedor.produtos.get(i).getDescricao().equals(descricao)) {
				(fornecedor.produtos.get(i)).setPreco(novoPreco);
				// TODO
				return true;
			}
		}

		return false;

	}

	/**
	 * Metodo para remover um produto
	 * 
	 * @param nome           Nome do produto
	 * @param descricao      Descricao do produto
	 * @param nomeFornecedor Nome do fornecedor
	 * @return true caso conclua com sucesso
	 */
	public boolean removeProduto(String nome, String descricao, String nomeFornecedor) {

		excessoes.VerificaRemoveProduto(nome, descricao, nomeFornecedor);

		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}

		Fornecedor fornecedor = fornecedores.get(nomeFornecedor);

		for (int i = 0; i < fornecedor.produtos.size(); i++) {
			if (fornecedor.produtos.get(i).getNome().equals(nome)
					&& fornecedor.produtos.get(i).getDescricao().equals(descricao)) {

				fornecedor.produtos.remove(i);
				return true;
			}
		}
		throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
	}

	// <CRUID PRODUTO-COMBO>
	/**
	 * Metodo para adicionar um combo
	 * 
	 * @param nomeFornecedor Nome do fornecedor
	 * @param nome           Nome do produto
	 * @param descricao      Descricao do produto
	 * @param fator          Fator do produto
	 * @param produto        Produtos simples
	 * @return String com o nome
	 */
	public void adicionaProdutoCombo(String nomeFornecedor, String nome, String descricao, double fator,
			String produto) {

		int indiceVerificador;
		excessoes.verificaProdutoFator(fator, "Erro no cadastro de combo: fator invalido.");
		excessoes.verificaAtributoVazioNull(nomeFornecedor,
				"Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		excessoes.verificaAtributoVazioNull(nome, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		excessoes.verificaAtributoVazioNull(descricao,
				"Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		excessoes.verificaAtributoVazioNull(produto, "Erro no cadastro de combo: combo deve ter produtos.");
		excessoes.verificaProdutoCombo(produto);

		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}

		produto = produto.replace(", ", "--");
		String[] produtos = produto.split("--");
		indiceVerificador = produtos.length;

		ArrayList<ProdutoAbstract> ArrayProduto = new ArrayList<>();

		Fornecedor fornecedor = fornecedores.get(nomeFornecedor);
		String produtoFornecedor;

		for (int i = 0; i < produtos.length; i++) {
			for (int j = 0; j < fornecedor.produtos.size(); j++) {
				produtoFornecedor = fornecedor.produtos.get(j).getNome() + " - "
						+ fornecedor.produtos.get(j).getDescricao();

				if (produtos[i].equals(produtoFornecedor)) {
					ArrayProduto.add(fornecedor.produtos.get(j));
					break;
				}

				if (j == fornecedor.produtos.size() - 1) {
					throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
				}
			}
		}

		if (indiceVerificador != ArrayProduto.size()) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
		}

		ProdutoCombo combo = new ProdutoCombo(nome, descricao, fator, ArrayProduto);
		if (fornecedor.produtos.contains(combo)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}

		fornecedor.produtos.add(combo);

	}

	/**
	 * Metodo para editar um combo
	 * 
	 * @param nome           Nome do combo
	 * @param descricao      Descricao do combo
	 * @param nomeFornecedor Nome do fornecedor
	 * @param novoFator      Novo fator
	 * @return true caso execute com sucesso
	 */
	public boolean editaCombo(String nome, String descricao, String nomeFornecedor, double novoFator) {

		excessoes.verificaProdutoFator(novoFator, "Erro na edicao de combo: fator invalido.");
		excessoes.verificaAtributoVazioNull(nome, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		excessoes.verificaAtributoVazioNull(descricao,
				"Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		excessoes.verificaAtributoVazioNull(nomeFornecedor,
				"Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");

		if (!fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}

		Fornecedor fornecedor = fornecedores.get(nomeFornecedor);

		for (int i = 0; i < fornecedor.produtos.size(); i++) {
			if (fornecedor.produtos.get(i).getNome().equals(nome)
					&& fornecedor.produtos.get(i).getDescricao().equals(descricao)) {

				((ProdutoCombo) fornecedor.produtos.get(i)).setFator(novoFator);

				return true;
			}
		}

		throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");

	}

}
