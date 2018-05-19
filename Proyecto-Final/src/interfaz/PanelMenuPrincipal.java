package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelMenuPrincipal extends JPanel implements MouseListener{


	//--------------------------------------
	// Relaciones
	//--------------------------------------

	/*
	 * Relacion con la ventana principal
	 */
	VentanaPrincipal ventana;

	//--------------------------------------
	// Atributos
	//--------------------------------------

	public PanelMenuPrincipal(VentanaPrincipal v) {
		addMouseListener(this);
		ventana = v;
	}

	@Override
	public void paint(Graphics g) {

		// Cargo la imagen que sera usada como banner para el juego
		Image fondo = new ImageIcon("data/fondo/Banner.png").getImage();
		g.drawImage(fondo, 0, 0,null);


		// Selecciono una fuente para las opciones
		g.setFont(new Font("Helvetica", Font.BOLD, 35));
		// Selecciono un color para las opciones
		g.setColor(Color.WHITE);
		// Dibujo las opciones
		g.drawString("Seleccionar Jugador Uno", 110, 166);
		g.drawString("Seleccionar Jugador Dos", 110, 260);
		g.drawString("Iniciar Batalla", 110, 360);
		g.drawString("Ver Puntajes Guardados", 110, 454);
		g.drawString("Créditos", 110, 548);

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		int posX = e.getX();
		int posY = e.getY();

		System.out.println("PosX:  " + posX + "  PosY:    " + posY);

		//****************************************//
		// Area de opcion de selecion jugador 1
		//****************************************//
		if (posX > 45 && posX < 625 && posY > 110 && posY < 190) {
			ventana.agregarPanelJugador(1);
		}
		//****************************************//
		// Area de opcion de selecion jugador 2
		//****************************************//
		else if (posX > 45 && posX < 625 && posY > 195 && posY < 290) {
			ventana.agregarPanelJugador(2);
		}
		//****************************************
		// Area de opcion de selecion jugador 
		//****************************************
		else if (posX > 45 && posX < 625 && posY > 295 && posY < 390) {
			ventana.agregarPanelEscenario();
			//Chasqui, aqui quede!

		}

		//****************************************
		// Area de opcion de puntajes 
		//****************************************
		else if (posX > 45 && posX < 625 && posY > 395 && posY < 490) {

		}

		//****************************************
		// Área de pruebas varias
		//****************************************
		else if(posX > 45 && posX < 625 && posY > 495 && posY < 590) {
			
		}


		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
