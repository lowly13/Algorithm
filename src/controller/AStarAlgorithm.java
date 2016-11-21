package controller;

import model.map.AStarMap;
import model.node.AStarNode;
import model.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 2016-11-19.
 */
public class AStarAlgorithm extends Algorithm {
	private boolean isFinish;

	private List<Node> openList;
	private List<Node> closedList;

	public AStarAlgorithm() {
		isFinish = false;
		map = new AStarMap();
		openList = new ArrayList<>();
		closedList = new ArrayList<>();
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

		// OpenList 중 가장 작은 Cost(F) 를 가진 Node 를 찾는다.
		AStarNode minimumNode = findMinimumInCostOpenList();

		// 만약 minimumNode 가 Null 이면 계속해서 찾다가 더이상 찾을 곳이 없다는 뜻!!
		if (minimumNode == null) {
			System.out.println("경로가 없습니당!");
			return true;
		}

		// 가장 작은 Cost(F) 를 가진 Node 가 EndNode 이면 isFinish = true
		if (minimumNode.equals(map.getEndNode())) {
			isFinish = true;
			return true;
		}

		// 해당 Node 의 Child 를 가져온다.
		List<Node> childNodeList = map.getChildNodes(minimumNode);
		for (Node childNode : childNodeList) {
			// ChildNode 가 Obstacle 이면 확인할 필요가 없다.
			if (childNode.isObstacle()) continue;

			// ChildNode 가 ClosedList 에 포함 되어있으면 확인할 필요가 없다.
			if (closedList.contains(childNode)) continue;

			// ChildNode 가 OpenList 에 포함 되어있으면
			else if (openList.contains(childNode)) {
				int beforeCost = ((AStarNode) childNode).getF();
				int afterCost = minimumNode.getG() + childNode.getStraightDistance(minimumNode) + childNode.getStraightDistance(map.getEndNode());
				/** F */ /** 부모 노드의 비용*/    /**  부모 노드와 자식 노드간 거리*/         /**  자식 노드와 끝점 간의 거리*/

				// 이전 비용과 부모를 바꿨을 때 비용을 비교 부모를 바꿔준다.
				if (beforeCost > afterCost)
					((AStarNode) childNode).setParent(minimumNode, map.getEndNode());
			}

			// ChildNode 가 둘 다 포함 되어 있지 않으면 부모를 설정한 후 OpenList 에 추가한다.
			else {
				((AStarNode) childNode).setParent(minimumNode, map.getEndNode());
				addOpenList(childNode);
			}
		}

		count++;
		return false;
	}

	@Override
	public void clear() {
		this.isFinish = false;
		this.map = new AStarMap();
		this.openList.clear();
		this.closedList.clear();
		this.count = 0;
	}

	@Override
	protected void definePath() {
		Node startNode = map.getStartNode();
		Node node = map.getEndNode();

		while (!node.equals(startNode)) {
			node = ((AStarNode) node).getParent();
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

	public AStarNode findMinimumInCostOpenList() {
		int min = Integer.MAX_VALUE;
		AStarNode minNode = null;

		for (Node node : openList) {
			AStarNode starNode = (AStarNode) node;

			if (min >= starNode.getF()) {
				min = starNode.getF();
				minNode = starNode;
			}
		}

		if (minNode != null) {
			removeOpenList(minNode);
			addClosedList(minNode);
		}

		return minNode;
	}
}
