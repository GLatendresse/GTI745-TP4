import java.awt.Button;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class ModeMenu {
	
	public static final int PLAYMODE = 0;
	public static final int DRAGMODE = 1;
	public static final int ADDMODE = 2;
	public static final int DELETEMODE = 3;
	
	int centerX;
	int centerY;
	int width;
	int height;
	int currentMode;
	
	
	public ModeMenu(int centerX, int centerY, int width, int height)
	{
		this.centerY = centerY;
		this.centerX = centerX;
		this.width = width;
		this.height = height;
		currentMode = PLAYMODE;
		
	}
	
	public void reshape(GraphicsWrapper gw){
		
		centerX = (int) (gw.getWidth() * 0.5 - width/2.f);
		centerY = (int)(gw.getHeight() * 0.80);
		
	}
	
	public void drawPlayMode(GraphicsWrapper gw){
		
		gw.setColor(Color.white);
		gw.drawRect(centerX, centerY, width/2.f, height, false);
		
		if(currentMode == PLAYMODE)
			gw.setColor(Color.green);
		else
			gw.setColor(Color.red);
			
		gw.drawRect(centerX, centerY, width/2.f, height, true);
		gw.setColor(Color.black);
		gw.drawString(centerX + (1.f/8.f)*(width/2.f), centerY + height/2.f, "Play Mode");
		
	}
	
	public void drawDragMode(GraphicsWrapper gw){
		
		gw.setColor(Color.white);
		gw.drawRect(centerX + width/2.f, centerY, width/2.f, height, false);
		
		if(currentMode == DRAGMODE)
			gw.setColor(Color.green);
		else
			gw.setColor(Color.red);
			
		gw.drawRect(centerX + width/2.f, centerY, width/2.f, height, true);
		gw.setColor(Color.black);
		gw.drawString(centerX + width/2.f + (1.f/8.f)*(width/2.f), centerY + height/2.f, "Drag Mode");
		
	}
	
	public void drawAddMode(GraphicsWrapper gw){
		
		gw.setColor(Color.white);
		gw.drawRect(centerX + 2*(width/2.f), centerY, width/2.f, height, false);
		
		if(currentMode == ADDMODE)
			gw.setColor(Color.green);
		else
			gw.setColor(Color.red);
			
		gw.drawRect(centerX + 2*(width/2.f), centerY, width/2.f, height, true);
		gw.setColor(Color.black);
		gw.drawString(centerX + 2*(width/2.f) + (1.f/8.f)*(width/2.f), centerY + height/2.f, "Add");
		
	}
	
	
	public void drawDeleteMode(GraphicsWrapper gw){
		
		gw.setColor(Color.white);
		gw.drawRect(centerX + 3*(width/2.f), centerY, width/2.f, height, false);
		
		if(currentMode == DELETEMODE)
			gw.setColor(Color.green);
		else
			gw.setColor(Color.red);
			
		gw.drawRect(centerX + 3*(width/2.f), centerY, width/2.f, height, true);
		gw.setColor(Color.black);
		gw.drawString(centerX + 3*(width/2.f) + (1.f/8.f)*(width/2.f), centerY + height/2.f, "Delete");
		
	}
	
	public void draw(GraphicsWrapper gw){
		
		drawPlayMode(gw);
		drawDragMode(gw);
		//drawAddMode(gw);
		//drawDeleteMode(gw);
	}
	
	public void setCurrentModeWhenClicked(int mouseX){
		
		if(mouseX < (centerX+width/2.f))
			currentMode = PLAYMODE;
		else
			currentMode = DRAGMODE;
		
	}

	/**
	 * @return the centerX
	 */
	public int getCenterX() {
		return centerX;
	}

	/**
	 * @param centerX the centerX to set
	 */
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	/**
	 * @return the centerY
	 */
	public int getCenterY() {
		return centerY;
	}

	/**
	 * @param centerY the centerY to set
	 */
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the currentMode
	 */
	public int getCurrentMode() {
		return currentMode;
	}

	/**
	 * @param currentMode the currentMode to set
	 */
	public void setCurrentMode(int currentMode) {
		this.currentMode = currentMode;
	}
}
