package model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Han on 2016-11-14.
 */
public class Node {
	protected int x;
	protected int y;

	/**
	 * default = 0
	 * start = 1
	 * end = 2
	 * openList = 3
	 * closedList = 4
	 * obstacle = 5
	 * */
	private int state = 0;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isOpenList() {
		return state == 3;
	}

	public void setOpenList(boolean openList) {
		state = 3;
	}

	public boolean isClosedList() {
		return state == 4;
	}

	public void setClosedList(boolean closedList) {
		state = 4;
	}

	public boolean isStartNode() {
		return state == 1;
	}

	public void setStartNode(boolean startNode) {
		state = 1;
	}

	public boolean isEndNode() {
		return state == 2;
	}

	public void setEndNode(boolean endNode) {
		state = 2;
	}

	public boolean isObstacle() {
		return state == 5;
	}

	public void setObstacle(boolean obstacle) {
		state = 5;
	}

	public void setDefault() {
		state = 0;
	}

	public void draw(Graphics g) {
		if (isStartNode()) g.setColor(Color.RED);
		else if (isEndNode()) g.setColor(Color.BLUE);
		else if (isObstacle()) g.setColor(Color.BLACK);
		else if (isOpenList()) g.setColor(Color.GREEN);
		else if (isClosedList()) g.setColor(Color.DARK_GRAY);
		else g.setColor(Color.WHITE);

		g.fillRect(x * 20, y * 20, 19, 19);
//		g.drawRect(x * 20, y * 20, 19, 19);
	}
}
