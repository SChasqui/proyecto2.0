/* Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package interfaz;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * Creacion de la clase PanelPuntajes que extiende de Jpanel e implementa MouseListener
 */
public class PanelPuntajes extends JPanel implements MouseListener{
	
	/*
	 * Relacion con la VentanaPrincipal
	 */
	private VentanaPrincipal ventana;
	
	/*
	 * Constructor de la clase PanelPuntajes
	 * @param recibe a la VentanaPrincipal
	 */
	public PanelPuntajes(VentanaPrincipal ventana) {
		this.ventana = ventana;
		
	}
	
	/*
	 * metodo que permite pintar objetos de tipo Graphics
	 * @param objeto de tipo Graphics
	 */
	public void paint(Graphics g) {
		Image fondo = new ImageIcon("data/fondo/diseño.png").getImage();
		g.drawImage(fondo, 0, 0,null);
		
		Image botonBuscar = new ImageIcon("data/fondo/botonBuscar.png").getImage();
		g.drawImage(botonBuscar, 340, 600,null);
		
		Image botonSalir = new ImageIcon("data/fondo/botonSalirNaranja.png").getImage();
		g.drawImage(botonSalir, 950, 600, null);
		pintarTop10(g);
	}
	
	public void pintarTop10(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 30));
		String[] s = ventana.darJuego().darTopTen();
		for (int i = 0; i < s.length; i++) {
			g.drawString(s[i], 210, 130 + i * 45);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
