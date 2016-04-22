package part2;

import Part1.ListaPalabras;

public class checkingLevenhstain {
	public static void main (String []args){
		ListaPalabras palabras = new ListaPalabras();
		palabras.insertarPalabra("pablo");
		palabras.insertarPalabra("paula");
		palabras.insertarPalabra("pepa");
		palabras.insertarPalabra("juan");
		LevenshtainDistance palabra = new LevenshtainDistance();
		palabra.insertLevenhstain(palabras);
		palabra.palabras.consultarLetra(' ');
	}

}
