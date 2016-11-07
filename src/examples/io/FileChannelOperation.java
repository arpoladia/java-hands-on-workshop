package examples.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileChannelOperation {
	
	public static String readFile(File file) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			FileInputStream fis = new FileInputStream(file);
			FileChannel fc = fis.getChannel();
			try {
				ByteBuffer buff = ByteBuffer.allocate(1024);
				while (fc.read(buff) != -1) {
					buff.flip();
					sb.append(Charset.forName("UTF-8").decode(buff));
					buff.clear();
				}
			} finally {
				fc.close();
				fis.close();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	public static void writeFile(File file, String content) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			FileChannel fc = fos.getChannel();
			try {
				ByteBuffer buff = ByteBuffer.wrap(content.getBytes(Charset.forName("UTF-8")));
				fc.write(buff);
			} finally {
				fc.close();
				fos.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) throws IOException {
		String fileContent = readFile(new File("unicode-input.txt"));
		System.out.println(fileContent);
		writeFile(new File("unicode-output.txt"), fileContent);
	}
	
}
