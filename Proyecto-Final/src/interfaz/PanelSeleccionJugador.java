package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.NoDesbloqueadoException;

public class PanelSeleccionJugador extends JPanel implements MouseListener {

	private VentanaPrincipal ventana;

	private int numJugador;

	private int index;
	
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

		Image flecha = new ImageIcon("data/fondo/flechaDerecha.png").getImage();
		g.drawImage(flecha, 890, 310, null);

		Image flechaIzquierda = new ImageIcon("data/fondo/flechaIzquierda.png").getImage();
		g.drawImage(flechaIzquierda, 290, 310, null);

		Image aceptar = new ImageIcon("data/fondo/aceptar.png").getImage();
		g.drawImage(aceptar, 985, 583, null);

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
			
			try {
				String nombre = JOptionPane.showInputDialog("Inserte Su NickName");
				String personaje = ventana.darJuego().daPersonajes()[index];
				ventana.darJuego().agregarJugadores(nombre, numJugador, personaje, index);
				if (numJugador == 1) {
					ventana.darJuego().darJugador1().seleccionarPersonaje(personaje, index);
				}else if (numJugador == 2) {
					ventana.darJuego().darJugador2().seleccionarPersonaje(personaje, index);
				}
			}
			catch(NoDesbloqueadoException e1) {
				
			}
			
			ventana.agregarPanelMenuPrincipal();
			
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
