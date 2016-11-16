package view;

import controller.AStarAlgorithm;
import model.Map;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Han on 2016-11-14.
 */
public class AStarPanel extends JPanel {
	private AStarAlgorithm algorithm;

	public AStarPanel() {
		algorithm = new AStarAlgorithm(40, 40);
		this.setLayout(new BorderLayout());
	}

	public void setLength(int x_size, int y_size) {
		algorithm = new AStarAlgorithm(x_size, y_size);
	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);



	}
}
