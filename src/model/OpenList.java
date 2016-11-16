package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 2016-11-14.
 */
public class OpenList {
	private List<AStarNode> openList;

	public OpenList() {
		openList = new ArrayList<>();
	}

	public void add(AStarNode node) {
		this.openList.add(node);
	}

	public void add(List<AStarNode> nodeList) {
		this.openList.addAll(nodeList);
	}

}
