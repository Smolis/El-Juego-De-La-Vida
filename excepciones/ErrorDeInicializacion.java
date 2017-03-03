package excepciones;

@SuppressWarnings("serial")
public class ErrorDeInicializacion extends Exception {
	
	public ErrorDeInicializacion(){
		
	}
	
	public String errorDeInicializacion(){
		return "EXCEPCION: Error de inicializacion";
	}

}
