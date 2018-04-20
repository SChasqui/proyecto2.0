/*
 * Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package modelo;

import java.util.ArrayList;

public class Juego {

	//--------------------------------------
	// Relaciones
	//--------------------------------------

	/*
	 * Arraylist de los jugadores que han usado el juego
	 */
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	/*
	 * Batalla que se esa efectuando en ejecucion
	 */	
	private Batalla battle;

	/*
	 * Jugador Uno Actual
	 */
	private Jugador jugador1;

	/*
	 * Jugador Dos Actual
	 */
	private Jugador jugador2;


	//--------------------------------------
	// Constructor
	//--------------------------------------

	/*
	 * Construlle un objeto de tipo Juego
	 */
	public Juego() {
		jugador1 = new Jugador("Beta tester");
	}
	
	//--------------------------------------
	// Metodos.
	//--------------------------------------
	
	public void iniciarBatalla(String fondo) throws JugadorNoSeleccionadoException {
		//**************************************
		// Comprobar la existencia de Jugadores
		//**************************************
		if (jugador1 == null) {
			throw new JugadorNoSeleccionadoException("No ha selecionado al jugador 1");
		}else if(jugador2 == null) {
			throw new JugadorNoSeleccionadoException("No ha selecionado al jugador 2");
		}
		
		// Inicializa la Batalla
		battle = new Batalla(jugador1,jugador2, fondo);
	}
	
	public Jugador darJugador1() {
		return jugador1;
	}
	
	public Jugador darJugador2() {
		return jugador2;
	}
	

}
