package modelo;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Personaje {


	//--------------------------------------
	// Constantes
	//--------------------------------------

	public static final int IZQUIERDA = -1;

	public static final int DERECHA = 1;

	//--------------------------------------
	// Atributos
	//--------------------------------------

	/*
	 * arreglo de las imagenes que puede tener un personaje
	 */
	private String sprite;

	/*
	 * precio en puntos de un personaje
	 */
	private int precio;

	/*
	 * posicion en el componente X del personaje
	 */
	private int posX;

	/*
	 * posicion en el componente Y del personaje
	 */
	private int posY;

	/*
	 * Es el kposSprite[0] del personaje
	 */
	private int ki;

	/*
	 * Es la salud del personaje
	 */
	private int salud;

	/*
	 * Lista de ataque es de un personaje
	 */
	private ArrayList<Ataque> ataques;

	/*
	 * Es un rectangulo que representa el área donde se encuentra el personaje
	 */
	private Rectangle rectangulo;

	/*
	 * Adversario del personaje 
	 */
	private Personaje adversario;

	/*
	 * Ancho del sprite del personaje 
	 */
	private int tamanhoX;

	/*
	 * Alto del sprite del personaje 
	 */
	private int tamanhoY;

	/*
	 * Denota la direccion en la que se esta desplazando el personaje
	 */
	private int direccion;

	/*
	 * arreglo de frames del sprite
	 */
	private int[] posSprite = new int[5];

	/*
	 * boolean que denota el estado en el que se encuentra el personaje; true para quieto y false para cualquier otro movimiento
	 */
	private boolean quieto;
	
	private AtaqueDistancia ataqueDistancia;

	//--------------------------------------
	// Constructor
	//--------------------------------------
	public Personaje(String pSprite, int precio) {

		/*
		 * se inicializa el arreglo de imagenes de las posibles posiciones del personaje
		 */
		sprite = pSprite;

		/*
		 * se fija el precio que tendra el personaje
		 */
		this.precio = precio;

		rectangulo = new Rectangle (posX, posY, tamanhoX, tamanhoY);

		quieto = true;
	}

	//--------------------------------------
	// Metodos
	//--------------------------------------
	public int darPrecio() {
		return precio;
	}

	public int darPosY() {
		return posY;
	}

	public int darPosX() {
		return posX;
	}

	public void cambiarPosX(int newPosX) {
		posX = newPosX;
	}
	public void cambiarPosY(int newPosY) {
		posX = newPosY;
	}

	private Rectangle darRectangulo() {
		return rectangulo;
	}

	/*
	 * Método que informa sposSprite[0] el ataque que recibe como parámetro lo afecto
	 * @param x - La posición en el eje X del ataque
	 * @param y - La posición en el eje Y del ataque
	 */
	public boolean fueGolpeado(int x, int y) {

		return posX< x && x < posX+30 && posY< y && y < posY+50;
	}


	/*
	 * Método encargado de atacar
	 * @param tecla - Corresponde a la representación Unicode de la tecla pulsada
	 */
	public int atacar(int tecla) {

		int efectoAtaque = 0;

//		if(this.rectangulo.intersects(adversario.darRectangulo())) {
//			Ataque temp = new Ataque (tecla);
//			efectoAtaque = temp.darDanho();
//		}
		
		posSprite[1] = 1;
		quieto = false;

		return efectoAtaque;
	}
	
	public int lanzarAtaqueDistante() {
		
		int efectoAtaque = 0;
		
		posSprite[3] = 1;
		quieto = false;
		
		
		
		return efectoAtaque;
		
	}

	public void moverX(int mover) {
		posX+=mover;
		direccion = mover>0? DERECHA:IZQUIERDA;
		
		
		posSprite[2] = posSprite[2] !=0? posSprite[2]:1;
		System.out.println(posSprite[2]);
		quieto = false;
	}

	public void moverY(int mover) {
		posY+=mover;
	}


	//--------------------------------------
	// Metodos Graficos
	//--------------------------------------

	public String darSprite() {

		String aMostrar = "";

		if(quieto) {
			// Se retorna un frame de la animacion del personaje parado
			aMostrar = spriteQuieto();
			
			if (posSprite[2] == 2) {
				posSprite[2] = 3;
				aMostrar = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/moverIzquierda": "/moverDerecha")+"/"+(posSprite[2])+ ".png";
			}

			//**************************************************************
			// Se reinician los frames de cada uno de los otros movimientos
			//**************************************************************
			for (int i = 1; i < posSprite.length; i++) {
				posSprite[i]=0;
			}
		}else if(posSprite[1] != 0) {
			aMostrar = spritePuño();
		}else if(posSprite[2] != 0) {
			aMostrar = spriteMovimiento();
		}else if(posSprite[3] != 0) {
			aMostrar = spriteAtaqueMedDistancia();
		}

		return aMostrar;
	}

	public String spriteQuieto() {
		if(posSprite[0] == -1) {
			posSprite[0] = 1;
		}
		else if(posSprite[0] < 4) {
			posSprite[0]++;
		}else {
			posSprite[0] = -4;
		}

		return "data/Sprites/" + sprite + "/"+ (direccion == IZQUIERDA? "paradoIzquierda": "paradoDerecha") +"/"+(posSprite[0] > 0? posSprite[0] : -posSprite[0] )+ ".png";
	}

	public String spritePuño() {

		String frame = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/puñoIzquierda": "/puñoDerecha")+"/"+(posSprite[1])+ ".png";
		
		posSprite[1]++;
		quieto = false;
		if (posSprite[1] > 6) {
			posSprite[1] = 0;
			quieto = true;
		}

		return frame;
	}
	
	public String spriteMovimiento() {
		
		String frame = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/moverIzquierda": "/moverDerecha")+"/"+(posSprite[2])+ ".png";
	
		posSprite[2] = 2;
		quieto = false;
		
		return frame;
	
	}
	
	public String spriteAtaqueMedDistancia() {
		
		String frame = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/ataqueMedIzquierda": "/ataqueMedDerecha")+"/"+(posSprite[3])+ ".png";
		
		posSprite[3]++;
		quieto = false;
		
		if(posSprite[3] == 6) {
			ataqueDistancia = new AtaqueDistancia(sprite, 1, direccion, posX, posY);
		}
		if (posSprite[3] > 6) {
			posSprite[3] = 0;
			quieto = true;
		}

		return frame;
	
	}
	
	public void quietotrue() {
		quieto = true;
	}
	
	public AtaqueDistancia darAtaqueDistancia() {
		return ataqueDistancia;
	}


}
