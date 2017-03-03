package comandos;

import excepciones.FileNotFoundException;
import excepciones.PalabraIncorrecta;
import excepciones.PosicionOcupada;
import logica.Casilla;
import logica.Controlador;

public class CrearCelula implements Comando {
	private Casilla casilla;
	
	
	public CrearCelula(int f, int c){
		casilla = new Casilla(f,c);
	}
	
	public CrearCelula() {
		
	}

	public String ejecuta(Controlador controlador) throws FileNotFoundException, PalabraIncorrecta{
		String mensaje; 
		try{
			 if (!controlador.casillaVacia(casilla.usarF(), casilla.usarC()))throw new PosicionOcupada();
			 else{
				 controlador.crearCelula(casilla.usarF(), casilla.usarC());
			 }
		 }
		 catch(PosicionOcupada e){
			 System.out.println(e.posicionOcupada());
		}
		finally{
			mensaje = controlador.toString();
		}
		
		return mensaje;
	}

	public Comando parsea(String[] palabras) throws FileNotFoundException, PalabraIncorrecta, NumberFormatException, PosicionOcupada{
		Comando comando = null;
		try{
			if (palabras.length <= 3){
				if (palabras[0].equals("crearcelula")){
					comando = new CrearCelula(Integer.parseInt(palabras[1]), Integer.parseInt(palabras[2]));
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
		return "  CREARCELULA: Crea una celula en la posicion (f,c) si es posible";
	}

}
