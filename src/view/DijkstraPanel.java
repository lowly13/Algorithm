package view;

import controller.DijkstraAlgorithm;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;

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

	public boolean isFinish() {
		return algorithm.isFinish();
	}

	public int getCount() {
		return algorithm.getCount();
	}

	@Override
	public void start() {
		algorithm.start();
		repaint();
	}

	@Override
	public boolean next() {
		boolean isFinish = algorithm.next();
		if (isFinish) System.out.println("DIJKSTRA FINISH");
		repaint();
		return isFinish;
	}

	@Override
	public void clear() {
		algorithm.clear();
		repaint();
	}

	@Override
	public void setStartNode(int x, int y) {
		algorithm.setStart(x, y);
	}

	@Override
	public void setEndNode(int x, int y) {
		algorithm.setEnd(x, y);
	}

	@Override
	public void setObstacleNode(int x, int y) {
		algorithm.setObstacle(x, y);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		algorithm.getMap().draw(g);
	}
}
