package core;

import java.util.LinkedList;

public class Highscore {
	
	final GamePanel gp;
	final WriteToFile writer;
	
	public Highscore(GamePanel gp) {
		this.gp = gp;
		writer = new WriteToFile();
	}
	
	/**
	 * Calculates the score based on coins and time left
	 * @return
	 */
	private int calculateScore() {
		int score = gp.collisionChecker1.getCoins();
		String[] strArr = gp.getTimerDisplay().timeLeft().split(":");
		boolean minutesDone = false;
		for(String s: strArr) {
			if (!minutesDone) {
				score += Integer.parseInt(s)*60; //regner minutter til sekunder
				minutesDone = true;
			}
			else {
				score += Integer.parseInt(s); //legger til sekunder
			}
		}
		System.out.println(score);
		return score;
	}
	
	/**
	 * Compares the given score i to the highscores i the highscore table
	 * Overwrites the corresponding highscore file if a new highscore is achieved
	 * @param fileName - 
	 * @param i - score
	 */
	private void compareScores(String fileName, int i) {
		Table hsTable = gp.highscores;
		LinkedList<Integer> hsScores = hsTable.getScores();
		int index = 0;
		for(int j: hsScores) {
			if(i > j) {
				
				hsTable.add(gp.getPlayerName(), i, index);
				hsTable.removeLast();
				writer.overWriteFile(fileName, hsTable);
				break;
			}
			index++;
		}
		gp.highscores = hsTable;
	}
	
	/**
	 * Method to check if highscore should be updated with a the score from the current game
	 * @param fileName
	 */
	public void updateHighscore(String fileName) {
		int currentScore = calculateScore();
		compareScores(fileName, currentScore);
	}
}
