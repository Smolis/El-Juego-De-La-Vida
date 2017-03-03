package comandos;

import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;
import excepciones.PosicionVacia;
import logica.Casilla;
import logica.Controlador;

public class EliminarCelula implements Comando{
	private Casilla casilla;
	
	public EliminarCelula(int f, int c){
		casilla = new Casilla(f,c);
	}
	
	public EliminarCelula() {
		
	}

	public String ejecuta(Controlador controlador) throws FileNotFoundException, PalabraIncorrecta,
	FormatoNumericoIncorrecto, IOException, ErrorDeInicializacion, PosicionVacia {
		String mensaje; 
		try{
			if (controlador.casillaVacia(casilla.usarF(), casilla.usarC())) throw new PosicionVacia();
			else{
				controlador.eliminarCelula(casilla.usarF(), casilla.usarC());
			}
		}
		catch(PosicionVacia e){
			e.posicionVacia();
		}
		finally{
			mensaje = controlador.toString();
		}
		return mensaje;
	}	


	public Comando parsea(String[] palabras) {
		Comando comando = null;
		try{
			if (palabras.length <= 3){
				if (palabras[0].equals("eliminarcelula")){
					comando = new EliminarCelula(Integer.parseInt(palabras[1]), Integer.parseInt(palabras[2]));
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
		return "  ELIMINARCELULA: Elimina una celula de la posicion (f,c) si es posible";
	}

	
	
}
