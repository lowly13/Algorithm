package view;

import controller.AStarAlgorithm;
import model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Han on 2016-11-14.
 */
public class AStarPanel extends JPanel {
	private AStarAlgorithm algorithm;


	public AStarPanel() {
		algorithm = new AStarAlgorithm(40, 40);
		this.setLayout(new BorderLayout());

		addMouseListener(new MouseListener());
	}

	public void setLength(int x_size, int y_size) {
		algorithm = new AStarAlgorithm(x_size, y_size);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		algorithm.getMap().draw(g);
	}

	private class MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			Point point = e.getPoint();

			int x = (int) point.getX() / 20;
			int y = (int) point.getY() / 20;
			int button = e.getButton();

			System.out.println(x + " / " + y);
			System.out.println(button);

			if (button == 1) {
				algorithm.setStart(x, y);
			}
			else if (button == 2) {
				algorithm.setObstacle(x, y);
			}
			else if (button == 3) {
				algorithm.setEnd(x, y);
			}

			repaint();
		}
	}
}
