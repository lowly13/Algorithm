package model.map;

import model.node.AStarNode;

/**
 * Created by Han on 2016-11-19.
 */
public class AStarMap extends Map {
	@Override
	public void initMap() {
		map = new AStarNode[X_SIZE][Y_SIZE];

		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[i].length; j++)
				map[i][j] = new AStarNode(i, j);
	}
}
