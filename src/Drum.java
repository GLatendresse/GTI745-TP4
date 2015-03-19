import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* La classe drum comprend une liste de toute les partie d'une batterie */
public class Drum 
{
	private List<DrumPart> drumParts;
	
	public Drum()
	{
		// TODO Auto-generated method stub
		drumParts = new ArrayList<DrumPart>();
		initializeDrum(1);
	}
	
	public void initializeDrum(int noTemplate)
	{
		switch (noTemplate)
		{
		case 1:
			DrumPart dp = new DrumPart("Bass Drum", 1, 80.0f, 508.0f, 500.0f, Color.red, Color.BLACK);
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
	}
	
	public DrumPart getDrumPart(int indexPart)
	{
		if( drumParts == null)
		{
			System.out.print( "FAIL !!: ");
			return null;
		}
		if( indexPart >= 0  && indexPart < drumParts.size() )
			return drumParts.get(indexPart);
		else
			return null;
	}
	
	public DrumPart getDrumPartMouseClicked(int mouseX, int mouseY)
	{
		//On vérifie les partie de drum qui sont des cercles
		DrumPart drumPart = null;
		double distance = 0.0;
		for(int i=0; i < getDrumParts().size()-1; i++  )
		{
			drumPart = getDrumPart(i);
			//On va chercher la distance entre le point milieu et l'endroit du click
			distance = Math.sqrt( Math.pow( mouseX- drumPart.getCenterX(), 2) +  Math.pow( mouseY - drumPart.getCenterY(), 2) );
			if( distance <= drumPart.getradius() )
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
		return null;
	}
	
	public List<DrumPart> getDrumParts()
	{
		return drumParts;
	}
}
