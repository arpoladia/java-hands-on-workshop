package exercises.generics;

public class Value<T> {
	
	public Value(T val) {
		this.value = val;
	}
	
	private T value;
	
	int count = 0;
	
	public T getValue() {
		count++;
		return value;
	}
	
	@Override
	public String toString() {
		return "Val:" + value.toString() + " Count:" + count;
	}
	
	public static void main(String[] args) {
		Value<String> val1 = new Value<>("A");
		System.out.println(val1);
		Value<Integer> val2 = new Value<>(1);
		val2.getValue();
		val2.getValue();
		System.out.println(val2);
		Value<Double> val3 = new Value<>(1.5D);
		val3.getValue();
		System.out.println(val3);
	}
	
}
