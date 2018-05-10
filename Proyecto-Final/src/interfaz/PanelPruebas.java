package interfaz;


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

	// --------------------------------------
	// Constructor
	// --------------------------------------
	public PanelPruebas(VentanaPrincipal v) {

		ventana = v;
		addKeyListener(this);
		setVisible(true);
		setLocationRelativeTo(v);
		setSize(1280, 720);

		HiloPruebas h = new HiloPruebas(this);
		h.start();

		HiloAtaqueDistancia hD = new HiloAtaqueDistancia(this, ventana.darJuego());
		hD.start();
		HiloAnimaciones hA = new HiloAnimaciones(ventana.darJuego());
		hA.start();
	}

	@Override
	public void paint(Graphics g) {

		ImageIcon fondo = new ImageIcon("data/fondoEcenario/F03.png");
		g.drawImage(fondo.getImage(), 0, 0, null);

		Image sprite = ventana.darJuego().darJugador1().darPersonaje().darSprite();
		g.drawImage(sprite, ventana.darJuego().darJugador1().darPersonaje().darPosX(),
				ventana.darJuego().darJugador1().darPersonaje().darPosY(), null);

		Image sprite2 = ventana.darJuego().darJugador2().darPersonaje().darSprite();
		g.drawImage(sprite2, ventana.darJuego().darJugador2().darPersonaje().darPosX(),
				ventana.darJuego().darJugador2().darPersonaje().darPosY(), null);

		AtaqueDistancia a = ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia();
		
		
		while (a != null) {
			ImageIcon spriteAtaque = new ImageIcon(a.darSprite());
			g.drawImage(spriteAtaque.getImage(), a.darPosX(), a.darPosY(), null);
			
			kickBoxAtaque =  a.darKickBox();
			g.drawRect(kickBoxAtaque.x, kickBoxAtaque.y, kickBoxAtaque.width, kickBoxAtaque.height);
			
			a = a.darSiguiente();
			
		}

		a = ventana.darJuego().darJugador2().darPersonaje().darAtaqueDistancia();
		while (a != null) {
			ImageIcon spriteAtaque = new ImageIcon(a.darSprite());
			g.drawImage(spriteAtaque.getImage(), a.darPosX(), a.darPosY(), null);
			
			kickBoxAtaque =  a.darKickBox();
			g.drawRect(kickBoxAtaque.x, kickBoxAtaque.y, kickBoxAtaque.width, kickBoxAtaque.height);
			
			a = a.darSiguiente();
			
		}
		
		kickBoxPj1 = ventana.darJuego().darJugador1().darPersonaje().darRectangulo();
		g.drawRect(kickBoxPj1.x, kickBoxPj1.y, kickBoxPj1.width, kickBoxPj1.height);
		
		kickBoxPj2 = ventana.darJuego().darJugador2().darPersonaje().darRectangulo();
		g.drawRect(kickBoxPj2.x, kickBoxPj2.y, kickBoxPj2.width, kickBoxPj2.height);
		

	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		pressed.add(e.getKeyCode());
	}

	public void mover() {
		
		if(!ventana.darJuego().darJugador1().darPersonaje().atacando()) {
			ventana.darJuego().darJugador1().darPersonaje().quietotrue();
		}
		if(!ventana.darJuego().darJugador2().darPersonaje().atacando()) {
			ventana.darJuego().darJugador2().darPersonaje().quietotrue();
		}
		
		if (pressed.size() > 0) {
			for (int c : pressed) {

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
				else if(c == A) {
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
		pressed.remove(e.getKeyCode());

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

}