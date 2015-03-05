import java.awt.BorderLayout;
import java.awt.Container;

//import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Schedule the creation of the UI for the event-dispatching thread.
		javax.swing.SwingUtilities.invokeLater(
			new Runnable() {
				public void run() {
					createUI();
				}
			}
		);
	}
	
	private static void createUI() {
		if ( ! SwingUtilities.isEventDispatchThread() ) {
			System.out.println(
				"Warning: UI is not being created in the Event Dispatch Thread!");
			assert false;
		}

		/*GLCapabilities caps = new GLCapabilities();
		caps.setDoubleBuffered(true);
		caps.setHardwareAccelerated(true); */
		//MultitouchFramework mf = new MultitouchFramework( caps );

		JFrame frame = new JFrame(  );
		frame.setTitle( "TP04");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setLocationRelativeTo(null);
		
		/*
		if ( Constant.HAS_MENUBAR ) {
			JMenuBar menuBar = mf.client.createMenuBar();
			if ( menuBar != null )
				frame.setJMenuBar(menuBar);
		}*/


		frame.setVisible(true);

		//Container pane = frame.getContentPane();

		//pane.setLayout( new BorderLayout() );
		/*
		if ( Constant.HAS_PANEL_OF_WIDGETS ) {
			JPanel panelOfWidgets = mf.client.createPanelOfWidgets();
			if ( panelOfWidgets != null )
				pane.add( panelOfWidgets, BorderLayout.LINE_START );
		}
		pane.add( mf, BorderLayout.CENTER ); */

		//mf.start();
	}

}
