package modelo;

/*
 * Define el comportamiento para un objeto que puede ser atacado
 */
public interface Atacable {
	
    /**
     * Le resta vida al objeto <br>
     * @param daño El poder del ataque de quien golpea
     */
	public void restarVida(int daño);
}
