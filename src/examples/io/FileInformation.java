package examples.io;

import java.io.File;

public class FileInformation {
	
	private static void printFileData(File f) {
		System.out.println(
				"Absolute Path : " + f.getAbsolutePath() +
				"\nPath : " + f.getPath() +
				"\nName : " + f.getName() +
				"\nIs File : " + f.isFile() +
				"\nIs Directory : " + f.isDirectory() +
				"\nCan read : " + f.canRead() +
				"\nCan write : " + f.canWrite() +
				"\nLast Modified : " + f.lastModified());
	}
	
	public static void main(String[] args) {
		File file = new File("testDirectory1");
		System.out.println("Exists : " + file.exists());
		System.out.println();
		
		file.mkdirs();
		System.out.println("Exists : " + file.exists());
		printFileData(file);
		System.out.println();
		
		File newFile = new File("testDir");
		file.renameTo(newFile);
		System.out.println("File Exists : " + file.exists());
		System.out.println("New File Exists : " + newFile.exists());
		System.out.println();
		
		newFile.delete();
		System.out.println("New File Exists : " + newFile.exists());
	}
	
}
