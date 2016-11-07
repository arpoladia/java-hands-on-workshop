package examples.containers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTypes {
	
	public static void main(String[] args) {
		String[] letters = new String[] { "abc", "bcd", "cde", "ACD", "BDE", "CEF", "Ace", "Bdf", "Ceg" };
		
		Set<String> unsorted = new HashSet<String>();
		Set<String> linkedunsorted = new LinkedHashSet<String>();
		for (String letter : letters) {
			unsorted.add(letter);
			linkedunsorted.add(letter);
		}
		System.out.println(unsorted);
		System.out.println(linkedunsorted);
		System.out.println();
		
		// Natural ordering - Case sensitive
		Set<String> sorted = new TreeSet<String>();
		for (String letter : letters) {
			sorted.add(letter);
		}
		System.out.println(sorted);
		
		// Case insensitive ordering
		Set<String> sorted2 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		for (String letter : letters) {
			sorted2.add(letter);
		}
		System.out.println(sorted2);
	}
	
}
