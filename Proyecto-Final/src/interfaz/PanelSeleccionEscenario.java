/* Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

/*
 * Clase que modela al PanelSeleccionEscenario que extiende e implementa MouseListener
 */
public class PanelSeleccionEscenario extends JPanel implements MouseListener{
	
	//Constantes
	
	/*
	 * Constante que indica el numero de Escenarios que iene el juego
	 */
	public final static int NUM_ESCENARIOS = 6;
	
	/*
	 * Variable de tipo int que indica el indice del escenarioActual
	 */
	private int escenarioActual;
	//Relaciones
	
	/*
	 * Relacion con la ventanaPrincipal
	 */
	private VentanaPrincipal ventana;
	
	/*
	 * Constructor de la clase PanelSeleccionEscenario
	 */
	public PanelSeleccionEscenario(VentanaPrincipal ventana) {
		
		setVisible(true);
		this.ventana = ventana;
		escenarioActual = 1;
		addMouseListener(this);
		
	}
	/*
	 * Metodo principal que pinta un objetos de tipo Graphics
	 * @param un objeto de tipo Graphics
	 */
	@Override
	public void paint(Graphics g) {

		// Cargo la imagen que sera usada como banner para el juego
		Image fondo = new ImageIcon("data/fondo/fondoEscenarios.jpg").getImage();
		g.drawImage(fondo, 0, 0,null);
		

		pintarFondos(g);
		
		Image botonIzquierda = new ImageIcon("data/fondo/flechaIzquierda.png").getImage();
		g.drawImage(botonIzquierda, 90, 420, null);
		
		Image botonDerecha = new ImageIcon("data/fondo/flechaDerecha.png").getImage();
		g.drawImage(botonDerecha, 420, 420, null);
		
	
	}
	
	/*
	 * Metodo que pinta un objetos de tipo Graphics
	 * @param un objeto de tipo Graphics
	 */
	public void pintarFondos(Graphics g) {
		
		Image escenario = new ImageIcon("data/fondoEscenario/escenario" +escenarioActual + ".png").getImage();
		g.drawImage(escenario, 0, 0,null);
		
	}
	
	/*
	 * Metodo que escucha el evento MouseClicked
	 * @param un objeto de tipo MouseEvent
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int posX = e.getX();
		int posY = e.getY();
		
		//****************************************//
		// Area de opcion de selecion jugador 1
		//****************************************//		
		if (posX > 93 && posX < 204 && posY > 430 && posY < 563) {
			if((escenarioActual -1 > 0)) {escenarioActual--;}
			else { escenarioActual = NUM_ESCENARIOS;}
			
			repaint();
		}else if(posX > 420 && posX < 540 && posY > 480 && posY < 564) {
			
			escenarioActual++;
			if(escenarioActual  > NUM_ESCENARIOS) {escenarioActual = 1;}
			
			repaint();
		}else {
			ventana.cambiarAPanelJuego(escenarioActual);
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
