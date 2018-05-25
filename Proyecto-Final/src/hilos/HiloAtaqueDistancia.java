package hilos;

import interfaz.PanelJuego;
import interfaz.VentanaPrincipal;
import modelo.AtaqueDistancia;
import modelo.Juego;

public class HiloAtaqueDistancia extends Thread{

	private Juego miJuego;
	private VentanaPrincipal interfaz;
	private boolean colisionaron;

	public HiloAtaqueDistancia(Juego game, VentanaPrincipal v) {

		miJuego = game;

		interfaz = v;
	}

	public void run() {

		PanelJuego panel = interfaz.darPanelJuego();

		while(true && !panel.darAcabo()) {
			colisionaron = false;

			AtaqueDistancia actualUno = miJuego.darBatalla().darJugador1().darPersonaje().darAtaqueDistancia();
			AtaqueDistancia actualDos = miJuego.darBatalla().darJugador2().darPersonaje().darAtaqueDistancia();
			
			
			int i =1;
			while (actualUno != null) {
				
				if(actualUno.comprobarAtaque(miJuego.darBatalla().darJugador2().darPersonaje().darKickBox())) {
					miJuego.darBatalla().darJugador2().darPersonaje().restarVida(actualUno.darDanho());
					actualUno.restarVida();
				}
				
				actualUno.moverX();
				actualUno = actualUno.darSiguiente();

				System.out.println(i);
				i++;
			}

			while (actualDos != null) {
				
				if(actualDos.comprobarAtaque(miJuego.darBatalla().darJugador1().darPersonaje().darKickBox())) {
					miJuego.darBatalla().darJugador1().darPersonaje().restarVida(actualDos.darDanho());
					actualDos.restarVida();
				}
				
				actualDos.moverX();
				actualDos = actualDos.darSiguiente();

			}

			miJuego.darBatalla().darJugador1().darPersonaje().limpiarAtaques();
			miJuego.darBatalla().darJugador2().darPersonaje().limpiarAtaques();

			try {
				sleep(33);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
