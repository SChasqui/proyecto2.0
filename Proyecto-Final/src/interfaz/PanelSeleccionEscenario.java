package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class PanelSeleccionEscenario extends JPanel implements MouseListener{
	//Relaciones
	private VentanaPrincipal ventana;
	
	private int personajeActual;
	
	private String[] fondos;
	
	public PanelSeleccionEscenario(VentanaPrincipal ventana) {
		
		setVisible(true);
		this.ventana = ventana;
		personajeActual = 0;
		fondos =  ventana.darJuego().darFondos();
		addMouseListener(this);
		
	}
	// Vamo a pintar :V 
	@Override
	public void paint(Graphics g) {

		// Cargo la imagen que sera usada como banner para el juego
		Image fondo = new ImageIcon("data/fondo/fondoEscenarios.jpg").getImage();
		g.drawImage(fondo, 0, 0,null);
		
		Image botonIzquierda = new ImageIcon("data/fondo/flechaIzquierda.png").getImage();
		g.drawImage(botonIzquierda, 90, 420, null);
		
		Image botonDerecha = new ImageIcon("data/fondo/flechaDerecha.png").getImage();
		g.drawImage(botonDerecha, 420, 420, null);
		
		pintarFondos(g);
	
	}
	public void pintarFondos(Graphics g) {
		
		ImageIcon iconPatter = (new ImageIcon(fondos[personajeActual]));
		g.drawImage(iconPatter.getImage(),120,130,380,270,null);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int posX = e.getX();
		int posY = e.getY();
		
		//****************************************//
		// Area de opcion de selecion jugador 1
		//****************************************//
		System.out.println("PosX:  " + posX + "  PosY:    " + posY);
		
		if (posX > 93 && posX < 204 && posY > 430 && posY < 563) {
			personajeActual++;
			if(personajeActual == fondos.length) {
				
				personajeActual = 0;
			}
			repaint();
		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		repaint();
		System.out.println("Pase");
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
