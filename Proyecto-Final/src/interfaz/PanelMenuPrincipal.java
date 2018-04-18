package interfaz;

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
	
	boolean[] botones;	

	public PanelMenuPrincipal(VentanaPrincipal v) {
		botones = new boolean[3];
		addMouseListener(this);
		ventana = v;
	}

	@Override
	public void paint(Graphics g) {

		// Cargo la imagen que sera usada como banner para el juego
		Image fondo = new ImageIcon("data/fondo/Banner.png").getImage();
		g.drawImage(fondo, 0, 0,null);

		// Selecciono un color para los recuadros
		g.setColor(Color.RED);

		// Dibujo los recuadros

		//*********************//
		// Condicional Cuadro 1
		//*********************//
		if (!botones[0]) {
			g.drawRect(20, 120, 580, 35);
		}else {
			g.fillRect(20, 120, 580, 35);
		}

		//*********************//
		// Condicional Cuadro 2
		//*********************//
		if (!botones[1]) {
			g.drawRect(20, 190, 580, 35);
		}else {
			g.fillRect(20, 190, 580, 35);
		}

		//*********************//
		// Condicional Cuadro 3
		//*********************//
		if (!botones[2]) {
			g.drawRect(20, 260, 360, 35);
		}else {
			g.fillRect(20, 260, 360, 35);
		}



		// Selecciono una fuente para las opciones
		g.setFont(new Font("Algerian", Font.BOLD, 40));
		// Selecciono un color para las opciones
		g.setColor(Color.BLUE);
		// Dibujo las opciones
		g.drawString("Seleccionar Jugador Uno", 20, 150);
		g.drawString("Seleccionar Jugador Dos", 20, 220);
		g.drawString("Iniciar Batalla", 20, 290);

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

		botones[0] = false;
		botones[1] = false;
		botones[2] = false;

		System.out.println("PosX:  " + posX + "  PosY:    " + posY);

		//****************************************//
		// Area de opcion de selecion jugador 1
		//****************************************//
		if (posX > 20 && posX < 600 && posY > 120 && posY < 155) {
			botones[0] = true;
		}
		//****************************************//
		// Area de opcion de selecion jugador 2
		//****************************************//
		else if (posX > 20 && posX < 600 && posY > 190 && posY < 225) {
			botones[1] = true;
		}
		//****************************************
		// Area de opcion de selecion jugador 
		//****************************************
		else if (posX > 20 && posX < 380 && posY > 260 && posY < 295) {
			botones[2] = true;
		}


		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}