/* Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hilos.HiloAnimaciones;
import hilos.HiloAtaqueDistancia;
import hilos.HiloJuego;
import modelo.AtaqueDistancia;
import modelo.Jugador;
import modelo.JugadorNoSeleccionadoException;

/*
 * Clase que modela el PanelJuego que extiende de JPanel e implementa KeyListener
 */
public class PanelJuego extends JPanel implements KeyListener{
	
	//Relaciones 
	
	/*
	 * Relacion con la ventana principal
	 */
	public VentanaPrincipal ventana;
	
	//Constantes
	
	/*
	 * Constante que mueven al jugador 1
	 */
	
	/*
	 * Constante que mueve al jugador 1 hacia arriba
	 */
	public final static int FLECHA_ARRIBA = 40;
	/*
	 * Constante que mueve al jugador 1 hacia la derecha
	 */
	public final static int FLECHA_DERECHA = 39;
	/*
	 * Constante que mueve al jugador 1 hacia abajo
	 */
	public final static int FLECHA_ABAJO = 38;
	
	/*
	 * Constante que mueve al jugador 1 hacia la izquierda
	 */
	public final static int FLECHA_IZQUIERDA = 37;
	
	/*
	 * Constante que permite dar ki
	 */
	public static final int NUMERO_CERO = 96;
	/*
	 * Constante que permite dar puño
	 */
	public static final int NUMERO_UNO = 97;
	
	/*
	 * Constante que permite dar patada
	 */
	public static final int NUMERO_DOS = 98;
	/*
	 * Constante que permite defender
	 */
	public static final int NUMERO_TRES = 99;
	/*
	 * Constante que permite lanzar ataque mediano
	 */
	public static final int NUMERO_CUATRO = 100;
	/*
	 * Constante que permite lanzar ataque pequeño
	 */
	public static final int NUMERO_CINCO = 101;
	/*
	 * Constante que permite lanzar ataque grande
	 */
	public static final int NUMERO_SEIS = 102;
	
	/*
	 * Constantes para el Jugador 2
	 */
	
	/*
	 * Constante que permite mover hacia arriba
	 */
	public final static int W = 83;
	/*
	 * Constante que permite mover hacia la derecha
	 */
	public final static int D = 68;
	/*
	 * Constante que permite mover hacia abajo
	 */
	public static final int S = 87;
	/*
	 * Constante que permite mover hacia la izquierda
	 */
	public static final int A = 65;
	
	/*
	 * Constante que permite dar un puño
	 */
	public static final int G = 71;
	/*
	 * Constante que permite dar patada
	 */
	public static final int H = 72;
	/*
	 * Constante que permite defender
	 */
	public static final int J = 74;
	/*
	 * Constante que permite recargar el Ki
	 */
	public static final int R = 82;
	/*
	 * Constante que permite lanzar ataque mediano
	 */
	public static final int T = 84;
	/*
	 * Constante que permite lanzar ataque pequeño
	 */
	public static final int Y = 89;
	/*
	 * Constante que permite lanzar ataque grande
	 */
	public static final int U = 85;
	
	/*
	 * Constante que permite 
	 */
	public final Set<Integer> pressed = new HashSet<Integer>();
	
	/*
	 * boolean modificado 
	 */
	private boolean modificando;
	/*
	 * bolean atacado
	 */
	private boolean acabo;
	
	/*
	 * Constructor del PanelJuego
	 * @param objeto de tipo VentanaPrincipal 
	 */
	public PanelJuego(VentanaPrincipal ventana) {
		
		this.ventana = ventana;
		
		setVisible(true);

	}
	/*
	 * metodo que da el boolean modificado 
	 */
	public boolean modificando(){
		return modificando;
	}
	
