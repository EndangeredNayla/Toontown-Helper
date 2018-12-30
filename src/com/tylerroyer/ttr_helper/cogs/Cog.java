package com.tylerroyer.ttr_helper.cogs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tylerroyer.ttr_helper.globals.GlobalFonts;

public class Cog {
	private static Cog flunky = new Cog("Flunky", CogType.BOSSBOT, 1, 5);
	private static Cog pencilPusher = new Cog("Pencil Pusher", CogType.BOSSBOT, 2, 6);
	private static Cog yesman = new Cog("Yesman", CogType.BOSSBOT, 3, 7);
	private static Cog micromanager = new Cog("Micromanager", CogType.BOSSBOT, 4, 8);
	private static Cog downsizer = new Cog("Downsizer", CogType.BOSSBOT, 5, 9);
	private static Cog headHunter = new Cog("Head Hunter", CogType.BOSSBOT, 6, 10);
	private static Cog corporateRaider = new Cog("Corporate Raider", CogType.BOSSBOT, 7, 11);
	private static Cog theBigCheese = new Cog("The Big Cheese", CogType.BOSSBOT, 8, 12);

	private static Cog bottomFeeder = new Cog("Bottom Feeder", CogType.LAWBOT, 1, 5);
	private static Cog bloodsucker = new Cog("Bloodsucker", CogType.LAWBOT, 2, 6);
	private static Cog doubleTalker = new Cog("Double Talker", CogType.LAWBOT, 3, 7);
	private static Cog ambulanceChaser = new Cog("Ambulance Chaser", CogType.LAWBOT, 4, 8);
	private static Cog backStabber = new Cog("Back Stabber", CogType.LAWBOT, 5, 9);
	private static Cog spinDoctor = new Cog("Spin Doctor", CogType.LAWBOT, 6, 10);
	private static Cog legalEagle = new Cog("Legal Eagle", CogType.LAWBOT, 7, 11);
	private static Cog bigWig = new Cog("Big Wig", CogType.LAWBOT, 8, 12);

	private static Cog shortChange = new Cog("Short Change", CogType.CASHBOT, 1, 5);
	private static Cog pennyPincher = new Cog("Penny Pincher", CogType.CASHBOT, 2, 6);
	private static Cog tightwad = new Cog("Tightwad", CogType.CASHBOT, 3, 7);
	private static Cog beanCounter = new Cog("Bean Counter", CogType.CASHBOT, 4, 8);
	private static Cog numberCruncher = new Cog("Number Cruncher", CogType.CASHBOT, 5, 9);
	private static Cog moneyBags = new Cog("Money Bags", CogType.CASHBOT, 6, 10);
	private static Cog loanShark = new Cog("Loan Shark", CogType.CASHBOT, 7, 11);
	private static Cog robberBaron = new Cog("Robber Baron", CogType.CASHBOT, 8, 12);

	private static Cog coldCaller = new Cog("Cold Caller", CogType.SELLBOT, 1, 5);
	private static Cog telemarketer = new Cog("Telemarketer", CogType.SELLBOT, 2, 6);
	private static Cog nameDropper = new Cog("Name Dropper", CogType.SELLBOT, 3, 7);
	private static Cog gladHander = new Cog("Glad Hander", CogType.SELLBOT, 4, 8);
	private static Cog moverAndShaker = new Cog("Mover & Shaker", CogType.SELLBOT, 5, 9);
	private static Cog twoFace = new Cog("Two-Face", CogType.SELLBOT, 6, 10);
	private static Cog theMingler = new Cog("The Mingler", CogType.SELLBOT, 7, 11);
	private static Cog mrHollywood = new Cog("Mr. Hollywood", CogType.SELLBOT, 8, 12);

	private static Cog unimplementedCog = new Cog("UnimplementedCogName", CogType.NONE, 0, 0);

	public static Cog[] cogs = { flunky, pencilPusher, yesman, micromanager, downsizer, headHunter, corporateRaider,
			theBigCheese, bottomFeeder, bloodsucker, doubleTalker, ambulanceChaser, backStabber, spinDoctor, legalEagle,
			bigWig, shortChange, pennyPincher, tightwad, beanCounter, numberCruncher, moneyBags, loanShark, robberBaron,
			coldCaller, telemarketer, nameDropper, gladHander, moverAndShaker, twoFace, theMingler, mrHollywood };

	private String name;
	private CogType cogType;
	private int lowestLevel, highestLevel;
	private BufferedImage image, infoImage;

	private Cog(String name, CogType cogType, int lowestLevel, int highestLevel) {
		this.name = name;
		this.cogType = cogType;
		this.lowestLevel = lowestLevel;
		this.highestLevel = highestLevel;

		try {
			image = ImageIO.read(this.getClass().getResourceAsStream("/resources/graphical/Cog - " + name + ".png"));
		} catch (Exception e) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream("/resources/graphical/MissingAsset.png"));
			} catch (Exception e1) {
				e1.printStackTrace();
				image = null;
			}
		}

		infoImage = new BufferedImage(658, 192, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = infoImage.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

		try {
			g.setFont(GlobalFonts.cogFont);

			String type = this.getCogType().toString().toLowerCase();
			type = (char) (type.charAt(0) & 0xDF) + type.substring(1);

			// Background
			BufferedImage background;
			try {
				background = ImageIO.read(this.getClass()
						.getResourceAsStream("/resources/graphical/Cog Panel Background - " + type + ".png"));
			} catch (Exception e) {
				try {
					background = ImageIO
							.read(this.getClass().getResourceAsStream("/resources/graphical/MissingAsset.png"));
				} catch (Exception e1) {
					e1.printStackTrace();
					background = null;
				}
			}
			g.drawImage(background, 0, 0, null);

			// Cog picture
			g.drawImage(this.getImage(), 32, 32, null);
			g.setColor(Color.BLACK);
			g.setStroke(new BasicStroke(5));
			g.drawRect(29, 29, 133, 133);

			// Cog name
			g.drawString("Name:", 180, 55);
			g.drawString(this.getName(), 365, 55);

			// Level range
			g.drawString("Lv. range:", 180, 105);
			g.drawString(this.getLowestLevel() + " - " + this.getHighestLevel(), 365, 105);

			// Cog Type
			g.drawString("Type:", 180, 155);
			g.drawString(type, 410, 155);

			try {
				g.drawImage(
						ImageIO.read(
								this.getClass().getResourceAsStream("/resources/graphical/CogType - " + type + ".png")),
						360, 127, null);
			} catch (Exception e) {
				try {
					g.drawImage(
							ImageIO.read(this.getClass().getResourceAsStream("/resources/graphical/MissingAsset.png")),
							360, 127, null);
					background = ImageIO
							.read(this.getClass().getResourceAsStream("/resources/graphical/MissingAsset.png"));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Cog findCogByName(String name) {
		for (Cog c : cogs) {
			if (name.equals(c.getName()))
				return c;
		}

		return unimplementedCog;
	}

	public String getName() {
		return name;
	}

	public CogType getCogType() {
		return cogType;
	}

	public int getLowestLevel() {
		return lowestLevel;
	}

	public int getHighestLevel() {
		return highestLevel;
	}

	public BufferedImage getImage() {
		return image;
	}

	public BufferedImage getInfoImage() {
		return infoImage;
	}
}
