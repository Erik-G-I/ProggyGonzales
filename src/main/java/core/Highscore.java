package core;

import java.util.ArrayList;

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
		int score = gp.collisionChecker.getCoins();
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
		ArrayList<Integer> scores = hsTable.getScoreList();
		ArrayList<String> names = hsTable.getNameList();
		for(int j: scores) {
			if(i > j) {
				int index = scores.indexOf(j);
				scores.add(index, i);
				scores.remove(5);
				names.add(index, gp.getPlayerName());
				names.remove(5);
				hsTable.overWriteTable(names, scores);
				writer.overWriteFile(fileName, hsTable);
				break;
			}
		}
		gp.highscores = hsTable;
	}
	
	public void updateHighscore(String fileName) {
		int currentScore = calculateScore();
		compareScores(fileName, currentScore);
	}
}
