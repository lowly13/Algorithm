package controller;

import model.AStarNode;
import model.Map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 2016-11-14.
 */
public class AStarAlgorithm {
	private boolean isFinish;

	private List<AStarNode> openList;
	private List<AStarNode> closedList;
	private Map map;

	public AStarAlgorithm(int x_size, int y_size) {
		this.map = new Map(x_size, y_size);

		openList = new ArrayList<>();
		closedList = new ArrayList<>();

		// 시작점, 끝점을 설정
		setStart(0, 0);
		setEnd(39, 39);

		// 장애물 설정
		setObstacle(3, 3);
		setObstacle(5, 5);
		setObstacle(7, 7);

		// 열린List 중 가장 작은 F 를 가진 Node 를 찾는다.
		AStarNode minimumNode = findMinimumCostInOpenList();

		// 해당 Node 의 Child 들을 가져온다.
		List<AStarNode> childNodeList = map.getChildNodes(minimumNode);
		for (AStarNode node : childNodeList) {

			// child 노드가 OpenList 또는 ClosedList 에 포함 되어 있으면
			if (openList.contains(node) || closedList.contains(node)) {
				// Child 노드의 Parent 노드가 있는지 확인 부모가 있다면
				if (node.getParent() != null) {
					int beforeCost = node.getF();
					int cost/** F */ = minimumNode.getG()
							+ node.getStraightDistance(minimumNode)/** G */
							+ node.getStraightDistance(map.getEndNode())/** H */;

					// 새로운 부모를 가질때 비용과 이전 부모를 가질때 비용을 고려해 부모를 바꿔준다.
					if (cost < beforeCost) {
						node.setF(minimumNode, map.getEndNode());
						node.setParent(minimumNode);
					}
				}
			}
			else {
				node.setParent(minimumNode);
				node.setF(minimumNode, map.getEndNode());
				openList.add(node);
			}
		}

		// loop Start
		for (; true; ) {
			// openList 에 들어있는 지점 중 총 비용이 가장 적은 곳을 선택
			minimumNode = findMinimumCostInOpenList();

			if (minimumNode == null || minimumNode.equals(map.getEndNode())) {
				closedList.add(minimumNode);
				break;
			}

			// 비용이 가장 적은 Node 를 열린 List 에서 빼고 닫힌 List 에 넣는다
//			openList.remove(minimumNode);
//			closedList.add(minimumNode);

			// 비용이 가장 적은 Node 에서 8방향으로 OpenList 에 추가할 노드가 있는지 확인하면서 (closedList 안에 있는 Node 들은 확인할 필요가 없다)
			// 8방향의 Node 의 비용을 다시 Check -> 더 작은 R 의 비용이 나온다면 비용을 바꿔준다.
			childNodeList = map.getChildNodes(minimumNode);
			for (AStarNode node : childNodeList) {
				boolean isAlreadyInOpenList = openList.contains(node) || closedList.contains(node);

				// 추가할 노드면 비용, Parent 설정 후 추가
				if (!isAlreadyInOpenList) {
					node.setParent(minimumNode);
					node.setF(minimumNode, map.getEndNode());
					openList.add(node);
				} else { // 추가할 노드가 아니라면, 비용을 고려 후 비용을 바꾸던가 가만히 놔둠!
					AStarNode nodesParent = node.getParent();
					if (nodesParent != null) {
						int beforeCost = node.getF();
						int cost/** F */ = minimumNode.getG()
								+ node.getStraightDistance(minimumNode)/** G */
								+ node.getStraightDistance(map.getEndNode())/** H */;

						if (cost < beforeCost) {
							node.setF(minimumNode, map.getEndNode());
							node.setParent(minimumNode);
						}
					}
				}
			}

			// loop End
		}

		for (AStarNode node : openList) System.out.println(node);
		System.out.println();
		System.out.println();
		for (AStarNode node : closedList) System.out.println(node);
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

		openList.remove(minNode);
		closedList.add(minNode);

		return minNode;
	}

	public void setStart(int x, int y) {
		map.setStartNode(x, y);
		// 시작점을 열린 목록에 바로 추가!
		openList.add(map.getStartNode());
	}

	public void setEnd(int x, int y) {
		map.setEndNode(x, y);
	}

	public void setObstacle(int x, int y) {
		map.setObstacle(x, y);
	}
}
