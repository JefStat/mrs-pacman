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
import java.io.File;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@SuppressWarnings({ "serial", "unused" })
public class MapGUI extends JFrame implements ActionListener, TableModelListener {
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
	private final URL EDITORJPG = this.getClass().getResource("editor.jpg");
	
	private Map MapLevel;
	private JInternalFrame Internal;
	private JTextField input;
	private JTable Table;
	private int RefreshOverload;
	private boolean skip = false;
	private JLabel Lives;
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
		JMenuItem createMap = new JMenuItem("Open Map Editor");
		createMap.setActionCommand("Create");
		createMap.addActionListener(this);
		editorMenu.add(createMap);
		MB.add(editorMenu);
		
		setVisible(true);
		setLayout(new BorderLayout());
		this.add(new JLabel(new ImageIcon(LOGOJPG)), BorderLayout.NORTH);
		Lives = new JLabel("Number Of Lives Left:");
		this.add(Lives,BorderLayout.SOUTH);
		input = new JTextField("NULL");
		new MapObserver(this, pmg);
	}

	public void setMap(Map x) {
		this.MapLevel = x;
	}
	/**
	 * Creates a simple image popup with the specified icon and title
	 * @param icon
	 * @param title
	 */
	private void CreateImagePopup(ImageIcon icon, String title){
		JFrame popup = new JFrame(title);
		popup.setLayout(new BorderLayout());
		popup.add(new JLabel(icon), BorderLayout.CENTER);
		popup.pack();
		popup.setVisible(true);
	}
	/**
	 * Creates a text box popup with an ok button
	 * @param label -- title of the frame
	 * @param actioncommand -- actioncommand string
	 */
	private void CreateButtonPopup(String label, String actioncommand){
		JFrame popup = new JFrame(label);
		JButton ok = new JButton("OK");
		ok.setActionCommand(actioncommand);
		ok.addActionListener(this);
		input = new JTextField();
		input.setText("enter filename here");
		input.setVisible(true);
		popup.setLayout(new FlowLayout());
		popup.add(input);
		popup.add(ok);
		popup.setResizable(false);
		popup.setVisible(true);
		popup.pack();
	}
	@Override
	/*
	 * This is the code for the import map/export map button/menu
	 */
	public void actionPerformed(ActionEvent arg0) {
		if ("Create".equals(arg0.getActionCommand())) { // new
			openEditor(MapLevel.getSize());
		}
		if ("Rules".equals(arg0.getActionCommand())) { // new
			CreateImagePopup(new ImageIcon(RULESJPG),"Rules");
		}
		if ("Credits".equals(arg0.getActionCommand())) { // new
			CreateImagePopup(new ImageIcon(SPLASHJPG),"Credits");
		}
		if ("import".equals(arg0.getActionCommand())) { // new
			CreateButtonPopup("Import Map", "importok");
		}
		//EXPORT MENU BUTTON CODE
		if ("export".equals(arg0.getActionCommand())) { // new
			CreateButtonPopup("Export Map", "exportok");
		}
		//LISTENER WHEN OK IS PRESSED ON EXPORT POPUP
		if ("exportok".equals(arg0.getActionCommand())) {
			try {
				MapLevel.exportXML(input.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//LISTENER WHEN OK IS PRESSED ON IMPORT POPUP
		if ("importok".equals(arg0.getActionCommand())) {
			try {
				importXML(input.getText()); //FLAW IN IMPORTMAP IN THE MAPCLASS NOTED. MUST BE EXPLORED 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * Imports the xml file created from the toXML with exportXML needs to run in the gui.
	 * @param file
	 */
	public void importXML(String filename){
		File file = new java.io.File(filename+ ".xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			PacManDefaultHandler parser = new PacManDefaultHandler();
			saxParser.parse(file, parser);
			MapLevel = parser.getMap();
			updateGUI(MapLevel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void tableChanged(TableModelEvent arg0) {
		RefreshOverload++;
		if (RefreshOverload >= MapLevel.getSize()*MapLevel.getSize() && skip == false){
		int column = arg0.getColumn();
		int row = arg0.getLastRow();
		String input = (String)Table.getModel().getValueAt(row, column);
		Integer iden = new Integer(input);
		int identity = iden.intValue();
		if (identity >= 10){identity = identity%10; skip = true; Table.setValueAt(""+identity, row, column);}
		if (identity >= 0 && identity <6){
		MapLevel.changeIdentity(column,row,identity);
		MapLevel.refreshPacdots();
		updateGUI(MapLevel);}
		else {System.out.println("INPUT TOO LARGE ERROR");}
		skip = false;
		}
	}
	public void changeLives(int lives){
		Lives.setText("Number Of Lives Left:" + lives);
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
		Internal.dispose();
		MapLevel = m; 
		buildGUI();
		System.out.println(MapLevel.getPacdots());
	}
	/**
	 *  This function opens up an editor of the last state of the game.
	 * @param size passed for the size of the array
	 */
	public void openEditor(int size){
		RefreshOverload = 0;
		JFrame Editor = new JFrame("Editor");
		Table = new JTable(size,size);
		Editor.setLayout(new BorderLayout());
		Editor.add(Table, BorderLayout.CENTER);
		JLabel Instructions = new JLabel(new ImageIcon(EDITORJPG));
		Editor.add(Instructions, BorderLayout.SOUTH);
		Editor.pack();
		Editor.setVisible(true);
		Table.setBackground(Color.BLACK);
		Table.setForeground(Color.WHITE);
		Table.getModel().addTableModelListener(this);
		for(int i = 0; i < size; i++){
			   for(int j = 0; j < size; j++){
				  Table.setValueAt(""+ MapLevel.getIdentity(i, j), j, i);
			     }
			   }
		Editor.setSize(500, 675);
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
