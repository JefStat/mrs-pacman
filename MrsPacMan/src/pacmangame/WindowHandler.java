package pacmangame;
/**
 * This class is the WindowHandler
 * This class controls the events that occur with the window while the GUI is working.
 * 
 * Title: MapGUI Class version 0.1
 * @Date: March 4th, 2009
 * @Author: Nahim Nasser
 */

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class WindowHandler implements WindowListener {
	/**
	 * variable to create the gui
	 */
	private MapGUI frame;
	/**
	 * keep track of the start of the window
	 * @param f the MapGUI
	 */
	public WindowHandler(MapGUI f) {
		frame = f;
		frame.addWindowListener(this); //register the listener
	}	
	/**
	 * closes the window when the user is through with it
	 */
	public void windowClosing(WindowEvent arg0) {
		frame.dispose();
		System.exit(0);
	}
	/**
	 * acknowledges when the window is opened
	 */
	public void windowOpened(WindowEvent arg0) {
	}
	/**
	 * acknowledges when the window is closed
	 */
	public void windowClosed(WindowEvent arg0) {}
	/**
	 * acknowledges when the window is activated
	 */
	@Override
	public void windowActivated(WindowEvent e) {}
	/**
	 * acknowledges when the window is deactivated
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {}
	/**
	 * acknowledges when the window is deiconified
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {}
	/**
	 * acknowledges when the window is iconified
	 */
	@Override
	public void windowIconified(WindowEvent e) {}
}