package model.node;

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
	 */
	private int f = 0;
	private int g = 0;
	private int h = 0;

	private Node parent = null;

	public AStarNode(int x, int y) {
		super(x, y);
	}

	@Override
	public String toString() {
		return "x : " + x + " y : " + y + "/ f : " + f + " g : " + g + " h : " + h;
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

	public Node getParent() {
		return parent;
	}

	private void setG(AStarNode parent) {
		this.g = parent.g + getStraightDistance(parent);
	}

	private void setH(AStarNode end) {
		this.h = getStraightDistance(end);
	}

	private void setF(AStarNode parent, AStarNode end) {
		setG(parent);
		setH(end);
		this.f = h + g;
	}

	public void setParent(Node parent, Node end) {
		if (parent instanceof AStarNode && end instanceof AStarNode) {
			this.parent = parent;
			this.setF((AStarNode) parent, (AStarNode) end);
		}
	}
}
