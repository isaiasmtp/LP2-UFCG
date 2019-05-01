package lab2;

/**
 * Representacao de uma disciplina, que possui 4 notas avaliativas, horas e a media do aluno.
 * Para que o aluno seja aprovado deve ter media maior ou igual a 7.
 * @author isaiasmtp
 *
 */
public class Disciplina {

	private double[] notas;
	private String nomeDisciplina;
	private int horas;
	private double media;
	private int[] ponderada;
	private int somaPond;
	private String saidaNotas;
	
	/**
	 * Constroi a disciplina e inicializa com seu nome.
	 * @param nomeDisciplina Nome da disciplina.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[4];
		for(int i = 0; i<ponderada.length;i++) {
			ponderada[i] = 1;
		}
	}
	
	/**
	 * Constroi a disciplina e inicializa com seu nome, quantidade de notas e uma array com o valor para media ponderada com valor 1.
	 * @param nomeDisciplina Nome da discipĺina.
	 * @param qtdNotas Quantidade de notas.
	 */
	public Disciplina(String nomeDisciplina,int qtdNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[qtdNotas];
		for(int i = 0; i<ponderada.length;i++) {
			ponderada[i] = 1;
		}
	}
	
	/**
	 * Constroi a disciplina e inicializa com seu nome, quantidade de notas e uma array com o valor para media ponderada.
	 * @param nomeDisciplina Nome da disciplina.
	 * @param qtdNotas Quantidade de notas.
	 * @param ponderada Array com o valor para cada nota.
	 */
	public Disciplina(String nomeDisciplina,int qtdNotas, int[] ponderada) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[qtdNotas];
		this.ponderada = ponderada;
	}
	
	
	/**
	 * Cadastra horas da disciplina.
	 * @param horas Horas da disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	/**
	 * Cadastra a avaliacao e a nota.
	 * Caso alguma nota não seja cadastrada, deve ser 0.
	 * @param nota Prova realizada.
	 * @param valorNota Nota da prova realizada. 
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * Calcula a media das notas cadastradas.
	 */
	public void mediaNota() {
		this.media = 0;
		this.somaPond = 0;
		for(int i = 0; i<ponderada.length;i++) {
			this.somaPond += ponderada[i];
		}
		
		for (int i = 0;i<this.notas.length;i++) {
			this.media += this.notas[i]*ponderada[i];
		}
		this.media = this.media/somaPond;
	}
	
	
	/**
	 * Retorna  true caso a media seja maior ou igual a 7 ou false caso a nota seja menor que 7.
	 * @return true caso aprovado, false caso reprovado
	 */
	public boolean aprovado() {
		mediaNota();
		if (media >= 7) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a string que representa a disciplina. Representa o nome da disciplina, as horas, a media e as notas.
	 */
	public String toString() {
		mediaNota();
		this.saidaNotas = "";
		for (int i=0;i<notas.length;i++) {
			this.saidaNotas += notas[i];
			if(i != (notas.length-1)) {
				this.saidaNotas += ", ";
			}
		}
		
		return (this.nomeDisciplina + " "+ this.horas + " "+this.media + " " + "[" + saidaNotas +"]");
	}
	
	
}
