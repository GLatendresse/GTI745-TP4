import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


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
	
	public String toString()
	{
		return idInstrument + " : " + duration;
	}
	
}

public class Animation 
{
	private List<Note> notes = new ArrayList<Note>();
	private List<Note> demonstration = new ArrayList<Note>();
	private boolean isAnimationPlay = false;
	private boolean isDemoPlay = false;
	private boolean isInPause = true;
	private int durationTotal = 0;
	private int currentTimeAnimation = 0;
	private String fileName = "New File";
	private String demoFileName = "";
	private boolean isFileUpToDate = true;
	
	public Animation()
	{
		
	}
	
	public void setTotalDuration( int duree ){ durationTotal = duree; }
	public int getTotalDuration(){ return this.durationTotal; }
	
	public void setCurrentTime( int time ){ currentTimeAnimation = time; }
	public int getCurrentTime(){ return this.currentTimeAnimation; }
	
	public void  setDemoFileName ( String demoFile ){ demoFileName = demoFile; }
	public String getDemoFileName ( ){ return demoFileName; }
	
	public void setFileName(String filename){ this.fileName = filename; } 
	public String getFileName(){ return this.fileName; } 
	
	
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
	
	public List<Note> getDemo()
	{
		return demonstration;
	}
	
	public Note getDemoNote(int index)
	{
		if( index >= 0 && index < demonstration.size())
		{
			return demonstration.get(index);
		}
		else
		{
			return null;
		}
	}
	
	public boolean isAnimationPlay() { return isAnimationPlay; }
	public boolean isDemoPlay() { return isDemoPlay; }
	public boolean isAnimationInPause() { return isInPause; }
	
	public void saveFile() { isFileUpToDate = true; } 
	public void setFileChanged() { isFileUpToDate = false; } 
	public boolean isFileUpToDate() { return isFileUpToDate; };
	
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
		isDemoPlay = false;
		isInPause = true;
	}
	
	public void playDemo() 
	{
		isDemoPlay = true;
		isInPause = false;
	}
	
	public void pauseDemo()
	{
		isInPause = true;
	}
	
	public void stopDemo() 
	{
		isInPause = true;
		isDemoPlay = false;
		durationTotal = 0;
		currentTimeAnimation = 0;
	}
	
	public void importFile()
	{
		FileDialog fd = new FileDialog(new Frame(), "Choose a file", FileDialog.LOAD);
		File file = null;
		fd.setDirectory("C:\\");
		fd.setFile(".gti745");
		fd.setVisible(true);
		String filename = fd.getFile();
		String filePath = fd.getDirectory();
		if (filename == null)
		{
		  System.out.println("You cancelled the choice");
		}
		else
		{
			filePath += filename;
			initializeNotes(filePath);
		}
	}
	
	public void createNewFile()
	{
		int confirmNewFile = JOptionPane.showConfirmDialog (null, "Etes vous sûr de vouloir crée un nouveau fichier ? Tout changement non sauvegarder sera perdu.", "Warning", JOptionPane.YES_NO_OPTION);
		if(confirmNewFile == JOptionPane.YES_OPTION)
		{
			fileName = "New File";
			clearNotes();
			clearDemo();
			isFileUpToDate = true;
		}
	}
	
	public void SaveRecordToFile(Recording recording)
	{
		PrintWriter writerRecord = null;
		String savedFilePath = "...";
		FileDialog saveDialog = null;
		int confirmSave = JOptionPane.showConfirmDialog (null, "Voulez-vous sauvegarder votre enregistrement ?","Warning", JOptionPane.YES_NO_OPTION);
		if(confirmSave == JOptionPane.YES_OPTION)
		{
			try 
			{
				saveDialog = new FileDialog(new Frame(), "Choisissez un fichier de sauvegarde", FileDialog.SAVE);
				saveDialog.setFile("new file.gti745");
				saveDialog.setVisible(true);
				savedFilePath = saveDialog.getDirectory() + saveDialog.getFile();
				setFileName(saveDialog.getFile());
					
				saveFile();
				writerRecord = new PrintWriter(savedFilePath, "UTF-8");
				
				for( int i = 0; i< recording.getNotes().size(); i++ )
				{
					getNotes().add( recording.getNote(i) );
					writerRecord.println(recording.getNote(i).getIdInstrument() + ":" + recording.getNote(i).getDuration() );
				}
				writerRecord.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("L'utilisateur a annuler la save");
		}
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
			setFileName(file.getName());
			clearNotes();
			try 
			{
				BufferedReader br = new BufferedReader(new FileReader(file));
			    while ((line = br.readLine()) != null)
			    {
			       segment = line.split(":");
			       type = Integer.parseInt( segment[0] );
			       dururation = Integer.parseInt( segment[1] );
			       durationTotal += dururation;
			       notes.add(new Note( type, dururation ) );
			       // process the line.
			    }
			    br.close();
			} 
			catch (IOException ioe) 
			{
				ioe.printStackTrace();
			} 
			catch (NumberFormatException nfe) 
			{
				nfe.printStackTrace();
			} 
		}
		else
		{
			System.out.println("fichier inexistant");
		}
	}
	
	public void initializeDemo(String filePath)
	{
		File file = new File(filePath);
		String[] segment;
	    String line;
		int type = 0;
		int dururation = 0;
		if(! filePath.equals(demoFileName) &&  file.exists() )
		{
			demoFileName = filePath;
			clearDemo();
			try 
			{
				BufferedReader br = new BufferedReader(new FileReader(file));
			    while ((line = br.readLine()) != null)
			    {
			       segment = line.split(":");
			       type = Integer.parseInt( segment[0] );
			       dururation = Integer.parseInt( segment[1] );
			       durationTotal += dururation;
			       demonstration.add(new Note( type, dururation ) );
			       // process the line.
			    }
			    br.close();
			} 
			catch (IOException ioe) 
			{
				ioe.printStackTrace();
			} 
		}
		else
		{
			System.err.println("fichier inexistant où déja ouvert");
		}
	}
	
	public void clearNotes()
	{
		durationTotal = 0;
		currentTimeAnimation = 0;
		notes.clear();
	}
	
	public void clearDemo()
	{
		durationTotal = 0;
		currentTimeAnimation = 0;
		demonstration.clear();
	}
}
