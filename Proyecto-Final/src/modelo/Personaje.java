package modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;


public class Personaje implements Atacable, Comparable<Personaje>, Serializable{



	//--------------------------------------
	// CONSTANTES
	//--------------------------------------

	//** Constantes de direccion*****//
	public static final int IZQUIERDA = -1;
	public static final int DERECHA = 1;

	//** Constantes de Atributos ******//
	public static final int VIDA_BASE = 1000;
	public static final int KI_BASE = 300;
	public static final int VELOCIDAD_BASE = 40;
	public static final int RESISTENCIA_BASE = 100;
	public static final int FUERZA_BASE = 100;

	/*
	 ===============================================================
	 *-----------------------------------------------
	 *Información de Multiplicadores
	 *-----------------------------------------------
	 * [i][0] ----> multiplicador de Vida
	 * [i][1] ----> multiplicador de Ki
	 * [i][2] ----> multiplicador de Velocidad
	 * [i][3] ----> multiplicador de Fuerza
	 * [i][4] ----> multiplicador de Resistencia
	 * La suma de los multiplicadores por su respectivo
	 */
	
	/*
	 * Matriz constante de personajes
	 */
	public static final double[][] MATRIZ_DE_MULTIPLICADORES= {/*Bardock*/{1,1,1.5,2,1.2},
			/*Beerus*/{1,1.4,1.6,1.6,1.2}, /*Broly*/{1.6,1.1,1,2,1}, /*Frieza*/{1,1.3,1.3,1.2,1.09},
			/*GohanSSJ_Kid*/{1.2,1.2,1.4,1.3,1.23}, /*Goku*/{1,1,1.3,1.2,0.99}, 
			/*18*/{1.1,1.1,1.3,1.4,1.29}, /*Goku_Red*/{1.4,1.4,1.4,1.8,1.5},
			/*Kid_Buu*/{1.4,1.2,1.4,1.5,1.23}, /*Vegeta*/{1.2,1.1,1.3,1.3,1.19} };
	
	/*
	 * Informacion
	 * [0] ----> Bardock --> $800P
	 * [1] ----> Beerus --> $1000P
	 * [2] ----> Broly --> $1000P
	 * [3] ----> Frieza --> $900P
	 * [4] ----> GohanSSJ_Kid --> $1000P
	 * [5] ----> Goku --> $800P
	 * [6] ----> 18 --> $900P
	 * [7] ----> Goku_Red --> $1000P
	 * [8] ----> Kid_Buu --> $1000P
	 * [9] ----> Vegeta --> $900P 
	 */
	public static final int[] precios = {800,1000,1000,900,1000,800,900,1000,1000,900};

	//--------------------------------------
	// Atributos
	//--------------------------------------

	//*****atributos de Poder del Personaje*****//

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
	 * indice del Personaje en la matriz de multiplicadores
	 */
	private int indicePersonaje;

	//*****atributos de Movimiento del Personaje*****//

	//--------------------------------------
	// Información
	//--------------------------------------
	/*	- posSprite[0] ---> Corresponde al sprite parado.
	 * 	- posSprite[1] ---> Corresponde al sprite punho.
	 * 	- posSprite[2] ---> Corresponde al sprite movimiento.
	 * 	- posSprite[3] ---> Corresponde al sprite del ataque mediano.
	 * 	- posSprite[4] ---> Corresponde al sprite del ataque pequeño.
	 *  - posSprite[5] ---> Corresponde al sprite del ataque grande.
	 *	- posSprite[6] ---> Corresponde al sprite de la patada.
	 *	- posSprite[7] ---> Corresponde al sprite de la recarga de ki.
	 * 	- posSprite[8] ---> Corresponde al sprite de cubrirse.
	 */

	/*
	 * arreglo de frames del sprite
	 */
	private int[] posSprite = {0,-1,-1,-1,-1,-1,-1,-1,-1};

	/*
	 * boolean que representa si esta atacando o no
	 */
	private boolean atacando;

