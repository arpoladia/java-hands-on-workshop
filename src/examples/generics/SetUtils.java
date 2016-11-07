package examples.generics;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {
	
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	
	public static <U> Set<U> intersection(Set<U> a, Set<U> b) {
		Set<U> result = new HashSet<U>(a);
		result.retainAll(b);
		return result;
	}
	
	public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;
	}
	
	public static <V> Set<V> complement(Set<V> a, Set<V> b) {
		return difference(union(a, b), intersection(a, b));
	}
	
}
