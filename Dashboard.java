package CMS;

import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JTextField textField;
	private CourseDisplayPanel courseDisplay;
	private JTextField textField_1;
	private TeacherDisplay teacherdisplay;
	private StudentDisplay studentdisplay;
	private AdminDisplay ad;
	private ResultTable rd; 
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtNischalNeupane;
	private JTextField textField_5;
	private JTextField txtNischalgmailcom;
	private JPasswordField oldPassword;
	private JPasswordField newPassword;

	private static String loggedInFullName;
	private static String loggedEmail;
	private static String Userrole;
	private static String loggedPassword;
	private static String loggedPhone;
	private static int loggedID;
	private JButton addM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard(loggedInFullName,Userrole,loggedEmail,loggedPassword,loggedPhone,loggedID);
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

	public Dashboard(String fullName, String role,String email,String Password,String Phone,int ID){
		
		loggedInFullName = fullName;
		Userrole=role;
		loggedEmail=email;
		loggedPassword=Password;
		loggedPhone=Phone;
		loggedID=ID;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(6, 6, 145, 590);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(6, 89, 133, 40);
		btnNewButton.setBackground(new Color(224, 255, 255));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_1.setBounds(6, 128, 133, 40);
		panel.add(btnNewButton_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(6, 6, 133, 71);
		panel_6.setBackground(new Color(248, 248, 255));
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CMS");
		lblNewLabel.setBounds(16, 16, 127, 65);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Klee", Font.PLAIN, 45));
		panel_6.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Teachers");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton_2.setBounds(6, 206, 133, 45);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_3.setBounds(6, 167, 133, 40);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
		        
		        if (choice == JOptionPane.YES_OPTION) {
		            Assessment login = new Assessment();
		            dispose();
		            login.setVisible(true);
		            
		        }
		    }
		});

		btnNewButton_4.setBounds(6, 541, 133, 43);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_3_1 = new JButton("Admins");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnNewButton_3_1.setBounds(6, 252, 133, 40);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_4_1 = new JButton("Settings");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
				
			}
		});
		btnNewButton_4_1.setBounds(6, 498, 133, 43);
		panel.add(btnNewButton_4_1);
		
		JButton generate = new JButton("Generate Report");
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentID sid = new StudentID();
				sid.setVisible(true);				
			}
		});
		generate.setBounds(6, 366, 133, 40);
		panel.add(generate);
		
		JButton progress = new JButton("Result Progress");
		progress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		progress.setBounds(6, 406, 133, 40);
		panel.add(progress);
		
		JButton report = new JButton("Report Card");
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelfReport sr= new SelfReport(loggedID);
				sr.setVisible(true);
			}
		});
		report.setBounds(6, 327, 133, 40);
		panel.add(report);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(163, -28, 713, 624);
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
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(240, 255, 255));
		panel_13.setBounds(6, 90, 680, 114);
		panel_3.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Hello, This is the User Dashboard where you can find the basic information on courses, students,");
		lblNewLabel_9.setFont(new Font("Cochin", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(6, 6, 668, 16);
		panel_13.add(lblNewLabel_9);
		
		JLabel lblNewLabel_19 = new JLabel("teachers and admins. In this dashboard you can also edit your self profile in the settings and page");
		lblNewLabel_19.setFont(new Font("Cochin", Font.PLAIN, 16));
		lblNewLabel_19.setBounds(6, 34, 668, 16);
		panel_13.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("and you can reach out to us through the given neupanenischal2@gmail.com and Phone number in");
		lblNewLabel_20.setFont(new Font("Cochin", Font.PLAIN, 16));
		lblNewLabel_20.setBounds(6, 62, 668, 16);
		panel_13.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("in case of any technical Issues. Thank You !!!");
		lblNewLabel_21.setFont(new Font("Cochin", Font.PLAIN, 16));
		lblNewLabel_21.setBounds(6, 84, 303, 24);
		panel_13.add(lblNewLabel_21);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(169, 169, 169));
		panel_14.setBounds(6, 214, 382, 44);
		panel_3.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblNewLabel_22 = new JLabel("Basic Information:");
		lblNewLabel_22.setForeground(new Color(65, 105, 225));
		lblNewLabel_22.setBackground(new Color(128, 0, 128));
		lblNewLabel_22.setFont(new Font("Cochin", Font.PLAIN, 28));
		lblNewLabel_22.setBounds(6, 6, 400, 32);
		panel_14.add(lblNewLabel_22);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(176, 196, 222));
		panel_15.setBounds(77, 277, 219, 44);
		panel_3.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel lblNewLabel_23 = new JLabel("No. of Courses: ");
		lblNewLabel_23.setFont(new Font("Cochin", Font.PLAIN, 20));
		lblNewLabel_23.setBounds(6, 6, 155, 30);
		panel_15.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("C1");
		lblNewLabel_24.setForeground(new Color(128, 0, 128));
		lblNewLabel_24.setFont(new Font("Songti SC", Font.ITALIC, 26));
		lblNewLabel_24.setBounds(153, 6, 65, 33);
		panel_15.add(lblNewLabel_24);
		
		JPanel panel_15_1 = new JPanel();
		panel_15_1.setLayout(null);
		panel_15_1.setBackground(new Color(176, 196, 222));
		panel_15_1.setBounds(77, 344, 219, 44);
		panel_3.add(panel_15_1);
		
		JLabel lblNewLabel_23_1 = new JLabel("No. of Students: ");
		lblNewLabel_23_1.setFont(new Font("Cochin", Font.PLAIN, 20));
		lblNewLabel_23_1.setBounds(6, 6, 155, 30);
		panel_15_1.add(lblNewLabel_23_1);
		
		JLabel lblNewLabel_24_1 = new JLabel("C1");
		lblNewLabel_24_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_24_1.setFont(new Font("Songti SC", Font.ITALIC, 26));
		lblNewLabel_24_1.setBounds(156, 6, 65, 30);
		panel_15_1.add(lblNewLabel_24_1);
		
		JPanel panel_15_2 = new JPanel();
		panel_15_2.setLayout(null);
		panel_15_2.setBackground(new Color(176, 196, 222));
		panel_15_2.setBounds(77, 482, 219, 44);
		panel_3.add(panel_15_2);
		
		JLabel lblNewLabel_23_4 = new JLabel("No. of Admins: ");
		lblNewLabel_23_4.setFont(new Font("Cochin", Font.PLAIN, 20));
		lblNewLabel_23_4.setBounds(6, 6, 155, 30);
		panel_15_2.add(lblNewLabel_23_4);
		
		JLabel lblNewLabel_24_3 = new JLabel("C1");
		lblNewLabel_24_3.setForeground(new Color(128, 0, 128));
		lblNewLabel_24_3.setFont(new Font("Songti SC", Font.ITALIC, 26));
		lblNewLabel_24_3.setBounds(154, 0, 65, 41);
		panel_15_2.add(lblNewLabel_24_3);
		
		JPanel panel_15_3 = new JPanel();
		panel_15_3.setLayout(null);
		panel_15_3.setBackground(new Color(176, 196, 222));
		panel_15_3.setBounds(77, 415, 219, 44);
		panel_3.add(panel_15_3);
		
		JLabel lblNewLabel_23_3 = new JLabel("No. of Admins: ");
		lblNewLabel_23_3.setBounds(-126, -16, 139, 38);
		panel_15_3.add(lblNewLabel_23_3);
		lblNewLabel_23_3.setFont(new Font("Cochin", Font.PLAIN, 20));
		
		JLabel lblNewLabel_23_2 = new JLabel("No. of Teachers: ");
		lblNewLabel_23_2.setFont(new Font("Cochin", Font.PLAIN, 20));
		lblNewLabel_23_2.setBounds(6, 6, 155, 30);
		panel_15_3.add(lblNewLabel_23_2);
		
		JLabel lblNewLabel_24_2 = new JLabel("C1");
		lblNewLabel_24_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_24_2.setFont(new Font("Songti SC", Font.ITALIC, 26));
		lblNewLabel_24_2.setBounds(155, 6, 65, 32);
		panel_15_3.add(lblNewLabel_24_2);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(192, 192, 192));
		panel_16.setBounds(400, 216, 286, 240);
		panel_3.add(panel_16);
		panel_16.setLayout(null);
		
		JLabel lblNewLabel_25 = new JLabel("Notifications and Updates :");
		lblNewLabel_25.setFont(new Font("Cochin", Font.PLAIN, 23));
		lblNewLabel_25.setBounds(6, 6, 274, 28);
		panel_16.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("---------------------------------");
		lblNewLabel_26.setForeground(new Color(128, 128, 128));
		lblNewLabel_26.setBackground(new Color(248, 248, 255));
		lblNewLabel_26.setBounds(6, 29, 274, 16);
		panel_16.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("-> More Courses are being added this\n");
		lblNewLabel_27.setBounds(16, 57, 254, 16);
		panel_16.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("March.");
		lblNewLabel_28.setBounds(38, 74, 61, 16);
		panel_16.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("-> Modules for level 5 and level 6 are ");
		lblNewLabel_29.setBounds(16, 102, 257, 16);
		panel_16.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("being updated according to Uni.");
		lblNewLabel_30.setBounds(38, 118, 231, 16);
		panel_16.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("-> Four new Instructors are being added");
		lblNewLabel_31.setBounds(16, 146, 264, 16);
		panel_16.add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("and 7 instructors have left.\n");
		lblNewLabel_32.setBounds(38, 163, 248, 16);
		panel_16.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("-> The college is organizing a event in\n\n");
		lblNewLabel_33.setBounds(17, 191, 269, 16);
		panel_16.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("the 12th of June in Hyatt Regency.");
		lblNewLabel_34.setBounds(38, 208, 242, 16);
		panel_16.add(lblNewLabel_34);
        
		try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
            Statement statement = connection.createStatement();
            
            // Fetch counts from database
            ResultSet resultSetCourses = statement.executeQuery("SELECT COUNT(*) AS course_count FROM courses");
            if (resultSetCourses.next()) {
                lblNewLabel_24.setText(resultSetCourses.getString("course_count"));
            }
            resultSetCourses.close(); // Close the ResultSet
            
            ResultSet resultSetStudents = statement.executeQuery("SELECT COUNT(*) AS student_count FROM Student");
            if (resultSetStudents.next()) {
                lblNewLabel_24_1.setText(resultSetStudents.getString("student_count"));
            }
            resultSetStudents.close(); // Close the ResultSet
            
            ResultSet resultSetTeachers = statement.executeQuery("SELECT COUNT(*) AS teacher_count FROM Teacher");
            if (resultSetTeachers.next()) {
                lblNewLabel_24_2.setText(resultSetTeachers.getString("teacher_count"));
            }
            resultSetTeachers.close(); // Close the ResultSet
            
            ResultSet resultSetAdmins = statement.executeQuery("SELECT COUNT(*) AS admin_count FROM Admin");
            if (resultSetAdmins.next()) {
                lblNewLabel_24_3.setText(resultSetAdmins.getString("admin_count"));
            }
            resultSetAdmins.close(); // Close the ResultSet
            
            // Close resources
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL Exception
        }
		
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
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 36));
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
		
		JButton addC = new JButton("Add\nCourse\n");
		addC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse ac = new AddCourse();
				ac.setVisible(true);
			}
		});
		addC.setBounds(345, 119, 98, 35);
		addC.setBackground(new Color(210, 105, 30));
		panel_4.add(addC);
		
		JButton editC = new JButton("Edit Course");
		editC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCourse ec=new EditCourse();
				ec.setVisible(true);
			}
		});
		editC.setBounds(448, 119, 98, 35);
		panel_4.add(editC);
		
		JButton delC = new JButton("Del Course");
		delC.setBounds(547, 120, 92, 33);
		delC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelCourse del = new DelCourse();
				del.setVisible(true);
				}
		});
		delC.setBackground(new Color(255, 0, 0));
		panel_4.add(delC);
		
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
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.ITALIC, 40));
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
		
		JButton addS = new JButton("Add Student");
		addS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent as= new AddStudent();
				as.setVisible(true);
				}
		});
		addS.setBackground(new Color(210, 105, 30));
		addS.setBounds(115, 142, 109, 54);
		panel_5.add(addS);
		
		JButton editS = new JButton("Edit Student");
		editS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditStudent es = new EditStudent();
				es.setVisible(true);
			}
		});
		editS.setBackground(new Color(210, 105, 30));
		editS.setBounds(293, 142, 109, 54);
		panel_5.add(editS);
		
		JButton delS = new JButton("Remove Student");
		delS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelStudent ds= new DelStudent();
				ds.setVisible(true);
				
			}
		});
		delS.setBackground(new Color(210, 105, 30));
		delS.setBounds(469, 142, 130, 54);
		panel_5.add(delS);
		
		studentdisplay = new StudentDisplay();
		studentdisplay.setBounds(16, 201, 670, 331);
		studentdisplay.setForeground(new Color(0, 0, 0));
        panel_5.add(studentdisplay);
        studentdisplay.setLayout(null);
        
        JButton btnNewButton_10 = new JButton("Refresh Page");
        btnNewButton_10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		studentdisplay = new StudentDisplay();
        		studentdisplay.setBounds(16, 201, 670, 331);
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
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.ITALIC, 40));
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
        
        JButton addT = new JButton("Add Teacher");
        addT.setBounds(98, 161, 109, 54);
        addT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddTeacher at = new AddTeacher();
        		at.setVisible(true);
        	}
        });
        addT.setBackground(new Color(210, 105, 30));
        panel_1.add(addT);
        
        JButton editT = new JButton("Edit Teacher");
        editT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EditTeacher edit = new EditTeacher();
        		edit.setVisible(true);
        	}
        });
        editT.setBounds(276, 161, 109, 54);
        editT.setBackground(new Color(210, 105, 30));
        panel_1.add(editT);
        
        JButton delT = new JButton("Remove Teacher");
        delT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DelTeacher del = new DelTeacher();
        		del.setVisible(true);
        	}
        });
        delT.setBounds(470, 161, 130, 54);
        delT.setBackground(new Color(210, 105, 30));
        panel_1.add(delT);
        
        teacherdisplay = new TeacherDisplay();
        teacherdisplay.setBounds(16, 213, 670, 301);
        teacherdisplay.setForeground(new Color(0, 0, 0));
        panel_1.add(teacherdisplay);
        teacherdisplay.setLayout(null);
        
        JButton btnNewButton_9 = new JButton("Refresh Page");
        btnNewButton_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		teacherdisplay = new TeacherDisplay();
        		teacherdisplay.setBounds(16, 213, 670, 301);
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
        lblNewLabel_6_3.setFont(new Font("Times New Roman", Font.ITALIC, 40));
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
        
        JButton addA = new JButton("Add Admin");
        addA.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddAdmin aa = new AddAdmin();
        		aa.setVisible(true);
        	}
        });
        addA.setBackground(new Color(210, 105, 30));
        addA.setBounds(84, 150, 109, 54);
        panel_10.add(addA);
        
        JButton editA = new JButton("Edit Admin");
        editA.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EditAdmin ea = new EditAdmin();
        		ea.setVisible(true);
        	}
        });
        editA.setBackground(new Color(210, 105, 30));
        editA.setBounds(280, 150, 109, 54);
        panel_10.add(editA);
        
        JButton delA = new JButton("Remove Admin");
        delA.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DelAdmin da = new DelAdmin();
        		da.setVisible(true);
        	}
        });
        delA.setBackground(new Color(210, 105, 30));
        delA.setBounds(465, 150, 121, 54);
        panel_10.add(delA);
        
        ad = new AdminDisplay();
        ad.setBounds(16, 204, 670, 311);
        ad.setForeground(new Color(0, 0, 0));
        panel_10.add(ad);
        ad.setLayout(null);
        
        JButton btnNewButton_9_1 = new JButton("Refresh Page");
        btnNewButton_9_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 ad = new AdminDisplay();
        	        ad.setBounds(16, 204, 670, 311);
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
        
        JLabel lblNewLabel_7 = new JLabel("Settings:");
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.ITALIC, 35));
        lblNewLabel_7.setBounds(25, 9, 446, 45);
        panel_12.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Email");
        lblNewLabel_8.setForeground(new Color(0, 128, 128));
        lblNewLabel_8.setFont(new Font("Cochin", Font.PLAIN, 18));
        lblNewLabel_8.setBounds(560, 26, 143, 23);
        panel_12.add(lblNewLabel_8);
        
        lblNewLabel_8.setText("User: "+Userrole);
        
        JLabel lblNewLabel_10 = new JLabel("Username:");
        lblNewLabel_10.setFont(new Font("Cochin", Font.PLAIN, 19));
        lblNewLabel_10.setBounds(25, 132, 91, 16);
        panel_12.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("------------------------------------------------------------------------------------");
        lblNewLabel_11.setForeground(new Color(169, 169, 169));
        lblNewLabel_11.setBounds(23, 44, 680, 16);
        panel_12.add(lblNewLabel_11);
        
        JLabel lblNewLabel_12 = new JLabel("General Information");
        lblNewLabel_12.setFont(new Font("Cochin", Font.PLAIN, 18));
        lblNewLabel_12.setBounds(25, 66, 181, 16);
        panel_12.add(lblNewLabel_12);
        
        JLabel lblNewLabel_13 = new JLabel("--------------------");
        lblNewLabel_13.setForeground(new Color(169, 169, 169));
        lblNewLabel_13.setBounds(25, 83, 200, 16);
        panel_12.add(lblNewLabel_13);
        
        txtNischalNeupane = new JTextField();
        txtNischalNeupane.setText("Nischal Neupane");
        txtNischalNeupane.setBounds(120, 122, 181, 38);
        panel_12.add(txtNischalNeupane);
        txtNischalNeupane.setColumns(10);
        
        txtNischalNeupane.setText(loggedInFullName);
        
        JLabel lblNewLabel_14 = new JLabel("Phone:");
        lblNewLabel_14.setFont(new Font("Cochin", Font.PLAIN, 19));
        lblNewLabel_14.setBounds(393, 132, 61, 16);
        panel_12.add(lblNewLabel_14);
        
        textField_5 = new JTextField();
        textField_5.setBounds(466, 122, 181, 38);
        panel_12.add(textField_5);
        textField_5.setColumns(10);
        
        textField_5.setText(loggedPhone);
        
        JLabel lblNewLabel_15 = new JLabel("Email:");
        lblNewLabel_15.setFont(new Font("Cochin", Font.PLAIN, 19));
        lblNewLabel_15.setBounds(25, 197, 61, 16);
        panel_12.add(lblNewLabel_15);
        
        txtNischalgmailcom = new JTextField();
        txtNischalgmailcom.setText("nischal@gmail.com");
        txtNischalgmailcom.setBounds(120, 187, 181, 38);
        panel_12.add(txtNischalgmailcom);
        txtNischalgmailcom.setColumns(10);
        
        txtNischalgmailcom.setText(loggedEmail);
        
        JLabel lblNewLabel_12_1 = new JLabel("Security and Login:");
        lblNewLabel_12_1.setFont(new Font("Cochin", Font.PLAIN, 18));
        lblNewLabel_12_1.setBounds(25, 281, 181, 22);
        panel_12.add(lblNewLabel_12_1);
        
        JLabel lblNewLabel_13_1 = new JLabel("-------------------");
        lblNewLabel_13_1.setForeground(new Color(169, 169, 169));
        lblNewLabel_13_1.setBounds(25, 303, 200, 16);
        panel_12.add(lblNewLabel_13_1);
        
        JLabel lblNewLabel_16 = new JLabel("Old Password:");
        lblNewLabel_16.setFont(new Font("Cochin", Font.PLAIN, 19));
        lblNewLabel_16.setBounds(25, 356, 117, 16);
        panel_12.add(lblNewLabel_16);
        
        oldPassword = new JPasswordField();
        oldPassword.setToolTipText("");
        oldPassword.setBounds(143, 346, 158, 38);
        panel_12.add(oldPassword);
        
        JLabel lblNewLabel_17 = new JLabel("Change Password:");
        lblNewLabel_17.setFont(new Font("Cochin", Font.PLAIN, 19));
        lblNewLabel_17.setBounds(382, 348, 151, 32);
        panel_12.add(lblNewLabel_17);
        
        newPassword = new JPasswordField();
        newPassword.setBounds(530, 346, 156, 38);
        panel_12.add(newPassword);
        
        JLabel lblNewLabel_12_1_1 = new JLabel("Help & Services");
        lblNewLabel_12_1_1.setFont(new Font("Cochin", Font.PLAIN, 18));
        lblNewLabel_12_1_1.setBounds(27, 410, 134, 22);
        panel_12.add(lblNewLabel_12_1_1);
        
        JLabel lblNewLabel_13_1_1 = new JLabel("----------------");
        lblNewLabel_13_1_1.setForeground(new Color(169, 169, 169));
        lblNewLabel_13_1_1.setBounds(25, 433, 200, 16);
        panel_12.add(lblNewLabel_13_1_1);
        
        JLabel lblNewLabel_18 = new JLabel("Guidelines for Students ?");
        lblNewLabel_18.setForeground(new Color(100, 149, 237));
        lblNewLabel_18.setBounds(25, 461, 168, 16);
        panel_12.add(lblNewLabel_18);
        
        JLabel lblNewLabel_18_1 = new JLabel("Report Technical Issues ?");
        lblNewLabel_18_1.setForeground(new Color(100, 149, 237));
        lblNewLabel_18_1.setBounds(25, 489, 168, 16);
        panel_12.add(lblNewLabel_18_1);
        
        JLabel lblNewLabel_18_2 = new JLabel("Email: heraldcollege@edu.np");
        lblNewLabel_18_2.setForeground(new Color(100, 149, 237));
        lblNewLabel_18_2.setBounds(393, 461, 191, 16);
        panel_12.add(lblNewLabel_18_2);
        
        JLabel lblNewLabel_18_3 = new JLabel("Tel No. : 040 050 060");
        lblNewLabel_18_3.setForeground(new Color(100, 149, 237));
        lblNewLabel_18_3.setBounds(395, 489, 168, 16);
        panel_12.add(lblNewLabel_18_3);
        
        JButton btnNewButton_11 = new JButton("Edit Profile");
        btnNewButton_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice2 = JOptionPane.showConfirmDialog(null, "Are you sure about making changes to your Profile?", "Update Profile Confirmation", JOptionPane.YES_NO_OPTION);

                if (choice2 == JOptionPane.YES_OPTION) {
                    String NewName = txtNischalNeupane.getText();
                    String NewPhone = textField_5.getText();
                    String NewEmail = txtNischalgmailcom.getText();

                    String regexLN = "([A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+)";
                    Pattern Lname = Pattern.compile(regexLN);
                    Matcher LN = Lname.matcher(NewName);
                    boolean Nname = LN.matches();

                    String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                    Pattern verifyEmail = Pattern.compile(regexEmail);
                    Matcher eM = verifyEmail.matcher(NewEmail);
                    boolean CEmail = eM.matches();

                    if (Nname == true && CEmail == true) {

                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");

                            String query = "UPDATE " + Userrole + " SET Fullname=?, Email=?, Phone=? WHERE " + Userrole + "ID=" + loggedID;

                            PreparedStatement stmt = connection.prepareStatement(query);

                            stmt.setString(1, NewName);
                            stmt.setString(2, NewEmail);
                            stmt.setString(3, NewPhone);

                            int edited = stmt.executeUpdate();

                            if (edited > 0) {
                                JOptionPane.showMessageDialog(null, "Profile Updated!!!\nNow you will be led to the login page.");
                                dispose();
                                Assessment lg = new Assessment();
                                lg.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed.");
                            }
                            stmt.close();
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }else {
                    	JOptionPane.showMessageDialog(null, "Invalid Input.");
                    }
                }
            }
        });

        
        
        btnNewButton_11.setBounds(290, 248, 117, 43);
        panel_12.add(btnNewButton_11);
        
        JButton btnNewButton_12 = new JButton("Change");
        btnNewButton_12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int choice3 = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your password?", "Password Change Confirmation", JOptionPane.YES_NO_OPTION);

                if (choice3 == JOptionPane.YES_OPTION) {
        		
        		String Pass = oldPassword.getText();
        		boolean checkPass=Pass.equals(loggedPassword);
        		
        		if(checkPass==true) {
        			String Newpass = newPassword.getText();
        			
        			try {
    		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");

    		            String query = "UPDATE "+ Userrole + " SET Password=? WHERE "+ Userrole+"ID="+loggedID;
    		            
    		            PreparedStatement stmt = connection.prepareStatement(query);

    		            stmt.setString(1, Newpass);
    		            

    		            int changed = stmt.executeUpdate();

    		            if (changed > 0) {
    		                JOptionPane.showMessageDialog(null, "Password Changed!!!\nNow you will be led to the login page.");
    		                Assessment login = new Assessment();
    		                dispose();
    		                login.setVisible(true);
    		                
    		            } else {
    		                JOptionPane.showMessageDialog(null, "Failed !!!.");
    		            }
    		            stmt.close();
    		            connection.close();
    		        } catch (SQLException ex) {
    		            ex.printStackTrace();
    		        }
        			
        		}else {
        			JOptionPane.showMessageDialog(null, "Old Password is Incorrect !!!.");
        		}
        		
        	}
        	}
        });
        btnNewButton_12.setBounds(301, 392, 91, 47);
        panel_12.add(btnNewButton_12);	
        
        JPanel panel_17 = new JPanel();
        tabbedPane.addTab("Result", null, panel_17, null);
        panel_17.setLayout(null);
        
        JPanel panel_18 = new JPanel();
        panel_18.setBackground(new Color(255, 192, 203));
        panel_18.setBounds(6, 5, 680, 61);
        panel_17.add(panel_18);
        panel_18.setLayout(null);
        
        JLabel lblNewLabel_35 = new JLabel("Student's Result");
        lblNewLabel_35.setForeground(new Color(138, 43, 226));
        lblNewLabel_35.setFont(new Font("Times New Roman", Font.ITALIC, 36));
        lblNewLabel_35.setBounds(216, 6, 364, 49);
        panel_18.add(lblNewLabel_35);
        
        JButton editM = new JButton("Edit Marks");
        editM.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EditMarks em=new EditMarks();
        		em.setVisible(true);
        	}
        });
        editM.setBounds(309, 88, 127, 54);
        panel_17.add(editM);
        
        addM = new JButton("Add Marks");
        addM.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddMarks am = new AddMarks();
        		am.setVisible(true);
        	}
        });
        addM.setBounds(112, 88, 127, 54);
        panel_17.add(addM);
        
        rd = new ResultTable();
		rd.setBounds(6, 172, 676, 354);
		rd.setForeground(new Color(0, 0, 0));
        panel_17.add(rd);
        rd.setLayout(null);
        
        JButton btnNewButton_4_1_1 = new JButton("Refresh Page");
        btnNewButton_4_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rd = new ResultTable();
        		rd.setBounds(6, 172, 676, 223);
        		rd.setForeground(new Color(0, 0, 0));
                panel_17.add(rd);
                rd.setLayout(null);
        	}
        });
        btnNewButton_4_1_1.setBounds(516, 88, 133, 49);
        panel_17.add(btnNewButton_4_1_1);
        
        
        if(Userrole=="Student" || Userrole=="Teacher") {
        	addC.setVisible(false);
        	editC.setVisible(false);
        	delC.setVisible(false);
        	
        	addS.setVisible(false);
        	editS.setVisible(false);
        	delS.setVisible(false);
        	studentdisplay.setBounds(12, 170, 670, 350);
        	
        	
        	addT.setVisible(false);
        	editT.setVisible(false);
        	delT.setVisible(false);
        	teacherdisplay.setBounds(12, 170, 670, 350);
        	
        	
        	addA.setVisible(false);
        	editA.setVisible(false);
        	delA.setVisible(false);
        	ad.setBounds(12, 170, 670, 350);
        	
        	generate.setVisible(false);
    
        }
        
        if(Userrole=="Student") {
        	progress.setVisible(false);
        }
        
        if(Userrole!="Student") {
        	report.setVisible(false);
        }
       if(Userrole!="Teacher") { 
    	   editM.setVisible(false);
    	   addM.setVisible(false);       }
       
	}
}
