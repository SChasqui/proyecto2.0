package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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

		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ventana = v;
		lista = new JList<String>(v.darJuego().darJugadoresActuales());
		this.numJugador = numJugador;
		setVisible(true);
		
		scroll = new JScrollPane(lista);
		
		txtNuevoJugador = new JTextField("si no ve su nickName incertelo aqui y precione agregar");
		btAgregar = new JButton("agregar");
		btAgregar.setActionCommand(AGREGAR);
		btAgregar.addActionListener(this);
		
		btSeleccionar = new JButton("Selecionar");
		
		//***********************************************
		// Crear Panel de botones
		//***********************************************
		panelBotones = new JPanel();
		panelBotones.setLayout(new BorderLayout());
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
