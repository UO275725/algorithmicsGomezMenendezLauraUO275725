package algstudent.s4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import algstudent.s32.Inversions;

public class SegmentsPlacement {
	
	private static List<Integer> game;
	
	public static void main(String args[]) { 
		int numberFiles = 2;
		
		for (int i = 1; i <= numberFiles; i++) {
			String fileName = Paths.get("").toAbsolutePath().toString() + "/src/main/java/algstudent/s4/game" + i + ".txt";
			System.out.println("FILE: " + fileName);  
			game = readGameFromFile(fileName);	
			System.out.println("Cost of greedy 1 = " + greedy1() + " pufosos"); 	
			System.out.println("Cost of greedy 2 = " + greedy2() + " pufosos");
			System.out.println("Cost of greedy 3 = " + greedy3() + " pufosos");
	        System.out.println("\n****************************\n");
		}	

	}
	
	public static double greedy3() {
		double pufosos = 0;
		int[] gameArray = new int[game.size()];
		
		for(int i=1;i<game.size();i++) {
			gameArray[i] = game.get(i);
		}
		
		int aux;

	    for (int i = 0; i < gameArray.length - 1; i++) {
	        for (int x = i + 1; x < gameArray.length; x++) {
	            if (gameArray[x] < gameArray[i]) {
	                aux = gameArray[i];
	                gameArray[i] = gameArray[x];
	                gameArray[x] = aux;
	            }
	        }
	    }
		
		System.out.println("---------GREEDY3--------");
		long a = 0;
		long b =  gameArray[1];
		System.out.println("(" + a + " to " + b + "), midpoint= " + (a+b)/2);
		pufosos = pufosos + (a+b)/2;
		for(int i=2;i<gameArray.length;i++) {
			a = b;
			b = gameArray[i]+b;
			System.out.println("(" + a + " to " + b + "), midpoint= " + (a+b)/2.);
			pufosos = pufosos + (a+b)/2.;
		}
		return pufosos;
	}

	public static double greedy2() {
		double pufosos = 0;
		int[] gameArray = new int[game.size()];
		
		for(int i=1;i<game.size();i++) {
			gameArray[i] = game.get(i);
		}
		
		int aux;

	    for (int i = 1; i < gameArray.length -1; i++) {
	        for (int x = i + 1; x < gameArray.length; x++) {
	            if (gameArray[x] > gameArray[i]) {
	                aux = gameArray[i];
	                gameArray[i] = gameArray[x];
	                gameArray[x] = aux;
	            }
	        }
	    }
		
		System.out.println("---------GREEDY2--------");
		long a = 0;
		long b =  gameArray[1];
		System.out.println("(" + a + " to " + b + "), midpoint= " + (a+b)/2);
		pufosos = pufosos + (a+b)/2;
		for(int i=2;i<gameArray.length;i++) {
			a = b;
			b = gameArray[i]+b;
			System.out.println("(" + a + " to " + b + "), midpoint= " + (a+b)/2.);
			pufosos = pufosos + (a+b)/2.;
		}
					
		return pufosos;
	}

	public static double greedy1() {
		double pufosos = 0;
		
		int[] gameArray = new int[game.size()];
		for(int i=1;i<game.size();i++) {
			gameArray[i] = game.get(i);
		}
		System.out.println("---------GREEDY1--------");
		long a = 0;
		long b =  gameArray[1];
		System.out.println("(" + a + " to " + b + "), midpoint= " + (a+b)/2.);
		pufosos = pufosos + (a+b)/2;
		for(int i=2;i<gameArray.length;i++) {
			a = b;
			b = gameArray[i]+b;
			System.out.println("(" + a + " to " + b + "), midpoint= " + (a+b)/2.);
			pufosos = pufosos + (a+b)/2.;
		}
		return pufosos;
	}

	private static List<Integer> readGameFromFile(String file) {
		BufferedReader fich = null;
		String line;
		List<Integer> elements = new ArrayList<Integer>();

		try {
			fich = new BufferedReader(new FileReader(file));
			line = fich.readLine(); //first element of the file
			while (line != null) {
				elements.add(Integer.parseInt(line));
				line = fich.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("There is no file: "+file);
		} catch (IOException e) {
			System.out.println("Error reading the file: "+file);
		} finally {
			if (fich!=null)
				try {
					fich.close();
				} catch (IOException e) {
					System.out.println("Error closing the file: "+file);
					e.printStackTrace();
				}
		}

		return elements;
	}

}
