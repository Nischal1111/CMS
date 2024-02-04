package CMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import java.awt.Font;


public class Assessment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assessment frame = new Assessment();
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
	private String[] checkLogin(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/CMS";
        String dbUsername = "root";
        String dbPassword = "";

        for (String role : new String[]{"Student", "Admin", "Teacher"}) {
            try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + role + " WHERE email = ? AND password = ?")) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                    	return new String[]{resultSet.getString("fullname"), role,resultSet.getString("Email")};
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
	
	public Assessment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Noto Sans Oriya", Font.PLAIN, 20));
		lblNewLabel.setBounds(296, 186, 132, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(440, 176, 149, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Noto Sans Oriya", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(296, 235, 102, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredUsername = textField.getText();
                String enteredPassword = textField_1.getText();

                String[] loginResult = checkLogin(enteredUsername, enteredPassword);

                if (loginResult != null) {
                    String userFullName = loginResult[0];
                    String userRole = loginResult[1];
                    String userEmail= loginResult[2];

                    JOptionPane.showMessageDialog(null, "Logged in as " + userRole);

                    Dashboard dashboard = new Dashboard(userFullName, userRole,userEmail);
                    dashboard.setVisible(true);

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
			}
		});
		btnNewButton.setBounds(471, 275, 88, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Don't Have an account ? ");
		lblNewLabel_2.setBounds(256, 352, 155, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Sign Up");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration register = new Registration();
				register.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(457, 340, 102, 36);
		contentPane.add(btnNewButton_2);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(440, 224, 149, 39);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to the Login Page");
		lblNewLabel_3.setFont(new Font("Noto Sans Oriya", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(231, 84, 461, 54);
		contentPane.add(lblNewLabel_3);
	}
}
