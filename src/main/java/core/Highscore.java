package core;

import java.util.ArrayList;
import java.util.LinkedList;

public class Highscore {
	
	GamePanel gp;
	WriteToFile writer;
	
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
			if (minutesDone == false) {
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
	
	public void updateHighscore(String fileName) {
		int currentScore = calculateScore();
		compareScores(fileName, currentScore);
	}
}
