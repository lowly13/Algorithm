package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Han on 2016-11-14.
 */
public class MainFrame extends JFrame {
	private AStarPanel astarPanel;
	private DijkstraPanel dijkstraPanel;
	private JPanel floydPanel;

	public MainFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		this.setLayout(new BorderLayout(50, 50));
		this.setBounds(0, 0, width, height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		int panelWidth = (width - 100) / 30;


		astarPanel = new AStarPanel();
		dijkstraPanel = new DijkstraPanel();
		floydPanel = new AStarPanel();

		JPanel centerPanel = new JPanel(new GridLayout(1, 3, 50, 50));
		centerPanel.add(astarPanel);
		centerPanel.add(dijkstraPanel);
		centerPanel.add(floydPanel);

		this.add(centerPanel, BorderLayout.CENTER);
		this.add(new ControlPanel(new ClickListener()), BorderLayout.SOUTH);

		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private class ClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = ((JButton)e.getSource()).getText();
			if (text.equals("START")) {
				astarPanel.start();
				System.out.println(text);
				repaint();
			}
			else if (text.equals("NEXT")) {
				astarPanel.next();
				System.out.println(text);
				repaint();
			}
			else if (text.equals("CLEAR")) {
				astarPanel.clear();
				System.out.println(text);
			}

		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
