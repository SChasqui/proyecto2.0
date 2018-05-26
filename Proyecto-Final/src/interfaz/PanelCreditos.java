package interfaz;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelCreditos extends JPanel  {
	
	private boolean muere;
	
	public PanelCreditos() {
		
		setVisible(true);
		muere = true;
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		Image fondo = new ImageIcon("data/fondo/fondoCreditos.png").getImage();
		g.drawImage(fondo, 0, 0,null);
		
		pintarMuñecos(g);
		pintarCreditos(g);
	}
	
	public void pintarMuñecos(Graphics g) {
		//Image escenario = new ImageIcon("data/vistaPreviaPersonajes/NPE" +i + ".png").getImage();
		//System.out.println("data/fondoEscenario/escenario" + + ".png");
		//g.drawImage(escenario, 0, 0,null);
		Image fondo = new ImageIcon("data/vistaPreviaPersonajes/NPE5.png").getImage();
		g.drawImage(fondo, 0, 0,null);
		g.getFont().drawString(0, 0, "Lero");
	}
	public void pintarCreditos(Graphics g) {
		Image fondo = new ImageIcon("data/fondo/creditos.png").getImage();
		g.drawImage(fondo, 640, 0,null);
		
	}
	
		
		
	
}
