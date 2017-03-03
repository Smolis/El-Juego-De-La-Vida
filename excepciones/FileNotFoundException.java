package excepciones;

@SuppressWarnings("serial")
public class FileNotFoundException extends Exception {
	public FileNotFoundException(){
		
	}
	
	public String fileNotFound(){
		return "EXCEPCION: archivo no encontrado";
	}
}
