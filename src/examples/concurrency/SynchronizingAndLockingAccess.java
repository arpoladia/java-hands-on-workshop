package examples.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizingAndLockingAccess {
	
	public static void main(String[] args) {
		EvenNumberGenerator gp = new EvenNumberGenerator();
		// EvenNumberGenerator gp = new SynchronizedEvenNumberGenerator();
		// EvenNumberGenerator gp = new LockedEvenNumberGenerator();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new EvenNumberGeneratorTask(gp, i));
		}
		exec.shutdown();
	}
	
}