	/*
	 * Denota la direccion en la que se esta desplazando el personaje (Usar Constantes)
	 */
	private int direccion;

	/*
	 * boolean que denota el estado en el que se encuentra el personaje; true para quieto y false para cualquier otro movimiento
	 */
	private boolean quieto;

	/*
	 * posicion en el componente X del personaje
	 */
	private int posX;

	/*
	 * posicion en el componente Y del personaje
	 */
	private int posY;

	//*****atributos Graficos del Personaje*****//

	/*
	 * Sprite que pintara el panel
	 */
	private Image frame;

	/*
	 * nombre de la carpeta de la cual se cargara el personaje
	 */
	private String personaje;
	
	//***** Atributos de Arbol ***********//
	
	private Personaje derecha;
	private Personaje Izquierda;

	//*****atributos varios que no se calificar :v del Personaje*****//

	/*
	 * precio en puntos de un personaje (Usar Constantes)
	 */
	private int precio;

	/*
	 * Adversario del personaje 
	 */
	private Personaje adversario;
	
	/*
	 * El ataque a dstancia que se encuentra ejecutando el personaje. Es null si no ejecuta ninguno.
	 */
	private AtaqueDistancia ataqueDistancia;
	
	/*
	 * La hoja de sprites del peronaje
	 */
	private Sprite sprite;

	//--------------------------------------
	// CONSTRUCTOR
	//--------------------------------------
    /**
     * Construye al personaje
     * @param pSprite El nombre del personaje - nombre!=null, nombre!="".
     */
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

	public String darNombre() {
		return personaje;
	}
	
	public Personaje getDerecha() {
		return derecha;
	}

	public Personaje getIzquierda() {
		return Izquierda;
	}

	public void setDerecha(Personaje derecha) {
		this.derecha = derecha;
	}

	public void setIzquierda(Personaje izquierda) {
		Izquierda = izquierda;
	}
	
	public void restarKi(int cuanto) {
		ki -= cuanto;
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
		posY = newPosY;
	}

	//MÉTODO INÚTIL
//	/*
//	 * Método que informa sposSprite[0] el ataque que recibe como parámetro lo afecto
//	 * @param x - La posición en el eje X del ataque
//	 * @param y - La posición en el eje Y del ataque
//	 */
//	public boolean fueGolpeado(int x, int y) {
//		return posX< x && x < posX+30 && posY< y && y < posY+50;
//	}


	/*
	 * Método encargado de atacar con el puño (cambiando el estado de el arreglo de posiciones de -1 a 0)
	 */
	public void atacarPuño() {
		posSprite[1] = posSprite[1] == -1? 0 : posSprite[1];
		quieto = false;
	}
	
	/*
	 * Método encargado de atacar con la patada 
	 */
	public void atacarPatada() {
		
		posSprite[6] = posSprite[6] == -1 ? 0 : posSprite[6];
		quieto = false;
	}

	/*
	 * Lanza un ataque mediano 
	 */
	public void lanzarAtaqueDistanteMediano() {
		posSprite[3] = posSprite[3] == -1 ? 0 : posSprite[3];
		quieto = false;
	}

	/*
	 * Lanza un ataque pequeño
	 */
	public void lanzarAtaqueDistantePequeño() {
		posSprite[4] = posSprite[4] == -1 ? 0 : posSprite[4];
		quieto = false;
	}
	
	/*
	 * Lanza un ataque grande
	 */
	public void lanzarAtaqueDistanteGrande() {
		posSprite[5] = posSprite[5] == -1? 0 : posSprite[5];
		quieto = false;
	}
	
	/*
	 * Método encargado de cambiar el estado del arreglo de posiciones y aumentar el ki
	 */
	public void recargarKi() {
		posSprite[7] = 0;
		if((ki+5)<Personaje.KI_BASE*MATRIZ_DE_MULTIPLICADORES[darIndicePersonaje()][1])
		ki+=2.5;
		quieto = false;
	}
	
