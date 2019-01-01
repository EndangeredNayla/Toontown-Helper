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
			missingAsset = ImageIO.read(
					this.getClass().getResourceAsStream("/resources/graphical/MissingAsset.png"));
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
		Shape lighthouseLaneShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 660, 635, 636, 641, 674, 677, 689, 682, 656, 670 },
				new int[] { 330, 305, 301, 299, 299, 290, 290, 309, 309, 324 });
		Shape seaweedStreetShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 735, 711, 668, 668, 720, 753 },
				new int[] { 433, 482, 482, 492, 492, 433 });
		Shape elmStreetShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 148, 116, 189, 193, 140, 164 },
				new int[] { 479, 509, 520, 511, 503, 480 });
		// Maple st is weird in that it seems to go right through Chip and Dale's area.
		// To account for this, I'm splitting it into two parts so there's not a link
		// going through Chip and Dale's area.
		// TODO Somehow I'd like both to light up whenever one of them is being hovered
		// over.
		Shape mapleStreetShape1 = HelperFunctions.createPolygonFromPoints(
				new int[] { 642, 612, 648, 630, 630, 680, 636, 650 },
				new int[] { 485, 485, 512, 512, 522, 522, 493, 493 });
		Shape mapleStreetShape2 = HelperFunctions.createPolygonFromPoints(
				new int[] { 346, 336, 394, 394 }, new int[] { 540, 549, 541, 532 });
		Shape oakStreetShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 234, 218, 203, 188, 221, 245 },
				new int[] { 582, 595, 591, 596, 604, 585 });
		Shape altoAvenueShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 482, 511, 494, 504, 532, 482 },
				new int[] { 295, 295, 273, 272, 307, 307 });
		Shape baritoneBoulevardShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 540, 548, 515, 533, 543, 534, 571, 540 },
				new int[] { 227, 227, 183, 183, 191, 191, 234, 234 });
		Shape tenorTerraceShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 376, 361, 329, 296, 370, 320, 354, 342, 294, 348, 273, 333, 364, 376 },
				new int[] { 230, 230, 257, 257, 194, 189, 167, 165, 196, 201, 266, 267, 239, 239 });
		Shape polarPlaceShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 755, 777, 760, 748, 758, 750 },
				new int[] { 172, 167, 155, 157, 163, 165 });
		Shape sleetStreetShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 597, 555, 557, 597 }, new int[] { 183, 183, 191, 191 });
		Shape walrusWayShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 682, 682, 636, 655, 668, 652, 695, 695 },
				new int[] { 272, 266, 266, 236, 236, 257, 261, 272 });
		Shape lullabyLaneShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 366, 381, 458, 495, 444, 436, 472, 451, 378, 356 },
				new int[] { 160, 149, 149, 113, 113, 121, 121, 141, 141, 156 });
		Shape pajamaPlaceShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 271, 235, 252, 224, 214, 200, 220, 276, 260, 278 },
				new int[] { 128, 126, 109, 105, 113, 108, 93, 101, 117, 119 });

		// TODO Ideally, the tab indices wouldn't be hard-coded. But for now, it should
		// be fine unless TTR adds more streets.
		panelLinks = new PanelLink[] { new PanelLink(loopyLaneShape, missingAsset, 1),
				new PanelLink(punchlinePlaceShape, missingAsset, 2),
				new PanelLink(sillyStreetShape, missingAsset, 3),
				new PanelLink(BarnacleBoulevardShape, missingAsset, 4),
				new PanelLink(lighthouseLaneShape, missingAsset, 5),
				new PanelLink(seaweedStreetShape, missingAsset, 6),
				new PanelLink(elmStreetShape, missingAsset, 7),
				new PanelLink(mapleStreetShape1, missingAsset, 8),
				new PanelLink(mapleStreetShape2, missingAsset, 8),
				new PanelLink(oakStreetShape, missingAsset, 9),
				new PanelLink(altoAvenueShape, missingAsset, 10),
				new PanelLink(baritoneBoulevardShape, missingAsset, 11),
				new PanelLink(tenorTerraceShape, missingAsset, 12),
				new PanelLink(polarPlaceShape, missingAsset, 13),
				new PanelLink(sleetStreetShape, missingAsset, 14),
				new PanelLink(walrusWayShape, missingAsset, 15),
				new PanelLink(lullabyLaneShape, missingAsset, 16),
				new PanelLink(pajamaPlaceShape, missingAsset, 17) };
	}
}
