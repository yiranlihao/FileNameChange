package com.filename.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorFrame {
	
	private JFrame frame = new JFrame();
	private JPanel mainPanel = new JPanel();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void Initialize() {
		
		frame.setTitle("Error!");
		
		frame.setBounds(550, 200, 295, 148);
		
		frame.setBackground(new Color(224, 255, 255));
		frame.setVisible(true);
		mainPanel.setBackground(new Color(224, 255, 255));
		
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u6587\u4EF6\u5939\uFF01");
		label.setBackground(new Color(255, 0, 0));
		label.setFont(new Font("¿¬Ìå", Font.PLAIN, 25));
		label.setBounds(47, 10, 175, 57);
		mainPanel.add(label);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setBounds(91, 77, 93, 23);
		mainPanel.add(button);
		
		
	}
}
