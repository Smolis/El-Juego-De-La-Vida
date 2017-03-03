package comandos;

import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;
import logica.Controlador;
import logica.Mundo;

public class Iniciar implements Comando {
	private Mundo mundo;
	
	/**
	 * Metodo que inicializa el mundo
	 * @param mundo 
	 * @throws FileNotFoundException 
	 * @throws PalabraIncorrecta
	 * @throws FormatoNumericoIncorrecto
	 * @throws IOException
	 * @throws ErrorDeInicializacion
	 */
	public String ejecuta(Controlador controlador) throws FileNotFoundException, PalabraIncorrecta,
	FormatoNumericoIncorrecto, IOException, ErrorDeInicializacion {
		mundo.inicializaMundo();
		return mundo.toString();
	}

	
	public Comando parsea(String[] palabras) {
		Comando comando = null;
		try{
			if (palabras.length <= 3){
				if (palabras[0].equals("iniciar")){
					comando = new Iniciar();
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
			System.out.println(e.palabraIncorrecta());
		}

		return comando;
	}
	
	
	public String textoAyuda(){
		//String con la ayuda del comando
		return "  INICIAR: Inicia la poblacion de forma aleatoria";
	}






}