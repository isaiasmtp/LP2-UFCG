package lab2;

public class Aluno {

	private ContaLaboratorio lab;
	
	public void cadastraLaboratorio(String nomeLaboratorio) {
		this.lab = new ContaLaboratorio(nomeLaboratorio);
	}
	
	public void cadastraLaboratorio(String nomeLaboratorio,int cota) {
		this.lab = new ContaLaboratorio(nomeLaboratorio, cota);
	}
	
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		lab.consomeEspaco(mbytes);
	}
	
	
	
	
	
	
}
