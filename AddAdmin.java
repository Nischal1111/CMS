package CMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class AddAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher frame = new AddTeacher();
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
	public AddAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(6, 6, 354, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Admin Details");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setBounds(69, 29, 237, 16);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 196, 222));
		panel_1.setBounds(6, 88, 354, 490);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Admin ID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(29, 21, 129, 16);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 245, 238));
		textField.setBounds(29, 49, 220, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Name:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(29, 89, 129, 16);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 245, 238));
		textField_1.setBounds(28, 115, 221, 28);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(29, 157, 61, 16);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 245, 238));
		textField_2.setBounds(29, 185, 220, 28);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 245, 238));
		textField_3.setBounds(29, 321, 220, 28);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(29, 253, 220, 28);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Add Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teacherId = textField.getText();
		        String teacherName = textField_1.getText();
		        String Email = textField_2.getText();
		        String Phone = textField_3.getText();
		        String Password=passwordField.getText();

		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "")) {
		            String sql = "INSERT INTO Admin (AdminID, Fullname, Email, Phone,password) VALUES (?, ?, ?, ?,?)";

		            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
		                stmt.setString(1, teacherId);
		                stmt.setString(2, teacherName);
		                stmt.setString(3, Email);
		                stmt.setString(4, Phone);
		                stmt.setString(5, Password);
		                
		                int added = stmt.executeUpdate();

		                if (added > 0) {
		                    JOptionPane.showMessageDialog(null,"Admin Added !!!");
		                  
		                } else {
		                	JOptionPane.showMessageDialog(null,"Failed !!!");
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setBounds(113, 361, 117, 48);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("GO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(139, 424, 67, 38);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Go to Admin -->");
		lblNewLabel_6.setBounds(17, 434, 129, 16);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Phone:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(29, 293, 61, 16);
		panel_1.add(lblNewLabel_4);
		

		
		JLabel lblNewLabel_4_1 = new JLabel("Password:");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(29, 225, 117, 16);
		panel_1.add(lblNewLabel_4_1);
	
		
	}
}
