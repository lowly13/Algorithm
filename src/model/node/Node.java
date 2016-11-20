package model.node;

import java.awt.*;

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
	 */
	private int state = 0;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Node && x == ((Node) obj).x && y == ((Node) obj).y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isStartNode() {
		return state == 1;
	}

	public boolean isEndNode() {
		return state == 2;
	}

	public boolean isObstacle() {
		return state == 5;
	}

	public boolean isOpenList() {
		return state == 3;
	}

	public boolean isClosedList() {
		return state == 4;
	}

	public boolean isPath() {
		return state == 6;
	}

	public void setDefault() {
		state = 0;
	}

	public void setStartNode() {
		state = 1;
	}

	public void setEndNode() {
		state = 2;
	}

	public void setObstacle() {
		state = 5;
	}

	public void setOpenList() {
		if (state != 1 && state != 2)
			state = 3;
	}

	public void setClosedList() {
		if (state != 1 && state != 2)
			state = 4;
	}

	public void setPath() {
		if (state != 1 && state != 2)
			state = 6;
	}

	public int getStraightDistance(Node node) {
		int dx = this.x - node.x;
		int dy = this.y - node.y;

		return (int) (Math.sqrt(dx * dx + dy * dy) * 10);
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
