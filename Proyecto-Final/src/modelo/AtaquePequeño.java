package modelo;

public class AtaquePequeño extends AtaqueDistancia {

	public AtaquePequeño(int poder, int direccion, int posX, int posY) {
		super(poder, direccion, posX-(30 * direccion), posY);
		System.out.println("poder 1" +poder);
		this.cambiarPoder(super.darPoder()-75);
		System.out.println("poder des "+poder);
		// TODO Auto-generated constructor stub
	}

	public String darSprite() {
		return "data/Sprites/"  + "AtaquePequeño/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}
}
