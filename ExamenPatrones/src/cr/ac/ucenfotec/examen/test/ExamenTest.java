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
	private Repartidor dealer;
	private Jugador player, player2, player3;
	private Mesa miMesa;

	@Before
	public void setUp() {
		card = new Carta("Uno", "Flores", 1);
		card2 = new Carta("Dos", "Estrellas", 2);
		card3 = new Carta("As", "Escudos", 1);
		card4 = new Carta("Jota", "Gotas", 10);

		player = new Jugador();
		player.setNombre("Bryce Carlson");
		player.agregarCartaAMano(card);
		player.agregarCartaAMano(card2);

		deck = new Naipe();
		dealer = new Repartidor();
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
		assertEquals(52, dealer.getNaipe().length);

		assertNotEquals("Carta [nombre=As, palo=Escudos, valor=1]", dealer.getNaipe()[0]);
		assertNotEquals("Carta [nombre=Ka, palo=Gotas, valor=10]", dealer.getNaipe()[51]);
	}

	@Test
	public void testClaseJugador() {
		assertEquals("[Carta [nombre=Uno, palo=Flores, valor=1], Carta [nombre=Dos, palo=Estrellas, valor=2]]",
				player.getMano().toString());
		assertEquals("Carta [nombre=Uno, palo=Flores, valor=1]", player.getMano().get(0).toString());
		assertEquals("Carta [nombre=Dos, palo=Estrellas, valor=2]", player.getMano().get(1).toString());
	}

	@Test
	public void testMesaSinJugadores() {
		assertEquals(0, miMesa.getJugadores().size());
	}

	@Test
	public void testAgregarJugador() {
		agregarJugadores();
		assertEquals("Bryce Carlson", miMesa.getJugadores().get(0).getNombre());
	}

	@Test(expected = RuntimeException.class)
	public void testAgregarJugadorAMesaLlena() {
		for (int i = 0; i < 5; i++) {
			miMesa.agregarJugador(player);
		}
	}

	@Test
	public void testDarCarta() {
		player = new Jugador();

		assertEquals(52, dealer.getListNaipe().size());
		assertEquals(0, player.getMano().size());

		player.agregarCartaAMano(dealer.darCarta());

		assertEquals(51, dealer.getListNaipe().size());
		assertEquals(1, player.getMano().size());
	}

	@Test
	public void testEmpezarAJugar() {
		agregarJugadores();
		
		assertEquals(0, player.getMano().size());
		assertEquals(0, player2.getMano().size());

		miMesa.empezarAJugar21();

		assertEquals(2, player.getMano().size());
		assertEquals(2, player2.getMano().size());
	}

	@Test
	public void testGanador() {
		agregarJugadores();
		player.agregarCartaAMano(card2);
		player.agregarCartaAMano(card3);
		
		player2.agregarCartaAMano(card2);
		player2.agregarCartaAMano(card4);
		
		player3.agregarCartaAMano(card);
		player3.agregarCartaAMano(card3);
		
		assertEquals("Ken Uston", miMesa.ganador(miMesa.getJugadores()));
	}
	
	@Test
	public void verificarCambio() {
		player = new Jugador();
		player2 = new Jugador();
		
		card = new Carta("Jota", "Flores", 10);
		card2 = new Carta("Tres", "Estrellas", 3);
		card3 = new Carta("Cinco", "Flores", 5);
		
		player.agregarCartaAMano(card);
		player.agregarCartaAMano(card2);
		
		player2.agregarCartaAMano(card);
		player2.agregarCartaAMano(card3);
		
		miMesa.agregarJugador(player);
		miMesa.agregarJugador(player2);
				
		assertTrue(miMesa.verificarCambio(miMesa.getJugadores().get(0).getMano()));
		assertFalse(miMesa.verificarCambio(miMesa.getJugadores().get(1).getMano()));
	}
	
	public void agregarJugadores() {
		player = new Jugador();
		player.setNombre("Bryce Carlson");
		player2 = new Jugador();
		player2.setNombre("Ken Uston");
		player3 = new Jugador();
		player3.setNombre("Tommy Hyland");

		miMesa.agregarJugador(player);
		miMesa.agregarJugador(player2);
		miMesa.agregarJugador(player3);
	}
}
