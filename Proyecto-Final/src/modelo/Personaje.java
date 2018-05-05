package modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

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
	 * Sprite que pintara el panel
	 */
	private Image frame;

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

		rectangulo = new Rectangle (posX, posY, new ImageIcon(spriteQuieto()).getIconWidth(), new ImageIcon(spriteQuieto()).getIconHeight());

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

	public Rectangle darRectangulo() {
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
		rectangulo.setLocation(posX, posY);

		posSprite[2] = posSprite[2] !=0? posSprite[2]:1;
		quieto = false;
	}

	public void moverY(int mover) {
		posY+=mover;
		rectangulo.setLocation(posX, posY);
	}


	//--------------------------------------
	// Metodos Graficos
	//--------------------------------------

	public Image darSprite() {
		return frame;
	}

	public void actualizar() {

		String aMostrar = "";

		if(quieto) {
			// Se retorna un frame de la animacion del personaje parado
			aMostrar = spriteQuieto();

			if (posSprite[2] == 2) {
				posSprite[2] = 3;
				aMostrar = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/moverIzquierda": "/moverDerecha")+"/"+(posSprite[2])+ ".png";
				rectangulo.setSize(new ImageIcon(aMostrar).getIconWidth(), new ImageIcon(aMostrar).getIconHeight());
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

		frame = new ImageIcon(aMostrar).getImage();
	}

	public String spriteQuieto() {

		File f = new File("data/Sprites/" + sprite + "/paradoDerecha");

		String[] array = f.list();
		//		System.out.println(array.length);

		if(posSprite[0] == -1) {
			posSprite[0] = 1;
		}
		else if(posSprite[0] < array.length) {
			posSprite[0]++;
		}else {
			posSprite[0] = -array.length;
		}

		return "data/Sprites/" + sprite + "/"+ (direccion == IZQUIERDA? "paradoIzquierda": "paradoDerecha") +"/"+(posSprite[0] > 0? posSprite[0] : -posSprite[0] )+ ".png";
	}

	public String spritePuño() {

		File f = new File("data/Sprites/" + sprite + "/puñoIzquierda");
		String[] array = f.list();

		String frame = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/puñoIzquierda": "/puñoDerecha")+"/"+(posSprite[1])+ ".png";

		rectangulo.setSize(new ImageIcon(frame).getIconWidth(), new ImageIcon(frame).getIconHeight());

		posSprite[1]++;
		quieto = false;
		if (posSprite[1] > array.length) {
			posSprite[1] = 0;
			quieto = true;
		}

		return frame;
	}

	public String spriteMovimiento() {

		String frame = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/moverIzquierda": "/moverDerecha")+"/"+(posSprite[2])+ ".png";

		rectangulo.setSize(new ImageIcon(frame).getIconWidth(), new ImageIcon(frame).getIconHeight());

		posSprite[2] = 2;
		quieto = false;

		return frame;

	}
	//
	public String spriteAtaqueMedDistancia() {

		String frame = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/ataqueMedIzquierda": "/ataqueMedDerecha")+"/"+(posSprite[3])+ ".png";

		posSprite[3]++;
		quieto = false;

		if(posSprite[3] == 5) {

			AtaqueDistancia actual = ataqueDistancia;
			if (ataqueDistancia == null) {
				ataqueDistancia = new AtaqueDistancia(sprite, 1, direccion, posX + (100 * direccion) , posY);
			}

			while(actual != null) {
				if (actual.darSiguiente() == null) {
					actual.seleccionarSiguiente( new AtaqueDistancia(sprite, 1, direccion, posX + (100 * direccion) , posY));
					actual = null;
				}else {
					actual = actual.darSiguiente();
				}
			}
		}
		if (posSprite[3] > 6) {
			posSprite[3] = 0;
			quieto = true;
		}

		return frame;

	}

	public void eliminarAtaque(AtaqueDistancia actual) {

		if (actual == null) {

		}else {
			if (ataqueDistancia.darVida() == 0) {
				ataqueDistancia = ataqueDistancia.darSiguiente();
				actual = ataqueDistancia;
			}else {
				if (actual.darSiguiente() != null && actual.darSiguiente().darVida() == 0) {
					actual.seleccionarSiguiente(actual.darSiguiente().darSiguiente());
				}else{
					actual = actual.darSiguiente();
				}
			}
			eliminarAtaque(actual);

		}

	}

	public void limpiarAtaques() {

		eliminarAtaque(ataqueDistancia);

	}

	public void quietotrue() {
		quieto = true;
	}

	public AtaqueDistancia darAtaqueDistancia() {
		return ataqueDistancia;
	}


}
