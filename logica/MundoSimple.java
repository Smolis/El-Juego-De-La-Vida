package logica;

import excepciones.ErrorDeInicializacion;

public class MundoSimple extends Mundo {
	private  int maxCelulasSimples;
	private int filas; 
	private int columnas;
	private Superficie superficie;
	
	public MundoSimple(int simples) throws ErrorDeInicializacion {
		this.maxCelulasSimples = simples;
		inicializarCelulas();		
	}
	
	public void inicializarCelulas(){
		int cont = 0;
		try{
			if(superficie != null){
				while(cont < maxCelulasSimples){
					int pos1 = (int)(Math.random()*(filas));
					int pos2 = (int)(Math.random()*(columnas));

					
					if(superficie.usarPosicion(pos1,pos2) == null){
						superficie.crearCelulaSimple(pos1, pos2);
						cont++;
					}
				}
			}
			
			else throw new ErrorDeInicializacion();
		}
		catch(ErrorDeInicializacion e){
			e.errorDeInicializacion();
		}
		finally{
			toString();
		}

	}

	
	public void crearCelula(int f, int c) {
		superficie.crearCelulaSimple(f, c);
		
	}	
	
}


