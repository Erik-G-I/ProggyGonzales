package timer;

import java.awt.Graphics;

import javax.swing.Timer;

import core.DisplayText;
import core.GamePanel;
import java.awt.Color;

public class TimerDisplay extends DisplayText{
	
	private GamePanel gp;
	private int widthOfScreen;
	private int seconds;
	private int minutes;
	private String showTime;
	private Timer timer;
	private Time time;
	
	public TimerDisplay(GamePanel gp) {
		this.gp=gp;
		seconds=60; //change later to wanted time
		minutes=0; //change later to wanted time
		widthOfScreen=gp.screenWidth;
		showTime=new String();
		time=new Time(seconds,minutes,showTime);
		timer=new Timer(1000,time);
	}
	
	public void startTime() {
		time.setTimer(timer);
		timer.start();
	}
	
	public void update() {
		showTime=time.getShowTime();
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
}
