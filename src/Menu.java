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
		Buttons btn1 = new Buttons(1, 40.0f, 30.0f, 30.0f, "Import", Color.magenta );
		listButtons.add(btn1);
		
		Buttons btn2 = new Buttons(2, 40.0f, 30.0f, 30.0f, "Save", Color.pink );
		listButtons.add(btn2);
		
		Buttons btn3 = new Buttons(3, 40.0f, 30.0f, 30.0f, "Play", Color.green );
		listButtons.add(btn3);
		
		Buttons btn4 = new Buttons(4, 40.0f, 30.0f, 30.0f, "Stop", Color.red );
		listButtons.add(btn4);
		
		Buttons btn5 = new Buttons(5, 40.0f, 30.0f, 30.0f, "Record", Color.orange );
		listButtons.add(btn5);
		
		Buttons btn6 = new Buttons(6, 40.0f, 30.0f, 30.0f, "Demo 1", Color.CYAN );
		listButtons.add(btn6);
		
		Buttons btn7 = new Buttons(7, 40.0f, 30.0f, 30.0f, "Demo 2", Color.CYAN );
		listButtons.add(btn7);
	}
	
	public void changePositionButtons()
	{
		//for(int i =0; i < listButtons.size(); i++ )
		//{
		//Bouton export
		listButtons.get(0).setCenterX((float)(gw.getWidth() * 0.07 + gw.getWidth() * 0.08) );
		listButtons.get(0).setCenterY((float)(gw.getHeight() * 0.05));
		//Bouton import
		listButtons.get(1).setCenterX((float)(gw.getWidth() * 0.07 * 2 + gw.getWidth() * 0.08) );
		listButtons.get(1).setCenterY((float)(gw.getHeight() * 0.05));
		//Bouton Play
		listButtons.get(2).setCenterX((float)(gw.getWidth() * 0.07 * 10 + gw.getWidth() * 0.08) );
		listButtons.get(2).setCenterY((float)(gw.getHeight() * 0.05));
		//Bouton Stop
		listButtons.get(3).setCenterX((float)(gw.getWidth() * 0.07 * 11 + gw.getWidth() * 0.08) );
		listButtons.get(3).setCenterY((float)(gw.getHeight() * 0.05));
		//Bouton Record
		listButtons.get(4).setCenterX((float)(gw.getWidth() * 0.07 * 12 + gw.getWidth() * 0.08) );
		listButtons.get(4).setCenterY((float)(gw.getHeight() * 0.05));	
		//Bouton Demo 1
		listButtons.get(5).setCenterX((float)(gw.getWidth() * 0.07 * 10.5 + gw.getWidth() * 0.08) );
		listButtons.get(5).setCenterY((float)(gw.getHeight() * 0.15));
		//Bouton Demo 2
		listButtons.get(6).setCenterX((float)(gw.getWidth() * 0.07 * 11.5 + gw.getWidth() * 0.08) );
		listButtons.get(6).setCenterY((float)(gw.getHeight() * 0.15));
		//}
	}
	
	public void drawButtons()
	{
		Buttons button = null;
		for(int i=0; i < listButtons.size(); i++ )
		{
			button = listButtons.get(i);

			if( i == BUTTON_PLAY-1 && ! drum.getAnimation().isAnimationInPause() && ! drum.getAnimation().isAnimationInPause()    )
			{
				if( button.isActivate() )
					gw.setColor(Color.YELLOW);
				else
					gw.setColor(Color.GRAY);
				gw.drawCenteredCircle(button.getCenterX(), button.getCenterY(), button.getRadius(), true);
				gw.setColor(Color.WHITE);
				gw.drawString(button.getCenterX() - button.getRadius(), button.getCenterY(), "Pause");
			}
			else
			{
				if( button.isActivate() )
					gw.setColor(button.getBackgroundColor());
				else
					gw.setColor(Color.GRAY);
				gw.drawCenteredCircle(button.getCenterX(), button.getCenterY(), button.getRadius(), true);
				gw.setColor(Color.WHITE);
				gw.drawString(button.getCenterX() - button.getRadius(), button.getCenterY(), button.getName());			
			}
		}
	}
	
	public void drawAnimationWidget()
	{
		float posAnimeLine = 0.0f;
		float posMenuX = gw.getWidth() * 0.30f;
		//dessine background widget
		gw.setColor( Color.WHITE );
		gw.fillRect((float)(gw.getWidth() * 0.26), 0, 460, 150);
		
		//dessine boite de l'animation
		gw.setColor( Color.BLACK );
		gw.drawRect((float)(posMenuX), (float)(gw.getHeight() * 0.05), 400, 80);
		gw.drawLine((float)(posMenuX + 100), (float)(gw.getHeight() * 0.05), (float)(posMenuX + 100), (float)(gw.getHeight() * 0.05 + 80));
		gw.drawLine((float)(posMenuX + 200), (float)(gw.getHeight() * 0.05), (float)(posMenuX + 200), (float)(gw.getHeight() * 0.05 + 80));
		gw.drawLine((float)(posMenuX + 300), (float)(gw.getHeight() * 0.05), (float)(posMenuX + 300), (float)(gw.getHeight() * 0.05 + 80));
		
		//dessine ligne de l'animation
		gw.setColor( Color.RED );
		if(  drum.getAnimation().getTotalDuration() != 0 )
		{
			posAnimeLine = (float)((float)(drum.getAnimation().getCurrentTime()) / (float)(drum.getAnimation().getTotalDuration()));
		}
		gw.drawLine((float)((posMenuX) + (400 * posAnimeLine)), (float)(gw.getHeight() * 0.05), (float)((posMenuX) + (400 * posAnimeLine)), (float)(gw.getHeight() * 0.05 + 80));
		//gw.fillRect((float)((gw.getWidth() * 0.52)), (float)(gw.getHeight() * 0.05), (float)(400 * posAnimeLine), (float)(gw.getHeight() * 0.05 + 80));
		//dessine fileName 
		gw.setColor( Color.BLACK );
		gw.drawString((float)(posMenuX), (float)(gw.getHeight() * 0.02), drum.getAnimation().getFileName() );
		gw.drawString((float)(posMenuX), (float)(gw.getHeight() * 0.05 + 100), "0" );
		gw.drawString((float)(posMenuX + 90), (float)(gw.getHeight() * 0.05 + 100), String.valueOf(  (drum.getAnimation().getTotalDuration() * 0.25)/1000 ) );
		gw.drawString((float)(posMenuX + 180), (float)(gw.getHeight() * 0.05 + 100), String.valueOf( (drum.getAnimation().getTotalDuration() * 0.5)/1000  )  );
		gw.drawString((float)(posMenuX + 270), (float)(gw.getHeight() * 0.05 + 100), String.valueOf( (drum.getAnimation().getTotalDuration() * 0.75)/1000  )  );
		gw.drawString((float)(posMenuX + 370), (float)(gw.getHeight() * 0.05 + 100), String.valueOf( (drum.getAnimation().getTotalDuration())/1000  ) + " sec" );
		
		if( drum.getRecording() != null && drum.getRecording().isRecording() )
		{
			System.out.println("Recording print");
			gw.setColor( Color.RED );
			gw.drawString((float)(posMenuX) + 200, (float)(gw.getHeight() * 0.02), "Recording"  );
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
				return button;
			}
		}
		return null;
	}
	
	public void activateAllButton()
	{
		Buttons button;
		for(int i=0; i < getButtons().size(); i++  )
		{
			button = getButton(i);
			button.activate();			
		}
	}
	
	public void desactivateAllButton()
	{
		Buttons button;
		for(int i=0; i < getButtons().size(); i++  )
		{
			button = getButton(i);
			button.desactivate();			
		}
	}
	
}
