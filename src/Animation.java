import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Note 
{
	private int idInstrument = 0;
	private  int duration = 0;
	
	public Note(int id, int duration)
	{
		this.idInstrument = id;
		this.duration = duration;
	}
	
	public void setIdInstrument(int id) { idInstrument = id; }
	public void setDuration(int temps) { duration = temps; }
	
	public int getIdInstrument() { return idInstrument; }
	public int getDuration() { return duration; }
	
}

public class Animation 
{
	private List<Note> notes = new ArrayList<Note>();
	private boolean isAnimationPlay = false;
	private boolean isInPause = true;
	private int durationTotal = 0;
	private int currentTimeAnimation = 0;
	
	public Animation()
	{
		
	}
	
	public void initializeNotes(String filePath)
	{
		File file = new File(filePath);
		String[] segment;
	    String line;
		int type = 0;
		int dururation = 0;
		if( file.exists() )
		{
			try (BufferedReader br = new BufferedReader(new FileReader(file))) 
			{
			    while ((line = br.readLine()) != null)
			    {
			       segment = line.split(":");
			       type = Integer.parseInt( segment[0] );
			       dururation = Integer.parseInt( segment[1] );
			       durationTotal += dururation;
			       notes.add(new Note( type, dururation ) );
			       // process the line.
			    }
			} 
			catch (IOException ioe) 
			{
				ioe.printStackTrace();
			} 
		}
		else
		{
			System.out.println("fichier inexistant");
		}
	}
	
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
	
	public void setTotalDuration( int duree ){ durationTotal = duree; }
	public int getTotalDuration(){ return this.durationTotal; }
	
	public void setCurrentTime( int time ){ currentTimeAnimation = time; }
	public int getCurrentTime(){ return this.currentTimeAnimation; }
	
	public boolean isAnimationPlay() { return isAnimationPlay; }
	public boolean isAnimationInPause() { return isInPause; }
	
	public void playAnimation() 
	{
		isAnimationPlay = true;
		isInPause = false;
	}
	
	public void pauseAnimation()
	{
		isInPause = true;
	}
	
	public void stopAnimation() 
	{
		isAnimationPlay = false;
	}
}
