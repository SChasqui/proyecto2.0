package hilos;

import interfaz.VentanaPrincipal;

public class HiloCreditos extends Thread{
	
	private VentanaPrincipal ventana;
	
	private int contador;
	
	public HiloCreditos(VentanaPrincipal ventana) {
		this.ventana = ventana;
		
	}
	
	public void run(){
		while(!ventana.darMuere()) {
			ventana.darPanelCreditos().repaint();
			
		}try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ventana.repaint();
		
	}
}
