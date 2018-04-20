package modelo;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Personaje {


	//--------------------------------------
	// Constantes
	//--------------------------------------

	public static final int IZQUIERDA = -1;

	public static final int DERECHA = 1;

	//--------------------------------------
	// Atributos
	//--------------------------------------

	/*
	 * arreglo de las imagenes que puede tener un personaje
	 */
	private String[] sprites;

	/*
	 * precio en puntos de un personaje
	 */
	private int precio;

	/*
	 * posicion en el componente X del personaje
	 */
	private int posX;

	/*
	 * posicion en el componente Y del personaje
	 */
	private int posY;

	/*
	 * Es el ki del personaje
	 */
	private int ki;

	/*
	 * Es la salud del personaje
	 */
	private int salud;

	/*
	 * Lista de ataque es de un personaje
	 */
	private ArrayList<Ataque> ataques;

	/*
	 * Es un rectangulo que representa el área donde se encuentra el personaje
	 */
	private Rectangle rectangulo;

	/*
	 * Adversario del personaje 
	 */
	private Personaje adversario;

	/*
	 * Ancho del sprite del personaje 
	 */
	private int tamanhoX;

	/*
	 * Alto del sprite del personaje 
	 */
	private int tamanhoY;

	/*
	 * Denota la direccion en la que se esta desplazando el personaje
	 */
	private int direccion;


	int i = 1;

	//--------------------------------------
	// Constructor
	//--------------------------------------
	public Personaje(String[] pSprite, int precio) {

		/*
		 * se inicializa el arreglo de imagenes de las posibles posiciones del personaje
		 */
		sprites = pSprite;

		/*
		 * se fija el precio que tendra el personaje
		 */
		this.precio = precio;

		rectangulo = new Rectangle (posX, posY, tamanhoX, tamanhoY);
	}

	//--------------------------------------
	// Metodos
	//--------------------------------------
	public int darPrecio() {
		return precio;
	}

	public int darPosY() {
		return posY;
	}

	public int darPosX() {
		return posX;
	}

	public void cambiarPosX(int newPosX) {
		posX = newPosX;
	}
	public void cambiarPosY(int newPosY) {
		posX = newPosY;
	}

	private Rectangle darRectangulo() {
		return rectangulo;
	}

	/*
	 * Método que informa si el ataque que recibe como parámetro lo afectó
	 * @param x - La posición en el eje X del ataque
	 * @param y - La posición en el eje Y del ataque
	 */
	public boolean fueGolpeado(int x, int y) {

		return posX< x && x < posX+30 && posY< y && y < posY+50;
	}


	/*
	 * Método encargado de atacar
	 * @param tecla - Corresponde a la representación Unicode de la tecla pulsada
	 */
	public int atacar(int tecla) {

		int efectoAtaque = 0;

		if(this.rectangulo.intersects(adversario.darRectangulo())) {
			Ataque temp = new Ataque (tecla);
			efectoAtaque = temp.darDanho();
		}

		return efectoAtaque;
	}

	public void moverX(int mover) {
		posX+=mover;
		direccion = mover>0? DERECHA:IZQUIERDA;
	}

	public void moverY(int mover) {
		posY+=mover;
	}

	public String darSprite() {
		if(i == -1) {
			i = 1;
		}
		else if(i < 4) {
			i++;
		}else {
			i = -4;
		}

		return "data/Sprites/Bardock/"+ (direccion == IZQUIERDA? "paradoIzquierda": "paradoDerecha") +"/"+(i > 0? i : -i)+ ".png";
	}


}
