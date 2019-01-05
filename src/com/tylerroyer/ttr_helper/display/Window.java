package com.tylerroyer.ttr_helper.display;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.tylerroyer.ttr_helper.driver.Driver;
import com.tylerroyer.ttr_helper.globals.GlobalFonts;
import com.tylerroyer.ttr_helper.globals.GlobalStrings;

public class Window extends JFrame {
	public static final int INITIAL_WIDTH = 1150, INITIAL_HEIGHT = 730;

	private JTabbedPane tabbedPane;

	private MapsPanel mapsPanel;
	private CogsPanel cogsPanel;
	private InvasionsPanel invasionsPanel;
	private TablesPanel tablesPanel;

	public Window() {
		this.setTitle(GlobalStrings.ProgramName + " " + GlobalStrings.ProgramVersion);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mapsPanel = new MapsPanel();
		cogsPanel = new CogsPanel();
		invasionsPanel = new InvasionsPanel();
		tablesPanel = new TablesPanel();

		tabbedPane = new JTabbedPane();
		tabbedPane.setFont(GlobalFonts.mickeyFont.deriveFont(18f));
		tabbedPane.addTab("Maps", mapsPanel);
		tabbedPane.addTab("Cogs", cogsPanel);
		tabbedPane.addTab("Invasions", invasionsPanel);
		tabbedPane.addTab("Tables", tablesPanel);
		this.add(tabbedPane);

		this.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
		this.setVisible(true);

		// Stop execution when window closes.
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Driver.running = false;
			}
		});
	}

	public void update() {
		invasionsPanel.doUpdate(tabbedPane.getSelectedComponent() == invasionsPanel);
		cogsPanel.doUpdate(tabbedPane.getSelectedComponent() == cogsPanel);
		mapsPanel.doUpdate(tabbedPane.getSelectedComponent() == mapsPanel);
		tablesPanel.doUpdate(tabbedPane.getSelectedComponent() == tablesPanel);
	}
}
