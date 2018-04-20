package hilos;

import interfaz.PanelPruebas;

public class HiloPruebas extends Thread{
	
	PanelPruebas panel;
	
	public HiloPruebas(PanelPruebas p) {
		panel = p;
	}
	
	@Override
	public void run() {
		while (true) {

			panel.repaint();
			try {
				sleep(170);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
