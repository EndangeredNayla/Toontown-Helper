package com.tylerroyer.ttr_helper.maps;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;

public class PanelLink {
	private Shape[] shapes;
	private BufferedImage hoverImage;
	private int linkedPanelIndex;

	public PanelLink(Shape shape, BufferedImage hoverImage, int linkedPanelIndex) {
		this.shapes = new Shape[] { shape };
		this.hoverImage = hoverImage;
		this.linkedPanelIndex = linkedPanelIndex;
	}

	public PanelLink(Shape[] shapes, BufferedImage hoverImage, int linkedPanelIndex) {
		this.shapes = shapes;
		this.hoverImage = hoverImage;
		this.linkedPanelIndex = linkedPanelIndex;
	}

	public BufferedImage getHoverImage() {
		return hoverImage;
	}

	public int getLinkedPanelIndex() {
		return linkedPanelIndex;
	}

	public boolean inBounds(int x, int y) {
		for (Shape shape : shapes)
			if (shape.getBounds().contains(x, y))
				return true;

		return false;
	}

	public void fill(Graphics2D g) {
		for (Shape shape : shapes)
			g.fill(shape);
	}

	public void draw(Graphics2D g) {
		for (Shape shape : shapes)
			g.draw(shape);
	}
}
