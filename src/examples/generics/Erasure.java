package examples.generics;

import java.util.ArrayList;

public class Erasure {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Class c1 = new ArrayList<String>().getClass();
		Class c2 = new ArrayList<Integer>().getClass();
		System.out.println(c1 == c2);
		System.out.println(c1.getSimpleName());
		System.out.println(c2.getSimpleName());
	}
	
	public <T> void willNotCompile(Object arg) {
		// if (arg instanceof T) {}
		// T var = new T();
		// T[] array = new T[10];
	}
	
}
