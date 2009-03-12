/*
 * This class is the graphical user-interface of the map
 * 
 * Title: MapGUI Class version 0.1
 * Date: March 4th, 2009
 * Author: Nahim Nasser
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MapGUI extends JFrame implements ActionListener {
	private Map MapLevel;
	
	public MapGUI(String label) {
		super(label);
		new WindowHandler(this); //create the listener
		
		this.setLayout(new GridLayout(Map.MAX,Map.MAX));
		JMenuBar MB = new JMenuBar();
		setJMenuBar(MB);
		JMenu importMenu = new JMenu( "Import" );
	    MB.add( importMenu );
	    JMenuItem importMap = new JMenuItem("Map");
	    importMap.addActionListener(this);
	    importMenu.add(importMap);
	    
	    JMenu saveMenu = new JMenu( "Export" );
	    JMenuItem exportMap = new JMenuItem("Export/Save Map");
	    saveMenu.add(exportMap);
	    MB.add( saveMenu );
	    setVisible(true);
		}
		public MapGUI() { this(""); }
		
	public void setMap(Map x){
		this.MapLevel = x;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		arg0.getSource();
		JFrame popup = new JFrame("Import Map");
		JButton ok = new JButton("OK");
		//ok.addActionListener(this);
		JTextField input = new JTextField();
		input.setText("Enter File Name.Txt Here");
		input.setVisible(true);
		popup.setLayout(new FlowLayout());
		popup.add(input);
		popup.add(ok);
		popup.setVisible(true);
		popup.pack();
	}
	public void updateGUI(){
		Coordinate level[][] = MapLevel.getMap();
		for(int i = 0; i < MapLevel.getSize(); i++){
			   for(int j = 0; j < MapLevel.getSize(); j++){
				if (level[j][i].getIdentity() == Coordinate.WALL) {
				      this.add(new JLabel(new ImageIcon("wall.jpg")));}
				if (level[j][i].getIdentity() == Coordinate.EMPTY) {
				      this.add(new JLabel(new ImageIcon("cherry.jpg")));}
				if (level[j][i].getIdentity() == Coordinate.FRUIT) {
				    this.add(new JLabel(new ImageIcon("cherry.jpg")));}
				if (level[j][i].getIdentity() == Coordinate.PRISON) {
				      this.add(new JLabel(new ImageIcon("prison.jpg")));}
				if (level[j][i].getIdentity() == Coordinate.PACDOT) {
				      this.add(new JLabel(new ImageIcon("pacdot.jpg")));}
			      }
			   }
		this.pack();
	}
}

