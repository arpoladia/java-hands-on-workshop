package examples.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedEvenNumberGenerator extends EvenNumberGenerator {
	
	private int currentEvenValue = 0;
	
	private volatile boolean canceled = false;
	
	private Lock lock = new ReentrantLock();
	
	@Override
	public int next() {
		lock.lock();
		try {
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			lock.unlock();
		}
	}
	
	@Override
	public void cancel() {
		canceled = true;
	}
	
	@Override
	public boolean isCanceled() {
		return canceled;
	}
	
}
