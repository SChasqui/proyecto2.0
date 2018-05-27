package modelo;

public class AtaqueMediano extends AtaqueDistancia {
	
    /**
     * Crea un ataque distante<br>
     * @param poder El poder del pj
     * @param direccion la direccion hacia donde se dirige el ataque. -1 izquierda, 1 derecha
     * @param posX la coordenada en X del ataque
     * @param posY la coordenada en Y del ataque
     */
	public AtaqueMediano(int poder, int direccion, int posX, int posY) {
		super(poder - 50, direccion, posX, posY);
	}
	
    /*
     * Desplaza el ataque en el eje X, mermándole poder a medida que avanza <br>
     * <b>pre:</b> la kickBox del ataque ha sido inicializada
     * <b>post:</b> La posición en X ha cambiado
     */
	@Override
	public void moverX() {
		posX += (super.darDireccion()  == 1) ? 20 * ((double)darDanho()/30): -20 * ((double)darDanho()/30);
		setKickBoxLocation(super.darPosX(), super.darPosY());
		this.setPoder(this.darPoder()-1);
	}
}
