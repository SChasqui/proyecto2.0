package modeloTest;


import static org.junit.Assume.assumeTrue;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Personaje;

class PersonajeTest extends TestCase{
	
	/*
	 * Informacion
	 * [0] ----> Bardock --> $800P
	 * [1] ----> Beerus --> $1000P
	 * [2] ----> Broly --> $1000P
	 * [3] ----> Frieza --> $900P
	 * [4] ----> GohanSSJ_Kid --> $1000P
	 * [5] ----> Goku --> $800P
	 * [6] ----> 18 --> $900P
	 * [7] ----> Goku_Red --> $1000P
	 * [8] ----> Kid_Buu --> $1000P
	 * [9] ----> Vegeta --> $900P 
	 */
	
	private Personaje aProbar;
	private Personaje adversario;

	void setupEscenario1() {
		aProbar = new Personaje("Goku_Red", 1000, 7);
		adversario = new Personaje("18", 900, 6);
		aProbar.setAdversario(adversario);
	}
	
	
	//--------------------------------------
	// Información
	//--------------------------------------
	/*	- posSprite[0] ---> Corresponde al sprite parado.
	 * 	- posSprite[1] ---> Corresponde al sprite punho.
	 * 	- posSprite[2] ---> Corresponde al sprite movimiento.
	 * 	- posSprite[3] ---> Corresponde al sprite del ataque mediano.
	 * 	- posSprite[4] ---> Corresponde al sprite del ataque pequeño.
	 *  - posSprite[5] ---> Corresponde al sprite del ataque grande.
	 *	- posSprite[6] ---> Corresponde al sprite de la patada.
	 *	- posSprite[7] ---> Corresponde al sprite de la recarga de ki.
	 * 	- posSprite[8] ---> Corresponde al sprite de cubrirse.
	 */
	
	@Test
	void testAtacarPuño() {
		setupEscenario1();
		assertEquals(aProbar.darArregloPosiciones()[1], -1);
		aProbar.atacarPuño();
		assertTrue(aProbar.darArregloPosiciones()[1] == 0);
		aProbar.actualizar();
		assertTrue(aProbar.darArregloPosiciones()[1] == 1);
	}
	
	@Test
	void testAtacarPatada() {
		setupEscenario1();
		assertEquals(aProbar.darArregloPosiciones()[6], -1);
		aProbar.atacarPatada();
		assertTrue(aProbar.darArregloPosiciones()[6] == 0);
		aProbar.actualizar();
		assertTrue(aProbar.darArregloPosiciones()[6] == 1);
		
	}
	
	@Test
	void testLanzarAtaqueMediano() {
		setupEscenario1();
		assertEquals(aProbar.darArregloPosiciones()[3], -1);
		aProbar.lanzarAtaqueDistanteMediano();
		assertTrue(aProbar.darArregloPosiciones()[3] == 0);
		aProbar.actualizar();
		assertTrue(aProbar.darArregloPosiciones()[3] == 1);
	}
	
	@Test
	void testLanzarAtaquePequeño() {
		setupEscenario1();
		assertEquals(aProbar.darArregloPosiciones()[4], -1);
		aProbar.lanzarAtaqueDistantePequeño();
		assertTrue(aProbar.darArregloPosiciones()[4] == 0);
		aProbar.actualizar();
		assertTrue(aProbar.darArregloPosiciones()[4] == 1);
	}
	
	@Test
	void testLanzarAtaqueGrande() {
		setupEscenario1();
		assertEquals(aProbar.darArregloPosiciones()[5], -1);
		aProbar.lanzarAtaqueDistanteGrande();
		assertTrue(aProbar.darArregloPosiciones()[5] == 0);
		aProbar.actualizar();
		assertTrue(aProbar.darArregloPosiciones()[5] == 1);
	}
	
	@Test
	void testRecargarKi() {
		setupEscenario1();
		int kiInicial = 0;
		int kiDespues = 0;
		
		//probando cuando el ki está al tope (no debería aumentar
		kiInicial = aProbar.darKI();
		aProbar.recargarKi();
		kiDespues = aProbar.darKI();
		assertEquals(kiInicial , kiDespues);
		
		//Prueba cuando el ki está menor al tope (aumenta)
		aProbar.restarKi(400);
		kiInicial = aProbar.darKI();
		aProbar.recargarKi();
		kiDespues = aProbar.darKI();
		assertTrue(kiInicial< kiDespues);
		
	}
	
	@Test
	void testDefender() {
		setupEscenario1();
		int resistenciaInicial = 0;
		int resistenciaDespues = 0;
		
		//probando cuando el ki está al tope (no debería aumentar
		resistenciaInicial = aProbar.darResistencia();
		aProbar.defender();
		resistenciaDespues = aProbar.darResistencia();
		assertEquals(resistenciaDespues , resistenciaInicial*2);
		
	}
	
	@Test
	void testNormalizarResistencia() {
		setupEscenario1();
		
		int resistenciaOriginal = aProbar.darResistencia();
		aProbar.defender();
		aProbar.normalizarResistencia();
		int resistenciaNormalizada = aProbar.darResistencia();
		assertTrue(resistenciaNormalizada == resistenciaOriginal);
		
	}
	
	@Test
	void testMoverX() {
		setupEscenario1();
		aProbar.cambiarPosX(0);
		aProbar.moverX(-5);
		assertFalse(aProbar.darPosX() != 0);
		
		aProbar.moverX(5);
		assertTrue(aProbar.darPosX() == 5);
		
	}
	
	@Test
	void testMoverY() {
		setupEscenario1();
		aProbar.cambiarPosY(0);
		aProbar.moverY(-5);
		assertFalse(aProbar.darPosY() != 0);
		
		aProbar.moverY(9);
		assertTrue(aProbar.darPosY() == 9);
		
		
	}
	
	@Test
	void actualizar() {
		
	}
	
	
}
