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

		this.add(centerPanel, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);

		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
