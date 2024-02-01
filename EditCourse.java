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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditCourse extends JFrame {

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
					EditCourse frame = new EditCourse();
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
	public EditCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(6, 6, 411, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Course Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBounds(118, 16, 254, 42);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(16, 93, 389, 421);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(36, 138, 192, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Course Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(36, 100, 116, 16);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(230, 230, 250));
		textField_1.setBounds(36, 220, 192, 31);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Seats");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(36, 192, 61, 16);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Level");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(36, 263, 61, 16);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseId = textField_2.getText();
		        String courseName = textField.getText();
		        int seats = Integer.parseInt(textField_1.getText());
		        String level = comboBox.getSelectedItem().toString();
		        int duration = Integer.parseInt(comboBox_1.getSelectedItem().toString());

		        try {
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");

		            String query = "UPDATE courses SET Course_Name=?, Seats=?, Level=?, Duration=? WHERE Course_ID=?";
		            PreparedStatement stmt = connection.prepareStatement(query);

		            stmt.setString(1, courseName);
		            stmt.setInt(2, seats);
		            stmt.setString(3, level);
		            stmt.setInt(4, duration);
		            stmt.setString(5, courseId);

		            int edited = stmt.executeUpdate();

		            if (edited > 0) {
		                JOptionPane.showMessageDialog(null, "Course Updated!!!");
		            } else {
		                JOptionPane.showMessageDialog(null, "Course ID not found.");
		            }
		            stmt.close();
		            connection.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(146, 327, 93, 39);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Go to Courses -->");
		lblNewLabel_5.setBounds(36, 390, 134, 16);
		panel_1.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("GO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(164, 381, 75, 37);
		panel_1.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Undergraduate", "Graduate"}));
		comboBox.setBounds(36, 291, 148, 39);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Duration");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(241, 263, 93, 16);
		panel_1.add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		comboBox_1.setBounds(241, 291, 81, 39);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("Course ID");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(36, 29, 104, 16);
		panel_1.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(230, 230, 250));
		textField_2.setBounds(36, 57, 188, 31);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
	}
}
