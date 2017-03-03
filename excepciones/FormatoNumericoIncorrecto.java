package excepciones;

@SuppressWarnings("serial")
public class FormatoNumericoIncorrecto extends Exception {
	
	public FormatoNumericoIncorrecto(){
		
	}
	
	public String formatoNumericoIncorrecto(){
		return "EXCEPCION: formato numerico incorrecto";
	}
}
