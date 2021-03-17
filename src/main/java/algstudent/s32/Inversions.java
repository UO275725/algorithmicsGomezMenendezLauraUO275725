package algstudent.s32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Inversions {

	public long sum = 0;
	public Inversions(List<Integer> ranking) {
		/*
		Integer[] left = null;
		Integer[] right = null;
		for(int i=0;i<ranking.size()/2;i++) {
			left[i] = ranking.get(i);
		}
		for(int i=ranking.size()/2;i<ranking.size()+1;i++) {
			
			right[i] = ranking.get(i);
		}
		
        int i = 0;
        int j = 0;
  
		int l = 0;
		int k = l;
		
 
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                ranking.add(k+1, left[i++]);
            else {
            	 ranking.add(k+1, right[j++]);

				int m = 0;
				sum += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
        	 ranking.add(k+1, left[i++]);
        while (j < right.length)
        	ranking.add(k+1, right[j++]);
        
	}
	
	private static int mergeSortAndCount(int[] arr, int l,
            int r)
			{
			
			// Keeps track of the inversion count at a
			// particular node of the recursion tree
			int count = 0;
			
			if (l < r) {
			int m = (l + r) / 2;
			
			// Total inversion count = left subarray count
			// + right subarray count + merge count
			
			// Left subarray count
			count += mergeSortAndCount(arr, l, m);
			
			// Right subarray count
			count += mergeSortAndCount(arr, m + 1, r);
			
			// Merge count
			//count += mergeAndCount(arr, l, m, r);
			}
			
return count;*/
}
	public long start() {
		return 0;
	}

}
