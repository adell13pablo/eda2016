package Part1;

public class ListaPalabras implements iListaPalabras{

	DNode header;
	DNode trailer;
	public ListaPalabras(){
		header = new DNode(null);
		trailer = new DNode(null); // Methods are inspired in the double linked list
		header.next= trailer; // And the words are added at the end of the list
		trailer.prev=header;
	}
	 /*** DECISSION***
	 We have defined a base case to avoid any error if the list is empty
	 If the list is not empty, we add the new element at the end of the list
	 Also, we show a security message to be sure that the method have been successfully used 
	  */


		public void insertarPalabra(String palabra) {
		DNode nuevapalabra = new DNode(palabra);
		if(isEmpty()){ 
			nuevapalabra.next=header.next;
			header.next.prev= nuevapalabra;
			header.next=nuevapalabra;
		}
		else{ 
//			DNode aux = header;
//			DNode aux2 = null;
//			while(aux!=trailer){
//				aux2=aux;
//				aux=aux.next;
//			}
			nuevapalabra.next=trailer;
			trailer.prev.next=nuevapalabra;
			trailer.prev=nuevapalabra;
		}
		System.out.println("The word " + palabra + " has been added"); 
		}
		
	/*** DECISSION***
	 We implement a method to remove the chosen word to do so, we have made an auxiliary node to be able to remove the node which contains the word
	 Also, to be able to identify the word, we must go through all the list 
	 Finally, if the method is able to remove the word it prints a message notifying everything was right
	 */
	 
		public void eliminarPalabra(String palabra) { 
			if(isEmpty()) System.out.println("The list is empty, the word cannot be removed");
			DNode aux = header; 
			while(aux!=trailer){ 
				aux=aux.next;
				if(palabra.equals(aux.elem)){
					aux.next=aux.next.next;
					aux.next.prev=aux;
					System.out.println("The word has been succesfully removed"); 
				} 
			}
			
		}
	/***DECISSION***
	 We check every position in the list to see if the word is equal to the given one
	 If it is, we return the position
	 When the method is over, we return -1 and a security message
	 */
		@Override
		public int buscarPalabra(String palabra) {
			int i = 0; 
			int t = 0;
			System.out.println("Executing buscarPalabra");
			for(DNode aux = header; aux!=trailer; aux=aux.next){
		
				if(palabra.equals(aux.elem)) {t=i;}
				i++;
			}
			System.out.println("Method ended");
			if(t!=0){
			System.out.println("The word " + palabra + " is at the position " + t);
			}
			else {
				System.out.println("The word " + palabra + " is not in the list");

			}
			return t;
		}

		/*** DECISSION***
		 First, we create a control node to go from the header to the trailer. Then, we split the element of the node into a array of chars in order to be able
		 to compare it with the parameter. We start at the next position of the header due to this node contains  null element. 
		 Then, we make another loop to compare every char with the parameter. All the positive comparisons of the word will be printed in the screen. 
		 If a word has been positively compared, we will avoid adding twice the same word by adding a break item;
		 */
		public void consultarLetra(char c) {
			System.out.println("Executing consultarLetra");
			String result = "";
			String resultspace = "";
			if(c==' '){
				for(DNode auxspace = header.next; auxspace!=trailer;auxspace=auxspace.next){
					resultspace += " " + auxspace.elem + ",";
				}
				System.out.println("The list contains the words" + resultspace);
				
			}
			else {
			for(DNode aux = header.next; aux!=trailer; aux=aux.next){
				char [] split = aux.elem.toCharArray();
				for(int i = 0; i<split.length;i++){
					if(split[i]==c){
						
//						System.out.println("The char " + c + " is contained in " + aux.elem);
						result += " " + aux.elem + ",";
						break;
					}
	
				}
			}
			System.out.println("The words in the list containing the character " + c + " are" + result);
				
			}
		}
		
		/*
		 * This method will split the String into a character array 
		 */
		public char [] splitword( String palabra){
//			System.out.println(palabra);
			int y = palabra.length();
			char [] split = new char [y];
			split = palabra.toCharArray();
			return split;
		}
		/*** DECISSION***
		 We check if the list has any element by calling the isEmpty() method to the header,
		  if its reference is null, then the list will be empty and will return 0
		  If it is not empty we will check until the auxiliary node reaches the trailer position,
		  to do so, we use a control variable in order to count every position in the list.
		 */
	public int getSize(){
		int i = 0;
		if(isEmpty()) return 0;
		else{
			
			for(DNode aux = header;aux!=trailer;aux=aux.next){
				i++;
			}
			return i;
		}
	}

	/*** DECISSION***
	 We check the first position in the list in order to see whether it is empty or not 
	 */
	public boolean isEmpty(){
		return (header.next==null);
	}
	
/**** DECISSION***
The method will check whether the word is or not in the list, if it is, it will return the position, if it is not, it will return -1
*/
//public int buscarPalabra(String palabra) {
//   
//   DNode aux = header;
//   int i = 0; 
//   int u = 0;
//   while (aux!=trailer){
//       aux=aux.next;
//       i++;
//       if(aux.elem.equals(palabra)) u=i;;
//   }
//   if(u==0) u=-1;
//   return u;
//   
//}

/** DECISSION**
 This method will return the element at the position indicated in the parameter
 */
public String returnpos(int pos){
	int i = 0;
	String result = "";
	for(DNode aux = header.next;aux!=trailer;aux=aux.next){
		if(i==pos){
			result = aux.elem;
			break;
		}
		i++;
	}
	return result;
}


}

