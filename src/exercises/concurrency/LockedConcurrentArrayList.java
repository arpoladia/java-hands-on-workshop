package exercises.concurrency;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedConcurrentArrayList<T> {
	
	private ArrayList<T> list = new ArrayList<>();
	
	private Lock lock = new ReentrantLock();
	
	public T get(int index) {
		lock.lock();
		try {
			return list.get(index);
		} finally {
			lock.unlock();
		}
	}
	
	public void add(T obj) {
		lock.lock();
		try {
			list.add(obj);
		} finally {
			lock.unlock();
		}
	}
	
	public T remove(int index) {
		lock.lock();
		try {
			return list.remove(index);
		} finally {
			lock.unlock();
		}
	}
	
	public void clear() {
		lock.lock();
		try {
			list.clear();
		} finally {
			lock.unlock();
		}
	}
	
	public int size() {
		lock.lock();
		try {
			return list.size();
		} finally {
			lock.unlock();
		}
	}
	
}
