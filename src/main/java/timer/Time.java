package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import core.GamePanel;
import entity.PlayerState;

public class Time implements ActionListener{
	
	private int seconds;
	private int minutes;
	private String showTime; //timer will be a String
	private GamePanel gp;
	private Timer timer;
	private boolean gameOver;
	private boolean startPowerUpTimer;
	private int powerUpSeconds = 5;
	
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
		if(seconds > 0) {
			if(startPowerUpTimer == true) {
				powerUpSeconds--;
				if(gp.pickedUpPowerUp()) {
					powerUpSeconds = 5;
					gp.setPickedUpPowerUp(false);
				}
				if(powerUpSeconds == 0) {
					powerUpSeconds = 5;
					startPowerUpTimer = false;
					gp.setPLayerState(PlayerState.NORMAL);
					System.out.println("normal speed");
				}
			}
		}
	}
	
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void setStartPowerUpTimer(boolean startPowerUpTimer) {
		this.startPowerUpTimer = startPowerUpTimer;
	}
	
}
