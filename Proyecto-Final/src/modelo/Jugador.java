/*
 * Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package modelo;

import java.io.Serializable;


public class Jugador implements Comparable<Jugador>, Serializable{

	//--------------------------------------
	// Atributos
	//--------------------------------------

	/*
	 * Nickname del Jugador
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
	private Personaje desBloqueados;

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
    /**
     * Crea un jugador<br>
     * @param nombre El nombre del jugador
     */
	public Jugador(String nombre) {
		nickName = nombre;
		puntos = 0;

	}

	//--------------------------------------
	// Metodos
	//--------------------------------------
	
    /*
     * Selecciona un personaje <br>
     * <b>pre:</b> la lista de 
     * @param i - El índice que indica la posición del acción (sprite) en la que va
     * @param direccion - 1: DERECHA; -1 IZQUIERDA.
     * @return la imagen de la matriz en la fila MOVERCE, con columna indice en la dirección direccion.
     */
	public void seleccionarPersonaje(String personaje, int indice) throws NoDesbloqueadoException {
		if (desBloqueados == null) {
			desBloqueados = new Personaje(personaje, Personaje.precios[indice], indice);
		}
		Personaje temp = buscarPorPersonaje(personaje, desBloqueados);
		if (temp != null) {
			personajeActual = temp;
		}else {
			throw new NoDesbloqueadoException("El personaje no ha sido Desbloqueado", personaje);
		}

	}

	public Personaje buscarPorPersonaje(String name, Personaje actual) {
		
		if(actual == null) {
			return null;

		}else if(actual.darNombre().equals(name)) {
			return actual;

		}else if(actual.darNombre().compareTo(name) < 0){
			return actual.getDerecha() == null ? null : buscarPorPersonaje(name,actual.getDerecha());

		}else{
			return actual.getIzquierda() == null? null : buscarPorPersonaje(name,actual.getIzquierda());
		}
	}

	public void desbloquearPersonaje(int indice, String personaje) throws PuntosInsuficientesException {
		
		if (Personaje.precios[indice] < puntos) {
			puntos -= Personaje.precios[indice];
			añadirADesbloqueados(desBloqueados, new Personaje(personaje, Personaje.precios[indice], indice));
		}else {
			throw new PuntosInsuficientesException("");
		}
	}
	
	public void añadirADesbloqueados(Personaje nodo, Personaje agregable) {
		if (nodo.compareTo(agregable) > 0) {
			if (nodo.getIzquierda() == null) {
				nodo.setIzquierda(agregable);
			}else {
				añadirADesbloqueados(nodo.getIzquierda(), agregable);
			}
		}else {
			if (nodo.getDerecha() == null) {
				nodo.setDerecha(agregable);
			}else {
				añadirADesbloqueados(nodo.getDerecha(), agregable);
			}
		}
	}

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

	public int darSaludMaxima() {
		return (int) (Personaje.VIDA_BASE*Personaje.MATRIZ_DE_MULTIPLICADORES[personajeActual.darIndicePersonaje()][0]);
	}

	public int darSaludActual() {
		return (int) (((double)personajeActual.darSalud() / (double)darSaludMaxima()) * 500);
	}

	public int darKiMaximo() {
		return (int) (Personaje.KI_BASE*Personaje.MATRIZ_DE_MULTIPLICADORES[personajeActual.darIndicePersonaje()][1]);
	}

	public int darKiActual() {
		return (int) ((double)((double)personajeActual.darKI() / (double)darKiMaximo()) * 500);
	}

	public void AñadirPuntos(int puntos) {
		this.puntos += puntos;
	}

	public int darPuntos() {
		return puntos;
	}

	@Override
	public int compareTo(Jugador o) {
		return nickName.compareTo(o.darNickName());
	}

}
