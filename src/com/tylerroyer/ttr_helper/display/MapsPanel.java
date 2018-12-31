package com.tylerroyer.ttr_helper.display;

import javax.swing.JTabbedPane;

import com.tylerroyer.ttr_helper.globals.GlobalFonts;
import com.tylerroyer.ttr_helper.maps.MapPanel;
import com.tylerroyer.ttr_helper.maps.WorldMapPanel;

public class MapsPanel extends JTabbedPane {
	MapPanel worldMapPanel;

	public MapsPanel() {
		worldMapPanel = new WorldMapPanel(this);

		this.setTabPlacement(JTabbedPane.LEFT);
		this.setFont(GlobalFonts.mickeyFont.deriveFont(18f));
		this.addTab("World Map", worldMapPanel);
	}

	public void doUpdate(boolean isSelected) {
		if (isSelected) {
			worldMapPanel.repaint();
		}
	}
}
