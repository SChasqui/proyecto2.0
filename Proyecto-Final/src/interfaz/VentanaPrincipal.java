package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import modelo.Juego;


public class VentanaPrincipal extends JFrame{

	//--------------------------------------
	// Relaciones
	//--------------------------------------
	
	/*
	 * Relcaion con la clase principal del modelo
	 */
	private Juego juego;
	
	/*
	 * Relacion con el Menu principal
	 */
	private PanelMenuPrincipal menuPrincipal;
	
	private PanelPruebas pPruebas;

	public VentanaPrincipal() {

		setLayout(new BorderLayout());
		setVisible(true);
		setSize(1280, 720);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		menuPrincipal = new PanelMenuPrincipal(this);
		add(menuPrincipal,BorderLayout.CENTER);
		
		
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
	
}
