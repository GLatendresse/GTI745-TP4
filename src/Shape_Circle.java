import java.awt.Color;


public class Shape_Circle extends Shape{

	public Shape_Circle(Color color, float alpha, int lifeTime, int xFromCenter, int yFromCenter, boolean isFilled) {
		super(color, alpha, lifeTime, xFromCenter, yFromCenter, isFilled);
	}

	@Override
	public void draw(GraphicsWrapper gw, int x, int y) {
		gw.setColor(color, alpha-((float)currentAge/(float)lifeTime));
		gw.drawCenteredCircle(x+xFromCenter, y+yFromCenter, currentAge*10, isFilled);
		this.incrementTime();
	}

}
