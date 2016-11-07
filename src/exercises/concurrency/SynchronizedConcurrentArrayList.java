package exercises.concurrency;

import java.util.ArrayList;

public class SynchronizedConcurrentArrayList<T> {
	
	private ArrayList<T> list = new ArrayList<>();
	
	public synchronized T get(int index) {
		return list.get(index);
	}
	
	public synchronized void add(T obj) {
		list.add(obj);
	}
	
	public synchronized T remove(int index) {
		return list.remove(index);
	}
	
	public synchronized void clear() {
		list.clear();
	}
	
	public synchronized int size() {
		return list.size();
	}
	
}
