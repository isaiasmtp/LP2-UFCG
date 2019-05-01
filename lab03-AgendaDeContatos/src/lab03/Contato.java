package lab03;

/**
 * Classe que representa um contato, tem nome, sobrenome e telefone.
 * @author Isaías Martins
 *
 */
public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * Metodo que retorna o nome do contato
 	 * @return Nome do contato
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que retorna o sobrenome do contato
 	 * @return sobrenome do contato
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Metodo que retorna o telefone do contato
 	 * @return telefone do contato
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Metodo que valida o contato, verifica se existe valores vazios sendo passados como parametro.
	 * @param nome Nome do contato
	 * @param sobrenome Sobrenome do contato
	 * @param telefone Telefone fo contato
	 * @return true caso os valores sejam validos, false caso não sejam validos.
	 */
	private boolean validaContato(String nome, String sobrenome, String telefone) {
		if("".equals(sobrenome.trim()) ||"".equals(nome.trim()) || "".equals(telefone.trim())) {
			return false;
		}
		return true;
	}
	
	/**
	 * Construtor que usa um metodo para validar os parametros e casos seja valido, constroi um contato, caso não seja valido, lança uma excecção.
	 * @param nome Nome do contato
	 * @param sobrenome Sobrebnome do contato
	 * @param telefone Telefone do contato
	 */
	public Contato (String nome, String sobrenome, String telefone) {
		if((validaContato(nome,sobrenome, telefone))){
			this.nome = nome;
			this.sobrenome = sobrenome;
			this.telefone = telefone;	
		}else {
			throw new IllegalArgumentException();
		}
		
	}
	
	/**
	 * Compara dois contatos
	 * Caso tenha nome e sobrenome iguais, retorna true, caso seja diferente, retorna false.
	 */
	public boolean equals(Object contato) {
	     if (this.nome.equals( ((Contato) contato).getNome())
	          && this.sobrenome.equals (((Contato) contato).getSobrenome())){
	          return true;
	     }
	     return false;		
		}
	
	/**
	 * Metodo que retorna uma String, com o nome, sobrenome e telefone do contato.
	 */
	public String toString() {
		return getNome() + " " + getSobrenome() + " - "+ getTelefone();
	}
}
