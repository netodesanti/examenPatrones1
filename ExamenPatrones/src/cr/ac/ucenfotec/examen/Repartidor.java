package cr.ac.ucenfotec.examen;

import java.util.Random;

public class Repartidor {
	private Carta[] naipe = new Carta[52];
	private Naipe deck = new Naipe();
	
	public Repartidor() {
		conseguirNaipe();
	}

	public void conseguirNaipe() {
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

}
