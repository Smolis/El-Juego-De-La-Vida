package excepciones;

@SuppressWarnings("serial")
public class PosicionOcupada extends Exception {
	
	public PosicionOcupada(){
		
	}
	
	public String posicionOcupada(){
		return "EXCEPCION: posicion ocupada";
	}
}
