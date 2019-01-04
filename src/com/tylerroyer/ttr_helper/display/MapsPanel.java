package com.tylerroyer.ttr_helper.display;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JTabbedPane;

import com.tylerroyer.ttr_helper.globals.GlobalFonts;
import com.tylerroyer.ttr_helper.maps.AltoAvenueMapPanel;
import com.tylerroyer.ttr_helper.maps.BaritoneBoulevardMapPanel;
import com.tylerroyer.ttr_helper.maps.BarnacleBoulevardMapPanel;
import com.tylerroyer.ttr_helper.maps.ElmStreetMapPanel;
import com.tylerroyer.ttr_helper.maps.LighthouseLaneMapPanel;
import com.tylerroyer.ttr_helper.maps.LoopyLaneMapPanel;
import com.tylerroyer.ttr_helper.maps.LullabyLaneMapPanel;
import com.tylerroyer.ttr_helper.maps.MapPanel;
import com.tylerroyer.ttr_helper.maps.MapleStreetMapPanel;
import com.tylerroyer.ttr_helper.maps.OakStreetMapPanel;
import com.tylerroyer.ttr_helper.maps.PajamaPlaceMapPanel;
import com.tylerroyer.ttr_helper.maps.PolarPlaceMapPanel;
import com.tylerroyer.ttr_helper.maps.PunchlinePlaceMapPanel;
import com.tylerroyer.ttr_helper.maps.SeaweedStreetMapPanel;
import com.tylerroyer.ttr_helper.maps.SillyStreetMapPanel;
import com.tylerroyer.ttr_helper.maps.SleetStreetMapPanel;
import com.tylerroyer.ttr_helper.maps.TenorTerraceMapPanel;
import com.tylerroyer.ttr_helper.maps.WalrusWayMapPanel;
import com.tylerroyer.ttr_helper.maps.WorldMapPanel;

public class MapsPanel extends JTabbedPane {
	private Map<String, MapPanel> mapPanels = new LinkedHashMap<>();

	public MapsPanel() {
		// Put all maps into hash map
		mapPanels.put("World Map", new WorldMapPanel(this));
		mapPanels.put("LoopyLane", new LoopyLaneMapPanel(this));
		mapPanels.put("Punchline Place", new PunchlinePlaceMapPanel(this));
		mapPanels.put("Silly Street", new SillyStreetMapPanel(this));
		mapPanels.put("Barnacle Boulevard", new BarnacleBoulevardMapPanel(this));
		mapPanels.put("Lighthouse Lane", new LighthouseLaneMapPanel(this));
		mapPanels.put("Seaweed Street", new SeaweedStreetMapPanel(this));
		mapPanels.put("Elm Street", new ElmStreetMapPanel(this));
		mapPanels.put("Maple Street", new MapleStreetMapPanel(this));
		mapPanels.put("Oak Street", new OakStreetMapPanel(this));
		mapPanels.put("Alto Avenue", new AltoAvenueMapPanel(this));
		mapPanels.put("Baritone Boulevard", new BaritoneBoulevardMapPanel(this));
		mapPanels.put("Tenor Terrace", new TenorTerraceMapPanel(this));
		mapPanels.put("Polar Place", new PolarPlaceMapPanel(this));
		mapPanels.put("Sleet Street", new SleetStreetMapPanel(this));
		mapPanels.put("Walrus Way", new WalrusWayMapPanel(this));
		mapPanels.put("Lullaby Lane", new LullabyLaneMapPanel(this));
		mapPanels.put("Pajama Place", new PajamaPlaceMapPanel(this));

		// Pane properties
		this.setTabPlacement(JTabbedPane.LEFT);
		this.setFont(GlobalFonts.minnieFont.deriveFont(18f));
		
		// Add tabs to pane
		for(Entry<String, MapPanel> entry : mapPanels.entrySet()) {
			this.addTab(entry.getKey(), entry.getValue());
		}
	}

	public void doUpdate(boolean isSelected) {
		if (isSelected) {
			// Repaint all maps
			for(MapPanel panel : mapPanels.values()) {
				panel.repaint();
			}
		}
	}
}
