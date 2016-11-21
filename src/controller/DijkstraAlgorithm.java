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

	public boolean isFinish() {
		return isFinish;
	}

	@Override
	public boolean next() {
		// isFinish == true 이면 종료한다.
		if (isFinish) {
			definePath();
			return true;
		}

		// OpenList 중 가장 작은 Cost(G) 를 가진 Node 를 찾는다.
		DijkstraNode closestNode = findClosestNodeInOpenList();

		// 만약 ClosestNode 가 Null 이면 더이상 찾아갈 곳이 없다는 뜻!
		if (closestNode == null) {
			System.out.println("경로가 없습니다!");
			return true;
		}

		// 가장 작은 Cost(G) 를 가진 Node 가 EndNode 이면 isFinish = true
		if (closestNode.equals(map.getEndNode())) {
			isFinish = true;
			return true;
		}

		// 가장 가까운 노드로 선택된 Node 의 자식 Node 들을 찾는다.
		List<Node> childNodes = map.getChildNodes(closestNode);
		for (Node node : childNodes) {
			// ChildNode 가 Obstacle 이면 확인할 필요가 없다.
			if (node.isObstacle()) continue;

			// ClosedList 에 들어있으면 이미 확인한 Node 이기 때문에 다른 확인을 하지않고 넘어간다.
			if (closedList.contains(node)) continue;

			// OpenList 에 이미 들어 있으면
			if (openList.contains(node)) {
				int beforeCost = ((DijkstraNode) node).getG();
				int currentCost = closestNode.getG() + node.getStraightDistance(closestNode);

				// 이전 비용과 부모를 바꿨을 때 비용을 비교해서 부모를 바꿔준다.
				if (beforeCost > currentCost)
					((DijkstraNode) node).setParent(closestNode);
			}

			// OpenList ClosedList 두 List 에 없으면 OpenList 에 추가한다.
			else {
				((DijkstraNode) node).setParent(closestNode);
				addOpenList(node);
			}
		}

		count++;
		return false;
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
		node.setOpenList();
		openList.add(node);
	}

	public void removeOpenList(Node node) {
		openList.remove(node);
	}

	public void addClosedList(Node node) {
		node.setClosedList();
		closedList.add(node);
	}

	public DijkstraNode findClosestNodeInOpenList() {
		int min = Integer.MAX_VALUE;
		DijkstraNode minNode = null;

		for (Node node : openList) {
			DijkstraNode dijkstraNode = (DijkstraNode) node;

			if (min >= dijkstraNode.getG()) {
				min = dijkstraNode.getG();
				minNode = dijkstraNode;
			}
		}

		if (minNode != null) {
			removeOpenList(minNode);
			addClosedList(minNode);
		}

		return minNode;
	}
}




