package modelo;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class AtaqueDistancia extends Ataque implements Destruible{
	
	/*
	 *	INFORMACIÓN:
	 *	
	 *
	 */
//
	
	/*
	 * Hace referencia al "ancho" del ataque
	 */
	private int ancho;
	
	int i = 1;
	
	/*
	 * Vida del ataque
	 */
	private int vida;
	
	/*
	 * siguiente ataque en la lista
	 */
	private AtaqueDistancia siguiente;
	
	private Rectangle kickBox;
	
	public AtaqueDistancia (int poder,  int direccion, int posX, int posY) {
		super(poder, direccion, posX, posY);
		vida = 50;
		ImageIcon img = new ImageIcon(this.darSprite());
		kickBox = new Rectangle(posX, posY, img.getIconWidth(), img.getIconHeight() );
	}
	
	public AtaqueDistancia darSiguiente() {
		return siguiente;
	}
	
	public void seleccionarSiguiente(AtaqueDistancia s) {
		siguiente = s;
	}

	public int darAncho() {
		return ancho;
	}

	public void cambiarAncho(int ancho) {
		this.ancho = ancho;
	}
	
	public void moverX() {
		posX += (super.darDireccion()  == 1) ? 20 * ((double)darDanho()/80): -20 * ((double)darDanho()/80);
		kickBox.setLocation(super.darPosX(), super.darPosY());
		vida--;
	}
	
	public int darVida() {
		return vida;
	}
	
	public void vidaACero() {
		vida = 1;
	}
	
	public String darSprite() {
		return "data/Sprites/"  + "AtaqueMed/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}
	
	public boolean comprobarAtaque(Rectangle rect) {
		
		return kickBox.intersects(rect);
	}
	
	@Override
	public Rectangle darKickBox() {
		return kickBox;
	}
	
}	
