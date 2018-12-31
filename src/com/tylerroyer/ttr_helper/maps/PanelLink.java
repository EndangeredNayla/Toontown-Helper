package com.tylerroyer.ttr_helper.maps;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;

public class PanelLink {
	private Shape shape;
	private BufferedImage hoverImage;
	private int linkedPanelIndex;

	public PanelLink(Shape shape, BufferedImage hoverImage, int linkedPanelIndex) {
		this.shape = shape;
		this.hoverImage = hoverImage;
		this.linkedPanelIndex = linkedPanelIndex;
	}

	public BufferedImage getHoverImage() {
		return hoverImage;
	}

	public int getLinkedPanelIndex() {
		return linkedPanelIndex;
	}

	public boolean contains(int x, int y) {
		return shape.contains(x, y);
	}
	
	public void fill(Graphics2D g) {
		g.fill(shape);
	}
}
