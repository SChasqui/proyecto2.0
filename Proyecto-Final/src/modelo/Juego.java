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
	private Jugador raiz;

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
	
	/*
	 * Arreglo de fondos
	 */
	private String[] fondos;


	//--------------------------------------
	// Constructor
	//--------------------------------------

	/*
	 * Construlle un objeto de tipo Juego
	 */
	public Juego() {
	}
	
	//--------------------------------------
	// Metodos
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
	
	public void agregarJugador(Jugador jugador) {
		if (raiz == null) {
			raiz = jugador;
		}else {
			agregarJugador(jugador, raiz);
		}
	}
	
	public void agregarJugador(Jugador jugador, Jugador nodo) {
		if (nodo.darNickName().compareTo(jugador.darNickName()) < 0) {
			if (nodo.darDerecha() == null) {
				nodo.cambiarDerecha(jugador);
			}else {
				agregarJugador(jugador, nodo.darDerecha());
			}
		}else {
			if (nodo.darIzquierda() == null) {
				nodo.cambiarIzquierda(jugador);
			}else {
				agregarJugador(jugador, nodo.darIzquierda());
			}
		}
	}
	
	public Jugador buscarJugador(String nickName, Jugador nodo) {
		
		if (nodo == null) {
			return null;
		}else if(nodo.darNickName().equals(nickName)) {
			return nodo;
		}else if(nodo.darNickName().compareTo(nickName) < 0){
			return buscarJugador(nickName, nodo.darDerecha());
		}else if(nodo.darNickName().compareTo(nickName) > 0) {
			return buscarJugador(nickName, nodo.darIzquierda());
		}
		return null;
	}
	
	public void agregarJugadores(String nickName, int jugador, String personaje) {
		Jugador aux = buscarJugador(nickName, raiz);
		if (aux == null) {
			aux = new Jugador(nickName,personaje);
			agregarJugador(aux);
		}
		if(jugador == 1){
			jugador1 = aux;
		}else if(jugador == 2){
			jugador2 = aux;
		}
	}
	
	
	
	public String[] darFondos() {
		return fondos;
	}
	

}
