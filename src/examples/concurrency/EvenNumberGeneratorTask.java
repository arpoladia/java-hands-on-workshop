package examples.concurrency;

public class EvenNumberGeneratorTask implements Runnable {

	private EvenNumberGenerator generator;

	@SuppressWarnings("unused")
	private final int id;

	public EvenNumberGeneratorTask(EvenNumberGenerator g, int ident) {
		generator = g;
		id = ident;
	}

	public void run() {
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " not even!");
				generator.cancel();
			}
		}
	}

}
