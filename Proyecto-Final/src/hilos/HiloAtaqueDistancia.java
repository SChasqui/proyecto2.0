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
			
			AtaqueDistancia actualUno = miJuego.darJugador1().darPersonaje().darAtaqueDistancia();
			AtaqueDistancia actualDos = miJuego.darJugador2().darPersonaje().darAtaqueDistancia();
			
			int i =1;
			while (actualUno != null) {

				actualUno.moverX();
				actualUno = actualUno.darSiguiente();
				
				System.out.println(i);
				i++;
				
			}
			
			while (actualDos != null) {

				actualDos.moverX();
				actualDos = actualDos.darSiguiente();
				
			}
			
			miJuego.darJugador1().darPersonaje().limpiarAtaques();
			miJuego.darJugador2().darPersonaje().limpiarAtaques();

			try {
				sleep(83);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
