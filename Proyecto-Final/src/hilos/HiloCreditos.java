package hilos;

import interfaz.VentanaPrincipal;

public class HiloCreditos extends Thread{
	
	private VentanaPrincipal ventana;
	
	public HiloCreditos(VentanaPrincipal ventana) {
		this.ventana = ventana;
		
	}
	
	public void run(){
		while(ventana.darMuere()) {
			ventana.darPanelCreditos().repaint();
			System.out.println("Hola");
			
		}try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ventana.repaint();
		
	}
}
