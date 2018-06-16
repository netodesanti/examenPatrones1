package cr.ac.ucenfotec.examen.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cr.ac.ucenfotec.examen.Carta;
import cr.ac.ucenfotec.examen.Jugador;
import cr.ac.ucenfotec.examen.Mesa;
import cr.ac.ucenfotec.examen.Naipe;
import cr.ac.ucenfotec.examen.Repartidor;

public class ExamenTest {

	private Carta card, card2, card3, card4;
	private Naipe deck;
	private Repartidor cartasJuego;
	private Jugador player;
	private Mesa miMesa;

	@Before
	public void setUp() {
		card = new Carta("Uno", "Flores", 1);
		card2 = new Carta("Dos", "Estrellas", 2);
		card3 = new Carta("As", "Escudos", 1);
		card4 = new Carta("Jota", "Gotas", 10);
		
		deck = new Naipe();
		cartasJuego = new Repartidor();
		player = new Jugador();
		miMesa = new Mesa();
	}

	@Test(expected = RuntimeException.class)
	public void testValorEntre1y10() {
		card2.setValor(0);
		card3.setValor(11);

		assertTrue(card.chkValor(card));
		assertTrue(card.chkValor(card3));
		assertFalse(card.chkValor(card2));
		assertFalse(card.chkValor(card4));
	}

	@Test
	public void testCartasIguales() {
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

	@Test
	public void testClaseJugador() {
		player.setNombre("Bryce Carlson");
		player.agregarCartaAMano(card);
		player.agregarCartaAMano(card2);

		assertEquals("[Carta [nombre=Uno, palo=Flores, valor=1], Carta [nombre=Dos, palo=Estrellas, valor=2]]",
				player.getMano().toString());
		assertEquals("Carta [nombre=Uno, palo=Flores, valor=1]", player.getMano().get(0).toString());
		assertEquals("Carta [nombre=Dos, palo=Estrellas, valor=2]", player.getMano().get(1).toString());
	}
	
	@Test
	public void testMesaSinJugadores() {
		assertEquals(0, miMesa.getJugadores().size());
	}
}
