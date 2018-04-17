package modelo;

public class AtaqueDistancia extends Ataque{
	
	/*
	 * Es la posicion en la que va el ataque en el eje X
	 */
	private int posX;
	
	/*
	 * Es la posicion en la que va el ataque en el eje Y
	 */
	private int posY;
	
	/*
	 * Hace referencia al "ancho" del ataque
	 */
	private int ancho;
	
	public AtaqueDistancia ( ) {
		
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

	public int darAncho() {
		return ancho;
	}

	public void cambiarAncho(int ancho) {
		this.ancho = ancho;
	}
	
	
}	
