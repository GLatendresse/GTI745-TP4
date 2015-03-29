import java.awt.Button;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Menu 
{
	private GraphicsWrapper gw = null;
	private List<Buttons> listButtons;
	
	public Menu(GraphicsWrapper gw )
	{
		this.gw = gw;
		listButtons = new ArrayList<Buttons>();
		initializeMenu();
	}
	
	public void initializeMenu()
	{
		Buttons btn1 = new Buttons(1, 40.0f, 30.0f, 30.0f, "Import", Color.green );
		listButtons.add(btn1);
	}
	
	public void changePositionButtons()
	{
		listButtons.get(0).setCenterX((float)(gw.getWidth() * 0.2));
		listButtons.get(0).setCenterY((float)(gw.getHeight() * 0.05));
	}
	
	public void drawButtons()
	{
		Buttons button = null;
		for(int i=0; i < listButtons.size(); i++ )
		{
			button = listButtons.get(i);
			gw.setColor(button.getBackgroundColor());
			gw.drawCenteredCircle(button.getCenterX(), button.getCenterY(), button.getRadius(), true);
			gw.setColor(Color.WHITE);
			gw.drawString(button.getCenterX() - button.getRadius(), button.getCenterY(), button.getName());
		}
	}
	
	public List<Buttons> getButtons()
	{
		return listButtons;
	}
	
	public Buttons getButton(int index)
	{
		return listButtons.get(index);
	}
	
	public Buttons getButtonMouseClicked(int mouseX, int mouseY)
	{		
		Buttons button = null;
		double distance = 0.0;
		for(int i=0; i < getButtons().size(); i++  )
		{
			button = getButton(i);

			//On va chercher la distance entre le point milieu et l'endroit du click
			distance = Math.sqrt( Math.pow( mouseX- button.getCenterX(), 2) +  Math.pow( mouseY - button.getCenterY(), 2) );
			if( distance <= button.getRadius() )
			{
				if( i > 0 )
				{
					return button;
				}
				else if( mouseY <=  button.getCenterY() )
				{
					return button;
				}
			}
		}
		return null;
	}
	
}
