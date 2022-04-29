package core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;  
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {

	FileWriter fw;
	BufferedWriter bw;
	
	public WriteToFile() {
		
	}
	/**
	 * Writes to the end of the spesified file
	 * @param fileName - Name of file to write to, ex. "example.txt"
	 * @param text - What to write in the file
	 */
	public void writeFile(String fileName, String text) {
		try {
			fw = new FileWriter(new File(this.getClass().getResource("/highscoreDB/"+fileName).getPath()), true);
			bw = new BufferedWriter(fw);
			bw.write(text);
			bw.newLine();
			bw.close();
			
			System.out.println("Successfully updated 'highscore.txt'!");
		} catch (IOException e) {
			System.out.println("Error occurred when trying to write to 'highscore.txt'!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to rewrite the highscore file when a new highscore is achieved
	 * @param fileName
	 * @param table
	 */
	public void overWriteFile(String fileName, Table table) {
		try {
			fw = new FileWriter(new File(this.getClass().getResource("/highscoreDB/"+fileName).getPath()), false);
			bw = new BufferedWriter(fw);
			
			int index = 0;
			for(String s: table.getNames()) {
				
				int score = table.getScore(index);
				String line = s + "," + Integer.toString(score);
				bw.write(line);
				bw.newLine();
				index ++;
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Couldn't overwrite");
			e.printStackTrace();
		}
	}
	
}
