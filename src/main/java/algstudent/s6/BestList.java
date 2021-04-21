package algstudent.s6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.BackingStoreException;

public class BestList {

	private static List<String> List01;
	private String file;
	private List<String> ListA;
	private List<String> ListB;
	private static int numberOfSongs; 
	private boolean solved;
	private int lengthBlocks = 20;	
	
	public static void main(String args[]) { 
		String fileName = Paths.get("").toAbsolutePath().toString() + "/src/main/java/algstudent/s6/List01.txt";
		List01 = readFromFile(fileName);
		int lengthBlocks = 20 * 60;
		String n = List01.get(0);
		numberOfSongs = Integer.parseInt(n);
		System.out.println("Number of songs: " + numberOfSongs);
		System.out.println();
		System.out.println("List of songs:");
		for(int i=1;i<List01.size();i++) {
			String[] parts = List01.get(i).split("\t");
			String[] ID = parts[0].split(",");
			String[] time = parts[1].split(",");
			String[] s = parts[2].split(",");
			
			String[] min = time[0].split(":");
			
			String id = ID[0];
			int seconds = Integer.parseInt(min[0])*60 + Integer.parseInt(min[1]);
			int score  = Integer.parseInt(s[0]);
			System.out.println("id: " + id + "	seconds: " + min[0] + ":" + min[1] + "	 score: " + score);
		}
		
		System.out.println();
		System.out.println("Length of the blocks: " + lengthBlocks/60);
		System.out.println("Total score: " );
		System.out.println("Total counter: ");
	}
	
	public BestList(String file, int lengthBlocks) {
		this.file = file;
		this.lengthBlocks = lengthBlocks;
		
		readFromFile(file);
	}
	
	private void backtracking(int level) {
		if(level == lengthBlocks) {
			solved = true;
		}
		else {
			int j = 0;
			int k = 0;
			int totalA = 0;
			int totalScoreA = 0;
			int totalB = 0;
			int totalScoreB = 0;
			
			for(int i = 0; i < 2; i++) {
				if(i==0) {
					doNothing();
				}
				if(i==1 && ListA.size()<numberOfSongs && totalA < lengthBlocks) { 
					ListA.add(List01.get(j));
					
					for(int n = 0;n<ListA.size();n++) {
						String[] parts = ListB.get(i).split("\t");
						String[] time = parts[1].split(",");
						String[] min = time[0].split(":");
						int seconds = Integer.parseInt(min[0])*60 + Integer.parseInt(min[1]);
						totalA = totalA + seconds;
						String[] s = parts[2].split(",");
						int score  = Integer.parseInt(s[0]);
						totalScoreA = totalScoreA + score;
						
					}
					
					System.out.println(ListA.get(i).split("\t"));
					j++;
					backtracking(level++);
					ListA.remove(List01.get(j));
					
				}
				if(i==2 && ListB.size()<numberOfSongs && totalB < lengthBlocks ) { 
					ListB.add(List01.get(k));
					for(int n = 0;n<ListB.size();n++) {
						String[] parts = ListB.get(i).split("\t");
						String[] time = parts[1].split(",");
						String[] min = time[0].split(":");
						int seconds = Integer.parseInt(min[0])*60 + Integer.parseInt(min[1]);
						totalB = totalB + seconds;
						String[] s = parts[2].split(",");
						int score  = Integer.parseInt(s[0]);
						totalScoreB = totalScoreB + score;
					}
					k++;
					backtracking(level++);
					ListB.remove(List01.get(k));
				}
			}
		}
		
	}
	
	/*private boolean valid(int level) {
		
	}*/
	
	private void doNothing() {
		// TODO Auto-generated method stub
		
	}

	private static List<String> readFromFile(String file) {
		List01 = new ArrayList<String>();
		BufferedReader reader = null; 	
		try {
			reader = new BufferedReader(new FileReader(file)); 	
			while (reader.ready()) { 
				List01.add(reader.readLine());
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return List01; 
	}
}
