package algstudent.s1;

public class Vector3 {
	static int[] v;
	
	
		public static void main(String[] args) {
			long t1, t2;
			int sum = 0;
			
			for(int n=1;n<Integer.MAX_VALUE; n*=5) {
				v = new int[n];	
				Vector1.fillIn(v);
				
				t1 = System.currentTimeMillis();
				
				sum = Vector1.sum(v);
				
				t2 = System.currentTimeMillis();
				
				System.out.printf("SIZE=%d TIME=%d miliseconds SUM=%d\n", n, t2-t1, sum);
			}
			

		}

}
