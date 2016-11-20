package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Han on 2016-11-16.
 */
public class ControlPanel extends JPanel {
	private JButton start;
	private JButton animation;
	private JButton next;
	private JButton clear;

	public ControlPanel(ActionListener listener) {
		start = new JButton("START");
		animation = new JButton("ANIMATION");
		next = new JButton("NEXT");
		clear = new JButton("CLEAR");

		this.add(start);
		this.add(animation);
		this.add(next);
		this.add(clear);

		start.addActionListener(listener);
		animation.addActionListener(listener);
		next.addActionListener(listener);
		clear.addActionListener(listener);
	}

	public JButton getNext() {
		return next;
	}
}
