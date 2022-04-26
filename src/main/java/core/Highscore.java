package core;

import java.util.ArrayList;

public class Highscore {
	
	Panel gp;
	WriteToFile writer;
	
	public Highscore(Panel gp) {
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
		ArrayList<Integer> list = gp.highscores;
		for(int j: list) {
			if(i > j) {
				list.add(list.indexOf(j), i);
				list.remove(5);
				writer.overWriteFile(fileName, list);
				break;
			}
		}
		gp.highscores = list;
	}
	
	public void updateHighscore(String fileName) {
		int currentScore = calculateScore();
		compareScores(fileName, currentScore);
	}
}
