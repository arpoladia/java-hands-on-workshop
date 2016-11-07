package exercises.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;

public class CharCountNIO {
	
	public static void readCharacterCountsFromFile(File file, HashMap<Character, Integer> charCounts)
			throws IOException {
		try {
			FileInputStream fis = new FileInputStream(file);
			FileChannel fc = fis.getChannel();
			try {
				ByteBuffer buff = ByteBuffer.allocate(1024);
				while (fc.read(buff) != -1) {
					buff.flip();
					CharBuffer charBuffer = Charset.forName("UTF-8").decode(buff);
					while (charBuffer.hasRemaining()) {
						char character = charBuffer.get();
						Integer count = charCounts.get(character);
						charCounts.put(character, count == null ? 1 : count + 1);
					}
					buff.clear();
				}
			} finally {
				fc.close();
				fis.close();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
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
		HashMap<Character, Integer> charCounts = new HashMap<>();
		readCharacterCountsFromFile(new File("unicode-input.txt"), charCounts);
		System.out.println(charCounts);
		writeFile(new File("char-count-nio.txt"), charCounts.toString());
	}
	
}
