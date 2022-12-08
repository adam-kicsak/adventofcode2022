package adventofcode;

import java.util.List;
import java.util.stream.Collectors;

public class Day3 {

	public static void main(String[] args) {
		
		String[] split = IN.split("\n");	
		int accum = 0;
		
		// part A
		
		for (String s : split) {
			int half = s.length() / 2;
			List<Integer> halfchars = s.substring(0, half).chars().boxed().collect(Collectors.toList());
			char c = (char) s.substring(half).chars().filter(i -> halfchars.contains(i)).findFirst().getAsInt();
			
			accum += priority(c);
		}

		System.out.println(accum);

		// part B
		
		accum = 0;
		for (int i = 0; i < split.length; i+=3) {
			char c = find(split[i], split[i+1], split[i+2]);
			accum += priority(c);
		}
		
		System.out.println(accum);

	}	
	
	private static char find(String s1, String s2, String s3) {

		for(char c = 'a'; c <= 'z'; c++) {
			if(s1.contains(String.valueOf(c)) && s2.contains(String.valueOf(c)) && s3.contains(String.valueOf(c))) {
				return c;
			}
		}
	
		for(char c = 'A'; c <= 'Z'; c++) {
			if(s1.contains(String.valueOf(c)) && s2.contains(String.valueOf(c)) && s3.contains(String.valueOf(c))) {
				return c;
			}
		}
		
		return '\0';
	}

	private static int priority(char c) {
		
		if( 'a' <= c && c <= 'z') {
			return (int) (c - 'a') + 1;
		}
		if( 'A' <= c && c <= 'Z') {
			return (int) (c - 'A') + 27;
		}
		return 0;
	}

	static String IN = """
vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw""";

}
