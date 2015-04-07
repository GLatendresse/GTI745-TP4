import java.util.ArrayList;
import java.util.List;


public class Recording 
{
	private List<Note> notes = new ArrayList<Note>();
	private boolean isrecording = false;
	private int durationTotal = 0;
	private int currentTimeAnimation = 0;
	private boolean isInPause = true;
	
	public Recording()
	{
	
	}
	
	
	public void setTotalDuration( int duree ){ durationTotal = duree; }
	public int getTotalDuration(){ return this.durationTotal; }
	
	public void setCurrentTime( int time ){ currentTimeAnimation = time; }
	public int getCurrentTime(){ return this.currentTimeAnimation; }
	
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
	}
	
	public void pauseDemo()
	{
		isInPause = true;
	}
	
	public void stopRecording() 
	{
		isrecording = false;
		durationTotal = 0;
		currentTimeAnimation = 0;
	}
	
}
