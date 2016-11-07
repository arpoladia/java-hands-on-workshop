package examples.containers;

import java.util.HashMap;

class Num {
	
	protected int number;
	
	public Num(int n) {
		number = n;
	}
	
	@Override
	public String toString() {
		return "#" + number;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.number;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Num other = (Num) obj;
		if (this.number != other.number) {
			return false;
		}
		return true;
	}
	
}

public class EqualsAndHashcode {
	
	static String getVal(int number) {
		if (number % 2 == 0) {
			return "Even";
		} else {
			return "Odd";
		}
	}
	
	public static void main(String[] args) {
		HashMap<Num, String> map = new HashMap<>();
		for (int i = 1; i <= 5; i++) {
			map.put(new Num(i), getVal(i));
		}
		System.out.println(map);
		System.out.println();
		
		// When the hashcode & equals method are not implemented,
		// the following returns null instead of Odd
		Num three = new Num(3);
		System.out.println(three + " = " + map.get(three));
	}
	
}
