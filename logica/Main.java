package practica;

import java.util.Scanner;

import excepciones.ErrorDeInicializacion;
import excepciones.PosicionOcupada;
import excepciones.PosicionVacia;
import logica.Controlador;
import logica.Mundo;
import logica.MundoSimple;

public class Main {
	private static Scanner in = new Scanner(System.in);
	
	/**Declaracion de la clase Main
	 * @author Marta Huertas
	 * @author Guillermo Cortina
	 * @version 16/11/2015
	 */

	/**
	 * Se crea un mundo y un controlador y se realiza la simulacion
	 * @throws PosicionOcupada 
	 * @throws NumberFormatException 
	 * @throws PosicionVacia 
	 * @throws ErrorDeInicializacion 
	 */
	public static void main (String[] args) throws NumberFormatException, PosicionOcupada, PosicionVacia, ErrorDeInicializacion{
		Mundo mundo = new MundoSimple(3);
		Controlador c = new Controlador(mundo,in);
		c.realizaSimulacion();
	}

}
