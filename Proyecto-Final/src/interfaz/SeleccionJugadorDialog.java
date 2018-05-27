/* Dragon battle PCS
 * @author Carlos Eduardo lizalda valencia
 * @author Paola Andrea Veloza
 * @author Santiago Chasqui
 * @version 0.1B
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/*
 * Clase que modela el JDialog SeleccionJugadorDialog e implementa ActionListener
 */
public class SeleccionJugadorDialog extends JDialog implements ActionListener{
	
	/*
	 * Relacion con la ventana principal
	 */
	private VentanaPrincipal ventana;
	/*
	 * Declaracion del objeto de tipo JList<String>
	 */
	private JList<String> lista;
	/*
	 * Declaracion del obeto txtNuevoJugador de tipo JTextField
	 */
	private JTextField txtNuevoJugador;
	/*
	 * Declaracion del scroll
	 */
	private JScrollPane scroll;
	
	/*
	 * Declaracion del boton agregar
	 */
	private JButton btAgregar;
	/*
	 * Declaracion del boton Seleccionar
	 */
	private JButton btSeleccionar;
	/*
	 * Declaracion del panelBotones
	 */
	private JPanel panelBotones;
	
	/*
	 * Variable de tipo int que indica el numero del jugador
	 */
	private int numJugador;
	//Constantes
	
	/*
	 * Constante del boton Agregar
	 */
	public static final String AGREGAR = "agrege";
	/*
	 * Constante del boton Seleccionar
	 */
	public static final String SELECCIONAR = "seleccione";

	/*
	 * Constructor de la clase SeleccionJugadorDialog
	 * @param Objeto de tipo VentanaPrincipal
	 * @param int que indica el numero del jugador
	 */
	public SeleccionJugadorDialog(VentanaPrincipal v, int numJugador) {

		setTitle("Seleccionar Jugador");

		setSize(500, 500);

		setLayout(new BorderLayout());
		ventana = v;
		lista = new JList<String>(v.darJuego().darJugadoresActuales());
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.setLayoutOrientation(JList.VERTICAL_WRAP);
		lista.setVisibleRowCount(-1);
		this.numJugador = numJugador;
		setVisible(true);

		scroll = new JScrollPane(lista);

		txtNuevoJugador = new JTextField("Si no ve su nickName insertelo aqui y presione agregar");
		btAgregar = new JButton("Agregar");
		btAgregar.setActionCommand(AGREGAR);
		btAgregar.addActionListener(this);

		btSeleccionar = new JButton("Selecionar");
		btSeleccionar.addActionListener(this);
		btSeleccionar.setActionCommand(SELECCIONAR);

		//***********************************************
		// Crear Panel de botones
		//***********************************************
		panelBotones = new JPanel();
		panelBotones.setLayout(new BorderLayout());
		panelBotones.add(btSeleccionar, BorderLayout.SOUTH);
		panelBotones.add(txtNuevoJugador,BorderLayout.CENTER);
		panelBotones.add(btAgregar,BorderLayout.EAST);
		//***********************************************

		add(panelBotones,BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);

	}
	
	/*
	 * Metodo que escucha el evento ActionPerformed
	 * @param objeto de tipo ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		
		if (comando.equals(AGREGAR)) {
			remove(scroll);
			ventana.darJuego().agregarJugadores(txtNuevoJugador.getText(), numJugador);
			lista = new JList<String>(ventana.darJuego().darJugadoresActuales());
			lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			lista.setLayoutOrientation(JList.VERTICAL_WRAP);
			lista.setVisibleRowCount(-1);
			lista.setFont(new Font("Arial", Font.ITALIC, 40));
			scroll = new JScrollPane(lista);
			add(scroll, BorderLayout.CENTER);
			pack();
			setSize(500, 500);
		}else {
			ventana.cambiarJugador(lista.getSelectedValue());
			dispose();
		}

	}

}
