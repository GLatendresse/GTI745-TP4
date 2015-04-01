import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/* La classe drum comprend une liste de toute les partie d'une batterie */
public class Drum 
{
	public static final int HIHAT_CYMBAL = 6; 
	public static final int HIHAT_PEDAL = 9; 
	
	private List<DrumPart> drumParts;
	private Animation animation;
	public GraphicsWrapper gw = null;
	
	private float drumPositionX = 0.0f;
	private float drumPositionY = 0.0f;
	private float drumHeight = 10.0f;
	private float drumWidth = 10.0f; 
	
	public Drum(GraphicsWrapper gw)
	{
		// TODO Auto-generated method stub
		this.gw = gw;
		System.out.println("contruct");
		drumParts = new ArrayList<DrumPart>();
		animation = new Animation();
		//initializeDrumPosition();
		initializeDrum();
	}
	
	public void setDrumPostionX(float posX){  drumPositionX = posX; }
	public void setDrumPostionY(float posY){ drumPositionY = posY; }
	public void setDrumWidth(float width){  drumWidth = width; }
	public void setDrumHeight(float height){ drumHeight = height; }
	public void setAnimation(Animation anime){ animation = anime; }
	
	public float getDrumPostionX(){ return drumPositionX; }
	public float getDrumPostionY(){ return drumPositionY; }
	public float getDrumWidth(){  return drumWidth; }
	public float getDrumHeight(){ return drumHeight; }
	public Animation getAnimation(){ return animation; }
	

	
	public DrumPart getDrumPart(int indexPart)
	{
		if( drumParts == null)
		{
			return null;
		}
		if( indexPart >= 0  && indexPart < drumParts.size() )
			return drumParts.get(indexPart);
		else
			return null;
	}
	
	public DrumPart getDrumPartMouseClicked(int mouseX, int mouseY)
	{
		
		//On vérifie les partie de drum 
		DrumPart drumPart = null;
		double distance = 0.0;
		for(int i=0; i < getDrumParts().size(); i++  )
		{
			drumPart = getDrumPart(i);
			//On vérifie si on a cliquer sur la pédale Hihat
			if( i == HIHAT_PEDAL-1 )
			{
				if( mouseX >= drumPart.getCenterX() && mouseX <= drumPart.getCenterX() + drumPart.getRadius()*2 )
				{
					if( mouseY >= drumPart.getCenterY() && mouseY <= drumPart.getCenterY() + drumPart.getRadius()*2 )
					{
						if(drumPart.getCymbalHihatOpening())
						{
							System.out.println("hihat Open");
							drumPart.setCymbalHihatOpening(false);
						}
						else
						{
							System.out.println("hihat close");
							drumPart.setCymbalHihatOpening(true);
						}
						return drumPart;
					}
				}
			}
			else
			{
				//On va chercher la distance entre le point milieu et l'endroit du click
				distance = Math.sqrt( Math.pow( mouseX- drumPart.getCenterX(), 2) +  Math.pow( mouseY - drumPart.getCenterY(), 2) );
				if( distance <= drumPart.getRadius() )
				{
					if( i > 0 )
					{
						return drumPart;
					}
					else if( mouseY <=  drumPart.getCenterY() )
					{
						return drumPart;
					}
				}
			}
		}
		return null;
	}
	
	public List<DrumPart> getDrumParts()
	{
		return drumParts;
	}
	
	public void initializeDrumPosition()
	{
		System.out.println("init drum");
		setDrumPostionX( (float)(gw.getWidth()/4.0) );
		setDrumPostionY( (float)(gw.getHeight()/4.0) );
		setDrumWidth( (float)(gw.getWidth()/2.0) );
		setDrumHeight( (float)(gw.getHeight()/2.0) );
		//gw.drawRect(drumPositionX, drumPositionY, drumWidth, drumHeight);
		//initializeDrum(1);
	}
	
