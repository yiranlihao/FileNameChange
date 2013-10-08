package com.filename.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.filename.file.FileModify;

public class Main {

	private JFrame frame;
	private JTextField textField_filename;
	private JTextField txtCusersdelldocuments;
	private JTextField textField_character;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textFiled_rename;
	private JTextArea textArea ;
	private JRadioButton radioButton_1,radioButton_2;
	private JCheckBox checkBox_contain,checkBox_display,checkBox_keepend;
	private JComboBox comboBox_length;
	private JScrollPane rightPanel;
	private JPanel mainPanel;
	public String pathname="";// �ļ��е�·��
	public List<String> list_oldName = new ArrayList<String>();
	public List<String> list_fileURL = new ArrayList<String>();
	public List<String> list_newName = new ArrayList<String>();
	public List<String> list_state = new ArrayList<String>();

	public Object[][] data;
	public String[] columnNames = { "�ļ���", "����·��", "�޸ĺ�����", "״̬" };

	private JTable table;

	private String character="*";//ͨ���
	
	private String rule;//��������
	
	private int startNum=0,endNum=100;//��ʼ���֣���������
	
	private String startWord = "a",endWord="z";//��ʼ��ĸ��������ĸ��
	
	private int length = 1;
	
	private File file;
	
//	private boolean is_contain;//�Ƿ�������ļ���
//	
//	private boolean is_display;//�Ƿ���ʾ�ļ���
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(400, 30, 850, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("�ļ��������޸���");
		frame.setResizable(false);// �������ô����С��
		frame.setVisible(true);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(224, 255, 255));

		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);

		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(175,
				238, 238), new Color(175, 238, 238), new Color(175, 238, 238),
				new Color(175, 238, 238)));
		leftPanel.setBackground(new Color(224, 255, 255));
		leftPanel.setBounds(10, 5, 260, 652);
		mainPanel.add(leftPanel);
		leftPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ȫ���򲿷��ļ���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 10, 148, 15);
		leftPanel.add(lblNewLabel);

		textField_filename = new JTextField();
		textField_filename.setFont(new Font("����", Font.PLAIN, 13));
		textField_filename.setText("\u6B64\u529F\u80FD\u6682\u65F6\u5C4F\u853D");
		textField_filename.setEnabled(false);
		textField_filename.setBounds(21, 35, 188, 21);
		leftPanel.add(textField_filename);
		textField_filename.setColumns(10);

		JLabel label = new JLabel("\u641C\u7D22\u4F4D\u7F6E");
		label.setFont(new Font("����", Font.PLAIN, 15));
		label.setBounds(21, 66, 70, 15);
		leftPanel.add(label);

		txtCusersdelldocuments = new JTextField();
		txtCusersdelldocuments.setText("C:\\Users\\Dell\\Documents");
		txtCusersdelldocuments.setEditable(false);
		txtCusersdelldocuments.setBounds(21, 89, 132, 21);
		leftPanel.add(txtCusersdelldocuments);
		txtCusersdelldocuments.setColumns(10);

		JButton button_open = new JButton("\u6587\u4EF6");
		button_open.setBounds(163, 88, 70, 23);
		leftPanel.add(button_open);

		JButton button = new JButton("\u5F00\u59CB\u68C0\u7D22");
		button.setFont(new Font("����", Font.PLAIN, 15));
		button.setBounds(130, 134, 103, 23);
		leftPanel.add(button);

		checkBox_contain = new JCheckBox(
				"\u5305\u542B\u5B50\u6587\u4EF6\u5939");
		checkBox_contain.setEnabled(false);
		checkBox_contain.setBackground(new Color(224, 255, 255));
		checkBox_contain.setFont(new Font("����", Font.PLAIN, 12));
		checkBox_contain.setBounds(21, 121, 103, 23);
		leftPanel.add(checkBox_contain);

		checkBox_display = new JCheckBox(
				"\u663E\u793A\u6587\u4EF6\u5939");
		checkBox_display.setEnabled(false);
		checkBox_display.setBackground(new Color(224, 255, 255));
		checkBox_display.setFont(new Font("����", Font.PLAIN, 12));
		checkBox_display.setBounds(21, 146, 103, 23);
		leftPanel.add(checkBox_display);

		JLabel label_2 = new JLabel(
				"---------\u4FEE\u6539\u683C\u5F0F----------");
		label_2.setFont(new Font("����", Font.PLAIN, 15));
		label_2.setBounds(21, 175, 212, 15);
		leftPanel.add(label_2);

		JLabel label_3 = new JLabel("\u8BBE\u7F6E\u901A\u914D\u7B26");
		label_3.setFont(new Font("����", Font.PLAIN, 15));
		label_3.setBounds(21, 203, 85, 15);
		leftPanel.add(label_3);

		textField_character = new JTextField();
		textField_character.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if (textField_character.getText().toString().length()>=1) {
					e.consume();
				}
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				character = textField_character.getText();								

				textFiled_rename.setText("ABC"+character+"cbd");
				
			}
		});
		textField_character.setFont(new Font("����", Font.PLAIN, 15));
		textField_character.setText("*");
		textField_character.setHorizontalAlignment(SwingConstants.LEFT);
		textField_character.setToolTipText("");
		textField_character.setBounds(113, 200, 70, 21);
		leftPanel.add(textField_character);
		textField_character.setColumns(10);

		JButton button_help = new JButton("");
		button_help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpFrame frame = new HelpFrame();
				frame.Initialize();
			}
		});
		button_help
				.setIcon(new ImageIcon(
						Main.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		button_help.setBounds(205, 200, 27, 22);
		leftPanel.add(button_help);

		JLabel label_4 = new JLabel("\u901A\u914D\u7B26\u89C4\u5219");
		label_4.setFont(new Font("����", Font.PLAIN, 14));
		label_4.setBounds(21, 234, 70, 15);
		leftPanel.add(label_4);

		radioButton_1 = new JRadioButton("\u4ECE");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (radioButton_1.isSelected()) {
					radioButton_2.setSelected(false);
				}
				
			}
		});
		radioButton_1.setSelected(true);
		radioButton_1.setBackground(new Color(224, 255, 255));
		radioButton_1.setFont(new Font("����", Font.PLAIN, 14));
		radioButton_1.setBounds(18, 258, 39, 23);
		leftPanel.add(radioButton_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("����", Font.PLAIN, 15));
		textField_1.setText("0");
		textField_1.setBounds(58, 259, 39, 21);
		leftPanel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_5 = new JLabel("\u5230");
		label_5.setFont(new Font("����", Font.PLAIN, 14));
		label_5.setBounds(101, 260, 14, 19);
		leftPanel.add(label_5);

		textField_2 = new JTextField();
		textField_2.setText("100");
		textField_2.setFont(new Font("����", Font.PLAIN, 15));
		textField_2.setBounds(117, 259, 59, 21);
		leftPanel.add(textField_2);
		textField_2.setColumns(10);

		JLabel label_6 = new JLabel("\u957F\u5EA6");
		label_6.setFont(new Font("����", Font.PLAIN, 14));
		label_6.setBounds(179, 262, 28, 15);
		leftPanel.add(label_6);

		comboBox_length = new JComboBox();
		comboBox_length.setModel(new DefaultComboBoxModel(new String[] { "1",
				"2", "3" }));
		comboBox_length.setFont(new Font("����", Font.PLAIN, 14));
		comboBox_length.setBounds(209, 259, 32, 21);
		leftPanel.add(comboBox_length);

		radioButton_2 = new JRadioButton("\u4ECE");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (radioButton_2.isSelected()) {
					radioButton_1.setSelected(false);
				}
				
			}
		});
		radioButton_2.setBackground(new Color(224, 255, 255));
		radioButton_2.setFont(new Font("����", Font.PLAIN, 14));
		radioButton_2.setBounds(18, 295, 39, 23);
		leftPanel.add(radioButton_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("����", Font.PLAIN, 15));
		textField_3.setText("a");
		textField_3.setColumns(10);
		textField_3.setBounds(58, 296, 39, 21);
		leftPanel.add(textField_3);

		JLabel label_7 = new JLabel("\u5230");
		label_7.setFont(new Font("����", Font.PLAIN, 14));
		label_7.setBounds(101, 299, 14, 19);
		leftPanel.add(label_7);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("����", Font.PLAIN, 15));
		textField_4.setText("z");
		textField_4.setColumns(10);
		textField_4.setBounds(117, 296, 59, 21);
		leftPanel.add(textField_4);	
		
		JLabel label_8 = new JLabel("\u6587\u4EF6\u540D\u89C4\u5219");
		label_8.setFont(new Font("����", Font.PLAIN, 15));
		label_8.setBounds(21, 337, 85, 15);
		leftPanel.add(label_8);

		textFiled_rename = new JTextField();
		textFiled_rename.setFont(new Font("����", Font.PLAIN, 14));
		textFiled_rename.setText("ABC*cbd");
		textFiled_rename.setBounds(21, 360, 212, 21);
		leftPanel.add(textFiled_rename);
		textFiled_rename.setColumns(10);

		checkBox_keepend = new JCheckBox(
				"\u4FDD\u6301\u539F\u6709\u540E\u7F00\u540D");
		checkBox_keepend.setEnabled(false);
		checkBox_keepend.setSelected(true);
		checkBox_keepend.setFont(new Font("����", Font.PLAIN, 15));
		checkBox_keepend.setBackground(new Color(224, 255, 255));
		checkBox_keepend.setBounds(21, 395, 148, 23);
		leftPanel.add(checkBox_keepend);

		textArea = new JTextArea();
		textArea.setFont(new Font("����", Font.PLAIN, 13));
		textArea.setBounds(21, 424, 212, 179);
		leftPanel.add(textArea);

		JButton btnReady = new JButton("Ready");
		btnReady.setFont(new Font("����", Font.PLAIN, 13));
		btnReady.setBounds(31, 614, 93, 23);
		leftPanel.add(btnReady);

		JButton butDo = new JButton("\u6267\u884C");
		butDo.setFont(new Font("����", Font.PLAIN, 14));
		butDo.setBounds(130, 613, 93, 23);
		leftPanel.add(butDo);
		
		
		rightPanel = new JScrollPane();
		Object[][] data1 = {};
		final JTable table1 = new JTable(data1,columnNames);
		//table1.setBackground(new Color(224, 255, 255));
		rightPanel.setViewportView(table1);	//��ʼ��ʱ����һ���յ�table��Ϊ����
		this.rightPanel.getViewport().setBackground(new Color(224, 255, 255));
		rightPanel.setBorder(new BevelBorder(BevelBorder.LOWERED,
				new Color(176, 224, 230), new Color(176, 224, 230),
				new Color(176, 224, 230), new Color(176, 224, 230)));
		rightPanel.setBounds(280, 5, 554, 652);
		rightPanel.setBackground(new Color(224, 255, 255));
		mainPanel.add(rightPanel);
		
		
		
		//******************************************************
		//ͨ������¼����ı���ʧȥ�����
		/*textField_character.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				character = textField_character.getText();								

				textFiled_rename.setText("ABC"+character+"cbd");
								
			}
		});*/
		
		
		//*****************************************************
		//���������ʧȥ����󴥷��¼�
		textFiled_rename.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				rule = textFiled_rename.getText();								
				
			}
		});

		// *******************************************************************
		/*
		 * @leehao Dell-Windows7 Eclipse4.2
		 * 
		 * @time:2013-9-28 10:00
		 * 
		 * button_open(���ļ�)�ĵ����¼��� ѡ��Ŀ���ļ��е�·����������ֵ����textField_position
		 */
		button_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("actionPerformed()");

				// �����ļ�ѡ����
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("��ѡ��Ŀ���ļ���");

				// ֻ��ʾ�ļ���
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showOpenDialog(chooser);

				// �õ�ѡ�е��ļ��е�·����
				txtCusersdelldocuments.setText(chooser.getSelectedFile().getPath());
				// System.out.println(chooser.getSelectedFile().getPath());
				// ��ȡ�ļ�·��
				pathname = txtCusersdelldocuments.getText();
				// System.out.println(pathname);
			}
		});

		// ****************************************************************
		/*
		 * @leehao Dell-Windows7 Eclipse4.2
		 * 
		 * @time:2013-9-28 10:00
		 * 
		 * �õ�ѡ���ļ������ȫ���ļ�����д��list_oldName�У��õ�ȫ���ļ���
		 * ·����д��list_fileURL��list_newNameȫ��ֻΪ���ַ�����list_stateȫ����Ϊ��δ���ġ�
		 * ���������ĸ�list�е�ȫ��Ԫ�ض�Ӧд��table��data�С���
		 */

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// pathname = textField_position.getText();
				// System.out.println("pathname: "+pathname);
				
				if (pathname.equals("")) {
					ErrorFrame errorFrame=new ErrorFrame();
					errorFrame.Initialize();
				}
				

				list_oldName.clear();
				list_fileURL.clear();
				list_newName.clear();
				list_state.clear();
				// table.removeAll();

				file = new File(pathname);
				File[] files = file.listFiles();
				
				// String[] filenames = file.list();
				// for (String filename : filenames) {
				// list_oldName.add(filename);
				// }
				

				for (File filePath : files) {
					if (filePath.isFile()) {
						// �õ���ǰĿ¼�µ������ļ����ļ�����
						list_oldName.add(filePath.getName());
						// �õ���ǰĿ¼�µ������ļ����ļ�·��
						list_fileURL.add(filePath.getAbsolutePath());
						list_newName.add(" ");
						list_state.add("δ����");
					}

				}

				/*
				 * for (Iterator iterator = list_oldName.iterator();
				 * iterator.hasNext();) { String string = (String)
				 * iterator.next(); System.out.println(string); } for (Iterator
				 * iterator = list_fileURL.iterator(); iterator.hasNext();) {
				 * String string = (String) iterator.next();
				 * System.out.println(string); } for (Iterator iterator =
				 * list_state.iterator(); iterator.hasNext();) { String string =
				 * (String) iterator.next(); System.out.println(string); }
				 */

				/*
				 * for (int i = 0; i < list_oldName.size(); i++) {
				 * System.out.println(list_oldName.toArray()[i]);
				 * System.out.println(list_fileURL.toArray()[i]);
				 * System.out.println(list_newName.toArray()[i]);
				 * System.out.println(list_state.toArray()[i]); }
				 */

				System.out.println(list_fileURL.size());
				data = new Object[list_fileURL.size()][4];

				for (int i = 0; i < list_oldName.size(); i++) {
					data[i][0] = (Object) list_oldName.toArray()[i];
					data[i][1] = (Object) list_fileURL.toArray()[i];
					data[i][2] = (Object) list_newName.toArray()[i];
					data[i][3] = (Object) list_state.toArray()[i];
				}
				table = new JTable(data, columnNames);
				//table.repaint();
				table.setBounds(3, 3, 550, 646);
				//table.setModel(new CustomTableModel());
				//table.setEnabled(false);
				table.setPreferredScrollableViewportSize(new Dimension(500, 70));
				// table.setForeground(new Color(255, 0, 0));//����table��ǰ��ɫ
				table.setSelectionBackground(new Color(224, 255, 255));

				// JScrollPane rightPanel = new JScrollPane(table);
				//rightPanel = new JScrollPane(table);
				rightPanel.remove(table1);//�Ƴ���ʼ��ʱ�Ŀ�table	
				rightPanel.setViewportView(table);//��Ӧ�¼�����ӵ�table
				/*rightPanel.setBorder(new BevelBorder(BevelBorder.LOWERED,
						new Color(176, 224, 230), new Color(176, 224, 230),
						new Color(176, 224, 230), new Color(176, 224, 230)));
				rightPanel.setBounds(280, 5, 554, 652);
				mainPanel.add(rightPanel);*/
			}
		});

		//"Ready"��ť����굥��������
		btnReady.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				list_state.clear();
				list_newName.clear();
				
				rule = textFiled_rename.getText();				
				
				//list_stateȫ������Ϊ��׼��������			
				for (int i = 0; i < list_fileURL.size(); i++) {
					list_state.add("׼������");
				}
				
				//������˳�����������
				if (radioButton_1.isSelected()) {
					startNum = Integer.parseInt(textField_1.getText());
					endNum = Integer.parseInt(textField_2.getText());
					length = Integer.parseInt((String) comboBox_length.getSelectedItem());
					list_newName = FileModify.Modify(file,rule,character,startNum,endNum,length);
				}
				
				//����ĸ˳�����������
				else if (radioButton_2.isSelected()) {
					startWord = textField_3.getText();
					endWord = textField_4.getText();
					
					list_newName = FileModify.Modify(file,rule,character,startWord, endWord);
				}
				
				//ˢ��data�е����ݣ�
				for (int i = 0; i < list_newName.size(); i++) {
					//data[i][0] = (Object) list_oldName.toArray()[i];
					//data[i][1] = (Object) list_fileURL.toArray()[i];
					data[i][2] = (Object) list_newName.toArray()[i];
					data[i][3] = (Object) list_state.toArray()[i];
				}				
				
				table.repaint();//ˢ��table
				
				textArea.setText(list_newName.get(0)+"\n"+list_newName.get(1)+"\n"+"......"
						+"\n"+"....."+"\n"+list_newName.get(list_newName.size()-2)+"\n"
						+list_newName.get(list_newName.size()-1)+"\n"+"���޸�"+list_newName.size()+"���ļ���"
						+"\n"+(file.listFiles().length>list_newName.size()?("����"
						+(file.listFiles().length-list_newName.size())
						+"���ļ�������������."+"\n"):("")));
				
			}
		});
		
		//
		/*
		 * @leehao Dell-windows7 eclipse4.2
		 * @2013-9-29 ����9:10
		 * ��ִ�С���ť�ĵ����¼���ִ��������������
		 * 
		 */
		butDo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				File[] files=file.listFiles();
				
				String pathname= file.getPath();
				
				for (int i = 0; i < list_newName.size(); i++) {
					
					File newFile = new File(pathname+"\\"+list_newName.get(i));
					
					files[i].renameTo(newFile);
					
					data[i][3]="����ɸ���";
					
				}
				
				table.repaint();//ˢ������			
				
			}
		});	
		
		
		// System.out.println(list_fileURL.size());

		// *******************************************************************
		// String[] columnNames = { "�ļ���", "����·��", "�޸ĺ�����", "״̬" };
		// Object[][] data = new Object[list_fileURL.size()][4];
		/*
		 * { {"����","java",new Integer(3),new Boolean(true)}, {"����",".NET",new
		 * Integer(4),new Boolean(true)}, {"����","weapon",new Integer(100),new
		 * Boolean(false)}, {"����ı","film",new Integer(50),new Boolean(true)}
		 * 
		 * };
		 */

		// table = new JTable(data, columnNames);
		// table.setBounds(3, 3, 550, 646);
		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		// //table.setForeground(new Color(255, 0, 0));//����table��ǰ��ɫ
		// table.setSelectionBackground(new Color(224, 255, 255));

		/*
		 * JScrollPane rightPanel = new JScrollPane(table);
		 * rightPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(
		 * 176, 224, 230), new Color(176, 224, 230), new Color(176, 224, 230),
		 * new Color(176, 224, 230))); rightPanel.setBounds(280, 5, 554, 652);
		 * mainPanel.add(rightPanel);
		 */
	}

}
