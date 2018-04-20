package interfaz;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelSeleccionJugador extends JPanel {
	
	private VentanaPrincipal ventana;
	
	public PanelSeleccionJugador() {
		
		setVisible(true);
		this.ventana = ventana;
		
	}
	
	@Override
	public void paint(Graphics g) {

		// Cargo la imagen que sera usada como banner para el juego
		Image fondo = new ImageIcon("data/fondo/escenarioJugador.jpg").getImage();
		g.drawImage(fondo, 0, 0,null);
		Image personaje = new ImageIcon("data/vistaPreviaPersonajes/Gohan.jpg").getImage();
		g.drawImage(personaje, 390, 110,null);
	}

}
