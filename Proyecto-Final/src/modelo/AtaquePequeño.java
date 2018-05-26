package modelo;

public class AtaquePequeño extends AtaqueDistancia {

	public AtaquePequeño(int poder, int direccion, int posX, int posY) {
		super(poder - 100, direccion, posX-(30 * direccion), posY);
//		System.out.println("poder 1 " + super.darPoder());
//		super.cambiarPoder(darPoder()-150);
//		System.out.println("poder des "+ super.darPoder());
//		// TODO Auto-generated constructor stub
	}

	public String darSprite() {
		return "data/Sprites/"  + "AtaquePequeño/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}
	
	public void moverX() {
		posX += (super.darDireccion()  == 1) ? 20 * ((double)darDanho()/20): -20 * ((double)darDanho()/20);
		setKickBoxLocation(super.darPosX(), super.darPosY());
		this.setPoder(this.darPoder()-1);
	}
}
