package modeloTest;



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

	void setupEscenario1() throws Exception {
		aProbar = new Personaje("Goku_Red", 1000, 7);
	}

	void testFueGolpeado() {
		
	}

}
