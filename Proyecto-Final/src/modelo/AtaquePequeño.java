package modelo;

public class AtaquePequeño extends AtaqueDistancia {

	public AtaquePequeño(int poder, int direccion, int posX, int posY) {
		super(poder, direccion, posX-(30 * direccion), posY);
		cambiarPoder(poder+5);
		// TODO Auto-generated constructor stub
	}

	public String darSprite() {
		return "data/Sprites/"  + "AtaquePequeño/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}
}
