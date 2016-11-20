package controller;

import model.map.Map;

/**
 * Created by Han on 2016-11-19.
 */
public abstract class Algorithm {
	protected Map map;
	protected long executionTime;
	protected int count = 0;

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
		System.out.println("실행 시간 : " + executionTime);
		System.out.println("연산 횟수 : " + count);
		System.out.println();
	}

	public Map getMap() {
		return map;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public int getCount() {
		return count;
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
