package modeloTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Juego;
import modelo.Jugador;

class JuegoTest {
	
	private Juego j;
	
	void setUpEscenario1() {
		j = new Juego();
	}

	@Test
	void agregarJugadoresTest1() {
		setUpEscenario1();
		j.agregarJugadores("", 1);
		j.agregarJugadores(null, 2);
		Jugador p = new Jugador("Jugador idiota");
		assertTrue(p.compareTo(j.darJugador1()) == 0 && p.compareTo(j.darJugador2()) == 0);
	}

}
