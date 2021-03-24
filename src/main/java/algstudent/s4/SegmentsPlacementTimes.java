package algstudent.s4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algstudent.s1.MatrixOperations;

public class SegmentsPlacementTimes {
	
	public static void main(String arg[]) { 
		int nTimes = Integer.parseInt(arg[0]);
		long t1, t2;
		
		for(int n=100;n<Integer.MAX_VALUE; n*=2) {
			
			t1 = System.currentTimeMillis();
			
			for(int repetitions=1; repetitions<=nTimes; repetitions++) {
				
				greedy1(n);
				//greedy2(n);
				//greedy3(n);
			}
			
			t2 = System.currentTimeMillis();
			
			System.out.printf("SIZE: " + n + ", TIME= " + (t2-t1) + " miliseconds\n");
		}
		
			
	    System.out.println("\n****************************\n");
	
			
	}

	public static void greedy3(int n) {
		double pufosos = 0;
		
		Random random = new Random();
		int[] gameArray = new int[n];
		for(int i=1;i<n;i++) {
			gameArray[i] = random.nextInt(101)+1;
		}
		int aux;

	    for (int i = 0; i < n - 1; i++) {
	        for (int x = i + 1; x < n; x++) {
	            if (gameArray[x] < gameArray[i]) {
	                aux = gameArray[i];
	                gameArray[i] = gameArray[x];
	                gameArray[x] = aux;
	            }
	        }
	    }
		
		long a = 0;
		long b =  gameArray[1];
		pufosos = pufosos + (a+b)/2;
		for(int i=2;i<n;i++) {
			a = b;
			b = gameArray[i]+b;
			pufosos = pufosos + (a+b)/2.;
		}
	}

	public static double greedy2(int n) {
		double pufosos = 0;
		
		Random random = new Random();
		int[] gameArray = new int[n];
		for(int i=1;i<n;i++) {
			gameArray[i] = random.nextInt(101)+1;
		}
		
		int aux;

	    for (int i = 1; i < n -1; i++) {
	        for (int x = i + 1; x < n; x++) {
	            if (gameArray[x] > gameArray[i]) {
	                aux = gameArray[i];
	                gameArray[i] = gameArray[x];
	                gameArray[x] = aux;
	            }
	        }
	    }
		
		long a = 0;
		long b =  gameArray[1];
		pufosos = pufosos + (a+b)/2;
		for(int i=2;i<n;i++) {
			a = b;
			b = gameArray[i]+b;
			pufosos = pufosos + (a+b)/2.;
		}
					
		return pufosos;
	}

	public static double greedy1(int n) {
		double pufosos = 0;
		
		Random random = new Random();
		int[] gameArray = new int[n];
		for(int i=1;i<n;i++) {
			gameArray[i] = random.nextInt(101)+1;
		}

		long a = 0;
		long b =  gameArray[1];
		pufosos = pufosos + (a+b)/2;
		for(int i=2;i<n;i++) {
			a = b;
			b = gameArray[i]+b;
			pufosos = pufosos + (a+b)/2.;
		}
		return pufosos;
	}



}
