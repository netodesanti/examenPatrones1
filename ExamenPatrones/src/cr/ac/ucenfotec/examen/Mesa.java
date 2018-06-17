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

	public String ganador(ArrayList<Jugador> jugador) {
		String ganador = "";

		if (jugador.size() == 1) {
			ganador = jugador.get(0).getNombre();
		}

		if (jugador.size() == 2) {
			ganador = compararDos(jugador.get(0), jugador.get(1)).getNombre();
		}

		if (jugador.size() == 3) {
			if (compararDos(jugador.get(0), jugador.get(1)) == null) {
				if (compararDos(jugador.get(0), jugador.get(2)) == null) {
					return "Empataron los tres jugadores";
				} else {
					return "Empataron " + jugador.get(0).getNombre() + " y " + jugador.get(1).getNombre();
				}
			} else if (compararDos(jugador.get(0), jugador.get(2)) == null) {
				return "Empataron " + jugador.get(0).getNombre() + " y " + jugador.get(2).getNombre();
			} else if (compararDos(jugador.get(0), jugador.get(1)) != null) {
				Jugador ganeTemp = compararDos(jugador.get(0), jugador.get(1));
				ganador = compararDos(ganeTemp, jugador.get(2)).getNombre();
			}
		}

		if (jugador.size() == 4) {
			if (compararDos(jugador.get(0), jugador.get(1)) == null) {
				if (compararDos(jugador.get(0), jugador.get(2)) == null) {
					if (compararDos(jugador.get(2), jugador.get(3)) == null) {
						ganador = "Empataron todos los jugadores";
					} else if (compararDos(jugador.get(0), jugador.get(1)) == null) {
						if (compararDos(jugador.get(0), jugador.get(2)) == null) {
							return "Empataron los tres jugadores";
						} else {
							return "Empataron " + jugador.get(0).getNombre() + " y " + jugador.get(1).getNombre();
						}
					}
				}
			} else if(compararDos(jugador.get(2), jugador.get(3)) == null) {
				return "Empataron " + jugador.get(2) + " y " + jugador.get(3);
			} else if (compararDos(jugador.get(0), jugador.get(1)) != null) {
				Jugador ganeTemp = compararDos(jugador.get(0), jugador.get(1));
				Jugador ganeTemp2 = compararDos(jugador.get(2), jugador.get(3));
				ganador = compararDos(ganeTemp, ganeTemp2).getNombre();
			}
		}
		
		return ganador;
	}

	public boolean verificarCambio(ArrayList<Carta> mano) {
		boolean valor = false;

		if (mano.get(0).getNombre().equals("Jota") || mano.get(0).getNombre().equals("Qüina")
				|| mano.get(0).getNombre().equals("Ka")) {
			if (mano.get(1).getValor() == 3) {
				valor = true;
			}
		} else if (mano.get(0).getValor() == 3) {
			if (mano.get(0).getNombre().equals("Jota") || mano.get(0).getNombre().equals("Qüina")
					|| mano.get(0).getNombre().equals("Ka")) {
				valor = true;
			}
		} else {
			valor = false;
		}

		return valor;
	}

	public boolean ganadorMedio(Jugador jugador) {
		boolean valor = false;

		if (jugador.getMano().get(0).getValor() == 10) {
			if (jugador.getMano().get(1).getValor() == 2) {
				valor = true;
			}
		} else if (jugador.getMano().get(0).getValor() == 2) {
			if (jugador.getMano().get(1).getValor() == 10) {
				valor = true;
			}
		} else {
			valor = false;
		}

		return valor;
	}
	
	public boolean ganadorComodin(Jugador jugador) {
		if (jugador.getMano().get(0).getNombre().equals("Siete") && jugador.getMano().get(0).getPalo().equals("Gotas")
				|| jugador.getMano().get(1).getNombre().equals("Siete")
						&& jugador.getMano().get(1).getPalo().equals("Gotas")) {
			return true;
		} else {
			return false;
		}
	}

	private Jugador compararDos(Jugador jugador, Jugador jugador2) {
		int dif, dif2;
		Jugador ganador = null;

		dif = 21 - (jugador.getMano().get(0).getValor() + jugador.getMano().get(1).getValor());
		dif2 = 21 - (jugador2.getMano().get(0).getValor() + jugador2.getMano().get(1).getValor());

		if (dif == dif2) {
			ganador = null;
		}

		if (dif < dif2) {
			ganador = jugador;
		} else if (dif > dif2) {
			ganador = jugador2;
		}

		return ganador;
	}
}
