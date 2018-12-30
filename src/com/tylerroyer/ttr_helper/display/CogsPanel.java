package com.tylerroyer.ttr_helper.display;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.tylerroyer.ttr_helper.cogs.Cog;

public class CogsPanel extends JPanel {
	private JPanel cogPanelListContainer;

	public CogsPanel() {
		cogPanelListContainer = new JPanel();
		buildCogPanelListContainer();

		JScrollPane scrollPane = new JScrollPane(cogPanelListContainer);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);

		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
	}

	private void buildCogPanelListContainer() {
		for (Cog c : Cog.cogs) {
			cogPanelListContainer.add(new CogPanel(c));
		}
		cogPanelListContainer.setPreferredSize(new Dimension(225, Cog.cogs.length * 207));
	}

	public void doUpdate(boolean isSelected) {
		if (isSelected) {
			// Update scroller size
			cogPanelListContainer.setPreferredSize(new Dimension(225,
					cogPanelListContainer.getComponent(cogPanelListContainer.getComponentCount() - 1).getY() + 207));
		}
	}

	private class CogPanel extends JPanel {
		public CogPanel(Cog c) {
			add(new JLabel(new ImageIcon(c.getInfoImage())));
		}
	}
}
