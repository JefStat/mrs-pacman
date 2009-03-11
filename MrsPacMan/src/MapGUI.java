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
	private Map MapLevel;
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

		JTable Table = new JTable(MapLevel.MAX,MapLevel.MAX); //JTABLE IMPLEMENTED -- 
		Table.setForeground(Color.BLACK);
		Table.setBackground(Color.BLACK);
		//Table.getCellEditor(0, 0);
		TF = new JTextArea();         
		TF.setBackground(Color.white);
		TF.setVisible(true);
		TF.setEditable(false);
		setContentPane(Table);
		
		}
	public void changeText(String input){
		TF.setText(input);
	}
		public MapGUI() { this(""); }
		
	public void setMap(Map x){
		this.MapLevel = x;
	}
}

