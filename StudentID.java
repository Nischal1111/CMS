package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentID extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentID frame = new StudentID();
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
	public StudentID() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(106, 90, 205));
		panel.setBounds(6, 6, 308, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Report:");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Cochin", Font.PLAIN, 26));
		lblNewLabel.setBounds(81, 6, 165, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID:");
		lblNewLabel_1.setFont(new Font("LiSong Pro", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(61, 75, 198, 40);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(71, 122, 164, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(31, 168, 103, 40);
		contentPane.add(btnNewButton);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int studentID = Integer.parseInt(textField.getText());
			        
			        ResultDisplay resultDisplay = new ResultDisplay();
			        
			        resultDisplay.displayStudentResult(studentID);
			        
			        resultDisplay.setVisible(true);
			        dispose();
			}
		});
		btnGo.setBounds(180, 168, 103, 40);
		contentPane.add(btnGo);
	}
}
