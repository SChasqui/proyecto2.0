package modelo;

public class AtaquePeque�o extends AtaqueDistancia {

	public AtaquePeque�o(int poder, int direccion, int posX, int posY) {
		super(poder, direccion, posX-(30 * direccion), posY);
		cambiarPoder(poder+5);
		// TODO Auto-generated constructor stub
	}

	public String darSprite() {
		return "data/Sprites/"  + "AtaquePeque�o/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}
}
