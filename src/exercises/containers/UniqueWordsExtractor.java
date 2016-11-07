package exercises.containers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class UniqueWordsExtractor {

	private Map<String, TreeSet<String>> resultsCache = new HashMap<>();

	public TreeSet<String> getUniqueWords(String sentence) {
		if (resultsCache.containsKey(sentence)) {
			System.out.println("Found in cache : " + sentence);
			return resultsCache.get(sentence);
		} else {
			TreeSet<String> result = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
			String[] words = sentence.split("\\s+");
			for (String word : words) {
				result.add(word);
			}
			resultsCache.put(sentence, result);
			return result;
		}
	}

	public static void main(String[] args) {
		UniqueWordsExtractor uwe = new UniqueWordsExtractor();
		System.out.println(uwe.getUniqueWords(""));
		System.out.println();
		System.out.println(uwe.getUniqueWords("That is a good book but this IS not a good read."));
		System.out.println();
		System.out.println(uwe.getUniqueWords(""));
		System.out.println();
		System.out.println(uwe.getUniqueWords("shelly picks the Sea shells on the sEa shore."));
		System.out.println();
		System.out.println(uwe.getUniqueWords("That is a good book but this IS not a good read."));
	}

}
