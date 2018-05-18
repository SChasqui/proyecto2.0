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
import javax.swing.JPanel;

import modelo.Juego;


public class VentanaPrincipal extends JFrame{

	//--------------------------------------
	// Relaciones.
	//--------------------------------------
	private PanelSeleccionEscenario pSeleccionEscenario;
	
	private PanelSeleccionJugador pSeleccionJugador;
	
	private JPanel panelAuxiliar;
	/*
	 * Relacion con el Menu principal
	 */
	private PanelMenuPrincipal menuPrincipal;
	
	private PanelPruebas pPruebas;
	/*
	 * Relacion con la clase principal del modelo
	 */
	private Juego juego;

	public VentanaPrincipal() {

		setLayout(new BorderLayout());
		setVisible(true);
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panelAuxiliar = new JPanel();
		menuPrincipal = new PanelMenuPrincipal(this);
		panelAuxiliar.setLayout(new BorderLayout());
		panelAuxiliar.add(menuPrincipal);
		
		add(panelAuxiliar,BorderLayout.CENTER);
		
		pSeleccionEscenario = new PanelSeleccionEscenario(this);
		
		pSeleccionJugador = new PanelSeleccionJugador(this,0);
		
//		pPruebas = new PanelPruebas(this);
		
		
		juego = new Juego();

	}

	public static void main(String args[]) {

		VentanaPrincipal v = new VentanaPrincipal();

	}
	
	public void crearPanelPruebas() {
		pPruebas = new PanelPruebas(this);
	}
	
	public PanelPruebas darPanelPruenas() {
		return pPruebas;
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

	public PanelPruebas getpPruebas() {
		return pPruebas;
	}

	public void setpPruebas(PanelPruebas pPruebas) {
		this.pPruebas = pPruebas;
	}

	public void agregarPamelEcenario() {
		System.out.println("Pase");
		panelAuxiliar.removeAll();
		panelAuxiliar.add(pSeleccionEscenario);
		pSeleccionEscenario.updateUI();
		pSeleccionEscenario.repaint();
		repaint();
	}
	
	public void agregarPanelJugador(int i) {
		
		panelAuxiliar.removeAll();
		pSeleccionJugador.cambiarJugador(i);
		panelAuxiliar.add(pSeleccionJugador);
		pSeleccionJugador.updateUI();
		pSeleccionJugador.repaint();
		repaint();
	}
	
	public void agregarPanelMenuPrincipal() {
		panelAuxiliar.removeAll();
		panelAuxiliar.add(menuPrincipal);
		pSeleccionJugador.updateUI();
		pSeleccionJugador.repaint();
		repaint();
	}
}
