package hilos;

import interfaz.PanelPruebas;
import modelo.Jugador;

public class HiloAnimaciones extends Thread {
	
	private Jugador jugador;
	private PanelPruebas panel;
	private int personaje;
	
	
	public HiloAnimaciones(Jugador j, PanelPruebas p, int personaje) {

		jugador = j;
		panel = p;
		this.personaje = personaje;
	}
	
	@Override
	public void run() {

		while (true) {

				jugador.darPersonaje().actualizar();
				if (!panel.modificando()) {
					if (personaje == 1) {
						panel.moverPersonaje1();
					}else {
						panel.moverPersonaje2();
					}
				}
				if ((jugador.darKiActual() / 500) * jugador.darKiMaximo() != jugador.darKiMaximo()) {
					jugador.darPersonaje().recuperarKi();
				}
			
			
			try {
				sleep(83);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}

}
