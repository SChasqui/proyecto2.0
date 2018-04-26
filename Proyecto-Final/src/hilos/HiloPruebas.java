package hilos;

import interfaz.PanelPruebas;

public class HiloPruebas extends Thread{
	
	PanelPruebas panel;
	
	/*
	 * Holamundosa
	 */
	public HiloPruebas(PanelPruebas p) {
		panel = p;
	}
	
	
	@Override
	public void run() {
		while (true) {

			panel.repaint();
			try {
				sleep(83);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
