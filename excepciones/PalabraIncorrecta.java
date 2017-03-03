package excepciones;

@SuppressWarnings("serial")
public class PalabraIncorrecta extends Exception {
	
	public PalabraIncorrecta(){
		
	}
	
	public String palabraIncorrecta(){
		return "EXCEPCION: palabra incorrecta";
	}
}
