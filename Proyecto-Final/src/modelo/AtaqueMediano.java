package modelo;

public class AtaqueMediano extends AtaqueDistancia {

	public AtaqueMediano(int poder, int direccion, int posX, int posY) {
		super(poder - 50, direccion, posX, posY);
//		cambiarPoder(poder-100);
	}
}
