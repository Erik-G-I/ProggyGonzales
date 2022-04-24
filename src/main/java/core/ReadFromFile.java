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

	public ArrayList<String> list;
	
	public ReadFromFile() {
		list = new ArrayList<String>();
	}
	
	
	public void readHighscore(int i) {
		BufferedReader reader;
		list.clear();
		
		
		try {
			InputStream is = getClass().getResourceAsStream("/highscoreDB/highscore.txt");
			
			reader = new BufferedReader(new InputStreamReader(is));
			int j = 0;
			
			while(j <= i) {
				String line = reader.readLine();
				list.add(line);
				j++;
			}
			reader.close();
			
		} catch(Exception e) {
			
		}
	}
}
