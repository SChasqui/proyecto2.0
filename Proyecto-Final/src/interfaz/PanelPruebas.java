package interfaz;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import hilos.HiloAnimaciones;
import hilos.HiloAtaqueDistancia;
import hilos.HiloPruebas;
import modelo.AtaqueDistancia;
import modelo.Jugador;
import modelo.JugadorNoSeleccionadoException;

/*
 * Clase que sirve para probar los métodos del modelo del mundo
 */
public class PanelPruebas extends JDialog implements KeyListener {

	// --------------------------------------
	// Constantes.
	// --------------------------------------
	public final static int FLECHA_ARRIBA = 40;
	public final static int FLECHA_DERECHA = 39;
	public final static int FLECHA_ABAJO = 38;
	public final static int FLECHA_IZQUIERDA = 37;
	public static final int NUMERO_UNO = 97;
	public static final int NUMERO_DOS = 98;

	// Jugador 2
	public final static int W = 83;
	public final static int D = 68;
	public static final int S = 87;
	public static final int A = 65;
	public static final int J = 74;
	public static final int K = 75;


	public final Set<Integer> pressed = new HashSet<Integer>();

	// --------------------------------------
	// Relaciones
	// --------------------------------------
	/*
	 * Relación con la ventana principal
	 */
	private VentanaPrincipal ventana;

	private Rectangle kickBoxAtaque;
	private Rectangle kickBoxPj1;
	private Rectangle kickBoxPj2;

	private boolean modificando;

