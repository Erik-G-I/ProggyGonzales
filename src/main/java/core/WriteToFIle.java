package core;

import java.io.FileWriter;  
import java.io.IOException; 

public class WriteToFIle {

	FileWriter fw;
	
	public WriteToFIle() {
		
	}
	
	public void writeFile(String text) {
		try {
			fw = new FileWriter("highscore.txt");
			fw.write(text);
			fw.close();
			System.out.println("Successfully updated highscore!");
		} catch (IOException e) {
			System.out.println("Error occurred when trying to write highscore!");
			e.printStackTrace();
		}
	}
	
}
