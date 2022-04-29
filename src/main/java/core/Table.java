package core;

import java.util.LinkedList;

public class Table {

	private LinkedList<String> names;
	private LinkedList<Integer> scores;
	
	/**
	 * Table construct
	 * creates a new table object
	 * Table stores two lists
	 */

	public Table() {
		names = new LinkedList<String>();
		scores = new LinkedList<Integer>();
	}
	
	
	/**
	 * Adds a name and a score to the end of the table
	 * @param name
	 * @param score
	 */
	public void add(String name, int score) {
		names.add(name);
		scores.add(score);
	}
	
	/**
	 * Adds a name and a score to a specified index in the table
	 * @param name
	 * @param score
	 * @param index
	 */
	public void add(String name, int score, int index) {
		names.add(index, name);
		scores.add(index, score);
	}

	
	/**
	 * 
	 * @param index of the name you want (0-4)
	 * @return name of given index
	 */
	public String getName(int index) {
		
		return names.get(index);
	}
	
	/**
	 * Getter for name-list
	 * @return list of names
	 */

	public LinkedList<String> getNames(){
		return names;
	}
	
	/**
	 * 
	 * @param index of score you want (0-4)
	 * @return score of given index
	 */
	public int getScore(int index) {
		
		return scores.get(index);
	}
	
	/**
	 * getter for score-list
	 * @return list of scores
	 */
	public LinkedList<Integer> getScores(){
		return scores;
	}
	
	/**
	 * removes the last element i the table
	 * removes from both name and score list
	 */
	public void removeLast() {
		names.removeLast();
		scores.removeLast();
	}
	
	/**
	 * erases entire table
	 */
	public void clear() {
		names.clear();
		scores.clear();
	}
	
	
}
