package controllers;

import java.util.HashMap;
import java.util.Map;

import abstrato.ProdutoAbstract;
import backend.Exceptions;
import entidades.Cliente;
import entidades.Conta;

/**
 * Classe quecontrola a conta
 * 
 * @author Isaias Martins
 *
 */
public class ControllerConta {

	Map<String, Conta> contasCliente;
	Exceptions excessoes;

	/**
	 * Construtor do controller conta
	 */
	public ControllerConta() {
		contasCliente = new HashMap<>();
		excessoes = new Exceptions();
	}

	/**
	 * Metodo para adicionar uma compra
	 * 
	 * @param cliente        Cliente
	 * @param nomeFornecedor Nome do fornecedor
	 * @param data           Data da compra
	 * @param produto        Produto
	 */
	public void adicionaCompra(Cliente cliente, String nomeFornecedor, String data, ProdutoAbstract produto) {

		Conta conta = contasCliente.get(cliente.getCpf());

		if (conta == null) {
			conta = new Conta();
		}

		conta.adicionaCompra(nomeFornecedor, data, produto);
		contasCliente.put(cliente.getCpf(), conta);
	}

	/**
	 * Metodo que retorna o debito
	 * 
	 * @param cliente    Cliente
	 * @param fornecedor Fornecedor
	 * @return String debito
	 */
	public String getDebito(Cliente cliente, String fornecedor) {

		Conta conta = contasCliente.get(cliente.getCpf());

		return String.format("%.2f", conta.getDebito(fornecedor)).replace(",", ".");

	}

	/**
	 * Metodo para exibir a conta de um cliente com um fornecedor
	 * 
	 * @param cpf            CPF do cliente
	 * @param nomeFornecedor Nome do fornecedor
	 * @return
	 */
	public String exibeContas(String cpf, String nomeFornecedor) {

		return (nomeFornecedor + " | " + contasCliente.get(cpf).toString(nomeFornecedor));
	}

	/**
	 * Metodo para exibir todas as contas do cliente
	 * 
	 * @param cpf CPF do cliente
	 * @return
	 */
	public String exibeContas(String cpf) {

		if (!contasCliente.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");

		}

		return (contasCliente.get(cpf).toString());
	}

	/**
	 * Metodo para o cliente realizar pagamento ao fornecedor
	 * 
	 * @param cliente        Cliente
	 * @param nomeFornecedor Nome do fornecedor
	 */
	public void realizaPagamento(Cliente cliente, String nomeFornecedor) {
		Conta conta = contasCliente.get(cliente.getCpf());
		conta.apagarFornecedor(nomeFornecedor);
	}

}
