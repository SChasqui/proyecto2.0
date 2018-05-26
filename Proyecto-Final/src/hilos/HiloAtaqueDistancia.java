package hilos;

import interfaz.PanelJuego;
import interfaz.VentanaPrincipal;
import modelo.AtaqueDistancia;
import modelo.Juego;
import modelo.Personaje;

public class HiloAtaqueDistancia extends Thread{

	private Juego miJuego;
	private VentanaPrincipal interfaz;

	public HiloAtaqueDistancia(Juego game, VentanaPrincipal v) {

		miJuego = game;

		interfaz = v;
	}

	public void run() {

		PanelJuego panel = interfaz.darPanelJuego();

		while(true && !panel.darAcabo()) {
			
			Personaje pj1 = miJuego.darBatalla().darJugador1().darPersonaje();
			Personaje pj2 = miJuego.darBatalla().darJugador2().darPersonaje();
			AtaqueDistancia actualUno = pj1.darAtaqueDistancia();
			AtaqueDistancia actualDos = pj2.darAtaqueDistancia();
			
			
			while (actualUno != null) {
				
				if(actualUno.comprobarAtaque(pj2.darKickBox())) {
					pj2.restarVida((actualUno.darDanho())-pj2.darResistencia());
					actualUno.destruirAtaque();
					pj1.limpiarAtaques();
					pj2.limpiarAtaques();
					
				}
				
				if(actualDos!=null) {
					
					if(actualUno.comprobarAtaque(actualDos.darKickBox())) {actualDos.restarVida(actualUno.darPoder());}
					if(actualDos.comprobarAtaque(actualUno.darKickBox())) {actualUno.restarVida(actualDos.darPoder());}
				}
				
				actualUno.moverX();
				actualUno = actualUno.darSiguiente();
			}

			while (actualDos != null) {
				
				if(actualDos.comprobarAtaque(pj1.darKickBox())) {
					pj1.restarVida((actualDos.darDanho())-pj2.darResistencia());
					actualDos.destruirAtaque();
					pj1.limpiarAtaques();
					pj2.limpiarAtaques();
					
				}
				if(actualUno!=null) {
					
					if(actualDos.comprobarAtaque(actualUno.darKickBox())) {actualUno.restarVida(actualDos.darPoder());}
					if(actualUno.comprobarAtaque(actualDos.darKickBox())) {actualDos.restarVida(actualUno.darPoder());}
				}
				
				actualDos.moverX();
				actualDos = actualDos.darSiguiente();

			}

			pj1.limpiarAtaques();
			pj2.limpiarAtaques();

			try {
				sleep(33);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