	// --------------------------------------
	// Constructor
	// --------------------------------------
	public PanelPruebas(VentanaPrincipal v) {

		ventana = v;
//		v.darJuego().agregarJugadores("Betta", 1 ,"Beerus",1);
//		v.darJuego().agregarJugadores("Betta2", 2 ,"Broly",2);
		try {
			v.darJuego().iniciarBatalla("nothing");
		} catch (JugadorNoSeleccionadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addKeyListener(this);
		setVisible(true);
		setLocationRelativeTo(v);
		setSize(1280, 720);

		HiloPruebas h = new HiloPruebas(this);
		h.start();

		HiloAtaqueDistancia hD = new HiloAtaqueDistancia(this, ventana.darJuego());
		hD.start();
		HiloAnimaciones hA1 = new HiloAnimaciones(ventana.darJuego().darJugador1(),this,1);
		hA1.start();
		HiloAnimaciones hA2 = new HiloAnimaciones(ventana.darJuego().darJugador2(),this,2);
		hA2.start();
	}

	@Override
	public void paint(Graphics g) {

		pintarFondo(g);

		pintarPersonajes(g);

		AtaqueDistancia a = ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia();


		while (a != null) {
			ImageIcon spriteAtaque = new ImageIcon(a.darSprite());
			g.drawImage(spriteAtaque.getImage(), a.darPosX(), a.darPosY(), null);
			a = a.darSiguiente();
		}

		a = ventana.darJuego().darJugador2().darPersonaje().darAtaqueDistancia();
		while (a != null) {
			ImageIcon spriteAtaque = new ImageIcon(a.darSprite());
			g.drawImage(spriteAtaque.getImage(), a.darPosX(), a.darPosY(), null);
			a = a.darSiguiente();
		}
		pintarBarras(g);
	}

	private void pintarPersonajes(Graphics g) {
		Image sprite = ventana.darJuego().darJugador1().darPersonaje().darSprite();
		g.drawImage(sprite, ventana.darJuego().darJugador1().darPersonaje().darPosX(),
				ventana.darJuego().darJugador1().darPersonaje().darPosY(), null);

		Image sprite2 = ventana.darJuego().darJugador2().darPersonaje().darSprite();
		g.drawImage(sprite2, ventana.darJuego().darJugador2().darPersonaje().darPosX(),
				ventana.darJuego().darJugador2().darPersonaje().darPosY(), null);
		
	}

	public void pintarFondo(Graphics g) {
		ImageIcon fondo = new ImageIcon("data/fondoEscenario/escenario1.png");
		g.drawImage(fondo.getImage(), 0, 0, null);
	}

	public void pintarBarras(Graphics g) {

		g.setColor(Color.red);
		// Pintar vida de jugador 1
		g.drawRect(30, 50, 500, 30);
		g.fillRect(30, 50, ventana.darJuego().darJugador1().darSaludActual(), 30);
		// Pintar vida Jugador 2
		g.drawRect(730, 50, 500, 30);
		g.fillRect(730, 50, ventana.darJuego().darJugador2().darSaludActual(), 30);
		
		g.setColor(Color.BLUE);
		//Pintar Ki Jugador 1
		g.drawRect(30, 80, 500, 30);
		g.fillRect(30, 80, ventana.darJuego().darJugador1().darKiActual(), 30);
		//Pintar Ki Jugador 2
		g.drawRect(730, 80, 500, 30);
		g.fillRect(730, 80, ventana.darJuego().darJugador2().darKiActual(), 30);

	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		modificando = true;
		pressed.add(e.getKeyCode());
		modificando = false;
	}

	public void moverPersonaje1() {

		if(!ventana.darJuego().darJugador1().darPersonaje().atacando()) {
			ventana.darJuego().darJugador1().darPersonaje().quietotrue();
		}

		Set<Integer> temp = new HashSet<Integer>(pressed);

		if (temp.size() > 0) {
			for (int c : temp) {

				if (c == FLECHA_IZQUIERDA) {
					ventana.darJuego().darJugador1().darPersonaje().moverX(-12);
				} else if (c == FLECHA_ABAJO) {
					ventana.darJuego().darJugador1().darPersonaje().moverY(-12);
				} else if (c == FLECHA_DERECHA) {
					ventana.darJuego().darJugador1().darPersonaje().moverX(12);
				} else if (c == FLECHA_ARRIBA) {
					ventana.darJuego().darJugador1().darPersonaje().moverY(12);
				} else if (c == NUMERO_UNO) {
					ventana.darJuego().darJugador1().darPersonaje().atacar(c);
				} else if (c == NUMERO_DOS) {
					ventana.darJuego().darJugador1().darPersonaje().lanzarAtaqueDistante();

				}

			}
		}

	}

	public void moverPersonaje2() {

		if(!ventana.darJuego().darJugador2().darPersonaje().atacando()) {
			ventana.darJuego().darJugador2().darPersonaje().quietotrue();
		}

		Set<Integer> temp = new HashSet<Integer>(pressed);

		if (temp.size() > 0) {
			for (int c : temp) {

				if(c == A) {
					ventana.darJuego().darJugador2().darPersonaje().moverX(-12);
				}else if(c == S) {
					ventana.darJuego().darJugador2().darPersonaje().moverY(-12);
				}else if(c == D) {
					ventana.darJuego().darJugador2().darPersonaje().moverX(12);
				}else if(c == W) {
					ventana.darJuego().darJugador2().darPersonaje().moverY(12);
				}else if(c == J) {
					ventana.darJuego().darJugador2().darPersonaje().atacar(c);
				}else if(c == K) {
					ventana.darJuego().darJugador2().darPersonaje().lanzarAtaqueDistante();

				}

			}
		}

	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		modificando = true;
		pressed.remove(e.getKeyCode());
		modificando = false;

		int c = e.getKeyCode();

		if (c == FLECHA_IZQUIERDA) {
			ventana.darJuego().darJugador1().darPersonaje().quietotrue();
		} else if (c == FLECHA_DERECHA) {
			ventana.darJuego().darJugador1().darPersonaje().quietotrue();
		} else if (c == A) {
			ventana.darJuego().darJugador2().darPersonaje().quietotrue();
		} else if (c == D) {
			ventana.darJuego().darJugador2().darPersonaje().quietotrue();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	/* Not used */ }

	public boolean modificando(){
		return modificando;
	}

}