package modelo;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class AtaqueDistancia extends Ataque{
	

	
	/*
	 * Hace referencia al "ancho" del ataque
	 */
	private int ancho;
	
	int i = 1;
	
	/*
	 * Vida del ataque
	 */
	private int vida = 50;
	
	/*
	 * siguiente ataque en la lista
	 */
	private AtaqueDistancia siguiente;
	
	private Rectangle kickBox;
	
	public AtaqueDistancia (String personaje, int tipoAtaque,  int direccion, int posX, int posY) {
		super(personaje, tipoAtaque, direccion, posX, posY);
		
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
		posX += (super.darDireccion()  == 1) ? 20: -20;
		kickBox.setLocation(super.darPosX(), super.darPosY());
//		System.out.println("Pos X: " +super.darPosX() + " - PosY: " + super.darPosY());
		vida--;
	}
	
	public int darVida() {
		return vida;
	}
	
	public String darSprite() {
		i=4;
//		if(i!= 4 && i!=-4) {
//			
//			if(i == -1) {
//				i = 1;
//			}
//			else if(i < 4) {
//				i++;
//			}else {
//				i = -4;
//			}
//		}
		
		return "data/Sprites/" + super.darPersonaje() + "/"+ (darDireccion() == Personaje.IZQUIERDA? "ataqueMedianoIzquierda": "ataqueMedianoDerecha") +"/"+(i > 0? i : -i)+".png";
	}
	
	@Override
	public Rectangle darKickBox() {
//		System.out.println("Pos X: " +super.darPosX() + " - PosY: " + super.darPosY() + " Ancho imagen: " + Math.abs(super.anchoSprite) +  " Alto Sprite: " + Math.abs(super.altoSprite) );
		return kickBox;
	}
	
}	
