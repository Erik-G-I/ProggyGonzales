package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Time implements ActionListener{
	
	private int seconds;
	private int minutes;
	private String showTime; //timer will be a String
	private Timer timer;
	
	public Time(int seconds, int minutes, String showTime) {
		this.seconds=seconds;
		this.minutes=minutes;
		this.showTime=showTime;
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
		this.showTime=minutes+":"+seconds;
		if(seconds==0) {
			if(minutes>0) {
				seconds=60; //reset seconds then descrease minutes
				minutes--;
			}
			else {
				//when both minutes and seconds are 0
				timer.stop();
			}
		}
	}
	
	
	
	
}
