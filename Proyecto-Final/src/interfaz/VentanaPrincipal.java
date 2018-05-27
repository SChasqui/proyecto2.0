/* Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hilos.HiloAnimaciones;
import hilos.HiloAtaqueDistancia;
import hilos.HiloCreditos;
import hilos.HiloJuego;
import hilos.HiloTiempo;
import modelo.Juego;
import modelo.Jugador;
import modelo.JugadorNoSeleccionadoException;

/*
 * Clase que modela a la ventanaPrincipal
 */
public class VentanaPrincipal extends JFrame{

	//--------------------------------------
	// Relaciones con cada uno de sus paneles.
	//--------------------------------------
	
	/*
	 * Relacion con el panel Seleccion Escenario
	 */
	private PanelSeleccionEscenario pSeleccionEscenario;
	
	/*
	 * Relacion con el panel Selecion jugador
	 */
	private PanelSeleccionJugador pSeleccionJugador;

	/*
	 * Relacion con el Menu principal
	 */
	private PanelMenuPrincipal menuPrincipal;
	
	/*
	 * Relacion con panelJuego
	 */
	private PanelJuego pJuego;
	
	/*
	 * Relacion con el Panel creditos
	 */
	private PanelCreditos pCreditos;
	
	/*
	 * Relacion con el panel puntajes
	 */
	
	private PanelPuntajes pPuntajes;
	/*
	 * Relacion con la clase principal del modelo
	 */
	private Juego juego;
	
	/*
	 * Constructor de la clase. Construye un objeto VentanaPrincipal
	 */

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
		
		pCreditos = new PanelCreditos(this);
		
		pPuntajes = new PanelPuntajes(this);

