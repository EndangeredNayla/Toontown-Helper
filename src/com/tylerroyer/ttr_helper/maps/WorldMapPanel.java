package com.tylerroyer.ttr_helper.maps;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTabbedPane;

import com.tylerroyer.ttr_helper.globals.HelperFunctions;

public class WorldMapPanel extends MapPanel {
	public WorldMapPanel(JTabbedPane holder) {
		super("World Map", holder);
	}

	protected void initPanelLinks() {
		BufferedImage missingAsset = null;
		try {
			missingAsset = ImageIO.read(this.getClass().getResourceAsStream("/resources/graphical/MissingAsset.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Shape loopyLaneShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 482, 482, 454, 450, 438, 446 },
				new int[] { 295, 307, 305, 316, 315, 295 });
		Shape punchlinePlaceShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 568, 582, 582, 543, 527, 538, 547, 568 },
				new int[] { 397, 397, 422, 438, 418, 414, 424, 418 });
		Shape sillyStreetShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 302, 245, 266, 210, 172, 203, 182, 162, 176, 148, 202, 299, 272, 294 },
				new int[] { 442, 438, 422, 418, 450, 449, 468, 468, 456, 455, 409, 411, 430, 431 });
		Shape BarnacleBoulevardShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 568, 568, 600, 600, 583, 583 },
				new int[] { 397, 367, 367, 378, 378, 397 });

		panelLinks = new PanelLink[] {
				new PanelLink(loopyLaneShape, missingAsset, 1), 
				new PanelLink(punchlinePlaceShape, missingAsset, 2),
				new PanelLink(sillyStreetShape, missingAsset, 3),
				new PanelLink(BarnacleBoulevardShape, missingAsset, 4)};
	}
}
