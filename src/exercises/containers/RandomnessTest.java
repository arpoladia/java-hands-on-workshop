package exercises.containers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomnessTest {

	public static void main(String[] args) {
		generateRandomNumbers(500);
		generateRandomNumbers(5000);
		generateRandomNumbers(10000);
	}
	
	private static void generateRandomNumbers(int numberOfIterations) {
		Random rand = new Random(47);
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < numberOfIterations; i++) {
			int r = rand.nextInt(10);
			Integer freq = freqMap.get(r);
			freqMap.put(r, freq == null ? 1 : freq + 1);
		}
		System.out.println(freqMap);
		System.out.println();
	}

}
