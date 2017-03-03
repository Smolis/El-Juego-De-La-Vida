package practica;

import java.io.FileWriter;
import java.util.Scanner;

import excepciones.FormatoNumericoIncorrecto;
import excepciones.IOException;
import logica.Casilla;
import logica.Superficie;

public interface Celula {
	 public abstract Casilla ejecutaMovimiento(int f, int c, Superficie superficie);
	 public abstract void guardar(FileWriter fw) throws IOException ;
	 public abstract void cargar(Scanner sc) throws FormatoNumericoIncorrecto;
	 public abstract boolean esComestible();
	}