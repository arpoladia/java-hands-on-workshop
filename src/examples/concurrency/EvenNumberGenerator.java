package examples.concurrency;

public class EvenNumberGenerator {

	private int currentEvenValue = 0;

	private volatile boolean canceled = false;

	public int next() {
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
