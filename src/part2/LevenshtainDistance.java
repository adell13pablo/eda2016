package part2;


import Part1.ListaPalabras;

public class LevenshtainDistance {
	final char [] alphabet; // This constant will store the alphabet we need to create every possible variant of the words 
public	ListaPalabras palabras; // The different words we will create, will be stored in a new list
	
	public LevenshtainDistance(){
		alphabet= new char [] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		palabras = new ListaPalabras();
	}
	
	/** DECISSION **
	 This method will perform the change of each character in the given word in all the positions in this word
	 in order to create every possible variants of the word. Then, once every loop in the method is achieve every variant is added to the ListaPalabras object
	 
	 */
	public void update(String palabra){
		char [] update = new char [palabra.length()];
		update= palabra.toCharArray();
		int [] poss = new int [update.length];
		System.out.println("Executing update");
		for(int i = 0; i<update.length;i++){
			int pos = (int) ((Math.random()*update.length)-1);
				for(int j = 0; j<poss.length;j++){
						if(pos==poss[j]){
							while(pos==poss[j]){
								pos = (int) ((Math.random()*update.length));
							}
						}
						else poss[j] = pos;
					}
		for(int g = 0; g<alphabet.length;g++){
			char [] arra= new char [update.length];
			for(int f = 0; f<update.length;f++){
				arra[f]= update[f]; 
			}
			System.out.println(pos);
			arra[pos] = alphabet[g];
			palabras.insertarPalabra(String.valueOf(arra));
		}
		
		}
	}
	
	/** DECISSION **
	 This method will perform the insertion of each character in the given word in all the positions in this word
	 in order to create every possible variants of the word. Then, once every loop in the method is achieve every variant is added to the ListaPalabras object
	 
	 */
	
public void insert(String palabra){
	char [] insert = new char [palabra.length()];
	insert= palabra.toCharArray();
	int [] poss = new int [insert.length];
	System.out.println("Executing insert");
	for(int i = 0; i<insert.length;i++){
		int pos = (int) ((Math.random()*insert.length)+1);
			for(int j = 0; j<poss.length;j++){
					if(pos==poss[j]){
						while(pos==poss[j]){
							pos = (int) ((Math.random()*insert.length)-1);
						}
					}
					else{
						poss[j] = pos;
					}
				}
	for(int g = 0; g<alphabet.length;g++){
		char [] arra= new char [insert.length+1];
		int d= 0;
		for(int f = 0; f<arra.length;f++){
			
			System.out.println(d);
			if(f==pos) {
				arra[f] = alphabet[g];
				d--;
				
			}
			else{ 
				arra[f]= insert[d]; 
			}
			d++;
		}
		
		palabras.insertarPalabra(String.valueOf(arra));
	}
	
	}
	
}
 /**DECISSION**
  This method eliminate in one operation a character from a given word in order to make all possible variants
  */
public void eliminate(String palabra){
	char [] eliminate = new char [palabra.length()];
	eliminate= palabra.toCharArray();
	int [] poss = new int [eliminate.length];
	System.out.println("Executing eliminate");
	for(int i = 0; i<eliminate.length;i++){
		int pos = (int) ((Math.random()*eliminate.length)+1);
			for(int j = 0; j<poss.length;j++){
					if(pos==poss[j]){
						while(pos==poss[j]){
							pos = (int) ((Math.random()*eliminate.length)-1);
						}
					}
					else{
						poss[j] = pos;
					}
				}
			char [] arra = new char [eliminate.length-1];
			int v= 0;
			for(int s = 0; s<arra.length;s++){
				if(s==pos){
					v++;
				}
				arra[s]=eliminate[v];
				v++;
				
			}
			palabras.insertarPalabra(String.valueOf(arra));
	}
}
///*
// * This method is to pass the values from one char to another
// */
//	public char[] passchar(char [] arra){
//		char [] pass = new char[arra.length];
//		for(int i = 0; i<pass.length;i++){
//			pass[i]=arra[i];
//		}
//		return pass;
//	}
//	
//	/*
//	 * This method will change characters in an array
//	 */
//	public char [] change(char [] lsit, char c, int pos){
//		char [] nw = new char [lsit.length +1];
//		int y = 0;
//		for(int i = 0; i<nw.length;i++){
//			y++;
//			if(i==pos) { 
//				nw[i]=c;
//				y--;
//			}
//			else {
//			nw[i]=lsit[y];
//		}
//		}
//	return nw;	
//	}
//	
//	
	public void insertLevenhstain(ListaPalabras plabras){
		for(int i = 0; i<plabras.getSize();i++){
			insert(plabras.returnpos(i));
			update(plabras.returnpos(i));
			eliminate(plabras.returnpos(i));

		}
		
	}

}
