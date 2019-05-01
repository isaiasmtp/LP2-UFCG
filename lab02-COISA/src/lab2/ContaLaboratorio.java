package lab2;

/**
 * Representa uma conta no laboratorio, indentificado pelo nome, conta com uma cota e um valor utilizado.
 * @author Isaias Martins
 *
 */
public class ContaLaboratorio {

	private String nomeLab;
	private int cota;
	private int usado;
	
	/**
	 * Constroi uma conta no laboratorio com nome e cota definidos pelos parametros.
	 * @param nomeLab Nome do laboratorio.
	 * @param cota Cota que a conta do laboratorio tem.
	 */
	public ContaLaboratorio (String nomeLab, int cota){
		this.nomeLab = nomeLab;
		this.cota = cota;
		
	}
	
	/**
	 * Constroi uma conta no laboratorio com nome e cota definida para 2000mb.
	 * @param nomeLab Nome do laboratorio.
	 */
	public ContaLaboratorio(String nomeLab) {
		this.nomeLab = nomeLab;
		this.cota = 2000;
	}
	
	/**
	 * Soma o espaço usado, com mais espaço utilizado.
	 * @param mbytes Espaço usado.
	 */
	public void consomeEspaco(int mbytes) {
		this.usado += mbytes;
	}
	
	/**
	 * Libera espaco, do espaco utilizado.
	 * @param mbytes
	 */
	public void liberaEspaco(int mbytes) {
		this.usado = this.usado - mbytes;
		
	}
	
	/**
	 * Retorna um boleano, verdadeiro caso atinga a cota e negativo caso nao atinga a cota.
	 * @return true caso atinja a bonta, false caso nao atinga a cota.
	 */
	public boolean atingiuCota() {
		if (this.usado >= this.cota) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna String que representa o nome do laboratorio, espaco usado e a cota da conta do laboratorio.
	 * @return nome do laboratorio, espaco usado e cota.
	 */
	public String toString() {
		return (this.nomeLab + " " + this.usado +"/"+this.cota);
	}
	
}
