package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadFromFile {

	public Table table;
	private String[] arr;
	
	public ReadFromFile() {
		table = new Table();
	}
	
	
	public void readHighscore(String fileName, int i) {
		BufferedReader reader;
		
		
		try {
			InputStream is = getClass().getResourceAsStream("/highscoreDB/"+fileName);
			
			reader = new BufferedReader(new InputStreamReader(is));
			int j = 0;
			
			while(j < i) {
				arr = new String[2];
				String line = reader.readLine();
				arr = line.split(" ");
				table.addEntry(arr[0], Integer.parseInt(arr[1]));
				j++;
			}
			reader.close();
			
		} catch(Exception e) {
			
		}
	}
}
