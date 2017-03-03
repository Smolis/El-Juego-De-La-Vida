package comandos;

import logica.Controlador;
import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;

public class Ayuda implements Comando {

	/**
	 * Metodo que ejecuta el comando ayuda
	 */
	public String ejecuta(Controlador controlador) throws FileNotFoundException, PalabraIncorrecta,
	FormatoNumericoIncorrecto, IOException, ErrorDeInicializacion {
		return ParserComandos.AyudaComandos();	

	}
	
	public Comando parsea(String[] palabras) {
		Comando comando = null;
		try{
			if (palabras.length <= 3){
				if (palabras[0].equals("ayuda")){
					comando = new Ayuda();
				}
				else{
					comando = null;
					throw new PalabraIncorrecta();
				}
			}
			else{
				comando = null;
				throw new PalabraIncorrecta();
			}
		}
		catch(PalabraIncorrecta e){
			e.palabraIncorrecta();
		}

		return comando;
	}

	/**
	 * Metodo que devuelve un String
	 */
	public String textoAyuda() {
		//String con la ayuda del comando
		return "  AYUDA: Muestra ayuda de los comandos disponibles"; 	
	}

	
	
}
