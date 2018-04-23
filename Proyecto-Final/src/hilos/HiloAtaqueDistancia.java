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
			
			AtaqueDistancia[] a = miJuego.darJugador1().darPersonaje().darAtaqueDistancia();
			AtaqueDistancia[] b = miJuego.darJugador2().darPersonaje().darAtaqueDistancia();
			

			for (int i = 0; i < a.length; i++) {
				if(a[i] != null) {
					a[i].moverX();
					if (a[i].darVida() == 0) {
						a[i] = null;
					}
				}
				
			}
			
			for (int i = 0; i < b.length; i++) {
				if(b[i] != null) {
					b[i].moverX();
					if (b[i].darVida() == 0) {
						b[i] = null;
					}
				}
				
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
