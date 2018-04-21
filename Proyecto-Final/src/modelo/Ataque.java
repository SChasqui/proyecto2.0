package modelo;

public class Ataque {
	
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
	 * Tipo del ataque
	 */
	private String tipoAtaque;
	
	private int direccion;
	
	private String personaje;
	
	
	//--------------------------------------
	// Constructor
	//--------------------------------------
	public Ataque(String pj, int pAtaque, int pDireccion, int pX, int pY) {
		personaje = pj;
		direccion = pDireccion;
		posX = pX;
		posY = pY;
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
	
	public int darPosx() {
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
	
	public String darPersonaje() {
		return personaje;
	}
	
	public int darDireccion() {
		return direccion;
	}
	

}
