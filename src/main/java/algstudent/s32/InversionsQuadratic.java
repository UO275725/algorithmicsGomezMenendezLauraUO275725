package algstudent.s32;

import java.util.List;

public class InversionsQuadratic {
	
	private List<Integer> ranking;
	long sum = 0;

	public InversionsQuadratic(List<Integer> ranking) {
		this.ranking = ranking;
						
	}

	public long start() { 
		for(int i=0;i<ranking.size();i++) //O(n)
			for(int j=ranking.size()-1;j>i;j--) //O(n)
				if(i!=j) 
					if(ranking.get(j)<ranking.get(i))
						sum = sum + 1;
		return sum;
	}

}
