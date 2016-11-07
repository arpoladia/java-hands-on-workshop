package examples.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteration {
	
	public static void main(String[] args) {
		List<String> brands = new ArrayList<>();
		brands.addAll(Arrays.asList("HP", "Dell", "Lenovo", "Toshiba", "Asus"));
		
		ListIterator<String> it = brands.listIterator();
		
		// Forward
		while (it.hasNext()) {
			System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex());
		}
		System.out.println();
		
		// Backward
		while (it.hasPrevious()) {
			System.out.print(it.previous() + " ");
		}
		System.out.println();
		System.out.println();
		
		// In place modification
		while (it.hasNext()) {
			if ("Lenovo".equals(it.next())) {
				it.set("Apple");
			}
		}
		System.out.println(brands);
	}
	
}
