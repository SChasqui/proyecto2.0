package hilos;

import interfaz.PanelJuego;
import modelo.Juego;

public class HiloJuego extends Thread{
	
	PanelJuego pJuego;
	
	Juego miJuego;
	
	/*
	 * Holamundosa
	 */
	public HiloJuego(PanelJuego p, Juego miJuego) {
		pJuego = p;
		this.miJuego = miJuego;
	}
	
	
	@Override
	public void run() {
		while (true && !pJuego.darAcabo()) {

			pJuego.repaint();
			try {
				//83
				sleep(83);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
