package hilos;

import interfaz.PanelJuego;
import interfaz.VentanaPrincipal;
import modelo.Juego;

public class HiloJuego extends Thread{
	
	VentanaPrincipal interfaz;
	
	Juego miJuego;
	
	/*
	 * Holamundosa
	 */
	public HiloJuego(VentanaPrincipal ventana, Juego miJuego) {
		interfaz = ventana;
		this.miJuego = miJuego;
	}
	
	
	@Override
	public void run() {
		
		PanelJuego pJuego = interfaz.darPanelJuego();
		
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
