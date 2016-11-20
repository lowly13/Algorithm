package view;

import javax.swing.*;

/**
 * Created by Han on 2016-11-19.
 */
public class AStarPanelWrapper extends JPanel {
	private AStarPanel starPanel;
	private JPanel controlPanel;

	public AStarPanelWrapper() {
		starPanel = new AStarPanel(null);
		controlPanel = new JPanel();
	}


}
