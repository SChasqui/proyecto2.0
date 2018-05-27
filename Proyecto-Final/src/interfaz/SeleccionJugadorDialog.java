package interfaz;

import javax.swing.JDialog;
import javax.swing.JList;

public class SeleccionJugadorDialog extends JDialog {
	
	private VentanaPrincipal ventana;
	private JList<String> lista;
	
	public SeleccionJugadorDialog(VentanaPrincipal v) {

		ventana = v;
		lista = new JList<String>();
		setVisible(true);
		
	}

}
