import java.awt.Color;


public class Shape_Rectangle extends Shape{
	
	public Shape_Rectangle(Color color, float alpha, int lifeTime, int xFromCenter, int yFromCenter, boolean isFilled) {
		super(color, alpha, lifeTime, xFromCenter, yFromCenter, isFilled);
	}
	
	@Override
	public void draw(GraphicsWrapper gw, int x, int y) {
		
		gw.setColor(color);
		gw.drawRect(xFromCenter, yFromCenter, x, y, isFilled);
		
	}

}
