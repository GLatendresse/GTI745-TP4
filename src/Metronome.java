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
	private boolean minusIsPressed; //Détermine si le "-" est appuyé"
	private boolean plusIsPressed; //Détermine si le "+" est appuyé"
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
		this.plusIsPressed = false;
		this.minusIsPressed = false;
		this.beat = defautBeat; 

	}
	
	public void setName(String name){ this.name = name; }
	public void setWidth(float width){ this.width = width; }
	public void setHeight(float height){ this.height = height; }
	public void setCenterX(float centerX){ this.centerX = centerX; }
	public void setCenterY(float centerY){ this.centerY = centerY; }
	public void setBackgroundColor(Color color){ this.backgroundColor = color; }
	public void setIsActivatedColor(Color color){ this.isActivatedColor = color; }
	public void minusPressed(){ this.minusIsPressed = true; }
	public void minusUnpressed(){ this.minusIsPressed = false; }
	public void plusPressed(){ this.plusIsPressed = true; }
	public void plusUnpressed(){ this.plusIsPressed = false; }
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
	public float getMinusCenterX(){ return centerX + (1.f/20.f)*width;}
	public float getMinusCenterY(){ return centerY + (3.f/2.f)*height;}
	public float getMinusWidth(){ return (2.f/5.f)*width;}
	public float getMinusHeight(){ return (1.f/4.f)*height;}
	public float getPlusCenterX(){ return centerX + (width/2.f) + (1.f/20.f)*width;}
	public float getPlusCenterY(){ return centerY + (3.f/2.f)*height - ((2.f/5.f)*width)/2.f;}
	public float getPlusWidth(){ return (2.f/5.f)*width;}
	public float getPlusHeight(){ return (2.f/5.f)*width;}
	public Color getBackgroundColor(){ return this.backgroundColor; }
	public Color getIsActivatedColor(){ return this.isActivatedColor; }	
	public boolean isActivated(){ return this.isActivated; }
	public boolean minusIsPressed(){ return this.minusIsPressed; }
	public boolean plusIsPressed(){ return this.plusIsPressed; }
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
					
					System.out.println("Beat : " + beat);
						
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
	
	public void drawMetronome(GraphicsWrapper gw)
	{
		
		Color color;
		if(isActivated){
			
			color = isActivatedColor;
			
		}
		else{
			
			color = backgroundColor;
			
		}
		
		float testCenterx = centerX + (1.f/10.f)*width;
		float testCentery = centerY + (3.f/2.f)*height;
		float testwidth = (2.f/5.f)*width;
		float testheight = (1.f/4.f)*height;
		
		gw.setColor(color);
		//Dessine le rectangle du métronome
		gw.drawRect(centerX, centerY, width, height, true);
		
	}
	
	public void drawMinus(GraphicsWrapper gw)
	{
		
		Color color;
		
		if(minusIsPressed){
			
			color = isActivatedColor;
			
		}
		else{
			
			color = backgroundColor;
			
		}
		
		float testCenterx = centerX + (1.f/10.f)*width;
		float testCentery = centerY + (3.f/2.f)*height;
		float testwidth = (2.f/5.f)*width;
		float testheight = (1.f/4.f)*height;
		
		gw.setColor(color);
		//Dessine le "-"
		gw.drawRect(centerX + (1.f/20.f)*width, centerY + (3.f/2.f)*height, (2.f/5.f)*width, (1.f/4.f)*height, true);
		
		
	}
	
	public void drawPlus(GraphicsWrapper gw)
	{
		
		Color color;
		if(plusIsPressed){
			
			color = isActivatedColor;
			
		}
		else{
			
			color = backgroundColor;
			
		}
		
		float testCenterx = centerX + (1.f/10.f)*width;
		float testCentery = centerY + (3.f/2.f)*height;
		float testwidth = (2.f/5.f)*width;
		float testheight = (1.f/4.f)*height;
		
		gw.setColor(color);
	
		//Dessine le "+"
		gw.drawRect(centerX + (width/2.f) + (1.f/20.f)*width, centerY + (3.f/2.f)*height, (2.f/5.f)*width, (1.f/4.f)*height, true);
		gw.drawRect(centerX + (width/2.f) + (1.f/20.f)*width + ((2.f/5.f)*width)/2.f - ((1.f/4.f)*height)/2.f, centerY + (3.f/2.f)*height - ((2.f/5.f)*width)/2.f + ((1.f/4.f)*height)/2.f, (1.f/4.f)*height, (2.f/5.f)*width, true);
		
	}
	
	public void drawName(GraphicsWrapper gw)
	{
		
		gw.setColor(Color.black);
		gw.drawString(centerX + (1.f/8.f)*width, centerY + height/2.f, name);
		
	}
	
	public void drawBeat(GraphicsWrapper gw){
		
		gw.setColor(Color.black);
		gw.drawString(centerX + (1.f/30.f)*width, centerY + (3*height)/4.f, "Beat:" + beat + "ms");
		
	}
	
	public void draw(GraphicsWrapper gw){
		
		drawMetronome(gw);
		drawMinus(gw);
		drawPlus(gw);
		drawName(gw);
		drawBeat(gw);
		
	}
	
	public String toString()
	{
		return this.name;
	}
	
}
