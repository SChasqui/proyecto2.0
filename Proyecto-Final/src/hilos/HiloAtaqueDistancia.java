package hilos;

import interfaz.PanelPruebas;
import modelo.AtaqueDistancia;
import modelo.Juego;

public class HiloAtaqueDistancia extends Thread{
	
	private PanelPruebas pPruebas;
	private Juego miJuego;
	
	public HiloAtaqueDistancia(PanelPruebas p, Juego game) {
		pPruebas = p;
		miJuego = game;
	}
	
	public void run() {
		while(true) {
			if(miJuego.darJugador1().darPersonaje().darAtaqueDistancia()!= null) {
				
				miJuego.darJugador1().darPersonaje().darAtaqueDistancia().moverX();
				try {
					sleep(83);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