	//Initialize le drum en mettant les parties à leurs position par défaut.
	public void initializeDrum()
	{		
		DrumPart dp = new DrumPart("Bass Drum", 1, 0.0f, (float)(drumWidth), (float)(drumPositionY + drumHeight), Color.red, Color.BLACK);
		drumParts.add(dp);
		
		DrumPart dp2 = new DrumPart("Floor Tom Tom", 2, 0.0f, 0.0f, 0.0f, new Color( 255,165,0), Color.BLACK);
		drumParts.add(dp2);
		
		DrumPart dp3 = new DrumPart("Middle Tom Tom", 3, 0.0f, 0.0f, 0.0f, new Color(255,183,50), Color.BLACK);
		drumParts.add(dp3);
		
		DrumPart dp4 = new DrumPart("High Tom Tom", 4, 0.0f, 0.0f, 0.0f, new Color(255,201,102), Color.BLACK);
		drumParts.add(dp4);
		
		DrumPart dp5 = new DrumPart("Snare Drum", 5, 0.0f, 0.0f, 0.0f, Color.green, Color.BLACK);
		drumParts.add(dp5);
		
		DrumPart dp6 = new DrumPart("hihat cymbal", 6, 0.0f, 0.0f, 0.0f, Color.magenta, Color.BLACK);
		drumParts.add(dp6);
		
		DrumPart dp7 = new DrumPart("crash cymbal", 7, 0.0f, 0.0f, 0.0f, Color.yellow, Color.BLACK);
		drumParts.add(dp7);
		
		DrumPart dp8 = new DrumPart("ride cymbal", 8, 0.0f, 0.0f, 0.0f, Color.cyan, Color.BLACK);
		drumParts.add(dp8);
		
		DrumPart dp9 = new DrumPart("hihat pedal", 9, 0.0f, 0.0f, 0.0f, Color.gray, Color.BLACK);
		drumParts.add(dp9);

	}
	
	//Permet de dessiner la ligne entre la 
	public void drawLineHihat()
	{
		DrumPart hiHat = getDrumPart(HIHAT_CYMBAL -1);
		DrumPart hiHatPedal = getDrumPart(HIHAT_PEDAL -1);
		
		gw.setColor(1,1,1);
		gw.drawLine(hiHat.getCenterX(), hiHat.getCenterY() + hiHat.getRadius(), hiHatPedal.getCenterX()+ (float)(hiHatPedal.getRadius()), hiHatPedal.getCenterY());
		
		/*
		for(int i=0; i < getDrumParts().size()-1; i++  )
		{
			
		}*/
	}
	
	
	/*
	public void changeDrumPartsPosition(int noTemplate)
	{		
		switch (noTemplate)
		{
		case 1:
			DrumPart dp = new DrumPart("Bass Drum", 1, 80.0f, (float)(drumWidth), (float)(drumPositionY + drumHeight), Color.red, Color.BLACK);
			drumParts.add(dp);
			
			DrumPart dp2 = new DrumPart("Floor Tom Tom", 2, 30.0f, 30.0f, 300.0f, new Color( 255,165,0), Color.BLACK);
			drumParts.add(dp2);
			
			DrumPart dp3 = new DrumPart("Middle Tom Tom", 3, 30.0f, 138.0f, 300.0f, new Color(255,183,50), Color.BLACK);
			drumParts.add(dp3);
			
			DrumPart dp4 = new DrumPart("High Tom Tom", 4, 30.0f, 238.0f, 300.0f, new Color(255,201,102), Color.BLACK);
			drumParts.add(dp4);
			
			DrumPart dp5 = new DrumPart("Snare Drum", 5, 45.0f, 338.0f, 300.0f, Color.green, Color.BLACK);
			drumParts.add(dp5);
			
			DrumPart dp6 = new DrumPart("hihat cymbal", 6, 30.0f, 438.0f, 300.0f, Color.magenta, Color.BLACK);
			drumParts.add(dp6);
			
			DrumPart dp7 = new DrumPart("crash cymbal", 7, 30.0f, 538.0f, 300.0f, Color.yellow, Color.BLACK);
			drumParts.add(dp7);
			
			DrumPart dp8 = new DrumPart("ride cymbal", 8, 30.0f, 638.0f, 300.0f, Color.cyan, Color.BLACK);
			drumParts.add(dp8);
			
			DrumPart dp9 = new DrumPart("hihat pedal", 9, 15.0f, 738.0f, 300.0f, Color.gray, Color.BLACK);
			drumParts.add(dp9);
			
			break;
		default:
			drumParts.add(new DrumPart("-", 1, 200, 508, 1016));
			break;
		}
	}*/
}
