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
	 * path = 6
	 * */
	private int state = 0;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isOpenList() {
		return state == 3;
	}

	public void setOpenList() {
		if (state != 1)
			if (state != 2)
				state = 3;
	}

	public boolean isClosedList() {
		return state == 4;
	}

	public void setClosedList() {
		if (state != 1)
			if (state != 2)
				state = 4;
	}

	public boolean isStartNode() {
		return state == 1;
	}

	public void setStartNode() {
		state = 1;
	}

	public boolean isEndNode() {
		return state == 2;
	}

	public void setEndNode() {
		state = 2;
	}

	public boolean isObstacle() {
		return state == 5;
	}

	public void setObstacle() {
		state = 5;
	}

	public boolean isPath() {
		return state == 6;
	}

	public void setPath() {
		if (isStartNode()) return;
		state = 6;
	}

	public void setDefault() {
		state = 0;
	}

	public void draw(Graphics g) {
		if (isStartNode()) g.setColor(Color.RED);
		else if (isEndNode()) g.setColor(Color.BLUE);
		else if (isObstacle()) g.setColor(Color.BLACK);
		else if (isOpenList()) g.setColor(Color.GREEN);
		else if (isClosedList()) g.setColor(Color.GRAY);
		else if (isPath()) g.setColor(Color.MAGENTA);
		else g.setColor(Color.WHITE);

		g.fillRect(x * 20, y * 20, 19, 19);
	}
}
