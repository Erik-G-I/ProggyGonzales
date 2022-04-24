package core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;  
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths; 

public class WriteToFile {

	FileWriter fw;
	BufferedWriter bw;
	
	public WriteToFile() {
		
	}
	/**
	 * 
	 * @param fileName - Name of file to write to, ex. "example.txt"
	 * @param text - What to write in the file
	 */
	public void writeFile(String fileName, String text) {
		try {
			fw = new FileWriter(new File(this.getClass().getResource("/highscoreDB/highscore.txt").getPath()), true);
			bw = new BufferedWriter(fw);
//			Path source = Paths.get(this.getClass().getResource("/highscoreDB").getPath());
//			String sourceStr = source.toString();
//			System.out.println(sourceStr);
//			File file = new File(sourceStr + File.separator + fileName);
//			fw = new FileWriter(file, true);
//			bw = new BufferedWriter(fw);
			bw.write(text);
			bw.newLine();
			bw.close();
			
			System.out.println("Successfully updated '"+fileName+"'!");
		} catch (IOException e) {
			System.out.println("Error occurred when trying to write to '"+fileName+"'!");
			e.printStackTrace();
		}
	}
	
}
