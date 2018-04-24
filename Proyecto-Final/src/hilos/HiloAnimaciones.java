package hilos;

import modelo.Juego;

public class HiloAnimaciones extends Thread {
	
	Juego juego;
	
	public HiloAnimaciones(Juego j) {

		juego = j;
		
	}
	
	@Override
	public void run() {

		while (true) {

			if (juego.darJugador2() != null && juego.darJugador2().darPersonaje() != null) {
				juego.darJugador2().darPersonaje().actualizar();
			}
			if (juego.darJugador1() != null && juego.darJugador1().darPersonaje() != null) {
				juego.darJugador1().darPersonaje().actualizar();
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
