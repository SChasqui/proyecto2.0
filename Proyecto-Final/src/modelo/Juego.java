/*
 * Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package modelo;

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
	
	private String fondoActual;
	
	/*
	 * Informacion
	 * [0] ----> Bardock
	 * [1] ----> Beerus
	 * [2] ----> Broly 
	 * [3] ----> Frieza
	 * [4] ----> GohanSSJ_Kid
	 * [5] ----> Goku
	 * [6] ----> Goku_Blue
	 * [7] ----> Goku_Red
	 * [8] ----> Kid_Buu 
	 * [9] ----> Vegeta  
	 *
	 *
	 * Arreglo de personajes
	 */
	private String[] personajes = {"Bardock","Beerus","Broly","Frieza","GohanSSJ_Kid","Goku","Goku_Blue","Goku_Red","Vegeta"};



	//--------------------------------------
	// Constructor
	//--------------------------------------

	/*
	 * Construlle un objeto de tipo Juego
	 */
	public Juego() {
//		fondoActual = fondos[0];
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
	
	public String darJugadorActual() {
		return darJugadorActual();
	}
	
	public void cambiarFondoActual(int nFondo) {
		fondoActual = fondos[nFondo+1];
	}
//	public void avanzarFondoActual() {
//		int index = -1;
//		for (int i = 0; i < fondos.length; i++) {
//			if(fondos[i].equals(fondoActual)) index =i;
//		}
//		
//		if(index+1 <fondos.length)
//		fondoActual = fondos[index+1];
//		else index = 0;
//		
//	}
	
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
	
	public void agregarJugadores(String nickName, int jugador, String personaje, int num) {
		Jugador aux = buscarJugador(nickName, raiz);
		if (aux == null) {
			aux = new Jugador(nickName,personaje, num);
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
	
	public String[] daPersonajes() {
		return personajes;
	}
	

}
