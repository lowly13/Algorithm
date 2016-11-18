package controller;

import model.AStarNode;
import model.AStarMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 2016-11-14.
 */
public class AStarAlgorithm {
	private boolean isFinish = false;

	private List<AStarNode> openList;
	private List<AStarNode> closedList;
	private AStarMap aStarMap;

	public AStarAlgorithm() {
		this.aStarMap = new AStarMap();

		openList = new ArrayList<>();
		closedList = new ArrayList<>();

		// 시작점, 끝점을 설정
//		setStart(0, 0);
//		setEnd(15, 15);

		// 장애물 설정
//		setObstacle(3, 3);
//		setObstacle(5, 5);
//		setObstacle(7, 7);
//
//		findPath();
	}

	public boolean isFinish() {
		return isFinish;
	}

	public AStarNode findMinimumCostInOpenList() {
		int min = Integer.MAX_VALUE;
		AStarNode minNode = null;

		for (AStarNode node : openList) {
			if (min >= node.getF()) {
				min = node.getF();
				minNode = node;
			}
		}

		if (minNode != null) {
			openList.remove(minNode);
			closedList.add(minNode);
			System.out.println(minNode);
			minNode.setClosedList();
		}

		return minNode;
	}

	public void findPath() {
		while (true) {
			if (doOneStep()) break;
		}
//		System.out.println("끝남.");
//		for (AStarNode node : openList) System.out.println(node);
//		System.out.println();
//		System.out.println();
//		for (AStarNode node : closedList) System.out.println(node);
	}

	public void findMinimumCostPath() {
		AStarNode node = aStarMap.getEndNode();
		for (; ; ) {
			if (!node.equals(aStarMap.getStartNode())) {
				node = node.getParent();
				node.setPath();
			} else break;
		}
	}

	public boolean doOneStep() {
		// 열린List 중 가장 작은 F 를 가진 Node 를 찾는다.
		AStarNode minimumNode = findMinimumCostInOpenList();

		// 다음 경로가 EndNode 이면 isFinish 를 true로 바꾸고 return true 해준다.
		if (minimumNode.equals(aStarMap.getEndNode())) {
			isFinish = true;
			findMinimumCostPath();
			return true;
		}

		// 해당 Node 의 Child 들을 가져온다.
		List<AStarNode> childNodeList = aStarMap.getChildNodes(minimumNode);
		for (AStarNode node : childNodeList) {
			if (node.isObstacle()) continue;

			// child 노드가 OpenList 또는 ClosedList 에 포함 되어 있으면
			if (openList.contains(node) || closedList.contains(node)) {
				// Child 노드의 Parent 노드가 있는지 확인 부모가 있다면
				if (node.getParent() != null) {
					int beforeCost = node.getF();
					int cost/** F */ = minimumNode.getG()
							+ node.getStraightDistance(minimumNode)/** G */
							+ node.getStraightDistance(aStarMap.getEndNode())/** H */;

					// 새로운 부모를 가질때 비용과 이전 부모를 가질때 비용을 고려해 부모를 바꿔준다.
					if (cost < beforeCost) {
						node.setF(minimumNode, aStarMap.getEndNode());
						node.setParent(minimumNode);
					}
				}
			}

			// child 노드가 OpenList 또는 ClosedList 에 포함 되어 있지 않으면
			// node 의 부모를 설정한 후 OpenList 에 추가시킨다.
			else {
				node.setParent(minimumNode);
				node.setF(minimumNode, aStarMap.getEndNode());
				openList.add(node);
				node.setOpenList();
			}
		}

		return false;
	}

	public void setStart(int x, int y) {
		aStarMap.setStartNode(x, y);
		// 시작점을 열린 목록에 바로 추가!
		if (openList.isEmpty()) openList.add(aStarMap.getStartNode());
		else {
			openList.clear();
			openList.add(aStarMap.getStartNode());
		}

	}

	public void clear() {
		isFinish = false;
		aStarMap = new AStarMap();
		openList.clear();
		closedList.clear();
	}

	public void setEnd(int x, int y) {
		aStarMap.setEndNode(x, y);
	}

	public void setObstacle(int x, int y) {
		aStarMap.setObstacle(x, y);
	}

	public AStarMap getAStarMap() {
		return aStarMap;
	}

}
