/* Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import hilos.HiloCreditos;


/*
 * Creacion de una clase PanelCreditos de tipo Panel e implementando el MouseListener
 */
public class PanelCreditos extends JPanel implements MouseListener {
	
	//--------------------------------------
	// Relaciones
	//--------------------------------------
	
	/*
	 * Relacion con la ventana principal
	 */
	private VentanaPrincipal ventana;
	
	/*
	 * Boolean que indica cuadno muere el hilo
	 */
	private boolean muere;
	
	/*
	 * Entero que indica la posicion de los grafics que la implementen
	 */
	private int posY; 
	
	
	/*
	 * Constructor de la clase PanelCredios
	 */
	public PanelCreditos(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setVisible(true);
		muere = false;
		posY = 0;
		addMouseListener(this);
		
	}
	
	/*
	 * metodo que da el boolean muere
	 * <b> Pre: </b> la variable de tipo boolean ya fue inicializado <br>
	 */
	
	public boolean darMuere() {
		
		return muere;
	}
	
	/*
	 * Metodo que cambia el boolean muere
	 * <b> Pos: </b> La variable de tipo boolean fue cambiada <br>
	 */ 
	public void cambiarMuere(boolean mu) {
		muere = mu;
	}
	
	/*
	 * Metodo principal paint que permite pintar objetos de tipo graphics
	 * @param un objeto de tipo Graphics
	 */
	public void paint(Graphics g) {
		
		Image fondo = new ImageIcon("data/fondo/fondoDragon.jpg").getImage();
		g.drawImage(fondo, 0, 0,null);
		
		pintarMuñecos(g);
		pintarCreditos(g);
	}
	
	/*
	 * Metodo que permite pintar un graphic
	 * @param un objeto de tipo Graphics
	 */
	public void pintarMuñecos(Graphics g) {
		//Image escenario = new ImageIcon("data/vistaPreviaPersonajes/NPE" +i + ".png").getImage();
		//System.out.println("data/fondoEscenario/escenario" + + ".png");
		//g.drawImage(escenario, 0, 0,null);
		Image fondo = new ImageIcon("data/vistaPreviaPersonajes/NPE10.png").getImage();
		g.drawImage(fondo, 0, 0,null);
		
		Image botonSalir = new ImageIcon("data/fondo/salirCreditos.png").getImage();
		g.drawImage(botonSalir, 1050, 600, null);
	
		
	}
	
	/*
	 * Metodo que permite pintar un graphic
	 * @param un objeto de tipo Graphics
	 */
	public void pintarCreditos(Graphics g) {
		Image creditos = new ImageIcon("data/fondo/creditos.png").getImage();
		g.drawImage(creditos, 615, 500 + posY--,null);
		
	}
	/*
	 * Metodo que escucha el evento mouseClicked
	 * @param un objeto de tipo MouseEvent
	 */

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
