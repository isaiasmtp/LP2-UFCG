package controllers;

import abstrato.ProdutoAbstract;
import backend.Exceptions;
import entidades.Cliente;
import entidades.Fornecedor;

public class Controller {

	ControllerClientes clientes = new ControllerClientes();
	ControllerFornecedores fornecedores = new ControllerFornecedores();
	ControllerConta contas = new ControllerConta();
	Exceptions excessoes = new Exceptions();

	// <CONTROLLER CLIENTES>

	/**
	 * Metodo para adicionar cliente
	 * 
	 * @param cpf   CPF do cliente
	 * @param nome  Nome do cliente
	 * @param email Email do cliente
	 * @param local Local do cliente
	 * @return CPF do cliente
	 */
	public String adicionaCliente(String cpf, String nome, String email, String local) {
		return clientes.adicionarCliente(cpf, nome, email, local);
	}

	/**
	 * Metodo para exibir uma string do cliente
	 * 
	 * @param cpf Cpf do cliente
	 * @return String do cliente
	 */
	public String exibeCliente(String cpf) {
		return clientes.recuperaCliente(cpf);
	}

	/**
	 * Metodo para editar Cliente
	 * 
	 * @param cpf          Cpf do cliente
	 * @param atributo     Atributo para ser editado
	 * @param novoAtributo Novo atributo que ser� usado para substituir
	 * @return
	 */
	public boolean editaCliente(String cpf, String atributo, String novoValor) {
		return clientes.editarCliente(cpf, atributo, novoValor);
	}

	/**
	 * Metodo para remover cliente
	 * 
	 * @param cpf Cpf do cliente
	 * @return true caso remova com sucesso
	 */
	public boolean removeCliente(String cpf) {
		return clientes.removerCliente(cpf);
	}

	/**
	 * Metodo que retorna todos os clientes no mapa
	 * 
	 * @return String com todos os clientes
	 */
	public String exibeClientes() {
		return clientes.imprimirTodosClientes();
	}

	// <CONTROLLER FORNECEDORES>

	/**
	 * Metodo que adiciona um fornecedor ao Mapa
	 * 
	 * @param nome     Nome do fornecedor
	 * @param email    Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 * @return Nome do fornecedor
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return fornecedores.adicionarFornecedor(nome, email, telefone);
	}

	/**
	 * Metodo que retorna to String do fornecedor
	 * 
	 * @param Nome do fornecedor
	 * @return toString do Forncedor
	 */
	public String exibeFornecedor(String nome) {
		return fornecedores.recuperaFornecedor(nome);
	}

	/**
	 * Metodo para editar Fornecedor
	 * 
	 * @param nome         Nome do fornecedor
	 * @param atributo     Atributo que vai ser editado
	 * @param novoAtributo Novo atribudo que vai substituir.
	 * @return true caso conclua com sucesso.
	 */
	public boolean editaFornecedor(String nome, String email, String telefone) {
		return fornecedores.editarFornecedor(nome, email, telefone);
	}

	/**
	 * Metodo para remover fornecedor do mapa
	 * 
	 * @param nome Nome do fornecedor
	 * @return true caso conclua com sucesso
	 */
	public boolean removeFornecedor(String nome) {
		return fornecedores.removerFornecedor(nome);
	}

	/**
	 * Metodo para imprimir todos os fornecedores
	 * 
	 * @return String com todos os fornecedores
	 */
	public String exibeFornecedores() {
		return fornecedores.imprimirTodosFornecedores();
	}

	// <CONTROLLER PRODUTOS>

	/**
	 * Metodo para adicioinar produto a um fornecedor
	 * 
	 * @param nomeFornecedor Nome do Fornecedor
	 * @param nome           Nome do produto
	 * @param descricao      Descricao do produto
	 * @param preco          Preco do produto
	 */
	public String adicionaProduto(String nomeFornecedor, String nome, String descricao, double preco) {
		fornecedores.adicionaProdutoSimples(nomeFornecedor, nome, descricao, preco);
		return nome;
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
		return fornecedores.exibeProduto(nome, descricao, nomeFornecedor);
	}

	/**
	 * Metodo que exibe todos os produtos de um fornecedor
	 * 
	 * @param nomeFornecedor Nome do fornecedor
	 * @return String com todos os produtos do fornecedor em ordem alfabetica
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return fornecedores.exibeProdutosFornecedor(nomeFornecedor);
	}

	/**
	 * Metodo que exibe todos os produtos de todos os fornecedores
	 * 
	 * @return String com todos os produtos
	 */
	public String exibeProdutos() {
		return fornecedores.exibeProdutos();
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
		return fornecedores.editaProduto(nome, descricao, nomeFornecedor, novoPreco);
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
		return fornecedores.removeProduto(nome, descricao, nomeFornecedor);
	}