	/*
	 * Método encargado de cambiar el estado del arreglo de posiciones y aumentar la resistencia
	 */
	public void defender() {
		posSprite[8] = 0;
		resistencia*=2;
		quieto = false;
	}
	
	/*
	 * Método que reestablece la resistencia del pj a la que estaba por defecto.
	 */
	public void normalizarResistencia() {
		resistencia = (int) (RESISTENCIA_BASE * MATRIZ_DE_MULTIPLICADORES[indicePersonaje][4]);
	}
	
	/*
	 * Método que se encarga de mover al pj en eje X.
	 * Se mueve si el pj está dentro de los límites y no ha colisionado con su adversario.
	 * @param mover - La cantidad de pixeles a desplazarse. Si mover < 0, la dirección es izquierda, sino es derecha.
	 */
	public void moverX(int mover) {

		direccion = mover>0? DERECHA:IZQUIERDA;

		if(posX+mover >= 0 && posX+mover <=1200 && !colisionaronHorizontal(mover)) {

			posX += mover;

			posSprite[2] = posSprite[2] !=-1? posSprite[2]:0;
			quieto = false;
			
		}else if(posX+mover >= 0 && posX+mover <=1200 && !colisionaronHorizontal(9 * direccion)) {
			
			posX += 9*direccion;

			posSprite[2] = posSprite[2] !=-1? posSprite[2]:0;
			quieto = false;
		}
	}

	/*
	 * Método que se encarga de mover al pj en eje Y.
	 * Se mueve si el pj está dentro de los límites y no ha colisionado con su adversario.
	 * @param mover - La cantidad de pixeles a desplazarse. Si mover < 0, la dirección es izquierda, sino es derecha.
	 */
	public void moverY(int mover) {

//		mover *= 30/(double)velocidad;

		if(posY + mover >= 0 && posY + mover <= 600  && !colisionaronVertical(mover)) {
			posY += mover;
		}else if(posY + mover >=0 && posY + mover <= 600 && !colisionaronVertical(9)) {
			posY += 9;
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

			//**********************
			// Se reinician los frames de cada uno de los otros movimientos
			//**********************
			for (int i = 1; i < posSprite.length; i++) {
				posSprite[i]=-1;
			}
		}else if(posSprite[1] != -1) {
			aMostrar = spritePuño();
		}else if(posSprite[2] != -1) {
			aMostrar = spriteMovimiento();
		}else if(posSprite[3] != -1) {
			aMostrar = spriteAtaqueMedianoDistancia();
		}else if(posSprite[4] != -1) {
			aMostrar = spriteAtaquePequeñoDistancia();
		}else if(posSprite[5] != -1) {
			aMostrar = spriteAtaqueGrandeDistancia();
		}else if(posSprite[6] != -1) {
			aMostrar = spritePatada();
		}else if(posSprite[7] != -1) {
			aMostrar = spriteRecargarKi();
		}else if(posSprite[8] !=-1) {
			aMostrar = spriteDefender();
		}
		
		normalizarResistencia();
		frame = aMostrar;
	}

	public Image spriteQuieto() {

		if(posSprite[0] < sprite.darTamanhos()[Sprite.PARADO] - 1) {
			posSprite[0]++;
		}else {
			posSprite[0] = 0;
		}

		return sprite.spriteQuieto(posSprite[0], direccion);
	}

	public Image spritePuño() {

		atacando = true;

		Image frame = sprite.spritePuño(posSprite[1], direccion);

		posSprite[1]++;
		quieto = false;
		if (posSprite[1] > sprite.darTamanhos()[Sprite.PUNHO]-1) {
			if (colisionaronHorizontal(direccion * 12)) {
				int daño = fuerza - adversario.darResistencia();
				adversario.restarVida(daño);
			}
			posSprite[1] = -1;
			quieto = true;
		}

		return frame;
	}
	
