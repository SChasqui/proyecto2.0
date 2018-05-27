package modelo;

public class AtaqueGrande extends AtaqueDistancia {
	
	
    /**
     * Crea un ataque distante grande<br>
     * @param poder El poder del pj
     * @param direccion la direccion hacia donde se dirige el ataque. -1 izquierda, 1 derecha
     * @param posX la coordenada en X del ataque
     * @param posY la coordenada en Y del ataque
     */
	public AtaqueGrande(int poder, int direccion, int posX, int posY) {
		super(poder, direccion, posX, posY);
	}
	
    /*
     * Devuelve la ruta del ataque <br>
     */
	@Override
	public String darSprite() {
		return "data/Sprites/"  + "AtaqueGrande/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}
	
    /*
     * Desplaza el ataque en el eje X, mermándole poder a medida que avanza <br>
     * <b>pre:</b> la kickBox del ataque ha sido inicializada
     * <b>post:</b> La posición en X ha cambiado
     */
	@Override
	public void moverX() {
		posX += (super.darDireccion()  == 1) ? 20 * ((double)darDanho()/50): -20 * ((double)darDanho()/50);
		setKickBoxLocation(super.darPosX(), super.darPosY());
		this.setPoder(this.darPoder()-1);
	}

}
