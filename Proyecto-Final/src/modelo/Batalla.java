 /* Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */

package modelo;

/*
 * Clase que modela una batalla
 */
public class Batalla {

	//--------------------------------------
	// Constantes
	//--------------------------------------

	/*
	 * Constante que determina el tiempo inicial de un combate
	 */
	public static final int TIEMPO_INICIAL = 120;
	
	/*
	 * Constante que respresenta el número de escenarios
	 */
	public static final int NUM_ESCENARIOS = 6;
	
	//--------------------------------------
	// Relaciones
	//--------------------------------------

	/*
	 * Jugador Uno
	 */
	private Jugador jugador1;
	
	/*
	 * Jugador Dos
	 */
	private Jugador jugador2;
	
	/*
	 * Arreglo de fondos
	 * 
	 * Informacion
	 * [0] ----> escenario1
	 * [1] ----> escenario2
	 * [2] ----> escenario3
	 * [3] ----> escenario4
	 * [4] ----> escenario5
	 * [5] ----> escenario6
	 */
	private String[] fondos = {"escenario1", "escenario2", "escenario3", "escenario4", "escenario5", "escenario6"};
	
	/*
	 * Fondo de la batalla
	 */
	private String fondo;

	//--------------------------------------
	// Atributos
	//--------------------------------------

	/*
	 * entero que representa el numero de segundos restante en un combate
	 */
	private int tiempoRestante;

	//--------------------------------------
	// Constructor
	//--------------------------------------

	/*
	 * Construlle un objeto de tipo Batalla
	 */
	public Batalla(Jugador playerOne, Jugador playertwo, int fondo) {

		// Se inicializa el contador de tiempo de la batalla
		tiempoRestante = TIEMPO_INICIAL;

		// Se inicializa el jugador uno
		jugador1 = playerOne;

		// Se inicializa el jugador dos
		jugador2 = playertwo;
		
		// Se inicializa el fondo
		this.fondo = fondos[fondo-1];
		
		jugador1.darPersonaje().setAdversario(jugador2.darPersonaje());
		jugador2.darPersonaje().setAdversario(jugador1.darPersonaje());
	}

	//--------------------------------------
	// Metodos
	//--------------------------------------

	/*
	 * Metodo encargado de reestar 1 al tiempo restante cada vez que sea llamado<br>
	 * <b> Pre: </b> tiempoRestante != 0 <br>
	 * <b> Post: </b> tiempo restante ha disminuido en 1 <br>
	 */
	public void restarUnSegundo() {
		tiempoRestante--;
	}
	
	public int darTiempoActual() {
		return tiempoRestante;
	}
	
	public int darNumeroEscenarios() {
		return NUM_ESCENARIOS;
	}
	
	public String darFondos() {
		return fondo;
	}
	
	public Jugador darJugador1() {
		return jugador1;
	}
	
	public Jugador darJugador2() {
		return jugador2;
	}

}
