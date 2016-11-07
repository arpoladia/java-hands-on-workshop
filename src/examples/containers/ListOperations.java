package examples.containers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListOperations {
	
	public static void main(String[] args) {
		LinkedList<String> brands = new LinkedList<>();
		brands.addAll(Arrays.asList("HP", "Dell", "Lenovo", "Toshiba"));
		System.out.println("01 : " + brands);
		
		brands.add("Acer");
		System.out.println("02 : " + brands);
		
		brands.addAll(Arrays.asList("Apple", "Asus"));
		System.out.println("03 : " + brands);
		
		System.out.println("04 : " + brands.contains("Acer"));
		
		brands.remove("Acer");
		System.out.println("05 : " + brands);
		
		brands.removeAll(Arrays.asList("Apple", "Asus"));
		System.out.println("06 : " + brands);
		
		System.out.println("07 : " + brands.indexOf("Dell"));
		
		List<String> subBrands = brands.subList(0, 2);
		System.out.println("08 : " + subBrands);
		
		Collections.sort(subBrands);
		System.out.println("09 : " + brands);
		
		Collections.shuffle(brands, new Random(17));
		System.out.println("10 : " + brands);
		
		System.out.println("11 : " + brands.getFirst());
		
		brands.addFirst("Apple");
		System.out.println("12 : " + brands);
		
		brands.removeFirst();
		System.out.println("13 : " + brands);
		
		brands.addLast("Apple");
		System.out.println("14 : " + brands);
		
		brands.removeLast();
		System.out.println("15 : " + brands);
		
		brands.retainAll(Arrays.asList("Toshiba", "Dell"));
		System.out.println("16 : " + brands);
	}
	
}
