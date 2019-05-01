package lab03;

/**
 * Classe que representa uma agenda composta por um array de contatos
 * @author isaiasmtp
 *
 */
public class Agenda {

	private Contato[] contatos;
	
	/**
	 * Contrutor que cria uma agenda que é um array de contatos.
	 */
	public Agenda() {
		contatos = new Contato[101];
	}
	
	/**
	 * Metodo para validar a posicao do contato a ser adicionado
	 * @param posicao Posicao do contato	
	 * @return true caso seja uma posição valida, caso não seja uma posicao valida.
	 */
	public boolean validaPosicao(int posicao) {
		if (posicao < 1 || posicao > 100) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Metodo que verifica se a string passada na entrada é uma string vazia.
	 * @param nome Nome do contato	
	 * @param sobrenome Sobrenome do contato	
	 * @param telefone Telefone do contato	
	 * @return False caso a string seja vazia, verdadeiro caso contenha algo.
	 */
	private boolean verificaEntradas(String nome, String sobrenome, String telefone) {
		if("".equals(nome.trim())) {
			return false;
		}
		if( "".equals(sobrenome.trim())){
			return false;
		}
		if( "".equals(telefone.trim())){
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo que cadastra um contato, precisa ter a posição, nome, sobrenome e telefone do contato.
	 * Não adiciona contatos repetidos (nome e sobrenome iguais).
	 * @param posicao Posicao do contato	
	 * @param nome Nome do contato
	 * @param sobrenome Sobrenome do contato
	 * @param telefone Telefone do contato
	 * @return true caso tenha cadastrado, false caso não tenha cadastrado.
	 */ 
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		
		if(!verificaEntradas(nome,sobrenome,telefone)) {
			return false;
		}

		Contato contatoTempo = new Contato(nome, sobrenome, telefone);
		
		int cont = 0;
		for (int i = 0; i<contatos.length;i++) {
			cont = 0;
			
			if(contatos[i]!= null) {
				
				if (contatoTempo.equals(contatos[i])){
					cont = 1;
					break;				
				}
			}
		}		
		if (cont == 0) {
			contatos[posicao] = contatoTempo;
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que recebe uma posicao e busca na array o contato e imprime o nome, sobrenome e telefone.
	 * @param posicao  Posicao do contato
	 * @return metodo toString do contato.
	 */ 
	public String exibirContato(int posicao) {
		return contatos[posicao].toString();
	}
	
	/**
	 * Metodo para listar os contatos cadastrados
	 * Primeiro verifica se a posição não contem o valor null, e então imprime os contatos cadastrados.
	 * @return String com todos os contatos cadastrados.
	 */
	public String listarContatos() {
		String saida = "";
		
		for (int i = 0;i < contatos.length; i++) {
			if(contatos[i]!=null ){
				if ( !(contatos[i].getNome().equals("") && contatos[i].getSobrenome().equals(""))) {
					saida += (i + " - "+ contatos[i].getNome() + " "+ contatos[i].getSobrenome() +"\n");
				}
			}
		}	
		return saida;
	}
	
	/**
	 * Metodo que compara 2 agendas.
	 * @return Retorna true caso a lista da agenda seja igual, false caso seja diferente.
	 */
	public boolean equals(Object agenda) {
	     if (this.listarContatos().equals(((Agenda) agenda).listarContatos())){
	          return true;
	     }
	     return false;
	}
	
	
	
}
