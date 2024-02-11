package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
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
	public AddCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(6, 6, 354, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Course Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setBounds(69, 29, 237, 16);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(6, 88, 354, 404);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Course ID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(29, 21, 129, 16);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(29, 49, 180, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Course Name:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(29, 89, 104, 16);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(230, 230, 250));
		textField_1.setBounds(28, 115, 181, 28);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Seats:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(29, 157, 61, 16);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(230, 230, 250));
		textField_2.setBounds(29, 185, 84, 28);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Level:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(29, 225, 61, 16);
		panel_1.add(lblNewLabel_4);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Undergraduate", "Graduate"}));
		comboBox.setBounds(29, 253, 153, 27);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Duration:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(220, 226, 104, 16);
		panel_1.add(lblNewLabel_5);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		comboBox_1.setBounds(230, 253, 61, 27);
		panel_1.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Add Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseId = textField.getText();
		        String courseName = textField_1.getText();
		        int seats = Integer.parseInt(textField_2.getText());
		        String level = comboBox.getSelectedItem().toString();
		        int duration = Integer.parseInt(comboBox_1.getSelectedItem().toString());

		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "")) {
		            String sql = "INSERT INTO Courses (Course_ID, Course_Name, Seats, Level, Duration) VALUES (?, ?, ?, ?, ?)";

		            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
		                stmt.setString(1, courseId);
		                stmt.setString(2, courseName);
		                stmt.setInt(3, seats);
		                stmt.setString(4, level);
		                stmt.setInt(5, duration);

		                int added = stmt.executeUpdate();

		                if (added > 0) {
		                	JOptionPane.showMessageDialog(null,"Course Added !!!");
		                	
		                } else {
		                	JOptionPane.showMessageDialog(null,"Failed !!!");
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setBounds(114, 286, 117, 48);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("GO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(145, 360, 67, 38);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Go to Courses -->");
		lblNewLabel_6.setBounds(16, 370, 129, 16);
		panel_1.add(lblNewLabel_6);
	}
}
