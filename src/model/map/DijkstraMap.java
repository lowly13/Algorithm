package model.map;

import model.node.DijkstraNode;

/**
 * Created by limjunghyun on 2016-11-19.
 */
public class DijkstraMap extends Map {

	@Override
	public void initMap() {
		map = new DijkstraNode[X_SIZE][Y_SIZE];

		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[i].length; j++)
				map[i][j] = new DijkstraNode(i, j);
	}
}
