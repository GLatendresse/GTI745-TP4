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
			DrumPart dp = new DrumPart(1, 80.0f, 508.0f, 500.0f, Color.red, Color.BLACK);
			drumParts.add(dp);
			
			DrumPart dp2 = new DrumPart(2, 30.0f, 0.0f, 300.0f, Color.orange, Color.BLACK);
			drumParts.add(dp2);
			
			DrumPart dp3 = new DrumPart(3, 30.0f, 108.0f, 300.0f, Color.yellow, Color.BLACK);
			drumParts.add(dp3);
			
			DrumPart dp4 = new DrumPart(4, 30.0f, 208.0f, 300.0f, Color.green, Color.BLACK);
			drumParts.add(dp4);
			
			DrumPart dp5 = new DrumPart(5, 30.0f, 308.0f, 300.0f, Color.cyan, Color.BLACK);
			drumParts.add(dp5);
			
			DrumPart dp6 = new DrumPart(6, 30.0f, 408.0f, 300.0f, Color.blue, Color.BLACK);
			drumParts.add(dp6);
			
			DrumPart dp7 = new DrumPart(7, 30.0f, 508.0f, 300.0f, Color.magenta, Color.BLACK);
			drumParts.add(dp7);
			
			DrumPart dp8 = new DrumPart(8, 30.0f, 608.0f, 300.0f, Color.pink, Color.BLACK);
			drumParts.add(dp8);
			
			DrumPart dp9 = new DrumPart(9, 15.0f, 708.0f, 300.0f, Color.gray, Color.BLACK);
			drumParts.add(dp9);
			
			break;
		default:
			drumParts.add(new DrumPart(1, 200, 508, 1016));
			break;
		}
	}
	
	public DrumPart getDrumPart(int indexPart)
	{
		System.out.print( "getDrumPart: ");
		if( drumParts == null)
		{
			System.out.print( "FAIL !!: ");
			return null;
		}
		System.out.println("getDrumPart: " + indexPart + " < " + drumParts.size() );
		if( indexPart >= 0  && indexPart < drumParts.size() )
			return drumParts.get(indexPart);
		else
			return null;
	}
	
	public List<DrumPart> getDrumParts()
	{
		return drumParts;
	}
}
