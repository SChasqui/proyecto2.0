package modelo;

import java.awt.Rectangle;
import java.io.Serializable;

public abstract class Ataque implements Serializable{
	
	//--------------------------------------
	// Atributos
	//--------------------------------------
	
	
	/*
	 * Es la posición en la que se encuentra el ataque
	 */
	protected int posX;
	
	/*
	 * Es la posición en la que se encuentra el ataque
	 */
	private int posY;
	
	/*
	 * Es el alcance en el eje X del ataque
	 */
	private int alcanceX;
	
	/*
	 * Es el alcance en el eje Y del ataque
	 */
	private int alcanceY;
	
	/*
	 * Corresponde al danho que el ataque causa al adversario
	 */
	private int danho;
	
	/*
	 * Corresponde a la dirección del ataque
	 */
	private int direccion;
	
	/*
	 * Es el rectangulo que define el espacio que ocupa el ataque
	 */
	private Rectangle kickBox;
	
	
	//--------------------------------------
	// Constructor
	//--------------------------------------
	
    /**
     * Crea el ataque abstracto<br>
     * @param poder El poder del pj
     * @param pDireccion la direccion hacia donde se dirige el ataque. -1 izquierda, 1 derecha
     * @param pX la coordenadas en X del ataque
     * @param pY la coordenadas en Y del ataque
     */
	public Ataque(int poder, int pDireccion, int pX, int pY) {
		
		direccion = pDireccion;
		posX = pX;
		posY = pY;
		danho = poder;

	}

	public int darAlcanceX() {
		return alcanceX;
	}

	public void cambiarAlcanceX(int alcanceX) {
		this.alcanceX = alcanceX;
	}

	public int darAlcanceY() {
		return alcanceY;
	}

	public void cambiarAlcanceY(int alcanceY) {
		this.alcanceY = alcanceY;
	}
	
	public int darDanho() {
		return danho;
	}
	
	public int darPosX() {
		return posX;
	}

	public void cambiarPosX(int posX) {
		this.posX = posX;
	}

	public int darPosY() {
		return posY;
	}

	public void cambiarPosY(int posY) {
		this.posY = posY;
	}
	
	public int darDireccion() {
		return direccion;
	}
	
	public abstract void moverX();
	
	public abstract String darSprite();
	
	public Rectangle darKickBox() {
		return kickBox;
	}
	

}
