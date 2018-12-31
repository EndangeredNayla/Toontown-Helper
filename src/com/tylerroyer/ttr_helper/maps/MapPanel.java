package com.tylerroyer.ttr_helper.maps;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTabbedPane;

public abstract class MapPanel extends Canvas {
	private BufferedImage map;
	protected PanelLink[] panelLinks;
	protected JTabbedPane holder;

	protected MapPanel(String mapName, JTabbedPane holder) {
		try {
			map = ImageIO.read(this.getClass().getResourceAsStream("/resources/graphical/" + mapName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.holder = holder;
		initPanelLinks();
	}

	protected abstract void initPanelLinks();

	@Override
	public void paint(Graphics arg0) {
		Graphics2D g = (Graphics2D) arg0;

		g.drawImage(map, 0, 0, this);

		boolean isHovering = false;
		int mouseX = MouseInfo.getPointerInfo().getLocation().x;
		int mouseY = MouseInfo.getPointerInfo().getLocation().y;
		for (PanelLink pl : panelLinks) {
			// TODO This might have to be relative to component's pos on screen.
			if (pl.contains(mouseX, mouseY)) {
				isHovering = true;
				pl.draw(g);
			}
		}
		
		if(isHovering)
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		else
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
}
