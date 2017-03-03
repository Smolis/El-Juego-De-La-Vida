package comandos;

import logica.Controlador;
import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;

public class Paso implements Comando {
	

	
	public String ejecuta(Controlador controlador) throws FileNotFoundException, PalabraIncorrecta,
	FormatoNumericoIncorrecto, IOException, ErrorDeInicializacion {
		controlador.evoluciona();
		return controlador.toString();

	}
	
	public Comando parsea(String[] palabras) {
		Comando comando = null;
		try{
			if (palabras.length <= 3){
				if (palabras[0].equals("paso")){
					comando = new Paso();
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

	public String textoAyuda() {
		//String con la ayuda del comando
		return "  PASO: Realiza un paso en la simulacion";

	}

	
}