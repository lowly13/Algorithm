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

		setMaze2();

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

	private void setMaze2() {
		aStarPanel.setStartNode(2, 2);
		aStarPanel.setEndNode(25, 22);

		aStarPanel.setObstacleNode(0, 4);
		aStarPanel.setObstacleNode(0, 5);
		aStarPanel.setObstacleNode(1, 4);
		aStarPanel.setObstacleNode(1, 5);
		aStarPanel.setObstacleNode(2, 4);
		aStarPanel.setObstacleNode(2, 5);
		aStarPanel.setObstacleNode(3, 4);
		aStarPanel.setObstacleNode(3, 5);
		aStarPanel.setObstacleNode(4, 4);
		aStarPanel.setObstacleNode(4, 5);
		aStarPanel.setObstacleNode(5, 4);
		aStarPanel.setObstacleNode(5, 5);
		aStarPanel.setObstacleNode(6, 4);
		aStarPanel.setObstacleNode(6, 5);
		aStarPanel.setObstacleNode(7, 4);
		aStarPanel.setObstacleNode(7, 5);
		aStarPanel.setObstacleNode(8, 4);
		aStarPanel.setObstacleNode(8, 5);
		aStarPanel.setObstacleNode(9, 4);
		aStarPanel.setObstacleNode(9, 5);
		aStarPanel.setObstacleNode(10, 4);
		aStarPanel.setObstacleNode(10, 5);
		aStarPanel.setObstacleNode(11, 4);
		aStarPanel.setObstacleNode(11, 5);
		aStarPanel.setObstacleNode(12, 4);
		aStarPanel.setObstacleNode(12, 5);
		aStarPanel.setObstacleNode(13, 4);
		aStarPanel.setObstacleNode(13, 5);
		aStarPanel.setObstacleNode(14, 4);
		aStarPanel.setObstacleNode(14, 5);
		aStarPanel.setObstacleNode(15, 4);
		aStarPanel.setObstacleNode(15, 5);
		aStarPanel.setObstacleNode(16, 4);
		aStarPanel.setObstacleNode(16, 5);
		aStarPanel.setObstacleNode(17, 4);
		aStarPanel.setObstacleNode(17, 5);
		aStarPanel.setObstacleNode(18, 4);
		aStarPanel.setObstacleNode(18, 5);
		aStarPanel.setObstacleNode(19, 4);
		aStarPanel.setObstacleNode(19, 5);
		aStarPanel.setObstacleNode(20, 4);
		aStarPanel.setObstacleNode(20, 5);
		aStarPanel.setObstacleNode(21, 4);
		aStarPanel.setObstacleNode(21, 5);
		aStarPanel.setObstacleNode(22, 4);
		aStarPanel.setObstacleNode(22, 5);
		aStarPanel.setObstacleNode(23, 4);
		aStarPanel.setObstacleNode(23, 5);

		aStarPanel.setObstacleNode(28, 0);
		aStarPanel.setObstacleNode(29, 0);
		aStarPanel.setObstacleNode(30, 0);
		aStarPanel.setObstacleNode(31, 0);
		aStarPanel.setObstacleNode(28, 1);
		aStarPanel.setObstacleNode(29, 1);
		aStarPanel.setObstacleNode(30, 1);
		aStarPanel.setObstacleNode(31, 1);
		aStarPanel.setObstacleNode(28, 2);
		aStarPanel.setObstacleNode(29, 2);
		aStarPanel.setObstacleNode(30, 2);
		aStarPanel.setObstacleNode(31, 2);
		aStarPanel.setObstacleNode(28, 3);
		aStarPanel.setObstacleNode(29, 3);
		aStarPanel.setObstacleNode(30, 3);
		aStarPanel.setObstacleNode(31, 3);
		aStarPanel.setObstacleNode(28, 4);
		aStarPanel.setObstacleNode(29, 4);
		aStarPanel.setObstacleNode(30, 4);
		aStarPanel.setObstacleNode(31, 4);
		aStarPanel.setObstacleNode(28, 5);
		aStarPanel.setObstacleNode(29, 5);
		aStarPanel.setObstacleNode(30, 5);
		aStarPanel.setObstacleNode(31, 5);
		aStarPanel.setObstacleNode(28, 6);
		aStarPanel.setObstacleNode(29, 6);
		aStarPanel.setObstacleNode(30, 6);
		aStarPanel.setObstacleNode(31, 6);
		aStarPanel.setObstacleNode(28, 7);
		aStarPanel.setObstacleNode(29, 7);
		aStarPanel.setObstacleNode(30, 7);
		aStarPanel.setObstacleNode(31, 7);
		aStarPanel.setObstacleNode(28, 8);
		aStarPanel.setObstacleNode(29, 8);
		aStarPanel.setObstacleNode(30, 8);
		aStarPanel.setObstacleNode(31, 8);
		aStarPanel.setObstacleNode(28, 9);
		aStarPanel.setObstacleNode(29, 9);
		aStarPanel.setObstacleNode(30, 9);
		aStarPanel.setObstacleNode(31, 9);
		aStarPanel.setObstacleNode(28, 10);
		aStarPanel.setObstacleNode(29, 10);
		aStarPanel.setObstacleNode(30, 10);
		aStarPanel.setObstacleNode(31, 10);
		aStarPanel.setObstacleNode(28, 11);
		aStarPanel.setObstacleNode(29, 11);
		aStarPanel.setObstacleNode(30, 11);
		aStarPanel.setObstacleNode(31, 11);
		aStarPanel.setObstacleNode(28, 12);
		aStarPanel.setObstacleNode(29, 12);
		aStarPanel.setObstacleNode(30, 12);
		aStarPanel.setObstacleNode(31, 12);
		aStarPanel.setObstacleNode(28, 13);
		aStarPanel.setObstacleNode(29, 13);
		aStarPanel.setObstacleNode(30, 13);
		aStarPanel.setObstacleNode(31, 13);
		aStarPanel.setObstacleNode(28, 14);
		aStarPanel.setObstacleNode(29, 14);
		aStarPanel.setObstacleNode(30, 14);
		aStarPanel.setObstacleNode(31, 14);
		aStarPanel.setObstacleNode(28, 15);
		aStarPanel.setObstacleNode(29, 15);
		aStarPanel.setObstacleNode(30, 15);
		aStarPanel.setObstacleNode(31, 15);

		aStarPanel.setObstacleNode(4, 8);
		aStarPanel.setObstacleNode(4, 9);
		aStarPanel.setObstacleNode(5, 8);
		aStarPanel.setObstacleNode(5, 9);
		aStarPanel.setObstacleNode(6, 8);
		aStarPanel.setObstacleNode(6, 9);
		aStarPanel.setObstacleNode(7, 8);
		aStarPanel.setObstacleNode(7, 9);
		aStarPanel.setObstacleNode(8, 8);
		aStarPanel.setObstacleNode(8, 9);
		aStarPanel.setObstacleNode(9, 8);
		aStarPanel.setObstacleNode(9, 9);
		aStarPanel.setObstacleNode(10, 8);
		aStarPanel.setObstacleNode(10, 9);
		aStarPanel.setObstacleNode(11, 8);
		aStarPanel.setObstacleNode(11, 9);
		aStarPanel.setObstacleNode(12, 8);
		aStarPanel.setObstacleNode(12, 9);
		aStarPanel.setObstacleNode(13, 8);
		aStarPanel.setObstacleNode(13, 9);
		aStarPanel.setObstacleNode(14, 8);
		aStarPanel.setObstacleNode(14, 9);
		aStarPanel.setObstacleNode(15, 8);
		aStarPanel.setObstacleNode(15, 9);
		aStarPanel.setObstacleNode(16, 8);
		aStarPanel.setObstacleNode(16, 9);
		aStarPanel.setObstacleNode(17, 8);
		aStarPanel.setObstacleNode(17, 9);
		aStarPanel.setObstacleNode(18, 8);
		aStarPanel.setObstacleNode(18, 9);
		aStarPanel.setObstacleNode(19, 8);
		aStarPanel.setObstacleNode(19, 9);
		aStarPanel.setObstacleNode(20, 8);
		aStarPanel.setObstacleNode(20, 9);
		aStarPanel.setObstacleNode(21, 8);
		aStarPanel.setObstacleNode(21, 9);
		aStarPanel.setObstacleNode(22, 8);
		aStarPanel.setObstacleNode(22, 9);
		aStarPanel.setObstacleNode(23, 8);
		aStarPanel.setObstacleNode(23, 9);
		aStarPanel.setObstacleNode(24, 8);
		aStarPanel.setObstacleNode(24, 9);
		aStarPanel.setObstacleNode(25, 8);
		aStarPanel.setObstacleNode(25, 9);
		aStarPanel.setObstacleNode(26, 8);
		aStarPanel.setObstacleNode(26, 9);
		aStarPanel.setObstacleNode(27, 8);
		aStarPanel.setObstacleNode(27, 9);

		aStarPanel.setObstacleNode(0, 12);
		aStarPanel.setObstacleNode(0, 13);
		aStarPanel.setObstacleNode(1, 12);
		aStarPanel.setObstacleNode(1, 13);
		aStarPanel.setObstacleNode(2, 12);
		aStarPanel.setObstacleNode(2, 13);
		aStarPanel.setObstacleNode(3, 12);
		aStarPanel.setObstacleNode(3, 13);
		aStarPanel.setObstacleNode(4, 12);
		aStarPanel.setObstacleNode(4, 13);
		aStarPanel.setObstacleNode(5, 12);
		aStarPanel.setObstacleNode(5, 13);
		aStarPanel.setObstacleNode(6, 12);
		aStarPanel.setObstacleNode(6, 13);
		aStarPanel.setObstacleNode(7, 12);
		aStarPanel.setObstacleNode(7, 13);
		aStarPanel.setObstacleNode(8, 12);
		aStarPanel.setObstacleNode(8, 13);
		aStarPanel.setObstacleNode(9, 12);
		aStarPanel.setObstacleNode(9, 13);
		aStarPanel.setObstacleNode(10, 12);
		aStarPanel.setObstacleNode(10, 13);
		aStarPanel.setObstacleNode(11, 12);
		aStarPanel.setObstacleNode(11, 13);
		aStarPanel.setObstacleNode(12, 12);
		aStarPanel.setObstacleNode(12, 13);
		aStarPanel.setObstacleNode(13, 12);
		aStarPanel.setObstacleNode(13, 13);
		aStarPanel.setObstacleNode(14, 12);
		aStarPanel.setObstacleNode(14, 13);
		aStarPanel.setObstacleNode(15, 12);
		aStarPanel.setObstacleNode(15, 13);
		aStarPanel.setObstacleNode(16, 12);
		aStarPanel.setObstacleNode(16, 13);
		aStarPanel.setObstacleNode(17, 12);
		aStarPanel.setObstacleNode(17, 13);
		aStarPanel.setObstacleNode(18, 12);
		aStarPanel.setObstacleNode(18, 13);
		aStarPanel.setObstacleNode(19, 12);
		aStarPanel.setObstacleNode(19, 13);
		aStarPanel.setObstacleNode(20, 12);
		aStarPanel.setObstacleNode(20, 13);
		aStarPanel.setObstacleNode(21, 12);
		aStarPanel.setObstacleNode(21, 13);

		aStarPanel.setObstacleNode(22, 18);
		aStarPanel.setObstacleNode(23, 18);
		aStarPanel.setObstacleNode(24, 18);
		aStarPanel.setObstacleNode(25, 18);
		aStarPanel.setObstacleNode(26, 18);
		aStarPanel.setObstacleNode(27, 18);
		aStarPanel.setObstacleNode(28, 18);
		aStarPanel.setObstacleNode(29, 18);

		aStarPanel.setObstacleNode(22, 19);
		aStarPanel.setObstacleNode(22, 20);
		aStarPanel.setObstacleNode(22, 21);
		aStarPanel.setObstacleNode(22, 22);
		aStarPanel.setObstacleNode(22, 23);
		aStarPanel.setObstacleNode(22, 24);

		aStarPanel.setObstacleNode(22, 24);
		aStarPanel.setObstacleNode(23, 24);
		aStarPanel.setObstacleNode(24, 24);
		aStarPanel.setObstacleNode(25, 24);
		aStarPanel.setObstacleNode(26, 24);
		aStarPanel.setObstacleNode(27, 24);

		aStarPanel.setObstacleNode(27, 20);
		aStarPanel.setObstacleNode(27, 21);
		aStarPanel.setObstacleNode(27, 22);
		aStarPanel.setObstacleNode(27, 23);

		aStarPanel.setObstacleNode(24, 20);
		aStarPanel.setObstacleNode(25, 20);
		aStarPanel.setObstacleNode(26, 20);



		dijkstraPanel.setStartNode(2, 2);
		dijkstraPanel.setEndNode(25, 22);

		dijkstraPanel.setObstacleNode(0, 4);
		dijkstraPanel.setObstacleNode(0, 5);
		dijkstraPanel.setObstacleNode(1, 4);
		dijkstraPanel.setObstacleNode(1, 5);
		dijkstraPanel.setObstacleNode(2, 4);
		dijkstraPanel.setObstacleNode(2, 5);
		dijkstraPanel.setObstacleNode(3, 4);
		dijkstraPanel.setObstacleNode(3, 5);
		dijkstraPanel.setObstacleNode(4, 4);
		dijkstraPanel.setObstacleNode(4, 5);
		dijkstraPanel.setObstacleNode(5, 4);
		dijkstraPanel.setObstacleNode(5, 5);
		dijkstraPanel.setObstacleNode(6, 4);
		dijkstraPanel.setObstacleNode(6, 5);
		dijkstraPanel.setObstacleNode(7, 4);
		dijkstraPanel.setObstacleNode(7, 5);
		dijkstraPanel.setObstacleNode(8, 4);
		dijkstraPanel.setObstacleNode(8, 5);
		dijkstraPanel.setObstacleNode(9, 4);
		dijkstraPanel.setObstacleNode(9, 5);
		dijkstraPanel.setObstacleNode(10, 4);
		dijkstraPanel.setObstacleNode(10, 5);
		dijkstraPanel.setObstacleNode(11, 4);
		dijkstraPanel.setObstacleNode(11, 5);
		dijkstraPanel.setObstacleNode(12, 4);
		dijkstraPanel.setObstacleNode(12, 5);
		dijkstraPanel.setObstacleNode(13, 4);
		dijkstraPanel.setObstacleNode(13, 5);
		dijkstraPanel.setObstacleNode(14, 4);
		dijkstraPanel.setObstacleNode(14, 5);
		dijkstraPanel.setObstacleNode(15, 4);
		dijkstraPanel.setObstacleNode(15, 5);
		dijkstraPanel.setObstacleNode(16, 4);
		dijkstraPanel.setObstacleNode(16, 5);
		dijkstraPanel.setObstacleNode(17, 4);
		dijkstraPanel.setObstacleNode(17, 5);
		dijkstraPanel.setObstacleNode(18, 4);
		dijkstraPanel.setObstacleNode(18, 5);
		dijkstraPanel.setObstacleNode(19, 4);
		dijkstraPanel.setObstacleNode(19, 5);
		dijkstraPanel.setObstacleNode(20, 4);
		dijkstraPanel.setObstacleNode(20, 5);
		dijkstraPanel.setObstacleNode(21, 4);
		dijkstraPanel.setObstacleNode(21, 5);
		dijkstraPanel.setObstacleNode(22, 4);
		dijkstraPanel.setObstacleNode(22, 5);
		dijkstraPanel.setObstacleNode(23, 4);
		dijkstraPanel.setObstacleNode(23, 5);

		dijkstraPanel.setObstacleNode(28, 0);
		dijkstraPanel.setObstacleNode(29, 0);
		dijkstraPanel.setObstacleNode(30, 0);
		dijkstraPanel.setObstacleNode(31, 0);
		dijkstraPanel.setObstacleNode(28, 1);
		dijkstraPanel.setObstacleNode(29, 1);
		dijkstraPanel.setObstacleNode(30, 1);
		dijkstraPanel.setObstacleNode(31, 1);
		dijkstraPanel.setObstacleNode(28, 2);
		dijkstraPanel.setObstacleNode(29, 2);
		dijkstraPanel.setObstacleNode(30, 2);
		dijkstraPanel.setObstacleNode(31, 2);
		dijkstraPanel.setObstacleNode(28, 3);
		dijkstraPanel.setObstacleNode(29, 3);
		dijkstraPanel.setObstacleNode(30, 3);
		dijkstraPanel.setObstacleNode(31, 3);
		dijkstraPanel.setObstacleNode(28, 4);
		dijkstraPanel.setObstacleNode(29, 4);
		dijkstraPanel.setObstacleNode(30, 4);
		dijkstraPanel.setObstacleNode(31, 4);
		dijkstraPanel.setObstacleNode(28, 5);
		dijkstraPanel.setObstacleNode(29, 5);
		dijkstraPanel.setObstacleNode(30, 5);
		dijkstraPanel.setObstacleNode(31, 5);
		dijkstraPanel.setObstacleNode(28, 6);
		dijkstraPanel.setObstacleNode(29, 6);
		dijkstraPanel.setObstacleNode(30, 6);
		dijkstraPanel.setObstacleNode(31, 6);
		dijkstraPanel.setObstacleNode(28, 7);
		dijkstraPanel.setObstacleNode(29, 7);
		dijkstraPanel.setObstacleNode(30, 7);
		dijkstraPanel.setObstacleNode(31, 7);
		dijkstraPanel.setObstacleNode(28, 8);
		dijkstraPanel.setObstacleNode(29, 8);
		dijkstraPanel.setObstacleNode(30, 8);
		dijkstraPanel.setObstacleNode(31, 8);
		dijkstraPanel.setObstacleNode(28, 9);
		dijkstraPanel.setObstacleNode(29, 9);
		dijkstraPanel.setObstacleNode(30, 9);
		dijkstraPanel.setObstacleNode(31, 9);
		dijkstraPanel.setObstacleNode(28, 10);
		dijkstraPanel.setObstacleNode(29, 10);
		dijkstraPanel.setObstacleNode(30, 10);
		dijkstraPanel.setObstacleNode(31, 10);
		dijkstraPanel.setObstacleNode(28, 11);
		dijkstraPanel.setObstacleNode(29, 11);
		dijkstraPanel.setObstacleNode(30, 11);
		dijkstraPanel.setObstacleNode(31, 11);
		dijkstraPanel.setObstacleNode(28, 12);
		dijkstraPanel.setObstacleNode(29, 12);
		dijkstraPanel.setObstacleNode(30, 12);
		dijkstraPanel.setObstacleNode(31, 12);
		dijkstraPanel.setObstacleNode(28, 13);
		dijkstraPanel.setObstacleNode(29, 13);
		dijkstraPanel.setObstacleNode(30, 13);
		dijkstraPanel.setObstacleNode(31, 13);
		dijkstraPanel.setObstacleNode(28, 14);
		dijkstraPanel.setObstacleNode(29, 14);
		dijkstraPanel.setObstacleNode(30, 14);
		dijkstraPanel.setObstacleNode(31, 14);
		dijkstraPanel.setObstacleNode(28, 15);
		dijkstraPanel.setObstacleNode(29, 15);
		dijkstraPanel.setObstacleNode(30, 15);
		dijkstraPanel.setObstacleNode(31, 15);

		dijkstraPanel.setObstacleNode(4, 8);
		dijkstraPanel.setObstacleNode(4, 9);
		dijkstraPanel.setObstacleNode(5, 8);
		dijkstraPanel.setObstacleNode(5, 9);
		dijkstraPanel.setObstacleNode(6, 8);
		dijkstraPanel.setObstacleNode(6, 9);
		dijkstraPanel.setObstacleNode(7, 8);
		dijkstraPanel.setObstacleNode(7, 9);
		dijkstraPanel.setObstacleNode(8, 8);
		dijkstraPanel.setObstacleNode(8, 9);
		dijkstraPanel.setObstacleNode(9, 8);
		dijkstraPanel.setObstacleNode(9, 9);
		dijkstraPanel.setObstacleNode(10, 8);
		dijkstraPanel.setObstacleNode(10, 9);
		dijkstraPanel.setObstacleNode(11, 8);
		dijkstraPanel.setObstacleNode(11, 9);
		dijkstraPanel.setObstacleNode(12, 8);
		dijkstraPanel.setObstacleNode(12, 9);
		dijkstraPanel.setObstacleNode(13, 8);
		dijkstraPanel.setObstacleNode(13, 9);
		dijkstraPanel.setObstacleNode(14, 8);
		dijkstraPanel.setObstacleNode(14, 9);
		dijkstraPanel.setObstacleNode(15, 8);
		dijkstraPanel.setObstacleNode(15, 9);
		dijkstraPanel.setObstacleNode(16, 8);
		dijkstraPanel.setObstacleNode(16, 9);
		dijkstraPanel.setObstacleNode(17, 8);
		dijkstraPanel.setObstacleNode(17, 9);
		dijkstraPanel.setObstacleNode(18, 8);
		dijkstraPanel.setObstacleNode(18, 9);
		dijkstraPanel.setObstacleNode(19, 8);
		dijkstraPanel.setObstacleNode(19, 9);
		dijkstraPanel.setObstacleNode(20, 8);
		dijkstraPanel.setObstacleNode(20, 9);
		dijkstraPanel.setObstacleNode(21, 8);
		dijkstraPanel.setObstacleNode(21, 9);
		dijkstraPanel.setObstacleNode(22, 8);
		dijkstraPanel.setObstacleNode(22, 9);
		dijkstraPanel.setObstacleNode(23, 8);
		dijkstraPanel.setObstacleNode(23, 9);
		dijkstraPanel.setObstacleNode(24, 8);
		dijkstraPanel.setObstacleNode(24, 9);
		dijkstraPanel.setObstacleNode(25, 8);
		dijkstraPanel.setObstacleNode(25, 9);
		dijkstraPanel.setObstacleNode(26, 8);
		dijkstraPanel.setObstacleNode(26, 9);
		dijkstraPanel.setObstacleNode(27, 8);
		dijkstraPanel.setObstacleNode(27, 9);

		dijkstraPanel.setObstacleNode(0, 12);
		dijkstraPanel.setObstacleNode(0, 13);
		dijkstraPanel.setObstacleNode(1, 12);
		dijkstraPanel.setObstacleNode(1, 13);
		dijkstraPanel.setObstacleNode(2, 12);
		dijkstraPanel.setObstacleNode(2, 13);
		dijkstraPanel.setObstacleNode(3, 12);
		dijkstraPanel.setObstacleNode(3, 13);
		dijkstraPanel.setObstacleNode(4, 12);
		dijkstraPanel.setObstacleNode(4, 13);
		dijkstraPanel.setObstacleNode(5, 12);
		dijkstraPanel.setObstacleNode(5, 13);
		dijkstraPanel.setObstacleNode(6, 12);
		dijkstraPanel.setObstacleNode(6, 13);
		dijkstraPanel.setObstacleNode(7, 12);
		dijkstraPanel.setObstacleNode(7, 13);
		dijkstraPanel.setObstacleNode(8, 12);
		dijkstraPanel.setObstacleNode(8, 13);
		dijkstraPanel.setObstacleNode(9, 12);
		dijkstraPanel.setObstacleNode(9, 13);
		dijkstraPanel.setObstacleNode(10, 12);
		dijkstraPanel.setObstacleNode(10, 13);
		dijkstraPanel.setObstacleNode(11, 12);
		dijkstraPanel.setObstacleNode(11, 13);
		dijkstraPanel.setObstacleNode(12, 12);
		dijkstraPanel.setObstacleNode(12, 13);
		dijkstraPanel.setObstacleNode(13, 12);
		dijkstraPanel.setObstacleNode(13, 13);
		dijkstraPanel.setObstacleNode(14, 12);
		dijkstraPanel.setObstacleNode(14, 13);
		dijkstraPanel.setObstacleNode(15, 12);
		dijkstraPanel.setObstacleNode(15, 13);
		dijkstraPanel.setObstacleNode(16, 12);
		dijkstraPanel.setObstacleNode(16, 13);
		dijkstraPanel.setObstacleNode(17, 12);
		dijkstraPanel.setObstacleNode(17, 13);
		dijkstraPanel.setObstacleNode(18, 12);
		dijkstraPanel.setObstacleNode(18, 13);
		dijkstraPanel.setObstacleNode(19, 12);
		dijkstraPanel.setObstacleNode(19, 13);
		dijkstraPanel.setObstacleNode(20, 12);
		dijkstraPanel.setObstacleNode(20, 13);
		dijkstraPanel.setObstacleNode(21, 12);
		dijkstraPanel.setObstacleNode(21, 13);

		dijkstraPanel.setObstacleNode(22, 18);
		dijkstraPanel.setObstacleNode(23, 18);
		dijkstraPanel.setObstacleNode(24, 18);
		dijkstraPanel.setObstacleNode(25, 18);
		dijkstraPanel.setObstacleNode(26, 18);
		dijkstraPanel.setObstacleNode(27, 18);
		dijkstraPanel.setObstacleNode(28, 18);
		dijkstraPanel.setObstacleNode(29, 18);

		dijkstraPanel.setObstacleNode(22, 19);
		dijkstraPanel.setObstacleNode(22, 20);
		dijkstraPanel.setObstacleNode(22, 21);
		dijkstraPanel.setObstacleNode(22, 22);
		dijkstraPanel.setObstacleNode(22, 23);
		dijkstraPanel.setObstacleNode(22, 24);

		dijkstraPanel.setObstacleNode(22, 24);
		dijkstraPanel.setObstacleNode(23, 24);
		dijkstraPanel.setObstacleNode(24, 24);
		dijkstraPanel.setObstacleNode(25, 24);
		dijkstraPanel.setObstacleNode(26, 24);
		dijkstraPanel.setObstacleNode(27, 24);

		dijkstraPanel.setObstacleNode(27, 20);
		dijkstraPanel.setObstacleNode(27, 21);
		dijkstraPanel.setObstacleNode(27, 22);
		dijkstraPanel.setObstacleNode(27, 23);

		dijkstraPanel.setObstacleNode(24, 20);
		dijkstraPanel.setObstacleNode(25, 20);
		dijkstraPanel.setObstacleNode(26, 20);
	}

	private class ClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = ((JButton) e.getSource()).getText();
			if (text.equals("START")) {
				aStarPanel.start();
				dijkstraPanel.start();
			} else if (text.equals("ANIMATION")) {
				int speed = controlPanel.getAnimationSpeed();
				new AnimationThread(aStarPanel, dijkstraPanel, speed).start();
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

	private class AnimationThread extends Thread {
		private AStarPanel aStarPanel;
		private DijkstraPanel dijkstraPanel;
		private int speed;

		public AnimationThread(AStarPanel aStarPanel, DijkstraPanel dijkstraPanel, int speed) {
			this.aStarPanel = aStarPanel;
			this.dijkstraPanel = dijkstraPanel;
			this.speed = speed;
		}

		@Override
		public void run() {
			super.run();

			while (true) {

				if (!dijkstraPanel.isFinish()) dijkstraPanel.next();
				if (!aStarPanel.isFinish()) aStarPanel.next();

				try {
					Thread.sleep(1025 - (speed * 10));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (aStarPanel.isFinish() && dijkstraPanel.isFinish()) {
					aStarPanel.next();
					dijkstraPanel.next();
					break;
				}
			}

			System.out.println("   A*\t\t연산 횟수 : " + aStarPanel.getCount());
			System.out.println("Dijkstra\t연산 횟수 : " + dijkstraPanel.getCount());
		}

	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
