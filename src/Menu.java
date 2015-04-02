import java.awt.Button;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Menu 
{
	public static final int BUTTON_PLAY = 3; 
	
	private GraphicsWrapper gw = null;
	private List<Buttons> listButtons;
	private Drum drum;
	
	public Menu(GraphicsWrapper gw, Drum drum )
	{
		this.drum = drum;
		this.gw = gw;
		listButtons = new ArrayList<Buttons>();
		initializeMenu();
	}
	
	public void initializeMenu()
	{
		Buttons btn1 = new Buttons(1, 40.0f, 30.0f, 30.0f, "Import", Color.lightGray );
		listButtons.add(btn1);
		
		Buttons btn2 = new Buttons(2, 40.0f, 30.0f, 30.0f, "Export", Color.lightGray );
		listButtons.add(btn2);
		
		Buttons btn3 = new Buttons(3, 40.0f, 30.0f, 30.0f, "Play", Color.green );
		listButtons.add(btn3);
		
		Buttons btn4 = new Buttons(4, 40.0f, 30.0f, 30.0f, "Stop", Color.red );
		listButtons.add(btn4);
	}
	
	public void changePositionButtons()
	{
		for(int i =0; i < listButtons.size(); i++ )
		{
			listButtons.get(i).setCenterX((float)(gw.getWidth() * 0.08 * (i+1) + gw.getWidth() * 0.1) );
			listButtons.get(i).setCenterY((float)(gw.getHeight() * 0.05));
		}
	}
	
	public void drawButtons()
	{
		Buttons button = null;
		for(int i=0; i < listButtons.size(); i++ )
		{
			button = listButtons.get(i);
			if( i == BUTTON_PLAY-1 && ! drum.getAnimation().isAnimationInPause()   )
			{
				gw.setColor(Color.YELLOW);
				gw.drawCenteredCircle(button.getCenterX(), button.getCenterY(), button.getRadius(), true);
				gw.setColor(Color.WHITE);
				gw.drawString(button.getCenterX() - button.getRadius(), button.getCenterY(), "Pause");
			}
			else
			{
				gw.setColor(button.getBackgroundColor());
				gw.drawCenteredCircle(button.getCenterX(), button.getCenterY(), button.getRadius(), true);
				gw.setColor(Color.WHITE);
				gw.drawString(button.getCenterX() - button.getRadius(), button.getCenterY(), button.getName());			
			}
		}
	}
	
	public void drawAnimationWidget()
	{
		float posAnimeLine = 0.0f;
		//dessine background widget
		gw.setColor( Color.WHITE );
		gw.fillRect((float)(gw.getWidth() * 0.5), 0, 460, 150);
		
		//dessine boite de l'animation
		gw.setColor( Color.BLACK );
		gw.drawRect((float)(gw.getWidth() * 0.52), (float)(gw.getHeight() * 0.05), 400, 80);
		gw.drawLine((float)(gw.getWidth() * 0.52 + 100), (float)(gw.getHeight() * 0.05), (float)(gw.getWidth() * 0.52 + 100), (float)(gw.getHeight() * 0.05 + 80));
		gw.drawLine((float)(gw.getWidth() * 0.52 + 200), (float)(gw.getHeight() * 0.05), (float)(gw.getWidth() * 0.52 + 200), (float)(gw.getHeight() * 0.05 + 80));
		gw.drawLine((float)(gw.getWidth() * 0.52 + 300), (float)(gw.getHeight() * 0.05), (float)(gw.getWidth() * 0.52 + 300), (float)(gw.getHeight() * 0.05 + 80));
		
		//dessine ligne de l'animation
		gw.setColor( Color.RED );
		if( drum.getAnimation().getTotalDuration() != 0 )
		{
			posAnimeLine = (float)((float)(drum.getAnimation().getCurrentTime()) / (float)(drum.getAnimation().getTotalDuration()));
			System.out.println("Anime: " + drum.getAnimation().getCurrentTime() + " / " + drum.getAnimation().getTotalDuration() + " = " + posAnimeLine );
		}
		gw.drawLine((float)((gw.getWidth() * 0.52) + (400 * posAnimeLine)), (float)(gw.getHeight() * 0.05), (float)((gw.getWidth() * 0.52) + (400 * posAnimeLine)), (float)(gw.getHeight() * 0.05 + 80));
		//gw.fillRect((float)((gw.getWidth() * 0.52)), (float)(gw.getHeight() * 0.05), (float)(400 * posAnimeLine), (float)(gw.getHeight() * 0.05 + 80));
		//dessine fileName 
		gw.setColor( Color.BLACK );
		gw.drawString((float)(gw.getWidth() * 0.52), (float)(gw.getHeight() * 0.02), drum.getFileName() );
		gw.drawString((float)(gw.getWidth() * 0.52), (float)(gw.getHeight() * 0.05 + 100), "0" );
		gw.drawString((float)(gw.getWidth() * 0.52 + 90), (float)(gw.getHeight() * 0.05 + 100), String.valueOf(  (drum.getAnimation().getTotalDuration() * 0.25)/1000 ) );
		gw.drawString((float)(gw.getWidth() * 0.52 + 180), (float)(gw.getHeight() * 0.05 + 100), String.valueOf( (drum.getAnimation().getTotalDuration() * 0.5)/1000  )  );
		gw.drawString((float)(gw.getWidth() * 0.52 + 270), (float)(gw.getHeight() * 0.05 + 100), String.valueOf( (drum.getAnimation().getTotalDuration() * 0.75)/1000  )  );
		gw.drawString((float)(gw.getWidth() * 0.52 + 370), (float)(gw.getHeight() * 0.05 + 100), String.valueOf( (drum.getAnimation().getTotalDuration())/1000  ) + " sec" );
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
