package examples.cleanup;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GarbageCollection {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		for (int i = 0; i < 700000; i++) {
			System.out.println("Creating list  : " + i);
			ArrayList<String> list = new ArrayList<>();
		}
	}
	
}
