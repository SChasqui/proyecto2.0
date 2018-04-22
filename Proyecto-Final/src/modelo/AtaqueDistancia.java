package modelo;

public class AtaqueDistancia extends Ataque{
	

	
	/*
	 * Hace referencia al "ancho" del ataque
	 */
	private int ancho;
	
	int i = 1;
	
	/*
	 * Vida del ataque
	 */
	private int vida = 50;
	
	public AtaqueDistancia (String personaje, int direccion,  int tipoAtaque, int posX, int posY ) {
		super(personaje, direccion, tipoAtaque, posX, posY);
		
	}


	public int darAncho() {
		return ancho;
	}

	public void cambiarAncho(int ancho) {
		this.ancho = ancho;
	}
	
	public void moverX() {
		System.out.println(super.darDireccion());
		posX += (super.darDireccion()  == 1) ? 15: -15; 
		vida--;
	}
	
	public int darVida() {
		return vida;
	}
	
	public String darSprite() {
		
		if(i!= 4 && i!=-4) {
			
			if(i == -1) {
				i = 1;
			}
			else if(i < 4) {
				i++;
			}else {
				i = -4;
			}
		}
		
		return "data/Sprites/" + super.darPersonaje() + "/"+ (darDireccion() == Personaje.IZQUIERDA? "ataqueMedianoIzquierda": "ataqueMedianoDerecha") +"/"+(i > 0? i : -i)+".png";
	}
	
}	
