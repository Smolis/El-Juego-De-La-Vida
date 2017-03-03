package excepciones;

@SuppressWarnings("serial")
public class PosicionVacia extends Exception {
	public PosicionVacia(){
		
	}
	
	public String posicionVacia(){
		return "EXCEPCION: posicion vacia";
	}

}
