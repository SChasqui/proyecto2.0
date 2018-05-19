package hilos;

import interfaz.PanelJuego;
import modelo.AtaqueDistancia;
import modelo.Juego;

public class HiloAtaqueDistancia extends Thread{

	private Juego miJuego;
	
	private PanelJuego panel;

	public HiloAtaqueDistancia(Juego game, PanelJuego p) {
		
		miJuego = game;
		
		panel = p;
	}

	public void run() {
		while(true && !panel.darAcabo()) {
			
			
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
				sleep(33);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
