package adventofcode;

import java.util.HashSet;
import java.util.Set;

public class Day6 {

	public static void main(String[] args) {

		
		final String IN = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
		final int NCHAR = 14; // part 2

		for(int p = 0; p < IN.length() - NCHAR; p++) {
			
			Set<Character> content = new HashSet<Character>();
			
			// part A
			// content.add(IN.charAt(p));
			// content.add(IN.charAt(p+1));
			// content.add(IN.charAt(p+2));
			// content.add(IN.charAt(p+3));
			// ---> NCHAR was literal of 4 while solving part A
			
			// part B
			for(int i = 0; i < NCHAR; i++) {
				content.add(IN.charAt(p + i));
			}
			
			if(content.size() == NCHAR) {
				System.out.println(p + NCHAR);
				break;
			}
		}

	}

}
