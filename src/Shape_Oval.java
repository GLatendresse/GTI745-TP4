import java.awt.Color;


public class Shape_Oval extends Shape{

	public Shape_Oval(Color color, float alpha, int lifeTime, int xFromCenter, int yFromCenter, boolean isFilled) {
		super(color, alpha, lifeTime, xFromCenter, yFromCenter, isFilled);
	}

	@Override
	public void draw(GraphicsWrapper gw, int x, int y) {
		
		gw.setColor(color, alpha-((float)currentAge/(float)lifeTime));
		gw.drawCenteredOval(x+xFromCenter, y+yFromCenter, currentAge*20, currentAge*12, isFilled);
		
		this.incrementTime();
	}

}