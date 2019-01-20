package com.tylerroyer.ttr_helper.display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.tylerroyer.ttr_helper.cogs.Cog;
import com.tylerroyer.ttr_helper.globals.GlobalFonts;

public class CogsPanel extends JPanel implements ActionListener {
	private JPanel cogPanelListContainer, buttonsPanel;
	private JButton byTypeButton, byRankButton, alphabeticallyButton;
	private SortType currentSortType;

	private enum SortType {
		BY_TYPE, BY_RANK, ALPHABETICALLY
	}

	public CogsPanel() {
		cogPanelListContainer = new JPanel();
		buildCogPanelListContainer(SortType.BY_TYPE);

		buttonsPanel = new JPanel();
		buildButtonsPanel();

		JScrollPane scrollPane = new JScrollPane(cogPanelListContainer);
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);

		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.PAGE_START);
	}

	private void buildCogPanelListContainer(SortType sortType) {
		currentSortType = sortType;
		cogPanelListContainer.removeAll();

		switch (sortType) {
		default:
			System.out.println(
					"WARNING: Unrecognized cog sort type: " + sortType.toString() + ".  Sorting by type instead.");
		case BY_TYPE:
			for (Cog c : Cog.cogs) {
				cogPanelListContainer.add(new CogPanel(c));
			}
			break;
		case BY_RANK:
			Cog[] sortedByRankCogs = Cog.cogs.clone();
			for (int i = sortedByRankCogs.length - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (sortedByRankCogs[j].getLowestLevel() > sortedByRankCogs[j + 1].getLowestLevel()) {
						Cog temp = sortedByRankCogs[j];
						sortedByRankCogs[j] = sortedByRankCogs[j + 1];
						sortedByRankCogs[j + 1] = temp;
					}
				}
			}

			for (Cog c : sortedByRankCogs) {
				cogPanelListContainer.add(new CogPanel(c));
			}
			break;
		case ALPHABETICALLY:
			Cog[] sortedAlphabeticallyCogs = Cog.cogs.clone();
			for (int i = sortedAlphabeticallyCogs.length - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (sortedAlphabeticallyCogs[j].getName()
							.compareToIgnoreCase(sortedAlphabeticallyCogs[j + 1].getName()) > 0) {
						Cog temp = sortedAlphabeticallyCogs[j];
						sortedAlphabeticallyCogs[j] = sortedAlphabeticallyCogs[j + 1];
						sortedAlphabeticallyCogs[j + 1] = temp;
					}
				}
			}

			for (Cog c : sortedAlphabeticallyCogs) {
				cogPanelListContainer.add(new CogPanel(c));
			}
			break;
		}

		cogPanelListContainer.setPreferredSize(new Dimension(225, Cog.cogs.length * 207));
	}

	private void buildButtonsPanel() {
		byTypeButton = new JButton("Sort by cog type");
		byRankButton = new JButton("Sort by cog rank");
		alphabeticallyButton = new JButton("Sort alphabetically");

		final float BUTTON_FONT_SIZE = 22f;
		byTypeButton.setFont(GlobalFonts.cogFont.deriveFont(BUTTON_FONT_SIZE));
		byRankButton.setFont(GlobalFonts.cogFont.deriveFont(BUTTON_FONT_SIZE));
		alphabeticallyButton.setFont(GlobalFonts.cogFont.deriveFont(BUTTON_FONT_SIZE));

		byTypeButton.addActionListener(this);
		byRankButton.addActionListener(this);
		alphabeticallyButton.addActionListener(this);

		final int BUTTON_WIDTH = 300, BUTTON_HEIGHT = 40;
		byTypeButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		byRankButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		alphabeticallyButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

		buttonsPanel.add(byTypeButton);
		buttonsPanel.add(byRankButton);
		buttonsPanel.add(alphabeticallyButton);
	}

	public void doUpdate(boolean isSelected) {
		if (isSelected) {
			// Update scroller size
			try {
				int compCount = cogPanelListContainer.getComponentCount();
				Component lastComponent = cogPanelListContainer.getComponent(compCount - 1);
				if (lastComponent != null)
					cogPanelListContainer.setPreferredSize(new Dimension(225, lastComponent.getY() + 207));
			} catch (ArrayIndexOutOfBoundsException e) {
				// Ignore. This is likely caused by sync issues and the program should function
				// w/o it.  Also, bounds checking doesn't work because of sync issues.
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton) event.getSource();

		if (source == byTypeButton && currentSortType != SortType.BY_TYPE) {
			cogPanelListContainer.removeAll();
			buildCogPanelListContainer(SortType.BY_TYPE);
			this.revalidate();
		} else if (source == byRankButton && currentSortType != SortType.BY_RANK) {
			cogPanelListContainer.removeAll();
			buildCogPanelListContainer(SortType.BY_RANK);
			this.revalidate();
		} else if (source == alphabeticallyButton && currentSortType != SortType.ALPHABETICALLY) {
			cogPanelListContainer.removeAll();
			buildCogPanelListContainer(SortType.ALPHABETICALLY);
			this.revalidate();
		}
	}

	private class CogPanel extends JPanel {
		public CogPanel(Cog c) {
			JLabel label = new JLabel(new ImageIcon(c.getInfoImage()));
			add(label);
		}
	}

}
