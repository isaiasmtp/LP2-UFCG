package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import backend.Exceptions;
import entidades.Cliente;

/**
 * Classe que representa um controlador de clientes
 * 
 * @author Isaias Martins
 *
 */
public class ControllerClientes {

	private Map<String, Cliente> clientes;
	Exceptions excessoes = new Exceptions();

	/**
	 * Constroi um controlador de clientes Inicializa o mapa de clientes
	 */
	public ControllerClientes() {
		clientes = new HashMap<String, Cliente>();
	}

	/**
	 * Metodo para adicionar cliente
	 * 
	 * @param cpf   CPF do cliente
	 * @param nome  Nome do cliente
	 * @param email Email do cliente
	 * @param local Local do cliente
	 * @return CPF do cliente
	 */
	public String adicionarCliente(String cpf, String nome, String email, String local) {
		excessoes.verificaEntradasControllerClientes(cpf, nome, email, local);

		if (clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}

		Cliente cliente = new Cliente(cpf, nome, email, local);
		clientes.put(cpf, cliente);
		return cpf;

	}

	/**
	 * Metodo para recuperar uma string
	 * 
	 * @param cpf Cpf do cliente
	 * @return String do cliente
	 */
	public String recuperaCliente(String cpf) {
		excessoes.verificaCPF(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");

		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
	}

	public Cliente recuperaClienteCliente(String cpf) {

		return clientes.get(cpf);

	}

	/**
	 * Metodo para editar Cliente
	 * 
	 * @param cpf          Cpf do cliente
	 * @param atributo     Atributo para ser editado
	 * @param novoAtributo Novo atributo que ser� usado para substituir
	 * @return
	 */
	public boolean editarCliente(String cpf, String atributo, String novoAtributo) {
		String nome;
		String email;
		String local;

		if ("".equals(atributo.trim())) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}

		if ("".equals(novoAtributo.trim())) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}

		if (clientes.containsKey(cpf)) {
			if (atributo.equals("nome")) {
				Cliente cliente = clientes.get(cpf);
				email = cliente.getEmail();
				local = cliente.getLocal();
				nome = novoAtributo;
				excessoes.verificaEntradasControllerClientes(cpf, nome, email, local);

				Cliente clienteAtualizado = new Cliente(cpf, nome, email, local);
				clientes.put(cpf, clienteAtualizado);
				return true;
			} else if (atributo.equals("email")) {
				Cliente cliente = clientes.get(cpf);
				nome = cliente.getNome();
				local = cliente.getLocal();
				email = novoAtributo;
				excessoes.verificaEntradasControllerClientes(cpf, nome, email, local);

				Cliente clienteAtualizado = new Cliente(cpf, nome, email, local);
				clientes.put(cpf, clienteAtualizado);
				return true;
			} else if (atributo.equals("localizacao")) {
				Cliente cliente = clientes.get(cpf);
				email = cliente.getEmail();
				nome = cliente.getNome();
				local = novoAtributo;
				excessoes.verificaEntradasControllerClientes(cpf, nome, email, local);

				Cliente clienteAtualizado = new Cliente(cpf, nome, email, local);
				clientes.put(cpf, clienteAtualizado);
				return true;
			} else {
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
			}
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}

	}

	/**
	 * Metodo para remover cliente
	 * 
	 * @param cpf Cpf do cliente
	 * @return true caso remova com sucesso
	 */
	public boolean removerCliente(String cpf) {
		if (clientes.containsKey(cpf)) {
			clientes.remove(cpf);
			return true;
		}
		return false;
	}

	/**
	 * Metodo que retorna todos os clientes no mapa
	 * 
	 * @return String com todos os clientes
	 */
	public String imprimirTodosClientes() {
		ArrayList<Cliente> clienteOrdenado = new ArrayList<>(this.clientes.values());
		String saida = "";

		Collections.sort(clienteOrdenado);

		for (int i = 0; i < clienteOrdenado.size(); i++) {
			saida += clienteOrdenado.get(i);
			if (!((i + 1) == clienteOrdenado.size())) {
				saida += " | ";
			}
		}
		return saida;
	}

}
