package comandos;

import java.io.*;

import logica.Controlador;
import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;
import excepciones.PosicionOcupada;
import excepciones.PosicionVacia;

public class LeeFichero implements Comando {
   public void Leer() {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
 
      try { //FALTA EL FILE NOT FOUND
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("prueba.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }

@Override
public String ejecuta(Controlador controlador) throws FileNotFoundException,
		PalabraIncorrecta, FormatoNumericoIncorrecto, IOException,
		ErrorDeInicializacion, PosicionVacia {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Comando parsea(String[] cadenaComando) throws FileNotFoundException,
		PalabraIncorrecta, FormatoNumericoIncorrecto, IOException,
		ErrorDeInicializacion, NumberFormatException, PosicionOcupada {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String textoAyuda() {
	// TODO Auto-generated method stub
	return null;
}
}
