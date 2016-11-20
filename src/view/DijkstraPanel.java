package view;

import controller.DijkstraAlgorithm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Han on 2016-11-14.
 */
public class DijkstraPanel extends Panel {
	private DijkstraAlgorithm algorithm;

	public DijkstraPanel(MouseAdapter mouseListener) {
		super(mouseListener);
		algorithm = new DijkstraAlgorithm();
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
	}

	@Override
	public void start() {
		algorithm.start();
	}

	@Override
	public void next() {
		algorithm.next();
	}

	@Override
	public void clear() {
		algorithm.clear();
	}

	@Override
	public void setStartNode(int x, int y) {
		algorithm.setStart(x, y);
		repaint();
	}

	@Override
	public void setEndNode(int x, int y) {
		algorithm.setEnd(x, y);
		repaint();
	}

	@Override
	public void setObstacleNode(int x, int y) {
		algorithm.setObstacle(x, y);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		algorithm.getMap().draw(g);
	}
}
