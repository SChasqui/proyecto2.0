package interfaz;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelPuntajes extends JPanel {
	
	private VentanaPrincipal ventana;
	
	public PanelPuntajes(VentanaPrincipal ventana) {
		this.ventana = ventana;
		
	}
	
	public void paint(Graphics g) {
		Image fondo = new ImageIcon("data/fondo/diseño.png").getImage();
		g.drawImage(fondo, 0, 0,null);
		
		Image botonBuscar = new ImageIcon("data/fondo/botonBuscar.png").getImage();
		g.drawImage(botonBuscar, 340, 600,null);
		
		Image botonSalir = new ImageIcon("data/fondo/botonSalirNaranja.png").getImage();
		g.drawImage(botonSalir, 950, 600, null);
		
	}
	
}
