import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

//Les boutons du menu

public class Buttons 
{
	public static final int BUTTON_IMPORT = 1; 
	public static final int BUTTON_SAVE = 2;
	public static final int BUTTON_PLAY = 3; 
	public static final int BUTTON_STOP = 4;
	public static final int BUTTON_RECORD = 5; 
	public static final int BUTTON_DEMO1 = 6;
	public static final int BUTTON_DEMO2 = 7; 
	public static final int BUTTON_NEW = 8; 
	
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
	private boolean isActivate = true;
	
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
	
	public boolean isActivate() { return isActivate; }
	public void activate(){  isActivate = true; }
	public void desactivate(){  isActivate = false; }
	
	public Color getBackgroundColor()
	{ 
		/*
		if( type == BUTTON_PLAY && drum.getAnimation() )
		{
			
		}
		else */
		return this.backgroundColor; 
	}
	
	public void doFunction(Drum drum, Menu menu)
	{
		if( isActivate() && drum != null && menu != null)
		{
			switch (type)
			{
	
			case BUTTON_IMPORT:
				drum.getAnimation().importFile();
				break;
			case BUTTON_SAVE:
				drum.getAnimation().SaveRecordToFile( drum.getRecording() );	
				break;
			case BUTTON_PLAY:
				System.out.println("Bouton play press !!");
				for( int i =0; i < drum.getAnimation().getNotes().size(); i++ )
				{
					System.out.println(drum.getAnimation().getNote(i).toString());
				}
				
				if( drum.getAnimation().isAnimationInPause() )
				{
					menu.getButton(BUTTON_NEW -1).desactivate();
					menu.getButton(BUTTON_SAVE -1).desactivate();
					menu.getButton(BUTTON_IMPORT -1).desactivate();
					menu.getButton(BUTTON_RECORD -1).desactivate();
					menu.getButton(BUTTON_DEMO1 -1).desactivate();
					menu.getButton(BUTTON_DEMO2 -1).desactivate();
					
					if( drum.getAnimation().isDemoPlay() )
					{
						drum.getAnimation().playDemo();
					}
					else
					{
						System.out.println("Animation Play");
						drum.getAnimation().playAnimation();
					}
				}
				else
				{
					menu.activateAllButton();
					drum.getAnimation().pauseAnimation();
				}
				break;
			case BUTTON_STOP:
				//Si on est en mode enregistrer
				if( drum.getRecording().isRecording() )
				{
					drum.getRecording().stopRecording();
					drum.getRecording().getNote( drum.getRecording().getNotes().size()-1 ).setDuration( 0 );
				}
				//Si on est en mode jouer enregistrement
				else
				{
					if( drum.getAnimation().isAnimationPlay() )
						drum.getAnimation().stopAnimation();
					else if( drum.getAnimation().isDemoPlay() )
						drum.getAnimation().stopDemo();
				}
				menu.activateAllButton();
				break;
			case BUTTON_RECORD:
				System.out.println("Recording");
				drum.getRecording().startRecording();
				
				menu.getButton(BUTTON_SAVE -1).desactivate();
				menu.getButton(BUTTON_IMPORT -1).desactivate();
				menu.getButton(BUTTON_RECORD -1).desactivate();
				menu.getButton(BUTTON_DEMO1 -1).desactivate();
				menu.getButton(BUTTON_DEMO2 -1).desactivate();
				menu.getButton(BUTTON_NEW -1).desactivate();
				break;
			case BUTTON_DEMO1:
				drum.getAnimation().setFileName("demo.gti745");
				drum.getAnimation().initializeDemo("demos\\demo.gti745");
				drum.getAnimation().playDemo();
				
				menu.getButton(BUTTON_SAVE -1).desactivate();
				menu.getButton(BUTTON_IMPORT -1).desactivate();
				menu.getButton(BUTTON_RECORD -1).desactivate();
				menu.getButton(BUTTON_DEMO2 -1).desactivate();
				menu.getButton(BUTTON_NEW -1).desactivate();
				
				break;
			case BUTTON_DEMO2:
				drum.getAnimation().setFileName("demo2.gti745");
				drum.getAnimation().initializeDemo("demos\\demo2.gti745");
				drum.getAnimation().playDemo();
				
				menu.getButton(BUTTON_SAVE -1).desactivate();
				menu.getButton(BUTTON_IMPORT -1).desactivate();
				menu.getButton(BUTTON_RECORD -1).desactivate();
				menu.getButton(BUTTON_DEMO1 -1).desactivate();
				menu.getButton(BUTTON_NEW -1).desactivate();
				
				break;
			case BUTTON_NEW:
				drum.getAnimation().createNewFile();
				break;
			default:
				
				break;
			}
		}
	}
	
	/*
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
	}*/
}
