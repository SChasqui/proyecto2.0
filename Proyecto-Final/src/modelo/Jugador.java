/*
 * Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package modelo;

public class Jugador implements Comparable<Jugador>{

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
	public Jugador(String nombre) {
		nickName = nombre;
		puntos = 0;

	}

	//--------------------------------------
	// Metodos
	//--------------------------------------

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

	public void desbloquearPersonaje(int indice, String personaje) {
		
		if (Personaje.precios[indice] < puntos) {
			
		}
	}
	
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

	public void A�adirPuntos(int puntos) {
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
