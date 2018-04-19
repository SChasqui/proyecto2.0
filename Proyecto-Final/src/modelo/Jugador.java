/*
 * Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package modelo;

public class Jugador {

	//--------------------------------------
	// Atributos
	//--------------------------------------

	/*
	 * Nicname del Jugador
	 */

	private String nickName;

	/*
	 * Arreglo de personajes desbloqueados por el jugador
	 */
	private Personaje[] desbloqueados;

	/*
	 * Arreglo de personajes bloqueados para el jugador
	 */
	private Personaje [] bloqueados;

	/*
	 * Puntos ganados por el jugador en las batallas
	 */
	private int puntos;

	/*
	 * Personaje que el jugador esta usando durante la batalla en transcurso
	 */
	private Personaje personajeActual;

	//--------------------------------------
	// Constructor
	//--------------------------------------
	public Jugador(String nombre) {
		nickName = nombre;
		puntos = 0;
		
		String[] borrar = {"probando"};
		personajeActual = new Personaje(borrar, 10);
	}

	//--------------------------------------
	// Metodos
	//--------------------------------------
	
	public String darNickName() {
		return nickName;
	}
	
	public Personaje darPersonaje() {
		return personajeActual;
	}
	
}
