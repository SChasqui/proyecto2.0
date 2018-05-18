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

	//****** Constantes de direccion*********//
	public static final int IZQUIERDA = -1;
	public static final int DERECHA = 1;
	
	//***** Constantes de Atributos *************//
	public static final int VIDA_BASE = 1000;
	public static final int KI_BASE = 300;
	public static final int VELOCIDAD_BASE = 160;
	public static final int RESISTENCIA_BASE = 100;
	public static final int FUERZA_BASE = 100;
	
	/*
	 * Informacion
	 * [0][j] ----> Bardock --> 800P
	 * [1][j] ----> Beerus --> 1000P
	 * [2][j] ----> Broly --> 1000P
	 * [3][j] ----> Frieza --> 900P
	 * [4][j] ----> GohanSSJ_Kid --> 1000P
	 * [5][j] ----> Goku --> 800P
	 * [6][j] ----> Goku_Blue --> 900P
	 * [7][j] ----> Goku_Red --> 1000P
	 * [8][j] ----> Kid_Buu --> 1000P
	 * [9][j] ----> Vegeta --> 900P 
	 * 
	 *===============================================================*
	 *
	 * [i][0] ----> multiplicador de Vida
	 * [i][1] ----> multiplicador de Ki
	 * [i][2] ----> multiplicador de Velocidad
	 * [i][3] ----> multiplicador de Fuerza
	 * [i][4] ----> multiplicador de Resistencia
	 * La suma de los multiplicadores por su respectivo
	 * atributo base da entre 800 y 1000 puntos de habilidad para cada personaje
	 */
	
	public static final double[][] MATRIZ_DE_MULTIPLICADORES= {/*Bardock*/{1,1,1.5,2,1.2},
			/*Beerus*/{1,1.4,1.6,1.6,1.2}, /*Broly*/{1.6,1.1,0.6,2,1}, /*Frieza*/{1,1.3,1.3,1.2,1.09},
			/*GohanSSJ_Kid*/{1.2,1.2,1.4,1.3,1.23}, /*Goku*/{1,1,1.3,1.2,0.99}, 
			/*Goku_Blue*/{1.1,1.1,1.3,1.4,1.29}, /*Goku_Red*/{1.4,1.2,1.4,1.4,1.33},
			/*Kid_Buu*/{1.4,1.2,1.4,1.5,1.23}, /*Vegeta*/{1.2,1.1,1.3,1.3,1.19} };
	
	//--------------------------------------
	// Atributos
	//--------------------------------------
	
	/*
	 * indice del Personaje en la matriz de multiplicadores
	 */
	private int indicePersonaje;

	/*
	 * boolean que representa si esta atacando o no
	 */
	private boolean atacando;

	/*
	 * Sprite que pintara el panel
	 */
	private Image frame;

	/*
	 * arreglo de las imagenes que puede tener un personaje
	 */
	private String personaje;

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
	 * Resistencia del personaje
	 */
	private int resistencia;
	
	/*
	 * Velocidad del Persoaneje
	 */
	private int velocidad;
	
	/*
	 * Fuerza del Personaje
	 */
	private int fuerza;

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

	//--------------------------------------
	// Información
	//--------------------------------------
	/*	- posSprite[0] ---> Corresponde al sprite parado.
	 * 	- posSprite[1] ---> Corresponde al sprite moverse.
	 * 	- posSprite[2] ---> Corresponde al sprite del puño.
	 * 	- posSprite[3] ---> Corresponde al sprite del ataque mediano.
	 * 	- posSprite[4] ---> Corresponde al sprite parado.
	 *  - posSprite[5] ---> Corresponde al sprite parado.
	 *
	 */

	private AtaqueDistancia ataqueDistancia;

	private Sprite sprite;

	//--------------------------------------
	// Constructor
	//--------------------------------------
	public Personaje(String pSprite, int precio, int indice) {
		
		indicePersonaje = indice;

		/*
		 * se inicializa el arreglo de imagenes de las posibles posiciones del personaje
		 */
		personaje = pSprite;

		sprite = new Sprite(pSprite);

		/*
		 * se fija el precio que tendra el personaje
		 */
		this.precio = precio;

		posX += (int)(Math.random() * 1000);
		posY += (int)(Math.random() * 500);

		rectangulo = new Rectangle (posX, posY, new ImageIcon(spriteQuieto()).getIconWidth(), new ImageIcon(spriteQuieto()).getIconHeight());

		quieto = true;

		salud = (int) (VIDA_BASE * MATRIZ_DE_MULTIPLICADORES[indicePersonaje][0]);
		
		ki = (int) (KI_BASE * MATRIZ_DE_MULTIPLICADORES[indicePersonaje][1]);
		
		velocidad = (int) (VELOCIDAD_BASE/ MATRIZ_DE_MULTIPLICADORES[indicePersonaje][2]);
		
		fuerza = (int) (FUERZA_BASE * MATRIZ_DE_MULTIPLICADORES[indicePersonaje][3]);
		
		resistencia = (int) (RESISTENCIA_BASE * MATRIZ_DE_MULTIPLICADORES[indicePersonaje][4]);
		
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
	public void atacar(int tecla) {
		posSprite[1] = 0;
		quieto = false;
	}

	public void lanzarAtaqueDistante() {
		posSprite[3] = 0;
		quieto = false;
	}

	public void moverX(int mover) {
		
		System.out.println(mover);
		
		mover *= 200/(double)velocidad;
		
		System.out.println(mover);

		direccion = mover>0? DERECHA:IZQUIERDA;

		if(posX+mover >= 0 && posX+mover <=1200 && !colisionaronHorizontal(mover)) {

			posX+=mover;
			rectangulo.setLocation(posX, posY);

			posSprite[2] = posSprite[2] !=-1? posSprite[2]:0;
			quieto = false;
		}
	}

	public void moverY(int mover) {
		
		mover *= 120/(double)velocidad;
		
		if(posY+mover >=0 && posY+mover <= 600  && !colisionaronVertical(mover)) {

			posY+=mover;
			rectangulo.setLocation(posX, posY);
		}
	}


	//--------------------------------------
	// Metodos Graficos
	//--------------------------------------

	public Image darSprite() {
		return frame;
	}

	public void actualizar() {

		Image aMostrar = frame;

		if(quieto) {
			// Se retorna un frame de la animacion del personaje parado
			aMostrar = spriteQuieto();
			if (posSprite[2] == 2) {

				posSprite[2] = 3;
				//				aMostrar = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/moverIzquierda": "/moverDerecha")+"/"+(posSprite[2])+ ".png";
				rectangulo.setSize(new ImageIcon(aMostrar).getIconWidth(), new ImageIcon(aMostrar).getIconHeight());
			}

			//**************************************************************
			// Se reinician los frames de cada uno de los otros movimientos
			//**************************************************************
			for (int i = 1; i < posSprite.length; i++) {
				posSprite[i]=-1;
			}
		}else if(posSprite[1] != -1) {
			aMostrar = spritePuño();
		}else if(posSprite[2] != -1) {
			aMostrar = spriteMovimiento();
		}else if(posSprite[3] != -1) {
			aMostrar = spriteAtaqueMedDistancia();
		}

		frame = aMostrar;
	}

	public Image spriteQuieto() {

		if(posSprite[0] == -1) {
			posSprite[0] = 0;
		}
		else if(posSprite[0] < sprite.darTamanhos()[Sprite.PARADO] - 1) {
			posSprite[0]++;
		}else {
			posSprite[0] = -sprite.darTamanhos()[Sprite.PARADO] + 1;
		}

		return sprite.spriteQuieto(posSprite[0], direccion);
	}

	public Image spritePuño() {

		atacando = true;

		Image frame = sprite.spritePuño(posSprite[1], direccion);

		rectangulo.setSize(frame.getWidth(null), frame.getHeight(null));

		posSprite[1]++;
		quieto = false;
		if (posSprite[1] > sprite.darTamanhos()[Sprite.PUNHO]-1) {
			if (colisionaronHorizontal(direccion * 12)) {
				int daño = fuerza - adversario.darResistencia();
				System.out.println(daño);
				adversario.restarVida(daño > 0? daño : 10);
			}
			posSprite[1] = -1;
			quieto = true;
		}

		return frame;
	}

	public Image spriteMovimiento() {

		atacando = false;

		Image frame = sprite.spriteMovimiento(posSprite[2], direccion);

		rectangulo.setSize(frame.getWidth(null), frame.getHeight(null));

		if (posSprite[2] == sprite.darTamanhos()[Sprite.MOVERCE] - 1) {
			posSprite[2] = sprite.darTamanhos()[Sprite.MOVERCE] - 2;
		}
		posSprite[2]++;
		quieto = false;

		return frame;

	}

	public void agregarAtaqueDistancia(AtaqueDistancia actual) {
		if (actual.darSiguiente() == null) {
			actual.seleccionarSiguiente( new AtaqueDistancia(personaje, 1, direccion, posX + (100 * direccion) , posY));
		}else {
			agregarAtaqueDistancia(actual.darSiguiente());
		}
	}

	public Image spriteAtaqueMedDistancia() {

		atacando = true;

		Image frame = sprite.spriteAtaqueMedDistancia(posSprite[3], direccion);

		posSprite[3]++;
		quieto = false;

		if(posSprite[3] == sprite.darTamanhos()[Sprite.ATAQUE_MEDIANO] - 1) {
			AtaqueDistancia actual = ataqueDistancia;
			if (ataqueDistancia == null) {
				ataqueDistancia = new AtaqueDistancia(personaje, 1, direccion, posX + (100 * direccion) , posY);
			}else if(ki - 20 > 0){
				ki -= 20;
				agregarAtaqueDistancia(actual);
			}
		}
		if (posSprite[3] > sprite.darTamanhos()[Sprite.ATAQUE_MEDIANO] - 1) {
			posSprite[3] = -1;
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

	public boolean atacando() {
		return atacando;
	}

	public boolean colisionaronHorizontal(int movimiento) {

		boolean buleano	= false;

		if (direccion == DERECHA && posX > adversario.darPosX()) {
			buleano = false;
		}
		else if (direccion == IZQUIERDA && posX < adversario.darPosX()) {
			buleano = false;
		}else {

			Image temp = sprite.spriteQuieto(posSprite[0], direccion);
			Rectangle futuro = new Rectangle(posX + movimiento, posY, temp.getWidth(null), temp.getHeight(null));
			temp = adversario.spriteQuieto();
			Rectangle futuroAdversario = new Rectangle(adversario.darPosX(), adversario.darPosY(), temp.getWidth(null), temp.getHeight(null));
			buleano = futuro.intersects(futuroAdversario);
		}

		return buleano;
	}

	private boolean colisionaronVertical(int movimiento) {

		boolean buleano	= false;

		if (movimiento > 0 && posY > adversario.darPosY()) {
			buleano = false;
		}
		else if (movimiento < 0 && posY < adversario.darPosY()) {
			buleano = false;
		}else {

			Image temp = sprite.spriteQuieto(posSprite[0], direccion);
			Rectangle futuro = new Rectangle(posX, posY + movimiento, temp.getWidth(null), temp.getHeight(null));
			temp = adversario.spriteQuieto();
			Rectangle futuroAdversario = new Rectangle(adversario.darPosX(), adversario.darPosY(), temp.getWidth(null), temp.getHeight(null));
			buleano = futuro.intersects(futuroAdversario);
		}

		return buleano;

	}

	public void setAdversario(Personaje adversario) {
		this.adversario = adversario;
	}
	
	public int darSalud() {
		return salud;
	}
	
	public int darKI() {
		return ki;
	}

	public int darVelocidad() {
		return velocidad;
	}
	
	public int darIndicePersonaje() {
		return indicePersonaje;
	}
	
	public void recuperarKi() {
		ki++;
	}
	
	public void restarVida(int vida) {
		salud -= vida;
	}
	
	public int darResistencia() {
		return resistencia;
	}

}
