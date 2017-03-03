package logica;

import java.util.Scanner;

import comandos.Comando;
import comandos.ParserComandos;
import excepciones.ErrorDeInicializacion;
import excepciones.FileNotFoundException;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import excepciones.PalabraIncorrecta;
import excepciones.PosicionOcupada;
import excepciones.PosicionVacia;

public class Controlador {

	private Mundo mundo;
	private Scanner in;
	boolean simulacionTerminada;

	
	public Controlador(Mundo mundo, Scanner in) throws ErrorDeInicializacion{
		this.mundo = mundo;
		this.in = new Scanner(System.in);
	}
	
	public void realizaSimulacion() throws NumberFormatException, PosicionOcupada, PosicionVacia{ 
		simulacionTerminada = mundo.esSimulacionTerminada();
		String[] comandos = null;
		
		while (!this.simulacionTerminada){    
			System.out.println(mundo.toString());    
			System.out.print("COMANDO > ");
			String palabras = in.nextLine().toLowerCase();
			comandos = palabras.split(" ");
			try {       
				Comando comando = ParserComandos.parseaComandos(comandos);       
				if (comando!=null) {          
					String mensaje = comando.ejecuta(this);          
					System.out.println(mensaje);       
				}       
			}     
			catch (FileNotFoundException e) {
				System.out.println(e.fileNotFound());
			}    
			catch (PalabraIncorrecta e) {
				System.out.println(e.palabraIncorrecta());
			}    
			catch (FormatoNumericoIncorrecto e) {
				System.out.println(e.formatoNumericoIncorrecto());
			}     
			catch (IOException e) {
				System.out.println(e.ioException());
			}        
			catch (ErrorDeInicializacion e) {
				System.out.println(e.errorDeInicializacion());
			} 
			
			finally{
				System.out.println(mundo.toString());
			}
		}
		
	}

	
	 public void crearCelula(int f, int c)throws PosicionOcupada, PalabraIncorrecta {
		 mundo.crearCelula(f, c);
	 }
	 
	 public void eliminarCelula(int f, int c) throws PosicionVacia {
		 mundo.eliminarCelula(f, c);
	 }
	 
	 public void inicializaMundo() throws ErrorDeInicializacion {
		 mundo.inicializaMundo();
	 }
	 public void juega(Mundo mundo) throws ErrorDeInicializacion {
		 
	 }
	 public String evoluciona() {
		return null; //throws 
		 
	 }
	 
	 public void simulacionTerminada() {
		 mundo.setSimulacionTerminada(true);
	 }
	 
	 public boolean casillaVacia(int f, int c){
		 return mundo.casillaVacia(f, c);
	 }
}
