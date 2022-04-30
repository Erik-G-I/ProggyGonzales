package core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFromFile {

	public final Table table;
	
	public ReadFromFile() {
		table = new Table();
	}
	
	/**
	 * Reads the highscores from a file
	 * @param fileName - to read from
	 * @param i - number of lines to read
	 */

	public void readHighscore(String fileName, int i) {
		BufferedReader reader;
		table.clear();
		
		
		try {
			InputStream is = getClass().getResourceAsStream("/highscoreDB/"+fileName);
			
			reader = new BufferedReader(new InputStreamReader(is));
			String[] arr;
			int j = 0;
			
			while(j < i) {
				arr = new String[2];
				arr = reader.readLine().split(",");
				table.add(arr[0], Integer.parseInt(arr[1]));
				j++;
			}
			reader.close();
			
		} catch(Exception e) {
			
		}
	}
}
