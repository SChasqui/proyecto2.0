package hilos;

import interfaz.PanelJuego;

public class HiloJuego extends Thread{
	
	PanelJuego pJuego;
	
	/*
	 * Holamundosa
	 */
	public HiloJuego(PanelJuego p) {
		pJuego = p;
	}
	
	
	@Override
	public void run() {
		while (true) {

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
