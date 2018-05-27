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

public class SeleccionJugadorDialog extends JDialog implements ActionListener{

	private VentanaPrincipal ventana;
	private JList<String> lista;
	private JTextField txtNuevoJugador;
	private JScrollPane scroll;
	private JButton btAgregar;
	private JButton btSeleccionar;
	private JPanel panelBotones;
	private int numJugador;

	public static final String AGREGAR = "agrege";
	public static final String SELECCIONAR = "seleccione";

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
		}

	}

}
