package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab03.Contato;

/**
 * Classe de teste do contato
 * @author Isaias Martins 
 *
 */
class ContatoTest {

    private Contato contatoBasico1;
    private Contato contatoBasico2;
    private Contato contatoBasico5;
    private Contato contatoBasico4;
    private Contato contatoBasico3;
    
    /**
     * Constroi contatos.
     */
    @BeforeEach
    public void criaContato() {
                contatoBasico1 = new Contato("Matheus", "Gaudencio", "2101-0000");
                contatoBasico2 = new Contato("Matheus", "Gaudencio", "4402-8922");
                contatoBasico4 = new Contato("Matheus", "Gaugau", "2101-0000");
                contatoBasico5 = new Contato("Mateus", "Gaugau", "2101-0000");
                contatoBasico3 = new Contato("Mateus", "Gaugau", "2101-0000");
    }
    
    /**
     * Teste igualdade entre contatos.
     */
	@Test
	void testEqualsObject() {
		assertEquals(contatoBasico1.equals(contatoBasico2),true);
		assertEquals(contatoBasico1.equals(contatoBasico4),false);
		assertEquals(contatoBasico4.equals(contatoBasico5),false);
		assertEquals(contatoBasico1.equals(contatoBasico5),false);
		assertEquals(contatoBasico3.equals(contatoBasico5),true);
	}
    
	/**
	 * Testa a criação de contatos.
	 */
	@Test
	void testContato() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("  ", "mfkdjlmd", "ojkfdijnfijn"));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "mfkdjlmd", "ojkfdijnfijn"));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "", "ojkfdijnfijn"));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "   ", "ojkfdijnfijn"));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "   ", "   "));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "", ""));
		assertThrows(IllegalArgumentException.class, () -> new Contato("fesfsd", "   ", "ojkfdijnfijn"));
		assertThrows(IllegalArgumentException.class, () -> new Contato("sdfsdf", "", "ojkfdijnfijn"));
		assertThrows(IllegalArgumentException.class, () -> new Contato("sdfsf", "fsdfsdf", "  "));
		assertThrows(IllegalArgumentException.class, () -> new Contato("esfsfd", "fsdfsdf", ""));
	}

	/**
	 * Testa a saida do metodo toString do contato.
	 */
	@Test
	void testToString() {
		assertEquals(contatoBasico1.toString(), contatoBasico1.getNome() + " " + contatoBasico1.getSobrenome() + " - "+ contatoBasico1.getTelefone());
		assertEquals(contatoBasico2.toString(), contatoBasico2.getNome() + " " + contatoBasico2.getSobrenome() + " - "+ contatoBasico2.getTelefone());
		assertEquals(contatoBasico4.toString(), contatoBasico4.getNome() + " " + contatoBasico4.getSobrenome() + " - "+ contatoBasico4.getTelefone());
		assertEquals(contatoBasico5.toString(), contatoBasico5.getNome() + " " + contatoBasico5.getSobrenome() + " - "+ contatoBasico5.getTelefone());
	}

}
