package adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {

	// set by input file content before run
	private static final int COLUMN_COUNT = 3;

	public static void main(String[] argv) throws IOException {

		String[] lines = Files.readString(Path.of("day5.txt")).split("\r\n");
		int li = 0;
		
		List<List<Character>> columns = new ArrayList<List<Character>>();
		
		for(int c = 0; c < COLUMN_COUNT; c++) {
			columns.add(new ArrayList<Character>());
		}
		
		
		while(lines[li].contains("[")) {
			
			String line = lines[li];
			
			for(int c = 0; c < COLUMN_COUNT; c++) {
				char columnChar = line.charAt(1 + c * 4);
				if(columnChar != ' ') {
					columns.get(c).add(columnChar);
				}
			}
			
			li++;
		}
		
		li += 2;
		
		System.out.println(columns);
		
		while(li < lines.length) {
			
			System.out.println(lines[li]);
			Scanner lScan = new Scanner(lines[li]);

			lScan.next("move");
			int n = lScan.nextInt();
			lScan.next("from"); 
			int from = lScan.nextInt() - 1;
			lScan.next("to");
			int to = lScan.nextInt() - 1;

			for(int r = 0; r < n; r++) {
				
				Character removed = columns.get(from).remove(0);
				
				// part A
				// columns.get(to).add(0, removed);
				
				// part B
				columns.get(to).add(r, removed);
			}
			
			li++;
	
		}
		
		System.out.println(columns);
	}	
	
}
