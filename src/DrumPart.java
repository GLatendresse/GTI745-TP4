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
	
	private String name;
	private int type;      //Le type de la partie du drum (bass drum, crash symbal, ... )
	private double radius; 
	private double centerX; 
	private double centerY;
	private boolean playState; //Détermine si l'instrument est activé/désactivé pour jouer
	private boolean cymbalHihatState; //Détermine si la symbale (Hi-hat) est monté par sa pédale ou pas 
	
	public DrumPart(int type, double radius, double centerX, double centerY )
	{
		this.name = "-";
		this.type = type;
		this.radius = radius;
		this.centerX = centerX;
		this.centerY = centerY;
		this.playState = true;
		this.cymbalHihatState = false;
	}
	
	public void setName(String name){ this.name = name; }
	public void setType(int type){ this.type = type; }
	public void setradius(double radius){ this.radius = radius; }
	public void setCenterX(double centerX){ this.centerX = centerX; }
	public void setCenterY(double centerY){ this.centerY = centerY; }
	public void setPlayState(boolean playState){ this.playState = playState; }
	public void setCymbalHihatState(boolean cymbalHihatState){ this.cymbalHihatState = cymbalHihatState; }
	
	public String getName(){ return this.name; }
	public int setType(){ return this.type; }
	public double getradius(){ return this.radius; }
	public double getCenterX(){ return this.centerX; }
	public double getCenterY(){ return this.centerY; }
	public boolean getPlayState(){ return this.playState; }
	public boolean getCymbalHihatState(){ return this.cymbalHihatState; }
	
	public void draw(GraphicsWrapper gw)
	{
		System.out.println("draw:" + type);
		switch (type)
		{
		case BASS_DRUM :
			gw.drawHalfCircle(200, 200, 50, true);
			break;
		default:
			gw.drawCircle(200, 200, 10);
			break;
		}
	}
	
	public String toString()
	{
		return this.name;
	}
}
