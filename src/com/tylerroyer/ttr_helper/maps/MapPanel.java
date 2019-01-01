package com.tylerroyer.ttr_helper.maps;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JTabbedPane;

public abstract class MapPanel extends Canvas implements MouseListener {
	private BufferedImage map;
	protected PanelLink[] panelLinks;
	protected JTabbedPane holder;

	int mouseX = 0;
	int mouseY = 0;

	protected MapPanel(String mapName, JTabbedPane holder) {
		try {
			map = ImageIO.read(this.getClass().getResourceAsStream("/resources/graphical/" + mapName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.holder = holder;
		initPanelLinks();

		addMouseListener(this);
	}

	protected abstract void initPanelLinks();

	@Override
	public void update(Graphics g) {
		// Double buffer code //
		Graphics offgc;
		Image offscreen = null;
		Dimension d = getSize();

		// create the offscreen buffer and associated Graphics
		offscreen = createImage(d.width, d.height);
		offgc = offscreen.getGraphics();

		// clear the exposed area
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, d.width, d.height);
		offgc.setColor(getForeground());

		// do normal redraw
		paint(offgc);
		// scale and transfer offscreen to window
		g.drawImage(offscreen, 0, 0, this);
	}

	@Override
	public void paint(Graphics arg0) {
		Graphics2D g = (Graphics2D) arg0;

		int mapX, mapY;
		mapX = getSize().width / 2 - map.getWidth() / 2;
		mapY = getSize().height / 2 - map.getHeight() / 2;
		g.translate(mapX, mapY);
		g.drawImage(map, 0, 0, this);

		boolean isHovering = false;
		try {
			// Locations relative to the map
			mouseX = MouseInfo.getPointerInfo().getLocation().x - getLocationOnScreen().x - mapX;
			mouseY = MouseInfo.getPointerInfo().getLocation().y - getLocationOnScreen().y - mapY;
		} catch (java.awt.IllegalComponentStateException e) {
			// Ignore. Caused by initializing panel while not selected.
		}
		for (PanelLink pl : panelLinks) {
			if (pl.contains(mouseX, mouseY)) {
				isHovering = true;
				
				g.setColor(new Color(.8f, .8f, 1f, 0.4f));
				pl.fill(g);
				g.setColor(Color.BLACK);
				g.setStroke(new BasicStroke(3));
				pl.draw(g);
				
				// TODO Move this up/over if close to the bottom/right of the window
				g.drawImage(pl.getHoverImage(), mouseX + 15, mouseY + 15, this);
			}
		}

		if (isHovering)
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		else
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	ArrayList<Point> events = new ArrayList<>();

	@Override
	public void mouseClicked(MouseEvent e) {
		events.add(new Point(mouseX, mouseY));
		
		System.out.print("{ ");
		for (Point p : events) {
			System.out.print(p.x + ", ");
		}
		System.out.print("}\n{ ");
		for (Point p : events) {
			System.out.print(p.y + ", ");
		}

		System.out.print("}\n\n");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Do nothing.
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Do nothing.
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// Test for panel links being clicked.
		for (PanelLink pl : panelLinks) {
			if (pl.contains(mouseX, mouseY)) {
				holder.setSelectedIndex(pl.getLinkedPanelIndex());
				return;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// Do nothing.
	}
}
