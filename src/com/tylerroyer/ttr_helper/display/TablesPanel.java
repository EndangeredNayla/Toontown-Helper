package com.tylerroyer.ttr_helper.display;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TablesPanel extends JPanel {
	public JPanel tableContainer;

	public TablesPanel() {
		tableContainer = new JPanel();

		createTables();

		JScrollPane scrollPane = new JScrollPane(tableContainer);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);

		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
	}

	private void createTables() {
		BufferedImage cogHPImage = null, bossbotPercentagesImage = null,
				lawbotPercentagesImage = null, cashbotPercentagesImage = null,
				sellbotPercentagesImage = null;
		JLabel cogHPLabel, bossbotPercentagesLabel, lawbotPercentagesLabel, cashbotPercentagesLabel,
				sellbotPercentagesLabel;

		try {
			cogHPImage = ImageIO.read(
					this.getClass().getResourceAsStream("/resources/graphical/Table - Cog HP.png"));
			bossbotPercentagesImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Table - Bossbots.png"));
			lawbotPercentagesImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Table - Lawbots.png"));
			cashbotPercentagesImage = ImageIO.read(this.getClass()
					.getResourceAsStream("/resources/graphical/Table - Cashbots.png"));
			sellbotPercentagesImage = ImageIO.read(
					this.getClass().getResourceAsStream("/resources/graphical/MissingAsset.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		cogHPLabel = new JLabel(new ImageIcon(cogHPImage));
		bossbotPercentagesLabel = new JLabel(new ImageIcon(bossbotPercentagesImage));
		lawbotPercentagesLabel = new JLabel(new ImageIcon(lawbotPercentagesImage));
		cashbotPercentagesLabel = new JLabel(new ImageIcon(cashbotPercentagesImage));
		sellbotPercentagesLabel = new JLabel(new ImageIcon(sellbotPercentagesImage));

		tableContainer.add(cogHPLabel);
		tableContainer.add(bossbotPercentagesLabel);
		tableContainer.add(lawbotPercentagesLabel);
		tableContainer.add(cashbotPercentagesLabel);
		tableContainer.add(sellbotPercentagesLabel);

		// TODO Length would ideally not be hard-coded but unless I start adding a whole
		// bunch of tables, it's not a big deal.
		tableContainer.setPreferredSize(new Dimension(1, 1053));
	}

	public void doUpdate(boolean isSelected) {
		if (isSelected) {
			// Update scroller size
			try {
				int compCount = tableContainer.getComponentCount();
				Component lastComponent = tableContainer.getComponent(compCount - 1);
				if (lastComponent != null) {
					tableContainer.setPreferredSize(new Dimension(225,
							lastComponent.getY() + lastComponent.getHeight() + 15));
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// Ignore. This is likely caused by sync issues and the program should function
				// w/o it. Also, bounds checking doesn't work because of sync issues.
			}
		}
	}
}
