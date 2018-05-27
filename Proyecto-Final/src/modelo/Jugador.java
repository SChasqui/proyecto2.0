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
	
    /**
     * Selecciona un personaje. Si el jugador se est� iniciandp, se le regala su primer PJ, <br>
     * de lo contrario lo busca en su �rbol de personajes desbloqueados <br>
     * <b>pre:</b> El �rbol de personajes desbloqueados ha sido inicializado <br>
     * <b>post:</b> se seleccion� un personaje, asign�ndolo a la variable personajeActual <br>
     * @param personaje - El nombre del personaje que el usuario pretende seleccionar.
     * @param indice - El indice de la posici�n del arreglo de personajes.
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
	
    /**
     * Busca un personaje por medio del nombre del pj <br>
     * Para ello usa la recursi�n: si el personaje tiene el mismo nombre, lo retorna; <br>
     * de lo contrario se llama a s� mismo (el m�todo) dependiendo de la comparaci�n lexicogr�fica <br>
     * <b>pre:</b> el �rbol de personajes ha sido inicializado
     * @param name - El nombre que se va buscar en la lista.
     * @param actual - El personaje actual de la recursi�n.
     * @return el personaje encontrado. Si no lo encuentra retorna null
     */
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
	
    /**
     * Desbloquea un personaje de la lista de precios de Personaje, agregandolo al �rbol de personajes desbloqueados <br>
     * Para a�adirlo hace uso del m�otodo a�adirADesbloqueados. <br>
     * <b>pre:</b> la lista de personajes y la de desbloqueados han sido incializadas <br>
     * <b>pre:</b> El arreglo de precios de la clase personaje ha sido inicializado <br>
     * @param indice - El indice en el arreglo de precios del personaje
     * @param personaje - el nombre del personaje.
     */
	public void desbloquearPersonaje(int indice, String personaje) throws PuntosInsuficientesException {
		
		if (Personaje.precios[indice] < puntos) {
			puntos -= Personaje.precios[indice];
			a�adirADesbloqueados(desBloqueados, new Personaje(personaje, Personaje.precios[indice], indice));
		}else {
			throw new PuntosInsuficientesException("");
		}
	}
	
    /**
     * Busca un espacio al final del �rbol de personajesDesbloqueados para agregar el nuevo personaje. <br>
     * El criterio de ordenamiento es el �rbol.
     * <b>pre:</b> El �rbol de personajes ha sido inicializado <br>
     * <b>post:</b> Se ha a�adido un nuevo personaje al �rbol de personajes desbloqueados
     * @param nodo - El nodo en el que se intenta poner en alguno de sus hijos el nuevo personaje.
     * @param agregable - El nuevo personaje a agregar.
     */
	public void a�adirADesbloqueados(Personaje nodo, Personaje agregable) {
		if (nodo.compareTo(agregable) > 0) {
			if (nodo.getIzquierda() == null) {
				nodo.setIzquierda(agregable);
			}else {
				a�adirADesbloqueados(nodo.getIzquierda(), agregable);
			}
		}else {
			if (nodo.getDerecha() == null) {
				nodo.setDerecha(agregable);
			}else {
				a�adirADesbloqueados(nodo.getDerecha(), agregable);
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
	
    /**
     * Retorna la salud m�xima del personaje. <br>
     * Se calcula por medio de la Matriz de multiplicadores de personaje.
     */
	public int darSaludMaxima() {
		return (int) (Personaje.VIDA_BASE*Personaje.MATRIZ_DE_MULTIPLICADORES[personajeActual.darIndicePersonaje()][0]);
	}
	
    /**
     * Retorna la salud actual del personaje. <br>
     */
	public int darSaludActual() {
		return (int) (((double)personajeActual.darSalud() / (double)darSaludMaxima()) * 500);
	}
	
    /**
     * Retorna el ki m�ximo del personaje. <br>
     * Se calcula por medio del ki base y la Matriz de multiplicadores de personaje.
     */
	public int darKiMaximo() {
		return (int) (Personaje.KI_BASE*Personaje.MATRIZ_DE_MULTIPLICADORES[personajeActual.darIndicePersonaje()][1]);
	}
	
    /**
     * Retorna la el ki actual del personaje. <br>
     */
	public int darKiActual() {
		return (int) ((double)((double)personajeActual.darKI() / (double)darKiMaximo()) * 500);
	}

	public void A�adirPuntos(int puntos) {
		this.puntos += puntos;
	}

	public int darPuntos() {
		return puntos;
	}
	
    /**
     * Cambia el criterio de comparaci�n para los objetos de esta clase. <br>
     */
	@Override
	public int compareTo(Jugador o) {
		return nickName.compareTo(o.darNickName());
	}

}
