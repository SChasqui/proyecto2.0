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

	public void desbloquearPersonaje(int indice) {


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
		return (int) (((double)personajeActual.darSalud() / darSaludMaxima()) * 500);
	}

	public int darKiMaximo() {
		return (int) (Personaje.KI_BASE*Personaje.MATRIZ_DE_MULTIPLICADORES[personajeActual.darIndicePersonaje()][1]);
	}

	public int darKiActual() {
		return (int) (((double)personajeActual.darKI() / darKiMaximo()) * 500);
	}

	public void darAñadirPuntos() {
		puntos += 100;
	}

	public int darPuntos() {
		return puntos;
	}

}
