package hilos;

import interfaz.PanelPruebas;
import modelo.Jugador;

public class HiloAnimaciones extends Thread {
	
	private Jugador jugador;
	private PanelPruebas panel;
	private int personaje;
	int time;
	
	
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
				time++;
				if ((jugador.darKiActual() / 500) * jugador.darKiMaximo() != jugador.darKiMaximo() && time > 13) {
					jugador.darPersonaje().recuperarKi();
					time = 0;
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
