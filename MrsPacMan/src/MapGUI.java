/**
 * This class is the graphical user-interface of the map
 * 
 * Title: MapGUI Class version 0.1
 * @Date: March 4th, 2009
 * @Author: Nahim Nasser
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.*;

@SuppressWarnings("serial")
public class MapGUI extends JFrame implements ActionListener {

	private Map MapLevel;
	private JInternalFrame Internal;

	/**
	 * This constructor creates the entire GUI including the menu bar.
	 * 
	 * @param label
	 */
	public MapGUI(String label) {
		super(label);
		new WindowHandler(this); // create the listener

		JMenuBar MB = new JMenuBar();
		setJMenuBar(MB);
		JMenu importMenu = new JMenu("Import");
		MB.add(importMenu);
		JMenuItem importMap = new JMenuItem("Map");
		importMap.addActionListener(this);
		importMenu.add(importMap);

		JMenu saveMenu = new JMenu("Export");
		JMenuItem exportMap = new JMenuItem("Export/Save Map");
		saveMenu.add(exportMap);
		MB.add(saveMenu);
		setVisible(true);
	}

	public MapGUI() {
		this("");
	}

	public void setMap(Map x) {
		this.MapLevel = x;
	}

	@Override
	/*
	 * This is the code for the import map/export map button UNCOMPLETE
	 * IMPLEMENTATION - IN PROGRESS
	 */
	public void actionPerformed(ActionEvent arg0) {
		arg0.getSource();
		JFrame popup = new JFrame("Import Map");
		JButton ok = new JButton("OK");
		// ok.addActionListener(this);
		JTextField input = new JTextField();
		input.setText("Enter File Name.Txt Here");
		input.setVisible(true);
		popup.setLayout(new FlowLayout());
		popup.add(input);
		popup.add(ok);
		popup.setVisible(true);
		popup.pack();
	}

	/**
	 * Builds the internal frame of the map containing all the graphics Images
	 * are stored as icons on JLabels
	 */
	public void buildGUI() {
		Internal = new JInternalFrame("Map");
		Internal.setVisible(true);
		Internal.setLayout(new GridLayout(MapLevel.getSize(), MapLevel
				.getSize()));
		for (int i = 0; i < MapLevel.getSize(); i++) {
			for (int j = 0; j < MapLevel.getSize(); j++) {
				if ((MapLevel.getPacMan().getX() == j)
						&& (MapLevel.getPacMan().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon("pacman.jpg")));
				}else if ((MapLevel.getChaser().getX() == j)
						&& (MapLevel.getChaser().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon("green.jpg")));
				}else if ((MapLevel.getFickle().getX() == j)
						&& (MapLevel.getFickle().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon("orange.jpg")));
				}else if ((MapLevel.getAmbusher().getX() == j)
						&& (MapLevel.getAmbusher().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon("orange.jpg")));
				}else if ((MapLevel.getStupid().getX() == j)
						&& (MapLevel.getStupid().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon("orange.jpg")));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.WALL) {
					Internal.add(new JLabel(new ImageIcon("wall.jpg")));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.EMPTY) {
					Internal.add(new JLabel(new ImageIcon("empty.jpg")));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.FRUIT) {
					Internal.add(new JLabel(new ImageIcon("cherry.jpg")));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.PRISON) {
					Internal.add(new JLabel(new ImageIcon("prison.jpg")));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.PACDOT) {
					Internal.add(new JLabel(new ImageIcon("pacdot.jpg")));
				}
			}
		}
		// next few lines attempt to remove any existing label where a character
		// is standing and insert .
		/*
		 * Internal.remove(MapLevel.getSize()(int)MapLevel.getPacMan().getX());
		 * // not sure if this should be y axis instead Internal.add(new
		 * JLabel(new ImageIcon("pacman.jpg"))); 
		 * 
		 * Idea failed array out of bounds error.
		 */

		Internal.validate(); // reloads all the labels.
		Internal.setBackground(Color.BLACK);
		Internal.setResizable(false);
		this.add(Internal);
		this.pack();
	}

	/**
	 * Rebuilds the internal frame of the GUI, essentially updating the GUI with
	 * new information if map has changed.
	 * 
	 * @param p
	 */
	public void updateGUI(PacManGame p) {
		try {
			Internal.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Internal.removeAll();
		MapLevel = p.getMap(1); // I highly recommend that we move the actual
								// passing of pacmangame to MAP, not mapGUI
		// MAP should contain the current position of pacman and all the objects
		// on the map
		// an updateMAP function should be implemented in the MAP class.
		buildGUI();
		System.out.println(MapLevel.getPacdots());
	}
}