	// <CRUID PRODUTO COMBO>

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
	public String adicionaCombo(String nomeFornecedor, String nome, String descricao, double fator, String produto) {
		fornecedores.adicionaProdutoCombo(nomeFornecedor, nome, descricao, fator, produto);
		return nome;
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
		return fornecedores.editaCombo(nome, descricao, nomeFornecedor, novoFator);
	}

	/**
	 * Metodo para adicionar Compra
	 * 
	 * @param cpf            Cpf do cliente
	 * @param nomeFornecedor Nome do fornecedor
	 * @param data           Data da compra
	 * @param nomeProd       Nome do produto
	 * @param descProd       Descricao do produto
	 */
	public void adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProd, String descProd) {
		excessoes.verificaEntradasConta(cpf, nomeFornecedor, data, nomeProd, descProd);

		Cliente cliente = clientes.recuperaClienteCliente(cpf);
		Fornecedor fornecedor = fornecedores.recuperaFornecedorFornecedor(nomeFornecedor);
		excessoes.verificaEntradasContaExistencia(fornecedor);
		ProdutoAbstract produto = fornecedor.getProduto(nomeProd, descProd);
		excessoes.verificaEntradasContaExistencia(cliente, fornecedor, produto);

		contas.adicionaCompra(cliente, fornecedor.getNome(), data, produto);
	}

	/**
	 * Metodo que retorna o debito
	 * 
	 * @param cpf            CPF do cliente
	 * @param nomeFornecedor Nome do fornecedor
	 * @return String debito
	 */
	public String getDebito(String cpf, String nomeFornecedor) {
		excessoes.verificaEntradasgetDebito(cpf, nomeFornecedor);

		Cliente cliente = clientes.recuperaClienteCliente(cpf);
		Fornecedor fornecedor = fornecedores.recuperaFornecedorFornecedor(nomeFornecedor);
		excessoes.verificaEntradasContaExistenciaGetDebito(cliente, fornecedor);
		excessoes.verificaGetDebito(contas.getDebito(cliente, fornecedor.getNome()));

		return contas.getDebito(cliente, fornecedor.getNome());
	}

	/**
	 * Metodo que exibe contas do fornecedor com o cliente
	 * 
	 * @param cpf            Cpf do cliente
	 * @param nomeFornecedor Nome do fornecedor
	 * @return
	 */
	public String exibeContas(String cpf, String nomeFornecedor) {
		excessoes.verificaCPF(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
		excessoes.verificaAtributoVazioNull(nomeFornecedor,
				"Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		Cliente cliente = clientes.recuperaClienteCliente(cpf);
		Fornecedor fornecedor = fornecedores.recuperaFornecedorFornecedor(nomeFornecedor);

		if (cliente == null) {
			throw new NullPointerException("Erro ao exibir conta do cliente: cliente nao existe.");
		}

		if (fornecedor == null) {
			throw new NullPointerException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}

		return ("Cliente: " + cliente.getNome() + " | " + contas.exibeContas(cpf, nomeFornecedor));

	}

	/**
	 * Exibe todas as contas de um cliente
	 * 
	 * @param cpf CPF do cliente
	 * @return String com todas as contas do cliente
	 */
	public String exibeContasClientes(String cpf) {
		excessoes.verificaCPF(cpf, "Erro ao exibir contas do cliente: cpf invalido.");

		Cliente cliente = clientes.recuperaClienteCliente(cpf);

		if (cliente == null) {
			throw new NullPointerException("Erro ao exibir contas do cliente: cliente nao existe.");
		}

		return ("Cliente: " + cliente.getNome() + " | " + contas.exibeContas(cpf));

	}

	/**
	 * Metodo para realizar um pagamento
	 * 
	 * @param cpf            CPF do cliente
	 * @param nomeFornecedor Nome do fornecedor
	 */
	public void realizaPagamento(String cpf, String nomeFornecedor) {
		excessoes.verificaNull(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		excessoes.verificaNull(nomeFornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		excessoes.verificaAtributoVazioNull(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		excessoes.verificaCPF(cpf, "Erro no pagamento de conta: cpf invalido.");
		excessoes.verificaAtributoVazioNull(nomeFornecedor,
				"Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");

		Cliente cliente = clientes.recuperaClienteCliente(cpf);
		if (cliente == null) {
			throw new NullPointerException("Erro no pagamento de conta: cliente nao existe.");
		}

		Fornecedor fornecedor = fornecedores.recuperaFornecedorFornecedor(nomeFornecedor);
		if (fornecedor == null) {
			throw new NullPointerException("Erro no pagamento de conta: fornecedor nao existe.");
		}

		contas.realizaPagamento(cliente, nomeFornecedor);
	}

}
