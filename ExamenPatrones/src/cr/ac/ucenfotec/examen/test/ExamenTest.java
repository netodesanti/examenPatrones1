package cr.ac.ucenfotec.examen.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cr.ac.ucenfotec.examen.Carta;
import cr.ac.ucenfotec.examen.Naipe;
import cr.ac.ucenfotec.examen.Repartidor;

public class ExamenTest {

	private Carta card, card2, card3, card4;
	private Naipe deck = new Naipe();
	private Repartidor cartasJuego = new Repartidor();
	
	@Test(expected = RuntimeException.class)
	public void testValorEntre1y10() {
		card.setValor(1);
		card2.setValor(0);
		card3.setValor(10);
		card4.setValor(11);
		
		assertTrue(card.chkValor(card));
		assertTrue(card.chkValor(card3));
		assertFalse(card.chkValor(card2));
		assertFalse(card.chkValor(card4));
	}
	
	@Test
	public void testCartasIguales() {
		card = new Carta("Uno", "Flores", 1);
		card2 = new Carta("Dos", "Estrellas", 2);
		card3 = new Carta("As", "Escudos", 1);
		
		assertTrue(card.equals(card, card3));
		assertFalse(card.equals(card, card2));
	}
	
	@Test
	public void testDeckCartas() {
		assertEquals(52, deck.getMiNaipe().length);
		
		assertEquals("Escudos", deck.getMiNaipe()[0].getPalo());
		assertEquals("Flores", deck.getMiNaipe()[1].getPalo());
		assertEquals("Estrellas", deck.getMiNaipe()[2].getPalo());
		assertEquals("Gotas", deck.getMiNaipe()[3].getPalo());
		assertEquals("Escudos", deck.getMiNaipe()[4].getPalo());
	}
	
	@Test
	public void testDeckCartasRepartidor() {
		assertEquals(52, cartasJuego.getNaipe().length);
		
		assertNotEquals("Carta [nombre=As, palo=Escudos, valor=1]", cartasJuego.getNaipe()[0]);
		assertNotEquals("Carta [nombre=Ka, palo=Gotas, valor=10]", cartasJuego.getNaipe()[51]);
	}
}
