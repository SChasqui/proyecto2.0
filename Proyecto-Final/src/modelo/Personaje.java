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
	
	private Sprite sprite;

	//--------------------------------------
	// Constructor
	//--------------------------------------
	public Personaje(String pSprite, int precio) {

		/*
		 * se inicializa el arreglo de imagenes de las posibles posiciones del personaje
		 */
		personaje = pSprite;
		
		sprite = new Sprite(pSprite);

		/*
		 * se fija el precio que tendra el personaje
		 */
		this.precio = precio;

		posX += 100;

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
	public void atacar(int tecla) {
		posSprite[1] = 1;
		quieto = false;
	}

	public void lanzarAtaqueDistante() {
		posSprite[3] = 1;
		quieto = false;
	}

	public void moverX(int mover) {

		if(posX+mover >= 0 && posX+mover <=1200 && !colisionaron(mover)) {

			posX+=mover;
			direccion = mover>0? DERECHA:IZQUIERDA;
			rectangulo.setLocation(posX, posY);

			posSprite[2] = posSprite[2] !=0? posSprite[2]:1;
			quieto = false;
		}
	}

	public void moverY(int mover) {
		if(posY+mover >=0 && posY+mover <= 600) {

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

		Image aMostrar = new ImageIcon("data/Sprites/" + sprite + (direccion == IZQUIERDA? "/moverIzquierda": "/moverDerecha")+"/"+(posSprite[2])+".png").getImage();

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
				posSprite[i]=0;
			}
		}else if(posSprite[1] != 0) {
			aMostrar = spritePuño();
		}else if(posSprite[2] != 0) {
			aMostrar = spriteMovimiento();}
//		}else if(posSprite[3] != 0) {
//			aMostrar = spriteAtaqueMedDistancia();
//		}

		frame = aMostrar;
	}

	public Image spriteQuieto() {

		if(posSprite[0] == -1) {
			posSprite[0] = 1;
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
		if (posSprite[1] > sprite.darTamanhos()[Sprite.PUNHO]) {
			posSprite[1] = 0;
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

	public String spriteAtaqueMedDistancia() {

		atacando = true;

		String frame = "data/Sprites/" + sprite + (direccion == IZQUIERDA? "/ataqueMedIzquierda": "/ataqueMedDerecha")+"/"+(posSprite[3])+ ".png";

		posSprite[3]++;
		quieto = false;

		if(posSprite[3] == 5) {
			AtaqueDistancia actual = ataqueDistancia;
			if (ataqueDistancia == null) {
				ataqueDistancia = new AtaqueDistancia(personaje, 1, direccion, posX + (100 * direccion) , posY);
			}else {
				agregarAtaqueDistancia(actual);
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

	public boolean atacando() {
		return atacando;
	}

	public boolean colisionaron(int m) {

		boolean buleano	= false;
		rectangulo = new Rectangle(posX + m, posY, frame.getHeight(null), frame.getHeight(null));
		buleano = rectangulo.intersects(adversario.darRectangulo());

		return buleano;
	}

	public void setAdversario(Personaje adversario) {
		this.adversario = adversario;
	}

}
