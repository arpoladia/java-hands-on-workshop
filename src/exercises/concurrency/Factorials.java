package exercises.concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FactorialTask implements Callable<String> {
	
	private int n;
	
	public FactorialTask(int n) {
		this.n = n;
	}
	
	@Override
	public String call() {
		return n + "! = " + factorial(n);
	}
	
	private int factorial(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n must be a positive integer!");
		}
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	
}

public class Factorials {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newFixedThreadPool(3);
		ArrayList<Future<String>> results = new ArrayList<>();
		for (int i = 1; i <= 15; i++) {
			results.add(exec.submit(new FactorialTask(i)));
		}
		for (Future<String> fs : results) {
			try {
				System.out.println(fs.get());
			} finally {
				exec.shutdown();
			}
		}
	}
	
}
