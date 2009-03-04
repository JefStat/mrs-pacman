/*
 * This class is the graphical user-interface of the map
 * 
 * Title: MapGUI Class version 0.1
 * Date: March 4th, 2009
 * Author: Nahim Nasser
 */

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MapGUI extends JFrame {
	private JTextArea TF;
	public MapGUI(String label) {
		super(label);
		new WindowHandler(this); //create the listener
		
		JMenuBar MB = new JMenuBar();
		setJMenuBar(MB);
		JMenu importMenu = new JMenu( "Import" );
	    MB.add( importMenu );
	    JMenuItem importMap = new JMenuItem("Map");
	    importMenu.add(importMap);
	    
	    JMenu saveMenu = new JMenu( "Export" );
	    JMenuItem exportMap = new JMenuItem("Export/Save Map");
	    saveMenu.add(exportMap);
	    MB.add( saveMenu );

		TF = new JTextArea();         
		TF.setBackground(Color.white);
		TF.setVisible(true);
		TF.setEditable(false);
		setContentPane(TF);
		}
	public void changeText(String input){
		TF.setText(input);
	}
		public MapGUI() { this(""); }
}
