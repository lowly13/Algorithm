package controller;

import model.map.Map;

/**
 * Created by Han on 2016-11-19.
 */
public abstract class Algorithm {
	protected Map map;
	protected long executionTime;

	public abstract boolean next();
	public abstract void clear();
	protected abstract void definePath();

	public void start() {
		long startTime = System.currentTimeMillis();

		while (true) {
			if (next()) break;
		}
		definePath();
		long endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println(executionTime);
	}

	public Map getMap() {
		return map;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setStart(int x, int y) {
		map.setStartNode(x, y);
	}

	public void setEnd(int x, int y) {
		map.setEndNode(x, y);
	}

	public void setObstacle(int x, int y) {
		map.setObstacle(x, y);
	}

	public void setDefault(int x, int y) {
		map.setDefault(x, y);
	}

}
