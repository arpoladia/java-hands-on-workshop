package examples.containers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTypes {

	public static void main(String[] args) {
		String[] letters = new String[] { "abc", "bcd", "cde", "ACD", "BDE", "CEF", "Ace", "Bdf", "Ceg" };

		Map<String, Integer> unsorted = new HashMap<>();
		Map<String, Integer> linkedunsorted = new LinkedHashMap<>();
		int i = 0;
		for (String letter : letters) {
			unsorted.put(letter, i);
			linkedunsorted.put(letter, i);
			i++;
		}
		System.out.println(unsorted);
		System.out.println(linkedunsorted);
		System.out.println();

		// Natural ordering - Case sensitive
		Map<String, Integer> sorted = new TreeMap<>();
		int j = 0;
		for (String letter : letters) {
			sorted.put(letter, j);
			j++;
		}
		System.out.println(sorted);

		// Case insensitive ordering
		Map<String, Integer> sorted2 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		int k = 0;
		for (String letter : letters) {
			sorted2.put(letter, k);
			k++;
		}
		System.out.println(sorted2);
	}

}
