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
	private static String loggedEmail;
	private static String Userrole;
	private JTextField textField_1;
	private TeacherDisplay teacherdisplay;
	private StudentDisplay studentdisplay;
	private AdminDisplay ad;
	private JTextField textField_2;
	private JTextField textField_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard(loggedInFullName,Userrole,loggedEmail);
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

	public Dashboard(String fullName, String role,String email){
		
		loggedInFullName = fullName;
		Userrole=role;
		loggedEmail=email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(6, 6, 145, 578);
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
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_2.setBounds(6, 221, 133, 45);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
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
		btnNewButton_4.setBounds(6, 529, 133, 43);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3_1 = new JButton("Admins");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnNewButton_3_1.setBounds(6, 325, 133, 40);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_4_1 = new JButton("Settings");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_4_1.setBounds(6, 487, 133, 43);
		panel.add(btnNewButton_4_1);
		
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
		panel_2.setBounds(6, 6, 676, 76);
		panel_2.setForeground(new Color(240, 255, 255));
		panel_2.setBackground(new Color(0, 0, 0));
		panel_4.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("COURSES");
		lblNewLabel_2.setBounds(255, 20, 194, 32);
		lblNewLabel_2.setFont(new Font("Cochin", Font.PLAIN, 36));
		lblNewLabel_2.setForeground(new Color(255, 255, 240));
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
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Students", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 228, 181));
		panel_11.setBounds(6, 5, 680, 67);
		panel_5.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_6_1 = new JLabel("Student Details");
		lblNewLabel_6_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_6_1.setFont(new Font("Cochin", Font.PLAIN, 40));
		lblNewLabel_6_1.setBounds(204, 6, 325, 57);
		panel_11.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Student Name:");
		lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3_1_1.setBounds(115, 114, 130, 16);
		panel_5.add(lblNewLabel_3_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(257, 99, 208, 43);
		panel_5.add(textField_2);
		
		JButton btnNewButton_5_1_2 = new JButton("Add Student");
		btnNewButton_5_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent as= new AddStudent();
				as.setVisible(true);
				}
		});
		btnNewButton_5_1_2.setBackground(new Color(210, 105, 30));
		btnNewButton_5_1_2.setBounds(116, 167, 109, 54);
		panel_5.add(btnNewButton_5_1_2);
		
		JButton btnNewButton_5_1_1_2 = new JButton("Edit Student");
		btnNewButton_5_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditStudent es = new EditStudent();
				es.setVisible(true);
			}
		});
		btnNewButton_5_1_1_2.setBackground(new Color(210, 105, 30));
		btnNewButton_5_1_1_2.setBounds(294, 167, 109, 54);
		panel_5.add(btnNewButton_5_1_1_2);
		
		JButton btnNewButton_5_1_1_1_1 = new JButton("Remove Student");
		btnNewButton_5_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelStudent ds= new DelStudent();
				ds.setVisible(true);
				
			}
		});
		btnNewButton_5_1_1_1_1.setBackground(new Color(210, 105, 30));
		btnNewButton_5_1_1_1_1.setBounds(472, 167, 130, 54);
		panel_5.add(btnNewButton_5_1_1_1_1);
		
		studentdisplay = new StudentDisplay();
		studentdisplay.setBounds(12, 250, 670, 270);
		studentdisplay.setForeground(new Color(0, 0, 0));
        panel_5.add(studentdisplay);
        studentdisplay.setLayout(null);
        
        JButton btnNewButton_10 = new JButton("Refresh Page");
        btnNewButton_10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		studentdisplay = new StudentDisplay();
        		studentdisplay.setBounds(12, 250, 670, 270);
        		studentdisplay.setForeground(new Color(0, 0, 0));
                panel_5.add(studentdisplay);
                studentdisplay.setLayout(null);
        	}
        });
        btnNewButton_10.setForeground(new Color(0, 128, 128));
        btnNewButton_10.setBackground(new Color(0, 139, 139));
        btnNewButton_10.setBounds(556, 84, 130, 46);
        panel_5.add(btnNewButton_10);
        
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
        btnNewButton_5_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EditTeacher edit = new EditTeacher();
        		edit.setVisible(true);
        	}
        });
        btnNewButton_5_1_1.setBounds(284, 177, 109, 54);
        btnNewButton_5_1_1.setBackground(new Color(210, 105, 30));
        panel_1.add(btnNewButton_5_1_1);
        
        JButton btnNewButton_5_1_1_1 = new JButton("Remove Teacher");
        btnNewButton_5_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DelTeacher del = new DelTeacher();
        		del.setVisible(true);
        	}
        });
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
        
        JPanel panel_10 = new JPanel();
        tabbedPane.addTab("Admins", null, panel_10, null);
        panel_10.setLayout(null);
        
        JPanel panel_9_1 = new JPanel();
        panel_9_1.setBounds(345, 5, 1, 1);
        panel_9_1.setLayout(null);
        panel_9_1.setBackground(new Color(102, 102, 153));
        panel_10.add(panel_9_1);
        
        JLabel lblNewLabel_6_2 = new JLabel("Teacher Details");
        lblNewLabel_6_2.setForeground(new Color(204, 255, 255));
        lblNewLabel_6_2.setFont(new Font("Cochin", Font.PLAIN, 40));
        lblNewLabel_6_2.setBounds(199, 6, 325, 57);
        panel_9_1.add(lblNewLabel_6_2);
        
        JPanel panel_9_2 = new JPanel();
        panel_9_2.setLayout(null);
        panel_9_2.setBackground(new Color(30, 144, 255));
        panel_9_2.setBounds(6, 5, 680, 69);
        panel_10.add(panel_9_2);
        
        JLabel lblNewLabel_6_3 = new JLabel("Admin Details");
        lblNewLabel_6_3.setForeground(new Color(204, 255, 255));
        lblNewLabel_6_3.setFont(new Font("Cochin", Font.PLAIN, 40));
        lblNewLabel_6_3.setBounds(208, 6, 325, 57);
        panel_9_2.add(lblNewLabel_6_3);
        
        JLabel lblNewLabel_3_1_2 = new JLabel("Admin Name:");
        lblNewLabel_3_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblNewLabel_3_1_2.setBounds(143, 102, 130, 16);
        panel_10.add(lblNewLabel_3_1_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(270, 86, 208, 43);
        panel_10.add(textField_3);
        
        JButton btnNewButton_5_1_3 = new JButton("Add Admin");
        btnNewButton_5_1_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddAdmin aa = new AddAdmin();
        		aa.setVisible(true);
        	}
        });
        btnNewButton_5_1_3.setBackground(new Color(210, 105, 30));
        btnNewButton_5_1_3.setBounds(85, 150, 109, 54);
        panel_10.add(btnNewButton_5_1_3);
        
        JButton btnNewButton_5_1_4 = new JButton("Edit Admin");
        btnNewButton_5_1_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EditAdmin ea = new EditAdmin();
        		ea.setVisible(true);
        	}
        });
        btnNewButton_5_1_4.setBackground(new Color(210, 105, 30));
        btnNewButton_5_1_4.setBounds(280, 150, 109, 54);
        panel_10.add(btnNewButton_5_1_4);
        
        JButton btnNewButton_5_1_5 = new JButton("Remove Admin");
        btnNewButton_5_1_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DelAdmin da = new DelAdmin();
        		da.setVisible(true);
        	}
        });
        btnNewButton_5_1_5.setBackground(new Color(210, 105, 30));
        btnNewButton_5_1_5.setBounds(465, 150, 121, 54);
        panel_10.add(btnNewButton_5_1_5);
        
        ad = new AdminDisplay();
        ad.setBounds(12, 250, 670, 270);
        ad.setForeground(new Color(0, 0, 0));
        panel_10.add(ad);
        ad.setLayout(null);
        
        JButton btnNewButton_9_1 = new JButton("Refresh Page");
        btnNewButton_9_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 ad = new AdminDisplay();
        	        ad.setBounds(12, 250, 670, 270);
        	        ad.setForeground(new Color(0, 0, 0));
        	        panel_10.add(ad);
        	        ad.setLayout(null);
        	}
        });
        btnNewButton_9_1.setForeground(new Color(0, 128, 128));
        btnNewButton_9_1.setBackground(new Color(0, 128, 128));
        btnNewButton_9_1.setBounds(583, 75, 103, 43);
        panel_10.add(btnNewButton_9_1);
        
        JPanel panel_12 = new JPanel();
        tabbedPane.addTab("Settings", null, panel_12, null);
        panel_12.setLayout(null);
        
        JLabel lblNewLabel_7 = new JLabel("General Information:");
        lblNewLabel_7.setFont(new Font("Cochin", Font.PLAIN, 35));
        lblNewLabel_7.setBounds(6, 5, 446, 45);
        panel_12.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Email");
        lblNewLabel_8.setForeground(new Color(0, 128, 128));
        lblNewLabel_8.setFont(new Font("Cochin", Font.PLAIN, 18));
        lblNewLabel_8.setBounds(543, 38, 143, 22);
        panel_12.add(lblNewLabel_8);
        
        lblNewLabel_8.setText(loggedEmail);
        
        JLabel lblNewLabel_9 = new JLabel("Name");
        lblNewLabel_9.setForeground(new Color(0, 139, 139));
        lblNewLabel_9.setFont(new Font("Cochin", Font.PLAIN, 18));
        lblNewLabel_9.setBounds(543, 5, 143, 32);
        panel_12.add(lblNewLabel_9);
        
        lblNewLabel_9.setText(loggedInFullName);
		
        
		
		
	}
}
