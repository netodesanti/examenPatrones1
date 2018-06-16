package cr.ac.ucenfotec.examen;

import java.util.ArrayList;

public class Mesa {
	Repartidor miRepartidor;
	ArrayList<Jugador> jugadores;
	
	public Mesa() {
		miRepartidor = new Repartidor();
		jugadores = new ArrayList<>();
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public Repartidor getMiRepartidor() {
		return miRepartidor;
	}
	
	public void agregarJugador(Jugador player) {
		if (jugadores.size() == 4) {
			throw new RuntimeException("La mesa está llena.");
		}
		
		jugadores.add(player);
	}
	
	public void empezarAJugar21() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < jugadores.size(); j++) {
				jugadores.get(j).agregarCartaAMano(miRepartidor.darCarta());
			}
		}
	}
}
