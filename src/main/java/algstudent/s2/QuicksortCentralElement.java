package algstudent.s2;


/* This program can be used to sort n elements with 
 * the best algorithm of this lab. It is the QUICKSORT */
public class QuicksortCentralElement extends Vector {
	
	public QuicksortCentralElement(int nElements) {
		super(nElements);
	}
	
	private void quickSort(int left, int right) {
		if(left >=right) return;
	    int leftI = left;
	    int rightI = right;
	    int pivot = elements[left + (right - left)/2]; 
	    while(leftI<=rightI)
	    {
	        while(elements[leftI]  < pivot )leftI++;   
	        while(elements[rightI] > pivot )rightI--;  
	        if(leftI <=rightI)
	        {
	            interchange(leftI, rightI);
	            leftI++;
	            rightI--;
	        }
	    }
	    if(left < rightI)quickSort(left,rightI); 
	    if(leftI < right)quickSort(leftI,right); 
		
	}

	@Override
	public void sort() {
		quickSort(0, elements.length-1);		
	}
	
	@Override
	public String getName() {
		return "Quicksort - Central element";
	} 
} 
