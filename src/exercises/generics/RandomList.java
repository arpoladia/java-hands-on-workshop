package exercises.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class RandomList<T> extends ArrayList<T> {
	
	private Random random = new Random(47);
	
	public T select() {
		if (size() > 0) {
			int index = random.nextInt(size());
			return get(index);
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[]{"a", "b", "c", "d", "e"});
		RandomList<String> randomList = new RandomList<>();
		randomList.addAll(list);
		for (int i = 0; i < 10; i++) {
			System.out.println(randomList.select());
		}
	}
	
}
