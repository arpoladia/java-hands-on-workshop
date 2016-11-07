package examples.generics;

public class TwoTuple<A, B> {
	
	public final A first;
	
	public final B second;
	
	public TwoTuple(A a, B b) {
		first = a;
		second = b;
	}
	
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	
	public static void main(String[] args) {
		TwoTuple<CharSequence, Integer> ex1 = new TwoTuple<>("ABC", 123);
		System.out.println(ex1);
		System.out.println();
		
		TwoTuple<Integer, TwoTuple<CharSequence, Integer>> ex2 = new TwoTuple<>(10, ex1);
		System.out.println(ex2);
	}
	
}
