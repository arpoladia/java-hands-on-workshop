package examples.concurrency;

public class BasicThreading {
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Countdown()).start();
		}
		System.out.println("Starting countdown...");
	}
	
}