	public Image spritePatada() {

		atacando = true;

		Image frame = sprite.spritePatada(posSprite[6], direccion);

		posSprite[6]++;
		quieto = false;
		if (posSprite[6] > sprite.darTamanhos()[Sprite.PATADA]-1) {
			if (colisionaronHorizontal(direccion * 12)) {
				int daño = (int) ((fuerza - adversario.darResistencia())+((fuerza - adversario.darResistencia()))*0.15);
				adversario.restarVida(daño);
			}
			posSprite[6] = -1;
			quieto = true;
		}

		return frame;
	}
	

	public Image spriteMovimiento() {

		atacando = false;

		Image frame = sprite.spriteMovimiento(posSprite[2], direccion);

		if (posSprite[2] == sprite.darTamanhos()[Sprite.MOVERCE] - 2) {
			posSprite[2] = sprite.darTamanhos()[Sprite.MOVERCE] - 3;
		}
		posSprite[2]++;
		quieto = false;

		return frame;

	}

	public void agregarAtaqueDistanciaMediano(AtaqueDistancia actual) {
		if (actual.darSiguiente() == null) {
			actual.seleccionarSiguiente( new AtaqueMediano(fuerza, direccion, posX + (100 * direccion) , posY));
		}else {
			agregarAtaqueDistanciaMediano(actual.darSiguiente());
		}
	}
	
	public void agregarAtaqueDistanciaPequeño(AtaqueDistancia actual) {
		if (actual.darSiguiente() == null) {
			actual.seleccionarSiguiente( new AtaquePequeño(fuerza, direccion, posX + (100 * direccion) , posY));
		}else {
			agregarAtaqueDistanciaPequeño(actual.darSiguiente());
		}
	}
	
	public void agregarAtaqueDistanciaGrande(AtaqueDistancia actual) {
		if (actual.darSiguiente() == null) {
			actual.seleccionarSiguiente( new AtaqueGrande(fuerza, direccion, posX + (100 * direccion) , posY));
		}else {
			agregarAtaqueDistanciaGrande(actual.darSiguiente());
		}
	}

	public Image spriteAtaqueMedianoDistancia() {

		atacando = true;

		Image frame = sprite.spriteAtaqueMedianoDistancia(posSprite[3], direccion);

		posSprite[3]++;
		quieto = false;

		if(posSprite[3] == sprite.darTamanhos()[Sprite.ATAQUE_MEDIANO] - 1) {
			AtaqueDistancia actual = ataqueDistancia;
			if (ataqueDistancia == null) {
				ataqueDistancia = new AtaqueMediano(fuerza, direccion, posX + (100 * direccion) , posY);
				if(ki-100 > 0)
				ki-=100;
			}else if(ki - 100 > 0){
				ki -= 100;
				agregarAtaqueDistanciaMediano(actual);
			}
		}
		if (posSprite[3] > sprite.darTamanhos()[Sprite.ATAQUE_MEDIANO] - 1) {
			posSprite[3] = -1;
			quieto = true;
		}

		return frame;

	}
	
	public Image spriteAtaquePequeñoDistancia() {

		atacando = true;

		Image frame = sprite.spriteAtaquePequeñoDistancia(posSprite[4], direccion);

		posSprite[4]++;
		quieto = false;

		if(posSprite[4] == sprite.darTamanhos()[Sprite.ATAQUE_PEQUENHO] - 1) {
			AtaqueDistancia actual = ataqueDistancia;
			if (ataqueDistancia == null) {
				ataqueDistancia = new AtaquePequeño(fuerza, direccion, posX + (100 * direccion) , posY);
				if(ki-25 > 0)
				ki-=25;
			}else if(ki - 25 > 0){
				ki -= 25;
				agregarAtaqueDistanciaPequeño(actual);
			}
		}
		if (posSprite[4] > sprite.darTamanhos()[Sprite.ATAQUE_PEQUENHO] - 1) {
			posSprite[4] = -1;
			quieto = true;
		}

		return frame;

	}
	
