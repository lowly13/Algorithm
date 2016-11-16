package model;

import java.awt.*;

/**
 * Created by Han on 2016-11-14.
 */
public class Node {
	private char tag;
	private int _x;
	private int _y;
	private boolean isObstacle;

	public Node(char tag, int _x, int _y, boolean isObstacle) {
		this.tag = tag;
		this._x = _x;
		this._y = _y;
		this.isObstacle = isObstacle;
	}

	public Node(char tag, int _x, int _y) {
		this(tag, _x, _y, true);
	}

	public Node(int _x, int _y) {
		this('-', _x, _y, true);
	}

	public Node(int _x, int _y, boolean isObstacle) {
		this('O', _x, _y, isObstacle);
	}

	public int getStraightDistance(Node node) {
		if (!node.isObstacle) return Integer.MAX_VALUE;

		int dx = node._x - this._x;
		int dy = node._y - this._y;

		double d_distance = Math.sqrt(dx*dx + dy*dy);

		return (int) (d_distance * 10);
	}

	public char getTag() {
		return tag;
	}

	public boolean isObstacle() {
		return isObstacle;
	}

	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}

	public void draw(Graphics g) {

	}
}
