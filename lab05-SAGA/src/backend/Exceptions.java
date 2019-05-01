package backend;

import abstrato.ProdutoAbstract;
import entidades.Cliente;
import entidades.Fornecedor;

/**
 * Classe de tratamento de excessoes
 * 
 * @author Isaias Martins
 *
 */
public class Exceptions {

	// <ControllerClientes>

	/**
	 * Metodo para verificar entradas no controller de clientes
	 * 
	 * @param cpf   CPF do cliente
	 * @param nome  Nome do cliente
	 * @param email Email do cliente
	 * @param local Localizacao do cliente
	 */
	public void verificaEntradasControllerClientes(String cpf, String nome, String email, String local) {

		if (nome == null) {
			throw new NullPointerException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}

		if (cpf == null) {
			throw new NullPointerException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}

		if (email == null) {
			throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}

		if (local == null) {
			throw new NullPointerException("cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}

		if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if ("".equals(cpf.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if ("".equals(email.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if ("".equals(local.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}

	/**
	 * Metodo para verificar cpf
	 * 
	 * @param cpf  Cpf do cliente
	 * @param erro Erro a ser mostrado
	 */
	public void verificaCPF(String cpf, String erro) {
		if ("".equals(cpf.trim())) {
			throw new IllegalArgumentException(erro);
		}

		if (cpf == null) {
			throw new NullPointerException(erro);
		}

		if (cpf.length() != 11) {
			throw new IllegalArgumentException(erro);
		}

	}

	/**
	 * Metodo para verificar entradas no controller de fornecedores
	 * 
	 * @param nome     Nome do fornecedor
	 * @param email    Email do fornecedor
	 * @param telefone Telefone do fornecedor
	 */
	public void verificaEntradasControllerFornecedores(String nome, String email, String telefone) {

		if (nome == null) {
			throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}

		if (email == null) {
			throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}

		if (telefone == null) {
			throw new NullPointerException("cadastro do fornecedor: telefone nao pode ser vazia ou nula.");
		}

		if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}

		if ("".equals(email.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if ("".equals(telefone.trim())) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazia ou nula.");
		}
	}

	/**
	 * Metodo para verificar se algum atributo e vazio
	 * 
	 * @param atributo Atributo a ser testado
	 * @param erro     Mensagem de erro
	 */
	public void verificaAtributoVazio(String atributo, String erro) {
		if ("".equals(atributo.trim())) {
			throw new IllegalArgumentException(erro);
		}

	}

	/**
	 * Metodo para verificar se algum atributo e vazio ou nulo
	 * 
	 * @param atributo Atributo a ser testado
	 * @param erro     Mensagem de erro
	 */
	public void verificaAtributoVazioNull(String atributo, String erro) {
		if ("".equals(atributo.trim())) {
			throw new IllegalArgumentException(erro);
		}

		if (atributo == null) {
			throw new NullPointerException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}

	}

	/**
	 * Verifica nome do fornecedor para remocao dele do controller
	 * 
	 * @param nome Nome do fornecedor
	 */
	public void verificaNomeRemocaoFornecedor(String nome) {
		if (nome == null) {
			throw new NullPointerException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser nulo.");
		}

		if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
	}

	// <PRODUTO CONTROLLER>

	/**
	 * Metodo que verifica entradas de produto
	 * 
	 * @param nome      Nome do produto
	 * @param descricao Descricao do produto
	 * @param preco     Preco do produto
	 */
	public void verificaEntradasProduto(String nome, String descricao, double preco) {

		if (nome == null) {
			throw new NullPointerException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}

		if (descricao == null) {
			throw new NullPointerException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}

		if (preco < 0) {
			throw new NullPointerException("Erro no cadastro de produto: preco invalido.");
		}

		if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}

		if ("".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}

	}

	/**
	 * Verifica entradas no metodo exibirProduto
	 * 
	 * @param nome           Nome do produto
	 * @param descricao      Descricao do produto
	 * @param nomeFornecedor Nome do fornecedor
	 */
	public void VerificaexibeProduto(String nome, String descricao, String nomeFornecedor) {

		if (nome == null) {
			throw new NullPointerException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}

		if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (nomeFornecedor == null) {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if ("".equals(nomeFornecedor.trim())) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (descricao == null) {
			throw new NullPointerException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if ("".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
	}

	/**
	 * Verifica entradas para edicao de produto
	 * 
	 * @param nome           Nome do produto
	 * @param descricao      Descricao do produto
	 * @param nomeFornecedor Nome do fornecedor
	 * @param novoPreco      Novo preco
	 */
	public void VerificaEditaProduto(String nome, String descricao, String nomeFornecedor, double novoPreco) {

		if (novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}

		if (descricao == null) {
			throw new NullPointerException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if ("".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (nome == null) {
			throw new NullPointerException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}

		if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (nomeFornecedor == null) {
			throw new NullPointerException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if ("".equals(nomeFornecedor.trim())) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}

	/**
	 * Verifica entradas do metodo remover produto
	 * 
	 * @param nome           Nome do produto
	 * @param descricao      Descricao do produto
	 * @param nomeFornecedor Nome do fornecedor
	 */
	public void VerificaRemoveProduto(String nome, String descricao, String nomeFornecedor) {

		if (nome == null) {
			throw new NullPointerException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}

		if ("".equals(nome.trim())) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (nomeFornecedor == null) {
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if ("".equals(nomeFornecedor.trim())) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (descricao == null) {
			throw new NullPointerException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}

		if ("".equals(descricao.trim())) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}

	}

	/**
	 * Metodo que verifica o fator do combo
	 * 
	 * @param atributo Atributo a ser testado
	 * @param erro     Mensagem de erro
	 */
	public void verificaProdutoFator(double atributo, String erro) {

		if (atributo <= 0) {
			throw new IllegalArgumentException(erro);
		}

		if (atributo >= 1) {
			throw new IllegalArgumentException(erro);
		}

	}

	/**
	 * Metodo que verifica se o produto Ã© um combo e exibe erro caso seja
	 * 
	 * @param produto
	 */
	public void verificaProdutoCombo(String produto) {
		String[] verificaCombo = produto.split("");

		for (int i = 0; i < verificaCombo.length; i++) {
			if (verificaCombo[i].equals("+")) {
				throw new IllegalArgumentException(
						"Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");

			}
		}
	}

	/**
	 * Verifica entradas da classe conta
	 * 
	 * @param cpf            Cpf do cliente
	 * @param nomeFornecedor Nome do fornecedor
	 * @param data           Data da compra
	 * @param nomeProd       Nome do produto
	 * @param descProd       Descricao do produto
	 */
	public void verificaEntradasConta(String cpf, String nomeFornecedor, String data, String nomeProd,
			String descProd) {
		verificaCPF(cpf, "Erro ao cadastrar compra: cpf invalido.");

		verificaAtributoVazioNull(nomeFornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		verificaAtributoVazioNull(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		verificaAtributoVazioNull(nomeProd, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		verificaAtributoVazioNull(descProd,
				"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");

		String verifData[] = data.split("/");

		if (verifData[0].length() != 2 || Integer.parseInt(verifData[0]) < 0 || Integer.parseInt(verifData[0]) > 31
				|| verifData[1].length() != 2 || Integer.parseInt(verifData[1]) < 0
				|| Integer.parseInt(verifData[1]) > 12 || Integer.parseInt(verifData[2]) < 0
				|| verifData[2].length() != 4) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}

	}

	/**
	 * Verifica as entradas do metodo de verificar contas existentes
	 * 
	 * @param cliente    Cliente
	 * @param fornecedor Fornecedor
	 * @param produto    Produto
	 */
	public void verificaEntradasContaExistencia(Cliente cliente, Fornecedor fornecedor, ProdutoAbstract produto) {
		if (cliente == null) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}

		if (fornecedor == null) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		}

		if (produto == null) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}
	}

	/**
	 * Verifica se conta com o fornecedor existe no cadastro
	 * 
	 * @param fornecedor Fornecedor
	 */
	public void verificaEntradasContaExistencia(Fornecedor fornecedor) {

		if (fornecedor == null) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		}

	}

	/**
	 * Verifica as entradas de getDebito
	 * 
	 * @param cpf            Cpf do cliente
	 * @param nomeFornecedor Nome do fornecedor
	 */
	public void verificaEntradasgetDebito(String cpf, String nomeFornecedor) {
		verificaCPF(cpf, "Erro ao recuperar debito: cpf invalido.");

		verificaAtributoVazioNull(nomeFornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");

	}

	/**
	 * Verifica se existe debito
	 * 
	 * @param variavel
	 */
	public void verificaGetDebito(String variavel) {
		if (Double.parseDouble(variavel) == 0) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
	}

	/**
	 * Verifica as contas existentes
	 * 
	 * @param cliente    Cliente
	 * @param fornecedor Fornecedor
	 */
	public void verificaEntradasContaExistenciaGetDebito(Cliente cliente, Fornecedor fornecedor) {
		if (cliente == null) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}

		if (fornecedor == null) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}

	}

	/**
	 * Verifica se o atributo é exclusivamente null
	 * 
	 * @param atributo Variavel
	 * @param erro     Mensagem de erro
	 */
	public void verificaNull(String atributo, String erro) {
		if (atributo == null) {
			throw new IllegalArgumentException(erro);

		}

	}

}