		pJuego = new PanelJuego(this);
		addKeyListener(pJuego);

	}
	
	/*
	 * Metodo que permite inicializar los hilos necesarios para el funcionamiento del programa
	 */

	public void iniciarHilos() {
		HiloJuego h = new HiloJuego(this, darJuego());
		h.start();
		HiloAtaqueDistancia hD = new HiloAtaqueDistancia(darJuego(),this);
		hD.start();
		HiloAnimaciones hA1 = new HiloAnimaciones(darJuego(),this,1);
		hA1.start();
		HiloAnimaciones hA2 = new HiloAnimaciones(darJuego(),this,2);
		hA2.start();
		HiloTiempo hT = new HiloTiempo(this, juego);
		hT.start();
		HiloCreditos hC = new HiloCreditos(this);
		hC.start();
	}
	
	/*
	 * Metodo que da el PanelJugador
	 */
	public PanelJuego darPanelJuego() {
		return pJuego;
	}
	
	/*
	 * Metodo que da el panelCreditos
	 */

	public PanelCreditos darPanelCreditos() {
		
		return pCreditos;
	}
	
	/*
	 * Metodo que da el PanelJuego
	 */

	public Juego darJuego() {
		return juego;
	}
	
	/*
	 * Metodo que da el panelSeleccionEscenario
	 */

	public PanelSeleccionEscenario getpSeleccionEscenario() {
		return pSeleccionEscenario;
	}
	
	/*
	 * Metodo que da el PanelSeleccionJugador
	 */
	public PanelSeleccionJugador getpSeleccionJugador() {
		return pSeleccionJugador;
	}
	
	/*
	 * Metodo que da el juego (modelo) clase principal del modelo
	 */
	public Juego getJuego() {
			return juego;
	}
	
	/*
	 * Metodo que da el panelMenuPrincipal
	 */
	public PanelMenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}
	
	/*
	 * Metodo que da el boolean dar Muerte comunicando al panel creditos
	 */
	public boolean darMuere() {
		
		return pCreditos.darMuere();
	}
	
	/*
	 * Metodo que permite cambiar el panelSeleccionEscenario
	 */
	public void setpSeleccionEscenario(PanelSeleccionEscenario pSeleccionEscenario) {
		this.pSeleccionEscenario = pSeleccionEscenario;
	}
	
	/*
	 * Metodo que permite cambiar el panelSeleccionJugador
	 */

	public void setpSeleccionJugador(PanelSeleccionJugador pSeleccionJugador) {
		this.pSeleccionJugador = pSeleccionJugador;
	}
	
	/*
	 * Metodo que permite cambiar el Juego
	 */

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	/*
	 * Metodo que permite cambiar el panelMenuPrincipal
	 */

	public void setMenuPrincipal(PanelMenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	
	/*
	 * Metodo que permite cambiar del panelSeleccionEscneario al panelJuego
	 */
	public void cambiarAPanelJuego(int escenario) {
		remove(pSeleccionEscenario);
		try {
			juego.iniciarBatalla(escenario);
			pJuego.cambiarAcabo(false);
			iniciarHilos();
			add(pJuego);
			pJuego.updateUI();
			pJuego.repaint(); pack(); setSize(1280,720);
		} catch (JugadorNoSeleccionadoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Panel no seleccionado", JOptionPane.WARNING_MESSAGE);
			add(menuPrincipal);
		}
	}
	
	/*
	 * Metodo que permite agregar o crear el panelSeleccionEscenario 
	 * Removiendo al panelMenuPrinicipal y añadiendo el panelSeleccionEscenario
	 */

	public void agregarPanelEscenario() {
		remove(menuPrincipal);
		add(pSeleccionEscenario);
		pSeleccionEscenario.updateUI();
		pSeleccionEscenario.repaint(); pack(); setSize(1280,720);
	}
	
	/*
	 * Metodo que permite agregar o crear el panelSeleccionJugador 
	 * Removiendo al panelMenuPrinicipal y añadiendo el panelSeleccionJugador
	 * @param recibe un entero que indica el numero del jugador que se esta agregando ya sea el jugador 1 o 2
	 */
	public void agregarPanelJugador(int i) {
		pSeleccionJugador.cambiarJugador(i);
		SeleccionJugadorDialog s = new SeleccionJugadorDialog(this, i);
	}
	
	public void cambiarJugador(String nombre) {
		remove(menuPrincipal);
		setLayout(new BorderLayout());
		pSeleccionJugador.cambiarJugadorActual();
		add(pSeleccionJugador,BorderLayout.CENTER);
		pSeleccionJugador.updateUI();
		pSeleccionJugador.repaint(); pack(); setSize(1280,720);
	}
	
	/*
	 * Metodo que permite agregar o crear el panelMenuPrincipal 
	 * Removiendo un objeto de tipo JPanel y agregando el panelMenuPrincipal
	 * @Param un Objeto de tipo JPanel
	 */
	public void agregarPanelMenuPrincipal(JPanel a) {
		remove(a);
		add(menuPrincipal);
		pSeleccionJugador.updateUI();
		pSeleccionJugador.repaint(); pack(); setSize(1280,720);
	}
	
	/*
	 * Metodo que permite dar un jugador 
	 * @param entero que indica si el jugador es el 1 o el 2
	 * @return un enetero que indica el jugador que se esta escogiendo
	 */
	
	public Jugador darJugadorIndice(int indice) {
		return indice == 1? juego.darJugador1() : juego.darJugador2();
	}

	
	/*
	 * Metodo que permite agregar el PanelCreditos a la ventana
	 * removiendo el panelMenuPrincipal y añadiendo el panelCreditos
	 */
	public void agregarPanelCreditos() {
		remove(menuPrincipal);
		HiloCreditos h = new HiloCreditos(this);
		pCreditos.cambiarMuere(false);
		h.start();
		add(pCreditos);
		pCreditos.updateUI();
		pCreditos.repaint(); pack(); setSize(1280,720);

	}
	
	/*
	 * Metodo que permite agregar el PanelPuntajes a la ventana
	 * removiendo el panelMenuPrincipal y añadiendo el panelPuntajes
	 */
	
	public void agregarPanelPuntajes() {
		remove(menuPrincipal);
		add(pPuntajes);
		pPuntajes.updateUI();
		pPuntajes.repaint(); pack(); setSize(1280,720);
		
	}
	
	/*
	 * Respectivo Main
	 */
	
	public static void main(String args[]) {
		VentanaPrincipal v = new VentanaPrincipal();
	}
}
