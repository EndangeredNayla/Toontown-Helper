package com.tylerroyer.ttr_helper.display;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JTabbedPane;

import com.tylerroyer.ttr_helper.globals.GlobalFonts;
import com.tylerroyer.ttr_helper.maps.MapPanel;
import com.tylerroyer.ttr_helper.maps.PunchlinePlaceMapPanel;
import com.tylerroyer.ttr_helper.maps.WorldMapPanel;

public class MapsPanel extends JTabbedPane {
	private Map<String, MapPanel> mapPanels = new LinkedHashMap<>();

	public MapsPanel() {
		mapPanels.put("World Map", new WorldMapPanel(this));
		mapPanels.put("Punchline Place", new PunchlinePlaceMapPanel(this));

		this.setTabPlacement(JTabbedPane.LEFT);
		this.setFont(GlobalFonts.mickeyFont.deriveFont(18f));
		for(Entry<String, MapPanel> entry : mapPanels.entrySet()) {
			this.addTab(entry.getKey(), entry.getValue());
		}
	}

	public void doUpdate(boolean isSelected) {
		if (isSelected) {
			for(MapPanel panel : mapPanels.values()) {
				panel.repaint();
			}
		}
	}
}
