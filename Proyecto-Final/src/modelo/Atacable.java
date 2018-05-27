package modelo;

/*
 * Define el comportamiento para un objeto que puede ser atacado
 */
public interface Atacable {
	
    /**
     * Le resta vida al objeto <br>
     * @param da�o El poder del ataque de quien golpea
     */
	public void restarVida(int da�o);
}
