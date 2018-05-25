package modelo;

public class AtaqueGrande extends AtaqueDistancia {

	public AtaqueGrande(int poder, int direccion, int posX, int posY) {
		super(poder, direccion, posX, posY);
//		cambiarPoder(poder);
		// TODO Auto-generated constructor stub
	}
	
	public String darSprite() {
		return "data/Sprites/"  + "AtaqueGrande/"+ (darDireccion() == Personaje.IZQUIERDA? "Izquierda": "Derecha") +".png";
	}

}
