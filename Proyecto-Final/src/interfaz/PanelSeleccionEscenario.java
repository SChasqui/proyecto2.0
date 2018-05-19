package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class PanelSeleccionEscenario extends JPanel implements MouseListener{
	
	//Constantes
	public final static int NUM_ESCENARIOS = 6;
	
	//Relaciones
	private VentanaPrincipal ventana;
	private int escenarioActual;
	private PanelJuego pJuego;
	
	
	
	public PanelSeleccionEscenario(VentanaPrincipal ventana) {
		
		setVisible(true);
		this.ventana = ventana;
		escenarioActual = 1;
		addMouseListener(this);
		
	}
	// Vamo a pintar :V 
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
	public void pintarFondos(Graphics g) {
		
		Image escenario = new ImageIcon("data/fondoEscenario/escenario" +escenarioActual + ".png").getImage();
		System.out.println("data/fondoEscenario/escenario" +escenarioActual + ".png");
		g.drawImage(escenario, 0, 0,null);
		
//		ImageIcon iconPatter = (new ImageIcon(fondos[escenarioActual]));
//		g.drawImage(iconPatter.getImage(),120,130,380,270,null);
		
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
			if((escenarioActual -1 > 0)) {escenarioActual--;}
			else { escenarioActual = NUM_ESCENARIOS;}
			
			repaint();
		}else if(posX > 420 && posX < 540 && posY > 480 && posY < 564) {
			
			escenarioActual++;
			if(escenarioActual  > NUM_ESCENARIOS) {escenarioActual = 1;}
			
			repaint();
		}else {
			pJuego = new PanelJuego(ventana, escenarioActual);
//			ventana.darJuego().cambiarFondoActual(escenarioActual);
			System.out.println(ventana.darJuego().darFondoActual());
			ventana.getPanelAuxiliar().removeAll();
			ventana.getPanelAuxiliar().add(pJuego);
			pJuego.updateUI();
			pJuego.repaint();
			ventana.repaint();
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
