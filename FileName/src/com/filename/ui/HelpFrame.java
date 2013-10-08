package com.filename.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpFrame {
	
	JFrame frame = new JFrame();
	
	JPanel mainPanel = new JPanel();
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void Initialize(){
		
		frame.setTitle("°ïÖú");
		
		frame.setBounds(550, 100, 255, 446);
		
		frame.setBackground(new Color(224, 255, 255));
		frame.setVisible(true);
		mainPanel.setBackground(new Color(224, 255, 255));
		
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5E2E\u52A9\u8BF4\u660E");
		lblNewLabel.setFont(new Font("¿¬Ìå", Font.PLAIN, 15));
		lblNewLabel.setBounds(80, 10, 60, 15);
		mainPanel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("¿¬Ìå", Font.PLAIN, 13));
		textArea.setText("1:\u901A\u914D\u7B26\r\n   \u901A\u914D\u7B26\u914D\u5408\u201C\u6587\u4EF6\u540D\u89C4\u5219\u201D\u4F7F\u7528\uFF0C\r\n\u8BBE\u7F6E\u901A\u914D\u7B26\u4E4B\u540E\u7CFB\u7EDF\u5C06\u6839\u636E\u901A\u914D\u7B26\u89C4\r\n\u5219\u6765\u66FF\u6362\u901A\u914D\u7B26\u800C\u5F62\u6210\u65B0\u7684\u6587\u4EF6\u540D\u3002\r\n\r\n2:\u901A\u914D\u7B26\u89C4\u5219\r\n   \u901A\u914D\u7B26\u89C4\u5219\u5206\u4E3A\u4E24\u79CD\uFF0C\u5206\u522B\u4E3A\u6570\u5B57\r\n\u548C\u5B57\u6BCD\u7684\u6709\u89C4\u5219\u9012\u589E\u5B57\u7B26\u3002\u5982\uFF1A\u8BBE\u7F6E\r\n\u7684\u901A\u914D\u7B26\u4E3A\u201C*\u201D\uFF1B\u901A\u914D\u7B26\u89C4\u5219\u4E3A\u201C0\r\n\u52305\u201D\uFF1B\u547D\u540D\u89C4\u5219\u4E3AABC*def\u3002\u5219\u6587\u4EF6\r\n\u540D\u751F\u6210\u89C4\u5219\u4E3A\uFF1A\r\nABC0def.type\r\nABC1def.type\r\nABC2def.type\r\n........\r\n\r\n\u6CE8\uFF1A\u5982\u679C\u8BBE\u7F6E\u7684\u901A\u914D\u7B26\u89C4\u5219\u8BA1\u6570\u5C0F\u4E8E\r\n\u6587\u4EF6\u5217\u8868\u4E2D\u7684\u6570\u76EE\uFF0C\u7CFB\u7EDF\u5C06\u4EE5\u901A\u914D\u7B26\r\n\u89C4\u5219\u7684\u6570\u76EE\u91CD\u547D\u540D\u6587\u4EF6\u3002");
		textArea.setBackground(new Color(224, 255, 255));
		textArea.setBounds(10, 35, 220, 330);
		mainPanel.add(textArea);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setBackground(new Color(230, 230, 250));
		button.setBounds(80, 375, 93, 23);
		mainPanel.add(button);
		
	}
	
	/*public static void main(String[] args) {
		HelpFrame frame = new HelpFrame();
		frame.Initialize();
	}*/
}
