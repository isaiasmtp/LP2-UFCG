package testesEntidades;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.Cliente;

/**
 * Classe que testa cliente
 * @author Isaias Martins
 *
 */
class ClienteTest {

	/**
	 * Metodo que testa Cliente
	 */
	@Test
	void testCliente() {
		assertThrows(IllegalArgumentException.class, () -> new Cliente("000000000","nome", "email","localizacao"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("00000000000"," ", "email","localizacao"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("00000000000","nome", "  ","localizacao"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("00000000000","nome", "email",""));
		
		assertThrows(NullPointerException.class, () -> new Cliente("00000000000",null, "email","localizacao"));
		assertThrows(NullPointerException.class, () -> new Cliente("00000000000","nome", null,"localizacao"));
		assertThrows(NullPointerException.class, () -> new Cliente("00000000000","nome", "email",null));
		assertThrows(NullPointerException.class, () -> new Cliente(null,"nome", "email","localizacao"));
		
		}

	/**
	 * Testa metodo toString
	 */
	@Test
	void testToString() {
		Cliente cliente = new Cliente("00000000000","nome", "email","localizacao");
		assertEquals(cliente.toString(),"nome - localizacao - email");
	}

	/**
	 * Testa metodo Equais
	 */
	@Test
	void testEqualsObject() {
		Cliente cliente1 = new Cliente("00000000000","nome", "email","localizacao");
		Cliente cliente2 = new Cliente("00000000000","n", "e","l");

		Cliente cliente3 = new Cliente("00000000000","nome", "email","localizacao");
		Cliente cliente4 = new Cliente("00000000001","nome", "email","localizacao");

		assertTrue(cliente1.equals(cliente2));
		assertFalse(cliente3.equals(cliente4));
	}

	/**
	 * Testa metodo CompareTo
	 */
	@Test
	void testCompareTo() {
		Cliente cliente1 = new Cliente("00000000000","A", "email","localizacao");
		Cliente cliente2 = new Cliente("00000000000","A", "email","localizacao");
		Cliente cliente3 = new Cliente("00000000001","B", "email","localizacao");
		
		assertEquals(cliente1.compareTo(cliente2), 0);
		assertEquals(cliente1.compareTo(cliente3), -1);
		assertEquals(cliente3.compareTo(cliente1), 1);
	}

}
