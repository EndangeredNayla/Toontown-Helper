package com.tylerroyer.ttr_helper.maps;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelLink {
	private Shape shape;
	private BufferedImage hoverImage;
	private Component linkedPanel;

	public PanelLink(Shape shape, BufferedImage hoverImage, Component linkedPanel) {
		this.shape = shape;
		this.hoverImage = hoverImage;
		this.linkedPanel = linkedPanel;
	}

	public BufferedImage getHoverImage() {
		return hoverImage;
	}

	public Component getLinkedPanel() {
		return linkedPanel;
	}

	public boolean contains(int x, int y) {
		return shape.contains(x, y);
	}
	
	public void draw(Graphics2D g) {
		g.fill(shape);
	}
}
