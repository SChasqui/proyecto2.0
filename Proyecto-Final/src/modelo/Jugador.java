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
	 * raiz derecha
	 */
	private Jugador derecha;
	
	/*
	 * raiz izquierda
	 */
	private Jugador izquierda;

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
	public Jugador(String nombre, String personaje) {
		nickName = nombre;
		puntos = 0;
		personajeActual = new Personaje(personaje, 10);
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

	public Jugador darDerecha() {
		return derecha;
	}

	public Jugador darIzquierda() {
		return izquierda;
	}

	public void cambiarDerecha(Jugador derecha) {
		this.derecha = derecha;
	}

	public void cambiarIzquierda(Jugador izquierda) {
		this.izquierda = izquierda;
	}
	
}
