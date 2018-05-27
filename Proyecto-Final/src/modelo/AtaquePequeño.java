package modelo;

public class AtaquePequeño extends AtaqueDistancia {
	
    /**
     * Crea un ataque distante<br>
     * @param poder El poder del pj
     * @param direccion la direccion hacia donde se dirige el ataque. -1 izquierda, 1 derecha
     * @param posX la coordenada en X del ataque
     * @param posY la coordenada en Y del ataque
     */
	public AtaquePequeño(int poder, int direccion, int posX, int posY) {
		super(poder - 100, direccion, posX-(30 * direccion), posY);
//		System.out.println("poder 1 " + super.darPoder());
//		super.cambiarPoder(darPoder()-150);
//		System.out.println("poder des "+ super.darPoder());
//		// TODO Auto-generated constructor stub
	}
	
    /*
     * Devuelve la ruta del ataque <br>
     */
	@Override
	public String darSprite() {
		return "data/Sprites/"  + "AtaquePequeño/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}
	
    /*
     * Desplaza el ataque en el eje X, mermándole poder a medida que avanza <br>
     * <b>pre:</b> la kickBox del ataque ha sido inicializada
     * <b>post:</b> La posición en X ha cambiado
     */
	@Override
	public void moverX() {
		posX += (super.darDireccion()  == 1) ? 20 * ((double)darDanho()/20): -20 * ((double)darDanho()/20);
		setKickBoxLocation(super.darPosX(), super.darPosY());
		this.setPoder(this.darPoder()-1);
	}
}
