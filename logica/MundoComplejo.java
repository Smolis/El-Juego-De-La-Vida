package logica;

import java.util.Scanner;

import excepciones.ErrorDeInicializacion;
import excepciones.PalabraIncorrecta;

public class MundoComplejo extends Mundo {
	private  int maxCelulasSimples;
	private  int maxCelulasComplejas;
	private Superficie superficie;
	private int filas;
	private int columnas; 

	public MundoComplejo(int simples, int complejas) throws ErrorDeInicializacion {
		this.maxCelulasSimples = simples;
		this.maxCelulasComplejas = complejas;
		inicializarCelulas();
	}

	public void inicializarCelulas(){
		int cont = 0, contComplejas = 0;

		while(cont < maxCelulasSimples){
			int pos1 = (int)(Math.random()*(filas));
			int pos2 = (int)(Math.random()*(columnas));

			if(superficie.usarPosicion(pos1,pos2) == null){
				superficie.crearCelulaSimple(pos1, pos2);
				cont++;
			}
		}

		while(contComplejas < maxCelulasComplejas){
			int posc1 = (int)(Math.random()*(filas));
			int posc2 = (int)(Math.random()*(columnas));

			if(superficie.usarPosicion(posc1, posc2) == null){
				superficie.crearCelulaCompleja(posc1, posc2);;
				contComplejas++;
			}
		}
	}

	
	@SuppressWarnings("null")
	public void crearCelula(int f, int c) throws PalabraIncorrecta{
		Scanner in = null;
		String palabra = null;
		System.out.print("Introduce el tipo de celula que quieres crear > ");
		palabra = in.nextLine().toLowerCase();
		try{
			if (palabra != "simple" || palabra != "compleja") throw new PalabraIncorrecta();
		}
		catch(PalabraIncorrecta e){
			e.palabraIncorrecta();
		}
		
		if (palabra == "simple"){
			superficie.crearCelulaSimple(f, c);
		}
		else{
			superficie.crearCelulaCompleja(f, c);
		}
		
	}
	
	
	
}
