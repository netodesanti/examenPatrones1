package cr.ac.ucenfotec.examen.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cr.ac.ucenfotec.examen.Carta;

public class CartaTest {

	private Carta card, card2, card3, card4;
	
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
	
}
