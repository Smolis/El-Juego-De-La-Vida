package comandos;

import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;
import excepciones.PosicionOcupada;

public class ParserComandos {
	private static final Comando[] comandos = { 
		new Ayuda(), new Iniciar(), new CrearCelula(),
		new EliminarCelula(), new Paso(), new Vaciar(), new Salir(), new Jugar()
	};
	
	/**
	 * Devuelve una cadena de todos los textos de los comandos
	 * cada uno en una linea
	 * @return
	 */
	static public String AyudaComandos(){
		String cadena = "";
		for (int i = 0; i < comandos.length; i++){
			cadena += comandos[i].textoAyuda();
			cadena += "\n";
		}
		return cadena;
	}
	/**
	 * Metodo comprueba que comando hemos introducido y si es valido
	 * @param cadenas
	 * @return
	 * @throws ErrorDeInicializacion 
	 * @throws IOException 
	 * @throws FormatoNumericoIncorrecto 
	 * @throws PalabraIncorrecta 
	 * @throws FileNotFoundException 
	 * @throws PosicionOcupada 
	 * @throws NumberFormatException 
	 */
	static public Comando parseaComandos(String[] cadenas) throws FileNotFoundException, PalabraIncorrecta, FormatoNumericoIncorrecto, IOException, ErrorDeInicializacion, NumberFormatException, PosicionOcupada{
		int i=0;
		boolean seguir = true;
		Comando comando = null;
		while (i < ParserComandos.comandos.length && seguir){
			comando = comandos[i].parsea(cadenas);
			if (comando!=null){
				seguir = false;
			}
			else{
				i++;
			}
		}
		return comando;
	}

}