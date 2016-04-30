package Part3;

import Part2.LevenshtainDistance;

public class DNode {
	DNode next;
	DNode prev;
	String elem;
	LevenshtainDistance words;
	public DNode(String elem){
		this.elem=elem;
		words = new LevenshtainDistance();
	}

}
