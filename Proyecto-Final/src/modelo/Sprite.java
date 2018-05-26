package modelo;

import java.awt.Image;
import java.io.File;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Sprite implements Serializable{
	
	//---------------------------------------------------------------------------------------------------
	// Información de los estados de los sprites (Correspondientes a las filas de la matriz de sprites)
	//---------------------------------------------------------------------------------------------------
	/*
	 * 0 - Parado
	 * 1 - Puño
	 * 2 - Patada
	 * 3 - Ataque grande
	 * 4 - Ataque Mediano
	 * 5 - Ataque Pequeño
	 * 6 - Defensa
	 * 7 - Moverce
	 * 8 - Recargar ki
	 */
	
	/*
	 * Corresponde al estado parado
	 */
	public static final int PARADO = 0;
	/*
	 * Corresponde al estado puño
	 */
	public static final int PUNHO = 1;
	/*
	 * Corresponde a la acción de patear 
	 */
	public static final int PATADA = 2;
	/*
	 * Corresponde a la animación de ataque grande
	 */
	public static final int ATAQUE_GRANDE = 3;
	/*
	 * Corresponde a la animación de ataque mediano
	 */
	public static final int ATAQUE_MEDIANO = 4;
	/*
	 * Corresponde a la animación de ataque pequeño
	 */
	public static final int ATAQUE_PEQUENHO = 5;
	/*
	 * Corresponde al estado defensivo
	 */
	public static final int DEFENSA = 6;
	/*
	 * Corresponde al estado de movimiento
	 */
	public static final int MOVERCE = 7;
	/*
	 * Corresponde al estado de recargar el ki
	 */
	public static final int RECARGA_KI = 8;

	/*
	 * Es el nombre del personaje
	 */
	private String personaje;
	
	/*
	 * Matriz de los sprites viendo hacia la derecha
	 */
	private Image[][] spritesDerecha;
	
	/*
	 * Matriz de los sprites viendo hacia la izquierda
	 */
	private Image[][] spritesIzquierda;

	/*
	 * Arreglo que contiene la cantidad de frames de cada una de las animaciones
	 */
	private int[] tamanhos;
	
	
	//-------------------------------
	// CONSTRUCTOR
	//-------------------------------
    /**
     * Crea la hoja de sprites<br>
     * @param nombre El nombre del personaje
     */
	public Sprite(String nombre) {
		// Inicializo el nombre
		personaje = nombre;

		// Se hace arreglo con el tamaño de las carpetas de cada uno de los sprites
		tamanhos = new int[9];

		// Cantidad de frames para Parado
		File f = new File("data/Sprites/" + nombre + "/paradoDerecha");
		String[] array = f.list();
		tamanhos[PARADO] = array.length ;

		// Cantidad de frames para Puños
		f = new File("data/Sprites/" + nombre + "/puñoDerecha");
		array = f.list();
		tamanhos[PUNHO] = array.length ;

		// Cantidad de frames para Patadas
		f = new File("data/Sprites/" + nombre + "/patadaDerecha");
		array = f.list();
		tamanhos[PATADA] = array.length ;

		// Cantidad de frames para Ataque grande
		f = new File("data/Sprites/" + nombre + "/ataqueGrandeDerecha");
		array = f.list();
		tamanhos[ATAQUE_GRANDE] = array.length ;

		// Cantidad de frames para Ataque Mediano
		f = new File("data/Sprites/" + nombre + "/ataqueMedianoDerecha");
		array = f.list();
		tamanhos[ATAQUE_MEDIANO] = array.length ;

		// Cantidad de frames para Ataque Pequeño
		f = new File("data/Sprites/" + nombre + "/ataquePequeñoDerecha");
		array = f.list();
		tamanhos[ATAQUE_PEQUENHO] = array.length ;

		// Cantidad de frames para Defenza
		f = new File("data/Sprites/" + nombre + "/defensaDerecha");
		array = f.list();
		tamanhos[DEFENSA] = array.length ;

		// Cantidad de frames para Defenza
		f = new File("data/Sprites/" + nombre + "/moverDerecha");
		array = f.list();
		tamanhos[MOVERCE] = array.length ;

		// Cantidad de frames para Recarga ki
		f = new File("data/Sprites/" + nombre + "/recargarKiDerecha");
		array = f.list();
		tamanhos[RECARGA_KI] = array.length ;

		//***************************************
		// Creacion de la matriz derecha
		//***************************************
		spritesDerecha = new Image[9][13];

		for (int i = 0; i < tamanhos[PARADO]; i++) {
			spritesDerecha[PARADO][i] = (new ImageIcon("data/Sprites/" + nombre + "/paradoDerecha/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[PUNHO]; i++) {
			spritesDerecha[PUNHO][i] = (new ImageIcon("data/Sprites/" + nombre + "/puñoDerecha/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[PATADA]; i++) {
			spritesDerecha[PATADA][i] = (new ImageIcon("data/Sprites/" + nombre + "/patadaDerecha/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[ATAQUE_GRANDE]; i++) {
			spritesDerecha[ATAQUE_GRANDE][i] = (new ImageIcon("data/Sprites/" + nombre + "/ataqueGrandeDerecha/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[ATAQUE_MEDIANO]; i++) {
			spritesDerecha[ATAQUE_MEDIANO][i] = (new ImageIcon("data/Sprites/" + nombre + "/ataqueMedianoDerecha/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[ATAQUE_PEQUENHO]; i++) {
			spritesDerecha[ATAQUE_PEQUENHO][i] = (new ImageIcon("data/Sprites/" + nombre + "/ataquePequeñoDerecha/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[DEFENSA]; i++) {
			spritesDerecha[DEFENSA][i] = (new ImageIcon("data/Sprites/" + nombre + "/defensaDerecha/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[RECARGA_KI]; i++) {
			spritesDerecha[RECARGA_KI][i] = (new ImageIcon("data/Sprites/" + nombre + "/recargarKiDerecha/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[MOVERCE]; i++) {
			spritesDerecha[MOVERCE][i] = (new ImageIcon("data/Sprites/" + nombre + "/moverDerecha/" + (i + 1)+".png")).getImage();
		}


		//***************************************
		// Creacion de la matriz izquierda
		//***************************************
		spritesIzquierda = new Image[9][13];

		for (int i = 0; i < tamanhos[PARADO]; i++) {
			spritesIzquierda[PARADO][i] = (new ImageIcon("data/Sprites/" + nombre + "/paradoIzquierda/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[PUNHO]; i++) {
			spritesIzquierda[PUNHO][i] = (new ImageIcon("data/Sprites/" + nombre + "/puñoIzquierda/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[PATADA]; i++) {
			spritesIzquierda[PATADA][i] = (new ImageIcon("data/Sprites/" + nombre + "/patadaIzquierda/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[ATAQUE_GRANDE]; i++) {
			spritesIzquierda[ATAQUE_GRANDE][i] = (new ImageIcon("data/Sprites/" + nombre + "/ataqueGrandeIzquierda/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[ATAQUE_MEDIANO]; i++) {
			spritesIzquierda[ATAQUE_MEDIANO][i] = (new ImageIcon("data/Sprites/" + nombre + "/ataqueMedianoIzquierda/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[ATAQUE_PEQUENHO]; i++) {
			spritesIzquierda[ATAQUE_PEQUENHO][i] = (new ImageIcon("data/Sprites/" + nombre + "/ataquePequeñoIzquierda/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[DEFENSA]; i++) {
			spritesIzquierda[DEFENSA][i] = (new ImageIcon("data/Sprites/" + nombre + "/defensaIzquierda/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[RECARGA_KI]; i++) {
			spritesIzquierda[RECARGA_KI][i] = (new ImageIcon("data/Sprites/" + nombre + "/recargarKiIzquierda/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[MOVERCE]; i++) {
			spritesIzquierda[MOVERCE][i] = (new ImageIcon("data/Sprites/" + nombre + "/moverIzquierda/" + (i + 1)+".png")).getImage();
		}
	}
	
    /*
     * Devuelve la imagen del sprite quieto en la posición que se le indica por parámetro <br>
     * <b>pre:</b> las matrices spritesDerecha y spritesIzquierda están declaradas e inicializadas
     * @param i - El índice que indica la posición del acción (sprite) en la que va
     * @param direccion - 1: DERECHA; -1 IZQUIERDA.
     * @return la imagen de la matriz en la fila PARADO, con columna indice en la dirección direccion.
     */
	public Image spriteQuieto(int i, int direccion) {
		i = i > 0? i : -i;
		return direccion == Personaje.DERECHA? spritesDerecha[PARADO][i] : spritesIzquierda[PARADO][i];
	}
	
    /*
     * Devuelve la imagen del sprite puño en la posición que se le indica por parámetro <br>
     * <b>pre:</b> las matrices spritesDerecha y spritesIzquierda están declaradas e inicializadas
     * @param i - El índice que indica la posición del acción (sprite) en la que va
     * @param direccion - 1: DERECHA; -1 IZQUIERDA.
     * @return la imagen de la matriz en la fila PUNHO, con columna indice en la dirección direccion.
     */
	public Image spritePuño(int i, int direccion) {
		return direccion == Personaje.DERECHA? spritesDerecha[PUNHO][i] : spritesIzquierda[PUNHO][i];
	}
	
    /*
     * Devuelve la imagen del sprite movimiento en la posición que se le indica por parámetro <br>
     * <b>pre:</b> las matrices spritesDerecha y spritesIzquierda están declaradas e inicializadas
     * @param i - El índice que indica la posición del acción (sprite) en la que va
     * @param direccion - 1: DERECHA; -1 IZQUIERDA.
     * @return la imagen de la matriz en la fila MOVERCE, con columna indice en la dirección direccion.
     */
	public Image spriteMovimiento(int i, int direccion) {
		return direccion == Personaje.DERECHA? spritesDerecha[MOVERCE][i] : spritesIzquierda[MOVERCE][i];
	}
	
    /*
     * Devuelve la imagen del sprite ataque mediano en la posición que se le indica por parámetro <br>
     * <b>pre:</b> las matrices spritesDerecha y spritesIzquierda están declaradas e inicializadas
     * @param i - El índice que indica la posición del acción (sprite) en la que va
     * @param direccion - 1: DERECHA; -1 IZQUIERDA.
     * @return la imagen de la matriz en la fila ATAQUE_MEDIANO, con columna indice en la dirección direccion.
     */
	public Image spriteAtaqueMedianoDistancia(int i, int direccion) {
		return direccion == Personaje.DERECHA? spritesDerecha[ATAQUE_MEDIANO][i] : spritesIzquierda[ATAQUE_MEDIANO][i];
	}
	
    /*
     * Devuelve la imagen del sprite ataque pequeño en la posición que se le indica por parámetro <br>
     * <b>pre:</b> las matrices spritesDerecha y spritesIzquierda están declaradas e inicializadas
     * @param i - El índice que indica la posición del acción (sprite) en la que va
     * @param direccion - 1: DERECHA; -1 IZQUIERDA.
     * @return la imagen de la matriz en la fila ATAQUE_PEQUENHO, con columna indice en la dirección direccion.
     */
	public Image spriteAtaquePequeñoDistancia(int i, int direccion) {
		return direccion == Personaje.DERECHA? spritesDerecha[ATAQUE_PEQUENHO][i] : spritesIzquierda[ATAQUE_PEQUENHO][i];
	}
	
    /*
     * Devuelve la imagen del sprite ataque grande en la posición que se le indica por parámetro <br>
     * <b>pre:</b> las matrices spritesDerecha y spritesIzquierda están declaradas e inicializadas
     * @param i - El índice que indica la posición del acción (sprite) en la que va
     * @param direccion - 1: DERECHA; -1 IZQUIERDA.
     * @return la imagen de la matriz en la fila ATAQUE_GRANDE, con columna indice en la dirección direccion.
     */
	public Image spriteAtaqueGrandeDistancia(int i, int direccion) {
		return direccion == Personaje.DERECHA? spritesDerecha[ATAQUE_GRANDE][i] : spritesIzquierda[ATAQUE_GRANDE][i];
	}

    /*
     * Devuelve la imagen del sprite patada en la posición que se le indica por parámetro <br>
     * <b>pre:</b> las matrices spritesDerecha y spritesIzquierda están declaradas e inicializadas
     * @param i - El índice que indica la posición del acción (sprite) en la que va
     * @param direccion - 1: DERECHA; -1 IZQUIERDA.
     * @return la imagen de la matriz en la fila PATADA, con columna indice en la dirección direccion.
     */
	public Image spritePatada(int i, int direccion) {
		return direccion == Personaje.DERECHA? spritesDerecha[PATADA][i] : spritesIzquierda[PATADA][i];
	}
	
    /*
     * Devuelve la imagen del sprite recarga de ki en la posición que se le indica por parámetro <br>
     * <b>pre:</b> las matrices spritesDerecha y spritesIzquierda están declaradas e inicializadas
     * @param lineaPuntos La línea con la información de los dos puntos
     * @return la imagen de la matriz en la fila RECARGA_KI, con columna indice en la dirección direccion.
     */
	public Image spriteRecargarKi(int i, int direccion) {
		// TODO Auto-generated method stub
		return direccion == Personaje.DERECHA? spritesDerecha[RECARGA_KI][i] : spritesIzquierda[RECARGA_KI][i];
	}
	
    /*
     * Devuelve la imagen del sprite defensa en la posición que se le indica por parámetro <br>
     * <b>pre:</b> las matrices spritesDerecha y spritesIzquierda están declaradas e inicializadas
     * @param i - El índice que indica la posición del acción (sprite) en la que va
     * @param direccion - 1: DERECHA; -1 IZQUIERDA.
     * @return la imagen de la matriz en la fila DEFENSA, con columna indice en la dirección direccion.
     */
	public Image spriteDefensa(int i, int direccion) {
		// TODO Auto-generated method stub
		return direccion == Personaje.DERECHA? spritesDerecha[DEFENSA][i] : spritesIzquierda[DEFENSA][i];
	}
	
    /*
     * Devuelve la imagen del sprite quieto en la posición que se le indica por parámetro <br>
     * <b>pre:</b> el arreglo de tamanhos ha sidod declarado e incializado
     * @return tamanhos - el arreglo de enteros con los tamaños (las posiciones obedecen las posiciones de las constantes)
     */
	public int[] darTamanhos() {
		return tamanhos;
	}
}
