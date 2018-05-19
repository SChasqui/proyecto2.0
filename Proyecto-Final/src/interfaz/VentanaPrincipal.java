package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Juego;
import modelo.JugadorNoSeleccionadoException;


public class VentanaPrincipal extends JFrame{

	//--------------------------------------
	// Relaciones.
	//--------------------------------------
	private PanelSeleccionEscenario pSeleccionEscenario;
	
	private PanelSeleccionJugador pSeleccionJugador;
	
//	private JPanel panelAuxiliar;
	/*
	 * Relacion con el Menu principal
	 */
	private PanelMenuPrincipal menuPrincipal;
	
	private PanelJuego pJuego;
	/*
	 * Relacion con la clase principal del modelo
	 */
	private Juego juego;

	public VentanaPrincipal() {
		
		juego = new Juego();

		setLayout(new BorderLayout());
		setVisible(true);
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menuPrincipal = new PanelMenuPrincipal(this);
		
		add(menuPrincipal,BorderLayout.CENTER);
		
		pSeleccionJugador = new PanelSeleccionJugador(this,0);
		
		pSeleccionEscenario = new PanelSeleccionEscenario(this);
		
		pJuego = new PanelJuego(this);
		addKeyListener(pJuego);
		
	}

	public static void main(String args[]) {

		VentanaPrincipal v = new VentanaPrincipal();

	}
	
	public Juego darJuego() {
		return juego;
	}
	
	public PanelSeleccionEscenario getpSeleccionEscenario() {
		return pSeleccionEscenario;
	}

	public void setpSeleccionEscenario(PanelSeleccionEscenario pSeleccionEscenario) {
		this.pSeleccionEscenario = pSeleccionEscenario;
	}

	public PanelSeleccionJugador getpSeleccionJugador() {
		return pSeleccionJugador;
	}

	public void setpSeleccionJugador(PanelSeleccionJugador pSeleccionJugador) {
		this.pSeleccionJugador = pSeleccionJugador;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	


	public PanelMenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(PanelMenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public void agregarPanelEscenario() {
		remove(menuPrincipal);
		add(pSeleccionEscenario);
		pSeleccionEscenario.updateUI();
		pSeleccionEscenario.repaint();
	}
	
	public void agregarPanelJugador(int i) {
		remove(menuPrincipal);
		setLayout(new BorderLayout());
		pSeleccionJugador.cambiarJugador(i);
		getContentPane().add(pSeleccionJugador,BorderLayout.CENTER);
		pSeleccionJugador.updateUI();
		pSeleccionJugador.repaint();
	}
	
	public void agregarPanelMenuPrincipal(JPanel a) {
		remove(a);
		add(menuPrincipal);
		pSeleccionJugador.updateUI();
		pSeleccionJugador.repaint();
	}

	public void cambiarAPanelJuego(int escenario) {
		remove(pSeleccionEscenario);
		try {
			juego.iniciarBatalla(escenario);
		} catch (JugadorNoSeleccionadoException e) {
			e.printStackTrace();
		}
		pJuego.iniciarHilos();
		pJuego.cambiarAcabo(true);
		add(pJuego);
		pJuego.updateUI();
		pJuego.repaint();
	}
}
