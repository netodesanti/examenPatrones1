package cr.ac.ucenfotec.examen;

public class Naipe {
	private Carta[] miNaipe = new Carta[52];

	private String[] nombres = { "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez",
			"Jota", "Qüina", "Ka" };
	private String[] palos = { "Escudos", "Flores", "Estrellas", "Gotas" };

	private int valor = 1;
	private String nombre, palo;

	public Naipe() {
		llenarDeck();
	}

	public void llenarDeck() {
		for (int i = 0; i < nombres.length; i++) {
			for (int j = 0; j < palos.length; j++) {
				if (nombres[i].equals("Jota") || nombres[i].equals("Qüina") || nombres[i].equals("Ka")) {
					valor = 10;
				}

				nombre = nombres[i];
				palo = palos[j];

				Carta card = new Carta(nombre, palo, valor);
				miNaipe[palos.length * i + j] = card;
			}

			valor++;
		}
	}

	public Carta[] getMiNaipe() {
		return miNaipe;
	}

}