	/*
	 * Metodo que permite pintar objetos de tipo Graphics 
	 * @param Objeto de tipo Graphics
	 */
	@Override
	public void paint(Graphics g) {

		pintarFondo(g);

		pintarPersonajes(g);

		AtaqueDistancia a = ventana.darJuego().darBatalla().darJugador1().darPersonaje().darAtaqueDistancia();


		while (a != null) {
			ImageIcon spriteAtaque = new ImageIcon(a.darSprite());
			g.drawImage(spriteAtaque.getImage(), a.darPosX(), a.darPosY(), null);
			a = a.darSiguiente();
		}

		a = ventana.darJuego().darBatalla().darJugador2().darPersonaje().darAtaqueDistancia();
		while (a != null) {
			ImageIcon spriteAtaque = new ImageIcon(a.darSprite());
			g.drawImage(spriteAtaque.getImage(), a.darPosX(), a.darPosY(), null);
			a = a.darSiguiente();
		}
		
		pintarReloj(g);
		
		pintarBarras(g);
	
	}
	
	/*
	 * Metodo que permite pintar el reloj 
	 * @param objeto de tipo Graphics 
	 */
	private void pintarReloj(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString(ventana.darJuego().darBatalla().darTiempoActual() + "", 600, 80);
		g.drawImage(new ImageIcon("data/fondo/rayitos.gif").getImage(), 600, 35,30,30, this);
		g.drawImage(new ImageIcon("data/fondo/rayitos.gif").getImage(), 640, 50,30,30, this);
	}
	/*
	 * Metodo que permite pintar al personaje
	 * @param objeto de tipo Graphics 
	 */
	private void pintarPersonajes(Graphics g) {
		Jugador temp = ventana.darJuego().darBatalla().darJugador1();
		
		Image sprite = temp.darPersonaje().darSprite();
		g.drawImage(sprite, temp.darPersonaje().darPosX(),
				temp.darPersonaje().darPosY(), null);

		temp = ventana.darJuego().darBatalla().darJugador2();
		Image sprite2 = temp.darPersonaje().darSprite();
		g.drawImage(sprite2, temp.darPersonaje().darPosX(),
				temp.darPersonaje().darPosY(), null);
		
	}
	/*
	 * Metodo que permite pintar el fondo 
	 * @param objeto de tipo Graphics
	 */

	public void pintarFondo(Graphics g) {
		ImageIcon fondo = new ImageIcon("data/fondoEscenario/"+ventana.darJuego().darBatalla().darFondos()+".png");
		g.drawImage(fondo.getImage(), 0, 0, null);
	}
	
	/*
	 * Metodo que permite pintar las barras
	 * @param objeto de tipo Graphics 
	 */
	public void pintarBarras(Graphics g) {

		g.setColor(Color.red);
		// Pintar vida de jugador 1
		g.drawRect(30, 50, 500, 30);
		g.fillRect(30, 50, ventana.darJuego().darBatalla().darJugador1().darSaludActual(), 30);
		// Pintar vida Jugador 2
		g.drawRect(730, 50, 500, 30);
		g.fillRect(730, 50, ventana.darJuego().darBatalla().darJugador2().darSaludActual(), 30);
		
		g.setColor(Color.BLUE);
		//Pintar Ki Jugador 1
		g.drawRect(30, 80, 500, 30);
		g.fillRect(30, 80, ventana.darJuego().darBatalla().darJugador1().darKiActual(), 30);
		//Pintar Ki Jugador 2
		g.drawRect(730, 80, 500, 30);
		g.fillRect(730, 80, ventana.darJuego().darBatalla().darJugador2().darKiActual(), 30);
		
		
		g.drawString(ventana.darJuego().darBatalla().darJugador1().darNickName(), 30, 150);
		g.drawString(ventana.darJuego().darBatalla().darJugador2().darNickName(), 730, 150);

	}
	
