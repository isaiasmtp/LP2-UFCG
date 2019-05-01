package entidades;

import backend.Exceptions;

/**
 * Classe que representa um cliente
 * 
 * @author Isa�as Martins - 118110593
 *
 */
public class Cliente implements Comparable {

	private String cpf;
	private String nome;
	private String email;
	private String local;
	Exceptions excessoes = new Exceptions();
	
	
	/**
	 * Metodo que constroi um cliente
	 * 
	 * @param cpf   CPF
	 * @param nome  Nome do cliente
	 * @param email Email do cliente
	 * @param local Localizacao do cliente
	 */
	public Cliente(String cpf, String nome, String email, String local) {
		excessoes.verificaEntradasControllerClientes(cpf, nome, email, local);

		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.local = local;

	}

	/**
	 * Metodo que retorna o nome do cliente
	 * 
	 * @return Nome do cliente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que retorna o email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que retorna localizacao do cliente
	 * 
	 * @return local
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Metodo que retorna string que representa o Cliente
	 */
	public String toString() {
		return this.nome + " - " + local + " - " + email;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	/**
	 * Metodo para comparar cliente de acordo com o nome
	 */
	@Override
	public int compareTo(Object o) {
		return this.nome.compareTo(((Cliente) o).nome);

	}
	
	/**
	 * Metodo que retorna cpf
	 * @return String cpf
	 */
	public String getCpf() {
		return cpf;
	}

}
