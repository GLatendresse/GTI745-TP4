import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;


public class Recording  implements Runnable
{
	private List<Note> notes = new ArrayList<Note>();
	private boolean isrecording = false;
	private int durationTotal = 0;
	private int currentTime = 0;
	public int timeOfLastNote = 0;
	private boolean isInPause = true;
	
	public Recording()
	{
	
	}
	
	
	public void setTotalDuration( int duree ){ durationTotal = duree; }
	public int getTotalDuration(){ return this.durationTotal; }
	
	public void setCurrentTime( int time ){ currentTime = time; }
	public int getCurrentTime(){ return this.currentTime; }
	
	public void setTimeOfLastNote( int duree ){ timeOfLastNote = duree; }
	public int getTimeOfLastNote(){ return this.timeOfLastNote; }
	
	public boolean isRecording() { return isrecording; }
	public boolean isInPause() { return isInPause; }
	
	public List<Note> getNotes()
	{
		return notes;
	}
	
	public Note getNote(int index)
	{
		if( index >= 0 && index < notes.size())
		{
			return notes.get(index);
		}
		else
		{
			return null;
		}
	}
	
	public void startRecording() 
	{
		isrecording = true;
		isInPause = false;
		
		/*
		ActionListener recording = new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) 
			{ 
				System.out.println("REC: " + currentTime);
				if( isrecording )
				{
					currentTime ++;
					System.out.println("REC: " + currentTime);
				}
			}
		};
		timerRecording = new Timer(1000/60, recording); */
	}
	
	public void pauseDemo()
	{
		isInPause = true;
	}
	
	public void stopRecording() 
	{
		isrecording = false;
		durationTotal = 0;
		currentTime = 0;
		timeOfLastNote = 0;
		isInPause = true;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
