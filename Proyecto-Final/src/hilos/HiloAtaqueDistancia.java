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
			
			while (actualUno != null) {
				
				if(actualUno.comprobarAtaque(miJuego.darBatalla().darJugador2().darPersonaje().darKickBox())) {
					miJuego.darBatalla().darJugador2().darPersonaje().restarVida((actualUno.darDanho())-miJuego.darBatalla().darJugador2().darPersonaje().darResistencia());
					System.out.println(actualUno.darDanho());
					actualUno.restarVida();
					miJuego.darBatalla().darJugador1().darPersonaje().limpiarAtaques();
					miJuego.darBatalla().darJugador2().darPersonaje().limpiarAtaques();
					
				}
				
				actualUno.moverX();
				actualUno = actualUno.darSiguiente();
			}

			while (actualDos != null) {
				
				if(actualDos.comprobarAtaque(miJuego.darBatalla().darJugador1().darPersonaje().darKickBox())) {
					miJuego.darBatalla().darJugador1().darPersonaje().restarVida((actualDos.darDanho())-miJuego.darBatalla().darJugador2().darPersonaje().darResistencia());
					actualDos.restarVida();
					miJuego.darBatalla().darJugador1().darPersonaje().limpiarAtaques();
					miJuego.darBatalla().darJugador2().darPersonaje().limpiarAtaques();
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
