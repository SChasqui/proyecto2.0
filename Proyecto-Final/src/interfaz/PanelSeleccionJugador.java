package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Jugador;
import modelo.NoDesbloqueadoException;
import modelo.Personaje;
import modelo.PuntosInsuficientesException;

public class PanelSeleccionJugador extends JPanel implements MouseListener {

	private VentanaPrincipal ventana;

	private int numJugador;

	private int index;

	private String nombreActual;

	public PanelSeleccionJugador(VentanaPrincipal v, int numJugador) {

		this.numJugador = numJugador;

		setVisible(true);
		this.ventana = v;
		addMouseListener(this);


	}

	@Override
	public void paint(Graphics g) {

		// Cargo la imagen que sera usada como banner para el juego
		Image fondo = new ImageIcon("data/fondo/escenarioJugador.jpg").getImage();
		g.drawImage(fondo, 0, 0,null);

		Image personaje = new ImageIcon("data/vistaPreviaPersonajes/" +ventana.darJuego().daPersonajes()[index]+ ".png").getImage();
		g.drawImage(personaje, 500, 250,null);
		
		g.setFont(new Font("Arial", Font.ITALIC, 30));
		g.drawString("Precio: " + Personaje.precios[index], 530, 530);

		Image flecha = new ImageIcon("data/fondo/flechaDerecha.png").getImage();
		g.drawImage(flecha, 890, 310, null);

		Image flechaIzquierda = new ImageIcon("data/fondo/flechaIzquierda.png").getImage();
		g.drawImage(flechaIzquierda, 290, 310, null);

		Image aceptar = new ImageIcon("data/fondo/aceptar.png").getImage();
		g.drawImage(aceptar, 985, 583, null);

		pintarNombreyPuntos(g);

	}

	public void pintarNombreyPuntos(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.ITALIC, 30));
		g.drawString(nombreActual, 30, 60);
		g.drawString("Puntos: " + ventana.darJugadorIndice(numJugador).darPuntos(), 30, 90);
	}

	public void cambiarJugador(int num) {
		numJugador = num;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int posX = e.getX();
		int posY = e.getY();

		//		System.out.println("posX = " +posX + "   PosY = " + posY );

		//Cuando oprima sobre la imagen

		if((posX > 500 && posX < 755 && posY > 250 && posY < 505) || (posX > 986 && posX < 1154 && posY > 582 && posY < 639)) {
			String personaje = ventana.darJuego().daPersonajes()[index];
			try {
				System.out.println(numJugador);
				
				ventana.darJugadorIndice(numJugador).seleccionarPersonaje(personaje, index);
				ventana.agregarPanelMenuPrincipal(this);

			}
			catch(NoDesbloqueadoException e1) {
				int seleccion = JOptionPane.showOptionDialog(
						this,
						e1.getMessage() + "\n¿ Desea desbloquear a " + e1.darPersonaje() + " ?", 
						"Personaje Bloqueado",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						new ImageIcon("data/fondo/icono.png"),    // null para icono por defecto.
						new Object[] { "Comprar", "Escojer otro"},   // null para YES, NO y CANCEL
						"opcion 1");
				if (seleccion == 0) {
					try {
				
							ventana.darJugadorIndice(numJugador).desbloquearPersonaje(index, personaje);
							ventana.darJugadorIndice(numJugador).seleccionarPersonaje(personaje, index);
						
					}catch (PuntosInsuficientesException e2) {
						JOptionPane.showConfirmDialog(this, "Puntos insuficientes",
								"Error en la compra", JOptionPane.DEFAULT_OPTION,
								JOptionPane.ERROR_MESSAGE, new ImageIcon("data/fondo/insuficientes.png"));
					} catch (NoDesbloqueadoException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}

		}

		//Cuando oprima sobre la imagen siguiente
		else if(posX > 869 && posX < 1004 && posY > 319 && posY < 461) {
			index = index == 9? 0: index + 1;
			repaint();

		}
		//Cuando oprima sobre el imagen para regresar
		else if(posX > 287 && posX < 405 && posY > 323 && posY < 458) {
			index = index == 0? 9: index - 1;
			repaint();
		}

	}

	public void cambiarJugadorActual() {
		nombreActual = JOptionPane.showInputDialog("Inserte Su NickName");
		ventana.darJuego().agregarJugadores(nombreActual, numJugador);
		nombreActual = ventana.darJugadorIndice(numJugador).darNickName();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
