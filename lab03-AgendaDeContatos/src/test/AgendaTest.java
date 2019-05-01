package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab03.Agenda;
import lab03.Contato;

/**
 * Classe de testes da agenda
 * @author Isaias Martins
 *
 */
class AgendaTest {
	
	private Agenda agenda1;
	private Agenda agenda2;
	private Agenda agenda3;
	private Agenda agenda4;

	/**
	 * Cria agenda e insere contatos.
	 */
	 @BeforeEach
	    public void criaAgenda() {
		 agenda1 = new Agenda();
		 agenda2 = new Agenda();
		 agenda3 = new Agenda();
		 agenda4 = new Agenda();
		 
		agenda1.cadastraContato(1, "nome1", "sobrenome1", "4002-8922");
		agenda1.cadastraContato(0, "teteus", "gaugau", "4002-8922");
		agenda1.cadastraContato(100, "nome2", "sobrenome1", "4002-8922");
		 
		agenda2.cadastraContato(1, "nome1", "sobrenome1", "4002-8922");
		agenda2.cadastraContato(0, "teteus", "gaugau", "4002-8922");
		agenda2.cadastraContato(100, "nome2", "sobrenome1", "4002-8922");
		
		agenda3.cadastraContato(31, "nomefe1", "sobregernome1", "40402-8922");
		agenda3.cadastraContato(50, "tetsafeus", "gaugergau", "4002-893222");
		agenda3.cadastraContato(10, "nomgree2", "sobregernome1", "4002-4238922");
		
		agenda4.cadastraContato(1, "a1", "a2", "1");
		agenda4.cadastraContato(2, "b1", "b2", "2");
		agenda4.cadastraContato(3, "c1", "c2", "3");
		
		
		 
	 }
			 
	 
		
	 /**
	  * Teste de Validação de posição
	  */
	@Test
	void testValidaPosicao() {
		assertEquals(agenda1.validaPosicao(50),true);
		assertEquals(agenda1.validaPosicao(1),true);
		assertEquals(agenda1.validaPosicao(100),true);
		
		assertEquals(agenda1.validaPosicao(0),false);
		assertEquals(agenda1.validaPosicao(101),false);
		assertEquals(agenda1.validaPosicao(-1),false);
		assertEquals(agenda1.validaPosicao(1000),false);
		assertEquals(agenda1.validaPosicao(-100),false);
	}

	/**
	 * Teste de cadastro de contatos na agenda.
	 */
	@Test
	void testCadastraContato() {
		assertEquals(agenda1.cadastraContato(1, "nomerwe1", "sobrerewnome1", "4002922"),true);
		assertEquals(agenda1.cadastraContato(0, "teterweus", "grweaugau", "402-8922"),true);
		
		assertEquals(agenda1.cadastraContato(13, "a2", "a1", "4002-8922"),true);
		assertEquals(agenda1.cadastraContato(13, "a2", "a1", "4002-8922"),false);
		assertEquals(agenda1.cadastraContato(13, "a2", "a1", "4002-892"),false);
		
		assertEquals(agenda1.cadastraContato(14, "nome2", "   ", "4002-8922"),false);
		assertEquals(agenda1.cadastraContato(15, "  ", "sobrenome1", "4002-8922"),false);
		assertEquals(agenda1.cadastraContato(16, "  ", "  ", "4002-8922"),false);
		assertEquals(agenda1.cadastraContato(17, "nome2", " rte  ", "   "),false);
		assertEquals(agenda1.cadastraContato(18, "  ", "  ", "   "),false);
		assertEquals(agenda1.cadastraContato(99, "", "", ""),false);
		assertThrows(IndexOutOfBoundsException.class, () -> agenda1.cadastraContato(101, "isaias", "martins", "400-8922"));
		assertThrows(IndexOutOfBoundsException.class, () -> agenda1.cadastraContato(1000, "isaias", "martins", "400-8922"));
		assertThrows(IndexOutOfBoundsException.class, () -> agenda1.cadastraContato(-1, "isaias", "martins", "400-8922"));
	}

	/**
	 * Testes de exibição de contato
	 */
	@Test
	void testExibirContato() {
		agenda1.cadastraContato(88, "nombre", "sobrenome1", "4002-8922");
		String msg1 = ("nombre" + " " + "sobrenome1" + " - "+ "4002-8922");
		
		assertEquals(agenda1.exibirContato(88),msg1);
		
		//Testando contatos não cadastrados
		assertThrows(NullPointerException.class, () ->agenda1.exibirContato(39));
		assertThrows(NullPointerException.class, () ->agenda1.exibirContato(46));

	}

	/**
	 * Teste para listar os contatos da agenda.
	 */
	@Test
	void testListarContatos() {
		
		agenda4.cadastraContato(1, "a1", "a2", "1");
		agenda4.cadastraContato(2, "b1", "b2", "2");
		agenda4.cadastraContato(3, "c1", "c2", "3");
		
		String msg1 = ("1 - "+"a1 "+ "a2\n" + "2 - "+"b1 "+ "b2\n" + "3 - "+"c1 "+ "c2\n");
		assertEquals(agenda4.listarContatos(),msg1);
		
		
	}

	/**
	 * Teste de comparar agendas.
	 */
	@Test
	void testEqualsObject() {
		assertEquals(agenda1.equals(agenda2),true);
		assertEquals(agenda1.equals(agenda3),false);
	}

}
