package examples.concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTask implements Callable<String> {
	
	private int id;
	
	public CallableTask(int id) {
		this.id = id;
	}
	
	@Override
	public String call() {
		return "Result of CallableTask : " + id;
	}
}

public class CallableTasks {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newFixedThreadPool(3);
		ArrayList<Future<String>> results = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			results.add(exec.submit(new CallableTask(i)));
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
