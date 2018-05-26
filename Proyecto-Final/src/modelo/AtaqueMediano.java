package modelo;

public class AtaqueMediano extends AtaqueDistancia {

	public AtaqueMediano(int poder, int direccion, int posX, int posY) {
		super(poder - 50, direccion, posX, posY);
//		cambiarPoder(poder-100);
	}
	
	public void moverX() {
		posX += (super.darDireccion()  == 1) ? 20 * ((double)darDanho()/30): -20 * ((double)darDanho()/30);
		setKickBoxLocation(super.darPosX(), super.darPosY());
		this.setPoder(this.darPoder()-1);
	}
}
