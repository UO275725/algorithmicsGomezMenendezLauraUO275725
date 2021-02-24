package algstudent.s1;

public class MatrixTime {
	public static void main(String[] arg) {
		int nTimes = Integer.parseInt(arg[0]);
		long t1, t2;
		
		for(int n=10;n<Integer.MAX_VALUE; n*=3) {
		
			int matrix[][]  = new int[n][n];
			//MatrixOperations.MatrixOperations(matrix, nTimes, 0, 100);
			
			t1 = System.currentTimeMillis();
			
			for(int repetitions=1; repetitions<=nTimes; repetitions++) {
				
				MatrixOperations.sumDiagonal1(matrix);
				
			}
			
			
			t2 = System.currentTimeMillis();
			
			System.out.printf("SIZE=%d TIME=%d hundreds of microseconds\n", n, t2-t1);
		}
		
		
	}
}
