package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Han on 2016-11-14.
 */
public class MainFrame extends JFrame {
	private AStarPanel aStarPanel;
	private DijkstraPanel dijkstraPanel;

	private ControlPanel controlPanel;

	public MainFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		this.setLayout(new BorderLayout(50, 50));
		this.setBounds(0, 0, width, height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		int panelWidth = (width - 100) / 30;

		aStarPanel = new AStarPanel(new MouseListener());
		dijkstraPanel = new DijkstraPanel(new MouseListener());
		controlPanel = new ControlPanel(new ClickListener());

		JPanel centerPanel = new JPanel(new GridLayout(1, 3, 50, 50));
		centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		centerPanel.add(aStarPanel);
		centerPanel.add(dijkstraPanel);

		setMaze();

		this.add(centerPanel, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);

		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void setMaze() {

		aStarPanel.setStartNode(1, 1);
		dijkstraPanel.setStartNode(1, 1);

		aStarPanel.setEndNode(15, 15);
		dijkstraPanel.setEndNode(15, 15);

		aStarPanel.setObstacleNode(1, 3);
		aStarPanel.setObstacleNode(1, 4);
		aStarPanel.setObstacleNode(2, 3);
		aStarPanel.setObstacleNode(2, 4);
		aStarPanel.setObstacleNode(3, 0);
		aStarPanel.setObstacleNode(3, 1);
		aStarPanel.setObstacleNode(3, 2);
		aStarPanel.setObstacleNode(3, 3);
		aStarPanel.setObstacleNode(3, 4);
		aStarPanel.setObstacleNode(4, 0);
		aStarPanel.setObstacleNode(4, 1);
		aStarPanel.setObstacleNode(4, 2);
		aStarPanel.setObstacleNode(4, 3);
		aStarPanel.setObstacleNode(4, 4);

		aStarPanel.setObstacleNode(0, 7);
		aStarPanel.setObstacleNode(0, 8);
		aStarPanel.setObstacleNode(1, 7);
		aStarPanel.setObstacleNode(1, 8);
		aStarPanel.setObstacleNode(2, 7);
		aStarPanel.setObstacleNode(2, 8);
		aStarPanel.setObstacleNode(3, 7);
		aStarPanel.setObstacleNode(3, 8);
		aStarPanel.setObstacleNode(4, 7);
		aStarPanel.setObstacleNode(4, 8);
		aStarPanel.setObstacleNode(5, 7);
		aStarPanel.setObstacleNode(5, 8);
		aStarPanel.setObstacleNode(6, 7);
		aStarPanel.setObstacleNode(6, 8);
		aStarPanel.setObstacleNode(7, 1);
		aStarPanel.setObstacleNode(7, 2);
		aStarPanel.setObstacleNode(7, 3);
		aStarPanel.setObstacleNode(7, 4);
		aStarPanel.setObstacleNode(7, 5);
		aStarPanel.setObstacleNode(7, 6);
		aStarPanel.setObstacleNode(7, 7);
		aStarPanel.setObstacleNode(7, 8);
		aStarPanel.setObstacleNode(8, 1);
		aStarPanel.setObstacleNode(8, 2);
		aStarPanel.setObstacleNode(8, 3);
		aStarPanel.setObstacleNode(8, 4);
		aStarPanel.setObstacleNode(8, 5);
		aStarPanel.setObstacleNode(8, 6);
		aStarPanel.setObstacleNode(8, 7);
		aStarPanel.setObstacleNode(8, 8);

		aStarPanel.setObstacleNode(1, 11);
		aStarPanel.setObstacleNode(1, 12);
		aStarPanel.setObstacleNode(2, 11);
		aStarPanel.setObstacleNode(2, 12);
		aStarPanel.setObstacleNode(3, 11);
		aStarPanel.setObstacleNode(3, 12);
		aStarPanel.setObstacleNode(4, 11);
		aStarPanel.setObstacleNode(4, 12);
		aStarPanel.setObstacleNode(5, 11);
		aStarPanel.setObstacleNode(5, 12);
		aStarPanel.setObstacleNode(6, 11);
		aStarPanel.setObstacleNode(6, 12);
		aStarPanel.setObstacleNode(7, 11);
		aStarPanel.setObstacleNode(7, 12);
		aStarPanel.setObstacleNode(8, 11);
		aStarPanel.setObstacleNode(8, 12);
		aStarPanel.setObstacleNode(9, 11);
		aStarPanel.setObstacleNode(9, 12);
		aStarPanel.setObstacleNode(10, 11);
		aStarPanel.setObstacleNode(10, 12);
		aStarPanel.setObstacleNode(11, 0);
		aStarPanel.setObstacleNode(11, 1);
		aStarPanel.setObstacleNode(11, 2);
		aStarPanel.setObstacleNode(11, 3);
		aStarPanel.setObstacleNode(11, 4);
		aStarPanel.setObstacleNode(11, 5);
		aStarPanel.setObstacleNode(11, 6);
		aStarPanel.setObstacleNode(11, 7);
		aStarPanel.setObstacleNode(11, 8);
		aStarPanel.setObstacleNode(11, 9);
		aStarPanel.setObstacleNode(11, 10);
		aStarPanel.setObstacleNode(11, 11);
		aStarPanel.setObstacleNode(11, 12);
		aStarPanel.setObstacleNode(12, 0);
		aStarPanel.setObstacleNode(12, 1);
		aStarPanel.setObstacleNode(12, 2);
		aStarPanel.setObstacleNode(12, 3);
		aStarPanel.setObstacleNode(12, 4);
		aStarPanel.setObstacleNode(12, 5);
		aStarPanel.setObstacleNode(12, 6);
		aStarPanel.setObstacleNode(12, 7);
		aStarPanel.setObstacleNode(12, 8);
		aStarPanel.setObstacleNode(12, 9);
		aStarPanel.setObstacleNode(12, 10);
		aStarPanel.setObstacleNode(12, 11);
		aStarPanel.setObstacleNode(12, 12);


		dijkstraPanel.setObstacleNode(1, 3);
		dijkstraPanel.setObstacleNode(1, 4);
		dijkstraPanel.setObstacleNode(2, 3);
		dijkstraPanel.setObstacleNode(2, 4);
		dijkstraPanel.setObstacleNode(3, 0);
		dijkstraPanel.setObstacleNode(3, 1);
		dijkstraPanel.setObstacleNode(3, 2);
		dijkstraPanel.setObstacleNode(3, 3);
		dijkstraPanel.setObstacleNode(3, 4);
		dijkstraPanel.setObstacleNode(4, 0);
		dijkstraPanel.setObstacleNode(4, 1);
		dijkstraPanel.setObstacleNode(4, 2);
		dijkstraPanel.setObstacleNode(4, 3);
		dijkstraPanel.setObstacleNode(4, 4);

		dijkstraPanel.setObstacleNode(0, 7);
		dijkstraPanel.setObstacleNode(0, 8);
		dijkstraPanel.setObstacleNode(1, 7);
		dijkstraPanel.setObstacleNode(1, 8);
		dijkstraPanel.setObstacleNode(2, 7);
		dijkstraPanel.setObstacleNode(2, 8);
		dijkstraPanel.setObstacleNode(3, 7);
		dijkstraPanel.setObstacleNode(3, 8);
		dijkstraPanel.setObstacleNode(4, 7);
		dijkstraPanel.setObstacleNode(4, 8);
		dijkstraPanel.setObstacleNode(5, 7);
		dijkstraPanel.setObstacleNode(5, 8);
		dijkstraPanel.setObstacleNode(6, 7);
		dijkstraPanel.setObstacleNode(6, 8);
		dijkstraPanel.setObstacleNode(7, 1);
		dijkstraPanel.setObstacleNode(7, 2);
		dijkstraPanel.setObstacleNode(7, 3);
		dijkstraPanel.setObstacleNode(7, 4);
		dijkstraPanel.setObstacleNode(7, 5);
		dijkstraPanel.setObstacleNode(7, 6);
		dijkstraPanel.setObstacleNode(7, 7);
		dijkstraPanel.setObstacleNode(7, 8);
		dijkstraPanel.setObstacleNode(8, 1);
		dijkstraPanel.setObstacleNode(8, 2);
		dijkstraPanel.setObstacleNode(8, 3);
		dijkstraPanel.setObstacleNode(8, 4);
		dijkstraPanel.setObstacleNode(8, 5);
		dijkstraPanel.setObstacleNode(8, 6);
		dijkstraPanel.setObstacleNode(8, 7);
		dijkstraPanel.setObstacleNode(8, 8);

		dijkstraPanel.setObstacleNode(1, 11);
		dijkstraPanel.setObstacleNode(1, 12);
		dijkstraPanel.setObstacleNode(2, 11);
		dijkstraPanel.setObstacleNode(2, 12);
		dijkstraPanel.setObstacleNode(3, 11);
		dijkstraPanel.setObstacleNode(3, 12);
		dijkstraPanel.setObstacleNode(4, 11);
		dijkstraPanel.setObstacleNode(4, 12);
		dijkstraPanel.setObstacleNode(5, 11);
		dijkstraPanel.setObstacleNode(5, 12);
		dijkstraPanel.setObstacleNode(6, 11);
		dijkstraPanel.setObstacleNode(6, 12);
		dijkstraPanel.setObstacleNode(7, 11);
		dijkstraPanel.setObstacleNode(7, 12);
		dijkstraPanel.setObstacleNode(8, 11);
		dijkstraPanel.setObstacleNode(8, 12);
		dijkstraPanel.setObstacleNode(9, 11);
		dijkstraPanel.setObstacleNode(9, 12);
		dijkstraPanel.setObstacleNode(10, 11);
		dijkstraPanel.setObstacleNode(10, 12);
		dijkstraPanel.setObstacleNode(11, 0);
		dijkstraPanel.setObstacleNode(11, 1);
		dijkstraPanel.setObstacleNode(11, 2);
		dijkstraPanel.setObstacleNode(11, 3);
		dijkstraPanel.setObstacleNode(11, 4);
		dijkstraPanel.setObstacleNode(11, 5);
		dijkstraPanel.setObstacleNode(11, 6);
		dijkstraPanel.setObstacleNode(11, 7);
		dijkstraPanel.setObstacleNode(11, 8);
		dijkstraPanel.setObstacleNode(11, 9);
		dijkstraPanel.setObstacleNode(11, 10);
		dijkstraPanel.setObstacleNode(11, 11);
		dijkstraPanel.setObstacleNode(11, 12);
		dijkstraPanel.setObstacleNode(12, 0);
		dijkstraPanel.setObstacleNode(12, 1);
		dijkstraPanel.setObstacleNode(12, 2);
		dijkstraPanel.setObstacleNode(12, 3);
		dijkstraPanel.setObstacleNode(12, 4);
		dijkstraPanel.setObstacleNode(12, 5);
		dijkstraPanel.setObstacleNode(12, 6);
		dijkstraPanel.setObstacleNode(12, 7);
		dijkstraPanel.setObstacleNode(12, 8);
		dijkstraPanel.setObstacleNode(12, 9);
		dijkstraPanel.setObstacleNode(12, 10);
		dijkstraPanel.setObstacleNode(12, 11);
		dijkstraPanel.setObstacleNode(12, 12);

		aStarPanel.start();
		dijkstraPanel.start();
	}

	private void animation() {

	}

	private class ClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = ((JButton) e.getSource()).getText();
			if (text.equals("START")) {
				aStarPanel.start();
				dijkstraPanel.start();
			} else if (text.equals("ANIMATION")) {
				animation();
			} else if (text.equals("NEXT")) {
				aStarPanel.next();
				dijkstraPanel.next();
			} else if (text.equals("CLEAR")) {
				aStarPanel.clear();
				dijkstraPanel.clear();
			}
		}
	}

	private class MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			Point point = e.getPoint();

			int x = (int) point.getX() / 20;
			int y = (int) point.getY() / 20;
			int button = e.getButton();

			if (button == 1) {
				aStarPanel.setStartNode(x, y);
				dijkstraPanel.setStartNode(x, y);
			} else if (button == 2) {
				aStarPanel.setObstacleNode(x, y);
				dijkstraPanel.setObstacleNode(x, y);
			} else if (button == 3) {
				aStarPanel.setEndNode(x, y);
				dijkstraPanel.setEndNode(x, y);
			}
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);
			aStarPanel.setObstacleNode((int) e.getPoint().getX() / 20, (int) e.getPoint().getY() / 20);
			dijkstraPanel.setObstacleNode((int) e.getPoint().getX() / 20, (int) e.getPoint().getY() / 20);
			repaint();
		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
