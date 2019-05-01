package controle;

import java.util.Scanner;

/**
 * Classe principal Main
 * 
 * @author Isaias Martins
 *
 */
public class Main {
	static Sistema colegio = new Sistema();
	static Scanner scan = new Scanner(System.in);

	private static void Menu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!\n");
		System.out.print("Opção> ");
	}

	private static void cadastrarAluno() {
		String matricula = "";
		String nome = "";
		String curso = "";
		System.out.print("Matrícula: ");
		matricula = scan.nextLine();

		if (colegio.existeAluno(matricula)) {
			System.out.println("MATRÍCULA JÁ CADASTRADA!\n");
		} else {
			System.out.print("Nome: ");
			nome = scan.nextLine();
			System.out.print("Curso: ");
			curso = scan.nextLine();

			colegio.cadastraAluno(matricula, nome, curso);
			System.out.println("CADASTRO REALIZADO!\n");
		}
	}

	private static void exibirAluno() {
		String matricula = "";
		System.out.print("Matrícula: ");
		matricula = scan.nextLine();

		System.out.println(colegio.exibirAluno(matricula));
	}

	private static void criarGrupo() {
		String grupo = "";
		System.out.print("Grupo: ");
		grupo = scan.nextLine();

		if (colegio.cadastraGrupo(grupo)) {
			System.out.println("\nCADASTRO REALIZADO!\n");
		} else {
			System.out.println("\nGRUPO JÁ CADASTRADO!\n");
		}

	}

	private static void alocarAluno() {
		String matricula = "";
		String grupo = "";

		System.out.print("Matrícula: ");
		matricula = scan.nextLine();
		System.out.print("Grupo: ");
		grupo = scan.nextLine();

		if (!colegio.existeAluno(matricula)) {
			System.out.println("\nAluno não cadastrado!\n");
		} else if (!colegio.existeGrupo(grupo)) {
			System.out.println("\nGrupo não cadastrado!\n");
		} else {
			colegio.alocaAluno(matricula, grupo);
			System.out.println("ALUNO ALOCADO!\n");
		}
	}

	private static void imprimirGrupo() {
		String grupo = "";
		System.out.print("Grupo: ");
		grupo = scan.nextLine();

		if (!colegio.existeGrupo(grupo)) {
			System.out.println("\nGrupo não cadastrado!\n");
		} else {
			System.out.println("\nAlunos do grupo " + grupo + ":");
			System.out.println(colegio.imprimirGrupo(grupo));
		}

	}

	private static void alocarOuImprimir() {
		String opcao = "";
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		opcao = scan.nextLine();

		if (opcao.equals("A")) {
			alocarAluno();
		} else {
			imprimirGrupo();
		}
	}

	private static void registrarResposta() {
		String matricula = "";

		System.out.print("Matrícula: ");
		matricula = scan.nextLine();

		if (!colegio.adicionarResposta(matricula)) {
			System.out.println("Aluno não cadastrado");
		}

		System.out.println("");
	}

	private static void imprimirRespostas() {
		System.out.println(colegio.imprimirRespostas());
	}

	public static void main(String[] args) {
		String entrada = "";
		boolean exec = true;

		do {
			Menu();
			entrada = scan.nextLine();
			System.out.println("");

			if (entrada.equals("C")) {
				cadastrarAluno();

			} else if (entrada.equals("E")) {
				exibirAluno();

			} else if (entrada.equals("N")) {
				criarGrupo();

			} else if (entrada.equals("A")) {
				alocarOuImprimir();

			} else if (entrada.equals("R")) {
				registrarResposta();

			} else if (entrada.equals("I")) {
				imprimirRespostas();

			} else if (entrada.equals("O")) {
				exec = false;

			} else {
				System.out.println("OPÇÃO INVÁLIDA!");
				System.out.println("");
			}
		} while (exec);

	}

}
