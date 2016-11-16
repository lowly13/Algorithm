package model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Han on 2016-11-14.
 */
public class AStarNode extends Node {
	/**
	 * f = total Cost
	 * g = distance from StartNode ( Path 고려 ) ParentNode.g + (distance From parentNode)
	 * h = distance from endNode
	 * */
	private int f = 0;
	private int g = 0;
	private int h = 0;

	private AStarNode parent = null;

	public AStarNode(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof AStarNode && x == ((AStarNode) obj).x && y == ((AStarNode) obj).y;
	}

	@Override
	public String toString() {
		return "x : " + x + " y : " + y + "/ f : " + f + " g : " + g + " h : " + h;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getG() {
		return g;
	}

	public int getH() {
		return h;
	}

	public int getF() {
		return f;
	}

	public AStarNode getParent() {
		return parent;
	}

	public void setParent(AStarNode parent) {
		this.parent = parent;
	}

	public void setG(AStarNode parent) {
		this.g = parent.g + getStraightDistance(parent);
	}

	public void setH(AStarNode end) {
		this.h = getStraightDistance(end);
	}

	public void setF(AStarNode parent, AStarNode end) {
		setG(parent);
		setH(end);
		this.f = h + g;
	}

	public int getStraightDistance(AStarNode node) {
		int dx = this.x - node.x;
		int dy = this.y - node.y;

		return (int) (Math.sqrt(dx*dx + dy*dy) * 10);
	}
}
