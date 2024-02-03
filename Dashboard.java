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
	private static String loggedInFullName;
	private static String Userrole;
	private JTextField textField_1;
	private TeacherDisplay teacherdisplay;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard(loggedInFullName,Userrole);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */

	public Dashboard(String fullName, String role){
		
		loggedInFullName = fullName;
		Userrole=role;
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		panel_3.setBackground(new Color(220, 220, 220));
		tabbedPane.addTab("Home", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(6, 6, 680, 72);
		panel_7.setBackground(new Color(105, 105, 105));
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setForeground(new Color(0, 128, 128));
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_8.setBounds(591, 42, 83, 24);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setForeground(new Color(51, 102, 204));
		lblNewLabel_5.setFont(new Font("PingFang HK", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(16, 0, 61, 22);
		panel_8.add(lblNewLabel_5);
		
		lblNewLabel_5.setText(Userrole);
		
		JLabel lblNewLabel_4 = new JLabel("Welcome "+ loggedInFullName);
		lblNewLabel_4.setBounds(162, 6, 463, 60);
		panel_7.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(255, 250, 240));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        
		
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
		panel_1.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(6, 6, 680, 69);
		panel_9.setBackground(new Color(102, 102, 153));
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Teacher Details");
		lblNewLabel_6.setForeground(new Color(204, 255, 255));
		lblNewLabel_6.setFont(new Font("Cochin", Font.PLAIN, 40));
		lblNewLabel_6.setBounds(199, 6, 325, 57);
		panel_9.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3_1 = new JLabel("Teacher Name:");
		lblNewLabel_3_1.setBounds(147, 117, 130, 16);
		lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(289, 106, 208, 43);
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JButton btnNewButton_5_1 = new JButton("Add Teacher");
		btnNewButton_5_1.setBounds(101, 177, 109, 54);
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacher at = new AddTeacher();
				at.setVisible(true);
			}
		});
		btnNewButton_5_1.setBackground(new Color(210, 105, 30));
		panel_1.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_1_1 = new JButton("Edit Teacher");
		btnNewButton_5_1_1.setBounds(284, 177, 109, 54);
		btnNewButton_5_1_1.setBackground(new Color(210, 105, 30));
		panel_1.add(btnNewButton_5_1_1);
		
		JButton btnNewButton_5_1_1_1 = new JButton("Remove Teacher");
		btnNewButton_5_1_1_1.setBounds(475, 177, 130, 54);
		btnNewButton_5_1_1_1.setBackground(new Color(210, 105, 30));
		panel_1.add(btnNewButton_5_1_1_1);
		
		teacherdisplay = new TeacherDisplay();
		teacherdisplay.setBounds(12, 250, 670, 270);
		teacherdisplay.setForeground(new Color(0, 0, 0));
        panel_1.add(teacherdisplay);
        teacherdisplay.setLayout(null);
        
        JButton btnNewButton_9 = new JButton("Refresh Page");
        btnNewButton_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		teacherdisplay = new TeacherDisplay();
        		teacherdisplay.setBounds(12, 250, 670, 270);
        		teacherdisplay.setForeground(new Color(0, 0, 0));
                panel_1.add(teacherdisplay);
                teacherdisplay.setLayout(null);
        	}
        });
        btnNewButton_9.setForeground(new Color(0, 128, 128));
        btnNewButton_9.setBackground(new Color(0, 128, 128));
        btnNewButton_9.setBounds(583, 90, 103, 43);
        panel_1.add(btnNewButton_9);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Students", null, panel_5, null);
	}
}
