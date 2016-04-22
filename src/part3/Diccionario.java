package part3;



public class Diccionario implements iDiccionario{
	DNode header;
	DNode trailer;
	public Diccionario(){
		header = new DNode (null);
		trailer = new DNode (null);
		header.next=trailer;
		trailer.prev=header;
	}
/**DECISSION**
 As the structure of the list is inspired in double linked list to perform a better sorting, the words will be added at the end of the array and then sorted alphabetically 
 * 
 */
	public void insertaPalabras(String p) {
		DNode palabra = new DNode (p);
		System.out.println("Executing insertion");
		if(isEmpty()){
		palabra.next= header.next.next;
		header.next.prev=palabra;
		header.next=palabra;
		palabra.words.insert(p);
		palabra.words.update(p);
		palabra.words.eliminate(p);
		System.out.println("The word " + p + " has been added to the collection");

		}
		else if (isPalabra(p)){
			System.out.println("The word is already in the collection");
		}
		
		else {
			
			palabra.next=trailer;
			trailer.prev.next=palabra;
			trailer.prev=palabra;
			palabra.words.insert(p);
			palabra.words.update(p);
			palabra.words.eliminate(p);
			System.out.println("The word " + p + "has been added to the collection");
			
		}
		FALTA ORDENARLAS ALFABETICAMENTE!!!!!
			
	}

	/**DECISSION**
	 * This method will search whether a word is or not in the list returning a boolean
	 */
	
	public boolean isPalabra(String p){
		int i = 0; 
		int t = 0;
		System.out.println("Executing buscarPalabra");
		for(DNode aux = header; aux!=trailer; aux=aux.next){
	
			if(p.equals(aux.elem)) {
				t=i;
				}
			i++;
		}
		System.out.println("Method ended");
		if(t!=0){
		System.out.println("The word " + p + " is at the position " + t);
		return true;
		}
		else {
			System.out.println("The word " + p + " is not in the list");
			return false;
		}
	}
	/**DECISSION**
	 * This method will search through the list and eliminate the word that is equal to the String parameter by ignoring the node the word is in
	 */
	public void eliminarPalabra(String p) {
		DNode control = null;
		DNode aux2 = null;
		for(DNode aux = header; aux!=trailer;aux=aux.next){
			control=aux2;
			aux2=aux;
			if(aux2.elem.equals(p)){
				control.next=aux;
				aux.prev=control;
				aux2=aux2.next;
				
			}
		}
		
	}
	
	
	/**DECISSION**
	 * This method will search for a given word and return its position as well as the word and all its variants
	 * 
	 */
	public int buscarPalabra(String p) {
		int i = 0; 
		int t = 0;
		System.out.println("Executing buscarPalabra");
		for(DNode aux = header; aux!=trailer; aux=aux.next){
	
			if(p.equals(aux.elem)) {
				t=i;
				System.out.println("The word " + p + " is at the position " + t);
				System.out.println("The variants of the word " + p + " are " );
				 aux.words.palabras.consultarLetra(' ');
			i++;
		}
		}
		System.out.println("Method ended");
		
		if(t==0) {
			System.out.println("The word " + p + " is not in the list");

		}
		return t;
	}
	// This method check if the list is empty or not;
	public boolean isEmpty(){
		return (header.next==null);
	}

}