	/*
	 * Metodo que escucha el evento keyPressed
	 * @param objeto de tipo KeyEvent
	 */
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		modificando = true;
		pressed.add(e.getKeyCode());
		modificando = false;
	}
	
	/*
	 * Metodo que mueve al personaje1
	 */
	public void moverPersonaje1() {
		
		Jugador temporal = ventana.darJuego().darBatalla().darJugador1();

		if(!temporal.darPersonaje().atacando()) {
			temporal.darPersonaje().quietotrue();
		}

		if (!modificando) {
			Set<Integer> temp = new HashSet<Integer>(pressed);

			if (temp.size() > 0) {
				for (int c : temp) {
					if (c == FLECHA_IZQUIERDA) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().moverX(-12);
					} else if (c == FLECHA_ABAJO) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().moverY(-12);
					} else if (c == FLECHA_DERECHA) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().moverX(12);
					} else if (c == FLECHA_ARRIBA) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().moverY(12);
					} else if (c == NUMERO_UNO) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().atacarPuño();
					} else if(c == NUMERO_DOS) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().atacarPatada();
					} else if (c == NUMERO_CUATRO) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().lanzarAtaqueDistanteMediano();
					} else if (c == NUMERO_CINCO) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().lanzarAtaqueDistantePequeño();
					} else if (c == NUMERO_SEIS) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().lanzarAtaqueDistanteGrande();
					} else if(c==NUMERO_CERO) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().recargarKi();
					} else if(c==NUMERO_TRES) {
						ventana.darJuego().darBatalla().darJugador1().darPersonaje().defender();
					}

				}
			}
		}

	}
	
	/*
	 * Metodo que mueve al personaje2
	 */
	public void moverPersonaje2() {
		
		Jugador temporal = ventana.darJuego().darBatalla().darJugador2();

		if(!temporal.darPersonaje().atacando()) {
			temporal.darPersonaje().quietotrue();
		}

		if (!modificando) {
			Set<Integer> temp = new HashSet<Integer>(pressed);

			if (temp.size() > 0) {
				for (int c : temp) {
					if(c == A) {
						temporal.darPersonaje().moverX(-12);
					}else if(c == S) {
						temporal.darPersonaje().moverY(-12);
					}else if(c == D) {
						temporal.darPersonaje().moverX(12);
					}else if(c == W) {
						temporal.darPersonaje().moverY(12);
					}else if(c == G) {
						temporal.darPersonaje().atacarPuño();
					}else if(c == H){
						temporal.darPersonaje().atacarPatada();
					}else if(c == T) {
						temporal.darPersonaje().lanzarAtaqueDistanteMediano();
					}else if(c == Y) {
						temporal.darPersonaje().lanzarAtaqueDistantePequeño();
					}else if(c == U) {
						temporal.darPersonaje().lanzarAtaqueDistanteGrande();
					}else if(c == R) {
						temporal.darPersonaje().recargarKi();;
					}else if(c == J) {
						temporal.darPersonaje().defender();
					}

				}
			}
		}

	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		modificando = true;
		pressed.remove(e.getKeyCode());
		modificando = false;
		
		try {
			
			int c = e.getKeyCode();
			
			if (c == FLECHA_IZQUIERDA) {
				ventana.darJuego().darBatalla().darJugador1().darPersonaje().quietotrue();
			} else if (c == FLECHA_DERECHA) {
				ventana.darJuego().darBatalla().darJugador1().darPersonaje().quietotrue();
			} else if (c == A) {
				ventana.darJuego().darBatalla().darJugador2().darPersonaje().quietotrue();
			} else if (c == D) {
				ventana.darJuego().darBatalla().darJugador2().darPersonaje().quietotrue();
			} else if (c == J) {
//				ventana.darJuego().darBatalla().darJugador2().darPersonaje().normalizarResistencia();
			}
		}catch(NullPointerException exception) {
			JOptionPane.showMessageDialog(null, "Guarde sus ataques para el juego", "Tecla presionado antes de empezar", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	/*
	 * Metodo que da el boolean acabo
	 */
	public boolean darAcabo() {
		return acabo;
	}
	/*
	 * Metodo que cambia el boolean acabo
	 */
	public void cambiarAcabo(boolean parametro) {
		acabo = parametro;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Metodo que permite mostrar el mensaje final de la partida
	 * @param Entero que indica el numero del personaje ganador 
	 */
	public void mostrarMensajeFianal(int personaje) {

		acabo = true;
		
		personaje = personaje == 1? 2:1;
		
		String nombre = personaje == 1? ventana.darJuego().darBatalla().darJugador1().darNickName() : ventana.darJuego().darBatalla().darJugador2().darNickName();
		
		JOptionPane.showMessageDialog(this, "Felicidades " + nombre + " Has ganado 100 puntos", "Fin de la batalla", JOptionPane.DEFAULT_OPTION);
		
		ventana.darJuego().darPuntos(personaje);
		
		ventana.agregarPanelMenuPrincipal(this);
		
	}

}

