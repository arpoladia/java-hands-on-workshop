package exercises.io;

import java.io.File;

public class DirFileSearch {
	
	private static void searchDirectory(String dirPath, String query) {
		File dir = new File(dirPath);
		if (dir.exists() && dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.getName().toLowerCase().contains(query)) {
					System.out.println(file.getName());
				}
			}
		} else {
			System.out.println("Not a directory!");
		}
	}
	
	public static void main(String[] args) {
		searchDirectory("D:/", "a");
		System.out.println();
		searchDirectory("D:/file.txt", "a");
	}
	
}
