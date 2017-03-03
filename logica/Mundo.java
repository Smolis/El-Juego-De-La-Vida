package logica;

import excepciones.ErrorDeInicializacion;
import excepciones.PalabraIncorrecta;
import excepciones.PosicionOcupada;

public abstract class Mundo {
	protected Superficie superficie;
	protected  int filas;
	protected  int columnas;
	private boolean simulacionTerminada = false;
	abstract void inicializarCelulas();
	public abstract void crearCelula(int f, int c) throws PalabraIncorrecta;


	public Mundo() throws ErrorDeInicializacion {
		this.superficie = new Superficie(this.filas, this.columnas);
		this.inicializaMundo();
	}
	
	public Mundo(int filas, int columnas) throws ErrorDeInicializacion {
		this.superficie = new Superficie(this.filas, this.columnas);
		this.inicializaMundo();
	}
		
		
	public void inicializaMundo() throws ErrorDeInicializacion {
		this.superficie.vaciar();
		this.inicializarCelulas();
		try{
			//Si hay mas celulas que posiciones
			int posiciones = filas + columnas;
			int celulas = superficie.numeroCelulas();
			if (posiciones < celulas){
				throw new ErrorDeInicializacion();
			}
		}
		catch(ErrorDeInicializacion error){
			System.out.println(error.errorDeInicializacion());
		}
		finally{
			System.out.println(toString());
		}
		
	}


	public boolean casillaVacia(int f, int c) {
		return superficie.casillaVacia(f, c);

	}

	public boolean correctas(int f, int c) {
		return this.superficie.correctas(f, c);
	}
	
	
	public void evoluciona(){
		boolean[][] activas = new boolean [filas][columnas];
		Casilla casilla = null;
		int nf = 0;
		int nc = 0;
		
		for (int f = 0; f < filas; f++){
			for (int c = 0; c < columnas; c++){
				activas[f][c] = true;
			}
		}
		
		for (int i = 0; i < filas; i++){
			for (int j = 0; j < columnas; j++){
				if (activas[i][j] && !superficie.casillaVacia(i, j)){
					casilla = superficie.ejecutaMovimiento(i, j);
					if (casilla != null){
						nf = casilla.usarF();
						nc = casilla.usarC();
						activas[nf][nc] = false;
					}
				}
			}
		}
	}
	
	
	public void vaciarSuperficie(){
		this.superficie.vaciar();
	}

	
	public void eliminarCelula(int f, int c){
		this.superficie.eliminarCelula(f, c);
	}

	
	public void crearCelulaSimple(int f, int c)  throws PosicionOcupada {
		this.superficie.crearCelulaSimple(f, c);
	}
	
	public void crearCelulaCompleja(int f, int c){
		this.superficie.crearCelulaCompleja(f,c);
	}
	public int getfilas(){
		return this.filas;
	}
	public int getcolumnas(){
		return this.columnas;
	
	}
	
	public boolean esSimulacionTerminada() {
		return this.simulacionTerminada;
	}

	public void setSimulacionTerminada(boolean simulacionTerminada) {
		this.simulacionTerminada = simulacionTerminada;
	}
	
	public String toString(){
		return this.superficie.toString();
	}


}

