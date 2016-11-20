package controller;

import model.map.DijkstraMap;
import model.node.AStarNode;
import model.node.DijkstraNode;
import model.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by limjunghyun on 2016-11-19.
 */
public class DijkstraAlgorithm extends Algorithm {
	private boolean isFinish;

	private List<Node> openList;
	private List<Node> closedList;

	public DijkstraAlgorithm() {
		this.isFinish = false;
		this.map = new DijkstraMap();
		this.openList = new ArrayList<>();
		this.closedList = new ArrayList<>();
	}

	@Override
	public void start() {
		super.start();
	}

	@Override
	public boolean next() {
		return true;
	}

	@Override
	public void clear() {
		this.isFinish = false;
		this.map = new DijkstraMap();
		this.openList.clear();
		this.closedList.clear();
	}

	@Override
	protected void definePath() {
		Node startNode = map.getStartNode();
		Node node = map.getEndNode();

		while (!node.equals(startNode)) {
			node = ((DijkstraNode) node).getParent();
			node.setPath();
		}
	}

	@Override
	public void setStart(int x, int y) {
		super.setStart(x, y);
		openList.clear();
		addOpenList(map.getStartNode());
	}

	public void addOpenList(Node node) {
		openList.add(node);
		node.setOpenList();
	}

	public void removeOpenList(Node node) {
		openList.remove(node);
	}

	public void addClosedList(Node node) {
		closedList.add(node);
		node.setClosedList();
	}
}




