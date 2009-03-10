/**
 * This class is the WindowHandler
 * 
 * Title: MapGUI Class version 0.1
 * @Date: March 4th, 2009
 * @Author: Nahim Nasser
 */

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class WindowHandler implements WindowListener {
private MapGUI frame;
public WindowHandler(MapGUI f) {
frame = f;
frame.addWindowListener(this); //register the listener
}
	public void windowClosing(WindowEvent arg0) {
		frame.dispose();
		System.exit(0);
}
public void windowOpened(WindowEvent arg0) {
}
public void windowClosed(WindowEvent arg0) {}
@Override
public void windowActivated(WindowEvent e) {}
@Override
public void windowDeactivated(WindowEvent e) {}
@Override
public void windowDeiconified(WindowEvent e) {}
@Override
public void windowIconified(WindowEvent e) {}
}