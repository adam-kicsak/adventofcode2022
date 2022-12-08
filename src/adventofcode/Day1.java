package adventofcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day1 {

	public static void main(String[] args) {
		
		String[] split = IN.split("\n");	
		List<Integer> ilist = new ArrayList<>();
		int accum = 0;
	 
		for (String s : split) {
			
			if(s.isEmpty()) {
				ilist.add(accum);
				accum = 0;
			} else 
				accum += Integer.valueOf(s);
		}

		ilist.add(accum);
		
		Collections.sort(ilist, Comparator.reverseOrder());

		// part A
		System.out.println(ilist.get(0));

		// part B
		System.out.println(ilist.get(0) + ilist.get(1) + ilist.get(2));
	}	
	
	static String IN = """
1000
2000
3000

4000

5000
6000

7000
8000
9000

10000""";

}
