package algstudent.s32;

import java.util.List;

public class InversionsQuadratic {
	
	long sum = 0;

	public InversionsQuadratic(List<Integer> ranking) {
		
		for(int i=0;i<ranking.size();i++) //O(n)
			for(int j=ranking.size()-1;j>i;j--) //O(n)
				if(i!=j) 
					if(ranking.get(j)<ranking.get(i))
						sum = sum + 1;
						
	}

	public long start() { 
		return sum;
	}

}
