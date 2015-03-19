import java.awt.Color;

//Classe qui comprend la partie d'une batterie (symbale, tambour, pédale...)
public class DrumPart 
{	
	public static final int BASS_DRUM = 1; 
	public static final int FLOOR_TOM_TOM = 2; 
	public static final int MIDDLE_TOM_TOM = 3; 
	public static final int HIGH_TOM_TOM = 4; 
	public static final int SNARE_DRUM = 5; 
	public static final int HIHAT_CYMBAL = 6; 
	public static final int CRASH_SYMBAL = 7; 
	public static final int RIDE_SYMBAL = 8; 
	public static final int HIHAT_PEDAL = 9; 
	
	private String name;
	private int type;      //Le type de la partie du drum (bass drum, crash symbal, ... )
	private float radius; 
	private float centerX; 
	private float centerY;
	private Color backgroundColor;
	private Color actionColor; //Couleur qui apparait quand l'utlisateur touche la partie de ce drum.
	private boolean playState; //Détermine si l'instrument est activé/désactivé pour jouer
	private boolean cymbalHihatState; //Détermine si la symbale (Hi-hat) est monté par sa pédale ou pas 
	private Sound sound = new Sound();
	public Chromaesthesia chroma = new Chromaesthesia();
	
	public DrumPart(String name, int type, float radius, float centerX, float centerY )
	{
		this.name = name;
		this.type = type;
		this.radius = radius;
		this.centerX = centerX;
		this.centerY = centerY;
		this.actionColor = Color.white;
		this.backgroundColor = Color.white;
		this.playState = true;
		this.cymbalHihatState = false;
		//sound = new Sound();
	}
	
	public DrumPart(String name, int type, float radius, float centerX, float centerY, Color colorBackground, Color colorAction )
	{
		this.name = name;
		this.type = type;
		this.radius = radius;
		this.centerX = centerX;
		this.centerY = centerY;
		this.actionColor = colorAction;
		this.backgroundColor = colorBackground;
		this.playState = true;
		this.cymbalHihatState = false;
	}
	
	public void setName(String name){ this.name = name; }
	public void setType(int type){ this.type = type; }
	public void setradius(float radius){ this.radius = radius; }
	public void setCenterX(float centerX){ this.centerX = centerX; }
	public void setCenterY(float centerY){ this.centerY = centerY; }
	public void setBackgroundColor(Color color){ this.backgroundColor = color; }
	public void setActionColor(Color color){ this.actionColor = color; }
	public void setPlayState(boolean playState){ this.playState = playState; }
	public void setCymbalHihatState(boolean cymbalHihatState){ this.cymbalHihatState = cymbalHihatState; }
	
	public String getName(){ return this.name; }
	public int setType(){ return this.type; }
	public float getradius(){ return this.radius; }
	public float getCenterX(){ return this.centerX; }
	public float getCenterY(){ return this.centerY; }
	public Color getBackgroundColor(Color color){ return this.backgroundColor; }
	public Color getActionColor(Color color){ return this.actionColor;  }	
	public boolean getPlayState(){ return this.playState; }
	public boolean getCymbalHihatState(){ return this.cymbalHihatState; }
	
	public void playSound()
	{
		switch (type)
		{
		case BASS_DRUM :
			chroma.addBass();
			break;
		case FLOOR_TOM_TOM:
			chroma.addLowTom();
			break;
		case MIDDLE_TOM_TOM:
			chroma.addMidTom();
			break;
		case HIGH_TOM_TOM:
			chroma.addHighTom();
			break;
		case SNARE_DRUM:
			chroma.addSnare();
			break;
		case HIHAT_CYMBAL:
				if(cymbalHihatState)
					chroma.addHiHatCymbalOpen();
				else
					chroma.addHiHatCymbalClosed();
			break;
		case CRASH_SYMBAL:
			chroma.addCrashCymbal();
			break;
		case RIDE_SYMBAL:
			chroma.addRideCymbal();
			break;
		case HIHAT_PEDAL:
			chroma.addHiHatPedal();
			break;
		default:

			break;
		}
	}
	
	public void drawChromaethesia(GraphicsWrapper gw){
		chroma.draw(gw, (int)centerX, (int)centerY);
	}
	
	public void draw(GraphicsWrapper gw)
	{
		gw.setColor(backgroundColor);
		switch (type)
		{
		case BASS_DRUM :
			//gw.fillHalfCircle(centerX, centerY, radius, backgroundColor);
			//gw.drawCenteredCircle(centerX, centerY, radius, true);
			gw.fillArc(centerX, centerY, radius, 0, (float)Math.PI);
			break;
		case FLOOR_TOM_TOM:
			//gw.fillCenteredCircle(centerX, centerY, radius, backgroundColor);
			gw.drawCenteredCircle(centerX, centerY, radius, true);
			break;
		case MIDDLE_TOM_TOM:
			//gw.fillCenteredCircle(centerX, centerY, radius, backgroundColor);
			gw.drawCenteredCircle(centerX, centerY, radius, true);
			break;
		case HIGH_TOM_TOM:
			//gw.setColor(backgroundColor);
			gw.drawCenteredCircle(centerX, centerY, radius, true);
			//gw.fillCenteredCircle(centerX, centerY, radius, backgroundColor);
			break;
		case HIHAT_CYMBAL:
			//gw.fillCenteredCircle(centerX, centerY, radius, backgroundColor);
			gw.drawCenteredCircle(centerX, centerY, radius, true);
			gw.setColor(0, 0, 0);
			gw.drawCenteredCircle(centerX, centerY, radius*0.6f);
			gw.drawCenteredCircle(centerX, centerY, radius*0.3f);
			
			break;
		case CRASH_SYMBAL:
			//gw.fillCenteredCircle(centerX, centerY, radius, backgroundColor);
			gw.drawCenteredCircle(centerX, centerY, radius, true);
			gw.setColor(0, 0, 0);
			gw.drawCenteredCircle(centerX, centerY, radius*0.6f);
			gw.drawCenteredCircle(centerX, centerY, radius*0.3f);
			break;
		case RIDE_SYMBAL:
			//gw.fillCenteredCircle(centerX, centerY, radius, backgroundColor);
			gw.drawCenteredCircle(centerX, centerY, radius, true);
			gw.setColor(0, 0, 0);
			gw.drawCenteredCircle(centerX, centerY, radius*0.6f);
			gw.drawCenteredCircle(centerX, centerY, radius*0.3f);
			break;
		case SNARE_DRUM:
			//gw.fillCenteredCircle(centerX, centerY, radius, backgroundColor);
			gw.drawCenteredCircle(centerX, centerY, radius, true);
			break;
		case HIHAT_PEDAL:
			gw.fillRect(centerX, centerY, radius*2, radius*2, backgroundColor);
			break;
		default:
			gw.drawCenteredCircle(200, 200, 10);
			break;
		}
	}
	
	public String toString()
	{
		return this.name;
	}
}
