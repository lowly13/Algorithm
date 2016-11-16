package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Han on 2016-11-14.
 */
public class MainFrame extends JFrame {

	public MainFrame() {
		super();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		this.setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
		this.add(new AStarPanel());

		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
