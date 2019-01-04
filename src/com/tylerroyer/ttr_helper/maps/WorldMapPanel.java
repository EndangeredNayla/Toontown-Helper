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
		BufferedImage missingAsset = null, altoAvenueHoverImage = null,
				baritoneBoulevardHoverImage = null, barnacleBoulevardHoverImage = null,
				elmStreetHoverImage = null, lighthouseLaneHoverImage = null,
				loopyLaneHoverImage = null, lullabyLaneHoverImage = null,
				mapleStreetHoverImage = null, oakStreetHoverImage = null,
				pajamaPlaceHoverImage = null, polarPlaceHoverImage = null,
				punchlinePlaceHoverImage = null, seaweedStreetHoverImage = null,
				sillyStreetHoverImage = null, sleetStreetHoverImage = null,
				tenorTerraceHoverImage = null, walrusWayHoverImage = null;
		try {
			missingAsset = ImageIO.read(
					this.getClass().getResourceAsStream("/resources/graphical/MissingAsset.png"));
			altoAvenueHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Alto Avenue.jpg"));
			baritoneBoulevardHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Baritone Boulevard.jpg"));
			barnacleBoulevardHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Barnacle Boulevard.png"));
			elmStreetHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Elm Street.jpg"));
			lighthouseLaneHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Lighthouse Lane.jpg"));
			loopyLaneHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Loopy Lane.png"));
			lullabyLaneHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Lullaby Lane.jpg"));
			mapleStreetHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Maple Street.jpg"));
			oakStreetHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Oak Street.jpg"));
			pajamaPlaceHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Pajama Place.jpg"));
			polarPlaceHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Polar Place.jpg"));
			punchlinePlaceHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Punchline Place.png"));
			seaweedStreetHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Seaweed Street.jpg"));
			sillyStreetHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Silly Street.png"));
			sleetStreetHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Sleet Street.jpg"));
			tenorTerraceHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Tenor Terrace.jpg"));
			walrusWayHoverImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Hover Image - Walrus Way.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Shape loopyLaneShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 482, 482, 454, 450, 438, 446 },
				new int[] { 295, 307, 307, 316, 315, 295 });
		Shape punchlinePlaceShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 568, 582, 582, 543, 527, 538, 547, 568 },
				new int[] { 397, 397, 422, 438, 418, 414, 424, 418 });
		Shape sillyStreetShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 302, 245, 266, 210, 172, 203, 182, 162, 176, 148, 202, 299, 272, 294 },
				new int[] { 442, 438, 422, 418, 450, 449, 468, 468, 456, 455, 409, 411, 430, 431 });
		Shape barnacleBoulevardShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 568, 568, 600, 600, 583, 583 },
				new int[] { 397, 367, 367, 378, 378, 397 });
		Shape lighthouseLaneShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 660, 635, 636, 641, 674, 677, 689, 682, 656, 670 },
				new int[] { 330, 305, 301, 299, 299, 290, 290, 309, 309, 324 });
		// I'm splitting Seaweed Street into two sections because it lies behind the
		// Bossbot HQ.
		Shape seaweedStreetShape1 = HelperFunctions.createPolygonFromPoints(
				new int[] { 735, 722, 728, 753 }, new int[] { 433, 459, 473, 433 });
		Shape seaweedStreetShape2 = HelperFunctions.createPolygonFromPoints(
				new int[] { 706, 668, 668, 704 }, new int[] { 481, 482, 492, 490 });
		Shape elmStreetShape = HelperFunctions.createPolygonFromPoints(
				new int[] { 148, 116, 189, 193, 140, 164 },
				new int[] { 479, 509, 520, 511, 503, 480 });
		// Maple st is weird in that it seems to go right through Chip and Dale's area.
		// To account for this, I'm splitting it into two parts so there's not a link
		// going through Chip and Dale's area.
		Shape mapleStreetShape1 = HelperFunctions.createPolygonFromPoints(
				new int[] { 642, 626, 623, 648, 630, 630, 665, 667, 636, 650 },
				new int[] { 485, 486, 493, 512, 512, 522, 522, 510, 493, 493 });
		Shape mapleStreetShape2 = HelperFunctions.createPolygonFromPoints(
				new int[] { 346, 338, 397, 397 }, new int[] { 543, 555, 546, 534 });
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
				new int[] { 271, 237, 252, 224, 214, 200, 220, 276, 261, 278 },
				new int[] { 128, 124, 109, 105, 112, 110, 93, 101, 117, 119 });

		// TODO Ideally, the tab indices wouldn't be hard-coded. But for now, it should
		// be fine unless TTR adds more streets.
		panelLinks = new PanelLink[] { new PanelLink(loopyLaneShape, loopyLaneHoverImage, 1),
				new PanelLink(punchlinePlaceShape, punchlinePlaceHoverImage, 2),
				new PanelLink(sillyStreetShape, sillyStreetHoverImage, 3),
				new PanelLink(barnacleBoulevardShape, barnacleBoulevardHoverImage, 4),
				new PanelLink(lighthouseLaneShape, lighthouseLaneHoverImage, 5),
				new PanelLink(
						new Shape[] { seaweedStreetShape1, seaweedStreetShape2 }, seaweedStreetHoverImage, 6),
				new PanelLink(elmStreetShape, elmStreetHoverImage, 7),
				new PanelLink(new Shape[] { mapleStreetShape1, mapleStreetShape2 }, mapleStreetHoverImage,
						8),
				new PanelLink(oakStreetShape, oakStreetHoverImage, 9),
				new PanelLink(altoAvenueShape, altoAvenueHoverImage, 10),
				new PanelLink(baritoneBoulevardShape, baritoneBoulevardHoverImage, 11),
				new PanelLink(tenorTerraceShape, tenorTerraceHoverImage, 12),
				new PanelLink(polarPlaceShape, polarPlaceHoverImage, 13),
				new PanelLink(sleetStreetShape, sleetStreetHoverImage, 14),
				new PanelLink(walrusWayShape, walrusWayHoverImage, 15),
				new PanelLink(lullabyLaneShape, lullabyLaneHoverImage, 16),
				new PanelLink(pajamaPlaceShape, pajamaPlaceHoverImage, 17) };
	}
}
