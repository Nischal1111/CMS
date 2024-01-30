package CMS;

import java.awt.EventQueue;

import java.util.regex.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Registration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullname;
	private JTextField email;
	private JPasswordField pw;
	private JPasswordField ConfirmPw;
	private JComboBox combo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	private void registerUser(String email, String password, String role, String fullname) {
	    String url = "jdbc:mysql://localhost:3306/CMS";
	    String dbUsername = "root";
	    String dbPassword = "";

	    try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
	        // Check the role and insert into the corresponding table
	        switch (role) {
	            case "Student":
	                try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (email, password, fullname) VALUES (?, ?, ?)")) {
	                    preparedStatement.setString(1, email);
	                    preparedStatement.setString(2, password);
	                    preparedStatement.setString(3, fullname);
	                    preparedStatement.executeUpdate();
	                }
	                break;

	            case "Admin":
	                try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO admins (email, password, fullname) VALUES (?, ?, ?, ?)")) {
	                    preparedStatement.setString(1, email);
	                    preparedStatement.setString(2, password);
	                    preparedStatement.setString(3, fullname);
	                    preparedStatement.executeUpdate();
	                }
	                break;

	            case "Teacher":
	                try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teachers (email, password, fullname) VALUES (?, ?, ?)")) {
	                    preparedStatement.setString(1, email);
	                    preparedStatement.setString(2, password);
	                    preparedStatement.setString(3, fullname);
	                    preparedStatement.executeUpdate();
	                }
	                break;

	            default:
	                JOptionPane.showMessageDialog(null, "Invalid role.");
	                return;
	        }

	        JOptionPane.showMessageDialog(null, "Registered as " + role);

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error occurred during registration.");
	    }
	}


	
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 465);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Monaco", Font.ITALIC, 20));
		lblNewLabel.setBounds(250, 92, 228, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Full Name:");
		lblNewLabel_2.setBounds(218, 154, 72, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(218, 194, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setBounds(218, 230, 72, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm Password:");
		lblNewLabel_5.setBounds(218, 263, 118, 16);
		contentPane.add(lblNewLabel_5);
		
		fullname = new JTextField();
		fullname.setForeground(new Color(169, 169, 169));
		fullname.setBounds(363, 149, 130, 26);
		contentPane.add(fullname);
		fullname.setColumns(10);
		
		email = new JTextField();
		email.setForeground(new Color(169, 169, 169));
		email.setBounds(363, 187, 130, 26);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FullName = fullname.getText();
				String Email=email.getText();
				String pass = pw.getText();
				String Confirmpw = ConfirmPw.getText();
				String role = (String) combo.getSelectedItem();
				
                
                // Regex for LastName
                String regexLN = "([A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+)";
                Pattern Lname = Pattern.compile(regexLN);
                Matcher LN = Lname.matcher(FullName);
                boolean lname = LN.matches();
                
                
                String regexEmail =  "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                Pattern verifyEmail = Pattern.compile(regexEmail);
                Matcher eM = verifyEmail.matcher(Email);
                boolean checkEmail = eM.matches();
                
                // Regex for password
                String regexP = "[a-zA-Z0-9_+&*-]+";
                Pattern passN = Pattern.compile(regexP); 
                Matcher pN = passN.matcher(pass);
                boolean passNew = pN.matches();
                
				
                if (!FullName.equals("") && !Email.equals("") && !pass.equals("") && !Confirmpw.equals("")) {
                    if ( lname == true && passNew == true && Confirmpw.equals(pass)) {
                        registerUser(Email, pass, role,FullName);
                        Assessment login = new Assessment();
                        login.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input or password mismatch.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Inputs cannot be empty.");
                }
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(138, 43, 226));
		btnNewButton.setBounds(413, 322, 80, 38);
		contentPane.add(btnNewButton);
		
		pw = new JPasswordField();
		pw.setBounds(363, 225, 130, 26);
		contentPane.add(pw);
		
		ConfirmPw = new JPasswordField();
		ConfirmPw.setBounds(363, 258, 130, 26);
		contentPane.add(ConfirmPw);
		
		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"Student", "Admin", "Teacher"}));
		combo.setBounds(363, 293, 129, 27);
		contentPane.add(combo);
		
		JLabel lblNewLabel_6 = new JLabel("Register As:");
		lblNewLabel_6.setBounds(218, 297, 105, 16);
		contentPane.add(lblNewLabel_6);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assessment login = new Assessment();
				login.setVisible(true);
				dispose();
			}
		});
		login.setBounds(363, 366, 117, 29);
		contentPane.add(login);
		
		JLabel lblNewLabel_7 = new JLabel("Go to Login Page -->");
		lblNewLabel_7.setBounds(218, 371, 150, 16);
		contentPane.add(lblNewLabel_7);
	}
}
