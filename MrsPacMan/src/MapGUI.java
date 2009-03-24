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
	private JTextField input;

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
		importMap.setActionCommand("import");
		importMap.addActionListener(this);
		importMenu.add(importMap);

		JMenu saveMenu = new JMenu("Export");
		JMenuItem exportMap = new JMenuItem("Export/Save Map");
		exportMap.setActionCommand("export");
		exportMap.addActionListener(this);
		saveMenu.add(exportMap);
		MB.add(saveMenu);
		setVisible(true);
		setLayout(new BorderLayout());
		this.add(new JLabel(new ImageIcon("logo.jpg")), BorderLayout.NORTH);
		input = new JTextField("NULL");
	}

	public MapGUI() {
		this("");
	}

	public void setMap(Map x) {
		this.MapLevel = x;
	}

	@Override
	/*
	 * This is the code for the import map/export map button/menu
	 * REPETITIVE CODE NEEDS TO BE REFACTORED
	 */
	public void actionPerformed(ActionEvent arg0) {
		//IMPORT MENU BUTTON CODE
		if ("import".equals(arg0.getActionCommand())) { // new
			JFrame popup = new JFrame("Import Map");
			JButton ok = new JButton("OK");
			ok.setActionCommand("importok");
			ok.addActionListener(this);
			input = new JTextField();
			input.setText("enter filename.txt here");
			input.setVisible(true);
			popup.setLayout(new FlowLayout());
			popup.add(input);
			popup.add(ok);
			popup.setResizable(false);
			popup.setVisible(true);
			popup.pack();
		}
		//EXPORT MENU BUTTON CODE
		if ("export".equals(arg0.getActionCommand())) { // new
			JFrame popup = new JFrame("Export Map");
			JButton ok = new JButton("OK");
			ok.setActionCommand("exportok");
			ok.addActionListener(this);
			input = new JTextField();
			input.setText("enter filename.txt here");
			input.setVisible(true);
			popup.setLayout(new FlowLayout());
			popup.add(input);
			popup.add(ok);
			popup.setResizable(false);
			popup.setVisible(true);
			popup.pack();
		}
		//LISTENER WHEN OK IS PRESSED ON EXPORT POPUP
		if ("exportok".equals(arg0.getActionCommand())) {
			try {
				MapLevel.ExportMap(input.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("EXPORT OF " + input.getText() + " COMPLETED");
		}
		//LISTENER WHEN OK IS PRESSED ON IMPORT POPUP
		if ("importok".equals(arg0.getActionCommand())) {
			System.out.println("IMPORT OK PRESSED");
			try {
				MapLevel.ImportMap(input.getText()); //FLAW IN IMPORTMAP IN THE MAPCLASS NOTED. MUST BE EXPLORED 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("IMPORT OF " + input.getText() + " COMPLETED");
		}
		
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
				} else if ((MapLevel.getChaser().getX() == j)
						&& (MapLevel.getChaser().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon("Blinky.gif")));
				} else if ((MapLevel.getFickle().getX() == j)
						&& (MapLevel.getFickle().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon("Inky.gif")));
				} else if ((MapLevel.getAmbusher().getX() == j)
						&& (MapLevel.getAmbusher().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon("Pinky.gif")));
				} else if ((MapLevel.getStupid().getX() == j)
						&& (MapLevel.getStupid().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon("Clyde.gif")));
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
