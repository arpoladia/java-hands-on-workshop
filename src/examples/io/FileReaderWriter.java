package examples.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
	
	public static String readFile(File file) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s).append('\n');
				}
			} finally {
				in.close();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	public static void writeFile(File file, String content) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, false));
			try {
				out.write(content);
			} finally {
				out.close();
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
