
package modelo;

/*
 * Define el comportamiento para un objeto que puede ser destruido
 */
public interface Destruible {
	
    /**
     * Se le resta poder al objeto sobre el que se llame el método<br>
     * @param cuanto El poder del ataque de quien golpea
     */
	public void restarPoder(int cuanto);
	
    /**
     * Destruye el objeto<br>
     */
	public void destruirAtaque();
}
