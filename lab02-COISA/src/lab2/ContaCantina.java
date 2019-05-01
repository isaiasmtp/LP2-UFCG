package lab2;

/**
* Representacao de uma cantina, Toda cantina precisa ter um nome e é identificado unicamente
* por este nome, cada compra na cantina tem uma quantidade de itens e um valor.
*
* @author Isaias Martins

*/

public class ContaCantina {

	private String nomeCantina;
	private int qtdItens;	
	private int valorCentavos;
	private int valorTotal;
	private String[] detalhes;
	private int posicaoDetalhes;
	private String saidaDetalhes;
	
	/**
	 * Constroi uma cantina a partir do seu nome.
	 * Inicializa um array para o registro dos detalhes com 5 posicoes.
	 * @param nomeCantina Nome da cantina.
	 */
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
		this.detalhes = new String[5];
		this.saidaDetalhes = "";
	}
	
	/**
	 * Metodo para cadastrar lanches comprados na cantina, e também armazenar um valor total de compras realizadas.
	 * @param qtdItens quantidade de itens de cada compra.
	 * @param valorCentavos valor da compra em centavos.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos){
		this.qtdItens += qtdItens;
		this.valorCentavos += valorCentavos;
		this.valorTotal += valorCentavos;
	}
	
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes){
		this.qtdItens += qtdItens;
		this.valorCentavos += valorCentavos;
		this.valorTotal += valorCentavos;
		this.detalhes[posicaoDetalhes] = detalhes;
		posicaoDetalhes += 1;
		if (posicaoDetalhes == 5){
			posicaoDetalhes = 0;
		}
	}
	
	public String listarDetalhes() {
		for (int i = 0; i<this.detalhes.length;i++) {
			this.saidaDetalhes += detalhes[i] + "\n";
		}
		return saidaDetalhes;
	}
	
	/**
	 * Metodo que paga uma parte ou todo o valor da divida.
	 * @param valorCentavos valor pago pelo usuario da cantina.
	 */
	public void pagaConta(int valorCentavos) {
		if(valorCentavos <= this.valorCentavos) {
			this.valorCentavos = this.valorCentavos  - valorCentavos;
		}
		
	}
	
	/**
	 * Retorna a quantidade de centavos que esta em divida.
	 * @return valor que falta pagar em centavos.
	 */
	public int getFaltaPagar( ) {
			return this.valorCentavos;
		
	
	}
	
	/**
	 * Retorna a String que representa o nome da cantina, a quantidade de itens comprados e o valor total.
	 * @return a representação em String do o nome da cantina, a quantidade de itens comprados e o valor total.
	 */
	public String toString() {
		return (this.nomeCantina + " "+qtdItens + " "+valorTotal);
	}
	
	
	
	
}
