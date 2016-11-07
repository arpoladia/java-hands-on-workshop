package examples.concurrency;

import java.util.concurrent.TimeUnit;

public class Countdown implements Runnable {
	
	protected int countDown = 6;
	
	private static int taskCount = 0;
	
	private final int id = taskCount++;
	
	public Countdown() {
		
	}
	
	public Countdown(int countDown) {
		this.countDown = countDown;
	}
	
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Done!") + ")";
	}
	
	@Override
	public void run() {
		try {
			while (countDown-- > 0) {
				TimeUnit.MILLISECONDS.sleep(5);
				System.out.println(status());
				Thread.yield();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
}
