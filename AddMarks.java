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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddMarks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarks frame = new AddMarks();
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
	public AddMarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(6, 6, 571, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Marks");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel.setBounds(211, 6, 149, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(32, 83, 89, 24);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(121, 79, 139, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Level:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(297, 88, 51, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(347, 79, 139, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Module 1:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(32, 153, 77, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Module 2:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(213, 154, 77, 16);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Module 3:");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_2.setBounds(413, 154, 77, 16);
		contentPane.add(lblNewLabel_3_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(6, 181, 130, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(183, 182, 130, 35);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(380, 182, 130, 35);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(6, 293, 130, 35);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(183, 293, 130, 35);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(380, 293, 130, 35);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_4 = new JLabel("Marks 1:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(32, 265, 77, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Marks 2:");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(213, 266, 77, 16);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Marks 3:");
		lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_2.setBounds(409, 265, 77, 16);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5 = new JLabel("Percentage:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(122, 359, 89, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Result:");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5_1.setBounds(312, 359, 89, 24);
		contentPane.add(lblNewLabel_5_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(97, 389, 130, 35);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(274, 389, 130, 35);
		contentPane.add(textField_9);
		
		JButton btnNewButton = new JButton("Add Marks");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
		            
		            String query = "INSERT INTO Result (StudentId, module_1, mark_1, module_2, mark_2, module_3, mark_3,percentage,result) VALUES (?,?,?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement pstmt = con.prepareStatement(query);
		            
		            int studentId = Integer.parseInt(textField.getText());
		            String module1 = textField_2.getText();
		            int mark1 = Integer.parseInt(textField_5.getText());
		            String module2 = textField_3.getText();
		            int mark2 = Integer.parseInt(textField_6.getText());
		            String module3 = textField_4.getText();
		            int mark3 = Integer.parseInt(textField_7.getText());
		            float percentage=Float.parseFloat(textField_8.getText());
		            String result = textField_9.getText();

		            pstmt.setInt(1, studentId);
		            pstmt.setString(2, module1);
		            pstmt.setInt(3, mark1);
		            pstmt.setString(4, module2);
		            pstmt.setInt(5, mark2);
		            pstmt.setString(6, module3);
		            pstmt.setInt(7, mark3);
		            pstmt.setFloat(8, percentage);
		            pstmt.setString(9, result);

		            int added = pstmt.executeUpdate();
		            
		            if(added>1) {
		            JOptionPane.showMessageDialog(null,"Marks added successfully.");
		            
		            }else {
					JOptionPane.showMessageDialog(null,"Failed to Add.");
		            }
		            
		            pstmt.close();
		            con.close();
		            
		            
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setBounds(183, 446, 130, 41);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(447, 452, 130, 41);
		contentPane.add(btnCancel);
	}

}
