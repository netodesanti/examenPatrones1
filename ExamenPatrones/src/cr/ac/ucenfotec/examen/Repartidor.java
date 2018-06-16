package cr.ac.ucenfotec.examen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Repartidor {
	private Carta[] naipe = new Carta[52];
	private Naipe deck = new Naipe();
	private int cartaActual = 0;
	private ArrayList<Carta> listNaipe;

	public Repartidor() {
		llenarNaipe();
		listNaipe = new ArrayList<Carta>(Arrays.asList(naipe));
	}

	public void llenarNaipe() {
		naipe = shuffle(deck.getMiNaipe());
	}

	public Carta[] shuffle(Carta card[]) {

		Random rand = new Random();

		for (int i = 0; i < 52; i++) {
			int r = i + rand.nextInt(52 - i);

			Carta temp = card[r];
			card[r] = card[i];

			card[i] = temp;
		}

		return card;
	}

	public Carta[] getNaipe() {
		return naipe;
	}

	public ArrayList<Carta> getListNaipe() {
		return listNaipe;
	}

	public Carta darCarta() {
		if (cartaActual < listNaipe.size()) {
			Carta card = listNaipe.get(cartaActual++);
			listNaipe.remove(cartaActual- 1);
			
			return card;
		} else {
			return null;
		}
	}

}
