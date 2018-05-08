package modelo;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Sprite {

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
	public static final int PARADO = 0;
	public static final int PUNHO = 1;
	public static final int PATADA = 2;
	public static final int ATAQUE_GRANDE = 3;
	public static final int ATAQUE_MEDIANO = 4;
	public static final int ATAQUE_PEQUENHO = 5;
	public static final int DEFENSA = 6;
	public static final int MOVERCE = 7;
	public static final int RECARGA_KI = 8;


	private String personaje;

	private Image[][] spritesDerecha;
	private Image[][] spritesIzquierda;

	/*
	 * Arreglo que contiene la cantidad de frames de cada una de las animaciones
	 */
	int[] tamanhos;

	public Sprite(String nombre) {
		// Inicializo el nombre
		personaje = nombre;

		// Se hace arreglo con el tamaño de las carpetas de cada uno de los sprites
		tamanhos = new int[9];

		// Cantidad de frames para Parado
		File f = new File("data/Sprites/" + nombre + "/paradoDerecha");
		String[] array = f.list();
		tamanhos[PARADO] = array.length -1;

		// Cantidad de frames para Puños
		f = new File("data/Sprites/" + nombre + "/puñoDerecha");
		array = f.list();
		tamanhos[PUNHO] = array.length -1;

		// Cantidad de frames para Patadas
		f = new File("data/Sprites/" + nombre + "/patadaDerecha");
		array = f.list();
		tamanhos[PATADA] = array.length -1;

		// Cantidad de frames para Ataque grande
		f = new File("data/Sprites/" + nombre + "/ataqueGrandeDerecha");
		array = f.list();
		tamanhos[ATAQUE_GRANDE] = array.length -1;

		// Cantidad de frames para Ataque Mediano
		f = new File("data/Sprites/" + nombre + "/ataqueMedianoDerecha");
		array = f.list();
		tamanhos[ATAQUE_MEDIANO] = array.length -1;

		// Cantidad de frames para Ataque Pequeño
		f = new File("data/Sprites/" + nombre + "/ataquePequeñoDerecha");
		array = f.list();
		tamanhos[ATAQUE_PEQUENHO] = array.length -1;

		// Cantidad de frames para Defenza
		f = new File("data/Sprites/" + nombre + "/defensaDerecha");
		array = f.list();
		tamanhos[DEFENSA] = array.length -1;

		// Cantidad de frames para Recarga ki
		f = new File("data/Sprites/" + nombre + "/recargarKiDerecha");
		array = f.list();
		tamanhos[RECARGA_KI] = array.length -1;

		//***************************************
		// Creacion de la matriz derecha
		//***************************************
		spritesDerecha = new Image[9][10];

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
			spritesDerecha[DEFENSA][i] = (new ImageIcon("data/Sprites/" + nombre + "/ataquePequeñoDerecha/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[RECARGA_KI]; i++) {
			spritesDerecha[RECARGA_KI][i] = (new ImageIcon("data/Sprites/" + nombre + "/recargarKiDerecha/" + (i + 1)+".png")).getImage();
		}

		//***************************************
		// Creacion de la matriz izquierda
		//***************************************
		spritesIzquierda = new Image[9][10];

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
			spritesIzquierda[DEFENSA][i] = (new ImageIcon("data/Sprites/" + nombre + "/ataquePequeñoIzquierda/" + (i + 1)+".png")).getImage();
		}
		for (int i = 0; i < tamanhos[RECARGA_KI]; i++) {
			spritesIzquierda[RECARGA_KI][i] = (new ImageIcon("data/Sprites/" + nombre + "/recargarKiIzquierda/" + (i + 1)+".png")).getImage();
		}
	}
	
	public Image spriteQuieto(int i, int direccion) {
		i = i > 0? i : -i;
		return direccion == Personaje.DERECHA? spritesDerecha[PARADO][i] : spritesIzquierda[PARADO][i];
	}
	
	public Image spritePuño(int i, int direccion) {
		return direccion == Personaje.DERECHA? spritesDerecha[PUNHO][i] : spritesIzquierda[PUNHO][i];
	}
	
	public Image spriteMovimiento(int i, int direccion) {
		return direccion == Personaje.DERECHA? spritesDerecha[PUNHO][i] : spritesIzquierda[PUNHO][i];
	}
	
	public int[] darTamanhos() {
		return tamanhos;
	}

}
