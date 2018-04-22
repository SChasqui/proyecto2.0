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

import hilos.HiloAtaqueDistancia;
import hilos.HiloPruebas;

/*
 * Clase que sirve para probar los métodos del modelo del mundo
 */
public class PanelPruebas extends JDialog implements KeyListener{
	
	//--------------------------------------
	// Constantes.
	//--------------------------------------
	public final static int FLECHA_ARRIBA = 40;
	public final static int	FLECHA_DERECHA = 39;
	public final static int	FLECHA_ABAJO = 38;
	public final static int FLECHA_IZQUIERDA = 37;
	public static final int NUMERO_UNO= 97;
	public static final int NUMERO_DOS= 98;
	
	private boolean ataqueActivo;
	
	private final Set<Integer> pressed = new HashSet<Integer>();
	
	//--------------------------------------
	// Relaciones
	//--------------------------------------
	/*
	 * Relación con la ventana principal
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
		setSize(1280, 720);
		
		
		HiloPruebas h = new HiloPruebas(this);
		h.start();
		
		HiloAtaqueDistancia hD = new HiloAtaqueDistancia(this, ventana.darJuego());
		hD.start();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		ImageIcon fondo = new ImageIcon("data/fondoEcenario/F03.png");
		g.drawImage(fondo.getImage(), 0, 0, null);

		ImageIcon sprite = new ImageIcon(ventana.darJuego().darJugador1().darPersonaje().darSprite());
		g.drawImage(sprite.getImage(), ventana.darJuego().darJugador1().darPersonaje().darPosX(), ventana.darJuego().darJugador1().darPersonaje().darPosY(), null);
		
		if(ataqueActivo) {
			System.out.println(ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia());
			ImageIcon spriteAtaque = new ImageIcon(ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia().darSprite());
			g.drawImage(spriteAtaque.getImage(), ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia().darPosx(), ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia().darPosY(), null);
			System.out.println("Pos x: " + ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia().darPosx());
		}
		
	}
	
	@Override
    public synchronized void keyPressed(KeyEvent e) {
        pressed.add(e.getKeyCode());
        if (pressed.size() > 0) {
          for (int c : pressed){
        	  
        	  if(c == FLECHA_IZQUIERDA) {
     			 ventana.darJuego().darJugador1().darPersonaje().moverX(-12);
     		 }else if(c == FLECHA_ABAJO) {
     			 ventana.darJuego().darJugador1().darPersonaje().moverY(-12);
     		 }else if(c == FLECHA_DERECHA) {
     			 ventana.darJuego().darJugador1().darPersonaje().moverX(12);
     		 }else if(c == FLECHA_ARRIBA) {
     			 ventana.darJuego().darJugador1().darPersonaje().moverY(12);
     		 }else if(c == NUMERO_UNO) {
     			 ventana.darJuego().darJugador1().darPersonaje().atacar(c);
     		 }else if(c == NUMERO_DOS) {
     			ventana.darJuego().darJugador1().darPersonaje().lanzarAtaqueDistante();
     			if(ventana.darJuego().darJugador1().darPersonaje().darAtaqueDistancia() != null) {
     				ataqueActivo = true;
     				
     			}
     		 }
        	  
        	  
          }
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        pressed.remove(e.getKeyCode());
        
        int c = e.getKeyCode();
        
        if(c == FLECHA_IZQUIERDA) {
			 ventana.darJuego().darJugador1().darPersonaje().quietotrue();
		 }else if(c == FLECHA_DERECHA) {
			 ventana.darJuego().darJugador1().darPersonaje().quietotrue();
		 }
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {/* Not used */ }

	
}
