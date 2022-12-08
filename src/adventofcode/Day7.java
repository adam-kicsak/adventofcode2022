package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day7 {

	
	public static void main(String[] argv) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File("day7.txt"));
		
		D r = new D(null, "/");
		D c = r;
		
		
		while(s.hasNext("\\$")) {
			s.next("\\$");
			if(s.hasNext("cd")) {
				s.next("cd");
				String dir = s.next();
				if("/".equals(dir)) {
					c = r;
				} else if("..".equals(dir)) {
					c = c.u;
				} else {
					c = new D(c, dir);
				}
			} else if(s.hasNext("ls")) {
				s.next("ls");
				while(!s.hasNext("\\$") && s.hasNext()) {
					if(s.hasNext("dir")) {
						s.next();
						s.next();
					} else {
						long fs = s.nextLong();
						String file = s.next();
						c.e.add(new F(c, file, fs));
					}
				}
			}
		}
		
		System.out.println(r);
		
		List<Long> sizes = new ArrayList<Long>();
		r.rs(sizes);
		
		System.out.println(sizes);

		
		
		// part A
		
		long sum = sizes.stream()
			.mapToLong(Long::longValue)
			.filter(l -> l <= 100000)
			.sum();
		
		System.out.println(sum);
		
		
		
		// part B
		
		long SPACE = 70000000L;
		long REQ = 30000000L;
		
		long tresholdSize = r.s() + REQ - SPACE;
		
		long toDelete = sizes.stream()
				.filter(size -> size >= tresholdSize)
				.sorted()
				.findFirst()
				.get();
		
		System.out.println(toDelete);
		
		
	}
	
	
}


interface E {
	long s();
}

class F implements E {
	
	D u;
	long s;
	String n;

	public F(D u, String n, long s) { this.u = u; this.n = n; this.s = s; }

	@Override
	public long s() {
		return s;
	}
	
	@Override
	public String toString() {
		return n + " (" + s + ")";
	}
}

class D implements E {

	final D u;
	final List<E> e = new ArrayList<>();
	final String n;

	public D(D u, String n) {
		this.n = n;
		if(u == null) {
			this.u = this;
		} else {
			this.u = u;
			u.e.add(this);
		}
	}

	public void rs(List<Long> sizes) {
		sizes.add(s());
		e.stream()
			.filter(D.class::isInstance)
			.map(D.class::cast)
			.forEach(d -> d.rs(sizes));
	}

	@Override
	public long s() {
		return e.stream().mapToLong(E::s).sum();
	}
	
	@Override
	public String toString() {
		return n + " [dir] (" + s() + ") --> " + e;
	}
}

