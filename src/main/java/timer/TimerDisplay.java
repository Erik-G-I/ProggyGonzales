package timer;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Timer;

import core.GamePanel;
import java.awt.Color;

public class TimerDisplay {
	
	private GamePanel gp;
	private Font timeFont;
	private int widthOfScreen;
	private int seconds;
	private int minutes;
	private String showTime;
	private Timer timer;
	private Time time;
	
	public TimerDisplay(GamePanel gp) {
		this.gp=gp;
		timeFont=new Font("Times New Roman",Font.BOLD,40);
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
		g2.setFont(timeFont);
		g2.setColor(Color.BLACK);
		g2.drawString(showTime, widthOfScreen/2,54);
	}
	
	public Time getTime() {
		return time;
	}
}
