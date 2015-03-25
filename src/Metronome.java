import java.awt.Color;


public class Metronome {


	private String name;
	private int beat; //Rythme du métronome en millisecondes
	private float width;
	private float height;
	private float centerX; 
	private float centerY;
	private Color backgroundColor;
	private Color isActivatedColor; //Couleur qui apparait quand l'utlisateur active le metronome.
	private boolean isActivated; //Détermine si le métronome est activé/désactivé
	private Thread metronomeThread;//Thread pour permettre les opérations en parrallèle.
	public Chromaesthesia chroma = new Chromaesthesia();
	

	public Metronome(String name, float width, float height, float centerX, float centerY, Color colorBackground, Color isActivatedColor, int defautBeat )
	{
		this.name = name;
		this.width = width;
		this.height = height;
		this.centerX = centerX;
		this.centerY = centerY;
		this.backgroundColor = colorBackground;
		this.isActivatedColor = isActivatedColor;
		this.isActivated = false;
		this.beat = defautBeat; 

	}
	
	public void setName(String name){ this.name = name; }
	public void setWidth(float width){ this.width = width; }
	public void setHeight(float height){ this.height = height; }
	public void setCenterX(float centerX){ this.centerX = centerX; }
	public void setCenterY(float centerY){ this.centerY = centerY; }
	public void setBackgroundColor(Color color){ this.backgroundColor = color; }
	public void setIsActivatedColor(Color color){ this.isActivatedColor = color; }
	public void activate(){
		
		this.isActivated = true; 
		playMetronome();
	
	}
	public void desactivate(){ 
		
		this.isActivated = false; 
		stopMetronome();
	}
	
	public void setBeat(int beat){ this.beat = beat; }

	
	public String getName(){ return this.name; }
	public float getWidth(){ return this.width; }
	public float getHeight(){ return this.height; }
	public float getCenterX(){ return this.centerX; }
	public float getCenterY(){ return this.centerY; }
	public Color getBackgroundColor(){ return this.backgroundColor; }
	public Color getIsActivatedColor(){ return this.isActivatedColor;  }	
	public boolean isActivated(){ return this.isActivated; }
	public int getBeat(){ return this.beat; }
	
	public void playMetronome(){
		
		
		
		Runnable playMetronome = new Runnable() {
			public void run() {
				while(isActivated){
					
					chroma.addCowbell();
					
					try {
						Thread.sleep(beat);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				}
			}
		};
		
		metronomeThread = new Thread(playMetronome);
		metronomeThread.start();
		
	}
		
	@SuppressWarnings("deprecation")
	public void stopMetronome(){
		
		metronomeThread.stop();
		
	}
	
	
	public void drawChromaethesia(GraphicsWrapper gw){
		chroma.draw(gw, (int)(centerX+width/2), (int)(centerY+height/2));
	}
	
	public void draw(GraphicsWrapper gw)
	{
		
		Color color;
		if(isActivated){
			
			color = isActivatedColor;
			
		}
		else{
			
			color = backgroundColor;
			
		}
		
		
		gw.setColor(color);
		gw.drawRect(centerX, centerY, width, height, true);
		
	}
	
	public String toString()
	{
		return this.name;
	}
	
}
