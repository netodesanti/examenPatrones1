package cr.ac.ucenfotec.examen;

public class Carta {
	private String nombre;
	private String palo;
	private int valor;
	
	public Carta() {
		super();
	}

	public Carta(String nombre, String palo, int valor) {
		super();
		this.nombre = nombre;
		this.palo = palo;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean chkValor(Carta card) {
		if (card.getValor() >= 1 && card.getValor() <= 10) {
			return true;
		} else {
			throw new RuntimeException("El valor se sale del rango.");
		}
	}
	
	public boolean equals(Carta card, Carta card2) {
		if (card.getValor() == card2.getValor()) {
			return true;
		} else {
			return false;
		}
	}

}
