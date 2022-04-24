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
	 * 
	 * @param fileName - Name of file to write to, ex. "example.txt"
	 * @param text - What to write in the file
	 */
	public void writeFile(String text) {
		try {
			fw = new FileWriter(new File(this.getClass().getResource("/highscoreDB/highscore.txt").getPath()), true);
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
	
	public void overWriteFile(ArrayList<Integer> list) {
		try {
			fw = new FileWriter(new File(this.getClass().getResource("/highscoreDB/highscore.txt").getPath()), false);
			bw = new BufferedWriter(fw);
			for(int i: list) {
				bw.write(Integer.toString(i));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
