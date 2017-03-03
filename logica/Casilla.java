package logica;

public class Casilla {
	private int f;
	private int c;
	
	/**Declaracion de la clase Casilla
	 * @author Marta Huertas
	 * @author Guillermo Cortina
	 * @version 16/11/2015
	 */

	/**
	 * Constructora por defecto de la clase Casilla
	 * Recopilara las coordenadas de la casilla de la superficie
	 * para utilizarlas posteriormente
	 * @param f (fila)
	 * @param c (columna)
	 */
	public Casilla(int f, int c){
		this.f = f;
		this.c = c;
	}

	public int usarF(){
		return f;
	}

	public int usarC(){
		return c;
	}

	public void setF(int f){
		this.f = f;
	}

	public void setC(int c){
		this.c = c;
	}
}


