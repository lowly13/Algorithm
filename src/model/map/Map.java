package model.map;


import model.node.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 2016-11-19.
 */
public abstract class Map {
	public final int X_SIZE;
	public final int Y_SIZE;

	protected Node[][] map;
	protected Node startNode;
	protected Node endNode;

	public Map() {
		this.X_SIZE = 30;
		this.Y_SIZE = 30;

		initMap();
	}

	public abstract void initMap();

	public void setStartNode(int x, int y) {
		if (x > X_SIZE || y > Y_SIZE) throw new IllegalArgumentException("X AND Y IS OUT OF RANGE");

		if (startNode != null) startNode.setDefault();
		this.map[x][y].setStartNode();
		startNode = this.map[x][y];
	}

	public void setEndNode(int x, int y) {
		if (x > X_SIZE || y > Y_SIZE) throw new IllegalArgumentException("X AND Y IS OUT OF RANGE");

		if (endNode != null) endNode.setDefault();
		endNode = this.map[x][y];
		endNode.setEndNode();
	}

	public void setObstacle(int x, int y) {
		if (x > X_SIZE || y > Y_SIZE) throw new IllegalArgumentException("X AND Y IS OUT OF RANGE");
		this.map[x][y].setObstacle();
	}

	public void setDefault(int x, int y) {
		if (x > X_SIZE || y > Y_SIZE) throw new IllegalArgumentException("X AND Y IS OUT OF RANGE");
		this.map[x][y].setDefault();
	}

	public Node getStartNode() {
		return startNode;
	}

	public Node getEndNode() {
		return endNode;
	}

	public List<Node> getChildNodes(Node parentNode) {
		List<Node> childNodes = new ArrayList<>();

		int x = parentNode.getX();
		int y = parentNode.getY();

		if (x - 1 >= 0 && y - 1 >= 0) childNodes.add(map[x - 1][y - 1]);        // x - 1, y - 1
		if (x - 1 >= 0) childNodes.add(map[x - 1][y]);                          // x - 1, y
		if (x - 1 >= 0 && y + 1 < Y_SIZE) childNodes.add(map[x - 1][y + 1]);    // x - 1, y + 1

		if (y - 1 >= 0) childNodes.add(map[x][y - 1]);                          // x, y - 1
		if (y + 1 < Y_SIZE) childNodes.add(map[x][y + 1]);                      // x, y + 1

		if (x + 1 < X_SIZE && y - 1 >= 0) childNodes.add(map[x + 1][y - 1]);    // x + 1, y - 1
		if (x + 1 < X_SIZE) childNodes.add(map[x + 1][y]);                      // x + 1, y
		if (x + 1 < X_SIZE && y + 1 < Y_SIZE) childNodes.add(map[x + 1][y + 1]);// x + 1, y + 1

		for (int i = 0; i < childNodes.size(); i++) {
			Node node = childNodes.get(i);
			if (node.isObstacle()) childNodes.remove(node);
		}

		return childNodes;
	}

	public void draw(Graphics g) {
		for (Node[] column : map)
			for (Node node : column) node.draw(g);
	}
}
