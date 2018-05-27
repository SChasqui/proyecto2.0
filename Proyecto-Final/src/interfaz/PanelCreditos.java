package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import hilos.HiloCreditos;

public class PanelCreditos extends JPanel implements MouseListener {
	
	private VentanaPrincipal ventana;
	
	private boolean muere;
	
	private int posY; 
	
	public PanelCreditos(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setVisible(true);
		muere = false;
		posY = 0;
		addMouseListener(this);
		
	}
	
	public boolean darMuere() {
		
		return muere;
	}
	
	public void cambiarMuere(boolean mu) {
		muere = mu;
	}
	
	public void paint(Graphics g) {
		
		Image fondo = new ImageIcon("data/fondo/fondoDragon.jpg").getImage();
		g.drawImage(fondo, 0, 0,null);
		
		pintarMuñecos(g);
		pintarCreditos(g);
	}
	
	public void pintarMuñecos(Graphics g) {
		//Image escenario = new ImageIcon("data/vistaPreviaPersonajes/NPE" +i + ".png").getImage();
		//System.out.println("data/fondoEscenario/escenario" + + ".png");
		//g.drawImage(escenario, 0, 0,null);
		Image fondo = new ImageIcon("data/vistaPreviaPersonajes/NPE10.png").getImage();
		g.drawImage(fondo, 0, 0,null);
		
		Image botonSalir = new ImageIcon("data/fondo/salirCreditos.png").getImage();
		g.drawImage(botonSalir, 1050, 600, null);
	
		
	}
	public void pintarCreditos(Graphics g) {
		Image creditos = new ImageIcon("data/fondo/creditos.png").getImage();
		g.drawImage(creditos, 615, 500 + posY--,null);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		int posX = arg0.getX();
		int posY = arg0.getY();
	
		if((posX >= 1051 && posX <= 1250) && (posY >=602 && posY <= 646)) {
			setVisible(false);
			ventana.agregarPanelMenuPrincipal(this);
			
		}
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
