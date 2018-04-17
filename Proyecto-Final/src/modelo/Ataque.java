package modelo;

public class Ataque {
	
	//--------------------------------------
	// Atributos
	//--------------------------------------
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
	 * Tipo del ataque
	 */
	private String tipoAtaque;
	
	
	//--------------------------------------
	// Constructor
	//--------------------------------------
	public Ataque() {
		
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
}
