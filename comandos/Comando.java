package comandos;

import logica.Controlador;
import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;
import excepciones.PosicionOcupada;
import excepciones.PosicionVacia;

public interface Comando {
	 public abstract String ejecuta(Controlador controlador)
	 throws FileNotFoundException, PalabraIncorrecta, 
	 FormatoNumericoIncorrecto, IOException,
	 ErrorDeInicializacion, PosicionVacia;

	 public abstract Comando parsea(String[] cadenaComando) 
	 throws FileNotFoundException, PalabraIncorrecta, 
	 FormatoNumericoIncorrecto, IOException,
	 ErrorDeInicializacion, NumberFormatException, PosicionOcupada; 
	 
	 public abstract String textoAyuda();
	  
}