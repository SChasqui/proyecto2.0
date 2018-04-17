package modelo;

import java.util.ArrayList;

public class Personaje {


	
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

	
	//--------------------------------------
	// Constructor
	//--------------------------------------
	public Personaje(String[] pSprite, int precio) {

		/*
		 * se inicializa el arreglo de imagenes de las posibles pociciones del personaje
		 */
		sprites = pSprite;

		/*
		 * se fija el precio que tendra el personaje
		 */
		this.precio = precio;

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
	
	/*
	 * M�todo que informa si el ataque que recibe como par�metro lo afect�
	 * @param x - La posici�n en el eje X del ataque
	 * @param y - La posici�n en el eje Y del ataque
	 */
	public boolean fueGolpeado(int x, int y) {

		return posX< x && x < posX+30 && posY< x && x < posY+50;
	}
	
	/*
	 * 
	 */
//	public int[] atacar(Ataque tipoAtaque) {
//		int alcanceX = posX + tipoAtaque.darAlcanceX();
//		int alcanceY = posY;
//		
//	}

}
