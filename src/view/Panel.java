package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * Created by Han on 2016-11-19.
 */
public abstract class Panel extends JPanel {

	public Panel(MouseAdapter mouseListener) {
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
	}

	public abstract void start();
	public abstract boolean next();
	public abstract void clear();

	public abstract void setStartNode(int x, int y);
	public abstract void setEndNode(int x, int y);
	public abstract void setObstacleNode(int x, int y);
}
