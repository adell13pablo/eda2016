package Part3;

public interface iDiccionario {
	public void insertaPalabras(String p);
	public void eliminarPalabra(String p);
	public int buscarPalabra (String p);
	public boolean isEmpty();
	public boolean isPalabra(String p);

}
