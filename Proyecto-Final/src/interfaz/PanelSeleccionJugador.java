package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelSeleccionJugador extends JPanel implements MouseListener {
	
	private VentanaPrincipal ventana;
	
	private String[] personajes = {"data/vistaPreviaPersonajes/Goku.png","data/vistaPreviaPersonajes/GokuRed.png","data/vistaPreviaPersonajes/GokuBlue.png","data/vistaPreviaPersonajes/Gohan.png","data/vistaPreviaPersonajes/Freezer.png","data/vistaPreviaPersonajes/Bardock.png","data/vistaPreviaPersonajes/Broly.png","data/vistaPreviaPersonajes/Beerus.png","data/vistaPreviaPersonajes/KidBuu.png"};
	
	public PanelSeleccionJugador() {
		
		setVisible(true);
		this.ventana = ventana;
		addMouseListener(this);
		
		
	}
	
	@Override
	public void paint(Graphics g) {

		// Cargo la imagen que sera usada como banner para el juego
		Image fondo = new ImageIcon("data/fondo/escenarioJugador.jpg").getImage();
		g.drawImage(fondo, 0, 0,null);
		
		Image personaje = new ImageIcon("data/vistaPreviaPersonajes/Freezer.jpg").getImage();
		g.drawImage(personaje, 350, 110,null);
		
		Image flecha = new ImageIcon("data/fondo/flechaDerecha.png").getImage();
		g.drawImage(flecha, 890, 310, null);
		
		Image flechaIzquierda = new ImageIcon("data/fondo/flechaIzquierda.png").getImage();
		g.drawImage(flechaIzquierda, 290, 310, null);
		
		Image flechaRetorno = new ImageIcon("data/fondo/flechaRetorno.png").getImage();
		g.drawImage(flechaRetorno, 70, 560, null);
		
		Image aceptar = new ImageIcon("data/fondo/aceptar.png").getImage();
		g.drawImage(aceptar, 985, 583, null);
		

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
		
		int posX = e.getX();
		int posY = e.getY();
		
		System.out.println("posX = " +posX + "   PosY = " + posY );
		
		//Cuando oprima sobre la imagen
		
		if(posX > 340 && posX < 625 && posY > 110 && posY < 1000) {
			
			System.out.println("Lol");
			
		}
		
		/*
		//Cuando oprima sobre la imagen siguiente
		else if() {
			
			
		}
		//Cuando oprima sobre el imagen para regresar
		else if() {
			
			
		}
		*/
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
