package practica;

import java.io.FileWriter;
import java.util.Scanner;

import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import logica.Casilla;
import logica.Superficie;

public class CelulaCompleja implements Celula {
	private final int MAX_COMER = 3;
	private int comido;
	protected boolean esComestible = false;
	private boolean lleno = true;
	
	public CelulaCompleja() {
		this.comido = 0;
	}
	
	public String toString(){
		return " * ";
	}
  
	public boolean esComestible(){
		return esComestible;
	}
    
	public boolean debeMorir(int f, int c){
		if (this.comido == MAX_COMER){
			return true;
		}
		else{
			return false;
		}
	}
    
    
	public Casilla buscaMovimiento(int f, int c, Superficie superficie){
		Casilla casilla = null;

		int nf = (int)(Math.random()*(superficie.getNumFilas()));
		int nc = (int)(Math.random()*(superficie.getNumColumnas()));
		casilla = new Casilla(nf,nc);

		return casilla;
	}
    
	public void sumaComidos(int f, int c){
		this.comido++;
	}


	public boolean puedeReproducirse(int f, int c) {
		return esComestible;
	}
	
	
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie) {
			
		Casilla casilla = buscaMovimiento(f,c,superficie);
		int nf = casilla.usarF();
		int nc = casilla.usarC();

		if (this.debeMorir(f, c)){
			superficie.eliminarCelula(f, c);
			System.out.println("Explosion de celula compleja en ("+nf+","+nc+")");
		}
		else if (superficie.casillaVacia(nf, nc)){
			superficie.mueve(f,c,nf,nc);
			System.out.println("Celula compleja en ("+f+","+c+")"+" se mueve a ("+nf+","+nc+") --NO COME--");
		}
		else if (superficie.esComestible(nf, nc)){
			superficie.eliminarCelula(nf, nc);
			superficie.mueve(f, c, nf, nc);
			this.sumaComidos(nf, nc);
			System.out.println("Celula compleja en ("+f+","+c+")"+" se mueve a ("+nf+","+nc+") --COME--");
		}
		else{

			for (int i = 0; i < superficie.getNumFilas(); i++){
				for (int j = 0; j < superficie.getNumColumnas(); j++){
					if (superficie.casillaVacia(i,j)){
						lleno = false;
					}
				}
			}
			if (!lleno){
				while(!superficie.casillaVacia(nf, nc) && !superficie.esComestible(nf,nc)){
					casilla = buscaMovimiento(f,c,superficie);
					nf = casilla.usarF();
					nc = casilla.usarC();
				}

				superficie.mueve(f, c, nf, nc);
				if (superficie.esComestible(nf, nc)){
					System.out.println("Celula compleja en ("+f+","+c+")"+" se mueve a ("+nf+","+nc+") --COME--");

				}
				else{
					System.out.println("Celula compleja en ("+f+","+c+")"+" se mueve a ("+nf+","+nc+") --NO COME--");
				}
			}
		}
		return casilla;
	}
	@Override
	public void guardar(FileWriter fw) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cargar(Scanner sc) throws FormatoNumericoIncorrecto {
		// TODO Auto-generated method stub
		
	}


}
