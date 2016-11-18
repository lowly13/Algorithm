package view;

import controller.AStarAlgorithm;

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
		algorithm = new AStarAlgorithm();
		this.setLayout(new BorderLayout());

		addMouseListener(new MouseListener());
		addMouseMotionListener(new MouseListener());
	}

	public boolean isFinish() {
		return algorithm.isFinish();
	}

	public void start() {
		algorithm.findPath();
		repaint();
	}

	public boolean next() {
		if (!algorithm.isFinish())
			return algorithm.doOneStep();
		repaint();
		return true;
	}

	public void clear() {
		algorithm.clear();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		algorithm.getAStarMap().draw(g);
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
			} else if (button == 2) {
				algorithm.setObstacle(x, y);
			} else if (button == 3) {
				algorithm.setEnd(x, y);
			}

			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			if (e.getButton() != 2) return;
			System.out.println(e.getPoint().getX() + "/" + e.getPoint().getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);
			if (e.getButton() != 2) return;
			System.out.println(e.getPoint().getX() + "/" + e.getPoint().getY());
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);
			algorithm.setObstacle((int) e.getPoint().getX() / 20, (int) e.getPoint().getY() / 20);
			repaint();
		}
	}
}
