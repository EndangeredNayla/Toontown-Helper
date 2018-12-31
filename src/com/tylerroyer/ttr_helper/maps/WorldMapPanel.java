package com.tylerroyer.ttr_helper.maps;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTabbedPane;

public class WorldMapPanel extends MapPanel {
	public WorldMapPanel(JTabbedPane holder) {
		super("World Map", holder);
	}

	protected void initPanelLinks() {
		BufferedImage testImage = null;
		try {
			testImage = ImageIO.read(this.getClass().getResourceAsStream("/resources/graphical/Cog - Flunky.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PanelLink testLink = new PanelLink(new Rectangle(0, 0, 100, 100), testImage, 1);
		panelLinks = new PanelLink[] {testLink};
	}
}
