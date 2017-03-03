package comandos;

import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;
import logica.Controlador;
import logica.Mundo;

public class Salir implements Comando{
	private Mundo mundo;

	
	public String ejecuta(Controlador controlador) throws FileNotFoundException, PalabraIncorrecta,
	FormatoNumericoIncorrecto, IOException, ErrorDeInicializacion {
		controlador.simulacionTerminada();
		return "Fin de la simulacion...";

	}
	
	public Comando parsea(String[] palabras) {
		Comando comando = null;
		try{
			if (palabras.length <= 3){
				if (palabras[0].equals("salir")){
					comando = new Salir();
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
		return "  SALIR: Cierra la aplicacion";
	}

	
}