	public Image spriteAtaqueGrandeDistancia() {

		atacando = true;

		Image frame = sprite.spriteAtaqueGrandeDistancia(posSprite[5], direccion);

		posSprite[5]++;
		quieto = false;

		if(posSprite[5] == sprite.darTamanhos()[Sprite.ATAQUE_GRANDE] - 1) {
			AtaqueDistancia actual = ataqueDistancia;
			if (ataqueDistancia == null) {
				ataqueDistancia = new AtaqueGrande(fuerza, direccion, posX + (100 * direccion) , posY);
				ki-=200;
			}else if(ki - 200 > 0){
				ki -= 200;
				agregarAtaqueDistanciaGrande(actual);
			}
		}
		if (posSprite[5] > sprite.darTamanhos()[Sprite.ATAQUE_GRANDE] - 1) {
			posSprite[5] = -1;
			quieto = true;
		}

		return frame;

	}
	
	public Image spriteRecargarKi() {

		atacando = true;

		Image frame = sprite.spriteRecargarKi(posSprite[7], direccion);

		posSprite[7]++;
		quieto = false;
		if (posSprite[7] > sprite.darTamanhos()[Sprite.RECARGA_KI]-1) {
			
			posSprite[7] = -1;
			quieto = true;
		}

		return frame;
	}

	public Image spriteDefender() {

		atacando = true;

		Image frame = sprite.spriteDefensa(posSprite[8], direccion);

		posSprite[8]++;
		quieto = false;
		if (posSprite[8] > sprite.darTamanhos()[Sprite.DEFENSA]-1) {
			
			posSprite[8] = -1;
			quieto = true;
		}

		return frame;
	}
	
	
	public void eliminarAtaque(AtaqueDistancia actual) {

		if (actual == null) {

		}else {
			if (ataqueDistancia.darPoder() == 0) {
				ataqueDistancia = ataqueDistancia.darSiguiente();
				actual = ataqueDistancia;
			}else {
				if (actual.darSiguiente() != null && actual.darSiguiente().darPoder() == 0) {
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
	
	public Sprite imagenes() {
		return sprite;
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
			temp = adversario.imagenes().spriteQuieto(0, direccion);
			Rectangle futuroAdversario = futuro;
			try {
				futuroAdversario = new Rectangle(adversario.darPosX(), adversario.darPosY(), temp.getWidth(null), temp.getHeight(null));
			}catch (Exception e) {
			}
			buleano = futuro.intersects(futuroAdversario);
		}

		return buleano;
	}

	public boolean colisionaronVertical(int movimiento) {

		boolean buleano	= false;

		if (movimiento > 0 && posY > adversario.darPosY()) {
			buleano = false;
		}
		else if (movimiento < 0 && posY < adversario.darPosY()) {
			buleano = false;
		}else {

			Image temp = sprite.spriteQuieto(posSprite[0], direccion);
			Rectangle futuro = new Rectangle(posX, posY + movimiento, temp.getWidth(null), temp.getHeight(null));
			temp = adversario.imagenes().spriteQuieto(0, direccion);
			Rectangle futuroAdversario = futuro;
			try {
				futuroAdversario = new Rectangle(adversario.darPosX(), adversario.darPosY(), temp.getWidth(null), temp.getHeight(null));
			}catch (Exception e) {
				
			}buleano = futuro.intersects(futuroAdversario);
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
		ki +=10;
	}
	
	public void restarVida(int daño) {
		salud -= daño > 0? daño : 10;
	}

	public int darResistencia() {
		return resistencia;
	}
	
	public Rectangle darKickBox() {
		Image temp = frame;
		Rectangle rect = new Rectangle();
		if(frame!=null) {
			rect = new Rectangle(posX,posY, temp.getWidth(null), temp.getHeight(null));
		}
		return rect;
	}
	
	public int[] darArregloPosiciones() {
		return posSprite;
	}

	public void prepararParaSerializar() {
		
	}
	
	@Override
	public int compareTo(Personaje o) {
		return personaje.compareTo(o.darNombre());
	}

}