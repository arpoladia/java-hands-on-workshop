package examples.io;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
	
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("unicode-output.txt", true);
		FileChannel fc = fos.getChannel();
		FileLock fl = fc.tryLock();
		if (fl != null) {
			System.out.println("Locked File");
			TimeUnit.SECONDS.sleep(5);
			fl.release();
			System.out.println("Released Lock");
		}
		fc.close();
		fos.close();
	}
	
}
