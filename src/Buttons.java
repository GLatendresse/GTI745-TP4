import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Les boutons du menu

public class Buttons 
{
	public static final int BUTTON_IMPORT = 1; 
	public static final int BUTTON_EXPORT = 2; 
	
	public static final int BASS_DRUM = 1; 
	public static final int FLOOR_TOM_TOM = 2; 
	public static final int MIDDLE_TOM_TOM = 3; 
	public static final int HIGH_TOM_TOM = 4; 
	public static final int SNARE_DRUM = 5; 
	public static final int HIHAT_CYMBAL = 6; 
	public static final int CRASH_SYMBAL = 7; 
	public static final int RIDE_SYMBAL = 8; 
	public static final int HIHAT_PEDAL = 9; 
	
	private int type = 0;
	private float centerX = 0.0f;
	private float centerY = 0.0f;
	private float radius = 0.0f;
	private String buttonName = "...";
	private Color backgroundColor = Color.white;
	
	
	public Buttons(int type, float centerX, float centerY, float radius, String buttonName, Color backgroundColor)
	{
		this.type = type;
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.buttonName = buttonName;
		this.backgroundColor = backgroundColor;
	}
	
	public void setName(String name) { this.buttonName = name; }
	public void setRadius(float radius){ this.radius = radius; }
	public void setCenterX(float centerX){ this.centerX = centerX; }
	public void setCenterY(float centerY){ this.centerY = centerY; }
	public void setBackgroundColor(Color color){ this.backgroundColor = color; }
	
	public String getName() { return this.buttonName; }
	public float getRadius(){ return this.radius; }
	public float getCenterX(){ return this.centerX; }
	public float getCenterY(){ return this.centerY; }
	public Color getBackgroundColor(){ return this.backgroundColor; }
	
	public void doFunction(Drum drum)
	{
		switch (type)
		{
		case BUTTON_IMPORT:

			FileDialog fd = new FileDialog(new Frame(), "Choose a file", FileDialog.LOAD);
			fd.setDirectory("C:\\");
			fd.setFile("*");
			fd.setVisible(true);
			String filename = fd.getFile();
			String filePath = fd.getDirectory();
			if (filename == null)
			{
			  System.out.println("You cancelled the choice");
			}
			else
			{
			   System.out.println("You chose " + filePath +  filename); 
			   readFile( drum, filePath +  filename );
			  // playDemo(drum);
			}

			//Sound.SoundTest();
			break;
		case BUTTON_EXPORT:
			
			break;
		default:
			
			break;
		}
	}
	
	public void readFile(Drum drum, String fileName)
	{
		File file = new File(fileName);
		String[] note;
		int type = 0;
		int duree = 0;
		if( file.exists() )
		{
			try (BufferedReader br = new BufferedReader(new FileReader(file))) 
			{
			    String line;
			    line = br.readLine();
			    while ((line = br.readLine()) != null)
			    {
			       note = line.split(":");
			       type = Integer.parseInt( note[0] );
			       duree = Integer.parseInt( note[1] );
					drum.getDrumPart(type).playSound();	
					Thread.sleep( duree );
			       // process the line.
			    }
			} 
			catch (IOException ioe) 
			{
				ioe.printStackTrace();
			} 
			catch (InterruptedException ie) 
			{
				// TODO Auto-generated catch block
				ie.printStackTrace();
			}
		}
		else
		{
			System.out.println("fichier inexistant");
		}
	}
	
	public void playDemo(Drum drum)
	{
		int duration = 200; // en millisecondes
		boolean alt = false;
		
		//Sound s = new Sound();
		
		try 
		{
			//drum.getDrumPart(BASS_DRUM).playSound();	
			//Thread.sleep( 2 );
			//drum.getDrumPart(HIHAT_CYMBAL).playSound();		//2
			
			for(int i = 4 ; i > 0 ; --i)
			{
				drum.getDrumPart(HIHAT_CYMBAL).playSound();		//1
				drum.getDrumPart(BASS_DRUM).playSound();	
				Thread.sleep( duration );
				drum.getDrumPart(HIHAT_CYMBAL).playSound();		//2
				Thread.sleep( duration );
				drum.getDrumPart(HIHAT_CYMBAL).playSound();		//3
				drum.getDrumPart(SNARE_DRUM).playSound();	
				Thread.sleep( duration );
				drum.getDrumPart(HIHAT_CYMBAL).playSound();	//4
				Thread.sleep( duration );
				drum.getDrumPart(HIHAT_CYMBAL).playSound();		//1
				drum.getDrumPart(BASS_DRUM).playSound();
				Thread.sleep( duration/2 );
				drum.getDrumPart(BASS_DRUM).playSound();
				Thread.sleep( duration/2 );
				drum.getDrumPart(HIHAT_CYMBAL).playSound();			//2
				Thread.sleep( duration );
				drum.getDrumPart(HIHAT_CYMBAL).playSound();			//3
				drum.getDrumPart(SNARE_DRUM).playSound();
				Thread.sleep( duration );
				drum.getDrumPart(HIHAT_CYMBAL).playSound();			//3
				Thread.sleep( duration );
			}
			drum.getDrumPart(SNARE_DRUM).playSound();	//3
			Thread.sleep( duration/2 );
			drum.getDrumPart(SNARE_DRUM).playSound();	//3
			Thread.sleep( duration/2 );
			drum.getDrumPart(SNARE_DRUM).playSound();	//3
			Thread.sleep( duration/2 );
			drum.getDrumPart(SNARE_DRUM).playSound();		//3
			Thread.sleep( duration/2 );
			drum.getDrumPart(CRASH_SYMBAL).playSound();
			Thread.sleep( duration*4 ); 
			
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
