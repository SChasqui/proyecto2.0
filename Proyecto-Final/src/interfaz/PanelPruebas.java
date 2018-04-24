package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

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

	private boolean ataqueActivo;

	private final Set<Integer> pressed = new HashSet<Integer>();

	// --------------------------------------
	// Relaciones
	// --------------------------------------
	/*
	 * Relación con la ventana principal
	 */
	private VentanaPrincipal ventana;

	// --------------------------------------
	// Constructor
	// --------------------------------------
	public PanelPruebas(VentanaPrincipal v) {

		ventana = v;
		addKeyListener(this);
		setVisible(true);
		setLocationRelativeTo(null);
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
		g.setColor(Color.BLUE);
		ImageIcon fondo = new ImageIcon("data/fondoEcenario/F03.png");
		g.drawImage(fondo.getImage(), 0, 0, null);

		Image sprite = ventana.darJuego().darJugador1().darPersonaje().darSprite();
		g.drawImage(sprite, ventana.darJuego().darJugador1().darPersonaje().darPosX(),
				ventana.darJuego().darJugador1().darPersonaje().darPosY(), null);

		Image sprite2 = ventana.darJuego().darJugador2().darPersonaje().darSprite();
		g.drawImage(sprite2, ventana.darJuego().darJugador2().darPersonaje().darPosX(),
				ventana.darJuego().darJugador2().darPersonaje().darPosY(), null);

		AtaqueDistancia[] a = ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia();
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) {
				ImageIcon spriteAtaque = new ImageIcon(a[i].darSprite());
				g.drawImage(spriteAtaque.getImage(), a[i].darPosx(), a[i].darPosY(), null);
				// System.out.println("Pos x: " + a[i].darPosx());
			}
		}
		
		AtaqueDistancia[] b = ventana.darJuego().darJugador2().darPersonaje().darAtaqueDistancia();
		for (int i = 0; i < b.length; i++) {
			if (b[i] != null) {
				ImageIcon spriteAtaque = new ImageIcon(b[i].darSprite());
				g.drawImage(spriteAtaque.getImage(), b[i].darPosx(), b[i].darPosY(), null);
				// System.out.println("Pos x: " + a[i].darPosx());
			}
		}

	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		pressed.add(e.getKeyCode());
		System.out.println("Flecha presionada: " + e.getKeyCode());
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
					if (ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia() != null) {
						ataqueActivo = true;

					}
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
					 if(ventana.darJuego().darJugador2().darPersonaje().darAtaqueDistancia() != null) {
						 ataqueActivo = true;
					
					 }
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
