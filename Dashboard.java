package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JTextField textField;
	private CourseDisplayPanel courseDisplay;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(6, 6, 145, 550);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(6, 117, 133, 40);
		btnNewButton.setBackground(new Color(224, 255, 255));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_1.setBounds(6, 169, 133, 40);
		panel.add(btnNewButton_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(6, 6, 133, 71);
		panel_6.setBackground(new Color(248, 248, 255));
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CMS");
		lblNewLabel.setBounds(39, 24, 59, 41);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Klee", Font.PLAIN, 27));
		panel_6.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Teachers");
		btnNewButton_2.setBounds(6, 221, 133, 45);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.setBounds(6, 278, 133, 40);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assessment login = new Assessment();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(6, 483, 133, 43);
		panel.add(btnNewButton_4);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(163, 18, 713, 578);
		contentPane.add(tabbedPane);
		

		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Home", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(238, 238, 238));
		tabbedPane.addTab("Course", null, panel_4, null);
		panel_4.setLayout(null);
		
		courseDisplay = new CourseDisplayPanel();
		courseDisplay.setBounds(12, 187, 670, 270);
		courseDisplay.setForeground(new Color(0, 0, 0));
        panel_4.add(courseDisplay);
        courseDisplay.setLayout(null);
        courseDisplay.setLayout(null);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 6, 644, 69);
		panel_2.setForeground(new Color(240, 255, 255));
		panel_2.setBackground(new Color(0, 0, 0));
		panel_4.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("COURSES");
		lblNewLabel_2.setBounds(255, 13, 114, 32);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblNewLabel_2.setForeground(new Color(224, 255, 255));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(351, 13, 61, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Course Name:");
		lblNewLabel_3.setBounds(6, 125, 154, 16);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		panel_4.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(143, 118, 190, 35);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Add\nCourse\n");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse ac = new AddCourse();
				ac.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(345, 119, 98, 35);
		btnNewButton_5.setBackground(new Color(210, 105, 30));
		panel_4.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Edit Course");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCourse ec=new EditCourse();
				ec.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(448, 119, 98, 35);
		panel_4.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Del Course");
		btnNewButton_7.setBounds(547, 120, 92, 33);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelCourse del = new DelCourse();
				del.setVisible(true);
				}
		});
		btnNewButton_7.setBackground(new Color(255, 0, 0));
		panel_4.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Refresh Page");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseDisplay = new CourseDisplayPanel();
				courseDisplay.setBounds(12, 187, 670, 270);
				courseDisplay.setForeground(new Color(0, 0, 0));
		        panel_4.add(courseDisplay);
		        courseDisplay.setLayout(null);
		        courseDisplay.setLayout(null);
				
			}
		});
		btnNewButton_8.setBounds(22, 469, 124, 43);
		btnNewButton_8.setForeground(new Color(0, 139, 139));
		panel_4.add(btnNewButton_8);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Teachers", null, panel_1, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Students", null, panel_5, null);
	}
}
