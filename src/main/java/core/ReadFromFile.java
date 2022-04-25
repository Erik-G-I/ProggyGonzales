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

	public ArrayList<Integer> list;
	
	public ReadFromFile() {
		list = new ArrayList<Integer>();
	}
	
	
	public void readHighscore(String fileName, int i) {
		BufferedReader reader;
		list.clear();
		
		
		try {
			InputStream is = getClass().getResourceAsStream("/highscoreDB/"+fileName);
			
			reader = new BufferedReader(new InputStreamReader(is));
			int j = 0;
			
			while(j < i) {
				String line = reader.readLine();
				list.add(Integer.parseInt(line));
				j++;
			}
			reader.close();
			
		} catch(Exception e) {
			
		}
	}
}
