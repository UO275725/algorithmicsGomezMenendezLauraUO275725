package algstudent.s1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatrixOperations {

	public static void main(String[] args) {
		int n = 3;
		int min = 0;
		int max = 100;
		int matrix[][]  = new int[n][n];
		MatrixOperations(matrix,n,min, max);
		

	}
	
	public static void MatrixOperations(int[][] matrix, int n, int min, int max) {
		 
		
		for (int x=0; x < matrix.length; x++) {
			for (int y=0; y < matrix[x].length; y++) {
				matrix[x][y] = (int) (Math.random()*max+1);
				while((matrix[x][y]<min)||(matrix[x][y]>max)) {
					matrix[x][y] = (int) (Math.random()*max+1);
				}
			  
			}
		}
		write(matrix);
		
	}
	
	public static void MatrixOperations(int[][] matrix, String filename) {
		//int[][] matrix;
		 
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			String line = br.readLine();
			int length = Integer.parseInt(line);
			matrix = new int[length][length];
			
			line = br.readLine();
			int row = 0; 
			while(line != null) {
				String[] integers = line.split(" ");
				for (int i = 0; i < integers.length; i++)
					matrix[row][i] = Integer.parseInt(integers[i]);
 
				row++; 
				line = br.readLine(); 
			}
			br.close(); 
		} catch (IOException e) {
			System.out.println("Error accesing the file.");
			e.printStackTrace();
		}
	}
	
	public static int getSize(int matrix[][]) {
		int size = matrix.length;
		return size;
	}
	
	public static void write(int matrix[][]) {
		for (int x=0; x < matrix.length; x++) {
			System.out.print("");
			for (int y=0; y < matrix[x].length; y++) {
			   System.out.print (matrix[x][y]);
			   if (y!=matrix[x].length-1) {
				   System.out.print("\t");
			   }
			}
			System.out.println("");
		}
	}
	
	public static int sumDiagonal1(int matrix[][]) {
		int[] diagonal1 = new int[matrix.length];
		int sum = 0;
		
		for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i==j){
                    diagonal1[i] = matrix[i][j];
                    sum = sum + diagonal1[i];
                }
            }
		}
		
		return sum;
	}
	

	public static void travelPath(int[][] matrix,int i, int j) {
		
		for(int x=0;x<10;x++) {
			if(matrix[i][j]==1) {
				matrix[i][j] = -1;
				i--;
			}
			if(matrix[i][j]==2) {
				matrix[i][j] = -1;
				j++;
			}
			if(matrix[i][j]==3) {
				matrix[i][j] = -1;
				i++;
			}
			if(matrix[i][j]==4) {
				matrix[i][j] = -1;
				j--;
			}
		}
	}
}
