package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import core.GamePanel;
import entity.PlayerState;
import gameState.GameState;

public class Time implements ActionListener{
	
	private int seconds;
	private int minutes;
	private String showTime; //timer will be a String
	private GamePanel gp;
	private Timer timer;
	private boolean gameOver;
	private boolean startPowerUpTimer;
	private int powerUpSeconds = 10;
	
	public Time(int seconds, int minutes, String showTime, GamePanel gp) {
		this.seconds=seconds;
		this.minutes=minutes;
		this.showTime=showTime;
		this.gp = gp;
	}
	
	public void setTimer(Timer timer) {
		this.timer=timer;
	}
	
	public String getShowTime() {
		return showTime;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		seconds--;
		if(seconds < 10) {
			this.showTime = minutes + ":0"+seconds;
		}
		else {
			this.showTime = minutes + ":" + seconds;
		}
		if(seconds == 0) {
			if(minutes > 0) {
				seconds = 60; //reset seconds then descrease minutes
				minutes--;
			}
			else {
				//when both minutes and seconds are 0
				timer.stop();
				gameOver = true;
			}
		}
		if(gp.gameState == GameState.RUNNING_GAME) {
		if(seconds > 0) {
			if(startPowerUpTimer == true) {
				if (gp.pickedUpPowerUp() == true) {
					powerUpSeconds = 10;
					System.out.println("updated time");
					gp.setPickedUpPowerUp(false);
				}
				powerUpSeconds--;
				if (gp.getPlayerState() == PlayerState.VOI) {
					int originalCoins = gp.getCoinsInCollisionChecker();
					if (originalCoins>0) {
					gp.setCoinsInCollisionChecker(originalCoins-1);
					}
					if (gp.getCoinsInCollisionChecker() <= 1) {
						gp.setPlayerState(PlayerState.NORMAL);
					}
					
					
				}
				if(powerUpSeconds == 0) {
					powerUpSeconds = 10;
					startPowerUpTimer = false;
					gp.setPlayerState(PlayerState.NORMAL);
					gp.playSoundEffect(6);
					System.out.println("normal speed");
				}
			}
		}
		}
		else {
			setStartPowerUpTimer(false);
		}
	}
	
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	protected void setStartPowerUpTimer(boolean startPowerUpTimer) {
		this.startPowerUpTimer = startPowerUpTimer;
	}
	
}
