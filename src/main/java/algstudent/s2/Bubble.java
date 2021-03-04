package algstudent.s2;

import javax.rmi.CORBA.Util;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the BUBBLE or DIRECT EXCHANGE */
public class Bubble extends Vector {
	public Bubble(int nElements) {
		super(nElements);
	}

	@Override
	public void sort() {
		/*
		 * each item is compared with the previous one
		 */
		for(int i = 1; i < elements.length; i++) { //positions
			for(int j = elements.length - 1; j >= i; j--) {
				if(elements[j]<=elements[j-1]) {
					interchange(j-1, j);
				}
			}
		}
		
	}  
	
	@Override
	public String getName() {
		return "Bubble";
	} 
} 

