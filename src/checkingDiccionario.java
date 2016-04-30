package Part3;

public class checkingDiccionario {
	public void main (String []args){
		Diccionario diccionario = new Diccionario();
		String [] palabras ={ "pato", "rey", "libro", "silla"};
		for(int i = 0; i<palabras.length;i++){
			diccionario.insertaPalabras(palabras[i]);
			diccionario.buscarPalabra("pato");
			diccionario.eliminarPalabra("sila");
		}
	}

}
