package comandos;

import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;
import logica.Controlador;
import logica.Mundo;
import logica.MundoSimple;

public class Jugar implements Comando {
	private Mundo mundo;
	private String tipoJuego;

	public Jugar(){ };

	public Jugar(Mundo mundo,String tipoJuego) {

	}

	public String ejecuta(Controlador controlador) throws FileNotFoundException, PalabraIncorrecta,
	FormatoNumericoIncorrecto, IOException,
	ErrorDeInicializacion  {

		controlador.juega(this.mundo);
		return tipoJuego;

	}

	public Comando parsea(String[] cadenas) throws  FileNotFoundException, PalabraIncorrecta,
	FormatoNumericoIncorrecto, IOException,
	ErrorDeInicializacion  {
		Comando comando = null;
		try{
			if (cadenas.length <= 4){
				if (cadenas[0].equals("jugar")){
					tipoJuego = "Juego simple";

				}
				else{
					cadenas = null;
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
		String mensaje = "  JUGAR SIMPLE N M S: juego simple con  N filas, M columnas y con S celulas simples"
				+"\n"+
				"  JUGAR COMPLEJO N M S C: juego complejo con N filas, M columnas, S celulas simples y C celulas complejas";

		return mensaje;

	}
}
