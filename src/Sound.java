import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

import java.util.Vector;

public class Sound {

	private final int CHANNEL = 9;
	private final int VOLUME = 80;
	private MidiChannel percussionChannel;
	
	public Sound(){
		try{
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		percussionChannel = synth.getChannels()[CHANNEL];
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void playSound(int note){
		percussionChannel.noteOn( note, VOLUME );
	}
	
	public void bassDrum(boolean alt){
		if (alt)
			playSound(35);
		else
			playSound(36);
	}
	
	public void snareDrum(boolean alt){
		if (alt)
			playSound(40);
		else
			playSound(38);
	}
	
	public void lowTom(boolean alt){
		if (alt)
			playSound(41);
		else
			playSound(43);
	}
	
	public void midTom(boolean alt){
		if (alt)
			playSound(47);
		else
			playSound(45);
	}
	
	public void highTom(boolean alt){
		if (alt)
			playSound(48);
		else
			playSound(50);
	}
	
	public void hiHatCymbal(boolean open){
		if (open)
			//playSound(46);
			playSound(56);
		else
			playSound(42);
	}
	
	public void hiHatPedal(){
		playSound(56);
	}
	
	public void rideCymbal(boolean alt){
		if (alt)
			playSound(46);
		else
			playSound(59);
	}
	
	public void crashCymbal(boolean alt){
		if (alt)
			playSound(57);
		else
			playSound(49);
	}
	
	public void cowBell(){
		playSound(56);
	}
	
	
	public static void main( String[] args ) {
		int duration = 200; // en millisecondes
		boolean alt = false;
		Sound s = new Sound();
		
		try {
			for(int i = 0 ; i < 4 ; i++){
			s.cowBell();
			Thread.sleep( duration*2 );
			}
			for(int i = 4 ; i > 0 ; --i){
				s.hiHatCymbal(false);		//1
				s.bassDrum(false);
				Thread.sleep( duration );
				s.hiHatCymbal(false);		//2
				Thread.sleep( duration );
				s.hiHatCymbal(false);		//3
				s.snareDrum(false);
				Thread.sleep( duration );
				s.hiHatCymbal(false);		//4
				Thread.sleep( duration );
				s.hiHatCymbal(false);		//1
				s.bassDrum(false);
				Thread.sleep( duration/2 );
				s.bassDrum(false);
				Thread.sleep( duration/2 );
				s.hiHatCymbal(false);		//2
				Thread.sleep( duration );
				s.hiHatCymbal(false);		//3
				s.snareDrum(false);
				Thread.sleep( duration );
				s.hiHatCymbal(false);		//3
				Thread.sleep( duration );
			}
			s.snareDrum(false);		//3
			Thread.sleep( duration/2 );
			s.snareDrum(false);	//3
			Thread.sleep( duration/2 );
			s.snareDrum(false);		//3
			Thread.sleep( duration/2 );
			s.snareDrum(false);		//3
			Thread.sleep( duration/2 );
			s.crashCymbal(true);
			Thread.sleep( duration*4 );
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//percussionChannel.noteOff( 38 );
		
	}
}
