package cr.ac.ucenfotec.examen;

import java.util.ArrayList;

public class Jugador {
	String nombre;
	ArrayList<Carta> mano = new ArrayList<>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Carta> getMano() {
		return mano;
	}

	public void agregarCartaAMano(Carta card) {
		this.mano.add(card);
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", mano=" + mano + "]";
	}
	
}
