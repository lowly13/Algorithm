package model.node;

/**
 * Created by limjunghyun on 2016-11-19.
 */
public class DijkstraNode extends Node {
	/**
	 * g = distance from StartNode ( Path 고려 ) ParentNode.g + (distance From parentNode)
	 * */
	private int g = 0;

	private DijkstraNode parent = null;

	public DijkstraNode(int x, int y) {
		super(x, y);
	}

	@Override
	public String toString() {
		return "x : " + x + " y : " + y + "/ g : " + g;
	}

	public int getG() {
		return g;
	}

	public DijkstraNode getParent() {
		return parent;
	}

	public void setParent(DijkstraNode parent) {
		this.parent = parent;
	}

	public void setG(DijkstraNode parent) {
		this.g = parent.g + getStraightDistance(parent);
	}
}
