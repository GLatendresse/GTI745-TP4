import java.util.ArrayList;
import java.util.List;


public class Recording 
{
	private List<Note> notes = new ArrayList<Note>();
	private boolean isrecording = false;
	
	public Recording()
	{
	
	}
	
	public boolean isRecording() { return isrecording; }
	
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
	
}
