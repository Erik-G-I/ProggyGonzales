package timer;

import java.awt.Graphics;

import javax.swing.Timer;

import core.DisplayText;
import core.GamePanel;
import java.awt.Color;

public class TimerDisplay extends DisplayText{
	
	private final int widthOfScreen;
	private final int seconds;
	private final int minutes;
	private String showTime;
	private final Timer timer;
	private final Time time;
	private int timerSeconds, timerMinutes;
	
	public TimerDisplay(GamePanel gp) {
		seconds=60; //change later to wanted time
		minutes=2; //change later to wanted time
		widthOfScreen=gp.screenWidth;
		showTime=new String();
		time=new Time(seconds,minutes,showTime,gp);
		timer=new Timer(1000,time);
	}
	
	public void startTime() {
		time.setTimer(timer);
		timer.start();
	}
	
	public void stopTime() {
		timer.stop();
	}
	
	public void update() {
		showTime=time.getShowTime();
		timerSeconds = this.getTime().getSeconds();
		timerMinutes = this.getTime().getMinutes();
	}
	
	public void draw(Graphics g2) {
		this.setGraphics(g2);
		g2.setColor(Color.BLACK);
		this.draw(50);
		g2.drawString(showTime, widthOfScreen/2,54);
	}
	
	public Time getTime() {
		return time;
	}
	
	public void startPowerUpTimerTrue1() {
		time.setStartPowerUpTimer1(true);
	}
	
	public void startPowerUpTimerTrue2() {
		time.setStartPowerUpTimer2(true);
	}

	public String timeLeft() {
		return showTime;
	}
	
	public String getTimeTaken() {
		int secondsTaken = this.seconds-timerSeconds;
		int minutesTaken = this.minutes-timerMinutes;
		return minutesTaken + ":" + secondsTaken;
	}
}
