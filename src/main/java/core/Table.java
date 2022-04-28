package core;

import java.util.ArrayList;

public class Table {

	private ArrayList<ArrayList> table;
	private ArrayList<String> name;
	private ArrayList<Integer> score;
	
	/**
	 * Constructor for table class
	 * creates a table structure using lists, not designed for large amount of data
	 */
	public Table() {
		table = new ArrayList<>();
		name = new ArrayList<>();
		score = new ArrayList<>();
		table.add(name);
		table.add(score);
	}
	
	public ArrayList<ArrayList> getTable(){
		return table;
	}
	
	public ArrayList<String> getNameList() {
		return name;
	}
	
	public String getName(int index) {
		return name.get(index);
	}
	
	public ArrayList<Integer>getScoreList() {
		return score;
	}
	
	public Integer getScore(int index) {
		return score.get(index);
	}
	
	public void addEntry(String name, int hs) {

		score.add(hs);
		this.name.add(name);
		table.add(this.name);
		table.add(score);
		
	}
	
	public void overWriteTable(ArrayList<String> names, ArrayList<Integer> scores) {
		clear();
		name = names;
		score = scores;
	}
	
	public void clear() {
		name.clear();
		score.clear();
	}
	
}
