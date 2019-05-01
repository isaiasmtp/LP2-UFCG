package lab03;
import java.util.Scanner;

/**
 * Classe principal do pacote
 * @author Isaias Martins
 *
 */
public class Main {
	
/**
 * Cria um menu
 */
private static void Menu() {	
	System.out.println("(C)adastrar Contato");
	System.out.println("(L)istar Contatos");
	System.out.println("(E)xibir Contato");
	System.out.println("(S)air");
	System.out.println("");
}	

public static void main(String[] args) {
	
	/**
	 * Criando Variaveis e objetos.
	 */
	Scanner scan = new Scanner(System.in);
	String entrada;
	int posicao;
	boolean executa = true;
	Agenda agenda = new Agenda();
	String nome;
	String sobrenome;
	String telefone;
	
	/**
	 * Loop de execurção de opções do menu.
	 */
	while(executa == true){
		Menu();
		System.out.print("Opções> ");
		entrada = scan.nextLine();
		System.out.println("");
		
		
		if (entrada.equals("C")) {	
			System.out.print("Posição: ");
			posicao= Integer.parseInt(scan.nextLine());
			
			if (!agenda.validaPosicao(posicao)) {
				System.out.println("\nPOSIÇÃO INVÁLIDA!\n");
			}else {
				System.out.print("Nome: ");
				nome= scan.nextLine();
				System.out.print("Sobrenome: ");
				sobrenome= scan.nextLine();
				System.out.print("Telefone: ");
				telefone= scan.nextLine();
				if(agenda.cadastraContato(posicao,nome,sobrenome,telefone)) {
					System.out.println("\nCadastro realizado com sucesso!\n");
				}else {
					System.out.println("\nCadastro não realizado!\n");
				}
			}
		
			
		}else if(entrada.equals("L")){
			System.out.println(agenda.listarContatos());
			
			
		}else if(entrada.equals("E")){
			System.out.print("Contato> ");
			posicao= Integer.parseInt(scan.nextLine());
			if (agenda.exibirContato(posicao) != null) {
				System.out.println("\n"+agenda.exibirContato(posicao)+"\n");
			}else {
				System.out.println("\nContato não cadastrado!\n");
			}
		
		
		}else if(entrada.equals("S")){
			executa = false;
			
		}else{
			System.out.println("OPÇÃO INVÁLIDA!");
			System.out.println("");
		}
		
	
		}
	}
}
