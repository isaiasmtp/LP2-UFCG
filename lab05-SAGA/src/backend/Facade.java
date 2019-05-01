package backend;

import abstrato.ProdutoAbstract;
import controllers.Controller;
import easyaccept.EasyAccept;
import entidades.Cliente;
import entidades.Fornecedor;

/**
 * Classe que representa uma fachada com todos os clientes, fornecedores e
 * produtos
 * 
 * @author Isaias Martins
 *
 */
public class Facade {

	Controller controller = new Controller();

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
		return controller.adicionaCliente(cpf, nome, email, local);
	}

	/**
	 * Metodo para exibir uma string do cliente
	 * 
	 * @param cpf Cpf do cliente
	 * @return String do cliente
	 */
	public String exibeCliente(String cpf) {
		return controller.exibeCliente(cpf);
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
		return controller.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * Metodo para remover cliente
	 * 
	 * @param cpf Cpf do cliente
	 * @return true caso remova com sucesso
	 */
	public boolean removeCliente(String cpf) {
		return controller.removeCliente(cpf);
	}

	/**
	 * Metodo que retorna todos os clientes no mapa
	 * 
	 * @return String com todos os clientes
	 */
	public String exibeClientes() {
		return controller.exibeClientes();
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
		return controller.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * Metodo que retorna to String do fornecedor
	 * 
	 * @param Nome do fornecedor
	 * @return toString do Forncedor
	 */
	public String exibeFornecedor(String nome) {
		return controller.exibeFornecedor(nome);
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
		return controller.editaFornecedor(nome, email, telefone);
	}

	/**
	 * Metodo para remover fornecedor do mapa
	 * 
	 * @param nome Nome do fornecedor
	 * @return true caso conclua com sucesso
	 */
	public boolean removeFornecedor(String nome) {
		return controller.removeFornecedor(nome);
	}

	/**
	 * Metodo para imprimir todos os fornecedores
	 * 
	 * @return String com todos os fornecedores
	 */
	public String exibeFornecedores() {
		return controller.exibeFornecedores();
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
		controller.adicionaProduto(nomeFornecedor, nome, descricao, preco);
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
		return controller.exibeProduto(nome, descricao, nomeFornecedor);
	}

	/**
	 * Metodo que exibe todos os produtos de um fornecedor
	 * 
	 * @param nomeFornecedor Nome do fornecedor
	 * @return String com todos os produtos do fornecedor em ordem alfabetica
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return controller.exibeProdutosFornecedor(nomeFornecedor);
	}

	/**
	 * Metodo que exibe todos os produtos de todos os fornecedores
	 * 
	 * @return String com todos os produtos
	 */
	public String exibeProdutos() {
		return controller.exibeProdutos();
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
		return controller.editaProduto(nome, descricao, nomeFornecedor, novoPreco);
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
		return controller.removeProduto(nome, descricao, nomeFornecedor);
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
		controller.adicionaCombo(nomeFornecedor, nome, descricao, fator, produto);
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
		return controller.editaCombo(nome, descricao, nomeFornecedor, novoFator);
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
		controller.adicionaCompra(cpf, nomeFornecedor, data, nomeProd, descProd);
	}

	/**
	 * Metodo que retorna o debito
	 * @param cpf CPF do cliente
	 * @param nomeFornecedor Nome do fornecedor
	 * @return String debito
	 */
	public String getDebito(String cpf, String nomeFornecedor) {
		return controller.getDebito(cpf, nomeFornecedor);
	}

	/**
	 * Metodo que exibe contas do fornecedor com o cliente
	 * @param cpf Cpf do cliente 
	 * @param nomeFornecedor Nome do fornecedor
	 * @return
	 */
	public String exibeContas(String cpf, String nomeFornecedor) {
		return controller.exibeContas(cpf, nomeFornecedor);
	}

	/**
	 * Exibe todas as contas de um cliente
	 * @param cpf CPF do cliente
	 * @return String com todas as contas do cliente
	 */
	public String exibeContasClientes(String cpf) {
		return controller.exibeContasClientes(cpf);
	}
	
	/**
	 * Metodo para realizar um pagamento 
	 * @param cpf CPF do cliente
	 * @param nomeFornecedor Nome do fornecedor
	 */
	public void realizaPagamento(String cpf, String nomeFornecedor) {
		controller.realizaPagamento(cpf, nomeFornecedor);
	}

	public static void main(String[] args) {
		args = new String[] { "backend.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
				"acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt",
				"acceptance_test/use_case_6.txt" };
		EasyAccept.main(args);

	}

}
