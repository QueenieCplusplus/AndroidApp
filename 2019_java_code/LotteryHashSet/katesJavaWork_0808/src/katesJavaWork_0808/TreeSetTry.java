package katesJavaWork_0808;

import java.util.TreeSet;

public class TreeSetTry {
	
	public static void main(String args[]) {
		
		TreeSet<Object> ts = new TreeSet<Object>();
		ts.add("Starbucks");
		ts.add("2");
		ts.add("cake");
		ts.add("2");
		ts.isEmpty();
		System.out.println(ts);
		System.out.println(ts.isEmpty());
	}
}
