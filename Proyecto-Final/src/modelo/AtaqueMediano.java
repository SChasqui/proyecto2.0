package modelo;

public class AtaqueMediano extends AtaqueDistancia {

	public AtaqueMediano(int poder, int direccion, int posX, int posY) {
		super(poder, direccion, posX, posY);
		cambiarPoder(poder+10);
	}
}
