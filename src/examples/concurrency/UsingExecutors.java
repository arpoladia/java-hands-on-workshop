package examples.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutors {
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		// ExecutorService exec = Executors.newFixedThreadPool(3);
		// ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Countdown());
		}
		System.out.println("Starting countdown...");
		exec.shutdown();
	}
	
}
