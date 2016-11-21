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
	private JSlider slider;

	public ControlPanel(ActionListener listener) {
		start = new JButton("START");
		animation = new JButton("ANIMATION");
		next = new JButton("NEXT");
		clear = new JButton("CLEAR");
		slider = new JSlider(0, 100, 0);

		this.add(start);
		this.add(animation);
		this.add(next);
		this.add(clear);
		this.add(slider);

		start.addActionListener(listener);
		animation.addActionListener(listener);
		next.addActionListener(listener);
		clear.addActionListener(listener);
	}

	public JButton getNext() {
		return next;
	}

	public int getAnimationSpeed() {
		return slider.getValue();
	}
}
