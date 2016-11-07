package examples.concurrency;

public class SynchronizedEvenNumberGenerator extends EvenNumberGenerator {
	
	private int currentEvenValue = 0;

	private volatile boolean canceled = false;

	public synchronized int next() {
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}

	public void cancel() {
		canceled = true;
	}

	public boolean isCanceled() {
		return canceled;
	}

}
