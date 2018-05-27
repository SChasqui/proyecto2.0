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
	void agregarJugadoresTest() {
		setUpEscenario1();
		j.agregarJugadores("", 1);
		assertTrue(j.compare(new Jugador("Jugador idiota"), j.darJugador1()) == 0);
	}

}
