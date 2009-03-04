/*
 * This class is the graphical user-interface of the map
 * 
 * Title: MapGUI Class version 0.1
 * Date: March 4th, 2009
 * Author: Nahim Nasser
 */

import java.awt.*;
import javax.swing.*;

//CURRENTLY IN PRIMITIVE STATE USING ADDRESSBOOK CODE

@SuppressWarnings("serial")
public class MapGUI extends JFrame {
	public JTextField TF;
	public MapGUI(String label) {
		super(label);
		new WindowHandler(this); //create the listener
		
		JMenuBar MB = new JMenuBar();
		setJMenuBar(MB);
		JMenu createMenu = new JMenu( "Create" );
	    MB.add( createMenu );
	    JMenuItem createAddressBook = new JMenuItem("Address Book");
	    JMenuItem createBuddy = new JMenuItem("Buddy Info");
	    createMenu.add(createAddressBook);
	    createMenu.add(createBuddy);
	    
	    JMenu addMenu = new JMenu( "Add" );
	    MB.add( addMenu );
	    JMenuItem addAddressBook = new JMenuItem("Address Book");
	    JMenuItem addBuddy = new JMenuItem("Buddy Info");
	    addMenu.add(addAddressBook);
	    addMenu.add(addBuddy);
	    
	    JMenu saveMenu = new JMenu( "Save" );
	    JMenuItem saveAll = new JMenuItem("Save All");
	    saveMenu.add(saveAll);
	    MB.add( saveMenu );

		TF = new JTextField(1);         
		TF.setBackground(Color.white);
		TF.setVisible(true);
		TF.setEditable(false);
		setContentPane(TF);
		}
		public MapGUI() { this(""); }
}
