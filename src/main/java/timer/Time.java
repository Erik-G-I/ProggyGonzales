package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import core.GamePanel;
import entity.player.PlayerState;
import gameState.GameState;

public class Time implements ActionListener{
	
	public int seconds;
	public int minutes;
	private String showTime; //timer will be a String
	private final GamePanel gp;
	private Timer timer;
	private boolean gameOver;
	private boolean startPowerUpTimer1;
	private boolean startPowerUpTimer2;
	private int powerUpSeconds1 = 10;
	private int powerUpSeconds2 = 10;
	
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
			if(startPowerUpTimer1 && seconds > 0) {
				if (gp.p1pickedUpPowerUp()) {
					powerUpSeconds1 = 10;
					gp.setPickedUpPowerUp(1,false);
				}
				powerUpSeconds1--;
					
				// Reduce coins by 1 for each second on a VOI
				if (gp.getPlayerState1() == PlayerState.VOI) {
					// The coins before deducting
					int originalCoins = gp.getCoinsInCollisionChecker(1);
					// Makes sure coins are not negative
					if (originalCoins>0) {
						gp.reduceCoinByOne(1);
					}
					// If proggy has no money left, the voi trip ends
					if (gp.getCoinsInCollisionChecker(1) <= 0) {
						gp.setPlayerState1(PlayerState.NORMAL);
					}
				}
					
				if(powerUpSeconds1 == 0) {
					powerUpSeconds1 = 10;
					startPowerUpTimer1 = false;
					gp.setPlayerState1(PlayerState.NORMAL);
					gp.playSoundEffect(6);
				}
			}
			
			if(startPowerUpTimer2 && seconds > 0) {
				if (gp.p2pickedUpPowerUp()) {
					powerUpSeconds2 = 10;
					gp.setPickedUpPowerUp(2,false);
				}
				powerUpSeconds2--;
				
				// Reduce coins by 1 for each second on a VOI
				if (gp.getPlayerState2() == PlayerState.VOI) {
					// The coins before deducting
					int originalCoins = gp.getCoinsInCollisionChecker(2);
					// Makes sure coins are not negative
					if (originalCoins>0) {
						gp.reduceCoinByOne(2);
					}
					// If proggy has no money left, the voi trip ends
					if (gp.getCoinsInCollisionChecker(2) <= 0) {
						gp.setPlayerState2(PlayerState.NORMAL);
					}
				}
				
				if(powerUpSeconds2 == 0) {
					powerUpSeconds2 = 10;
					startPowerUpTimer2 = false;
					gp.setPlayerState2(PlayerState.NORMAL);
					gp.playSoundEffect(6);
				}
			}
			
			
		}
		else {
			setStartPowerUpTimer1(false);
			setStartPowerUpTimer1(false);
		}

		
		
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	protected void setStartPowerUpTimer1(boolean startPowerUpTimer1) {
		this.startPowerUpTimer1 = startPowerUpTimer1;
	}
	
	protected void setStartPowerUpTimer2(boolean startPowerUpTimer2) {
		this.startPowerUpTimer2 = startPowerUpTimer2;
	}
	
	
	protected int getSeconds() {
		return seconds;
	}
	
	protected int getMinutes() {
		return minutes;
	}
	
}
