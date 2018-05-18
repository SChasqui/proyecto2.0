package modelo;

public class NoDesbloqueadoException extends Exception {

	private String personajeNoDesbloqueado;
	
	public NoDesbloqueadoException(String mensaje, String personaje) {
		super(mensaje);
		personajeNoDesbloqueado = personaje;
	}
	
	public String darPersonaje() {
		return personajeNoDesbloqueado;
	}
	
}
