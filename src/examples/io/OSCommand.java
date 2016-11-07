package examples.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSCommand {
	
	public static void executeCommand(String command) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
		Process process = processBuilder.start();
		BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String s;
		while ((s = results.readLine()) != null) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws IOException {
		executeCommand("ls -la");
		System.out.println();
		
		executeCommand("mkdir testdir");
		System.out.println(new File("testdir").exists());
		System.out.println();
		
		executeCommand("rm -rf testdir");
		System.out.println(new File("testdir").exists());
	}
	
}
