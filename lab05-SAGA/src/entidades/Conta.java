package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import abstrato.ProdutoAbstract;
import backend.Exceptions;

/**
 * Classe que representa uma conta
 * 
 * @author Isaias Martins
 *
 */
public class Conta {

	Map<String, ArrayList<Compra>> compras;
	Exceptions excessoes;

	/**
	 * Constroi uma conta
	 */
	public Conta() {
		compras = new HashMap<>();
		excessoes = new Exceptions();
	}

	/**
	 * Metodo para adicionar compra
	 * @param fornecedor Nome do fornecedor
	 * @param data Data da compra
	 * @param produto Produto
	 */
	public void adicionaCompra(String fornecedor, String data, ProdutoAbstract produto) {

		if (compras.get(fornecedor) == null) {
			compras.put(fornecedor, new ArrayList<>());
		}

		Compra compra = new Compra(data, produto);
		ArrayList<Compra> ComprasExistentes = compras.get(fornecedor);

		ComprasExistentes.add(compra);

		compras.put(fornecedor, ComprasExistentes);

	}

	/**
	 * Metodo para retornar debito total com um fornecedor
	 * @param fornecedor Nome do fornecedor
	 * @return
	 */
	public double getDebito(String fornecedor) {
		double soma = 0;

		if (!compras.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}

		for (int i = 0; i < compras.get(fornecedor).size(); i++) {

			soma += compras.get(fornecedor).get(i).getProduto().getPreco();

		}

		return soma;
	}

	/**
	 * Metodo da representação da conta de um fornecedor
	 * @param nomeFornecedor
	 * @return
	 */
	public String toString(String nomeFornecedor) {
		String saida = "";
		excessoes.verificaAtributoVazioNull(nomeFornecedor,
				"Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");

		ArrayList<Compra> comprasFornecedor = compras.get(nomeFornecedor);

		if (comprasFornecedor == null) {
			throw new NullPointerException(
					"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");

		}

		// Collections.sort(comprasFornecedor);

		for (int i = 0; i < comprasFornecedor.size(); i++) {
			saida += comprasFornecedor.get(i).getNomeDesProduto() + " - "
					+ comprasFornecedor.get(i).getData().replace("/", "-");

			if ((i + 1) != comprasFornecedor.size()) {
				saida += " | ";
			}

		}
		return saida;

	}
	
	/**
	 * Metodo da representação de todos os fornecedores
	 */
	public String toString() {
		String saida = "";

		// PEGAR TODOS OS FORNECEDORES
		// PEGAR TODOS OS PRODUTOS

		ArrayList<String> chavesFornecedores = new ArrayList<>();

		Set<String> chaves = compras.keySet();
		for (String chave : chaves) {
			chavesFornecedores.add(chave);

		}

		Collections.sort(chavesFornecedores);

		for (int i = 0; i < chavesFornecedores.size(); i++) {

			saida += chavesFornecedores.get(i) + " | " + toString(chavesFornecedores.get(i));
			if ((i + 1) != chavesFornecedores.size()) {
				saida += " | ";
			}
		}

		return saida;

	}

	/**
	 * Metodo para apagar um fornecedor
	 * @param nomeFornecedor Nome do fornecedor
	 */
	public void apagarFornecedor(String nomeFornecedor) {
		if (compras.remove(nomeFornecedor) == null) {
			throw new IllegalArgumentException(
					"Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		}

	}

}
