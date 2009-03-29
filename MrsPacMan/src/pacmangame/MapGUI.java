package pacmangame;
/**
 * This class is the graphical user-interface of the map
 * 
 * Title: MapGUI Class version 0.5
 * @Date: March 30th, 2009
 * @Author: Nahim Nasser, Jeff Statham
 * 
 * Added private class Map Observer to facilitate the linking of the observers and key event listeners. removed redunant inline comments. Changed the images to be applied as URLs was necessary for the .jar build in the build.xml to run independently
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

@SuppressWarnings("serial")
public class MapGUI extends JFrame implements ActionListener {
	/**
	 * These are the URLs for all the image icons
	 */
	private final URL BLINKYGIF = this.getClass().getResource("Blinky.gif");
	private final URL CHERRYJPG = this.getClass().getResource("cherry.jpg");
	private final URL CLYDEGIF = this.getClass().getResource("Clyde.gif");
	private final URL EMPTYJPG = this.getClass().getResource("empty.jpg");
	private final URL INKYGIF = this.getClass().getResource("Inky.gif");
	private final URL LOGOJPG = this.getClass().getResource("logo.jpg");
	private final URL PACDOTJPG = this.getClass().getResource("pacdot.jpg");
	private final URL PACMANJPG = this.getClass().getResource("pacman.jpg");
	private final URL PINKYGIF = this.getClass().getResource("Pinky.gif");
	private final URL PRISONJPG = this.getClass().getResource("prison.jpg");
	private final URL WALLJPG = this.getClass().getResource("wall.jpg");
	private final URL POWERPELLETJPG = this.getClass().getResource("powerpellet.jpg");
	private final URL SPLASHJPG = this.getClass().getResource("splash.jpg");
	private final URL RULESJPG = this.getClass().getResource("rules.jpg");
	
	private Map MapLevel;
	private JInternalFrame Internal;
	private JTextField input;

	/**
	 * This constructor creates the entire GUI including the menu bar.
	 * 
	 * @param label
	 */
	public MapGUI(String label, PacManGame pmg) {
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
		
		JMenu helpMenu = new JMenu("Help");
		JMenuItem Rules = new JMenuItem("Rules");
		Rules.setActionCommand("Rules");
		Rules.addActionListener(this);
		JMenuItem Credits = new JMenuItem("Credits");
		Credits.setActionCommand("Credits");
		Credits.addActionListener(this);
		helpMenu.add(Rules);
		helpMenu.add(Credits);
		MB.add(helpMenu);
		
		JMenu editorMenu = new JMenu("Editor");
		JMenuItem createMap = new JMenuItem("Create New Map");
		createMap.setActionCommand("Create");
		createMap.addActionListener(this);
		editorMenu.add(createMap);
		MB.add(editorMenu);
		
		setVisible(true);
		setLayout(new BorderLayout());
		this.add(new JLabel(new ImageIcon(LOGOJPG)), BorderLayout.NORTH);
		input = new JTextField("NULL");
		new MapObserver(this, pmg);
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
		if ("Create".equals(arg0.getActionCommand())) { // new
			openEditor(MapLevel.getSize());
		}
		if ("Rules".equals(arg0.getActionCommand())) { // new
			JFrame popup = new JFrame("Rules");
			popup.setLayout(new BorderLayout());
			popup.add(new JLabel(new ImageIcon(RULESJPG)), BorderLayout.CENTER);
			popup.pack();
			popup.setVisible(true);
		}
		if ("Credits".equals(arg0.getActionCommand())) { // new
			JFrame popup = new JFrame("Credits");
			popup.setLayout(new BorderLayout());
			popup.add(new JLabel(new ImageIcon(SPLASHJPG)),BorderLayout.CENTER);
			popup.pack();
			popup.setVisible(true);
		}
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
					Internal.add(new JLabel(new ImageIcon(PACMANJPG)));
				} else if ((MapLevel.getChaser().getX() == j)
						&& (MapLevel.getChaser().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon(BLINKYGIF)));
				} else if ((MapLevel.getFickle().getX() == j)
						&& (MapLevel.getFickle().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon(INKYGIF)));
				} else if ((MapLevel.getAmbusher().getX() == j)
						&& (MapLevel.getAmbusher().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon(PINKYGIF)));
				} else if ((MapLevel.getStupid().getX() == j)
						&& (MapLevel.getStupid().getY() == i)) {
					Internal.add(new JLabel(new ImageIcon(CLYDEGIF)));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.WALL) {
					Internal.add(new JLabel(new ImageIcon(WALLJPG)));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.EMPTY) {
					Internal.add(new JLabel(new ImageIcon(EMPTYJPG)));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.FRUIT) {
					Internal.add(new JLabel(new ImageIcon(CHERRYJPG)));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.POWERPELLET) {
					Internal.add(new JLabel(new ImageIcon(POWERPELLETJPG)));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.PRISON) {
					Internal.add(new JLabel(new ImageIcon(PRISONJPG)));
				} else if (MapLevel.getIdentity(j, i) == Coordinate.PACDOT) {
					Internal.add(new JLabel(new ImageIcon(PACDOTJPG)));
				}
			}
		}

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
	public void updateGUI(Map m) {
		try {
			Internal.setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Internal.removeAll();
		MapLevel = m; 
		buildGUI();
		System.out.println(MapLevel.getPacdots());
	}
	/**
	 * Editor Function, User controls element placement via a JTABLE implementation
	 */
	public void openEditor(int size){
		JFrame Editor = new JFrame("Editor");
		JTable Table = new JTable(size,size);
		Editor.setLayout(new BorderLayout());
		Editor.add(Table, BorderLayout.CENTER);
		Editor.pack();
		Editor.setVisible(true);
	}
	
	private class MapObserver implements Observer {
		
		private MapGUI f;
		
		public MapObserver(MapGUI f, PacManGame pmg){
			this.f = f;
			pmg.addObserver(this);
			this.f.setMap(pmg.getMap());
			this.f.buildGUI();
			f.addKeyListener(pmg);
			f.Internal.addKeyListener(pmg);
			f.input.addKeyListener(pmg);
		}
		
		@Override
		public void update(Observable arg0, Object arg1) {
			if (arg1 instanceof NotifierObject ){
				if (((NotifierObject) arg1).getI() == 1)
				{
					f.dispose();
				}else {
				f.updateGUI(((NotifierObject) arg1).getM());
				}
			}
		}
	}
}
