package hilos;

import interfaz.PanelJuego;
import modelo.Jugador;

public class HiloAnimaciones extends Thread {
	
	private Jugador jugador;
	private PanelJuego pJuego;
	private int personaje;
	int time;
	
	
	public HiloAnimaciones(Jugador j, PanelJuego p, int personaje) {

		jugador = j;
		pJuego = p;
		this.personaje = personaje;
	}
	
	@Override
	public void run() {

		while (true) {

				jugador.darPersonaje().actualizar();
				if (!pJuego.modificando()) {
					if (personaje == 1) {
						pJuego.moverPersonaje1();
					}else {
						pJuego.moverPersonaje2();
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
