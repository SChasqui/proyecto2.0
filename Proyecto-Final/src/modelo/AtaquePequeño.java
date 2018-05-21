package modelo;

public class AtaquePequeño extends AtaqueDistancia {

	public AtaquePequeño(int poder, int direccion, int posX, int posY) {
		super(poder, direccion, posX, posY);
		// TODO Auto-generated constructor stub
	}

	public String darSprite() {
		return "data/Sprites/"  + "AtaquePequeño/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}
}
