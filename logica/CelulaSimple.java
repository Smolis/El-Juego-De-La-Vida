package practica;

import java.io.FileWriter;
import java.util.Scanner;

import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import logica.Casilla;
import logica.Superficie;

public class CelulaSimple implements Celula {

	private int pasosSinMover;
	private int pasosParaReproducirse;
	private final int MAX_PASOS_SIN_MOVER = 1;
	private final int PASOS_REPRODUCCION = 2;
	protected boolean esComestible = true;
    
	
	public CelulaSimple(){
		this.pasosSinMover = MAX_PASOS_SIN_MOVER;
		this.pasosParaReproducirse = PASOS_REPRODUCCION;
	}	
    
	public String toString(){
		return " X ";		
	}
  
	public void restaPasosSinMover(int f, int c){
		this.pasosSinMover--;
	}
   
	public void restaPasosParaReproducirse(int nf, int nc){
		this.pasosParaReproducirse--;
	}
	public int getPasosSinMover() {
		return pasosSinMover;
	}

	public void setPasosSinMover(int pasosSinMover) {
		this.pasosSinMover = pasosSinMover;
	}

	public int getPasosParaReproducirse() {
		return pasosParaReproducirse;
	}

	public void setPasosParaReproducirse(int pasosParaReproducirse) {
		this.pasosParaReproducirse = pasosParaReproducirse;
	}
    

	public boolean esComestible(){
		return esComestible;
	}
  

   
	public void reproducirse (int f, int c, Casilla casilla, Superficie superficie){
		int nf = casilla.usarF();
		int nc = casilla.usarC();

		if (superficie.correctas(nf, nc)){
			superficie.crearCelulaSimple(f,c);
			superficie.crearCelulaSimple(nf, nc);
		}

		System.out.println("Movimiento de ("+f+","+c+") a ("+nf+","+nc+")");
		System.out.println("Nace nueva celula en ("+f+","+c+") cuyo padre ha sido ("+nf+","+nc+")");
	}

    
	public boolean mueve(int f, int c, Superficie superficie, Casilla casilla){
		boolean ok = false;
		int nf = casilla.usarF();
		int nc = casilla.usarC();

		if (superficie.correctas(nf, nc) && casilla != null){
			this.restaPasosParaReproducirse(f, c);
			superficie.mueve(f, c, nf, nc);
			System.out.println("Movimiento de ("+f+","+c+") a ("+nf+","+nc+")");
			ok = true;
			this.restaPasosParaReproducirse(nf, nc);
		}

		else{
			this.restaPasosSinMover(f,c); 
		}

		return ok;
	}

   
	public Casilla buscaMovimiento(int f, int c, Superficie superficie) {
		int cont = -1;
		int[] incrFila = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] incrCol = { -1, 0, 1, -1, 1, -1, 0, 1 };
		Casilla[] movPosibles = new Casilla[8];

		for (int i = 0; i < 8; i++) {
			int nf = f + incrFila[i];
			int nc = c + incrCol[i];
			if (superficie.correctas(nf, nc) && superficie.casillaVacia(nf, nc)) {
				cont++;
				movPosibles[cont] = new Casilla(nf, nc);
			}
		}

		if (cont == -1){
			return null;
		}

		else {
			int valor = (int)(Math.random()*(cont));
			return movPosibles[valor];
		}
	}
   
	public boolean debeMorir(int f, int c){
		if (pasosSinMover == 0){
			return true;
		}

		else{
			return false;
		}
	}
   
	public boolean puedeReproducirse(int f, int c){
		if (pasosParaReproducirse == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie){
		Casilla casilla = null;
			if (!superficie.casillaVacia(f, c)){
				if (this.debeMorir(f,c)){
					superficie.eliminarCelula(f, c);
					System.out.println("Muere la celula de la casilla "+"("+f +","+c+") por inactividad");
				}
				else if (this.puedeReproducirse(f,c)){
					casilla = buscaMovimiento(f, c, superficie);
					if (casilla != null){
						this.reproducirse(f, c, casilla, superficie);
						int nf = casilla.usarF();
						int nc = casilla.usarC();
						casilla = new Casilla(nf,nc);
					}
					else{
						superficie.eliminarCelula(f, c);
						System.out.println("Muere la celula de la casilla "+"("+f+","+c+") por no poder reproducirse");

					}

				}

				else{
					casilla = this.buscaMovimiento(f, c, superficie);
					if (casilla != null){
						int nf = casilla.usarF();
						int nc = casilla.usarC();
						this.restaPasosParaReproducirse(f, c);
						superficie.mueve(f, c, nf, nc);
						casilla.setF(nf);
						casilla.setC(nc);
						System.out.println("Movimiento de ("+f+","+c+") a ("+nf+","+nc+")");
					}

					else if (casilla == null){
						this.restaPasosSinMover(f, c);
					}
				}
			}
			return casilla;
		//}
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
