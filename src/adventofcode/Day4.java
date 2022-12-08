package adventofcode;

import java.util.regex.Pattern;

public class Day4 {

	public static void main(String[] args) {
		
		String[] in = IN.split("\n");
		int cntA = 0;
		int cntB = 0;
		
		for(String line : in) {
			int[] r = Pattern.compile("[,-]").splitAsStream(line).mapToInt(Integer::valueOf).toArray();

			// part A
			cntA += regionContains(r[0], r[1], r[2], r[3]) ? 1 : 0;
			
			// part B
			cntB += regionOverlaps(r[0], r[1], r[2], r[3]) ? 1 : 0;
		
		}
		
		System.out.println(cntA);
		System.out.println(cntB);

	}	
	
	// part B
	private static boolean regionOverlaps(int as, int ae, int bs, int be) {
		return (as <= bs && bs <= ae) || 
				(bs <= as && as <= be) ||
				(as <= be && be <= ae) ||
				(bs <= ae && ae <= be);
	}

	// part A
	private static boolean regionContains(int as, int ae, int bs, int be) {
		return (as <= bs && be <= ae) || (bs <= as && ae <= be);
	}

	static String IN = """
2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8""";	

}
