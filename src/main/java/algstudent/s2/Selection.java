package algstudent.s2;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the SELECTION */
public class Selection extends Vector {
	public Selection(int nElements) {
		super(nElements);
	}
	
	@Override
	public void sort() {
		/*
		 * lowest change first
		 */
		for (int i = 0; i < elements.length - 1; i++) 
		{
		    for (int j = i + 1; j < elements.length; j++) 
		    {
		        int min = elements[j];
		        if (min < elements[i]) 
		        {
		            int aux = elements[i];
		            elements[i] = elements[j];
		            elements[j] = aux;
		        } 
		    } 
		} 
	}  
	
	@Override
	public String getName() {
		return "Selection";
	} 
} 
