/*
 * Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package modelo;

import java.util.Comparator;

public class Juego implements Comparator<Jugador>{

	//--------------------------------------
	// Relaciones
	//--------------------------------------
	
	/*
	 * Top 10
	 */
	private Jugador[] topTen;

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
	
	private String fondoActual;
	
	/*
	 * Informacion
	 * [0] ----> Bardock
	 * [1] ----> Beerus
	 * [2] ----> Broly 
	 * [3] ----> Frieza
	 * [4] ----> GohanSSJ_Kid
	 * [5] ----> Goku
	 * [6] ----> 18
	 * [7] ----> Goku_Red
	 * [8] ----> Kid_Buu 
	 * [9] ----> Vegeta  
	 *
	 *
	 * Arreglo de personajes
	 */
	public static final String[] personajes = {"Bardock","Beerus","Broly","Frieza","GohanSSJ_Kid","Goku","18","Goku_Red","Kid_Buu","Vegeta"};



	//--------------------------------------
	// Constructor
	//--------------------------------------

	/*
	 * Construlle un objeto de tipo Juego
	 */
	public Juego() {
		/*
		 * Crear Top ten por defecto :v
		 */
		topTen = new Jugador[10];
		topTen[0] = new Jugador("Carlos-Sama");
		topTen[0].AñadirPuntos(100);
		topTen[1] = new Jugador("Paola-chan");
		topTen[1].AñadirPuntos(99);
		topTen[2] = new Jugador("Chasquido-Sun");
		topTen[2].AñadirPuntos(98);
		topTen[3] = new Jugador("Victor-Dono");
		topTen[3].AñadirPuntos(97);
		topTen[4] = new Jugador("Kyven-San");
		topTen[4].AñadirPuntos(96);
		topTen[5] = new Jugador("Barrios-kun");
		topTen[5].AñadirPuntos(95);
		topTen[6] = new Jugador("Eclipse-Sama");
		topTen[6].AñadirPuntos(94);
		topTen[7] = new Jugador("Deitel-tan");
		topTen[7].AñadirPuntos(93);
		topTen[8] = new Jugador("Cristovick is fake");
		topTen[8].AñadirPuntos(92);
		topTen[9] = new Jugador("the play boy :v");
		topTen[9].AñadirPuntos(91);
		
	}
	
	//--------------------------------------
	// Metodos
	//--------------------------------------
	
	public void iniciarBatalla(int numFondo) throws JugadorNoSeleccionadoException {
		//**************************************
		// Comprobar la existencia de Jugadores
		//**************************************
		if (jugador1 == null) {
			throw new JugadorNoSeleccionadoException("No ha selecionado al jugador 1");
		}else if(jugador2 == null) {
			throw new JugadorNoSeleccionadoException("No ha selecionado al jugador 2");
		}
		
		// Inicializa la Batalla
		battle = new Batalla(jugador1,jugador2, numFondo);
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
	
	public boolean inTopTen(Jugador j) {
		int inicio = 0;
		int fin = topTen.length;
		boolean encontrado = false;
		while (inicio < fin && !encontrado) {
			
			int medio = (inicio + fin)/2;
			
			if (j.compareTo(topTen[medio]) == 0) {
				encontrado = true;
			}else if(j.compareTo(topTen[medio]) < 0) {
				fin = medio - 1;
			}else {
				inicio = medio + 1;
			}
			
		}
		
		return encontrado;
	}
	
	public void darPuntos(int ganador) {
		
		if (ganador == 1) {
			jugador1.AñadirPuntos(
					(500 - jugador2.darSaludActual()) // La diferencia entre la salud maxima y la final
					/5);// Todo esto sobre 5
			ordenarTopTenPorNombre();
			if (!inTopTen(jugador1)) {
				topTen[9] = compare(jugador1, topTen[9]) > 0? jugador1 : topTen[9];
			}
			ordenarTopTenPorPuntos();
		}
		if (ganador == 2) {
			jugador2.AñadirPuntos(
					(500 - jugador1.darSaludActual())
					/5);
			ordenarTopTenPorNombre();
			if (!inTopTen(jugador2)) {
				topTen[9] = compare(jugador2, topTen[9]) > 0? jugador2 : topTen[9];
			}
			ordenarTopTenPorPuntos();
		}
	}
	
	public void ordenarTopTenPorPuntos() {
		for (int i = 0; i < topTen.length - 1; i++) {
			for (int j = 0; j < topTen.length - i - 1; j++) {
				if (compare(topTen[j], topTen[j+1]) > 0) {
					Jugador temp = topTen[j];
					topTen[j] = topTen[j+1];
					topTen[j+1] = temp;
				}
			}
		}
	}
	
	public void ordenarTopTenPorNombre() {
		for (int i = 0; i < topTen.length - 1; i++) {
			
			Jugador menor = topTen[i];
			int indiceMenor = i;
			
			for (int j = i+1; j < topTen.length; j++) {
				if (topTen[j].compareTo(menor)<0) {
					menor = topTen[j];
					indiceMenor = j;
				}
			}
			topTen[indiceMenor] = topTen[i];
			topTen[i] = menor;
			
		}
	}
	
	public Jugador[] darJugadoresEnBatalla() {
		Jugador[] j = {battle.darJugador1(),battle.darJugador2()};
		return j;
	}
	
	public String darFondoActual() {
		return fondoActual;
	}
	
	public void agregarJugador(Jugador jugador) {
		if (raiz == null) {
			raiz = jugador;
		}else {
			agregarJugador(jugador, raiz);
		}
	}
	
	public void agregarJugador(Jugador jugador, Jugador nodo) {
		if (nodo.compareTo(jugador) < 0) {
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
	
	public void agregarJugadores(String nickName, int jugador) {
		Jugador aux = buscarJugador(nickName, raiz);
		if (aux == null) {
			aux = new Jugador(nickName);
			agregarJugador(aux);
		}
		if(jugador == 1){
			jugador1 = aux;
		}else if(jugador == 2){
			jugador2 = aux;
		}
	}
	
	
	public String[] daPersonajes() {
		return personajes;
	}
	
	public Batalla darBatalla() {
		return battle;
	}

	@Override
	public int compare(Jugador o1, Jugador o2) {
		return o1.darPuntos()-o2.darPuntos();
	}
	

}
