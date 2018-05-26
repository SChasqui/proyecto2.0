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
		Image fondo = new ImageIcon("data/fondo/fondoEscenarios.jpg").getImage();
		g.drawImage(fondo, 0, 0,null);
		
	}
	
}
