package examples.generics;

public class ThreeTuple<A, B, CD> extends TwoTuple<A, B> {
	
	public final CD third;
	
	public ThreeTuple(A a, B b, CD c) {
		super(a, b);
		third = c;
	}
	
	public String toString() {
		return "(" + first + ", " + second + ", " + third + ")";
	}
	
	public static void main(String[] args) {
		ThreeTuple<String, Integer, Character> ex1 = new ThreeTuple<>("A", 1, 'a');
		System.out.println(ex1);
	}
	
}
