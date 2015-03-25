import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Chromaesthesia {
	
	private List<Shape> shapes;
	private Sound sound;
	
	public Chromaesthesia(){
		shapes = new ArrayList<Shape>();
		sound = new Sound();
	}
	
	public void addBass(){
		sound.bassDrum(false);
		shapes.add(new Shape_Oval(Color.red, 0.99f, 30, 0, 0, true));
	}
	
	public void addSnare(){
		sound.snareDrum(false);
		shapes.add(new Shape_Circle(Color.green, 0.99f, 30, 0, 0, true));
	}
	
	public void addLowTom(){
		sound.lowTom(false);
		shapes.add(new Shape_Circle(new Color( 255,165,0), 0.99f, 30, 0, 0, true));
	}
	
	public void addMidTom(){
		sound.midTom(false);
		shapes.add(new Shape_Circle(new Color(255,183,50), 0.99f, 30, 0, 0, true));
	}
	
	public void addHighTom(){
		sound.highTom(false);
		shapes.add(new Shape_Circle(new Color(255,201,102), 0.99f, 30, 0, 0, true));
	}
	
	public void addHiHatPedal(float radius){
		sound.hiHatPedal();
		shapes.add(new Shape_Circle(Color.gray, 0.99f, 10, (int)radius, (int)radius, true));
	}
	
	public void addHiHatCymbalClosed(){
		sound.hiHatCymbal(false);
		shapes.add(new Shape_Circle(Color.pink, 0.99f, 20, 0, 0, true));
	}
	
	public void addHiHatCymbalOpen(){
		sound.hiHatCymbal(true);
		shapes.add(new Shape_Circle(Color.magenta, 0.99f, 30, 0, 0, true));
	}
	
	public void addRideCymbal(){
		sound.rideCymbal(false);
		shapes.add(new Shape_Circle(Color.cyan, 0.99f, 40, 0, 0, true));
	}
	
	public void addCrashCymbal(){
		sound.crashCymbal(false);
		Shape_Circle s = new Shape_Circle(Color.yellow, 0.99f, 90, 0, 0, true);
		shapes.add(s);
	}
	
	
	public void addCowbell(){
		sound.cowBell();
		shapes.add(new Shape_Circle(Color.gray, 1.0f, 120, 0, 0, false));
	}
	
	public void draw(GraphicsWrapper gw, int x, int y){
		Iterator<Shape> iterator = shapes.iterator();
		Shape s;
		
		while (iterator.hasNext()) {
		    s = iterator.next();
		    s.draw(gw, x, y);
		    if (s.isDead())
		    	iterator.remove();
		}
	}
}
