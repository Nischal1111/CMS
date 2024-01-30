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

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(6, 6, 145, 468);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(31, 117, 81, 40);
		btnNewButton.setBackground(new Color(224, 255, 255));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton_1.setBounds(31, 191, 81, 40);
		panel.add(btnNewButton_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(6, 6, 133, 71);
		panel_6.setBackground(new Color(240, 255, 255));
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CMS");
		lblNewLabel.setBounds(39, 24, 59, 41);
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setFont(new Font("Klee", Font.PLAIN, 27));
		panel_6.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Teachers");
		btnNewButton_2.setBounds(31, 263, 80, 45);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.setBounds(31, 335, 81, 40);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Assessment login = new Assessment();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(31, 397, 78, 43);
		panel.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(685, 6, 166, 468);
		contentPane.add(panel_2);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(163, 18, 510, 456);
		contentPane.add(tabbedPane);
		

		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Home", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Course", null, panel_4, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Teachers", null, panel_1, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Students", null, panel_5, null);
	}
}
