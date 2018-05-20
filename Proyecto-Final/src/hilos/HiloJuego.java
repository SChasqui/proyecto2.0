package hilos;

import interfaz.PanelJuego;
import interfaz.VentanaPrincipal;
import modelo.Juego;

public class HiloJuego extends Thread{
	
	VentanaPrincipal interfaz;
	
	Juego miJuego;
	
	/*
	 * Modela el hilo encargado de el refresco visual en el transcurso de la batalla
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
				sleep(33);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
