package hilos;

import interfaz.VentanaPrincipal;

public class HiloCreditos extends Thread{
	
	private VentanaPrincipal ventana;
	
	public HiloCreditos(VentanaPrincipal ventana) {
		this.ventana = ventana;
		
	}
	
	public void run(){
		while(ventana.darMuere()) {
			
			
		}
		
	}
}
