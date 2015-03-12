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
		System.out.println("new drum");
		drumParts = new ArrayList<DrumPart>();
		System.out.println("new array");
		initializeDrum(1);
	}
	
	public void initializeDrum(int noTemplate)
	{
		System.out.println("noTemplate" + noTemplate);
		switch (noTemplate)
		{
		case 1:
			System.out.println("new drum1");
			DrumPart dp = new DrumPart(1, 200.0, 508.0, 1016.0);
			drumParts.add(dp);
			System.out.println("drum1" + dp.toString());
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
}
