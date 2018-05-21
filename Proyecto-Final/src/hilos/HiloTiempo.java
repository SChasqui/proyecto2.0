package hilos;

import interfaz.VentanaPrincipal;
import modelo.Juego;

public class HiloTiempo extends Thread {
	
	private VentanaPrincipal interfaz;
	private Juego mundo;
	
	public HiloTiempo(VentanaPrincipal interfaz, Juego mundo) {
		this.interfaz = interfaz;
		this.mundo = mundo;
	}
	
	@Override
	public void run() {

		while (mundo.darBatalla().darTiempoActual() != 0) {
			mundo.darBatalla().restarUnSegundo();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
