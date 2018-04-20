package interfaz;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.ImageIcon;

public class PanelSeleccionEscenario extends JDialog implements MouseListener{
	//Relaciones
	private VentanaPrincipal ventana;
	public PanelSeleccionEscenario(VentanaPrincipal ventana) {
		
		this.ventana = ventana;
		
	}
	
	@Override
	public void paint(Graphics g) {

		// Cargo la imagen que sera usada como banner para el juego
		Image fondo = new ImageIcon("data/fondo/escenarioEscenario.jpg").getImage();
		g.drawImage(fondo, 0, 0,null);
		ventana.getpSeleccionEscenario();
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
