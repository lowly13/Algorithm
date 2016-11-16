package view;

import model.AStarNode;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Han on 2016-11-14.
 */
public class GoPanel extends JPanel {
	private JFrame parentFrame;

	public GoPanel(JFrame frame) {
		this.parentFrame = frame;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		int width = (int) parentFrame.getSize().getWidth();
		int height = (int) parentFrame.getSize().getHeight();

		System.out.println(width + " / " + height);

		AStarNode node = new AStarNode(0, 0);
		AStarNode node2 = new AStarNode(0, 1);
		AStarNode node3 = new AStarNode(0, 2);
		node.draw(g);
		node2.draw(g);
		node3.draw(g);

	}
}
