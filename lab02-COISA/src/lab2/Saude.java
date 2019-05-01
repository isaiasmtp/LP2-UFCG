package lab2;

/**
 * Representacao da saude de um estudante, quanto a sua saude mental e fisica.
 * @author Isaias Martins
 *
 */
public class Saude {

	private String mental;
	private String fisica;
	private String[] statusGeral;
	
	private void calculaStatusGeral() {
		if (this.mental.equals("boa") && this.fisica.equals("boa")) {
			this.statusGeral[0] = "boa";
		}
		
		if (this.mental.equals("fraca") && this.fisica.equals("fraca")) {
			this.statusGeral[0] = "fraca";
		}
		
		if ((this.mental.equals("fraca") && this.fisica.equals("boa")) || (this.mental.equals("boa") && this.fisica.equals("fraca"))) {
			this.statusGeral[0] = "ok";
		}
		
	}
	
	/**
	 * Controi uma classe que representa o individuo quanto sua saude mental e fisica.
	 * Inicialmente, ambos os valores da saude são iniciados com "boa".
	 * Um array com o status geral e o emoji é inicializado.
	 */
	public Saude() {
		this.mental = "boa";
		this.fisica = "boa";
		statusGeral = new String[2];
		statusGeral[0] = "";
		statusGeral[1] = "";
	}
	
	/**
	 * Define a saude mental.
	 * Caso aja alteracao, o emoji e zerado.
	 * @param valor saude mental, que pode ser "boa" ou "fraca".
	 */
	void defineSaudeMental(String valor) {
		if (valor.equals("boa")) {
			this.mental = valor;
		}
		if (valor.equals("fraca")) {
			this.mental = valor;
			}
		this.statusGeral[1] = "";
	}
	
	/**
	 * Define a saude fisica
	 * Caso aja alteracao, o emoji e zerado.
	 * @param valor valor saude fisica, que pode ser "boa" ou "fraca".
	 */
	void defineSaudeFisica(String valor) {
		if (valor.equals("boa")) {
			this.fisica = valor;
		}
		if (valor.equals("fraca")) {
			this.fisica = valor;
		}
		this.statusGeral[1] = "";
		
	}
	
	/**
	 * Adiciona emoji ao array do status geral do aluno.
	 * Caso tenha emoji, ira trocar para o novo.
	 * @param emoji emoji adicionado ao status geral do aluno.
	 */
	public void definirEmoji(String emoji) {
			this.statusGeral[1] = emoji;
	}
	
	/**
	 * Calcula o status geral e retorna o status geral.
	 * Retorna a string que representa a saude mental.
	 * @return a representacao em string da saude.
	 */
	public String getStatusGeral() {	
		calculaStatusGeral();
		return this.statusGeral[0]+" "+this.statusGeral[1];
		
	}
	
	
}
