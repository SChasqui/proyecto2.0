/*
 * Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
	
	public static final String RUTA_TOP_TEN = "Saved/Top10.pro";
	public static final String RUTA_JUGADORES_REGISTRADOS = "Saved/Jugadores";
	
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
//		guardarTopTen();
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
					/2);// Todo esto sobre 5
			ordenarTopTenPorNombre();
			if (!inTopTen(jugador1)) {
				ordenarTopTenPorPuntos();
				topTen[9] = compare(jugador1, topTen[9]) > 0? jugador1 : topTen[9];
//				guardarTopTen();
			}
		}
		if (ganador == 2) {
			jugador2.AñadirPuntos(
					(500 - jugador1.darSaludActual())
					/2);
			ordenarTopTenPorNombre();
			if (!inTopTen(jugador2)) {
				ordenarTopTenPorPuntos();
				topTen[9] = compare(jugador2, topTen[9]) > 0? jugador2 : topTen[9];
//				guardarTopTen();
			}
		}
	}
	
	public void ordenarTopTenPorPuntos() {
		for (int i = 0; i < topTen.length - 1; i++) {
			for (int j = 0; j < topTen.length - i - 1; j++) {
				if (compare(topTen[j], topTen[j+1]) < 0) {
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
	
	public String[] darJugadoresActuales() {
		ArrayList<String> temp = listarJugadores(new ArrayList<String>(), raiz);
		String[] arreglo = new String[temp.size()];
		arreglo = temp.toArray(arreglo);
		arreglo = ordenarLexicograficamente(arreglo);
		return arreglo;
	}
	
	public ArrayList<String> listarJugadores(ArrayList<String> lista, Jugador nodo) {
		lista.add(nodo.darNickName());
		lista = listarJugadores(lista, nodo.darDerecha());
		lista = listarJugadores(lista, nodo.darDerecha());
		return lista;
	}
	
	public String[] ordenarLexicograficamente(String[] arreglo) {
		
		for (int i = 1; i < arreglo.length; i++) {
			for (int j = i; j > 0 && arreglo[j].compareTo(arreglo[j-1]) < 0; j--) {
				String temp = arreglo[j];
				arreglo[j] = arreglo[j-1];
				arreglo[j-1] = temp;
			}
		}
		return arreglo;
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
//		guardarListaDeJugadores();
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
		
		if (nickName == null || nickName.equals("")) {
			nickName = "Jugador idiota";
		}
		
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
	
//	public void guardarListaDeJugadores() {
//		File jugadores = new File(RUTA_JUGADORES_REGISTRADOS);
//		
//		try {
//			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(jugadores));
//			salida.writeObject(raiz);
//			salida.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
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
	
//	public void guardarTopTen() {
//		File TopTenTex = new File(RUTA_TOP_TEN);
//		
//		try {
//			BufferedWriter escritor = new BufferedWriter(new FileWriter(TopTenTex));
//			String top = "";
//			for (int i = 0; i < topTen.length; i++) {
//				top += ((i+1) + ") " + topTen[i].darNickName() + "           " + topTen[i].darPuntos()+"\n");
//			}
//			escritor.write(top);
//			escritor.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	

}
