package comandos;

import java.io.*;

import logica.Controlador;
import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.PalabraIncorrecta;
import excepciones.PosicionOcupada;
import excepciones.PosicionVacia;

public class EscribeFichero implements Comando{
    public  void escribeFichero(String cadena) throws IOException{
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("prueba.txt");
            pw = new PrintWriter(fichero);
 
                pw.println(cadena);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
              fichero.close();
          
        }
    }

	@Override
	public String ejecuta(Controlador controlador)
			throws FileNotFoundException, PalabraIncorrecta,
			FormatoNumericoIncorrecto, excepciones.IOException,
			ErrorDeInicializacion, PosicionVacia {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comando parsea(String[] cadenaComando) throws FileNotFoundException,
			PalabraIncorrecta, FormatoNumericoIncorrecto,
			excepciones.IOException, ErrorDeInicializacion,
			NumberFormatException, PosicionOcupada {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return null;
	}
}
