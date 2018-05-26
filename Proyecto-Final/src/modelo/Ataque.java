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
	
	private int direccion;
	
	private Rectangle kickBox;
	
	
	//--------------------------------------
	// Constructor
	//--------------------------------------
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
	
	public Rectangle darKickBox() {
		return kickBox;
	}
	

}
