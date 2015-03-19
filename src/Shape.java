import java.awt.Color;


public abstract class Shape {
	protected Color color;
	protected float alpha;
	protected int lifeTime, currentAge;
	protected int xFromCenter;
	protected int yFromCenter;
	protected boolean isFilled;
	
	public Shape (Color color, float alpha, int lifeTime, int xFromCenter, int yFromCenter,
			boolean isFilled){
		this.color = color;
		this.alpha = alpha;
		this.lifeTime = lifeTime;
		this.currentAge = 0;
		this.xFromCenter = xFromCenter;
		this.yFromCenter = yFromCenter;
		this.isFilled = isFilled;
	}
	
	public abstract void draw(GraphicsWrapper gw, int x, int y);
	
	public void incrementTime(){ currentAge++; }
	
	public boolean isDead(){ return currentAge >= lifeTime; }
	
	public boolean isBorn(){ return currentAge == 0;}
}
