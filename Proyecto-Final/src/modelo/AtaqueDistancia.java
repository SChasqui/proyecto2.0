package modelo;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class AtaqueDistancia extends Ataque implements Destruible{
	
	/*
	 * Hace referencia al "ancho" del ataque
	 */
	private int ancho;
	
	/*
	 * Poder del ataque
	 */
	private int poder;
	
	/*
	 * siguiente ataque en la lista
	 */
	private AtaqueDistancia siguiente;
	
	/*
	 * Es el rectangulo que define el espacio que ocupa el ataque
	 */
	private Rectangle kickBox;
	
	//--------------------------------------
	// Constructor
	//--------------------------------------
	
    /**
     * Crea un ataque distante<br>
     * @param poder El poder del pj
     * @param direccion la direccion hacia donde se dirige el ataque. -1 izquierda, 1 derecha
     * @param posX la coordenada en X del ataque
     * @param posY la coordenada en Y del ataque
     */
	public AtaqueDistancia (int poder,  int direccion, int posX, int posY) {
		super(poder, direccion, posX, posY);
		this.poder = poder*100;
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
	
    /*
     * Desplaza el ataque en el eje X, mermándole poder a medida que avanza <br>
     * <b>pre:</b> la kickBox del ataque ha sido inicializada
     * <b>post:</b> La posición en X ha cambiado
     */
	@Override
	public void moverX() {
		posX += (super.darDireccion()  == 1) ? 20 * ((double)darDanho()/120): -20 * ((double)darDanho()/120);
		kickBox.setLocation(super.darPosX(), super.darPosY());
		poder--;
	}
	
	public int darPoder() {
		return poder;
	}
	
	public void setPoder(int pw) {
		poder = pw;
	}
	
	public void cambiarPoder(int pod) {
		poder = pod;
	}
	
    /*
     * Le resta vida al ataque. Si sobrepasa el mínimo de vida, lo destruye <br>
     * <b>post:</b> El poder del ataque ha cambiado
     */
	public void restarPoder(int cuanto){
		if(poder-cuanto >=1)poder -= cuanto;
		else destruirAtaque();
		
	}
	
    /*
     * Destruye el ataque poniendo el poder en 1 <br>
     * <b>post:</b> El ataque se ha destruido
     */
	public void destruirAtaque(){
		poder = 1;
	}
	
    /*
     * Devuelve la ruta del ataque <br>
     */
	public String darSprite() {
		return "data/Sprites/"  + "AtaqueMed/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}
	
	public boolean comprobarAtaque(Rectangle rect) {
		
		return rect!=null?kickBox.intersects(rect):false;
	}
	
	@Override
	public Rectangle darKickBox() {
		return kickBox;
	}
	
	public void setKickBoxLocation(int x, int y) {
		kickBox.setLocation(x, y);
	}
	
}	
