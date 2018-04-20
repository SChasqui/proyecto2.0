package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import hilos.HiloPruebas;

/*
 * Clase que sirve para probar los m�todos del modelo del mundo
 */
public class PanelPruebas extends JDialog implements KeyListener{
	
	//--------------------------------------
	// Constantes
	//--------------------------------------
	public final static int FLECHA_ARRIBA = 40;
	public final static int	FLECHA_DERECHA = 39;
	public final static int	FLECHA_ABAJO = 38;
	public final static int FLECHA_IZQUIERDA = 37;
	
	
	private final Set<Integer> pressed = new HashSet<Integer>();
	
	//--------------------------------------
	// Relaciones
	//--------------------------------------
	/*
	 * Relaci�n con la ventana principal
	 */
	private VentanaPrincipal ventana;
	
	
	//--------------------------------------
	// Constructor
	//--------------------------------------
	public PanelPruebas(VentanaPrincipal v) {
		
		ventana = v;
		addKeyListener(this);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(300, 400);
		
		
		HiloPruebas h = new HiloPruebas(this);
		h.start();
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 700, 400);	
		
		ImageIcon sprite = new ImageIcon(ventana.darJuego().darJugador1().darPersonaje().darSprite());
		g.drawImage(sprite.getImage(), ventana.darJuego().darJugador1().darPersonaje().darPosX(), ventana.darJuego().darJugador1().darPersonaje().darPosY(), null);
		
	}
	
	@Override
    public synchronized void keyPressed(KeyEvent e) {
        pressed.add(e.getKeyCode());
        System.out.println((int)e.getKeyChar()+" ");
        if (pressed.size() > 0) {
          for (int c : pressed){
        	  
        	  if(c == FLECHA_IZQUIERDA) {
     			 ventana.darJuego().darJugador1().darPersonaje().moverX(-4);
     		 }else if(c == FLECHA_ABAJO) {
     			 ventana.darJuego().darJugador1().darPersonaje().moverY(-4);
     		 }else if(c == FLECHA_DERECHA) {
     			 ventana.darJuego().darJugador1().darPersonaje().moverX(4);
     		 }else if(c == FLECHA_ARRIBA) {
     			 ventana.darJuego().darJugador1().darPersonaje().moverY(4);
     		 }
        	  
        	  
          }
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        pressed.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {/* Not used */ }

	
}
